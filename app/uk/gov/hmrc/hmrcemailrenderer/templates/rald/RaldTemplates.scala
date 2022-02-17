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

  val raldGroup = "RALD"
  val rald_connection_removed = "rald_connection_removed"
  val rald_connection_removed_cy = "rald_connection_removed_cy"

  private val fromNoReplyVOA = FromAddress.noReply("Valuation Office Agency")
  private val fromNoReplyVOA_cy = FromAddress.noReply("Asiantaeth y Swyddfa Brisio")
  private val fromRALD = FromAddress.noReply("Rent and Lease Details")
  private val standardPriority = Some(MessagePriority.Standard)

  val templates = Seq(
    MessageTemplate.create(
      templateId = "rald_alert",
      fromAddress = fromRALD,
      service = RentalAndLeaseDetails,
      subject = "Your saved Rent and Lease details expires in 90 days.",
      plainTemplate = txt.rald.f,
      htmlTemplate = html.rald.f
    ),
    MessageTemplate.create(
      templateId = "rald_not_connected",
      fromAddress = fromRALD,
      service = RentalAndLeaseDetails,
      subject = "RALD - Not connected to",
      plainTemplate = txt.raldNotConnected.f,
      htmlTemplate = html.raldNotConnected.f,
      priority = standardPriority
    ),
    MessageTemplate.create(
      templateId = "rald_submission_confirmation",
      fromAddress = fromRALD,
      service = RentalAndLeaseDetails,
      subject = "Valuation Office Agency received your form",
      plainTemplate = txt.raldConfirmation.f,
      htmlTemplate = html.raldConfirmation.f,
      priority = standardPriority
    ),
    MessageTemplate.create(
      templateId = rald_connection_removed,
      fromAddress = fromNoReplyVOA,
      service = RentalAndLeaseDetails,
      subject = "Valuation Office Agency: You have removed your connection to a property",
      plainTemplate = txt.rald_connection_removed.f,
      htmlTemplate = html.rald_connection_removed.f,
      priority = standardPriority
    ),
    MessageTemplate.create(
      templateId = rald_connection_removed_cy,
      fromAddress = fromNoReplyVOA_cy,
      service = RentalAndLeaseDetails,
      subject = "Asiantaeth y Swyddfa Brisio: Rydych wedi dileu eich cysylltiad ag eiddo",
      plainTemplate = txt.rald_connection_removed_cy.f,
      htmlTemplate = html.rald_connection_removed_cy.f,
      priority = standardPriority
    )
  )

}
