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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitaltariffs

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.{ BTIAdviceService, BTIApplicationService, BTIOperationalService }

object DigitalTariffTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "digital_tariffs_application_submitted",
      fromAddress = FromAddress.noReply("HMRC Tariff Classification Team"),
      service = BTIApplicationService,
      subject = "HMRC received your Advance Tariff Ruling (ATaR) application",
      plainTemplate = txt.applicationSubmitted.f,
      htmlTemplate = html.applicationSubmitted.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "digital_tariffs_case_completed",
      fromAddress = FromAddress.noReply("HMRC Tariff Classification Team"),
      service = BTIOperationalService,
      subject = params => s"Issued: Advance Tariff Ruling for ${params("reference")}",
      plainTemplate = txt.caseCompleted.f,
      htmlTemplate = html.caseCompleted.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "digital_tariffs_advice_request",
      fromAddress = FromAddress.noReply("HMRC Tariff Classification Team"),
      service = BTIAdviceService,
      subject = params => s"${params("reference")}: ${params("itemName")}",
      plainTemplate = txt.adviceRequest.f,
      htmlTemplate = html.adviceRequest.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "digital_tariffs_application_submitted_cy",
      fromAddress = FromAddress.noReply("Tîm Dosbarthu Tariffau CThEF"),
      service = BTIApplicationService,
      subject = "Mae’ch cais am Ddyfarniad Tariffau Uwch (ATaR) wedi dod i law CThEF",
      plainTemplate = txt.applicationSubmitted_cy.f,
      htmlTemplate = html.applicationSubmitted_cy.f,
      priority = Some(MessagePriority.Background)
    )
  )
}
