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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ProblemSpec extends AnyWordSpec with Matchers {

  "Problem" should {

    "provide meaningful description for percentages lower than 1%" in {
      Problem("Header value is not an IP address", 1, 1).percentageDescription shouldBe "found in 1% of your requests"
      Problem("Header value is not an IP address", 0, 1).percentageDescription shouldBe "found in fewer than 1% of your requests"
    }

    "display record count in human friendly format" in {
      val numbersAndFormattedNumbers = Seq(
        (1, "1"),
        (22, "22"),
        (345, "345"),
        (999, "999"),
        (1000, "1k"),
        (5000, "5k"),
        (5001, "5k"),
        (5099, "5k"),
        (5100, "5.1k"),
        (5800, "5.8k"),
        (5876, "5.8k"),
        (10500, "10k"),
        (10999, "10k"),
        (101800, "101k"),
        (2000000, "2m"),
        (7800000, "7.8m"),
        (9999999, "9.9m"),
        (2147483647, "2.1b")
      )
      Problem.prettyCount(0) shouldBe "0"
      numbersAndFormattedNumbers.foreach {
        case (number, formatted) =>
          Problem.prettyCount(number) shouldBe formatted
          Problem.prettyCount(-number) shouldBe "-" + formatted
      }
    }
  }
}
