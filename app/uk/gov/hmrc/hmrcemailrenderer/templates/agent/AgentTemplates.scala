/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.agent

import uk.gov.hmrc.hmrcemailrenderer.domain
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Agent

object AgentTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "overseas_application_rejected",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC rejected your agent services account application",
      plainTemplate = txt.overseas_application_rejected.f,
      htmlTemplate = html.overseas_application_rejected.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "overseas_application_accepted",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC approved your agent services account application",
      plainTemplate = txt.overseas_application_accepted.f,
      htmlTemplate = html.overseas_application_accepted.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "overseas_application_received",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC received your agent services account application",
      plainTemplate = txt.overseas_application_received.f,
      htmlTemplate = html.overseas_application_received.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "client_rejected_authorisation_request",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC: Client declined your authorisation request",
      plainTemplate = txt.client_rejected_authorisation_request.f,
      htmlTemplate = html.client_rejected_authorisation_request.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "client_accepted_authorisation_request",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC: Client accepted your authorisation request",
      plainTemplate = txt.client_accepted_authorisation_request.f,
      htmlTemplate = html.client_accepted_authorisation_request.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "client_expired_authorisation_request",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC: Your authorisation request expired",
      plainTemplate = txt.client_expired_authorisation_request.f,
      htmlTemplate = html.client_expired_authorisation_request.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_services_account_created",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC: agent services account created",
      plainTemplate = txt.agent_services_account_created.f,
      htmlTemplate = html.agent_services_account_created.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_services_account_created_cy",
      fromAddress = FromAddress.noReply("Gwasanaethau Asiant CThEM"),
      service = Agent,
      subject = "Cyfrif gwasanaethau asiant CThEM wedi’i greu",
      plainTemplate = txt.agent_services_account_created_cy.f,
      htmlTemplate = html.agent_services_account_created_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_invitation_about_to_expire_single",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "Reminder: authorisation request will expire in 5 days",
      plainTemplate = txt.agent_invitation_about_to_expire_single.f,
      htmlTemplate = html.agent_invitation_about_to_expire_single.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "agent_invitations_about_to_expire",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "Reminder: authorisation requests will expire in 5 days",
      plainTemplate = txt.agent_invitations_about_to_expire.f,
      htmlTemplate = html.agent_invitations_about_to_expire.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
