/*
 * Copyright 2019 HM Revenue & Customs
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
      templateId = "apd_registration_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your Air Passenger Duty registration",
      plainTemplate = txt.apdRegistrationConfirmation.f,
      htmlTemplate = html.apdRegistrationConfirmation.f,
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
      priority = Some(MessagePriority.Standard)
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
    ),
    MessageTemplate.create(
      templateId = "c117_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C117 Authorised Economic Operator application",
      plainTemplate = txt.c117ApplicationConfirmation.f,
      htmlTemplate = html.c117ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part1_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 1 Part 1 Authorised Economic Operator application",
      plainTemplate = txt.c118Section1Part1ApplicationConfirmation.f,
      htmlTemplate = html.c118Section1Part1ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 1 Part 2 Authorised Economic Operator application",
      plainTemplate = txt.c118Section1Part2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section1Part2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part3_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 1 Part 3 Authorised Economic Operator application",
      plainTemplate = txt.c118Section1Part3ApplicationConfirmation.f,
      htmlTemplate = html.c118Section1Part3ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 2 Authorised Economic Operator application",
      plainTemplate = txt.c118Section2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
    templateId = "c118_section3_part1_application_confirmation",
    fromAddress = govUkTeamAddress,
    service = Eeitt,
    subject = "Submitted: C118 Section 3 Part 1 Authorised Economic Operator application",
    plainTemplate = txt.c118Section3Part1ApplicationConfirmation.f,
    htmlTemplate = html.c118Section3Part1ApplicationConfirmation.f,
    priority = Some(MessagePriority.Standard)
  ),
    MessageTemplate.create(
      templateId = "c118_section3_part2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 3 Part 2 Authorised Economic Operator application",
      plainTemplate = txt.c118Section3Part2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section3Part2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
  ),
    MessageTemplate.create(
      templateId = "c118_section4_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 4 Authorised Economic Operator application",
      plainTemplate = txt.c118Section4ApplicationConfirmation.f,
      htmlTemplate = html.c118Section4ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section5_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 5 Authorised Economic Operator application",
      plainTemplate = txt.c118Section5ApplicationConfirmation.f,
      htmlTemplate = html.c118Section5ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part1_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 6 Part 1 Authorised Economic Operator application",
      plainTemplate = txt.c118Section6Part1ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part1ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 6 Part 2 Authorised Economic Operator application",
      plainTemplate = txt.c118Section6Part2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part3_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 6 Part 3 Authorised Economic Operator application",
      plainTemplate = txt.c118Section6Part3ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part3ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part4_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: C118 Section 6 Part 4 Authorised Economic Operator application",
      plainTemplate = txt.c118Section6Part4ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part4ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "tsp_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Submitted: your Transitional Simplified Procedure application",
      plainTemplate = txt.tspApplicationConfirmation.f,
      htmlTemplate = html.tspApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "lt_registration_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You submitted a Landfill Tax registration",
      plainTemplate = txt.ltRegConfirmation.f,
      htmlTemplate = html.ltRegConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "gd_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Gaming Duty application received",
      plainTemplate = txt.gdApplicationConfirmation.f,
      htmlTemplate = html.gdApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ipt100_registration_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your IPT application",
      plainTemplate = txt.ipt100RegistrationConfirmation.f,
      htmlTemplate = html.ipt100RegistrationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
      MessageTemplate.create(
        templateId = "csr_submission_confirmation",
        fromAddress = govUkTeamAddress,
        service = Eeitt,
        subject = "HMRC received your self-report",
        plainTemplate = txt.corporateSelfReportingSubmissionConfirmation.f,
        htmlTemplate = html.corporateSelfReportingSubmissionConfirmation.f,
        priority = Some(MessagePriority.Standard)
  )
  )

}
