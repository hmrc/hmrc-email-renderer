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

package uk.gov.hmrc.hmrcemailrenderer.templates.dfs

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DigitalFormsService
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress

object DfsTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "dfs_submission_success_r39_2015",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "R39: Claim a Tax Refund submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmail.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_submission_success_r39_2015_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "R39: Claim a Tax Refund submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmail_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmail_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_submission_success_cis_2015",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "Subcontractor registration submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailCIS.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailCIS.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_submission_success_cis_2015_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "Subcontractor registration submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailCIS_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailCIS_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_submission_success_sptu_2015",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "State Pension top up (Class3A) submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailSPTU.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailSPTU.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_submission_success_sptu_2015_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "State Pension top up (Class3A) submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailSPTU_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailSPTU_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_generic_2015",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailGeneric.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailGeneric.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_generic_2015_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailGeneric_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailGeneric_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_generic_2017",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailGeneric3Paragraphs.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailGeneric3Paragraphs.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_generic_2017_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailGeneric3Paragraphs_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailGeneric3Paragraphs_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_empty_turn_around_time_2015",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailEmptyTurnAroundTime.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailEmptyTurnAroundTime.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_empty_turn_around_time_2015_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailEmptyTurnAroundTime_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailEmptyTurnAroundTime_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_empty_turn_around_time_2020",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailGeneric4ParagraphsEmptyTurnAroundTime.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailGeneric4ParagraphsEmptyTurnAroundTime.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_admin_notification",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "You’ve got a new message from HMRC Child Benefit admin",
      plainTemplate = txt.dfsAdminNotificationEmail.f,
      htmlTemplate = html.dfsAdminNotificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_admin_notification_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "You’ve got a new message from HMRC Child Benefit admin",
      plainTemplate = txt.dfsAdminNotificationEmail_welsh.f,
      htmlTemplate = html.dfsAdminNotificationEmail_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_trusts_submission_success",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsTrustsSubmissionConfirmationEmail.f,
      htmlTemplate = html.dfsTrustsSubmissionConfirmationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_trusts_submission_success_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsTrustsSubmissionConfirmationEmail_welsh.f,
      htmlTemplate = html.dfsTrustsSubmissionConfirmationEmail_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_submission_success_rcgt_2018",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "Capital Gains Tax real time transaction return submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailRCGT.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailRCGT.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dfs_submission_success_rcgt_2018_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "Capital Gains Tax real time transaction return submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailRCGT_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailRCGT_welsh.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_gencompsub_2021",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailGENCOMPSUB.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailGENCOMPSUB.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "dfs_submission_success_gencompsub_2021_welsh",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = _.apply("subject"),
      plainTemplate = txt.dfsSubmissionConfirmationEmailGENCOMPSUB_welsh.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailGENCOMPSUB_welsh.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
