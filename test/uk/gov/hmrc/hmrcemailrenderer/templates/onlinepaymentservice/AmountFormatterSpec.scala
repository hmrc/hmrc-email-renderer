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

package uk.gov.hmrc.hmrcemailrenderer.templates.onlinepaymentservice

import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class AmountFormatterSpec extends AnyWordSpecLike with Matchers with OptionValues {

  "amount should be correctly formatted for display" in {
    AmountFormatter.formatAmount("123456789") shouldBe "£123,456,789.00"
    AmountFormatter.formatAmount("0") shouldBe "£0.00"
    AmountFormatter.formatAmount("1234") shouldBe "£1,234.00"
    AmountFormatter.formatAmount("1234sdf") shouldBe "£0.00"
    AmountFormatter.formatAmount("1234.00") shouldBe "£1,234.00"
    AmountFormatter.formatAmount("123456789.56") shouldBe "£123,456,789.56"
  }
  "amount should be correctly formatted for display tps" in {
    AmountFormatter.formatAmountInPence("1233") shouldBe "£12.33"
  }

}
