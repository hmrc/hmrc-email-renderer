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

class ApiAddedRegisteredDeveloperAsCollaboratorConfirmationSpec extends PlaySpec with OneAppPerTest {

  val applicationName = "Application Name"
  val role = "role"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map("applicationName" -> applicationName, "role" -> role,
                           "staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1")

  "htmlView" must {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.render(templateParams)
      renderedHtml.contentType must include("text/html")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">You’ve been given " + role +
                                     " rights over <strong>" + applicationName + "</strong>.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">Sign in to the HMRC " +
                                     "API Developer Hub to access the application.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">For security reasons, we have not included a link with this email.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC API Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.render(templateParamsPlus)
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">Sign in to the HMRC " +
                                     developerHubTitle + " to access the application.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }
  }

  "textView" must {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.render(templateParams)
      renderedTxt.contentType must include("text/plain")
      renderedTxt.body must include("You’ve been given " + role + " rights over " + applicationName + ".")
      renderedTxt.body must include("Sign in to the HMRC API Developer Hub to access the application.")
      renderedTxt.body must include("For security reasons, we have not included a link with this email.")
      renderedTxt.body must include("From HMRC API Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.apiAddedRegisteredDeveloperAsCollaboratorConfirmation.render(templateParamsPlus)
      renderedTxt.body must include("Sign in to the HMRC " + developerHubTitle + " to access the application.")
      renderedTxt.body must include("From HMRC " + developerHubTitle)
    }
  }
}
