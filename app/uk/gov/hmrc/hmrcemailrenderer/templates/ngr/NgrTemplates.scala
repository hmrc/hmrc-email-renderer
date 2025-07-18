/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.ngr

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.NgrNotify

object NgrTemplates {

  private val fromNoReplyVOA = FromAddress.noReply("Valuation Office Agency")
  private val standardPriority = Some(MessagePriority.Standard)

  val ngr_registration_successful = "ngr_registration_successful"
  val ngr_add_property_request_sent = "ngr_add_property_request_sent"

  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.create(
      templateId = ngr_registration_successful,
      fromAddress = fromNoReplyVOA,
      service = NgrNotify,
      subject = "Manage your business rates valuation – registration successful",
      plainTemplate = txt.ngr_registration_successful.f,
      htmlTemplate = html.ngr_registration_successful.f,
      priority = standardPriority
    ),
    MessageTemplate.create(
      templateId = ngr_add_property_request_sent,
      fromAddress = fromNoReplyVOA,
      service = NgrNotify,
      subject = "Add a property request sent",
      plainTemplate = txt.ngr_add_property_request_sent.f,
      htmlTemplate = html.ngr_add_property_request_sent.f,
      priority = standardPriority
    )
  )
}
