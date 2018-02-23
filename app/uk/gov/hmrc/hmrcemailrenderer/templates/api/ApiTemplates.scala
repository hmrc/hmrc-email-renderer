/*
 * Copyright 2018 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.api

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ApiDeveloperHub
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress

/**
  * Templates used by the API Platform.
  */
object ApiTemplates {
  private def extractFromAddress(params : Map[String, String]): String = {
    val sender = params.get("developerHubTitle").getOrElse("Developer Hub")
    FromAddress.noReply(s"HMRC $sender")
  }

  val templates = Seq(
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiDeveloperEmailVerification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Verify your email address",
      plainTemplate = txt.verificationEmail.f,
      htmlTemplate = html.verificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiDeveloperPasswordReset",
      service = ApiDeveloperHub,
      fromAddress = extractFromAddress,
      subject = "Reset your password",
      plainTemplate = txt.passwordResetEmail.f,
      htmlTemplate = html.passwordResetEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiDeveloperChangedPasswordConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have reset your password",
      plainTemplate = txt.passwordChangedConfirmationEmail.f,
      htmlTemplate = html.passwordChangedConfirmationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiAddedRegisteredDeveloperAsCollaboratorConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have been added to an application",
      plainTemplate = txt.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.f,
      htmlTemplate = html.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have been added to an application",
      plainTemplate = txt.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.f,
      htmlTemplate = html.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiAddedDeveloperAsCollaboratorNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "A collaborator has been added to your application",
      plainTemplate = txt.apiAddedDeveloperAsCollaboratorNotification.f,
      htmlTemplate = html.apiAddedDeveloperAsCollaboratorNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiRemovedCollaboratorConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have been removed from an application",
      plainTemplate = txt.apiRemovedCollaboratorConfirmation.f,
      htmlTemplate = html.apiRemovedCollaboratorConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiRemovedCollaboratorNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "A collaborator has been removed from your application",
      plainTemplate = txt.apiRemovedCollaboratorNotification.f,
      htmlTemplate = html.apiRemovedCollaboratorNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationApprovedGatekeeperConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Application name approved",
      plainTemplate = txt.apiApplicationApprovedGatekeeperConfirmation.f,
      htmlTemplate = html.apiApplicationApprovedGatekeeperConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationApprovedAdminConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Application name approved: Verify your email address",
      plainTemplate = txt.apiApplicationApprovedAdminConfirmation.f,
      htmlTemplate = html.apiApplicationApprovedAdminConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationApprovedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Application name approved",
      plainTemplate = txt.apiApplicationApprovedNotification.f,
      htmlTemplate = html.apiApplicationApprovedNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationDeletedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "We deleted an application",
      plainTemplate = txt.apiApplicationDeletedNotification.f,
      htmlTemplate = html.apiApplicationDeletedNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationRejectedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Application not approved",
      plainTemplate = txt.apiApplicationRejectedNotification.f,
      htmlTemplate = html.apiApplicationRejectedNotification.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
