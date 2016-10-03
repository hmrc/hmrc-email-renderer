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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessageTemplate, TemplateGroup}
import uk.gov.hmrc.hmrcemailrenderer.templates.Service.SelfAssessment

object DigitalContactTemplates extends TemplateGroup {
  override val title = "Self Assessment"

  val defaultFromAddress = "HMRC paperless <noreply@tax.service.gov.uk>"

  override val templates  = Seq(
    MessageTemplate(
      templateId = "verifyEmailAddress",
      fromAddress = defaultFromAddress,
      service = SelfAssessment,
      subject = "HMRC paperless notifications: verify your email address",
      plainTemplate = txt.verifyEmailAddress.apply,
      htmlTemplate = html.verifyEmailAddress.apply
    )
  )
}
