/*
 * Copyright 2016 HM Revenue & Customs
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
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import play.api.libs.json._
import uk.gov.hmrc.play.test.UnitSpec
import org.scalacheck.{Arbitrary, Gen}
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority

class RenderResultSpec extends UnitSpec with GeneratorDrivenPropertyChecks {
  "RenderResult" should {

    implicit val nonEmptyStrings: Arbitrary[String] = Arbitrary(Arbitrary.arbString.arbitrary.suchThat(_.nonEmpty))

    def decode(value: String): String = new String(Base64.decode(value), "UTF-8")

    "have the plain and html fields Base64 encoded when rendered as JSON" in forAll { (plain: String, html: String) =>
      val result = Json.toJson(
        RenderResult(
          plain,
          html,
          "fromAddress",
          "subject",
          "service",
          MessagePriority.Standard
        )
      )

      decode((result \ "plain").as[String]) shouldBe plain
      decode((result \ "html").as[String]) shouldBe html
    }
  }
}
