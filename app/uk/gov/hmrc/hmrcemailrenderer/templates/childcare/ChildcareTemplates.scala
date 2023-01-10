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

package uk.gov.hmrc.hmrcemailrenderer.templates.childcare

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Childcare

object ChildcareTemplates {

  val childcareAddress = "noreply@childcarechoices.tax.service.gov.uk"

  val templates = Seq(
    MessageTemplate.create(
      templateId = "cc_registration_email",
      fromAddress = govUkTeamAddress,
      service = Childcare,
      subject = "Your interest in Tax-Free Childcare",
      plainTemplate = txt.ccRegistrationEmail.f,
      htmlTemplate = html.ccRegistrationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "childcare_schemes_interest_email",
      fromAddress = govUkTeamAddress,
      service = Childcare,
      subject = "Your interest in new childcare support schemes",
      plainTemplate = txt.csiEmailRegistration.f,
      htmlTemplate = html.csiEmailRegistration.f
    ),
    MessageTemplate.create(
      templateId = "childcare_registration_email",
      fromAddress = govUkTeamAddress,
      service = Childcare,
      subject = "2017 Childcare support schemes",
      plainTemplate = txt.childcareRegistrationEmail.f,
      htmlTemplate = html.childcareRegistrationEmail.f
    ),
    MessageTemplate.create(
      templateId = "childcare_taxfree_england",
      fromAddress = childcareAddress,
      service = Childcare,
      subject = "Apply for Tax-Free Childcare today",
      plainTemplate = txt.childcareTaxFreeEngland.f,
      htmlTemplate = html.childcareTaxFreeEngland.f
    ),
    MessageTemplate.create(
      templateId = "childcare_taxfree_england_A",
      fromAddress = childcareAddress,
      service = Childcare,
      subject = "Apply for Tax-Free Childcare today",
      plainTemplate = txt.childcareTaxFreeEngland_A.f,
      htmlTemplate = html.childcareTaxFreeEngland_A.f
    ),
    MessageTemplate.create(
      templateId = "childcare_taxfree_england_B",
      fromAddress = childcareAddress,
      service = Childcare,
      subject = "Apply for 30 hours free childcare & Tax-Free Childcare today",
      plainTemplate = txt.childcareTaxFreeEngland_B.f,
      htmlTemplate = html.childcareTaxFreeEngland_B.f
    ),
    MessageTemplate.create(
      templateId = "childcare_taxfree_devolved",
      fromAddress = childcareAddress,
      service = Childcare,
      subject = "Apply for Tax-Free Childcare today",
      plainTemplate = txt.childcareTaxFreeDevolved.f,
      htmlTemplate = html.childcareTaxFreeDevolved.f
    ),
    MessageTemplate.create(
      templateId = "childcare_taxfree_devolved_A",
      fromAddress = childcareAddress,
      service = Childcare,
      subject = "Apply for Tax-Free Childcare today",
      plainTemplate = txt.childcareTaxFreeDevolved_A.f,
      htmlTemplate = html.childcareTaxFreeDevolved_A.f
    ),
    MessageTemplate.create(
      templateId = "childcare_taxfree_devolved_B",
      fromAddress = childcareAddress,
      service = Childcare,
      subject = "Apply for Tax-Free Childcare today",
      plainTemplate = txt.childcareTaxFreeDevolved_B.f,
      htmlTemplate = html.childcareTaxFreeDevolved_B.f
    )
  )
}
