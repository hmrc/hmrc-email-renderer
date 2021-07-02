/*
 * Copyright 2021 HM Revenue & Customs
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

import java.util.Base64

import play.api.libs.json.{ Json, Reads }

final case class ValidConnectionMethodBase64EncodedDetails(
  connectionMethod: String,
  requestCount: Int,
  headerValidations: Set[HeadersValidation]
) {

  val prettyConnectionMethod: String = connectionMethod match {
    case "MOBILE_APP_DIRECT"      => "Mobile application direct"
    case "DESKTOP_APP_DIRECT"     => "Desktop application direct"
    case "MOBILE_APP_VIA_SERVER"  => "Mobile application via server"
    case "DESKTOP_APP_VIA_SERVER" => "Desktop application via server"
    case "WEB_APP_VIA_SERVER"     => "Web application via server"
    case "BATCH_PROCESS_DIRECT"   => "Batch process direct"
    case "OTHER_DIRECT"           => "Other direct"
    case "OTHER_VIA_SERVER"       => "Other via server"
    case "INVALID"                => "Invalid connection method"
    case "MISSING"                => "Missing connection method"
    case other                    => other
  }
}

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
) {

  val prettyHeaderOrHeaders: String = headerOrHeaders.split(',').map(_.trim).map(prettyHeader).mkString(", ")

  private def prettyHeader(header: String): String = header match {
    case "gov-client-browser-do-not-track"  => "Gov-Client-Browser-Do-Not-Track"
    case "gov-client-browser-js-user-agent" => "Gov-Client-Browser-JS-User-Agent"
    case "gov-client-browser-plugins"       => "Gov-Client-Browser-Plugins"
    case "gov-client-connection-method"     => "Gov-Client-Connection-Method"
    case "gov-client-device-id"             => "Gov-Client-Device-ID"
    case "gov-client-local-ips"             => "Gov-Client-Local-IPs"
    case "gov-client-local-ips-timestamp"   => "Gov-Client-Local-IPs-Timestamp"
    case "gov-client-mac-addresses"         => "Gov-Client-MAC-Addresses"
    case "gov-client-multi-factor"          => "Gov-Client-Multi-Factor"
    case "gov-client-public-ip"             => "Gov-Client-Public-IP"
    case "gov-client-public-ip-timestamp"   => "Gov-Client-Public-IP-Timestamp"
    case "gov-client-public-port"           => "Gov-Client-Public-Port"
    case "gov-client-screens"               => "Gov-Client-Screens"
    case "gov-client-timezone"              => "Gov-Client-Timezone"
    case "gov-client-user-agent"            => "Gov-Client-User-Agent"
    case "gov-client-user-ids"              => "Gov-Client-User-IDs"
    case "gov-client-window-size"           => "Gov-Client-Window-Size"
    case "gov-vendor-forwarded"             => "Gov-Vendor-Forwarded"
    case "gov-vendor-license-ids"           => "Gov-Vendor-License-IDs"
    case "gov-vendor-public-ip"             => "Gov-Vendor-Public-IP"
    case "gov-vendor-product-name"          => "Gov-Vendor-Product-Name"
    case "gov-vendor-version"               => "Gov-Vendor-Version"
    case other                              => other
  }
}

final case class Problem(message: String, percentage: Int, count: Int) {
  val percentageDescription: String =
    if (percentage < 1) {
      "found in fewer than 1% of your requests"
    } else {
      s"found in $percentage% of your requests"
    }

  val shortPercentageDescription: String =
    if (percentage < 1) {
      "Fewer than 1% of requests"
    } else {
      s"$percentage% of requests"
    }

  val prettyCount: String = count.toString

}

object Problem {
  implicit val reads: Reads[Problem] = Json.reads[Problem]
}

object HeadersValidation {
  implicit val reads: Reads[HeadersValidation] = Json.reads[HeadersValidation]
}
