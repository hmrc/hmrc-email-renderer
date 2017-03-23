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
    "uk.gov.hmrc"                 %% "microservice-bootstrap" % "5.14.0",
    "uk.gov.hmrc"                 %% "play-authorisation"     % "4.3.0",
    "uk.gov.hmrc"                 %% "play-health"            % "2.1.0",
    "uk.gov.hmrc"                 %% "play-url-binders"       % "2.1.0",
    "uk.gov.hmrc"                 %% "play-config"            % "4.3.0",
    "uk.gov.hmrc"                 %% "logback-json-logger"    % "3.1.0",
    "uk.gov.hmrc"                 %% "domain"                 % "4.1.0",
    "uk.gov.hmrc"                 %% "emailaddress"           % "2.1.0",
    "org.jsoup"                   %  "jsoup"                  % "1.7.3"             % "test",
    "org.scalatestplus.play"      %% "scalatestplus-play"     % "1.5.1"             % "test, it",
    "uk.gov.hmrc"                 %% "hmrctest"               % "2.3.0"             % "test, it",
    "uk.gov.hmrc"                 %% "http-verbs-test"        % "1.1.0"             % "test, it",
    "org.scalatest"               %% "scalatest"              % "2.2.6"             % "test, it",
    "org.pegdown"                 %  "pegdown"                % "1.6.0"             % "test, it",
    "com.typesafe.play"           %% "play-test"              % PlayVersion.current % "test, it",
    "org.mockito"                 %  "mockito-core"           % "1.9.0"             % "test, it"
  )
}

