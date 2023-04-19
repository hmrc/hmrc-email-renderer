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
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.hmrcemailrenderer.templates.api

class ApiApplicationToBeDeletedNotificationSpec extends AnyWordSpecLike with Matchers {

  val userFirstName = "Fred"
  val userLastName = "Bloggs"
  val applicationName = "Test Application"
  val environmentName = "Sandbox"
  val timeSinceLastUse = "11 months"
  val daysToDeletion = "30 days"

  val templateParams = Map(
    "userFirstName"    -> userFirstName,
    "userLastName"     -> userLastName,
    "applicationName"  -> applicationName,
    "environmentName"  -> environmentName,
    "timeSinceLastUse" -> timeSinceLastUse,
    "daysToDeletion"   -> daysToDeletion,
    "staticAssetUrlPrefix" -> "http://uri",
    "staticAssetVersion" -> "v1",
    "borderColour" -> "#005EA5"
  )

  "htmlView" should {
    "render as" in new TestCase {
      val renderedHtml = api.html.apiApplicationToBeDeletedNotification.render(templateParams)
      renderedHtml.contentType should include("text/html")
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\">Dear " + userFirstName + " " + userLastName + "</p>"
      )
      renderedHtml.body should include(
        "<p style=\"margin: 0 0 30px; font-size: 19px;\">Your <strong>" + environmentName +
          "</strong> application <strong>" + applicationName + "</strong>" +
          " has been inactive for more than <strong>" + timeSinceLastUse +
          "</strong> and will be deleted in <strong>" + daysToDeletion + "</strong>.</p>"
      )
      renderedHtml.body should include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC Developer Hub</p>")
    }
  }

  "textView" should {
    "render as" in new TestCase {
      val renderedTxt = api.txt.apiApplicationToBeDeletedNotification.render(templateParams)
      renderedTxt.contentType should include("text/plain")
      renderedTxt.body should include(s"Dear $userFirstName $userLastName")
      renderedTxt.body should include(
        s"Your $environmentName application $applicationName " +
          s"has been inactive for more than $timeSinceLastUse and will be deleted in $daysToDeletion.")
      renderedTxt.body should include("From HMRC Developer Hub")
    }

  }
}
