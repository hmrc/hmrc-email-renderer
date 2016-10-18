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

package uk.gov.hmrc.hmrcemailrenderer.templates.childcarecalculator

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.Childcare
import uk.gov.hmrc.hmrcemailrenderer.templates.{GovUkTemplate, TemplateGroup}

object childcareTemplates extends TemplateGroup with GovUkTemplate {
  val title = "ChildcareCalculator"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "childcare_registration_email",
      regime = Childcare,
      subject = "Registration of interest email",
      plainTemplate = txt.childcareRegistrationEmail.apply,
      htmlTemplate = html.childcareRegistrationEmail.apply,
      fromAddress = govUkTeamAddress)
  )
}
