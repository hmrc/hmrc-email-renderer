/*
 * Copyright 2022 HM Revenue & Customs
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
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.BusinessRates

object BarsTemplates {

  private val getBARefCode: Map[String, String] => String =
    _.getOrElse("baRefNumber", "No BA CODE")

  val templates = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "bars_alert",
      fromAddress = FromAddress.noReply("Business Rates"),
      service = BusinessRates,
      subject = getBARefCode,
      plainTemplate = txt.bars.f,
      htmlTemplate = html.bars.f
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "bars_alert_transaction",
      fromAddress = FromAddress.noReply("Business Rates"),
      service = BusinessRates,
      subject = getBARefCode,
      plainTemplate = txt.barsTransaction.f,
      htmlTemplate = html.barsTransaction.f
    )
  )
}
