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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq.extraparams

import java.util.Base64

import play.api.libs.json.{Json, Reads}

final case class ValidConnectionMethodBase64EncodedDetails(
  connectionMethod: String,
  requestCount: Int,
  headerValidations: Set[HeadersValidation]
)

object ValidConnectionMethodBase64EncodedDetails {

  private implicit val reads: Reads[ValidConnectionMethodBase64EncodedDetails] =
    Json.reads[ValidConnectionMethodBase64EncodedDetails]

  def parse(encoded: String): ValidConnectionMethodBase64EncodedDetails = {
    val decoded = new String(Base64.getDecoder.decode(encoded), "UTF-8")
    Json.parse(decoded).as[ValidConnectionMethodBase64EncodedDetails]
  }
}

final case class HeadersValidation(
  headerOrHeaders: String,
  errors: Set[Problem],
  warnings: Set[Problem]
)

final case class Problem(message: String, percentage: Int)

object Problem {
  implicit val reads: Reads[Problem] = Json.reads[Problem]
}

object HeadersValidation {
  implicit val reads: Reads[HeadersValidation] = Json.reads[HeadersValidation]
}