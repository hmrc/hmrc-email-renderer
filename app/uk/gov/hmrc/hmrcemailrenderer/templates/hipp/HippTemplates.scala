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

package uk.gov.hmrc.hmrcemailrenderer.templates.hipp

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Hipp

object HippTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "hipp_add_team_member_to_app_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "You have been added to an application in The Integration Hub",
      plainTemplate = txt.AddTeamMemberToApp.f,
      htmlTemplate = html.AddTeamMemberToApp.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_add_team_member_to_team_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "You have been added to a team in The Integration Hub",
      plainTemplate = txt.AddTeamMemberToTeam.f,
      htmlTemplate = html.AddTeamMemberToTeam.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_remove_team_member_from_app_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "You have been removed from an application in The Integration Hub",
      plainTemplate = txt.RemoveTeamMember.f,
      htmlTemplate = html.RemoveTeamMember.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_application_created",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "You have created an application in The Integration Hub",
      plainTemplate = txt.ApplicationCreated.f,
      htmlTemplate = html.ApplicationCreated.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_application_deleted",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "You have deleted an application from The Integration Hub",
      plainTemplate = txt.ApplicationDeleted.f,
      htmlTemplate = html.ApplicationDeleted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_application_deleted_team",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "Application deleted from The Integration Hub",
      plainTemplate = txt.ApplicationDeletedTeam.f,
      htmlTemplate = html.ApplicationDeletedTeam.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_production_access_approved_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "Your production access request has been approved",
      plainTemplate = txt.ProductionAccessRequestApproved.f,
      htmlTemplate = html.ProductionAccessRequestApproved.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_production_access_rejected_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "Your production access request has been rejected",
      plainTemplate = txt.ProductionAccessRequestRejected.f,
      htmlTemplate = html.ProductionAccessRequestRejected.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_new_production_access_request_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "A new production access request has been submitted for your review",
      plainTemplate = txt.NewProductionAccessRequest.f,
      htmlTemplate = html.NewProductionAccessRequest.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_production_access_request_submitted_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "Your production access request was successfully submitted",
      plainTemplate = txt.ProductionAccessRequestSubmitted.f,
      htmlTemplate = html.ProductionAccessRequestSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_api_ownership_added_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "There has been a change of API ownership",
      plainTemplate = txt.ApiOwnershipAdded.f,
      htmlTemplate = html.ApiOwnershipAdded.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hipp_api_ownership_removed_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Hipp,
      subject = "There has been a change of API ownership",
      plainTemplate = txt.ApiOwnershipRemoved.f,
      htmlTemplate = html.ApiOwnershipRemoved.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
