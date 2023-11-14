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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params

import play.api.libs.json.{ Json, Reads }

import java.util.Base64

final case class ValidConnectionMethodBase64EncodedDetails(connectionMethod: String, requestCount: Int) {

  private val prettyConnectionMethods: Map[String, String] = Map(
    "MOBILE_APP_DIRECT"      -> "Mobile application direct",
    "DESKTOP_APP_DIRECT"     -> "Desktop application direct",
    "MOBILE_APP_VIA_SERVER"  -> "Mobile application via server",
    "DESKTOP_APP_VIA_SERVER" -> "Desktop application via server",
    "WEB_APP_VIA_SERVER"     -> "Web application via server",
    "BATCH_PROCESS_DIRECT"   -> "Batch process direct",
    "OTHER_DIRECT"           -> "Other direct",
    "OTHER_VIA_SERVER"       -> "Other via server",
    "INVALID"                -> "Invalid connection method",
    "MISSING"                -> "Missing connection method"
  ).withDefault(identity)

  val prettyConnectionMethod: String = prettyConnectionMethods(connectionMethod)
}

object ValidConnectionMethodBase64EncodedDetails {

  private implicit val reads: Reads[ValidConnectionMethodBase64EncodedDetails] =
    Json.reads[ValidConnectionMethodBase64EncodedDetails]

  def parse(encoded: String): ValidConnectionMethodBase64EncodedDetails = {
    val decoded = new String(Base64.getDecoder.decode(encoded), "UTF-8")
    Json.parse(decoded).as[ValidConnectionMethodBase64EncodedDetails]
  }
}
