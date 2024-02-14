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
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.api

class ApiRemovedCollaboratorNotificationSpec extends AnyWordSpec with Matchers {

  val email = "email@email.com"
  val applicationName = "Application Name"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map(
    "email"                     -> email,
    "applicationName"           -> applicationName,
    "staticAssetUrlPrefix"      -> "http://uri",
    "staticHmrcFrontendVersion" -> "v1",
    "borderColour"              -> "#005EA5"
  )

  "htmlView" should {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiRemovedCollaboratorNotification.render(templateParams)
      renderedHtml.contentType should include("text/html")
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\"><strong>" + email +
          "</strong> has been removed from <strong>" + applicationName +
          "</strong> by another admin.</p>")
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\">They can no longer access this application.</p>")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC Developer Hub</p>")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.apiRemovedCollaboratorNotification.render(templateParamsPlus)
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }
  }

  "textView" should {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiRemovedCollaboratorNotification.render(templateParams)
      renderedTxt.contentType should include("text/plain")
      renderedTxt.body should include("A team member has been removed from your application")
      renderedTxt.body should include(email + " has been removed from " + applicationName + " by another admin.")
      renderedTxt.body should include("They can no longer access this application.")
      renderedTxt.body should include("From HMRC Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.apiRemovedCollaboratorNotification.render(templateParamsPlus)
      renderedTxt.body should include("From HMRC " + developerHubTitle)
    }
  }
}
