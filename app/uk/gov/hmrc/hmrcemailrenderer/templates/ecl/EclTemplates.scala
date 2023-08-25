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

package uk.gov.hmrc.hmrcemailrenderer.templates.ecl

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.EconomicCrimeLevy

object EclTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "ecl_registration_submitted",
      fromAddress = FromAddress.noReply("Economic Crime Levy"),
      service = EconomicCrimeLevy,
      subject = "You have registered for the Economic Crime Levy",
      plainTemplate = txt.eclRegistrationSubmitted.f,
      htmlTemplate = html.eclRegistrationSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ecl_registration_submitted_cy",
      fromAddress = FromAddress.noReply("Ardoll Troseddau Economaidd"),
      service = EconomicCrimeLevy,
      subject = "Rydych wedi cofrestru ar gyfer yr Ardoll Troseddau Economaidd",
      plainTemplate = txt.eclRegistrationSubmitted_cy.f,
      htmlTemplate = html.eclRegistrationSubmitted_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ecl_registration_received",
      fromAddress = FromAddress.noReply("Economic Crime Levy"),
      service = EconomicCrimeLevy,
      subject = "Your Economic Crime Levy registration has been received",
      plainTemplate = txt.eclRegistrationReceived.f,
      htmlTemplate = html.eclRegistrationReceived.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ecl_registration_received_cy",
      fromAddress = FromAddress.noReply("Ardoll Troseddau Economaidd"),
      service = EconomicCrimeLevy,
      subject = "Mae’ch cofrestriad ar gyfer yr Ardoll Troseddau Economaidd wedi dod i law",
      plainTemplate = txt.eclRegistrationReceived_cy.f,
      htmlTemplate = html.eclRegistrationReceived_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ecl_return_submitted",
      fromAddress = FromAddress.noReply("Economic Crime Levy"),
      service = EconomicCrimeLevy,
      subject = "You submitted a return for the Economic Crime Levy",
      plainTemplate = txt.eclReturnSubmitted.f,
      htmlTemplate = html.eclReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ecl_nil_return_submitted",
      fromAddress = FromAddress.noReply("Economic Crime Levy"),
      service = EconomicCrimeLevy,
      subject = "You submitted a return for the Economic Crime Levy",
      plainTemplate = txt.eclNilReturnSubmitted.f,
      htmlTemplate = html.eclNilReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ecl_amend_return_submitted",
      fromAddress = FromAddress.noReply("Economic Crime Levy"),
      service = EconomicCrimeLevy,
      subject = "You amended a return for the Economic Crime Levy",
      plainTemplate = txt.eclAmendReturnSubmitted.f,
      htmlTemplate = html.eclAmendReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ecl_amend_registration_submitted",
      fromAddress = FromAddress.noReply("Economic Crime Levy"),
      service = EconomicCrimeLevy,
      subject = "You amended a registration for the Economic Crime Levy",
      plainTemplate = txt.eclAmendRegistrationSubmitted.f,
      htmlTemplate = html.eclAmendRegistrationSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
