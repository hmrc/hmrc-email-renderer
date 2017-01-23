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
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import uk.gov.hmrc.hmrcemailrenderer.templates.api

class ApiRemovedCollaboratorNotificationSpec extends PlaySpec with OneAppPerTest {

  val email = "email@email.com"
  val applicationName = "Application Name"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map("email" -> email, "applicationName" -> applicationName,
    "staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1")

  "htmlView" must {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiRemovedCollaboratorNotification.render(templateParams)
      renderedHtml.contentType must include("text/html")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\"><strong>" + email +
        "</strong> has been removed from <strong>" + applicationName +
        "</strong> by another admin.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">They can no longer access this application.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC API Developer Hub</p>")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.apiRemovedCollaboratorNotification.render(templateParamsPlus)
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }
  }

  "textView" must {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiRemovedCollaboratorNotification.render(templateParams)
      renderedTxt.contentType must include("text/plain")
      renderedTxt.body must include("A collaborator has been removed from your application")
      renderedTxt.body must include(email + " has been removed from " + applicationName + " by another admin.")
      renderedTxt.body must include("They can no longer access this application.")
      renderedTxt.body must include("From HMRC API Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.apiRemovedCollaboratorNotification.render(templateParamsPlus)
      renderedTxt.body must include("From HMRC " + developerHubTitle)
    }
  }
}
