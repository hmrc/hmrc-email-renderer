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

package uk.gov.hmrc.hmrcemailrenderer.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import play.api.libs.json._
import uk.gov.hmrc.hmrcemailrenderer.model.Language._

class LanguageSpec extends AnyWordSpec with Matchers {
  "Language" should {
    "write to Json" in {
      Json.toJson[Language](English) shouldBe JsString("en")
      Json.toJson[Language](Welsh) shouldBe JsString("cy")
    }
    "read from Json" in {
      JsString("en").as[Language] shouldBe English
      JsString("cy").as[Language] shouldBe Welsh
      JsString("jpn").as[Language] shouldBe English
      JsString("cY").as[Language] shouldBe Welsh
      JsString("En").as[Language] shouldBe English
      Json.obj("reason" -> "reason", "status" -> "Rendering of template failed").as[Language] shouldBe English
    }
  }
}
