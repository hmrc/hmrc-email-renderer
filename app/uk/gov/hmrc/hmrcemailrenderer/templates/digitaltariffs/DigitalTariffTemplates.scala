/*
 * Copyright 2019 HM Revenue & Customs
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

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.BTIOperationalService

object DigitalTariffTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "digital_tariffs_case_completed",
      fromAddress = FromAddress.noReply("HMRC Tariff Classification Team"),
      service = BTIOperationalService,
      subject = "Binding Tariff Ruling issued",
      plainTemplate = txt.caseCompleted.f,
      htmlTemplate = html.caseCompleted.f,
      priority = Some(MessagePriority.Background)
    )
  )
}
