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
import scala.util.Try

@Singleton
class AppConfig @Inject() (servicesConfig: ServicesConfig) {

  lazy val isFixedSystemDateEnabled: Boolean =
    Try(servicesConfig.getBoolean("features.fixed-system-date.enabled")).getOrElse(false)

  lazy val fixedSystemDateDay: Int = {
    val defaultDayValue = 1
    val dayValue: Int = Try(servicesConfig.getInt("features.fixed-system-date.day")).getOrElse(defaultDayValue)

    if (dayValue >= 1 && dayValue <= 31) dayValue else defaultDayValue
  }

  lazy val fixedSystemDateMonth: Int = {
    val defaultMonthValue = 2
    val monthValue = Try(servicesConfig.getInt("features.fixed-system-date.month")).getOrElse(defaultMonthValue)

    if (monthValue >= 1 && monthValue <= 12) monthValue else defaultMonthValue
  }

  lazy val preferencesServiceBaseUrl: String = servicesConfig.baseUrl("preferences")
}
