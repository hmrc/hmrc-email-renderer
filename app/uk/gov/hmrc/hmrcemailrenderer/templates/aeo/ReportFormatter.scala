/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.aeo

import java.util.Base64
import play.api.libs.json._
import java.nio.charset.StandardCharsets
import java.time.format.DateTimeFormatter
import java.time.{ Instant, ZoneId, ZoneOffset }

object ReportFormatter {

  final case class Row(
    sendingCountry: String,
    receivingCountry: String,
    status: String,
    dateTime: Instant
  )

  implicit val rowReads = Json.reads[Row]

  def timeFormat(dateTime: Instant): String =
    DateTimeFormatter.RFC_1123_DATE_TIME
      .withZone(ZoneId.from(ZoneOffset.UTC))
      .format(dateTime)

  def parseRows(base64Rows: String): List[Row] = {
    val decoded = new String(Base64.getDecoder().decode(base64Rows), "UTF-8")
    Json.parse(decoded).as[List[Row]]
  }

}
