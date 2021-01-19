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

package uk.gov.hmrc.hmrcemailrenderer.templates.helpers

import uk.gov.hmrc.play.test.UnitSpec

class DateHelperSpec extends UnitSpec {

  "The short date formatter" should {

    "return 2 digit day and 3 letter month abbreviation in" in {
      DateHelper.shortDateFormatter("2020-04-22") shouldBe "22 Apr"
    }

    "return 1 single digit day and 3 letter month abbreviation" in {
      DateHelper.shortDateFormatter("2020-04-01") shouldBe "1 Apr"
    }

  }

}
