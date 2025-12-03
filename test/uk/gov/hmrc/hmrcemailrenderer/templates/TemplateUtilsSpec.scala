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

package uk.gov.hmrc.hmrcemailrenderer.templates

import org.scalatestplus.play.PlaySpec

import java.time.LocalDate

class TemplateUtilsSpec extends PlaySpec {

  "isP2TemplateAnnual" should {
    "return true when current date is between February and April 5th () otherwise return false" in {
      val currentDate = LocalDate.now()

      if (
        (currentDate.getMonthValue == 2)
        || (currentDate.getMonthValue == 3)
        || (currentDate.getMonthValue == 4 && currentDate.getDayOfMonth <= 5)
      ) {
        println("======== inside true1 =======")
        TemplateUtils.isP2TemplateAnnual mustBe {
          println("======== inside true =======")
          true
        }
      } else {
        println("======== inside false =======")
        TemplateUtils.isP2TemplateAnnual mustBe false
      }
    }
  }

  "currentYear" should {
    "return the correct value of year" in {
      val currentYearValue = TemplateUtils.currentYear
      println("====== yesr is ========" + currentYearValue)
      currentYearValue must be > 0
      currentYearValue.toString.length must be >= 4
    }
  }
}
