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

package uk.gov.hmrc.hmrcemailrenderer.templates.helpers

import uk.gov.hmrc.play.test.UnitSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.helpers.VrnFormatter._

class VRNFormatterSpec extends UnitSpec {
    "The VRN Formatter" should {

      "convert a 12 character VRN string into a user friendly format" in {
        formatVrn("1234567890") should be("123 45678 90")
      }
    }
}
