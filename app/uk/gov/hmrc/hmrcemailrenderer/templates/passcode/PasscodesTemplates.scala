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

package uk.gov.hmrc.hmrcemailrenderer.templates.passcode

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier._

object PasscodesTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "cato_access_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = CompanyAccountsTaxOnline,
      subject = "A new method of filing your Accounts and Company Tax Return",
      plainTemplate = txt.catoVerificationEmail.f,
      htmlTemplate = html.catoVerificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agents_opt_in_exclude_template_id",
      fromAddress = govUkTeamAddress,
      service = AgentOptInExclude,
      subject = "Switch back from Agent Services to the original HMRC online services",
      plainTemplate = txt.agentOptInExcludeEmail.f,
      htmlTemplate = html.agentOptInExcludeEmail.f
    ),
    MessageTemplate.create(
      templateId = "agents_opt_in_rejoin_template_id",
      fromAddress = govUkTeamAddress,
      service = AgentOptInRejoin,
      subject = "Rejoin the new Agent Services from HMRC",
      plainTemplate = txt.agentOptInRejoinEmail.f,
      htmlTemplate = html.agentOptInRejoinEmail.f
    ),
    MessageTemplate.create(
      templateId = "agents_access_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = Agent,
      subject = "Invite: Test and view your clients’ PAYE for employers accounts",
      plainTemplate = txt.agentVerificationEmail.f,
      htmlTemplate = html.agentVerificationEmail.f
    ),
    MessageTemplate.create(
      templateId = "agent_mapping_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = Agent,
      subject = "Your HMRC service test link - adding existing Self Assessment clients to an Agent Services account",
      plainTemplate = txt.agentMappingInvitation.f,
      htmlTemplate = html.agentMappingInvitation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_subscription_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = Agent,
      subject = "Your HMRC service test link - creating an Agent Services Account",
      plainTemplate = txt.agentSubscriptionInvitation.f,
      htmlTemplate = html.agentSubscriptionInvitation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "agent_fi_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = Agent,
      subject = "Your HMRC agent services link to view client records",
      plainTemplate = txt.agentForIndividualsInvitation.f,
      htmlTemplate = html.agentForIndividualsInvitation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "generic_access_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = Generic,
      subject = "Your HMRC service test link",
      plainTemplate = txt.genericVerificationEmail.f,
      htmlTemplate = html.genericVerificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "iht_access_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = InheritanceTax,
      subject = "How to access HMRC’s Inheritance Tax Online service",
      plainTemplate = txt.ihtVerificationEmail.f,
      htmlTemplate = html.ihtVerificationEmail.f
    ),
    MessageTemplate.create(
      templateId = "tamc_access_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = TaxAllowanceForMarriedCouples,
      subject = "Your HMRC Marriage Allowance link",
      plainTemplate = txt.tamcVerificationEmail.f,
      htmlTemplate = html.tamcVerificationEmail.f
    ),
    MessageTemplate.create(
      templateId = "gmp_access_invitation_template_id",
      fromAddress = govUkTeamAddress,
      service = GuaranteedMinimumPension,
      subject = "Your check a GMP link",
      plainTemplate = txt.gmpVerificationEmail.f,
      htmlTemplate = html.gmpVerificationEmail.f
    ),
    MessageTemplate.create(
      templateId = "cgtpd_private_beta_access",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "How to start the trial of the new ‘Report and pay Capital Gains Tax on UK property service’",
      plainTemplate = txt.cgtpdPrivateBetaAccess.f,
      htmlTemplate = html.cgtpdPrivateBetaAccess.f
    )
  )
}
