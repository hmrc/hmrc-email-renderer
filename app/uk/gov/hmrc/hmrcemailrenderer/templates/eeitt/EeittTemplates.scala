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

package uk.gov.hmrc.hmrcemailrenderer.templates.eeitt

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Eeitt

object EeittTemplates {

  private val getTorDySub: Map[String, String] => String =
    _.getOrElse("torDySub", "You applied for transfer of residence tax relief")

  private val getEmailSubjectCode: Map[String, String] => String =
    _.getOrElse("emailSubjectCode", "Confirm your email address")

  private val getEmailSubjectConfirmation: Map[String, String] => String =
    _.getOrElse("emailSubjectConfirmation", "HMRC has received your submission")

  private val getEmailSubjectCodeCy: Map[String, String] => String =
    _.getOrElse("emailSubjectCodeCy", "Cadarnhau’ch cyfeiriad e-bost")

  private val getEmailSubjectConfirmationCy: Map[String, String] => String =
    _.getOrElse("emailSubjectConfirmationCy", "Mae CThEF wedi derbyn eich cyflwyniad")

  private val getQAHCDySub: Map[String, String] => String =
    _.getOrElse("qahcDySub", "You submitted accounting period information for a QAHC")

  private val getc118CDySub: Map[String, String] => String =
    _.getOrElse("c118DySub", "Your application for AEO status")

