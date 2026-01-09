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

package uk.gov.hmrc.hmrcemailrenderer.services

import play.api.Configuration
import uk.gov.hmrc.hmrcemailrenderer.config.AppConfig
import uk.gov.hmrc.hmrcemailrenderer.utils.SpecBase
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

import java.time.LocalDate

class DateTimeServiceSpec extends SpecBase {

  "systemDate" should {

    "return current date when feature flag is disabled" in {
      val config = Configuration(
        "features.enable-fixed-system-date" -> false
      )

      val configWithFlagDisabled: ServicesConfig = new ServicesConfig(config)

      val currentDate: LocalDate = LocalDate.now()

      val result: LocalDate = dateTimeService(config, configWithFlagDisabled).systemDate()

      result mustBe an[LocalDate]

      result.getMonth.getValue mustBe currentDate.getMonth.getValue
      result.getDayOfMonth mustBe currentDate.getDayOfMonth
    }

    "return  the customised date when feature flag is enabled and config values for date are present" in {
      val config = Configuration(
        "features.enable-fixed-system-date" -> true,
        "features.fixed-system-date-month"  -> 3
      )

      val configWithFlagDisabled: ServicesConfig = new ServicesConfig(config)

      val currentDate: LocalDate = LocalDate.now()
      val result: LocalDate = dateTimeService(config, configWithFlagDisabled).systemDate()

      result mustBe an[LocalDate]

      result.getMonth.getValue must be(3)
      result.getDayOfMonth must be(1)
      result.getYear mustBe currentDate.getYear
    }

    "return the customised default date when feature flag is enabled and config value for date is not present" in {
      val config = Configuration(
        "features.enable-fixed-system-date" -> true
      )

      val configWithFlagDisabled: ServicesConfig = new ServicesConfig(config)

      val currentDate: LocalDate = LocalDate.now()
      val result: LocalDate = dateTimeService(config, configWithFlagDisabled).systemDate()

      result mustBe an[LocalDate]

      result.getMonth.getValue must be(2)
      result.getDayOfMonth must be(1)
      result.getYear mustBe currentDate.getYear
    }
  }

  def dateTimeService(config: Configuration, servicesConfig: ServicesConfig): DateTimeService = {
    val appConfig = new AppConfig(config, servicesConfig)
    new DateTimeService(appConfig)
  }
}
