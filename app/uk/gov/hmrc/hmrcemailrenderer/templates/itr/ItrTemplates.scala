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

package uk.gov.hmrc.hmrcemailrenderer.templates.itr

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.InvestmentTaxRelief
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress

object ItrTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "investment_tax_relief_verification_email",
      fromAddress = govUkTeamAddress,
      service = InvestmentTaxRelief,
      subject = "Apply to use Venture Capital Schemes: verify your email address",
      plainTemplate = txt.itrEmailVerification.f,
      htmlTemplate = html.itrEmailVerification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "investment_tax_relief_confirmation_email",
      fromAddress = govUkTeamAddress,
      service = InvestmentTaxRelief,
      subject = "Apply to use Venture Capital Schemes: We’ve received your Advance Assurance application",
      plainTemplate = txt.itrEmailConfirmation.f,
      htmlTemplate = html.itrEmailConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "investment_tax_relief_no_docs_confirmation_email",
      fromAddress = govUkTeamAddress,
      service = InvestmentTaxRelief,
      subject = "Apply to use Venture Capital Schemes: We’ve received your Advance Assurance application",
      plainTemplate = txt.itrNoDocsEmailConfirmation.f,
      htmlTemplate = html.itrNoDocsEmailConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
