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

class ApiAddedUnregisteredDeveloperAsCollaboratorConfirmationSpec extends PlaySpec with OneAppPerTest {

  val applicationName = "Application Name"
  val role = "role"
  val developerHubLink = "Developer Hub Link"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map("applicationName" -> applicationName, "role" -> role,
    "developerHubLink" -> developerHubLink,
    "staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1")

  "htmlView" must {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.render(templateParams)
      renderedHtml.contentType must include("text/html")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">You’ve been given " + role +
        " rights over <strong>" + applicationName + "</strong>.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">To register with the HMRC " +
        "API Developer Hub, click on the link below.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\"><a href=\"" +
        developerHubLink + "\" style=\"color: #005EA5;\">" +
        developerHubLink + "</a></p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC API Developer Hub</p>")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.render(templateParamsPlus)
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">To register with the HMRC " +
        developerHubTitle + ", click on the link below.</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }
  }

  "textView" must {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.render(templateParams)
      renderedTxt.contentType must include("text/plain")
      renderedTxt.body must include("You’ve been given " + role + " rights over " + applicationName + ".")
      renderedTxt.body must include("To register with the HMRC API Developer Hub, click on the link below.")
      renderedTxt.body must include(developerHubLink)
      renderedTxt.body must include("From HMRC API Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.apiAddedUnregisteredDeveloperAsCollaboratorConfirmation.render(templateParamsPlus)
      renderedTxt.body must include("To register with the HMRC " + developerHubTitle + ", click on the link below.")
      renderedTxt.body must include("From HMRC " + developerHubTitle)
    }
  }
}
