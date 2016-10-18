/*
 * Copyright 2016 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.fandf

import uk.gov.hmrc.email.services.BodyTemplate.Subject
import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.FriendsAndFamily
import uk.gov.hmrc.hmrcemailrenderer.templates._
import uk.gov.hmrc.email.services.BodyTemplate.Params

object FandFTemplates extends TemplateGroup with HmrcTemplate {
  val title = "FANDF"

  private def ask_help_subject(params : Params) =
    params.get("helpeeFirstName").flatMap(fname => params.get("helpeeLastName").map(lname => s"$fname $lname " )).getOrElse("Someone ") +"would like your help with tax online"

  private def offer_help_subject(params : Params) =
    params.get("helperFirstName").flatMap(fname => params.get("helperLastName").map(lname => s"$fname $lname " )).getOrElse("Someone ") +"wants to help you with your tax online"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "fandf_ask_help_notification",
      regime = FriendsAndFamily,
      subject = Subject(ask_help_subject),
      plainTemplate = txt.newFandFAskHelpMessageAlert.apply,
      htmlTemplate = html.newFandFAskHelpMessageAlert.apply,
      fromAddress = trustedHelpersTeamAddress),
    SimpleMessageTemplate(
      id = "fandf_offer_help_notification",
      regime = FriendsAndFamily,
      subject = Subject(offer_help_subject),
      plainTemplate = txt.newFandFOfferHelpMessageAlert.apply,
      htmlTemplate = html.newFandFOfferHelpMessageAlert.apply,
      fromAddress = trustedHelpersTeamAddress)
  )
}
