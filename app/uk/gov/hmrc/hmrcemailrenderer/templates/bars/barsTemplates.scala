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

package uk.gov.hmrc.hmrcemailrenderer.templates.bars

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.BusinessRates

object BarsTemplates  {

  private val getBARefCode: Map[String, String] => String =
    _.get("baRefNumber").getOrElse("No BA CODE")

  val templates = Seq(
    MessageTemplate.create(
      templateId = "bars_alert",
      fromAddress = "Business Rates <noreply@tax.service.gov.uk>",
      service = BusinessRates,
      subject = getBARefCode,
      plainTemplate = txt.bars.f,
      htmlTemplate = html.bars.f)
  )
}
