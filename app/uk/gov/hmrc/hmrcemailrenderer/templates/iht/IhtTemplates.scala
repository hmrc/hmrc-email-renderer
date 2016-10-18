/*
 * Copyright 2016 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.iht

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.InheritanceTax
object IhtTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "iht_access_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = InheritanceTax,
      subject = "How to access HMRC’s Inheritance Tax Online service",
      plainTemplate = txt.ihtVerificationEmail.f,
      htmlTemplate = html.ihtVerificationEmail.f)
  )
}
