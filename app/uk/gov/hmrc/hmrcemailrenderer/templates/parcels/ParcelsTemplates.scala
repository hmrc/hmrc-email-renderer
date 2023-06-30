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

package uk.gov.hmrc.hmrcemailrenderer.templates.parcels

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Parcels

object ParcelsTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "parcels_registration_confirmation",
      fromAddress = FromAddress.noReply("HMRC import VAT on parcels service"),
      service = Parcels,
      subject = "HMRC received your parcels import VAT registration",
      plainTemplate = txt.parcelsRegistered.f,
      htmlTemplate = html.parcelsRegistered.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
