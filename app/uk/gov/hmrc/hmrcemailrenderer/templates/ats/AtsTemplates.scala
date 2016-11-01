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

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.AnnualTaxSummary

object AtsTemplates {

  private val ats_year_for_subject: Map[String, String] => String =
    _.get("taxYear").map(year => s"Your Annual Tax Summary for $year is now ready").
      getOrElse(throw new RuntimeException("Missing parameter taxYear"))

  val templates = Seq(
    MessageTemplate.create(
      templateId = "annual_tax_summaries_message_alert",
      fromAddress = FromAddress.noReply("HMRC Your Annual Tax Summary"),
      service = AnnualTaxSummary,
      subject = ats_year_for_subject,
      plainTemplate = txt.annualTaxSummariesMessageAlert.f,
      htmlTemplate = html.annualTaxSummariesMessageAlert.f,
      priority = MessagePriority.Background
    )
  )
}
