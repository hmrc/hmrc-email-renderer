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

import java.text.DecimalFormat
import scala.annotation.tailrec

final case class ValidConnectionMethodBase64EncodedDetails(
  connectionMethod: String,
  requestCount: Int,
  headerValidations: Set[HeadersValidation]
) {

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

final case class HeadersValidation(
  headerOrHeaders: String,
  errors: Set[Problem],
  warnings: Set[Problem]
) {

  private val prettyHeaders: Map[String, String] = Map(
    "gov-client-browser-do-not-track"  -> "Gov-Client-Browser-Do-Not-Track",
    "gov-client-browser-js-user-agent" -> "Gov-Client-Browser-JS-User-Agent",
    "gov-client-browser-plugins"       -> "Gov-Client-Browser-Plugins",
    "gov-client-connection-method"     -> "Gov-Client-Connection-Method",
    "gov-client-device-id"             -> "Gov-Client-Device-ID",
    "gov-client-local-ips"             -> "Gov-Client-Local-IPs",
    "gov-client-local-ips-timestamp"   -> "Gov-Client-Local-IPs-Timestamp",
    "gov-client-mac-addresses"         -> "Gov-Client-MAC-Addresses",
    "gov-client-multi-factor"          -> "Gov-Client-Multi-Factor",
    "gov-client-public-ip"             -> "Gov-Client-Public-IP",
    "gov-client-public-ip-timestamp"   -> "Gov-Client-Public-IP-Timestamp",
    "gov-client-public-port"           -> "Gov-Client-Public-Port",
    "gov-client-screens"               -> "Gov-Client-Screens",
    "gov-client-timezone"              -> "Gov-Client-Timezone",
    "gov-client-user-agent"            -> "Gov-Client-User-Agent",
    "gov-client-user-ids"              -> "Gov-Client-User-IDs",
    "gov-client-window-size"           -> "Gov-Client-Window-Size",
    "gov-vendor-forwarded"             -> "Gov-Vendor-Forwarded",
    "gov-vendor-license-ids"           -> "Gov-Vendor-License-IDs",
    "gov-vendor-public-ip"             -> "Gov-Vendor-Public-IP",
    "gov-vendor-product-name"          -> "Gov-Vendor-Product-Name",
    "gov-vendor-version"               -> "Gov-Vendor-Version"
  ).withDefault(identity)

  val prettyHeaderOrHeaders: String = headerOrHeaders.split(',').map(_.trim).map(prettyHeaders).mkString(", ")
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
      "Fewer than 1% of total"
    } else {
      s"$percentage% of total"
    }

  val prettyCount: String = {
    val suffix = if (count > 1) "requests" else "request"
    s"${Problem.prettyCount(count)} $suffix"
  }
}

object Problem {
  implicit val reads: Reads[Problem] = Json.reads[Problem]

  private[tdq] def prettyCount(count: Int): String = {

    val siPrefixes: Seq[String] = Seq("", "k", "m", "b")
    val decimalFormat: DecimalFormat = new DecimalFormat("#.#")
    val thousand: Double = 1000.0

    def format(double: Double): String = {
      val rounded = BigDecimal(double).setScale(1, BigDecimal.RoundingMode.FLOOR).toDouble
      decimalFormat.format(rounded)
    }

    @tailrec def loop(d: Double, prefixes: Seq[String]): String =
      if (prefixes.isEmpty) {
        format(d)
      } else if (d < thousand) {
        if (d < 10) {
          format(d) + prefixes.head
        } else {
          d.toInt + prefixes.head
        }
      } else {
        loop(d / thousand, prefixes.tail)
      }

    if (count < 0) {
      "-" + loop(Math.abs(count), siPrefixes)
    } else {
      loop(count, siPrefixes)
    }
  }
}

object HeadersValidation {
  implicit val reads: Reads[HeadersValidation] = Json.reads[HeadersValidation]
}
