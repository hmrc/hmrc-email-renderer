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

package uk.gov.hmrc.hmrcemailrenderer.templates.helpers

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateHelper {
  private val messageDateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  def formatLocalDate(date: LocalDate): String = messageDateFormatter.format(date)

  def dateFormatter(date: String): String = {
    val dateFormatter = DateTimeFormatter.ofPattern("dd MMMM")
    val convert = LocalDate.parse(date: String)
    dateFormatter.format(convert)
  }

  def shortDateFormatter(date: String): String = {
    val dateFormatter = DateTimeFormatter.ofPattern("dd MMM")
    val convert = LocalDate.parse(date: String)
    val formatted = dateFormatter.format(convert)
    if (formatted.startsWith("0")) {
      formatted.substring(1)
    } else {
      formatted
    }
  }

}
