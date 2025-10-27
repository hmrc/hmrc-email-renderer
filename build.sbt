import uk.gov.hmrc.DefaultBuildSettings.*
import uk.gov.hmrc.versioning.SbtGitVersioning.autoImport.majorVersion

val appName = "hmrc-email-renderer"

ThisBuild / majorVersion := 3
ThisBuild / scalaVersion := "3.6.3"

val appDependencies: Seq[ModuleID] = AppDependencies()

lazy val playSettings: Seq[Setting[?]] = Seq.empty

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin)
  .disablePlugins(JUnitXmlReportPlugin) // Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(playSettings *)
  .settings(scalaSettings *)
  .settings(defaultSettings() *)
  .settings(
    libraryDependencies ++= appDependencies,
    retrieveManaged := true
  )
  .settings(routesGenerator := InjectedRoutesGenerator)
  .settings(
    scalacOptions := scalacOptions.value.diff(Seq("-Wunused:all")),
    scalacOptions += "-language:implicitConversions",
    scalacOptions ++= List(
      "-Wconf:msg=Flag.*repeatedly:s",
      "-Wconf:src=routes/.*:s",
      "-Wconf:src=templates/.*:s",
      "-Wconf:src=preview/.*:s"
    )
  )
  .settings(ScoverageSettings())

lazy val it = Project(id = "it", base = file("it"))
  .enablePlugins(PlayScala, ScalafmtPlugin)
  .dependsOn(microservice % "test->test") // the "test->test" allows reusing test code and test dependencies
  .settings(
    libraryDependencies ++= appDependencies ++ AppDependencies.it,
    scalacOptions ++= List("-Wconf:msg=Flag.*repeatedly:s")
  )

Test / scalacOptions ++= List("-Wconf:src=services/.*:s")

Test / test := (Test / test)
  .dependsOn(scalafmtCheckAll)
  .value

it / test := (it / Test / test)
  .dependsOn(scalafmtCheckAll, it / scalafmtCheckAll)
  .value
