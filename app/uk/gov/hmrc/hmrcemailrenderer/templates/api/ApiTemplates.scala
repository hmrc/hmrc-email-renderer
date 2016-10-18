package uk.gov.hmrc.email.templates.api

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.{TemplateGroup, GovUkTemplate}
import uk.gov.hmrc.email.templates.Regime.ApiDeveloperHub

/**
  * Templates used by the API Platform.
  */
object ApiTemplates extends TemplateGroup with GovUkTemplate {
  val title = "API Platform"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "apiDeveloperEmailVerification",
      regime = ApiDeveloperHub,
      subject = "Verify your email address",
      plainTemplate = txt.verificationEmail.apply,
      htmlTemplate = html.verificationEmail.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiDeveloperPasswordReset",
      regime = ApiDeveloperHub,
      subject = "Reset your password",
      plainTemplate = txt.passwordResetEmail.apply,
      htmlTemplate = html.passwordResetEmail.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiDeveloperChangedPasswordConfirmation",
      regime = ApiDeveloperHub,
      subject = "You have reset your password",
      plainTemplate = txt.passwordChangedConfirmationEmail.apply,
      htmlTemplate = html.passwordChangedConfirmationEmail.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiAddedRegisteredDeveloperAsCollaboratorConfirmation",
      regime = ApiDeveloperHub,
      subject = "You have been added to an application",
      plainTemplate = txt.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.apply,
      htmlTemplate = html.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation",
      regime = ApiDeveloperHub,
      subject = "You have been added to an application",
      plainTemplate = txt.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.apply,
      htmlTemplate = html.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiAddedDeveloperAsCollaboratorNotification",
      regime = ApiDeveloperHub,
      subject = "A collaborator has been added to your application",
      plainTemplate = txt.apiAddedDeveloperAsCollaboratorNotification.apply,
      htmlTemplate = html.apiAddedDeveloperAsCollaboratorNotification.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiRemovedCollaboratorConfirmation",
      regime = ApiDeveloperHub,
      subject = "You have been removed from an application",
      plainTemplate = txt.apiRemovedCollaboratorConfirmation.apply,
      htmlTemplate = html.apiRemovedCollaboratorConfirmation.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiRemovedCollaboratorNotification",
      regime = ApiDeveloperHub,
      subject = "A collaborator has been removed from your application",
      plainTemplate = txt.apiRemovedCollaboratorNotification.apply,
      htmlTemplate = html.apiRemovedCollaboratorNotification.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiApplicationApprovedGatekeeperConfirmation",
      regime = ApiDeveloperHub,
      subject = "Application name approved",
      plainTemplate = txt.apiApplicationApprovedGatekeeperConfirmation.apply,
      htmlTemplate = html.apiApplicationApprovedGatekeeperConfirmation.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiApplicationApprovedAdminConfirmation",
      regime = ApiDeveloperHub,
      subject = "Application name approved: Verify your email address",
      plainTemplate = txt.apiApplicationApprovedAdminConfirmation.apply,
      htmlTemplate = html.apiApplicationApprovedAdminConfirmation.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiApplicationApprovedNotification",
      regime = ApiDeveloperHub,
      subject = "Application name approved",
      plainTemplate = txt.apiApplicationApprovedNotification.apply,
      htmlTemplate = html.apiApplicationApprovedNotification.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    ),
    SimpleMessageTemplate(
      id = "apiApplicationRejectedNotification",
      regime = ApiDeveloperHub,
      subject = "Application not approved",
      plainTemplate = txt.apiApplicationRejectedNotification.apply,
      htmlTemplate = html.apiApplicationRejectedNotification.apply,
      fromAddress = "HMRC API Developer Hub <noreply@tax.service.gov.uk>"
    )
  )
}
