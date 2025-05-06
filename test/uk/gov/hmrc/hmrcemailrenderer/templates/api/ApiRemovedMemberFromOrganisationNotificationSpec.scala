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

class ApiRemovedMemberFromOrganisationNotificationSpec extends AnyWordSpecLike with Matchers with OptionValues {

  val organisationName = "Organisation Name"
  val emailAddress     = "test.user@example.com"
  val role             = "Admin"

  val templateParams = Map(
    "organisationName"          -> organisationName,
    "emailAddress"              -> emailAddress,
    "role"                      -> role,
    "staticAssetUrlPrefix"      -> "http://uri",
    "staticHmrcFrontendVersion" -> "v1",
    "borderColour"              -> "#005EA5"
  )

  "htmlView" should {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiRemovedMemberFromOrganisationNotification.render(templateParams)
      renderedHtml.contentType should include("text/html")
      renderedHtml.body should include("User removed from your organisation in the HMRC Developer Hub")
      renderedHtml.body should include(
        s"<p style=\"margin: 0 0 30px; font-size: 19px;\">This user has been removed from the $organisationName organisation.</p>"
      )
      renderedHtml.body should include(s"<p style=\"margin: 0 0 30px; font-size: 19px;\">Email address: $emailAddress</p>")
      renderedHtml.body should include(s"<p style=\"margin: 0 0 30px; font-size: 19px;\">Role: $role</p>")
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">They no longer have access to your organisation's Production applications.</p>")
    }
  }

  "textView" should {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiRemovedMemberFromOrganisationNotification.render(templateParams)
      renderedTxt.contentType should include("text/plain")
      renderedTxt.body should include("User removed from your organisation in the HMRC Developer Hub")
      renderedTxt.body should include(s"This user has been removed from the $organisationName organisation.")
      renderedTxt.body should include(s"Email address: $emailAddress")
      renderedTxt.body should include(s"Role: $role")
      renderedTxt.body should include("They no longer have access to your organisation's Production applications.")
    }
  }
}
