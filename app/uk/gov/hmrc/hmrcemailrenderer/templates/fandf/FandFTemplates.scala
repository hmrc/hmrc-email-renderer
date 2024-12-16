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

package uk.gov.hmrc.hmrcemailrenderer.templates.fandf

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.FriendsAndFamily

object FandFTemplates {
  val trustedHelpersTeamAddress = FromAddress.noReply("HMRC Trusted Helpers")

  private def ask_help_subject(params: Map[String, String]) =
    params
      .get("helpeeFirstName")
      .flatMap(fname => params.get("helpeeLastName").map(lname => s"$fname $lname "))
      .getOrElse("Someone ") + "has asked you to be their trusted helper"

  private def offer_help_subject(params: Map[String, String]) =
    params
      .get("helperFirstName")
      .flatMap(fname => params.get("helperLastName").map(lname => s"$fname $lname "))
      .getOrElse("Someone ") + "has offered to be your trusted helper"

  val templates = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "fandf_ask_help_notification",
      fromAddress = trustedHelpersTeamAddress,
      service = FriendsAndFamily,
      subject = ask_help_subject(_),
      plainTemplate = txt.newFandFAskHelpMessageAlert.f,
      htmlTemplate = html.newFandFAskHelpMessageAlert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "fandf_ask_help_notification_cy",
      fromAddress = trustedHelpersTeamAddress,
      service = FriendsAndFamily,
      subject = ask_help_subject(_),
      plainTemplate = txt.newFandFAskHelpMessageAlertCy.f,
      htmlTemplate = html.newFandFAskHelpMessageAlertCy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "fandf_offer_help_notification",
      fromAddress = trustedHelpersTeamAddress,
      service = FriendsAndFamily,
      subject = offer_help_subject(_),
      plainTemplate = txt.newFandFOfferHelpMessageAlert.f,
      htmlTemplate = html.newFandFOfferHelpMessageAlert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "fandf_offer_help_notification_cy",
      fromAddress = trustedHelpersTeamAddress,
      service = FriendsAndFamily,
      subject = offer_help_subject(_),
      plainTemplate = txt.newFandFOfferHelpMessageAlertCy.f,
      htmlTemplate = html.newFandFOfferHelpMessageAlertCy.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
