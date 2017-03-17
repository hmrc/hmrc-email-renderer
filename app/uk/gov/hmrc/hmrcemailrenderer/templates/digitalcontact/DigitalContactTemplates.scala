/*
 * Copyright 2017 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.{FromAddress, ServiceIdentifier}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment

object DigitalContactTemplates {
  val defaultFromAddress = FromAddress.noReply("HMRC paperless")

  val templates = Seq(
    MessageTemplate.create(
      templateId = "verifyEmailAddress",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: verify your email address",
      plainTemplate = txt.verifyEmailAddress.f,
      htmlTemplate  = html.verifyEmailAddress.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "changeOfEmailAddress",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: change of email address",
      plainTemplate = txt.changeOfEmailAddress.f,
      htmlTemplate = html.changeOfEmailAddress.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "digitalOptOutConfirmation",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC notifications by post",
      plainTemplate = txt.digitalOptOutConfirmation.f,
      htmlTemplate = html.digitalOptOutConfirmation.f),
    MessageTemplate.create(
      templateId = "changeOfEmailAddressNewAddress",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: verify your new email address",
      plainTemplate = txt.changeOfEmailAddressNewAddress.f,
      htmlTemplate = html.changeOfEmailAddressNewAddress.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: new message",
      plainTemplate = txt.newMessageAlert.f,
      htmlTemplate = html.newMessageAlert.f),
    MessageTemplate.create(
      templateId = "rescindedMessageAlert",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: message updated",
      plainTemplate = txt.rescindedMessageAlert.f,
      htmlTemplate = html.rescindedMessageAlert.f),
    MessageTemplate.create(
      templateId = "verificationReminder",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: complete the sign-up process",
      plainTemplate = txt.verificationReminder.f,
      htmlTemplate = html.verificationReminder.f),
    MessageTemplate.create(
      templateId = "newMessageAlert_SA309",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "You've got a new message from HMRC",
      plainTemplate = txt.newMessageAlertSA309.f,
      htmlTemplate = html.newMessageAlertSA309.f,
      priority = None
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_SS300",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "Self Assessment reminders: new message",
      plainTemplate = txt.newMessageAlertSS300.f,
      htmlTemplate = html.newMessageAlertSS300.f,
      priority = None
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_SA300",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "Self Assessment reminders: new message",
      plainTemplate = txt.newMessageAlertSA300.f,
      htmlTemplate = html.newMessageAlertSA300.f,
      priority = None
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_SA316",
      fromAddress = FromAddress.noReply("HMRC Self Assessment"),
      service = SelfAssessment,
      subject = "File your Self Assessment return",
      plainTemplate = txt.newMessageAlertSA316_A.f,
      htmlTemplate = html.newMessageAlertSA316_A.f,
      priority = Some(MessagePriority.Background)
    )
  )
}
