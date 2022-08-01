/*
 * Copyright 2022 HM Revenue & Customs
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
    )
  )

}
