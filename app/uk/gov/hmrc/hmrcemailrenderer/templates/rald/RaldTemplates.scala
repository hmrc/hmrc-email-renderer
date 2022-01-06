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

package uk.gov.hmrc.hmrcemailrenderer.templates.rald

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.RentalAndLeaseDetails

object RaldTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "rald_alert",
      fromAddress = FromAddress.noReply("Rent and Lease Details"),
      service = RentalAndLeaseDetails,
      subject = "Your saved Rent and Lease details expires in 90 days.",
      plainTemplate = txt.rald.f,
      htmlTemplate = html.rald.f
    ),
    MessageTemplate.create(
      templateId = "rald_not_connected",
      fromAddress = FromAddress.noReply("Rent and Lease Details"),
      service = RentalAndLeaseDetails,
      subject = "RALD - Not connected to",
      plainTemplate = txt.raldNotConnected.f,
      htmlTemplate = html.raldNotConnected.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "rald_submission_confirmation",
      fromAddress = FromAddress.noReply("Rent and Lease Details"),
      service = RentalAndLeaseDetails,
      subject = "Valuation Office Agency received your form",
      plainTemplate = txt.raldConfirmation.f,
      htmlTemplate = html.raldConfirmation.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
