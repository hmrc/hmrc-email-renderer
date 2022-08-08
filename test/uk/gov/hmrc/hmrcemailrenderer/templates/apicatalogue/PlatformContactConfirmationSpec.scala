/*
 * Copyright 2022 HM Revenue & Customs
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
import org.scalatest.{ Matchers, OptionValues, WordSpecLike }
import uk.gov.hmrc.hmrcemailrenderer.templates.apicatalogue

import java.util.Base64

class PlatformContactConfirmationSpec extends WordSpecLike with OptionValues with Matchers {

  val templateParams = Map(
    "apiTitle"    -> "Corporation Tax",
    "senderName"  -> "Joe Bloggs",
    "senderEmail" -> "joe.bloggs@example.com",
    "contactReasons" -> Base64.getEncoder.encodeToString(
      "Test contact reason one|Test contact reason two|Test contact reason three".getBytes),
    "specificQuestion"     -> "How many engineers does it to change a light bulb?",
    "apiEmail"             -> "testApi@example.com",
    "staticAssetUrlPrefix" -> "http://uri",
    "staticAssetVersion"   -> "v1",
    "borderColour"         -> "#005EA5"
  )

  val paragraphWithInlineCss = "<p style=\"margin: 0 0 30px; font-size: 19px;\">"

  "htmlView" should {
    "render matching html content" in new TestCase {
      val renderedHtml = apicatalogue.html.platformContactConfirmation.render(templateParams)
      renderedHtml.contentType should include("text/html")

      renderedHtml.body should include(paragraphWithInlineCss + s"Dear ${templateParams.get("senderName").get}</p>")

      renderedHtml.body should include("Here is a summary of your message sent to the platform team.</p>")

      renderedHtml.body should include(s"<strong>API</strong>: ${templateParams.get("apiTitle").get}</p>")

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
        paragraphWithInlineCss + s"<strong>Sent to:</strong> ${templateParams.get("apiEmail").get}</p>")

      renderedHtml.body should include(paragraphWithInlineCss + s"You should get a reply in 7 days.</p>")

      renderedHtml.body should include(paragraphWithInlineCss + "From HMRC API catalogue</p>")
    }
  }

  "textView" should {
    "render matching text content" in new TestCase {
      val renderedTxt = apicatalogue.txt.platformContactConfirmation.render(templateParams)
      renderedTxt.contentType should include("text/plain")

      renderedTxt.body should include(s"Dear ${templateParams.get("senderName").get}")

      renderedTxt.body should include("Here is a summary of your message sent to the platform team.")

      renderedTxt.body should include(s"API: ${templateParams.get("apiTitle").get}")

      renderedTxt.body should include(s"Name: ${templateParams.get("senderName").get}")

      renderedTxt.body should include(s"Email: ${templateParams.get("senderEmail").get}")

      renderedTxt.body should include(s"Why do you need to contact the API team?")

      renderedTxt.body should include("Test contact reason one")
      renderedTxt.body should include("Test contact reason two")
      renderedTxt.body should include("Test contact reason three")

      renderedTxt.body should include(s"Do you have a specific question?")

      renderedTxt.body should include(s"${templateParams.get("specificQuestion").get}")

      renderedTxt.body should include(s"Sent to: ${templateParams.get("apiEmail").get}")

      renderedTxt.body should include(s"You should get a reply in 7 days.")

      renderedTxt.body should include("From HMRC API catalogue")
    }
  }

}
