import sbt._
import play.sbt.PlayImport._
import play.core.PlayVersion

object MicroServiceBuild extends Build with MicroService {

  val appName = "hmrc-email-renderer"

  override lazy val appDependencies: Seq[ModuleID] = AppDependencies()
}

private object AppDependencies {
  def apply() = Seq(
    ws,
    "uk.gov.hmrc"                 %% "microservice-bootstrap" % "10.3.0",
    "uk.gov.hmrc"                 %% "domain"                 % "5.3.0",
    "uk.gov.hmrc"                 %% "emailaddress"           % "3.2.0",
    "net.codingwell"              %% "scala-guice"            % "4.1.1",
    "com.beachape"           %% "enumeratum"               % "1.5.13",
    "org.jsoup"                   %  "jsoup"                  % "1.7.3"             % "test",
    "org.scalatestplus.play"      %% "scalatestplus-play"     % "2.0.1"             % "test, it",
    "uk.gov.hmrc"                 %% "hmrctest"               % "3.4.0-play-25"             % "test, it",
    "org.scalatest"               %% "scalatest"              % "2.2.6"             % "test, it",
    "org.scalactic"               %% "scalactic"              % "2.2.6"             ,
    "org.pegdown"                 %  "pegdown"                % "1.6.0"             % "test, it",
    "com.typesafe.play"           %% "play-test"              % PlayVersion.current % "test, it",
    "org.mockito"                 %  "mockito-core"           % "1.9.0"             % "test, it",
    "com.github.tomakehurst"      % "wiremock"                % "1.58"              % "test,it"
  )
}

