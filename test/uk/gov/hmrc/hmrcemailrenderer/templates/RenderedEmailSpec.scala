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

package uk.gov.hmrc.hmrcemailrenderer.templates

import junit.framework.TestCase
import org.scalatest.TestData
import org.scalatestplus.play._
import play.api.test.{FakeApplication}
import play.twirl.api.Html

trait BorderSpec extends PlaySpec with OneAppPerTest {

  def assertBorder(expectedColor: String) = {
    val renderValues = Map("staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1")
    val result = helpers.html.template_main.render(renderValues, "Test", true, None, true, Html("<html></html>"))
    result.body must include("<td width=\"30\" style=\"font-family: Helvetica, Arial, sans-serif; padding: 4px 0; border-bottom: solid 10px " + expectedColor)
    result.body must include("<td style=\"font-family: Helvetica, Arial, sans-serif; padding: 4px 0; border-bottom: solid 10px " + expectedColor)
    result.contentType must include( "text/html" )
  }
}

class BorderFromConfigSpec extends BorderSpec  {

  override def newAppForTest(testData: TestData) =
    FakeApplication(additionalConfiguration = Map("border.color" -> "#012345"))

  "emailRenderedView" must {
    "have a border color from config" in new TestCase {
      app.configuration.getString("border.color") mustBe Some("#012345")
      assertBorder("#012345")
    }
  }
}

class BorderFromDefaultSpec extends BorderSpec {

  "emailRenderedView" must {
    "have a default border color" in new TestCase {
      app.configuration.getString("border.color") mustBe None
      assertBorder("#005EA5")
    }
  }
}
