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

package uk.gov.hmrc.hmrcemailrenderer.templates.paye

import uk.gov.hmrc.email.services.{BodyTemplate, SimpleMessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.PayAsYouEarn
import uk.gov.hmrc.hmrcemailrenderer.templates._

object PayeTemplates extends TemplateGroup with GovUkTemplate {
  val title = "PAYE"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "tax_estimate_message_alert",
      regime = PayAsYouEarn,
      subject = "Your Income Tax estimate has changed",
      plainTemplate = txt.newTaxEstimateMessageAlert.apply,
      htmlTemplate = html.newTaxEstimateMessageAlert.apply,
      fromAddress = " HMRC Check your Income Tax service <noreply@tax.service.gov.uk>")
  )
}
