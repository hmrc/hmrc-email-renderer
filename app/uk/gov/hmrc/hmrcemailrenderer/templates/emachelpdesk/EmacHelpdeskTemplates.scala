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

package uk.gov.hmrc.hmrcemailrenderer.templates.emachelpdesk

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.EmacHelpdesk

object EmacHelpdeskTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "emac_helpdesk_failure_confirmation_email",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "You’ve submitted a document to HMRC",
      plainTemplate = txt.emacHelpdeskFailureConfirmationEmail.f,
      htmlTemplate = html.emacHelpdeskFailureConfirmationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "emac_helpdesk_successful_confirmation_email",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "You’ve submitted a document to HMRC",
      plainTemplate = txt.emacHelpdeskSuccessfulConfirmationEmail.f,
      htmlTemplate = html.emacHelpdeskSuccessfulConfirmationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "emac_helpdesk_bulk_deenrolment_file_upload_failure",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "Bulk de-enrolment file upload failure",
      plainTemplate = txt.emacHelpdeskBulkDeenrolmentFileUploadFailure.f,
      htmlTemplate = html.emacHelpdeskBulkDeenrolmentFileUploadFailure.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "emac_helpdesk_bulk_deenrolment_file_upload_scan_success",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "Bulk de-enrolment file uploaded successfully",
      plainTemplate = txt.emacHelpdeskBulkDeenrolmentFileUploadScanSuccess.f,
      htmlTemplate = html.emacHelpdeskBulkDeenrolmentFileUploadScanSuccess.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "emac_helpdesk_bulk_deenrolment_file_rejected_by_approver",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "Bulk de-enrolment file rejected by approver",
      plainTemplate = txt.emacHelpdeskBulkDeenrolmentFileRejectedByApprover.f,
      htmlTemplate = html.emacHelpdeskBulkDeenrolmentFileRejectedByApprover.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "emac_helpdesk_bulk_deenrolment_file_approved",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "Bulk de-enrolment file approved",
      plainTemplate = txt.emacHelpdeskBulkDeenrolmentFileApproved.f,
      htmlTemplate = html.emacHelpdeskBulkDeenrolmentFileApproved.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "emac_helpdesk_bulk_deenrolment_file_processed",
      fromAddress = FromAddress.noReply("HMRC Services and Enrolments helpdesk"),
      service = EmacHelpdesk,
      subject = "Bulk de-enrolment file processed",
      plainTemplate = txt.emacHelpdeskBulkDeenrolmentFileProcessed.f,
      htmlTemplate = html.emacHelpdeskBulkDeenrolmentFileProcessed.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
