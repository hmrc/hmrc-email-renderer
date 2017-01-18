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
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.play.test.UnitSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ApiDeveloperHub

class ApiTemplatesSpec  extends UnitSpec {

  def findTemplate(templateId: String): MessageTemplate = {
    ApiTemplates.templates.filter(t => t.templateId == templateId).head
  }

  "The API templates" should {

    "of which apiAddedDeveloperAsCollaboratorNotification should contain" in new TestCase {
      val template = findTemplate("apiAddedDeveloperAsCollaboratorNotification")
      val subject: (Map[String, String]) => String = template.subject.f
      template.fromAddress.apply(Map.empty) should be("HMRC API Developer Hub <noreply@tax.service.gov.uk>")
      template.service should be(ApiDeveloperHub)
      subject(Map.empty) should be("A collaborator has been added to your application")

      // Fails here
      template.plainTemplate should be(txt.apiAddedDeveloperAsCollaboratorNotification.f)
      template.htmlTemplate should be(html.apiAddedDeveloperAsCollaboratorNotification.f)
      template.priority should be(MessagePriority.Urgent)
    }
  }


  "xxxx" in new TestCase {
    val template = findTemplate("apiAddedDeveloperAsCollaboratorNotification")
    val subject: (Map[String, String]) => String = template.subject.f
    template.fromAddress.apply(Map("developerHubTitle" -> "test account")) should be("HMRC test account <noreply@tax.service.gov.uk>")
    template.service should be(ApiDeveloperHub)
    subject(Map.empty) should be("A collaborator has been added to your application")

    // fails here
    template.plainTemplate should be(txt.apiAddedDeveloperAsCollaboratorNotification.f)
    template.htmlTemplate should be(html.apiAddedDeveloperAsCollaboratorNotification.f)
    template.priority should be(MessagePriority.Urgent)
  }

}
