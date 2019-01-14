/*
 * Copyright 2019 HM Revenue & Customs
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
import org.scalatest.{Matchers, WordSpec}
import uk.gov.hmrc.hmrcemailrenderer.templates.api

class apiAddedDeveloperAsCollaboratorConfirmationSpec extends WordSpec with Matchers {

  val applicationName = "Application Name"
  val role = "role"
  val developerHubLink = "Developer Hub Link"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map("applicationName" -> applicationName, "role" -> role,
    "developerHubLink" -> developerHubLink,
    "staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1", "borderColour" -> "#005EA5")

  "htmlView" should {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiAddedDeveloperAsCollaboratorConfirmation.render(templateParams)
      renderedHtml.contentType should include("text/html")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">You’ve been given " + role +
        " rights over <strong>" + applicationName + "</strong>.</p>")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">Not already registered? To register with the HMRC " +
        "Developer Hub, click on the link below.</p>")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\"><a href=\"" +
        developerHubLink + "\" style=\"color: #005EA5;\">" +
        developerHubLink + "</a></p>")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC Developer Hub</p>")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.apiAddedDeveloperAsCollaboratorConfirmation.render(templateParamsPlus)
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">Not already registered? To register with the HMRC " +
        developerHubTitle + ", click on the link below.</p>")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }
  }

  "textView" should {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiAddedDeveloperAsCollaboratorConfirmation.render(templateParams)
      renderedTxt.contentType should include("text/plain")
      renderedTxt.body should include("You’ve been given " + role + " rights over " + applicationName + ".")
      renderedTxt.body should include("Not already registered? To register with the HMRC Developer Hub, click on the link below.")
      renderedTxt.body should include(developerHubLink)
      renderedTxt.body should include("From HMRC Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.apiAddedDeveloperAsCollaboratorConfirmation.render(templateParamsPlus)
      renderedTxt.body should include("Not already registered? To register with the HMRC " + developerHubTitle + ", click on the link below.")
      renderedTxt.body should include("From HMRC " + developerHubTitle)
    }
  }
}
