import sbt._
import play.sbt.PlayImport._

private object AppDependencies {
  def apply(): Seq[ModuleID] = Seq(
    ws,
    "uk.gov.hmrc"            %% "bootstrap-frontend-play-28"  % "7.19.0",
    "uk.gov.hmrc"            %% "domain"                      % "8.3.0-play-28",
    "net.codingwell"         %% "scala-guice"                 % "6.0.0",
    "com.beachape"           %% "enumeratum"                  % "1.6.1",
    "org.jsoup"              %  "jsoup"                       % "1.13.1"        % "test",
    "org.scalatestplus.play" %% "scalatestplus-play"          % "5.1.0"         % "test, it",
    "uk.gov.hmrc"            %% "service-integration-test"    % "1.3.0-play-28" % "test, it",
    "org.pegdown"            %  "pegdown"                     % "1.6.0"         % "test, it",
    "org.mockito"            %  "mockito-core"                % "4.7.0"         % "test, it",
    "com.github.tomakehurst" %  "wiremock"                    % "2.27.2"        % "test, it",
    "org.mockito"            %% "mockito-scala"               % "1.17.12"       % "test, it",
    "com.vladsch.flexmark"   %  "flexmark-all"                % "0.35.10"       % "test, it"
  )
}
