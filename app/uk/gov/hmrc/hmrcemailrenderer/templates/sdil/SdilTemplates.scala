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

package uk.gov.hmrc.hmrcemailrenderer.templates.sdil

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SoftDrinksIndustryLevy

object SdilTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "sdil_registration_accepted",
      fromAddress = FromAddress.noReply("Soft Drinks Industry Levy"),
      service = SoftDrinksIndustryLevy,
      subject = "Soft Drinks Levy Reference Number",
      plainTemplate = txt.sdilRegistrationAccepted.f,
      htmlTemplate = html.sdilRegistrationAccepted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "sdil_registration_received",
      fromAddress = FromAddress.noReply("Soft Drinks Industry Levy"),
      service = SoftDrinksIndustryLevy,
      subject = "Soft Drinks Levy application submitted",
      plainTemplate = txt.sdilRegistrationReceived.f,
      htmlTemplate = html.sdilRegistrationReceived.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
