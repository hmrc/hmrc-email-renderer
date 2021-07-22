import com.lucidchart.sbt.scalafmt.ScalafmtCorePlugin.autoImport._
import play.routes.compiler.InjectedRoutesGenerator
import play.sbt.routes.RoutesKeys.routesGenerator
import sbt.Keys._
import sbt.Tests.{ Group, SubProcess }
import sbt._
import uk.gov.hmrc.ServiceManagerPlugin.Keys.itDependenciesList
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin._

trait MicroService {

  import TestPhases.oneForkedJvmPerTest
  import uk.gov.hmrc.{ SbtAutoBuildPlugin, _ }
  import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin
  import uk.gov.hmrc.versioning.SbtGitVersioning

  val appName: String

  lazy val appDependencies: Seq[ModuleID] = ???
  lazy val plugins: Seq[Plugins] = Seq.empty
  lazy val playSettings: Seq[Setting[_]] = Seq.empty

  import DefaultBuildSettings._
  import uk.gov.hmrc.versioning.SbtGitVersioning.autoImport.majorVersion

  lazy val externalServices = List(
    ExternalService("PREFERENCES")
  )

  lazy val microservice = Project(appName, file("."))
    .enablePlugins(play.sbt.PlayScala, SbtAutoBuildPlugin, SbtGitVersioning, SbtDistributablesPlugin, SbtArtifactory)
    .settings(majorVersion := 2)
    .settings(playSettings: _*)
    .settings(scalaSettings: _*)
    .settings(publishingSettings: _*)
    .settings(defaultSettings(): _*)
    .settings(
      libraryDependencies ++= appDependencies,
      scalaVersion := "2.12.12",
      retrieveManaged := true,
      evictionWarningOptions in update := EvictionWarningOptions.default.withWarnScalaVersionEviction(false)
    )
    .configs(IntegrationTest)
    .settings(inConfig(IntegrationTest)(Defaults.itSettings): _*)
    .settings(itDependenciesList := externalServices)
    .settings(
      Keys.fork in IntegrationTest := false,
      unmanagedSourceDirectories in IntegrationTest <<= (baseDirectory in IntegrationTest)(base => Seq(base / "it")),
      addTestReportOption(IntegrationTest, "int-test-reports"),
      testGrouping in IntegrationTest := oneForkedJvmPerTest((definedTests in IntegrationTest).value),
      parallelExecution in IntegrationTest := false,
      inConfig(IntegrationTest)(
        scalafmtCoreSettings ++
          Seq(
            compileInputs in compile := Def.taskDyn {
              val task = test in (resolvedScoped.value.scope in scalafmt.key)
              val previousInputs = (compileInputs in compile).value
              task.map(_ => previousInputs)
            }.value
          )
      )
    )
    .settings(resolvers += Resolver.jcenterRepo)
    .settings(routesGenerator := InjectedRoutesGenerator)
}

private object TestPhases {

  def oneForkedJvmPerTest(tests: Seq[TestDefinition]) =
    tests map { test =>
      new Group(test.name, Seq(test), SubProcess(ForkOptions(runJVMOptions = Seq("-Dtest.name=" + test.name))))
    }
}
