import uk.gov.hmrc.DefaultBuildSettings._
import uk.gov.hmrc.versioning.SbtGitVersioning.autoImport.majorVersion

val appName = "hmrc-email-renderer"

ThisBuild / majorVersion := 3
ThisBuild / scalaVersion := "3.4.2"

val appDependencies: Seq[ModuleID] = AppDependencies()

lazy val playSettings: Seq[Setting[_]] = Seq.empty

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin)
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(playSettings: _*)
  .settings(scalaSettings: _*)
  .settings(defaultSettings(): _*)
  .settings(
    libraryDependencies ++= appDependencies,
    retrieveManaged := true
  )
  .settings(resolvers += Resolver.jcenterRepo)
  .settings(routesGenerator := InjectedRoutesGenerator)
  .settings(ScoverageSettings())

lazy val it = Project(id = "it", base = file("it"))
  .enablePlugins(PlayScala, ScalafmtPlugin)
  .dependsOn(microservice % "test->test") // the "test->test" allows reusing test code and test dependencies
  .settings(libraryDependencies ++= appDependencies ++ AppDependencies.it)

Test / test := (Test / test)
  .dependsOn(scalafmtCheckAll)
  .value

it / test := (it / Test / test)
  .dependsOn(scalafmtCheckAll, it/scalafmtCheckAll)
  .value
