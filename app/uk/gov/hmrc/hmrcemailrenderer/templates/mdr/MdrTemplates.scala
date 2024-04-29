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

package uk.gov.hmrc.hmrcemailrenderer.templates.mdr

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.MDR

object MdrTemplates {
  val templates = Seq(
    // REGISTRATION - REGISTRATION SUCCESSFUL ORGANISATION
    MessageTemplate.create(
      templateId = "mdr_registration_successful_organisation",
      fromAddress = govUkTeamAddress,
      service = MDR,
      subject = "You have registered for Mandatory Disclosure Rules (MDR)",
      plainTemplate = txt.mdrRegistrationSuccessfulOrganisation.f,
      htmlTemplate = html.mdrRegistrationSuccessfulOrganisation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "mdr_registration_successful_individual",
      fromAddress = govUkTeamAddress,
      service = MDR,
      subject = "You have registered for Mandatory Disclosure Rules (MDR)",
      plainTemplate = txt.mdrRegistrationSuccessfulIndividual.f,
      htmlTemplate = html.mdrRegistrationSuccessfulIndividual.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "mdr_file_upload_successful",
      fromAddress = FromAddress.noReply("MDR@notifications.service.gov.uk"),
      service = MDR,
      subject = "Your file has passed checks for MDR",
      plainTemplate = txt.mdrFileUploadSuccessful.f,
      htmlTemplate = html.mdrFileUploadSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "mdr_file_upload_unsuccessful",
      fromAddress = FromAddress.noReply("MDR@notifications.service.gov.uk"),
      service = MDR,
      subject = "There is a problem with your file for MDR",
      plainTemplate = txt.mdrFileUploadUnsuccessful.f,
      htmlTemplate = html.mdrFileUploadUnsuccessful.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
