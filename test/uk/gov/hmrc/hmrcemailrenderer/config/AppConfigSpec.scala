/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.config

import play.api.Configuration
import uk.gov.hmrc.hmrcemailrenderer.utils.SpecBase
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

class AppConfigSpec extends SpecBase {

  "preferencesServiceBaseUrl" should {
    "return correct value of url" in {
      appConfig.preferencesServiceBaseUrl must be("http://localhost:8025")
    }
  }

  "isFixedSystemDateEnabled" should {
    "return correct value of feature flag" when {

      "fixed system date is disabled" in {
        appConfig.isFixedSystemDateEnabled must be(false)
      }

      "fixed system date feature config is absent" in {
        val config = Configuration(
          "unknown" -> "test"
        )

        val servicesConfigWithNoFeatureValue: ServicesConfig = new ServicesConfig(config)

        val appConfig = applicationConfig(servicesConfigWithNoFeatureValue)

        appConfig.isFixedSystemDateEnabled must be(false)
      }

      "fixed system date is enabled" in {
        val config = Configuration(
          "features.fixed-system-date.enabled" -> true
        )

        val servicesConfigWithFeatureEnabled: ServicesConfig = new ServicesConfig(config)

        val appConfig = applicationConfig(servicesConfigWithFeatureEnabled)

        appConfig.isFixedSystemDateEnabled must be(true)
      }
    }
  }

  "fixedSystemDateDay" should {
    "return correct value of fixed system date day" when {
      "config value is valid" in {
        appConfig.fixedSystemDateDay must be(1)
      }

      "config value is invalid" in {
        val config1 = Configuration(
          "features.fixed-system-date.enabled" -> true,
          "features.fixed-system-date.day"     -> "abc"
        )

        val config2 = Configuration(
          "features.fixed-system-date.enabled" -> true,
          "features.fixed-system-date.day"     -> 42
        )

        val config3 = Configuration(
          "features.fixed-system-date.enabled" -> true,
          "features.fixed-system-date.day"     -> 0
        )

        val servicesConfigWithInvalidDayValue1: ServicesConfig = new ServicesConfig(config1)
        val servicesConfigWithInvalidDayValue2: ServicesConfig = new ServicesConfig(config2)
        val servicesConfigWithInvalidDayValue3: ServicesConfig = new ServicesConfig(config3)

        val appConfig1: AppConfig = applicationConfig(servicesConfigWithInvalidDayValue1)
        val appConfig2: AppConfig = applicationConfig(servicesConfigWithInvalidDayValue2)
        val appConfig3: AppConfig = applicationConfig(servicesConfigWithInvalidDayValue3)

        appConfig1.fixedSystemDateDay must be(1)
        appConfig2.fixedSystemDateDay must be(1)
        appConfig3.fixedSystemDateDay must be(1)
      }
    }
  }

  "fixedSystemDateMonth" should {
    "return correct value of fixed system date month" when {
      "config value is valid" in {
        appConfig.fixedSystemDateMonth must be(2)
      }

      "config value is invalid" in {
        val config1 = Configuration(
          "features.fixed-system-date.enabled" -> true,
          "features.fixed-system-date.month"   -> "abc"
        )

        val config2 = Configuration(
          "features.fixed-system-date.enabled" -> true,
          "features.fixed-system-date.day"     -> 14
        )

        val config3 = Configuration(
          "features.fixed-system-date.enabled" -> true,
          "features.fixed-system-date.day"     -> 0
        )

        val servicesConfigWithInvalidDayValue1: ServicesConfig = new ServicesConfig(config1)
        val servicesConfigWithInvalidDayValue2: ServicesConfig = new ServicesConfig(config2)
        val servicesConfigWithInvalidDayValue3: ServicesConfig = new ServicesConfig(config3)

        val appConfig1: AppConfig = applicationConfig(servicesConfigWithInvalidDayValue1)
        val appConfig2: AppConfig = applicationConfig(servicesConfigWithInvalidDayValue2)
        val appConfig3: AppConfig = applicationConfig(servicesConfigWithInvalidDayValue3)

        appConfig1.fixedSystemDateMonth must be(2)
        appConfig2.fixedSystemDateMonth must be(2)
        appConfig3.fixedSystemDateMonth must be(2)
      }
    }
  }

  def applicationConfig(servicesConfig: ServicesConfig): AppConfig =
    new AppConfig(servicesConfig)
}
