import sbt.*
import play.sbt.PlayImport.*

private object AppDependencies {
  private val bootstrapVersion = "9.13.0"

  def apply(): Seq[ModuleID] = Seq(
    ws,
    "uk.gov.hmrc"            %% "bootstrap-frontend-play-30"  % bootstrapVersion,
    "uk.gov.hmrc"            %% "domain-play-30"              % "10.0.0",
    "net.codingwell"         %% "scala-guice"                 % "6.0.0",
    "com.beachape"           %% "enumeratum"                  % "1.7.4",
    "org.jsoup"              %  "jsoup"                       % "1.13.1"         % Test,
    "uk.gov.hmrc"            %% "bootstrap-test-play-30"      % bootstrapVersion % Test,
    "org.scalatestplus.play" %% "scalatestplus-play"          % "7.0.1"          % Test,
    "org.mockito"            %  "mockito-core"                % "4.7.0"          % Test,
    "org.scalatestplus"      %% "mockito-4-11"                % "3.2.17.0"       % Test,
    "com.github.tomakehurst" %  "wiremock"                    % "2.27.2"         % Test,
    "com.vladsch.flexmark"   %  "flexmark-all"                % "0.35.10"        % Test
  )

  val it = Seq(
    "uk.gov.hmrc"            %% "bootstrap-test-play-30"      % bootstrapVersion % "it/test",
    "org.scalatestplus.play" %% "scalatestplus-play"          % "7.0.1"          % "it/test",
    "org.scalatestplus"      %% "mockito-4-11"                % "3.2.17.0"       % "it/test",
    "org.pegdown"            %  "pegdown"                     % "1.6.0"          % "it/test",
    "org.mockito"            %  "mockito-core"                % "4.7.0"          % "it/test",
    "com.github.tomakehurst" %  "wiremock"                    % "2.27.2"         % "it/test",
    "com.vladsch.flexmark"   %  "flexmark-all"                % "0.35.10"        % "it/test"
  )
}
