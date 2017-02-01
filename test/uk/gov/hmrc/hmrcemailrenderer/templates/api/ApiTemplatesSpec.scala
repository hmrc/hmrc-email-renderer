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
import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ApiDeveloperHub

class ApiTemplatesSpec extends PlaySpec with OneAppPerSuite {

  "The API templates" should {

    "of are setup correctly" in new TestCase {

      validateTemplate(
        templateId = "apiDeveloperEmailVerification",
        expectedSubject = "Verify your email address")

      validateTemplate(
        templateId = "apiDeveloperPasswordReset",
        expectedSubject = "Reset your password")

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
        templateId = "apiAddedDeveloperAsCollaboratorNotification",
        expectedSubject = "A collaborator has been added to your application")

      validateTemplate(
        templateId = "apiRemovedCollaboratorConfirmation",
        expectedSubject = "You have been removed from an application")

      validateTemplate(
        templateId = "apiRemovedCollaboratorNotification",
        expectedSubject = "A collaborator has been removed from your application")

      validateTemplate(
        templateId = "apiApplicationApprovedGatekeeperConfirmation",
        expectedSubject = "Application name approved")

      validateTemplate(
        templateId = "apiApplicationApprovedAdminConfirmation",
        expectedSubject = "Application name approved: Verify your email address")

      validateTemplate(
        templateId = "apiApplicationApprovedNotification",
        expectedSubject = "Application name approved")

      validateTemplate(
        templateId = "apiApplicationRejectedNotification",
        expectedSubject = "Application not approved")
    }
  }

  def findTemplate(templateId: String): MessageTemplate = {
    ApiTemplates.templates.filter(t => t.templateId == templateId).head
  }

  def validateTemplate(templateId: String, expectedSubject: String) = {
    val template = findTemplate(templateId)
    val subject: (Map[String, String]) => String = template.subject.f
    template.fromAddress.apply(Map.empty) mustBe ("HMRC API Developer Hub <noreply@tax.service.gov.uk>")
    template.fromAddress.apply(Map("developerHubTitle" -> "test account")) mustBe("HMRC test account <noreply@tax.service.gov.uk>")
    template.service mustBe(ApiDeveloperHub)
    subject(Map.empty) mustBe(expectedSubject)
    template.plainTemplate mustNot be(null)
    template.htmlTemplate mustNot be(null)
    template.priority.get mustBe(MessagePriority.Urgent)
  }
}
