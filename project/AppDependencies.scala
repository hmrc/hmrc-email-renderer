import sbt._
import play.sbt.PlayImport._

private object AppDependencies {
  def apply() = Seq(
    ws,
    "uk.gov.hmrc"            %% "bootstrap-frontend-play-28" % "5.17.0",
    "uk.gov.hmrc"            %% "domain"                     % "6.2.0-play-28",
    "uk.gov.hmrc"            %% "emailaddress"               % "3.5.0",
    "net.codingwell"         %% "scala-guice"                % "4.2.6",
    "com.beachape"           %% "enumeratum"                 % "1.6.1",
    "org.jsoup"              % "jsoup"                       % "1.13.1" % "test",
    "org.scalatestplus.play" %% "scalatestplus-play"         % "3.1.3" % "test, it",
    "uk.gov.hmrc"            %% "service-integration-test"   % "1.2.0-play-28" % "test, it",
    "org.pegdown"            % "pegdown"                     % "1.6.0" % "test, it",
    "org.mockito"            % "mockito-core"                % "3.6.0" % "test, it",
    "com.github.tomakehurst" % "wiremock"                    % "2.27.2" % "test,it",
    "org.mockito"            %% "mockito-scala"              % "1.16.46" % "test,it",
    "com.vladsch.flexmark"   % "flexmark-all"                % "0.35.10" % "test,it"
  )
}
