/*
 * Copyright 2021 HM Revenue & Customs
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

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PayAsYouEarn

object PayeTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "tax_estimate_message_alert",
      fromAddress = FromAddress.noReply("HMRC Check your Income Tax service"),
      service = PayAsYouEarn,
      subject = "Check your PAYE code change online",
      plainTemplate = txt.newTaxEstimateMessageAlert.f,
      htmlTemplate = html.newTaxEstimateMessageAlert.f
    ),
    MessageTemplate.create(
      templateId = "tax_estimate_message_alert_cy",
      fromAddress = FromAddress.noReply("CThEM – Gwasanaeth Gwirio eich Treth Incwm"),
      service = PayAsYouEarn,
      subject = "Gwirio newid i’ch cod TWE ar-lein",
      plainTemplate = txt.taxEstimateMessageAlert_cy.f,
      htmlTemplate = html.taxEstimateMessageAlert_cy.f
    )
  )
}
