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

package uk.gov.hmrc.hmrcemailrenderer.templates.dst

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DigitalServicesTax

object DstTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "dst_registration_accepted",
      fromAddress = FromAddress.noReply("Digital Services Tax"),
      service = DigitalServicesTax,
      subject = "Digital Services Tax Reference Number",
      plainTemplate = txt.dstRegistrationAccepted.f,
      htmlTemplate = html.dstRegistrationAccepted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dst_registration_received",
      fromAddress = FromAddress.noReply("Digital Services Tax"),
      service = DigitalServicesTax,
      subject = "Digital Services Tax application submitted",
      plainTemplate = txt.dstRegistrationReceived.f,
      htmlTemplate = html.dstRegistrationReceived.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
