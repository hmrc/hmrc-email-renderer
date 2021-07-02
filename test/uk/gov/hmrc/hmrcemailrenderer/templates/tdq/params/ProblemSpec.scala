/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params

import org.scalatest.WordSpec
import org.scalatest.Matchers

class ProblemSpec extends WordSpec with Matchers {

  "Problem" should {
    "provide meaningful description for percentages lower than 1%" in {
      Problem("Header value is not an IP address", 1, 1).percentageDescription shouldBe "found in 1% of your requests"
      Problem("Header value is not an IP address", 0, 1).percentageDescription shouldBe "found in fewer than 1% of your requests"
    }
  }
}
