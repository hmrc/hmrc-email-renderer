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

package uk.gov.hmrc.hmrcemailrenderer.templates.euSubsidy

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.EUSubsidy

object EUSubsidyTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "create_undertaking_email_to_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You created a new single undertaking",
      plainTemplate = txt.createUndertakingEmailToLead.f,
      htmlTemplate = html.createUndertakingEmailToLead.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "undertaking_member_added_email_to_be",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You are now a member of a single undertaking",
      plainTemplate = txt.undertakingMemberAddedEmailToBE.f,
      htmlTemplate = html.undertakingMemberAddedEmailToBE.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "undertaking_member_added_email_to_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You have added a member to your single undertaking",
      plainTemplate = txt.undertakingMemberAddedEmailToLead.f,
      htmlTemplate = html.undertakingMemberAddedEmailToLead.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "undertaking_member_removed_email_to_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You have removed a member from your single undertaking",
      plainTemplate = txt.undertakingMemberRemovedEmailToLead.f,
      htmlTemplate = html.undertakingMemberRemovedEmailToLead.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "undertaking_member_removed_email_to_be",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You are removed from a single undertaking ",
      plainTemplate = txt.undertakingMemberRemovedEmailToBE.f,
      htmlTemplate = html.undertakingMemberRemovedEmailToBE.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "promoted_other_as_lead_email_to_be",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You are now undertaking administrator ",
      plainTemplate = txt.promotedOtherAsLeadEmailToBE.f,
      htmlTemplate = html.promotedOtherAsLeadEmailToBE.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "promoted_other_as_lead_email_to_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "Your status has changed and you are now an undertaking member",
      plainTemplate = txt.promotedOtherAsLeadEmailToLead.f,
      htmlTemplate = html.promotedOtherAsLeadEmailToLead.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "member_remove_themself_email_to_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You have removed yourself from a single undertaking",
      plainTemplate = txt.memberRemoveThemselfEmailToLead.f,
      htmlTemplate = html.memberRemoveThemselfEmailToLead.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "member_remove_themself_email_to_be",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You have asked to leave a single undertaking",
      plainTemplate = txt.memberRemoveThemselfEmailToBE.f,
      htmlTemplate = html.memberRemoveThemselfEmailToBE.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "promoted_themself_as_lead_email_to_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You are now undertaking administrator",
      plainTemplate = txt.promotedThemselfAsLeadEmailToLead.f,
      htmlTemplate = html.promotedThemselfAsLeadEmailToLead.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "removed_as_lead_email_to_previous_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You have changed from undertaking member to undertaking administrator",
      plainTemplate = txt.removedAsLeadEmailToPreviousLead.f,
      htmlTemplate = html.removedAsLeadEmailToPreviousLead.f,
      priority = Some(MessagePriority.Urgent)
    )
  )


}
