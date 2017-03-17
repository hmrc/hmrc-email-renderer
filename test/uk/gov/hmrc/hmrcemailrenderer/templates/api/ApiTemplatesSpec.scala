/*
 * Copyright 2017 HM Revenue & Customs
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
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ApiDeveloperHub
import uk.gov.hmrc.play.test.UnitSpec

class ApiTemplatesSpec extends UnitSpec with OneAppPerSuite {

  "The API templates" should {

    "of are setup correctly" in new TestCase {

      validateUrgentTemplate(
        templateId = "apiDeveloperEmailVerification",
        expectedSubject = "Verify your email address")

      validateUrgentTemplate(
        templateId = "apiDeveloperPasswordReset",
        expectedSubject = "Reset your password")

      validateStandardTemplate(
        templateId = "apiDeveloperChangedPasswordConfirmation",
        expectedSubject = "You have reset your password")

      validateUrgentTemplate(
        templateId = "apiAddedRegisteredDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application")

      validateUrgentTemplate(
        templateId = "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation",
        expectedSubject = "You have been added to an application")

      validateStandardTemplate(
        templateId = "apiAddedDeveloperAsCollaboratorNotification",
        expectedSubject = "A collaborator has been added to your application")

      validateStandardTemplate(
        templateId = "apiRemovedCollaboratorConfirmation",
        expectedSubject = "You have been removed from an application")

      validateStandardTemplate(
        templateId = "apiRemovedCollaboratorNotification",
        expectedSubject = "A collaborator has been removed from your application")

      validateStandardTemplate(
        templateId = "apiApplicationApprovedGatekeeperConfirmation",
        expectedSubject = "Application name approved")

      validateUrgentTemplate(
        templateId = "apiApplicationApprovedAdminConfirmation",
        expectedSubject = "Application name approved: Verify your email address")

      validateStandardTemplate(
        templateId = "apiApplicationApprovedNotification",
        expectedSubject = "Application name approved")

      validateUrgentTemplate(
        templateId = "apiApplicationRejectedNotification",
        expectedSubject = "Application not approved")
    }
  }

  def findTemplate(templateId: String): MessageTemplate = {
    ApiTemplates.templates.filter(t => t.templateId == templateId).head
  }

  def validateTemplate(templateId: String, expectedSubject: String, expectedPriority: Option[MessagePriority]) = {
    val template = findTemplate(templateId)
    val subject: (Map[String, String]) => String = template.subject.f
    template.fromAddress.apply(Map.empty) should be("HMRC API Developer Hub <noreply@tax.service.gov.uk>")
    template.fromAddress.apply(Map("developerHubTitle" -> "test account")) should be("HMRC test account <noreply@tax.service.gov.uk>")
    template.service should be(ApiDeveloperHub)
    subject(Map.empty) should be(expectedSubject)
    template.plainTemplate should not be (null)
    template.htmlTemplate should not be (null)
    template.priority should be(expectedPriority)
  }

  def validateUrgentTemplate(templateId: String, expectedSubject: String) = {
    validateTemplate(templateId, expectedSubject, Some(MessagePriority.Urgent))
  }

  def validateStandardTemplate(templateId: String, expectedSubject: String) = {
    validateTemplate(templateId, expectedSubject, None)
  }
}
