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
import uk.gov.hmrc.hmrcemailrenderer.templates.api
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class ApiVerificationEmailSpec extends AnyWordSpecLike with OptionValues with Matchers {

  val verificationLink = "http://verify.com"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map(
    "recipientName_title"   -> "Mr",
    "recipientName_surname" -> "Smith",
    "verificationLink"      -> verificationLink,
    "staticAssetUrlPrefix"  -> "http://uri",
    "staticAssetVersion"    -> "v1",
    "borderColour"          -> "#005EA5"
  )

  "htmlView" should {
    "render as" in new TestCase {
      val renderedHtml = api.html.verificationEmail.render(templateParams)
      renderedHtml.contentType should include("text/html")
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\">Click on the link below to verify your email address:</p>")
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\"><a href=\"" + verificationLink +
          "\" style=\"color: #005EA5;\">" + verificationLink + "</a></p>")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC Developer Hub</p>")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedHtml = api.html.verificationEmail.render(templateParamsPlus)
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }
  }

  "textView" should {
    "render as" in new TestCase {
      val renderedTxt = api.txt.verificationEmail.render(templateParams)
      renderedTxt.contentType should include("text/plain")
      renderedTxt.body should include("Click on the link below to verify your email address:")
      renderedTxt.body should include(verificationLink)
      renderedTxt.body should include("From HMRC Developer Hub")
    }
    "render with developerHubTitle" in new TestCase {
      val templateParamsPlus = templateParams + ("developerHubTitle" -> developerHubTitle)
      val renderedTxt = api.txt.verificationEmail.render(templateParamsPlus)
      renderedTxt.body should include("From HMRC " + developerHubTitle)
    }
  }
}
