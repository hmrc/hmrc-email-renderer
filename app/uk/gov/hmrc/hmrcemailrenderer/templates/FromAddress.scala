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

package uk.gov.hmrc.hmrcemailrenderer.templates

import play.api.Play

import scala.util.Try

case class FromAddress(f: Map[String, String] => String) {
  def apply(p: Map[String, String]) = f(p)
}

object FromAddress {
  import play.api.Play.current

  private val defaultDomain = "tax.service.gov.uk"

  lazy val replyDomain =
    Try(Play.configuration.getString("fromAddress.domain")).toOption.flatten.getOrElse(defaultDomain)

  def noReply(name: String): String = s"$name <noreply@$replyDomain>"

  lazy val govUkTeamAddress = noReply("Gov.uk Team")
  lazy val govUkTeamAddressWelsh = noReply("Gov.uk Tîm")

  lazy val seissFromAddress = noReply("Self-Employment Income Support Scheme")
  lazy val seissFromAddressWelsh = noReply("Cynllun Cymhorthdal Incwm Hunangyflogaeth")
}
