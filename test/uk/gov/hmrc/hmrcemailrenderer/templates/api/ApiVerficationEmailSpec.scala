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

class ApiVerficationEmailSpec extends PlaySpec {

  val verificationLink = "http://verify.com"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map(
    "recipientName_forename" -> "Rich",
    "verificationLink" -> verificationLink,
    "staticAssetUrlPrefix" -> "http://uri",
    "staticAssetVersion" -> "v1",
    "borderColour" -> "#005EA5"
  )

  "htmlView" must {
    "render as" in new TestCase {
      val renderedHtml = api.html.verificationEmail.render(templateParams)
      renderedHtml.contentType must include("text/html")
      renderedHtml.body must include("Dear Rich")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">Click on the link below to verify your email address:</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\"><a href=\"" + verificationLink +
        "\" style=\"color: #005EA5;\">" + verificationLink + "</a></p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC Digital API Developer Hub</p>")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.verificationEmail.render(templateParamsPlus)
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC Digital " + developerHubTitle + "</p>")
    }
  }

  "textView" must {
    "render as" in new TestCase {
      val renderedTxt = api.txt.verificationEmail.render(templateParams)
      renderedTxt.contentType must include("text/plain")
      renderedTxt.body must include("Dear Rich")
      renderedTxt.body must include("Click on the link below to verify your email address:")
      renderedTxt.body must include(verificationLink)
      renderedTxt.body must include("From HMRC Digital API Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.verificationEmail.render(templateParamsPlus)
      renderedTxt.body must include("From HMRC Digital " + developerHubTitle)
    }
  }
}
