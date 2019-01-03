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

package uk.gov.hmrc.hmrcemailrenderer.templates.emachelpdesk

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.EmacHelpdesk

object EmacHelpdeskTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "emac_helpdesk_failure_confirmation_email",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "You've submitted a document to HMRC",
      plainTemplate = txt.emacHelpdeskFailureConfirmationEmail.f,
      htmlTemplate = html.emacHelpdeskFailureConfirmationEmail.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "emac_helpdesk_successful_confirmation_email",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "You've submitted a document to HMRC",
      plainTemplate = txt.emacHelpdeskSuccessfulConfirmationEmail.f,
      htmlTemplate = html.emacHelpdeskSuccessfulConfirmationEmail.f,
      priority = Some(MessagePriority.Urgent))
  )
}
