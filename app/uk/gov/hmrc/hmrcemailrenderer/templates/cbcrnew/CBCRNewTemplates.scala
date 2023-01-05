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

package uk.gov.hmrc.hmrcemailrenderer.templates.cbcrnew

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CountryByCountryReportingNew

object CBCRNewTemplates {
  val templates = Seq(
    // REGISTRATION - REGISTRATION SUCCESSFUL ORGANISATION
    MessageTemplate.create(
      templateId = "cbc_registration_successful_organisation",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReportingNew,
      subject = "You have registered for country-by-country (CBC)",
      plainTemplate = txt.cbcRegistrationSuccessfulOrganisation.f,
      htmlTemplate = html.cbcRegistrationSuccessfulOrganisation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // FILEUPLOAD - FILE SENT FOR REVIEW
    MessageTemplate.create(
      templateId = "cbc_file_upload_successful",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReportingNew,
      subject = "Country-by-country (CBC) file sent for review",
      plainTemplate = txt.cbcFileUploadSuccessful.f,
      htmlTemplate = html.cbcFileUploadSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // FILEUPLOAD - FILE NOT ACCEPTED
    MessageTemplate.create(
      templateId = "cbc_file_upload_unsuccessful",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReportingNew,
      subject = "Country-by-country (CBC) file not accepted",
      plainTemplate = txt.cbcFileUploadUnsuccessful.f,
      htmlTemplate = html.cbcFileUploadUnsuccessful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // FILEUPLOAD - AGENT FILE ACCEPTED
    MessageTemplate.create(
      templateId = "cbc_agent_file_upload_successful",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReportingNew,
      subject = "Country-by-country (CBC) agent file accepted",
      plainTemplate = txt.cbcAgentFileUploadSuccessful.f,
      htmlTemplate = html.cbcAgentFileUploadSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // FILEUPLOAD - AGENT FILE NOT ACCEPTED
    MessageTemplate.create(
      templateId = "cbc_agent_file_upload_unsuccessful",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReportingNew,
      subject = "Country-by-country (CBC) agent file not accepted",
      plainTemplate = txt.cbcAgentFileUploadUnsuccessful.f,
      htmlTemplate = html.cbcAgentFileUploadUnsuccessful.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
