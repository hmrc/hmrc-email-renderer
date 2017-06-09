/*
 * Copyright 2017 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.registeryourcompany

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.RegisterYourCompany

object RegisterYourCompanyTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "register_your_company_verification_email",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "Register your company: verify your email address",
      plainTemplate = txt.registerYourCompanyVerificationEmail.f,
      htmlTemplate = html.registerYourCompanyVerificationEmail.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "register_your_company_welcome_email",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "Register your company - Welcome",
      plainTemplate = txt.registerYourCompanyWelcomeEmail.f,
      htmlTemplate = html.registerYourCompanyWelcomeEmail.f)
    )
}
