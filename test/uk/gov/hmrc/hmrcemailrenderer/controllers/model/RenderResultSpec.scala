/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.controllers.model

import com.ning.http.util.Base64
import play.api.libs.json._
import uk.gov.hmrc.play.test.UnitSpec

class RenderResultSpec extends UnitSpec {
  "RenderResult" should {

    def decode(value: String): String = new String(Base64.decode(value), "UTF-8")

    "have the plain and html fields Base64 encoded when rendered as JSON" in {
      val result = Json.toJson(RenderResult("Some Plain Text", "<p>Some HTML</p>", "fromAddress", "subject", "service", None))

      (result \ "plain").as[String] shouldBe "U29tZSBQbGFpbiBUZXh0"
      decode((result \ "plain").as[String]) shouldBe "Some Plain Text"
      (result \ "html").as[String] shouldBe "PHA+U29tZSBIVE1MPC9wPg=="
      decode((result \ "html").as[String]) shouldBe "<p>Some HTML</p>"
      (result \ "priority").asOpt[String] shouldBe None
    }
  }
}
