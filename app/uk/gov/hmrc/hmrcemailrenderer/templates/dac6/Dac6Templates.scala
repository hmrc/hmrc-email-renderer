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

package uk.gov.hmrc.hmrcemailrenderer.templates.dac6

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DAC6

object Dac6Templates {

  val templates = Seq(
    // REGISTRATION - REGISTRATION SUCCESSFUL
    MessageTemplate.create(
      templateId = "dac6_registration_successful",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "DAC6 registration successful",
      plainTemplate = txt.dac6RegistrationSuccessful.f,
      htmlTemplate = html.dac6RegistrationSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dac6_new_disclosure_confirmation",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "HMRC received your DAC6 disclosure",
      plainTemplate = txt.dac6NewDisclosureConfirmation.f,
      htmlTemplate = html.dac6NewDisclosureConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dac6_additional_disclosure_confirmation",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = "HMRC received your additional information about a disclosure",
      plainTemplate = txt.dac6AdditionalDisclosureConfirmation.f,
      htmlTemplate = html.dac6AdditionalDisclosureConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dac6_replace_disclosure_confirmation",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = params => s"You replaced disclosure ${params.apply("disclosureID")}",
      plainTemplate = txt.dac6ReplaceDisclosureConfirmation.f,
      htmlTemplate = html.dac6ReplaceDisclosureConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dac6_delete_disclosure_confirmation",
      fromAddress = govUkTeamAddress,
      service = DAC6,
      subject = params => s"You deleted disclosure ${params.apply("disclosureID")}",
      plainTemplate = txt.dac6DeleteDisclosureConfirmation.f,
      htmlTemplate = html.dac6DeleteDisclosureConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
