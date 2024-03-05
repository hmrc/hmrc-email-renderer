import uk.gov.hmrc.DefaultBuildSettings._
import uk.gov.hmrc.versioning.SbtGitVersioning.autoImport.majorVersion

val appName = "hmrc-email-renderer"

ThisBuild / majorVersion := 2
ThisBuild / scalaVersion := "2.13.12"

val appDependencies: Seq[ModuleID] = AppDependencies()

lazy val playSettings: Seq[Setting[_]] = Seq.empty

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtAutoBuildPlugin, SbtGitVersioning, SbtDistributablesPlugin)
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(playSettings: _*)
  .settings(scalaSettings: _*)
  .settings(defaultSettings(): _*)
  .settings(
    libraryDependencies ++= appDependencies,
    retrieveManaged := true,
    scalacOptions ++= Seq(
      // Silence unused warnings on Play `routes` and `twirl` files
      "-Wconf:cat=unused-imports&src=.*routes.*:s",
      "-Wconf:cat=unused-privates&src=.*routes.*:s",
      "-Wconf:src=twirl/.*:s"
    )
  )
  .settings(resolvers += Resolver.jcenterRepo)
  .settings(routesGenerator := InjectedRoutesGenerator)
  .settings(ScoverageSettings())

lazy val it = Project(id = "it", base = file("it"))
  .enablePlugins(PlayScala, ScalafmtPlugin)
  .dependsOn(microservice % "test->test") // the "test->test" allows reusing test code and test dependencies
  .settings(libraryDependencies ++= appDependencies ++ AppDependencies.it)

addCommandAlias("fmt", "scalafmt ; test:scalafmt ; it/test:scalafmt")