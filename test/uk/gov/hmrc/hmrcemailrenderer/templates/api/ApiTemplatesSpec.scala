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

package uk.gov.hmrc.hmrcemailrenderer.templates.api

import junit.framework.TestCase
import org.scalatestplus.play.OneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ApiDeveloperHub
import org.scalatest.{ Matchers, OptionValues, WordSpecLike }

class ApiTemplatesSpec extends WordSpecLike with Matchers with OptionValues with OneAppPerSuite {

  "The API templates" should {

    "of are setup correctly" in new TestCase {

      validateTemplate(templateId = "apiDeveloperEmailVerification", expectedSubject = "Verify your email address")

      validateTemplate(templateId = "apiDeveloperPasswordReset", expectedSubject = "Reset your password")

      validateTemplate(
        templateId = "apiDeveloperChangedPasswordConfirmation",
        expectedSubject = "You have reset your password")

      validateTemplate(
        templateId = "apiAddedRegisteredDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application")

      validateTemplate(
        templateId = "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application")

      validateTemplate(
        templateId = "apiAddedDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application")

      validateTemplate(
        templateId = "apiAddedDeveloperAsCollaboratorNotification",
        expectedSubject = "A team member has been added to your application")

      validateTemplate(
        templateId = "apiRemovedCollaboratorConfirmation",
        expectedSubject = "You have been removed from an application")

      validateTemplate(
        templateId = "apiRemovedCollaboratorNotification",
        expectedSubject = "A team member has been removed from your application")

      validateTemplate(
        templateId = "apiApplicationApprovedGatekeeperConfirmation",
        expectedSubject = "Application check passed")

      validateTemplate(
        templateId = "apiApplicationApprovedAdminConfirmation",
        expectedSubject = "Application check passed: Verify your email address")

      validateTemplate(templateId = "apiApplicationApprovedNotification", expectedSubject = "Application check passed")

      validateTemplate(templateId = "apiApplicationDeletedNotification", expectedSubject = "We deleted an application")

      validateTemplate(templateId = "apiDeveloperDeletedConfirmation", expectedSubject = "We deleted your account")

      validateTemplate(
        templateId = "apiApplicationRejectedNotification",
        expectedSubject = "Production credentials request unsuccessful")

      validateTemplate(
        templateId = "apiStatusChangedNotification",
        expectedSubject = "API Status Changed",
        expectedPriority = MessagePriority.Standard)

      validateTemplate(
        templateId = "apiAddedClientSecretNotification",
        expectedSubject = "Client Secret Added",
        expectedPriority = MessagePriority.Urgent)

      validateTemplate(
        templateId = "apiRemovedClientSecretNotification",
        expectedSubject = "Client Secret Removed",
        expectedPriority = MessagePriority.Urgent)

      validateTemplate(
        templateId = "apiApplicationToBeDeletedNotification",
        expectedSubject = "We’re deleting your application",
        expectedPriority = MessagePriority.Standard)

      validateTemplate(
        templateId = "apiVerifyResponsibleIndividual",
        expectedSubject = "Responsible Individual Verification")

      validateTemplate(
        templateId = "ppnsCallbackUrlChangedNotification",
        expectedSubject = "Changes made to Callback URL",
        expectedPriority = MessagePriority.Urgent)
    }
  }

  def findTemplate(templateId: String): MessageTemplate =
    ApiTemplates.templates.filter(t => t.templateId == templateId).head

  def validateTemplate(
    templateId: String,
    expectedSubject: String,
    expectedPriority: MessagePriority = MessagePriority.Urgent) = {
    val template = findTemplate(templateId)
    val subject: (Map[String, String]) => String = template.subject.f
    template.fromAddress.apply(Map.empty) should be("HMRC Developer Hub <noreply@tax.service.gov.uk>")
    template.fromAddress.apply(Map("developerHubTitle" -> "test account")) should be(
      "HMRC test account <noreply@tax.service.gov.uk>")
    template.service should be(ApiDeveloperHub)
    subject(Map.empty) should be(expectedSubject)
    template.plainTemplate should not be (null)
    template.htmlTemplate should not be (null)
    template.priority.get should be(expectedPriority)
  }
}
