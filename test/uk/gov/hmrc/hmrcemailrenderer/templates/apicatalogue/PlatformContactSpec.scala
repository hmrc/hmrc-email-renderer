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

package uk.gov.hmrc.hmrcemailrenderer.templates.apicatalogue

import junit.framework.TestCase
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.templates.apicatalogue

class PlatformContactSpec extends AnyWordSpecLike with OptionValues with Matchers {

  val templateParams = Map(
    "apiTitle"                  -> "Corporation Tax",
    "senderName"                -> "Joe Bloggs",
    "senderEmail"               -> "joe.bloggs@example.com",
    "contactReasons"            -> "Test contact reason one|Test contact reason two|Test contact reason three",
    "specificQuestion"          -> "How many engineers does it to change a light bulb?",
    "staticAssetUrlPrefix"      -> "http://uri",
    "staticHmrcFrontendVersion" -> "v1",
    "borderColour"              -> "#005EA5"
  )

  val paragraphWithInlineCss = "<p style=\"margin: 0 0 30px; font-size: 19px;\">"

  "htmlView" should {
    "render matching html content" in new TestCase {
      val renderedHtml = apicatalogue.html.platformContact.render(templateParams)

      renderedHtml.contentType should include("text/html")

      renderedHtml.body should include(
        s"<title>Information request about " + s"${templateParams.get("apiTitle").get}</title>")

      renderedHtml.body should include(paragraphWithInlineCss + "Dear platform team</p>")

      renderedHtml.body should include(
        paragraphWithInlineCss + "We have received an information request about " + s"${templateParams.get("apiTitle").get} on the API catalogue.</p>")

      renderedHtml.body should include(paragraphWithInlineCss + "Here is a summary.</p>")

      renderedHtml.body should include(
        paragraphWithInlineCss + "<strong>Name</strong>: " + s"${templateParams.get("senderName").get}</p>")

      renderedHtml.body should include(
        paragraphWithInlineCss + "<strong>Email</strong>: " + s"${templateParams.get("senderEmail").get}</p>")

      renderedHtml.body should include(
        paragraphWithInlineCss + "<strong>Why do you need to contact the API team?</strong></p>")

      renderedHtml.body should include(paragraphWithInlineCss + "Test contact reason one</p>")
      renderedHtml.body should include(paragraphWithInlineCss + "Test contact reason two</p>")
      renderedHtml.body should include(paragraphWithInlineCss + "Test contact reason three</p>")

      renderedHtml.body should include(paragraphWithInlineCss + "<strong>Do you have a specific question?</strong></p>")

      renderedHtml.body should include(paragraphWithInlineCss + s"${templateParams.get("specificQuestion").get}</p>")

      renderedHtml.body should include(
        paragraphWithInlineCss + s"You should reply to ${templateParams.get("senderEmail").get} in 7 days.</p>")

      renderedHtml.body should include(paragraphWithInlineCss + "From HMRC API catalogue</p>")
    }
  }

  "textView" should {
    "render matching text content" in new TestCase {
      val renderedTxt = apicatalogue.txt.platformContact.render(templateParams)
      renderedTxt.contentType should include("text/plain")

      renderedTxt.body should include(s"Information request about " + s"${templateParams.get("apiTitle").get}")

      renderedTxt.body should include("Dear platform team")

      renderedTxt.body should include(
        "We have received an information request about " + s"${templateParams.get("apiTitle").get} on the API catalogue.")

      renderedTxt.body should include("Here is a summary.")

      renderedTxt.body should include(s"Name: ${templateParams.get("senderName").get}")

      renderedTxt.body should include(s"Email: ${templateParams.get("senderEmail").get}")

      renderedTxt.body should include(s"Why do you need to contact the API team?")

      renderedTxt.body should include("Test contact reason one")
      renderedTxt.body should include("Test contact reason two")
      renderedTxt.body should include("Test contact reason three")

      renderedTxt.body should include(s"Do you have a specific question?")

      renderedTxt.body should include(s"${templateParams.get("specificQuestion").get}")

      renderedTxt.body should include(s"You should reply to ${templateParams.get("senderEmail").get} in 7 days.")

      renderedTxt.body should include("From HMRC API catalogue")
    }
  }

}
