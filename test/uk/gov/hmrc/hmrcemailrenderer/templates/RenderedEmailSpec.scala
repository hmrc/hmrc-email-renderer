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

package uk.gov.hmrc.hmrcemailrenderer.templates

import junit.framework.TestCase
import org.scalatest.Assertion
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import play.twirl.api.Html

trait RenderedEmailSpec extends AnyWordSpec with Matchers {

  def assertRenderedBorderMatchesGivenColour(expectedColour: String): Assertion = {
    val renderValues =
      Map("staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1", "borderColour" -> expectedColour)

    val result = helpers.html.template_main.render(renderValues, "Test", true, None, true, false, Html("<html></html>"))

    result.body should include(
      "<td width=\"30\" style=\"font-family: Helvetica, Arial, sans-serif; padding: 4px 0; border-bottom: solid 10px " + expectedColour)
    result.body should include(
      "<td style=\"font-family: Helvetica, Arial, sans-serif; padding: 4px 0; border-bottom: solid 10px " + expectedColour)
    result.contentType should include("text/html")
  }

  "emailRenderedView" should {
    "have a border colour from parameter config passed to the template" in new TestCase {
      assertRenderedBorderMatchesGivenColour("#012345")
      assertRenderedBorderMatchesGivenColour("#005EA5")
    }
  }
}
