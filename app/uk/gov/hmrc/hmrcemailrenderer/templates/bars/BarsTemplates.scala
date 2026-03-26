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

package uk.gov.hmrc.hmrcemailrenderer.templates.bars

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.BusinessRates

object BarsTemplates:

  private val fromBARS = FromAddress.noReply("Business Rates")
  val barsGroup = "BARS"
  val bars_alert = "bars_alert"
  val bars_alert_transaction = "bars_alert_transaction"

  private val getBARefCode: Map[String, String] => String =
    _.getOrElse("baRefNumber", "No BA CODE")

  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = bars_alert,
      fromAddress = fromBARS,
      service = BusinessRates,
      subject = getBARefCode,
      plainTemplate = txt.bars.f,
      htmlTemplate = html.bars.f
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = bars_alert_transaction,
      fromAddress = fromBARS,
      service = BusinessRates,
      subject = getBARefCode,
      plainTemplate = txt.barsTransaction.f,
      htmlTemplate = html.barsTransaction.f
    )
  )
