/*
 * Copyright 2025 HM Revenue & Customs
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

import org.mockito.Mockito.when
import org.scalatestplus.mockito.MockitoSugar.mock
import uk.gov.hmrc.hmrcemailrenderer.config.AppConfig
import uk.gov.hmrc.hmrcemailrenderer.utils.SpecBase

import java.time.LocalDate

class TemplateUtilsSpec extends SpecBase {

  "isP2TemplateAnnual" should {
    "return true when current date is between February and April 5th (April 5th included) otherwise return false" in {
      val currentDate = LocalDate.now()

      if (
        (currentDate.getMonthValue == 2)
        || (currentDate.getMonthValue == 3)
        || (currentDate.getMonthValue == 4 && currentDate.getDayOfMonth <= 5)
      ) {
        TemplateUtils.isP2TemplateAnnual() mustBe true
      } else {
        TemplateUtils.isP2TemplateAnnual() mustBe false
      }
    }

    "return true when fixed system date feature is enabled and date is between Feb and 5th of April" in {
      val appConfigMock: AppConfig = mock[AppConfig]

      when(appConfigMock.isFixedSystemDateEnabled).thenReturn(true)
      when(appConfigMock.fixedSystemDateDay).thenReturn(2)
      when(appConfigMock.fixedSystemDateMonth).thenReturn(3)

      TemplateUtils.isP2TemplateAnnual(appConfigMock) mustBe true
    }

    "return false when fixed system date feature is enabled and date is not between Feb and 5th of April" in {
      val day6th = 6
      val month5 = 5

      val appConfigMock: AppConfig = mock[AppConfig]

      when(appConfigMock.isFixedSystemDateEnabled).thenReturn(true)
      when(appConfigMock.fixedSystemDateDay).thenReturn(day6th)
      when(appConfigMock.fixedSystemDateMonth).thenReturn(month5)

      TemplateUtils.isP2TemplateAnnual(appConfigMock) mustBe false
    }

    "return true/false accordingly when fixed system date feature is disabled and current date falls" +
      " within Feb and 5th April or not" in {
        val appConfigMock: AppConfig = mock[AppConfig]
        val currentDate = LocalDate.now()

        when(appConfigMock.isFixedSystemDateEnabled).thenReturn(false)

        if (
          (currentDate.getMonthValue == 2)
          || (currentDate.getMonthValue == 3)
          || (currentDate.getMonthValue == 4 && currentDate.getDayOfMonth <= 5)
        ) {
          TemplateUtils.isP2TemplateAnnual(appConfigMock) mustBe true
        } else {
          TemplateUtils.isP2TemplateAnnual(appConfigMock) mustBe false
        }
      }
  }

  "currentYear" should {
    "return the correct value of year" in {
      val currentYearValue = TemplateUtils.currentYear

      currentYearValue must be > 0
      currentYearValue.toString.length must be >= 4
    }
  }
}
