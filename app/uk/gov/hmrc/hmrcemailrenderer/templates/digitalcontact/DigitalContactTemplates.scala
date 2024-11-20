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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment

object DigitalContactTemplates {
  val defaultFromAddress = FromAddress.noReply("HMRC digital")

  val defaultFromAddressWelsh = FromAddress.noReply("CThEF Digidol")

  // TODO: waiting for welsh translation
  val defaultWelshFrom = FromAddress.noReply("")

  val templatesToMapToNewMessageAlert = Seq(
    "R002",
    "SA251",
    "SA326D",
    "SA328D",
    "SA359",
    "SA370",
    "SA371",
    "SA372",
    "SA373",
    "IgnorePaperFiling",
    "CA001"
  )

  val newMessageAlertTemplates: Seq[MessageTemplate] =
    templatesToMapToNewMessageAlert.map { formId =>
      MessageTemplate.create(
        templateId = s"newMessageAlert_$formId",
        fromAddress = defaultFromAddress,
        service = SelfAssessment,
        subject = "HMRC paperless notifications: new message",
        plainTemplate = txt.newMessageAlert.f,
        htmlTemplate = html.newMessageAlert.f
      )
    }

  val templates = Seq(
    MessageTemplate.create(
      templateId = "verifyEmailAddress",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC electronic communications: verify your email address",
      plainTemplate = txt.verifyEmailAddress.f,
      htmlTemplate = html.verifyEmailAddress.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "verifyEmailAddress_cy",
      fromAddress = defaultFromAddressWelsh,
      service = SelfAssessment,
      subject = "CThEF – Cyfathrebu drwy ddull electronig: dilysu’ch cyfeiriad e-bost newydd",
      plainTemplate = txt.verifyEmailAddress_cy.f,
      htmlTemplate = html.verifyEmailAddress_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "changeOfEmailAddress",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC electronic communications: change of email address",
      plainTemplate = txt.changeOfEmailAddress.f,
      htmlTemplate = html.changeOfEmailAddress.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "changeOfEmailAddress_cy",
      fromAddress = defaultFromAddressWelsh,
      service = SelfAssessment,
      subject = "CThEF – Cyfathrebu drwy ddull electronig: newid cyfeiriad e-bost",
      plainTemplate = txt.changeOfEmailAddress_cy.f,
      htmlTemplate = html.changeOfEmailAddress_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "digitalOptOutConfirmation",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC notifications by post",
      plainTemplate = txt.digitalOptOutConfirmation.f,
      htmlTemplate = html.digitalOptOutConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "digitalOptOutConfirmation_cy",
      fromAddress = defaultFromAddressWelsh,
      service = SelfAssessment,
      subject = "CThEF – Hysbysiadau drwy’r post",
      plainTemplate = txt.digitalOptOutConfirmation_cy.f,
      htmlTemplate = html.digitalOptOutConfirmation_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "changeOfEmailAddressNewAddress",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC electronic communications: verify your new email address",
      plainTemplate = txt.changeOfEmailAddressNewAddress.f,
      htmlTemplate = html.changeOfEmailAddressNewAddress.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "changeOfEmailAddressNewAddress_cy",
      fromAddress = defaultFromAddressWelsh,
      service = SelfAssessment,
      subject = "CThEF – Cyfathrebu drwy ddull electronig: dilysu’ch cyfeiriad e-bost newydd",
      plainTemplate = txt.changeOfEmailAddressNewAddress_cy.f,
      htmlTemplate = html.changeOfEmailAddressNewAddress_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: new message",
      plainTemplate = txt.newMessageAlert.f,
      htmlTemplate = html.newMessageAlert.f
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_cy",
      fromAddress = defaultFromAddressWelsh,
      service = SelfAssessment,
      subject = "Hysbysiadau di-bapur CThEF: neges newydd",
      plainTemplate = txt.newMessageAlert_cy.f,
      htmlTemplate = html.newMessageAlert_cy.f
    ),
    MessageTemplate.create(
      templateId = "rescindedMessageAlert",
      fromAddress = FromAddress.noReply("HMRC Digital Contact (Team)"),
      service = SelfAssessment,
      subject = "HMRC recalled a Self Assessment message",
      plainTemplate = txt.rescindedMessageAlert.f,
      htmlTemplate = html.rescindedMessageAlert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "penaltyChargeApologies",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.penaltyChargeApologies.f,
      htmlTemplate = html.penaltyChargeApologies.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "rescindedMessageAlert_cy",
      fromAddress = FromAddress.noReply("CThEF – (Tîm) Cyswllt Digidol"),
      service = SelfAssessment,
      subject = "Gwnaeth CThEF alw neges ynghylch Hunanasesiad yn ei hôl",
      plainTemplate = txt.rescindedMessageAlert_cy.f,
      htmlTemplate = html.rescindedMessageAlert_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "verificationReminder",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC electronic communications: complete the sign-up process",
      plainTemplate = txt.verificationReminder.f,
      htmlTemplate = html.verificationReminder.f
    ),
    MessageTemplate.create(
      templateId = "verificationReminder_cy",
      fromAddress = defaultFromAddressWelsh,
      service = SelfAssessment,
      subject = "Cyfathrebu drwy ddull electronig CThEF: cwblhau’r broses fewngofnodi",
      plainTemplate = txt.verificationReminder_cy.f,
      htmlTemplate = html.verificationReminder_cy.f
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_SA309",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.newMessageAlertSA309.f,
      htmlTemplate = html.newMessageAlertSA309.f
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_SS300",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "Self Assessment reminders: new message",
      plainTemplate = txt.newMessageAlertSS300.f,
      htmlTemplate = html.newMessageAlertSS300.f
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_SA300",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "Self Assessment reminders: new message",
      plainTemplate = txt.newMessageAlertSA300.f,
      htmlTemplate = html.newMessageAlertSA300.f
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_SA316",
      fromAddress = FromAddress.noReply("HMRC Self Assessment"),
      service = SelfAssessment,
      subject = "File your Self Assessment return",
      plainTemplate = txt.newMessageAlertSA316_A.f,
      htmlTemplate = html.newMessageAlertSA316_A.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "dc-1462-test-message",
      fromAddress = FromAddress.noReply("None"),
      service = SelfAssessment,
      subject = "test template",
      plainTemplate = txt.dc_1462.f,
      htmlTemplate = html.dc_1462.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "digitalOptInConfirmation",
      fromAddress = FromAddress.noReply("HMRC digital team"),
      service = SelfAssessment,
      subject = "Your online tax letters",
      plainTemplate = txt.digitalOptInConfirmation.f,
      htmlTemplate = html.digitalOptInConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "digitalOptInConfirmation_cy",
      fromAddress = defaultFromAddressWelsh,
      service = SelfAssessment,
      subject = "Eich llythyrau treth ar-lein",
      plainTemplate = txt.digitalOptInConfirmation_cy.f,
      htmlTemplate = html.digitalOptInConfirmation_cy.f,
      priority = Some(MessagePriority.Urgent)
    )
  ) ++ newMessageAlertTemplates
}
