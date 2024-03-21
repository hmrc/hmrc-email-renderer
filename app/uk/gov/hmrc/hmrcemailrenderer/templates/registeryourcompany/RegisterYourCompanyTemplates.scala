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

package uk.gov.hmrc.hmrcemailrenderer.templates.registeryourcompany

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.RegisterYourCompany

object RegisterYourCompanyTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "register_your_company_verification_email",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "Confirm your email address - Set up a limited company and register for Corporation Tax service",
      plainTemplate = txt.registerYourCompanyVerificationEmail.f,
      htmlTemplate = html.registerYourCompanyVerificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "register_your_company_verification_email_cy",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject =
        "Cadarnhewch eich cyfeiriad e-bost – y gwasanaeth Sefydlu cwmni cyfyngedig a chofrestru ar gyfer Treth Gorfforaeth",
      plainTemplate = txt.registerYourCompanyVerificationEmail_cy.f,
      htmlTemplate = html.registerYourCompanyVerificationEmail_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_vat_email",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "Register for VAT online - new service",
      plainTemplate = txt.registerYourCompanyRegisterVATEmail.f,
      htmlTemplate = html.registerYourCompanyRegisterVATEmail.f
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_vat_email_cy",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "Cofrestrwch ar gyfer TAW ar-lein – gwasanaeth newydd",
      plainTemplate = txt.registerYourCompanyRegisterVATEmail_cy.f,
      htmlTemplate = html.registerYourCompanyRegisterVATEmail_cy.f
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_vat_email_v2",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "Register for VAT online - new service",
      plainTemplate = txt.registerYourCompanyRegisterVATEmailV2.f,
      htmlTemplate = html.registerYourCompanyRegisterVATEmailV2.f
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_vat_email_v2_cy",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "Cofrestrwch ar gyfer TAW ar-lein – gwasanaeth newydd",
      plainTemplate = txt.registerYourCompanyRegisterVATEmailV2_cy.f,
      htmlTemplate = html.registerYourCompanyRegisterVATEmailV2_cy.f
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_paye_confirmation_new_tax_year_v2",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "'Register an employer for PAYE' - application received",
      plainTemplate = txt.registerYourCompanyRegisterPAYEConfirmationNewTaxYearV2.f,
      htmlTemplate = html.registerYourCompanyRegisterPAYEConfirmationNewTaxYearV2.f
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_paye_confirmation_new_tax_year_v2_cy",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "'Cofrestru cyflogwr ar gyfer TWE – mae’r cais wedi dod i law",
      plainTemplate = txt.registerYourCompanyRegisterPAYEConfirmationNewTaxYearV2_cy.f,
      htmlTemplate = html.registerYourCompanyRegisterPAYEConfirmationNewTaxYearV2_cy.f
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_paye_confirmation_current_tax_year_v2",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "'Register an employer for PAYE' - application received",
      plainTemplate = txt.registerYourCompanyRegisterPAYEConfirmationV2.f,
      htmlTemplate = html.registerYourCompanyRegisterPAYEConfirmationV2.f
    ),
    MessageTemplate.create(
      templateId = "register_your_company_register_paye_confirmation_current_tax_year_v2_cy",
      fromAddress = FromAddress.govUkTeamAddress,
      service = RegisterYourCompany,
      subject = "'Cofrestru cyflogwr ar gyfer TWE – mae’r cais wedi dod i law",
      plainTemplate = txt.registerYourCompanyRegisterPAYEConfirmationV2_cy.f,
      htmlTemplate = html.registerYourCompanyRegisterPAYEConfirmationV2_cy.f
    )
  )
}
