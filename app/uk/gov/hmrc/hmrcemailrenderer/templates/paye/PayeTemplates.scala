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

package uk.gov.hmrc.hmrcemailrenderer.templates.paye

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PayAsYouEarn
import uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact.DigitalContactTemplates.{ defaultFromAddress, defaultFromAddressWelsh }

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
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_P800",
      fromAddress = defaultFromAddress,
      service = PayAsYouEarn,
      subject = "Your new tax calculation from HMRC is ready",
      plainTemplate = txt.newMessageAlert_P800.f,
      htmlTemplate = html.newMessageAlert_P800.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_P800_cy",
      fromAddress = defaultFromAddressWelsh,
      service = PayAsYouEarn,
      subject = "Mae’ch cyfrifiad treth newydd gan CThEM yn barod",
      plainTemplate = txt.newMessageAlert_P800_cy.f,
      htmlTemplate = html.newMessageAlert_P800_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    // DC-3393 Duplicate of newMessageAlert_P800 template id - that is used for D2 nudge email
    MessageTemplate.create(
      templateId = "newMessageAlert_P800_D2",
      fromAddress = defaultFromAddress,
      service = PayAsYouEarn,
      subject = "Your new tax calculation from HMRC is ready",
      plainTemplate = txt.newMessageAlert_P800.f,
      htmlTemplate = html.newMessageAlert_P800.f,
      priority = Some(MessagePriority.Standard)
    ),
    // DC-3393 Duplicate of newMessageAlert_P800_cy template id - that is used for D1 nudge email
    MessageTemplate.create(
      templateId = "newMessageAlert_P800_D2_cy",
      fromAddress = defaultFromAddressWelsh,
      service = PayAsYouEarn,
      subject = "Mae’ch cyfrifiad treth newydd gan CThEM yn barod",
      plainTemplate = txt.newMessageAlert_P800_cy.f,
      htmlTemplate = html.newMessageAlert_P800_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_PA302",
      fromAddress = defaultFromAddress,
      service = PayAsYouEarn,
      subject = "Your new tax calculation from HMRC is ready",
      plainTemplate = txt.newMessageAlert_PA302.f,
      htmlTemplate = html.newMessageAlert_PA302.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_PA302_cy",
      fromAddress = defaultFromAddressWelsh,
      service = PayAsYouEarn,
      subject = "Mae’ch cyfrifiad treth newydd gan CThEM yn barod",
      plainTemplate = txt.newMessageAlert_PA302_cy.f,
      htmlTemplate = html.newMessageAlert_PA302_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    // DC-3393 Duplicate of newMessageAlert_PA302 template id - that is used for D2 nudge email
    MessageTemplate.create(
      templateId = "newMessageAlert_PA302_D2",
      fromAddress = defaultFromAddress,
      service = PayAsYouEarn,
      subject = "Your new tax calculation from HMRC is ready",
      plainTemplate = txt.newMessageAlert_PA302.f,
      htmlTemplate = html.newMessageAlert_PA302.f,
      priority = Some(MessagePriority.Standard)
    ),
    // DC-3393 Duplicate of newMessageAlert_PA302_cy template id - that is used for D1 nudge email
    MessageTemplate.create(
      templateId = "newMessageAlert_PA302_D2_cy",
      fromAddress = defaultFromAddressWelsh,
      service = PayAsYouEarn,
      subject = "Mae’ch cyfrifiad treth newydd gan CThEM yn barod",
      plainTemplate = txt.newMessageAlert_PA302_cy.f,
      htmlTemplate = html.newMessageAlert_PA302_cy.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
