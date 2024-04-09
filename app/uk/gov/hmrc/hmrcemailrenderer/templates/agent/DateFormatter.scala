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

package uk.gov.hmrc.hmrcemailrenderer.templates.agent

import play.api.Logging

import scala.util.Try
import scala.util.control.NonFatal

object DateFormatter extends Logging {

  def formatMonth(month: String): String = month match {
    case "01" => "January"
    case "02" => "February"
    case "03" => "March"
    case "04" => "April"
    case "05" => "May"
    case "06" => "June"
    case "07" => "July"
    case "08" => "August"
    case "09" => "September"
    case "10" => "October"
    case "11" => "November"
    case "12" => "December"
    case _    => month
  }

  def formatDate(yyyymmdd: String): String = {
    val year = yyyymmdd.slice(0, 4)
    val month = yyyymmdd.slice(4, 6)
    val day = yyyymmdd.slice(6, 8)
    s"${formatDay(day)} ${formatMonth(month)} $year"
  }

  private def formatDay(day: String): String =
    Try(day.toInt.toString)
      .recover { case NonFatal(e) =>
        logger.warn(s"Day parse exception: ${e.getMessage}"); day
      }
      .getOrElse(day)

}
