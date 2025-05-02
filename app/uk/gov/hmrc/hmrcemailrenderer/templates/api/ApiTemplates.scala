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

package uk.gov.hmrc.hmrcemailrenderer.templates.api

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ApiDeveloperHub
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress

/** Templates used by the API Platform.
  */
object ApiTemplates {
  private def extractFromAddress(params: Map[String, String]): String = {
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
      templateId = "apiAddedDeveloperAsCollaboratorConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have been added to an application",
      plainTemplate = txt.apiAddedDeveloperAsCollaboratorConfirmation.f,
      htmlTemplate = html.apiAddedDeveloperAsCollaboratorConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiAddedDeveloperAsCollaboratorNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "A team member has been added to your application",
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
      subject = "A team member has been removed from your application",
      plainTemplate = txt.apiRemovedCollaboratorNotification.f,
      htmlTemplate = html.apiRemovedCollaboratorNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationApprovedGatekeeperConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Application check passed",
      plainTemplate = txt.apiApplicationApprovedGatekeeperConfirmation.f,
      htmlTemplate = html.apiApplicationApprovedGatekeeperConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationApprovedAdminConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Application check passed: Verify your email address",
      plainTemplate = txt.apiApplicationApprovedAdminConfirmation.f,
      htmlTemplate = html.apiApplicationApprovedAdminConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationApprovedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Application check passed",
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
      templateId = "apiDeveloperDeletedConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "We deleted your account",
      plainTemplate = txt.apiDeveloperDeletedConfirmation.f,
      htmlTemplate = html.apiDeveloperDeletedConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationRejectedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Production credentials request unsuccessful",
      plainTemplate = txt.apiApplicationRejectedNotification.f,
      htmlTemplate = html.apiApplicationRejectedNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiStatusChangedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "API Status Changed",
      plainTemplate = txt.apiStatusChangedNotification.f,
      htmlTemplate = html.apiStatusChangedNotification.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiAddedClientSecretNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Client Secret Added",
      plainTemplate = txt.apiAddedClientSecretNotification.f,
      htmlTemplate = html.apiAddedClientSecretNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiRemovedClientSecretNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Client Secret Removed",
      plainTemplate = txt.apiRemovedClientSecretNotification.f,
      htmlTemplate = html.apiRemovedClientSecretNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiApplicationToBeDeletedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "We’re deleting your application",
      plainTemplate = txt.apiApplicationToBeDeletedNotification.f,
      htmlTemplate = html.apiApplicationToBeDeletedNotification.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiProductionCredentialsRequestExpired",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Production credentials request deleted",
      plainTemplate = txt.apiProductionCredentialsRequestExpired.f,
      htmlTemplate = html.apiProductionCredentialsRequestExpired.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiProductionCredentialsRequestExpiryWarning",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "About your request for production credentials",
      plainTemplate = txt.apiProductionCredentialsRequestExpiryWarning.f,
      htmlTemplate = html.apiProductionCredentialsRequestExpiryWarning.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiNewTermsOfUseInvitation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "ACTION NEEDED: Agree to HMRC’s new Developer Hub terms of use",
      plainTemplate = txt.apiNewTermsOfUseInvitation.f,
      htmlTemplate = html.apiNewTermsOfUseInvitation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiNewTermsOfUseConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You conform to version 2 of our terms of use",
      plainTemplate = txt.apiNewTermsOfUseConfirmation.f,
      htmlTemplate = html.apiNewTermsOfUseConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiAddedRegisteredMemberToOrganisationConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have been added to an organisation in the HMRC Developer Hub",
      plainTemplate = txt.apiAddedRegisteredMemberToOrganisationConfirmation.f,
      htmlTemplate = html.apiAddedRegisteredMemberToOrganisationConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiAddedUnregisteredMemberToOrganisationConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have been added to an organisation in the HMRC Developer Hub",
      plainTemplate = txt.apiAddedUnregisteredMemberToOrganisationConfirmation.f,
      htmlTemplate = html.apiAddedUnregisteredMemberToOrganisationConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiRemovedMemberFromOrganisationConfirmation",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "You have been removed from an organisation",
      plainTemplate = txt.apiRemovedMemberFromOrganisationConfirmation.f,
      htmlTemplate = html.apiRemovedMemberFromOrganisationConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "ppnsCallbackUrlChangedNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Changes made to Callback URL",
      plainTemplate = txt.ppnsCallbackUrlChangedNotification.f,
      htmlTemplate = html.ppnsCallbackUrlChangedNotification.f,
      priority = Some(MessagePriority.Urgent) // Email is a mitigation for a security risk, so increased priority
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiVerifyResponsibleIndividual",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Responsible individual verification",
      plainTemplate = txt.apiVerifyResponsibleIndividual.f,
      htmlTemplate = html.apiVerifyResponsibleIndividual.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiVerifyResponsibleIndividualUpdate",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Responsible individual verification",
      plainTemplate = txt.apiVerifyResponsibleIndividualUpdate.f,
      htmlTemplate = html.apiVerifyResponsibleIndividualUpdate.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiResponsibleIndividualReminderToAdmin",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Update about your request for production credentials",
      plainTemplate = txt.apiResponsibleIndividualReminderToAdmin.f,
      htmlTemplate = html.apiResponsibleIndividualReminderToAdmin.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiResponsibleIndividualDeclined",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Important update about your production credentials request",
      plainTemplate = txt.apiResponsibleIndividualDeclined.f,
      htmlTemplate = html.apiResponsibleIndividualDeclined.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiResponsibleIndividualDeclinedV2",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Change details for the responsible individual",
      plainTemplate = txt.apiResponsibleIndividualDeclinedV2.f,
      htmlTemplate = html.apiResponsibleIndividualDeclinedV2.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiResponsibleIndividualDidNotVerify",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Production credentials request declined",
      plainTemplate = txt.apiResponsibleIndividualDidNotVerify.f,
      htmlTemplate = html.apiResponsibleIndividualDidNotVerify.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiResponsibleIndividualNotChanged",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Important update about your application",
      plainTemplate = txt.apiResponsibleIndividualNotChanged.f,
      htmlTemplate = html.apiResponsibleIndividualNotChanged.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiChangeOfApplicationName",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Changes made to application name",
      plainTemplate = txt.apiChangeOfApplicationName.f,
      htmlTemplate = html.apiChangeOfApplicationName.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiChangeOfApplicationDetails",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Changes made to application details",
      plainTemplate = txt.apiChangeOfApplicationDetails.f,
      htmlTemplate = html.apiChangeOfApplicationDetails.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiChangeOfApplicationDetailsNoValue",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Changes made to application details",
      plainTemplate = txt.apiChangeOfApplicationDetailsNoValue.f,
      htmlTemplate = html.apiChangeOfApplicationDetailsNoValue.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiChangeOfResponsibleIndividual",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "Important information about your application",
      plainTemplate = txt.apiChangeOfResponsibleIndividual.f,
      htmlTemplate = html.apiChangeOfResponsibleIndividual.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicFromAddress(
      templateId = "apiDeveloperHubNewLoginNotification",
      fromAddress = extractFromAddress,
      service = ApiDeveloperHub,
      subject = "New sign in to your account",
      plainTemplate = txt.apiDeveloperHubNewLoginNotification.f,
      htmlTemplate = html.apiDeveloperHubNewLoginNotification.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
