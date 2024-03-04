/*
 * Copyright 2023 HM Revenue & Customs
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

import com.google.inject.{ Inject, Singleton }
import play.api.libs.json.{ Json, OFormat }
import uk.gov.hmrc.crypto.{ ApplicationCrypto, PlainText }
import uk.gov.hmrc.hmrcemailrenderer.model.Language
import uk.gov.hmrc.http.{ HeaderCarrier, HttpClient }
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig
import uk.gov.hmrc.http.HttpReads.Implicits._

import scala.concurrent.{ ExecutionContext, Future }
@Singleton
class PreferencesConnector @Inject()(servicesConfig: ServicesConfig, http: HttpClient, crypto: ApplicationCrypto) {

  object LanguagePreference {
    implicit val format: OFormat[LanguagePreference] = Json.format[LanguagePreference]
  }

  def languageByEmail(emailAddress: String)(implicit hc: HeaderCarrier, ec: ExecutionContext): Future[Language] = {
    val encryptedEmail = new String(crypto.QueryParameterCrypto.encrypt(PlainText(emailAddress)).toBase64)
    val url = servicesConfig.baseUrl("preferences") + s"/preferences/language/$encryptedEmail"
    http.GET[Language](url)
  }
}

final case class LanguagePreference(lang: String)
