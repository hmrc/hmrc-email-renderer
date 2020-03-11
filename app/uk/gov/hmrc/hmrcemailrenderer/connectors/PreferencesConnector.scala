/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.hmrcemailrenderer.connectors

import com.typesafe.config.Config
import play.api.{Configuration, Play}
import play.api.Mode.Mode
import play.api.libs.json.Json
import uk.gov.hmrc.emailaddress.EmailAddress
import uk.gov.hmrc.hmrcemailrenderer.WSHttp
import uk.gov.hmrc.hmrcemailrenderer.model.Language
import uk.gov.hmrc.http.{HeaderCarrier, HttpException, HttpGet, HttpPost, HttpReads, HttpResponse}
import uk.gov.hmrc.play.config.ServicesConfig
import uk.gov.hmrc.play.http.logging.MdcLoggingExecutionContext._

import scala.concurrent.{Await, Future}

trait PreferencesConnector extends ServicesConfig {

  def httpGet: HttpGet

  object LanguagePreference {
    implicit val format = Json.format[LanguagePreference]
  }

  def languageByEmail(emailAddress: String)(implicit hc: HeaderCarrier): Future[Language] = {
    val url = baseUrl("preferences") + s"/preferences/language/${emailAddress}"
    httpGet.GET[Language](url)
    }
}

final case class LanguagePreference(lang: String)

object  PreferencesConnector {
  def apply(): PreferencesConnector = new PreferencesConnector with ServicesConfig {
    override protected def mode: Mode = Play.current.mode
    override protected def runModeConfiguration: Configuration = Play.current.configuration
    override def httpGet: HttpGet = WSHttp
  }
}

