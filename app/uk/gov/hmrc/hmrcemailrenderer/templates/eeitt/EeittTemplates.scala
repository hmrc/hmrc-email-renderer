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

package uk.gov.hmrc.hmrcemailrenderer.templates.eeitt

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Eeitt

object EeittTemplates {

  private val getTorDySub: Map[String, String] => String =
    _.getOrElse("torDySub", "You applied for transfer of residence tax relief")

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
      templateId = "cir_appointment_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau Penodiad",
      plainTemplate = txt.cirAppointmentConfirmation_cy.f,
      htmlTemplate = html.cirAppointmentConfirmation_cy.f,
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
      templateId = "cir_revocation_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau Dirymiad",
      plainTemplate = txt.cirRevocationConfirmation_cy.f,
      htmlTemplate = html.cirRevocationConfirmation_cy.f,
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
      templateId = "eeitt_ce930_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau CE930",
      plainTemplate = txt.eeitt_ce930_confirmation_cy.f,
      htmlTemplate = html.eeitt_ce930_confirmation_cy.f,
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
      templateId = "eeitt_ho930_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau HO930",
      plainTemplate = txt.eeitt_ho930_confirmation_cy.f,
      htmlTemplate = html.eeitt_ho930_confirmation_cy.f,
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
      templateId = "cir_return_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Ffurflen CIR",
      plainTemplate = txt.cirReturnConfirmation_cy.f,
      htmlTemplate = html.cirReturnConfirmation_cy.f,
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
      templateId = "randd_confirmation_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cyflwyno manylion Ymchwil a Datblygu",
      plainTemplate = txt.researchAndDevelopmentSubmission_cy.f,
      htmlTemplate = html.researchAndDevelopmentSubmission_cy.f,
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
      templateId = "ho10_confirmation_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cyflwyno HO10",
      plainTemplate = txt.ho10Confirmation_cy.f,
      htmlTemplate = html.ho10Confirmation_cy.f,
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
      templateId = "apd_return_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "ffurflen apd",
      plainTemplate = txt.apdReturnConfirmation_cy.f,
      htmlTemplate = html.apdReturnConfirmation_cy.f,
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
      templateId = "apd_registration_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae’ch cofrestriad ar gyfer Toll Teithwyr Awyr wedi dod i law CThEM",
      plainTemplate = txt.apdRegistrationConfirmation_cy.f,
      htmlTemplate = html.apdRegistrationConfirmation_cy.f,
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
      templateId = "ipt100_return_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Ffurflen IPT 100",
      plainTemplate = txt.ipt100ReturnConfirmation_cy.f,
      htmlTemplate = html.ipt100ReturnConfirmation_cy.f,
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
      templateId = "bd510_return_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Ffurflen BD 510",
      plainTemplate = txt.bd510ReturnConfirmation_cy.f,
      htmlTemplate = html.bd510ReturnConfirmation_cy.f,
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
      templateId = "lt100_return_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Ffurflen LT 100",
      plainTemplate = txt.lt100ReturnConfirmation_cy.f,
      htmlTemplate = html.lt100ReturnConfirmation_cy.f,
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
      templateId = "gd95_return_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae eich ffurflen Toll Hapchwarae wed’i chyflwyno",
      plainTemplate = txt.gd95ReturnConfirmation_cy.f,
      htmlTemplate = html.gd95ReturnConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    //GD94 Template deleted from gForms repo
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
      templateId = "al_registration_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae’ch cofrestriad ar gyfer Ardoll Agregau wedi dod i law",
      plainTemplate = txt.alRegistrationConfirmation_cy.f,
      htmlTemplate = html.alRegistrationConfirmation_cy.f,
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
      templateId = "ex250_registration_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae’ch cofrestriad i fod yn hyrwyddwr bingo wedi cael ei gyflwyno",
      plainTemplate = txt.ex250ReturnConfirmation_cy.f,
      htmlTemplate = html.ex250ReturnConfirmation_cy.f,
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
      templateId = "air597_return_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae’ch ffurflen hawlio Rhyddhad ar Gynnwys Alcoholig wedi cael ei chyflwyno",
      plainTemplate = txt.air597ReturnConfirmation_cy.f,
      htmlTemplate = html.air597ReturnConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c117_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c117ApplicationConfirmation.f,
      htmlTemplate = html.c117ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c117_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c117ApplicationConfirmation_cy.f,
      htmlTemplate = html.c117ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part1_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section1Part1ApplicationConfirmation.f,
      htmlTemplate = html.c118Section1Part1ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part1_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section1Part1ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section1Part1ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section1Part2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section1Part2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part2_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section1Part2ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section1Part2ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part3_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section1Part3ApplicationConfirmation.f,
      htmlTemplate = html.c118Section1Part3ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section1_part3_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section1Part3ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section1Part3ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section2_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section2ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section2ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section3_part1_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section3Part1ApplicationConfirmation.f,
      htmlTemplate = html.c118Section3Part1ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section3_part1_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section3Part1ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section3Part1ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section3_part2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section3Part2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section3Part2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section3_part2_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section3Part2ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section3Part2ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section4_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section4ApplicationConfirmation.f,
      htmlTemplate = html.c118Section4ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section4_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section4ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section4ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section5_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section5ApplicationConfirmation.f,
      htmlTemplate = html.c118Section5ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section5_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section5ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section5ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part1_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section6Part1ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part1ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part1_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section6Part1ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section6Part1ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part2_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section6Part2ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part2ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part2_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section6Part2ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section6Part2ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part3_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section6Part3ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part3ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part3_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section6Part3ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section6Part3ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part4_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received part of your AEO application",
      plainTemplate = txt.c118Section6Part4ApplicationConfirmation.f,
      htmlTemplate = html.c118Section6Part4ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c118_section6_part4_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEM",
      plainTemplate = txt.c118Section6Part4ApplicationConfirmation_cy.f,
      htmlTemplate = html.c118Section6Part4ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    //TSP Form shuttered
    MessageTemplate.create(
      templateId = "tsp_application_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your transitional simplified procedures application",
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
    ),
    //Cash dec template outdated - split into NI and GB
    MessageTemplate.create(
      templateId = "cash_declaration",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your cash declaration",
      plainTemplate = txt.cashDeclaration.f,
      htmlTemplate = html.cashDeclaration.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cash_declaration_EU",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your cash declaration",
      plainTemplate = txt.cashDeclaration_EU.f,
      htmlTemplate = html.cashDeclaration_EU.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cash_declaration_UK",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your cash declaration",
      plainTemplate = txt.cashDeclaration_UK.f,
      htmlTemplate = html.cashDeclaration_UK.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cet_email_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your request for help with a tax issue",
      plainTemplate = txt.cetEmailConfirmation.f,
      htmlTemplate = html.cetEmailConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "gss_email_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your growth support request for a mid-sized business",
      plainTemplate = txt.gssEmailTemplate.f,
      htmlTemplate = html.gssEmailTemplate.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "register_for_duty_on_gas_for_road_fuel_use",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your registration for duty on gas for use as road fuel",
      plainTemplate = txt.registerForDutyOnGasForRoadFuelUse.f,
      htmlTemplate = html.registerForDutyOnGasForRoadFuelUse.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "register_for_duty_on_biofuels_and_other_fuel_substitutes",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your registration for duty on biofuels and other fuel substitutes",
      plainTemplate = txt.registerForDutyOnBiofuelsAndOtherFuelSubstitutes.f,
      htmlTemplate = html.registerForDutyOnBiofuelsAndOtherFuelSubstitutes.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "rdec_email_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your supporting details for an R&D Expenditure Credit claim",
      plainTemplate = txt.rdecEmailTemplate.f,
      htmlTemplate = html.rdecEmailTemplate.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "corporation_tax_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your Corporation Tax application",
      plainTemplate = txt.corporationTaxConfirmation.f,
      htmlTemplate = html.corporationTaxConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "register_for_fuel_duty_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your application to register for Fuel Duty",
      plainTemplate = txt.registerForFuelDuty.f,
      htmlTemplate = html.registerForFuelDuty.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "adr_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your ADR application",
      plainTemplate = txt.adrConfirmation.f,
      htmlTemplate = html.adrConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ccg1_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your customs application",
      plainTemplate = txt.ccg1Confirmation.f,
      htmlTemplate = html.ccg1Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    //TSP DeReg Shuttered
    MessageTemplate.create(
      templateId = "tspDeReg_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your cancellation request",
      plainTemplate = txt.tspDeRegConfirmation.f,
      htmlTemplate = html.tspDeRegConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    //TSP Chief Shuttered
    MessageTemplate.create(
      templateId = "tspCHIEF_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your CHIEF badge request",
      plainTemplate = txt.tspCHIEFActivationConfirmation.f,
      htmlTemplate = html.tspCHIEFActivationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "challengeChildcare_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your mandatory review request",
      plainTemplate = txt.challengeChildcareSubmission.f,
      htmlTemplate = html.challengeChildcareSubmission.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "bd600_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your Lottery Duty return",
      plainTemplate = txt.bd600ReturnConfirmation.f,
      htmlTemplate = html.bd600ReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "civOffShore_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your exemption election",
      plainTemplate = txt.civOffShoreConfirmation.f,
      htmlTemplate = html.civOffShoreConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "civQualifying_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your exemption election",
      plainTemplate = txt.civQualifyingConfirmation.f,
      htmlTemplate = html.civQualifyingConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "civTransparency_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your transparency election",
      plainTemplate = txt.civTransparencyConfirmation.f,
      htmlTemplate = html.civTransparencyConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "confirmationCode_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address",
      plainTemplate = txt.confirmationCodeTemplate.f,
      htmlTemplate = html.confirmationCodeTemplate.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "civOffshore_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - election for exemption",
      plainTemplate = txt.civOffshoreCode.f,
      htmlTemplate = html.civOffshoreCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "civQualifying_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - election for exemption",
      plainTemplate = txt.civQualifyingCode.f,
      htmlTemplate = html.civQualifyingCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "civTransparency_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - election for transparency",
      plainTemplate = txt.civTransparencyCode.f,
      htmlTemplate = html.civTransparencyCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Statutory Parental Bereavement Pay",
      plainTemplate = txt.spbpCode.f,
      htmlTemplate = html.spbpCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_code_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost - Tâl Statudol Rhieni mewn Profedigaeth",
      plainTemplate = txt.spbpCode_cy.f,
      htmlTemplate = html.spbpCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your claim for an advance payment",
      plainTemplate = txt.spbpClaimConfirmation.f,
      htmlTemplate = html.spbpClaimConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cjrs_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Coronavirus Job Retention Scheme enquiry",
      plainTemplate = txt.cjrsCode.f,
      htmlTemplate = html.cjrsCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cjrs_code_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost - Ymholiad ynghylch y Cynllun Cadw Swyddi yn sgil Coronafeirws",
      plainTemplate = txt.cjrsCode_cy.f,
      htmlTemplate = html.cjrsCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cjrs_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your Coronavirus Job Retention Scheme question",
      plainTemplate = txt.cjrsSubmissionConfirmation.f,
      htmlTemplate = html.cjrsSubmissionConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seiss_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Ask for a review of your eligibility to claim Self-Employment Income Support",
      plainTemplate = txt.seissCode.f,
      htmlTemplate = html.seissCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "seiss_code_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Cadarnhau’ch cyfeiriad e-bost - Gofyn am adolygiad o’ch cymhwystra i hawlio Cymhorthdal Incwm Hunangyflogaeth",
      plainTemplate = txt.seissCode_cy.f,
      htmlTemplate = html.seissCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "seiss_eligibility_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "We received your request for an HMRC review of your eligibility for the Self-Employment Income Support Scheme",
      plainTemplate = txt.seissEligibilityConfirmation.f,
      htmlTemplate = html.seissEligibilityConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      //SEISS Child Shuttered
      templateId = "seiss_new_child_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your request to verify information",
      plainTemplate = txt.seissNewChildSubmission.f,
      htmlTemplate = html.seissNewChildSubmission.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seiss_grant_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You asked HMRC to review your grant amount for the Self-Employment Income Support Scheme online",
      plainTemplate = txt.seissGrantConfirmation.f,
      htmlTemplate = html.seissGrantConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ipr1_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your intellectual property rights application",
      plainTemplate = txt.ipr1ApplicationConfirmation.f,
      htmlTemplate = html.ipr1ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ipr2_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your intellectual property rights report",
      plainTemplate = txt.ipr2ReportConfirmation.f,
      htmlTemplate = html.ipr2ReportConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ipr3_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your intellectual property rights application",
      plainTemplate = txt.ipr3ApplicationConfirmation.f,
      htmlTemplate = html.ipr3ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seiss_repay_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your notification about Self-Employment Income Support Scheme grant money",
      plainTemplate = txt.seissRepayConfirmation.f,
      htmlTemplate = html.seissRepayConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seiss_repay_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae’ch hysbysiad am arian grant y Cynllun Cymhorthdal Incwm Hunangyflogaeth wedi dod i law CThEM.",
      plainTemplate = txt.seissRepayConfirmation_cy.f,
      htmlTemplate = html.seissRepayConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "vishing_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Report a suspicious HMRC phone call",
      plainTemplate = txt.vishingCode.f,
      htmlTemplate = html.vishingCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "vishing_code_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost - Rhoi gwybod am alwad ffôn amheus sy’n honni ei fod gan CThEM",
      plainTemplate = txt.vishingCode_cy.f,
      htmlTemplate = html.vishingCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ipr1_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Apply for action to protect your intellectual property rights",
      plainTemplate = txt.ipr1Code.f,
      htmlTemplate = html.ipr1Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ipr2_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Report goods that infringe your intellectual property rights",
      plainTemplate = txt.ipr2Code.f,
      htmlTemplate = html.ipr2Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ipr3_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Apply to extend your application to protect your intellectual property rights",
      plainTemplate = txt.ipr3Code.f,
      htmlTemplate = html.ipr3Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "vat_declaration_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your VAT status update",
      plainTemplate = txt.vatDeclarationApplicationConfirmation.f,
      htmlTemplate = html.vatDeclarationApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "trading_status_before_seiss_claimed",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your trading status details",
      plainTemplate = txt.tradingStatusBeforeSEISSClaimed.f,
      htmlTemplate = html.tradingStatusBeforeSEISSClaimed.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "settlement_request",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your settlement request",
      plainTemplate = txt.settlementRequest.f,
      htmlTemplate = html.settlementRequest.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "complaint_consultation_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Make a comment or complaint about HMRC consultations",
      plainTemplate = txt.consultationComplaint.f,
      htmlTemplate = html.consultationComplaint.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "complaint_consultation_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost - Gwneud sylw neu gŵyn am ymgynghoriadau CThEM",
      plainTemplate = txt.consultationComplaint_cy.f,
      htmlTemplate = html.consultationComplaint_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "consultation_complaint_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your consultation feedback",
      plainTemplate = txt.consultationComplaintConfirmation.f,
      htmlTemplate = html.consultationComplaintConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "dan_waiver_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your application for a guarantee waiver",
      plainTemplate = txt.danWaiverConfirmation.f,
      htmlTemplate = html.danWaiverConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "duty_deferment_account_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your application for a Duty Deferment Account",
      plainTemplate = txt.dutyDefermentAccountConfirmation.f,
      htmlTemplate = html.dutyDefermentAccountConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "duty_deferment_account_amend_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your request to change or cancel a duty deferment account",
      plainTemplate = txt.dutyDefermentAccountAmendConfirmation.f,
      htmlTemplate = html.dutyDefermentAccountAmendConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "eat_out_help_out_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your disclosure about Eat Out to Help Out Scheme payment",
      plainTemplate = txt.eatOuttoHelpOutConfirmation.f,
      htmlTemplate = html.eatOuttoHelpOutConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ni_vat_Status_reporting_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC Northern Ireland Protocol: application received",
      plainTemplate = txt.niVatStatusReporting.f,
      htmlTemplate = html.niVatStatusReporting.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ni_vat_Status_withdrawal_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC Northern Ireland Protocol: notification of withdrawal received",
      plainTemplate = txt.niVatStatusWithdrawal.f,
      htmlTemplate = html.niVatStatusWithdrawal.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "tor_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address – Apply for transfer of residence tax relief - HMRC",
      plainTemplate = txt.torCode.f,
      htmlTemplate = html.torCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "tor_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your application for transfer of residence tax relief",
      plainTemplate = txt.torConfirmation.f,
      htmlTemplate = html.torConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "tor_confirmation_dynamic",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getTorDySub,
      plainTemplate = txt.torConfirmation_dynamic.f,
      htmlTemplate = html.torConfirmation_dynamic.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "jrsRemoval_submission_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your Job Retention Scheme application",
      plainTemplate = txt.jrsRemovalSubmissionConfirmation.f,
      htmlTemplate = html.jrsRemovalSubmissionConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "nrsDLT_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address – Apply for a repayment of the non-UK Resident Stamp Duty Land Tax surcharge - HMRC",
      plainTemplate = txt.nrsDLTCode.f,
      htmlTemplate = html.nrsDLTCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "nrsDLT_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your application for repayment of the non-UK Resident Stamp Duty Land Tax surcharge",
      plainTemplate = txt.nrsDLTConfirmation.f,
      htmlTemplate = html.nrsDLTConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seissOverPayment_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirmation we received your SEISS amendments",
      plainTemplate = txt.seissOverPaymentConfirmation.f,
      htmlTemplate = html.seissOverPaymentConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seissOverPayment_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhad bod eich diwygiadau SEISS wedi dod i law",
      plainTemplate = txt.seissOverPaymentConfirmation_cy.f,
      htmlTemplate = html.seissOverPaymentConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pesm_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "We received your PESM application",
      plainTemplate = txt.pesmConfirmation.f,
      htmlTemplate = html.pesmConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pesm_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address – Apply for a Partial exemption special method",
      plainTemplate = txt.pesmCode.f,
      htmlTemplate = html.pesmCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "pesm_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost  – Gwneud cais am ddull eithriad rhannol arbennig",
      plainTemplate = txt.pesmCode_cy.f,
      htmlTemplate = html.pesmCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ctDormancy_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "We received your Corporation Tax notification",
      plainTemplate = txt.ctDormancyConfirmation.f,
      htmlTemplate = html.ctDormancyConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ctDormancy_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address – Tell HMRC your organisation has stopped trading or has never traded",
      plainTemplate = txt.ctDormancyCode.f,
      htmlTemplate = html.ctDormancyCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ctDormancy_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Cadarnhau’ch cyfeiriad e-bost – Rhowch wybod i CThEM bod eich sefydliad wedi rhoi’r gorau i fasnachu neu nad yw erioed wedi masnachu",
      plainTemplate = txt.ctDormancyCode_cy.f,
      htmlTemplate = html.ctDormancyCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "elcb_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address – Make a claim for extended loss carry back",
      plainTemplate = txt.elcbCode.f,
      htmlTemplate = html.elcbCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "elcb_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost – Gwneud hawliad i gario colled yn ôl dros gyfnod estynedig",
      plainTemplate = txt.elcbCode_cy.f,
      htmlTemplate = html.elcbCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "elcb_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your claim for extended loss carry back",
      plainTemplate = txt.elcbApplicationConfirmation.f,
      htmlTemplate = html.elcbApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ioss_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address – Tell HMRC you are registered for the VAT Import One Stop Shop in the EU",
      plainTemplate = txt.iossCode.f,
      htmlTemplate = html.iossCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ioss_dereg_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address – Tell HMRC about changes to a registration with the VAT Import One Stop Shop in the EU",
      plainTemplate = txt.iossDeregCode.f,
      htmlTemplate = html.iossDeregCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ioss_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Cadarnhau’ch cyfeiriad e-bost – Rhowch wybod i CThEM eich bod wedi’ch cofrestru ar gyfer y Gwasanaeth Un Cam ar gyfer TAW o ran Mewnforio yn yr EU",
      plainTemplate = txt.iossCode_cy.f,
      htmlTemplate = html.iossCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ioss_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You told HMRC about an IOSS registration",
      plainTemplate = txt.iossConfirmation.f,
      htmlTemplate = html.iossConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ioss_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Gwnaethoch roi gwybod i CThEM am gofrestriad IOSS",
      plainTemplate = txt.iossConfirmation_cy.f,
      htmlTemplate = html.iossConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ioss_dereg_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You sent HMRC an IOSS notification",
      plainTemplate = txt.iossDeregConfirmation.f,
      htmlTemplate = html.iossDeregConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "xiEORI_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You applied for an XI EORI number",
      plainTemplate = txt.xiEORIConfirmation.f,
      htmlTemplate = html.xiEORIConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "xiEORI_change_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You applied for a change to your XI EORI number",
      plainTemplate = txt.xiEORIChangeConfirmation.f,
      htmlTemplate = html.xiEORIChangeConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "nipbe_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You told HMRC about a Northern Ireland business establishment",
      plainTemplate = txt.nipbeConfirmation.f,
      htmlTemplate = html.nipbeConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "nipbe_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Gwnaethoch roi gwybod i CThEM am busnes parhaol yng Ngogledd Iwerddon",
      plainTemplate = txt.nipbeConfirmation_cy.f,
      htmlTemplate = html.nipbeConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seiss_voluntary_disclosure_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Self Employment Income Support Scheme: Agreement to repay",
      plainTemplate = txt.seissVoluntaryDisclosureConfirmation.f,
      htmlTemplate = html.seissVoluntaryDisclosureConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "netp_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You submitted your overseas bank details",
      plainTemplate = txt.netpConfirmation.f,
      htmlTemplate = html.netpConfirmation.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
