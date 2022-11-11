/*
 * Copyright 2022 HM Revenue & Customs
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

final case class HeadersValidation(headerOrHeaders: String, errors: Set[Problem], warnings: Set[Problem]) {

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

object HeadersValidation {
  implicit val reads: Reads[HeadersValidation] = Json.reads[HeadersValidation]
}
