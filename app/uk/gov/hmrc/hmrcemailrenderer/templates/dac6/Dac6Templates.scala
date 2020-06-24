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

package uk.gov.hmrc.hmrcemailrenderer.templates.dac6

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DAC6


object Dac6Templates {
  val templates = Seq(

   //  UPLOAD - DISCLOSURE SUBMITTED
    MessageTemplate.create(
      templateId = "dac6_disclosure_submitted",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "HMRC received your DAC6 disclosure",
      plainTemplate = txt.dac6DisclosureSubmitted.f,
      htmlTemplate = html.dac6DisclosureSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),

    // UPLOAD - DISCLOSURE ADDITIONAL INFORMATION
    MessageTemplate.create(
      templateId = "dac6_disclosure_additional_information",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "HMRC received your additional information about a disclosure",
      plainTemplate = txt.dac6DisclosureAdditionalInformation.f,
      htmlTemplate = html.dac6DisclosureAdditionalInformation.f,
      priority = Some(MessagePriority.Urgent)
    ),

    // UPLOAD - DISCLOSURE DELETED
    MessageTemplate.create(
      templateId = "dac6_disclosure_deleted",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "You deleted disclosure",
      plainTemplate = txt.dac6DisclosureDeleted.f,
      htmlTemplate = html.dac6DisclosureDeleted.f,
      priority = Some(MessagePriority.Urgent)
    ),

    // UPLOAD - DISCLOSURE REPLACED
    MessageTemplate.create(
      templateId = "dac6_disclosure_replaced",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "You replaced disclosure" ,
      plainTemplate = txt.dac6DisclosureReplaced.f,
      htmlTemplate = html.dac6DisclosureReplaced.f,
      priority = Some(MessagePriority.Urgent)
    ),

    // REGISTRATION - REGISTRATION SUCCESSFUL
    MessageTemplate.create(
      templateId = "dac6_registration_successful",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "You have registered for the DAC6 service ",
      plainTemplate = txt.dac6RegistrationSuccessful.f,
      htmlTemplate = html.dac6RegistrationSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
