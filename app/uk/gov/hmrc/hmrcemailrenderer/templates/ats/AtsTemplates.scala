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

package uk.gov.hmrc.hmrcemailrenderer.templates.ats

import uk.gov.hmrc.email.services.BodyTemplate.{Params, Subject}
import uk.gov.hmrc.email.services.{MissingTemplateParameterException, SimpleMessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.{TemplateGroup, GovUkTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.AnnualTaxSummary

object AtsTemplates extends {
  val title = "ATS"

  private def ats_year_for_subject(params : Params) =
    params.get("taxYear").map(year => s"Your Annual Tax Summary for $year is now ready").getOrElse(throw new MissingTemplateParameterException("taxYear"))

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "annual_tax_summaries_message_alert",
      regime = AnnualTaxSummary,
      subject = Subject(ats_year_for_subject),
      plainTemplate = txt.annualTaxSummariesMessageAlert.apply,
      htmlTemplate = html.annualTaxSummariesMessageAlert.apply,
      fromAddress = " HMRC Your Annual Tax Summary <noreply@tax.service.gov.uk>")
  )
}
