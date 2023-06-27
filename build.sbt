import sbt.Tests.{ Group, SubProcess }
import sbt._
import uk.gov.hmrc.DefaultBuildSettings._
import uk.gov.hmrc.ServiceManagerPlugin.Keys.itDependenciesList
import uk.gov.hmrc.versioning.SbtGitVersioning.autoImport.majorVersion

val appName = "hmrc-email-renderer"

val appDependencies: Seq[ModuleID] = AppDependencies()

lazy val playSettings: Seq[Setting[_]] = Seq.empty

def oneForkedJvmPerTest(tests: Seq[TestDefinition]): Seq[Group] =
  tests map { test =>
    Group(test.name, Seq(test), SubProcess(ForkOptions().withRunJVMOptions(Vector(s"-Dtest.name=${test.name}"))))
  }

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtAutoBuildPlugin, SbtGitVersioning, SbtDistributablesPlugin)
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(majorVersion := 2)
  .settings(playSettings: _*)
  .settings(scalaSettings: _*)
  .settings(defaultSettings(): _*)
  .settings(
    libraryDependencies ++= appDependencies,
    scalaVersion := "2.13.8",
    retrieveManaged := true,
    scalacOptions ++= Seq(
      // Silence unused warnings on Play `routes` and `twirl` files
      "-Wconf:cat=unused-imports&src=.*routes.*:s",
      "-Wconf:cat=unused-privates&src=.*routes.*:s",
      "-Wconf:src=twirl/.*:s"
    )
  )
  .configs(IntegrationTest)
  .settings(inConfig(IntegrationTest)(Defaults.itSettings): _*)
  .settings(
    IntegrationTest / fork := false,
    IntegrationTest / unmanagedSourceDirectories := (IntegrationTest / baseDirectory)(base => Seq(base / "it")).value,
    addTestReportOption(IntegrationTest, "int-test-reports"),
    IntegrationTest / testGrouping := oneForkedJvmPerTest((IntegrationTest / definedTests).value),
    IntegrationTest / parallelExecution := false,
    inConfig(IntegrationTest)(
      scalafmtCoreSettings ++
        Seq(
           compile / compileInputs := Def.taskDyn {
            val task = test in (resolvedScoped.value.scope in scalafmt.key)
            val previousInputs = (compile / compileInputs).value
            task.map(_ => previousInputs)
          }.value
        )
    )
  )
  .settings(resolvers += Resolver.jcenterRepo)
  .settings(routesGenerator := InjectedRoutesGenerator)
  .settings(ScoverageSettings())
