import sbt.Tests.{ Group, SubProcess }
import sbt._
import uk.gov.hmrc.DefaultBuildSettings._
import uk.gov.hmrc.ExternalService
import uk.gov.hmrc.ServiceManagerPlugin.Keys.itDependenciesList
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin.publishingSettings
import uk.gov.hmrc.versioning.SbtGitVersioning.autoImport.majorVersion

val appName = "hmrc-email-renderer"

val appDependencies: Seq[ModuleID] = AppDependencies()

lazy val playSettings: Seq[Setting[_]] = Seq.empty

lazy val externalServices = List(
  ExternalService("PREFERENCES")
)

def oneForkedJvmPerTest(tests: Seq[TestDefinition]): Seq[Group] =
  tests map { test =>
    Group(test.name, Seq(test), SubProcess(ForkOptions().withRunJVMOptions(Vector(s"-Dtest.name=${test.name}"))))
  }

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtAutoBuildPlugin, SbtGitVersioning, SbtDistributablesPlugin)
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
    unmanagedSourceDirectories in IntegrationTest := (baseDirectory in IntegrationTest)(base => Seq(base / "it")).value,
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
  .settings(ScoverageSettings())
