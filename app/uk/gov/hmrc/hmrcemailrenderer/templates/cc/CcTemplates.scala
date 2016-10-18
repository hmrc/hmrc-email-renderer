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

package uk.gov.hmrc.hmrcemailrenderer.templates.cc

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.Childcare
import uk.gov.hmrc.hmrcemailrenderer.templates.{GovUkTemplate, TemplateGroup}

object CcTemplates extends TemplateGroup with GovUkTemplate {
  val title = "CC"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "cc_registration_email",
      regime = Childcare,
      subject = "Your interest in Tax-Free Childcare",
      plainTemplate = txt.ccRegistrationEmail.apply,
      htmlTemplate = html.ccRegistrationEmail.apply,
      fromAddress = govUkTeamAddress)
  )
}
