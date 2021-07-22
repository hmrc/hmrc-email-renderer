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
    "uk.gov.hmrc"            %% "bootstrap-play-26"  % "4.0.0",
    "uk.gov.hmrc"            %% "auth-client"        % "5.6.0-play-26",
    "uk.gov.hmrc"            %% "domain"             % "5.9.0-play-26",
    "uk.gov.hmrc"            %% "emailaddress"       % "3.5.0",
    "net.codingwell"         %% "scala-guice"        % "4.2.6",
    "com.beachape"           %% "enumeratum"         % "1.6.1",
    "org.jsoup"              % "jsoup"               % "1.13.1" % "test",
    "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.3" % "test, it",
    "uk.gov.hmrc"            %% "hmrctest"           % "3.9.0-play-26" % "test, it",
    "org.pegdown"            % "pegdown"             % "1.6.0" % "test, it",
    "org.mockito"            % "mockito-core"        % "3.6.0" % "test, it",
    "com.github.tomakehurst" % "wiremock"            % "2.27.2" % "test,it"
  )
}
