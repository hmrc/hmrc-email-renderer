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

import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

import javax.inject.{ Inject, Singleton }
import scala.util.{ Failure, Success, Try }

@Singleton
class AppConfig @Inject() (servicesConfig: ServicesConfig) {

  lazy val isFixedSystemDateEnabled: Boolean = Try(
    servicesConfig.getBoolean("features.fixed-system-date.enabled")
  ) match {
    case Success(value) => value
    case Failure(_)     => false
  }

  lazy val fixedSystemDateDay: Int = {
    val defaultDayValue = 1

    Try(servicesConfig.getInt("features.fixed-system-date.day")) match {
      case Success(value) => if (value >= 1 && value <= 31) value else defaultDayValue
      case Failure(_)     => defaultDayValue
    }
  }

  lazy val fixedSystemDateMonth: Int = {
    val defaultMonthValue = 2

    Try(servicesConfig.getInt("features.fixed-system-date.month")) match {
      case Success(value) => if (value >= 1 && value <= 12) value else defaultMonthValue
      case Failure(_)     => defaultMonthValue
    }
  }

  lazy val preferencesServiceBaseUrl: String = servicesConfig.baseUrl("preferences")
}
