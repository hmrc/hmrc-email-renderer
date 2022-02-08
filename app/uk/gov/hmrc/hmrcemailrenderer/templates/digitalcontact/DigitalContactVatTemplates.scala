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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DigitalContactVat

object DigitalContactVatTemplates {
  val vatFromAddress = FromAddress.noReply("HMRC VAT")

  val templates = Seq(
    MessageTemplate.create(
      templateId = "newMessageAlert_VRT1214A",
      fromAddress = vatFromAddress,
      service = DigitalContactVat,
      subject = "New message about changes to your VAT business details",
      plainTemplate = txt.newMessageAlert_VRT1214A.f,
      htmlTemplate = html.newMessageAlert_VRT1214A.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_VRT1214C",
      fromAddress = vatFromAddress,
      service = DigitalContactVat,
      subject = "Your agent has made a change to your VAT business details",
      plainTemplate = txt.newMessageAlert_VRT1214C.f,
      htmlTemplate = html.newMessageAlert_VRT1214C.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_VRT12B",
      fromAddress = vatFromAddress,
      service = DigitalContactVat,
      subject = "Changes to your client’s VAT business details",
      plainTemplate = txt.newMessageAlert_VRT12B.f,
      htmlTemplate = html.newMessageAlert_VRT12B.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_VRT14B",
      fromAddress = vatFromAddress,
      service = DigitalContactVat,
      subject = "Changes to your client’s VAT business details",
      plainTemplate = txt.newMessageAlert_VRT14B.f,
      htmlTemplate = html.newMessageAlert_VRT14B.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_CC07C_SM11C",
      fromAddress = vatFromAddress,
      service = DigitalContactVat,
      subject = "Client opted out of Making Tax Digital for VAT",
      plainTemplate = txt.newMessageAlert_CC07C_SM11C.f,
      htmlTemplate = html.newMessageAlert_CC07C_SM11C.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
