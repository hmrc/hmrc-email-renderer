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

import junit.framework.TestCase
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ApiDeveloperHub
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatestplus.play.guice.GuiceOneAppPerSuite

class ApiTemplatesSpec extends AnyWordSpecLike with Matchers with OptionValues with GuiceOneAppPerSuite {

  "The API templates" should {

    "of are setup correctly" in new TestCase {

      validateTemplate(templateId = "apiDeveloperEmailVerification", expectedSubject = "Verify your email address")

      validateTemplate(templateId = "apiDeveloperPasswordReset", expectedSubject = "Reset your password")

      validateTemplate(
        templateId = "apiDeveloperChangedPasswordConfirmation",
        expectedSubject = "You have reset your password"
      )

      validateTemplate(
        templateId = "apiAddedRegisteredDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application"
      )

      validateTemplate(
        templateId = "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application"
      )

      validateTemplate(
        templateId = "apiAddedDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application"
      )

      validateTemplate(
        templateId = "apiAddedDeveloperAsCollaboratorNotification",
        expectedSubject = "A team member has been added to your application"
      )

      validateTemplate(
        templateId = "apiRemovedCollaboratorConfirmation",
        expectedSubject = "You have been removed from an application"
      )

      validateTemplate(
        templateId = "apiRemovedCollaboratorNotification",
        expectedSubject = "A team member has been removed from your application"
      )

      validateTemplate(
        templateId = "apiApplicationApprovedGatekeeperConfirmation",
        expectedSubject = "Application check passed"
      )

      validateTemplate(
        templateId = "apiApplicationApprovedAdminConfirmation",
        expectedSubject = "Application check passed: Verify your email address"
      )

      validateTemplate(templateId = "apiApplicationApprovedNotification", expectedSubject = "Application check passed")

      validateTemplate(templateId = "apiApplicationDeletedNotification", expectedSubject = "We deleted an application")

      validateTemplate(templateId = "apiDeveloperDeletedConfirmation", expectedSubject = "We deleted your account")

      validateTemplate(
        templateId = "apiApplicationRejectedNotification",
        expectedSubject = "Production credentials request unsuccessful"
      )

      validateTemplate(
        templateId = "apiStatusChangedNotification",
        expectedSubject = "API Status Changed",
        expectedPriority = MessagePriority.Standard
      )

      validateTemplate(
        templateId = "apiAddedClientSecretNotification",
        expectedSubject = "Client Secret Added",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiRemovedClientSecretNotification",
        expectedSubject = "Client Secret Removed",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiApplicationToBeDeletedNotification",
        expectedSubject = "We’re deleting your application",
        expectedPriority = MessagePriority.Standard
      )

      validateTemplate(
        templateId = "apiProductionCredentialsRequestExpired",
        expectedSubject = "Production credentials request deleted",
        expectedPriority = MessagePriority.Standard
      )

      validateTemplate(
        templateId = "apiNewTermsOfUseInvitation",
        expectedSubject = "ACTION NEEDED: Agree to HMRC’s new Developer Hub terms of use",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiNewTermsOfUseConfirmation",
        expectedSubject = "You conform to version 2 of our terms of use",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiProductionCredentialsRequestExpiryWarning",
        expectedSubject = "About your request for production credentials",
        expectedPriority = MessagePriority.Standard
      )

      validateTemplate(
        templateId = "apiVerifyResponsibleIndividual",
        expectedSubject = "Responsible individual verification",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiVerifyResponsibleIndividualUpdate",
        expectedSubject = "Responsible individual verification",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiResponsibleIndividualReminderToAdmin",
        expectedSubject = "Update about your request for production credentials",
        expectedPriority = MessagePriority.Standard
      )

      validateTemplate(
        templateId = "apiResponsibleIndividualDidNotVerify",
        expectedSubject = "Production credentials request declined",
        expectedPriority = MessagePriority.Standard
      )

      validateTemplate(
        templateId = "apiResponsibleIndividualDeclined",
        expectedSubject = "Important update about your production credentials request",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiResponsibleIndividualDeclinedV2",
        expectedSubject = "Change details for the responsible individual",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiResponsibleIndividualNotChanged",
        expectedSubject = "Important update about your application",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiChangeOfApplicationName",
        expectedSubject = "Changes made to application name",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiChangeOfApplicationDetails",
        expectedSubject = "Changes made to application details",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiChangeOfApplicationDetailsNoValue",
        expectedSubject = "Changes made to application details",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiChangeOfResponsibleIndividual",
        expectedSubject = "Important information about your application",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "ppnsCallbackUrlChangedNotification",
        expectedSubject = "Changes made to Callback URL",
        expectedPriority = MessagePriority.Urgent
      )

      validateTemplate(
        templateId = "apiDeveloperHubNewLoginNotification",
        expectedSubject = "New sign in to your account",
        expectedPriority = MessagePriority.Urgent
      )
    }
  }

  def findTemplate(templateId: String): MessageTemplate =
    ApiTemplates.templates.filter(t => t.templateId == templateId).head

  def validateTemplate(
    templateId: String,
    expectedSubject: String,
    expectedPriority: MessagePriority = MessagePriority.Urgent
  ) = {
    val template = findTemplate(templateId)
    val subject: (Map[String, String]) => String = template.subject.f
    template.fromAddress.apply(Map.empty) should be("HMRC Developer Hub <noreply@tax.service.gov.uk>")
    template.fromAddress.apply(Map("developerHubTitle" -> "test account")) should be(
      "HMRC test account <noreply@tax.service.gov.uk>"
    )
    template.service should be(ApiDeveloperHub)
    subject(Map.empty) should be(expectedSubject)
    template.plainTemplate should not be null
    template.htmlTemplate should not be null
    template.priority.get should be(expectedPriority)
  }
}
