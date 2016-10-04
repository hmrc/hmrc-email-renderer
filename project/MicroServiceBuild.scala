import sbt._
import play.PlayImport._
import play.core.PlayVersion

object MicroServiceBuild extends Build with MicroService {

  val appName = "hmrc-email-renderer"

  override lazy val appDependencies: Seq[ModuleID] = AppDependencies()
}

private object AppDependencies {
  def apply() = Seq(
    ws,
    "uk.gov.hmrc"       %% "microservice-bootstrap" % "4.4.0",
    "uk.gov.hmrc"       %% "play-authorisation"     % "3.3.0",
    "uk.gov.hmrc"       %% "play-health"            % "1.1.0",
    "uk.gov.hmrc"       %% "play-url-binders"       % "1.1.0",
    "uk.gov.hmrc"       %% "play-config"            % "2.1.0",
    "uk.gov.hmrc"       %% "play-json-logger"       % "2.1.1",
    "uk.gov.hmrc"       %% "domain"                 % "3.7.0",
    "uk.gov.hmrc"       %% "emailaddress"           % "1.1.0",
    "uk.gov.hmrc"       %% "hmrctest"               % "1.8.0"             % "test, it",
    "uk.gov.hmrc"       %% "http-verbs-test"        % "0.1.0"             % "test, it",
    "org.scalatest"     %% "scalatest"              % "2.2.6"             % "test, it",
    "org.pegdown"       %  "pegdown"                % "1.6.0"             % "test, it",
    "com.typesafe.play" %% "play-test"              % PlayVersion.current % "test, it"
  )
}