  private val getNIPBEDySub: Map[String, String] => String =
    _.getOrElse("nipbeDySub", "You told HMRC about a Northern Ireland business establishment")

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
      subject = "Mae’ch cofrestriad ar gyfer Toll Teithwyr Awyr wedi dod i law CThEF",
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
    // GD94 Template deleted from gForms repo
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
      subject = "Your application for AEO status",
      plainTemplate = txt.c117ApplicationConfirmation.f,
      htmlTemplate = html.c117ApplicationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "c117_application_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
      plainTemplate = txt.c117ApplicationConfirmation_cy.f,
      htmlTemplate = html.c117ApplicationConfirmation_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "c118_confirmation_dynamic",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getc118CDySub,
      plainTemplate = txt.c118Confirmation_dynamic.f,
      htmlTemplate = html.c118Confirmation_dynamic.f,
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
      subject = "Mae rhan o’ch cais AEO wedi dod i law CThEF",
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
    // TSP Form shuttered
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
    // Cash dec template outdated - split into NI and GB
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
      templateId = "cashDecEU_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Declare cash you carry into or out of Northern Ireland",
      plainTemplate = txt.cashDecEUCode.f,
      htmlTemplate = html.cashDecEUCode.f,
      priority = Some(MessagePriority.Urgent)
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
      templateId = "cashDecUK_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Declare cash you carry into or out of Great Britain",
      plainTemplate = txt.cashDecUKCode.f,
      htmlTemplate = html.cashDecUKCode.f,
      priority = Some(MessagePriority.Urgent)
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
      templateId = "corporation_tax_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Register a non-resident company or CIV for Corporation Tax and notify us that it has disposed of an interest in UK property or land",
      plainTemplate = txt.corporationTaxCode.f,
      htmlTemplate = html.corporationTaxCode.f,
      priority = Some(MessagePriority.Urgent)
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
      templateId = "adr_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Apply for Alternative Dispute Resolution to settle a tax dispute",
      plainTemplate = txt.adrCode.f,
      htmlTemplate = html.adrCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "adr_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Cadarnhau’ch cyfeiriad e-bost - Gwneud cais am Ddull Amgen o Ddatrys Anghydfod (ADR) i setlo anghydfod treth",
      plainTemplate = txt.adrCode_cy.f,
      htmlTemplate = html.adrCode_cy.f,
      priority = Some(MessagePriority.Urgent)
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
    // TSP DeReg Shuttered
    MessageTemplate.create(
      templateId = "tspDeReg_confirmation_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your cancellation request",
      plainTemplate = txt.tspDeRegConfirmation.f,
      htmlTemplate = html.tspDeRegConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    // TSP Chief Shuttered
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
      templateId = "challengeChildcare_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Challenge a Childcare Service application decision",
      plainTemplate = txt.challengeChildcareCode.f,
      htmlTemplate = html.challengeChildcareCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "challengeChildcare_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost - Herio penderfyniad ynghylch cais i’r Gwasanaeth Gofal Plant",
      plainTemplate = txt.challengeChildcareCode_cy.f,
      htmlTemplate = html.challengeChildcareCode_cy.f,
      priority = Some(MessagePriority.Urgent)
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
    MessageTemplate.createWithDynamicSubject(
      templateId = "dynamicEmail_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getEmailSubjectCode,
      plainTemplate = txt.dynamicCodeTemplate.f,
      htmlTemplate = html.dynamicCodeTemplate.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dynamicEmail_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getEmailSubjectConfirmation,
      plainTemplate = txt.dynamicConfirmationTemplate.f,
      htmlTemplate = html.dynamicConfirmationTemplate.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "fullyDynamicEmail_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getEmailSubjectConfirmation,
      plainTemplate = txt.fullyDynamicConfirmationTemplate.f,
      htmlTemplate = html.fullyDynamicConfirmationTemplate.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dynamicEmail_code_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getEmailSubjectCodeCy,
      plainTemplate = txt.dynamicCodeTemplate_cy.f,
      htmlTemplate = html.dynamicCodeTemplate_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dynamicEmail_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getEmailSubjectConfirmationCy,
      plainTemplate = txt.dynamicConfirmationTemplate_cy.f,
      htmlTemplate = html.dynamicConfirmationTemplate_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "fullyDynamicEmail_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getEmailSubjectConfirmation,
      plainTemplate = txt.fullyDynamicConfirmationTemplate_cy.f,
      htmlTemplate = html.fullyDynamicConfirmationTemplate_cy.f,
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
      templateId = "spbp_claim_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Claim Statutory Parental Bereavement Pay (SPBP3)",
      plainTemplate = txt.spbpClaimCode.f,
      htmlTemplate = html.spbpClaimCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_claim_code_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost - Hawlio Tâl Statudol Rhieni mewn Profedigaeth (SPBP3)",
      plainTemplate = txt.spbpClaimCode_cy.f,
      htmlTemplate = html.spbpClaimCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_notification_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Tell the employee they are not eligible for Statutory Parental Bereavement Pay (SPBP1)",
      plainTemplate = txt.spbpNotificationCode.f,
      htmlTemplate = html.spbpNotificationCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_notification_code_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Cadarnhau’ch cyfeiriad e-bost - Rhoi gwybod i’r cyflogai nad yw’n gymwys ar gyfer Tâl Statudol Rhieni mewn Profedigaeth (SPBP1)",
      plainTemplate = txt.spbpNotificationCode_cy.f,
      htmlTemplate = html.spbpNotificationCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_record_code_submission",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Record Statutory Parental Bereavement Pay claims (SPBP2)",
      plainTemplate = txt.spbpRecordCode.f,
      htmlTemplate = html.spbpRecordCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "spbp_record_code_submission_cy",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cadarnhau’ch cyfeiriad e-bost - Cofnodi hawliadau am Dâl Statudol Rhieni mewn Profedigaeth (SPBP2)",
      plainTemplate = txt.spbpRecordCode_cy.f,
      htmlTemplate = html.spbpRecordCode_cy.f,
      priority = Some(MessagePriority.Urgent)
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
      // SEISS Child Shuttered
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
    MessageTemplate.createWithDynamicSubject(
      templateId = "nipbe_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getNIPBEDySub,
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
      subject = "Self Employment Income Support Scheme: Agreement to repay grant money",
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
    ),
    MessageTemplate.create(
      templateId = "cjrs_disclosure_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Notification of intent to disclose CJRS overclaim - application received",
      plainTemplate = txt.cjrsDisclosureConfirmation.f,
      htmlTemplate = html.cjrsDisclosureConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cjrsDisclosure_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Coronavirus Job Retention Scheme Overclaim Notification",
      plainTemplate = txt.cjrsDisclosureCode.f,
      htmlTemplate = html.cjrsDisclosureCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "creative_industries_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your creative industries tax relief application",
      plainTemplate = txt.creativeIndustriesConfirmation.f,
      htmlTemplate = html.creativeIndustriesConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "creative_industries_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Apply for creative industries tax relief for Corporation Tax",
      plainTemplate = txt.creativeIndustriesCode.f,
      htmlTemplate = html.creativeIndustriesCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "qahc_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = getQAHCDySub,
      plainTemplate = txt.qahcConfirmation.f,
      htmlTemplate = html.qahcConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "qahc_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Apply for creative industries tax relief for Corporation Tax",
      plainTemplate = txt.qahcCode.f,
      htmlTemplate = html.qahcCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "pods_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You requested a pension scheme tax refund from HMRC",
      plainTemplate = txt.podsConfirmation.f,
      htmlTemplate = html.podsConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "res1_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Apply for certification of residence",
      plainTemplate = txt.res1Code.f,
      htmlTemplate = html.res1Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "res1_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Certificate of residence - application received",
      plainTemplate = txt.res1Confirmation.f,
      htmlTemplate = html.res1Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "utt_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Notify HMRC about an uncertain tax treatment",
      plainTemplate = txt.uttCode.f,
      htmlTemplate = html.uttCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "utt_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your uncertain tax treatment notification",
      plainTemplate = txt.uttConfirmation.f,
      htmlTemplate = html.uttConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ppt_registration_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Register for plastic packaging tax",
      plainTemplate = txt.pptRegistrationCode.f,
      htmlTemplate = html.pptRegistrationCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ppt_registration_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your registration for plastic packaging tax",
      plainTemplate = txt.pptRegistrationConfirmation.f,
      htmlTemplate = html.pptRegistrationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ppt_enquiry_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Enquire about plastic packaging tax",
      plainTemplate = txt.pptEnquiryCode.f,
      htmlTemplate = html.pptEnquiryCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ppt_enquiry_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your plastic packaging tax query",
      plainTemplate = txt.pptEnquiryConfirmation.f,
      htmlTemplate = html.pptEnquiryConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "psa1_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Tell HMRC your annual PAYE Settlement Agreement amount",
      plainTemplate = txt.psa1Code.f,
      htmlTemplate = html.psa1Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "psa1_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "PAYE Settlement Agreement amount notification",
      plainTemplate = txt.psa1Confirmation.f,
      htmlTemplate = html.psa1Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "vat652_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Notification of errors in VAT returns - form received",
      plainTemplate = txt.vat652Confirmation.f,
      htmlTemplate = html.vat652Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "vat652_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Notification of errors in VAT returns",
      plainTemplate = txt.vat652Code.f,
      htmlTemplate = html.vat652Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ppt_return_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your plastic packaging tax return",
      plainTemplate = txt.pptReturnConfirmation.f,
      htmlTemplate = html.pptReturnConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ppt_request_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your plastic packaging tax repayment request",
      plainTemplate = txt.pptRequestConfirmation.f,
      htmlTemplate = html.pptRequestConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "venture_capital_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your Venture Capital Schemes application",
      plainTemplate = txt.ventureCapitalConfirmation.f,
      htmlTemplate = html.ventureCapitalConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "venture_capital_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Apply for Venture Capital Schemes (VCS) advance assurance",
      plainTemplate = txt.ventureCapitalCode.f,
      htmlTemplate = html.ventureCapitalCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "trusts_report_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your trust discrepancy report",
      plainTemplate = txt.trustsReportConfirmation.f,
      htmlTemplate = html.trustsReportConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "trusts_report_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Report a discrepancy in a trust",
      plainTemplate = txt.trustsReportCode.f,
      htmlTemplate = html.trustsReportCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "trusts_request_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your trust data request",
      plainTemplate = txt.trustsRequestConfirmation.f,
      htmlTemplate = html.trustsRequestConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "trusts_request_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Make a data request about a trust",
      plainTemplate = txt.trustsRequestCode.f,
      htmlTemplate = html.trustsRequestCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "chief_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your request for an extension for using CHIEF to make import declarations",
      plainTemplate = txt.chiefConfirmation.f,
      htmlTemplate = html.chiefConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "chief_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Ask for an extension for using CHIEF to make import declarations",
      plainTemplate = txt.chiefCode.f,
      htmlTemplate = html.chiefCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "fprc_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received supporting details for your VAT repayment claim",
      plainTemplate = txt.fprcConfirmation.f,
      htmlTemplate = html.fprcConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "gbEORI_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Update GB EORI details - application received",
      plainTemplate = txt.gbEORIConfirmation.f,
      htmlTemplate = html.gbEORIConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "gbCancelEORI_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Cancel GB EORI details - application received",
      plainTemplate = txt.gbCancelEORIConfirmation.f,
      htmlTemplate = html.gbCancelEORIConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "essPreNotification_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Your notification to HMRC about the use of a till system",
      plainTemplate = txt.essPreNotificationConfirmation.f,
      htmlTemplate = html.essPreNotificationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "essPreNotification_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Tell HMRC about using a till system to reduce your tax bill",
      plainTemplate = txt.essPreNotificationCode.f,
      htmlTemplate = html.essPreNotificationCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "essDisclosure_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received a disclosure about Electronic Sales Suppression",
      plainTemplate = txt.essDisclosureConfirmation.f,
      htmlTemplate = html.essDisclosureConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "essDisclosure_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Tell HMRC about the misuse of a till system to reduce tax",
      plainTemplate = txt.essDisclosureCode.f,
      htmlTemplate = html.essDisclosureCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "rndNotification_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You have notified HMRC about a future R&D tax claim",
      plainTemplate = txt.rndNotificationConfirmation.f,
      htmlTemplate = html.rndNotificationConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "rndNotification_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Notify HMRC about a research and development tax claim",
      plainTemplate = txt.rndNotificationCode.f,
      htmlTemplate = html.rndNotificationCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "mod_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC received your UK Armed Forces customs declaration notification",
      plainTemplate = txt.modConfirmation.f,
      htmlTemplate = html.modConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "mod_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Notify HMRC about a UK Armed Forces customs declaration",
      plainTemplate = txt.modCode.f,
      htmlTemplate = html.modCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "rndClaim_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC has your supporting information for an R&D tax claim",
      plainTemplate = txt.rndClaimConfirmation.f,
      htmlTemplate = html.rndClaimConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "rndClaim_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Support a research and development (R&D) tax claim",
      plainTemplate = txt.rndClaimCode.f,
      htmlTemplate = html.rndClaimCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "eis_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC has your EIS1 compliance statement",
      plainTemplate = txt.eisConfirmation.f,
      htmlTemplate = html.eisConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "eis_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Submit an Enterprise Investment Scheme compliance statement (EIS1) to HMRC",
      plainTemplate = txt.eisCode.f,
      htmlTemplate = html.eisCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "seis_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC has your SEIS1 compliance statement",
      plainTemplate = txt.seisConfirmation.f,
      htmlTemplate = html.seisConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "sdes_alert",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You have unprocessed SDES items",
      plainTemplate = txt.sdesAlert.f,
      htmlTemplate = html.sdesAlert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "seis_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Submit a Seed Enterprise Investment Scheme compliance statement (SEIS1) to HMRC",
      plainTemplate = txt.seisCode.f,
      htmlTemplate = html.seisCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ca3822_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You applied for a certificate to confirm an employee will pay National Insurance while working abroad",
      plainTemplate = txt.ca3822Confirmation.f,
      htmlTemplate = html.ca3822Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ca3822_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Apply for a certificate to confirm an employee will pay National Insurance while working abroad (CA3822)",
      plainTemplate = txt.ca3822Code.f,
      htmlTemplate = html.ca3822Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ho5_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC has received your RDCO return",
      plainTemplate = txt.ho5Confirmation.f,
      htmlTemplate = html.ho5Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "ho5_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Submit a return as a registered dealer in controlled oils (RDCO)",
      plainTemplate = txt.ho5Code.f,
      htmlTemplate = html.ho5Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cds_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC has received your query about using the Customs Declaration Service",
      plainTemplate = txt.cdsConfirmation.f,
      htmlTemplate = html.cdsConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cds_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject =
        "Confirm your email address - Report a problem submitting a declaration using the Customs Declaration Service",
      plainTemplate = txt.cdsCode.f,
      htmlTemplate = html.cdsCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "p626_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "HMRC has received your request to apply for, amend or cancel a PAYE settlement agreement",
      plainTemplate = txt.p626Confirmation.f,
      htmlTemplate = html.p626Confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "p626_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Apply for, amend or cancel a PAYE settlement agreement",
      plainTemplate = txt.p626Code.f,
      htmlTemplate = html.p626Code.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "p11d_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You have submitted a P11D to HMRC",
      plainTemplate = txt.p11dConfirmation.f,
      htmlTemplate = html.p11dConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "p11d_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Tell HMRC about changes to P11D expenses and benefits",
      plainTemplate = txt.p11dCode.f,
      htmlTemplate = html.p11dCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "p11db_confirmation",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "You have submitted a P11D(b) to HMRC",
      plainTemplate = txt.p11dbConfirmation.f,
      htmlTemplate = html.p11dbConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "p11db_code",
      fromAddress = govUkTeamAddress,
      service = Eeitt,
      subject = "Confirm your email address - Return of expenses and benefits - Employer declaration",
      plainTemplate = txt.p11dbCode.f,
      htmlTemplate = html.p11dbCode.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
