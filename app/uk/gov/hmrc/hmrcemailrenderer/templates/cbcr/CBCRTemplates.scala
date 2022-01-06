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

package uk.gov.hmrc.hmrcemailrenderer.templates.cbcr

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CountryByCountryReporting

object CBCRTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "cbcr_subscription",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReporting,
      subject = "Confirmation of your country-by-country registration ID",
      plainTemplate = txt.cbcrCbcIDReceived.f,
      htmlTemplate = html.cbcrCbcIDReceived.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cbcr_report_confirmation",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReporting,
      subject = "Confirmation that your country-by-country report has been received",
      plainTemplate = txt.cbcrSubmissionConfirmation.f,
      htmlTemplate = html.cbcrSubmissionConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cbcr_cbcid_regeneration",
      fromAddress = govUkTeamAddress,
      service = CountryByCountryReporting,
      subject = "Your new country-by-country ID",
      plainTemplate = txt.cbcrIdRegeneration.f,
      htmlTemplate = html.cbcrIdRegeneration.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
