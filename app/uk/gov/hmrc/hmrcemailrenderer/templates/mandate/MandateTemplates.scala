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

package uk.gov.hmrc.hmrcemailrenderer.templates.mandate

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Mandate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress

object MandateTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "client_approves_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "A client has requested you to act as their agent",
      plainTemplate = txt.mandateClientApproves.f,
      htmlTemplate = html.mandateClientApproves.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_activates_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "Your agent has now accepted your request",
      plainTemplate = txt.mandateAgentActivates.f,
      htmlTemplate = html.mandateAgentActivates.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_rejects_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "Your agent has rejected your request",
      plainTemplate = txt.mandateAgentRejects.f,
      htmlTemplate = html.mandateAgentRejects.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_removes_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "Your agent removed you as a client",
      plainTemplate = txt.mandateAgentRemoves.f,
      htmlTemplate = html.mandateAgentRemoves.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "client_removes_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "A client has cancelled your request",
      plainTemplate = txt.mandateClientRemoves.f,
      htmlTemplate = html.mandateClientRemoves.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "client_cancels_active_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "A client has cancelled your authority",
      plainTemplate = txt.mandateClientCancelsActive.f,
      htmlTemplate = html.mandateClientCancelsActive.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_self_auth_activates_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "You have added your client",
      plainTemplate = txt.mandateAgentSelfAuthAdds.f,
      htmlTemplate = html.mandateAgentSelfAuthAdds.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_self_auth_deactivates_mandate",
      fromAddress = govUkTeamAddress,
      service = Mandate,
      subject = "You have removed your client",
      plainTemplate = txt.mandateAgentSelfAuthRemoves.f,
      htmlTemplate = html.mandateAgentSelfAuthRemoves.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
