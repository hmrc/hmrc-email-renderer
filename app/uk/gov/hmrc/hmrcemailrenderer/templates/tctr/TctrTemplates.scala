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

package uk.gov.hmrc.hmrcemailrenderer.templates.tctr

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.TctrForms

object TctrTemplates {

  private val fromNoReplyVOA = FromAddress.noReply("Valuation Office Agency")
  private val fromNoReplyVOA_cy = FromAddress.noReply("Asiantaeth y Swyddfa Brisio")
  private val standardPriority = Some(MessagePriority.Standard)

  val tctrGroup = "TCTR"
  val tctr_submission_confirmation = "tctr_submission_confirmation"
  val tctr_vacant_submission_confirmation = "tctr_vacant_submission_confirmation"
  val tctr_connection_removed = "tctr_connection_removed"
  val tctr_connection_removed_cy = "tctr_connection_removed_cy"

  val tctrTemplates: Seq[MessageTemplate] = Seq(
    MessageTemplate.create(
      templateId = tctr_submission_confirmation,
      fromAddress = fromNoReplyVOA,
      service = TctrForms,
      subject = "Valuation Office Agency: We have received your business trade and cost information",
      plainTemplate = txt.tctr_submission_confirmation.f,
      htmlTemplate = html.tctr_submission_confirmation.f,
      priority = standardPriority
    ),
    MessageTemplate.create(
      templateId = tctr_vacant_submission_confirmation,
      fromAddress = fromNoReplyVOA,
      service = TctrForms,
      subject = "Valuation Office Agency: We have received your vacant property declaration",
      plainTemplate = txt.tctr_vacant_submission_confirmation.f,
      htmlTemplate = html.tctr_vacant_submission_confirmation.f,
      priority = standardPriority
    ),
    MessageTemplate.create(
      templateId = tctr_connection_removed,
      fromAddress = fromNoReplyVOA,
      service = TctrForms,
      subject = "Valuation Office Agency: You have removed your connection to a property",
      plainTemplate = txt.tctr_connection_removed.f,
      htmlTemplate = html.tctr_connection_removed.f,
      priority = standardPriority
    ),
    MessageTemplate.create(
      templateId = tctr_connection_removed_cy,
      fromAddress = fromNoReplyVOA_cy,
      service = TctrForms,
      subject = "Asiantaeth y Swyddfa Brisio: Rydych wedi dileu eich cysylltiad ag eiddo",
      plainTemplate = txt.tctr_connection_removed_cy.f,
      htmlTemplate = html.tctr_connection_removed_cy.f,
      priority = standardPriority
    )
  )

}
