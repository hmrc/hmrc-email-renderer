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

class DateFormatterSpec extends AnyWordSpecLike with Matchers with OptionValues {

  val formatter = DateFormatter

  "formatDate should correctly format dates in" in {
    formatter.formatDate("20180101") shouldBe "1 January 2018"
    formatter.formatDate("20180201") shouldBe "1 February 2018"
    formatter.formatDate("20180301") shouldBe "1 March 2018"
    formatter.formatDate("20180401") shouldBe "1 April 2018"
    formatter.formatDate("20180501") shouldBe "1 May 2018"
    formatter.formatDate("20180601") shouldBe "1 June 2018"
    formatter.formatDate("20180701") shouldBe "1 July 2018"
    formatter.formatDate("20180801") shouldBe "1 August 2018"
    formatter.formatDate("20180901") shouldBe "1 September 2018"
    formatter.formatDate("20181001") shouldBe "1 October 2018"
    formatter.formatDate("20181101") shouldBe "1 November 2018"
    formatter.formatDate("20181201") shouldBe "1 December 2018"
    formatter.formatDate("20181301") shouldBe "1 13 2018"
    formatter.formatDate("20181205") shouldBe "5 December 2018"
    formatter.formatDate("2018120T") shouldBe "0T December 2018"
  }

  "formatPeriod should correctly format period dates" in {
    formatter.formatPeriod("0118") shouldBe "January 2018"
    formatter.formatPeriod("0219") shouldBe "February 2019"
    formatter.formatPeriod("0320") shouldBe "March 2020"
    formatter.formatPeriod("0421") shouldBe "April 2021"
    formatter.formatPeriod("0522") shouldBe "May 2022"
    formatter.formatPeriod("0623") shouldBe "June 2023"
    formatter.formatPeriod("0724") shouldBe "July 2024"
    formatter.formatPeriod("0825") shouldBe "August 2025"
    formatter.formatPeriod("0926") shouldBe "September 2026"
    formatter.formatPeriod("1027") shouldBe "October 2027"
    formatter.formatPeriod("1128") shouldBe "November 2028"
    formatter.formatPeriod("1229") shouldBe "December 2029"
  }

}
