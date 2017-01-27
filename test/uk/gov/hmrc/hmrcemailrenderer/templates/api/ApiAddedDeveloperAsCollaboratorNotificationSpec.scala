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
import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.templates.api

class ApiAddedDeveloperAsCollaboratorNotificationSpec extends PlaySpec {

  val email = "email@email.com"
  val applicationName = "Application Name"
  val role = "role"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map("email" -> email, "applicationName" -> applicationName, "role" -> role,
                           "staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1",
                            "borderColour" -> "#005EA5")

  "htmlView" must {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiAddedDeveloperAsCollaboratorNotification.render(templateParams)
      renderedHtml.contentType must include("text/html")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\"><strong>" + email +
                                     "</strong> has been added to <strong>" + applicationName +
                                     "</strong> by another admin.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">They now have " + role +
                                     " rights over the application.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC API Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.apiAddedDeveloperAsCollaboratorNotification.render(templateParamsPlus)
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }
  }

  "textView" must {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiAddedDeveloperAsCollaboratorNotification.render(templateParams)
      renderedTxt.contentType must include("text/plain")
      renderedTxt.body must include(email + " has been added to " + applicationName + " by another admin.")
      renderedTxt.body must include("They now have " + role + " rights over the application.")
      renderedTxt.body must include("From HMRC API Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.apiAddedDeveloperAsCollaboratorNotification.render(templateParamsPlus)
      renderedTxt.body must include("From HMRC " + developerHubTitle)
    }
  }
}
