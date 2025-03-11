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

class apiAddedMemberToOrganisationConfirmationSpec extends AnyWordSpec with Matchers {

  val organisationName = "Organisation Name"
  val role = "member"
  val article = "a"

  val templateParams = Map(
    "organisationName"          -> organisationName,
    "article"                   -> article,
    "role"                      -> role,
    "staticAssetUrlPrefix"      -> "http://uri",
    "staticHmrcFrontendVersion" -> "v1",
    "borderColour"              -> "#005EA5"
  )

  "htmlView" should {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiAddedMemberToOrganisationConfirmation.render(templateParams)
      renderedHtml.contentType should include("text/html")
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\">You are now " + article + " " + role +
          " of " + organisationName + ".</p>"
      )
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC Developer Hub</p>")
    }
  }

  "textView" should {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiAddedMemberToOrganisationConfirmation.render(templateParams)
      renderedTxt.contentType should include("text/plain")
      renderedTxt.body should include("You are now " + article + " " + role + " of " + organisationName + ".")
      renderedTxt.body should include("From HMRC Developer Hub")
    }
  }
}
