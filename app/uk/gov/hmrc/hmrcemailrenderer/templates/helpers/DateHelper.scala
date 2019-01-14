/*
 * Copyright 2019 HM Revenue & Customs
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

import org.joda.time.LocalDate
import org.joda.time.format.{ISODateTimeFormat, DateTimeFormat}

import scala.util.Try

object DateHelper {
  private val isoDateFormatter = ISODateTimeFormat.yearMonthDay()
  private val messageDateFormatter = DateTimeFormat.forPattern("d MMMM yyyy")

  def parseIsoDate(isoDate: String): LocalDate = isoDateFormatter.parseLocalDate(isoDate)

  def formatLocalDate(date: LocalDate): String = messageDateFormatter.print(date)

  // To ensure that emails are always sent, be tolerant of any failure to provide dates in ISO format
  def asUserDate(isoDate: Any): String = Try(formatLocalDate(parseIsoDate(isoDate.toString))) getOrElse isoDate.toString
}
