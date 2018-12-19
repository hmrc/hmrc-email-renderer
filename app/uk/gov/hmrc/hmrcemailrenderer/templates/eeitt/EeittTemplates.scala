/*
 * Copyright 2018 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.eeitt

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Eeitt

object EeittTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "eeitt_submission_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submission Confirmation",
      plainTemplate = txt.eeittSubmissionConfirmation.f,
      htmlTemplate = html.eeittSubmissionConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cir_appointment_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Appointment Confirmation",
      plainTemplate = txt.cirAppointmentConfirmation.f,
      htmlTemplate = html.cirAppointmentConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cir_revocation_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Revocation Confirmation",
      plainTemplate = txt.cirRevocationConfirmation.f,
      htmlTemplate = html.cirRevocationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "eeitt_ce930_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "CE930 Confirmation",
      plainTemplate = txt.eeitt_ce930_confirmation.f,
      htmlTemplate = html.eeitt_ce930_confirmation.f,
      priority = Some(MessagePriority.Standard)
  ),
    MessageTemplate.create(
      templateId = "eeitt_ho930_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HO930 Confirmation",
      plainTemplate = txt.eeitt_ho930_confirmation.f,
      htmlTemplate = html.eeitt_ho930_confirmation.f,
      priority = Some(MessagePriority.Standard)
  ),
  MessageTemplate.create(
    templateId = "cir_return_confirmation",
    fromAddress = govUkTeamAddress,
    service = Eeitt,
    subject = "CIR Return",
    plainTemplate = txt.cirReturnConfirmation.f,
    htmlTemplate = html.cirReturnConfirmation.f,
    priority = Some(MessagePriority.Standard)
  ),
  MessageTemplate.create(
    templateId = "randd_confirmation_submission",
    fromAddress = govUkTeamAddress,
    service = Eeitt,
    subject = "R&D Submission",
    plainTemplate = txt.researchAndDevelopmentSubmission.f,
    htmlTemplate = html.researchAndDevelopmentSubmission.f,
    priority = Some(MessagePriority.Standard)
  ),
    MessageTemplate.create(
      templateId = "ho10_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HO10 Submission",
      plainTemplate = txt.ho10Confirmation.f,
      htmlTemplate = html.ho10Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "apd_return_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "apd return",
      plainTemplate = txt.apdReturnConfirmation.f,
      htmlTemplate = html.apdReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "vat_refund_claim_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "VAT claim confirmation",
      plainTemplate = txt.claimVATRefundConfirmation.f,
      htmlTemplate = html.claimVATRefundConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ipt100_return_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "IPT 100 return",
      plainTemplate = txt.ipt100ReturnConfirmation.f,
      htmlTemplate = html.ipt100ReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "bd510_return_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "BD 510 return",
      plainTemplate = txt.bd510ReturnConfirmation.f,
      htmlTemplate = html.bd510ReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "al100_return_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "AL 100 return",
      plainTemplate = txt.al100ReturnConfirmation.f,
      htmlTemplate = html.al100ReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
    templateId = "lt100_return_confirmation",
    fromAddress = govUkTeamAddress,
    service = Eeitt,
    subject = "LT 100 return",
    plainTemplate = txt.lt100ReturnConfirmation.f,
    htmlTemplate = html.lt100ReturnConfirmation.f,
    priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
    templateId = "gd95_return_confirmation",
    fromAddress = govUkTeamAddress,
    service = Eeitt,
    subject = "Your Gaming Duty return has been submitted",
    plainTemplate = txt.gd95ReturnConfirmation.f,
    htmlTemplate = html.gd95ReturnConfirmation.f,
    priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
    templateId = "gd94_return_confirmation",
    fromAddress = govUkTeamAddress,
    service = Eeitt,
    subject = "Your Gaming Duty return (GD94) has been submitted",
    plainTemplate = txt.gd94ReturnConfirmation.f,
    htmlTemplate = html.gd94ReturnConfirmation.f,
    priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "al_registration_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "We received your Aggregates Levy registration",
      plainTemplate = txt.alRegistrationConfirmation.f,
      htmlTemplate = html.alRegistrationConfirmation.f,
    ),
    MessageTemplate.create(
      templateId = "ex250_registration_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your registration to be a bingo promoter has been submitted",
      plainTemplate = txt.ex250ReturnConfirmation.f,
      htmlTemplate = html.ex250ReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "air597_return_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your Alcoholic Ingredients Relief claim has been submitted",
      plainTemplate = txt.air597ReturnConfirmation.f,
      htmlTemplate = html.air597ReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    )
  )

}
