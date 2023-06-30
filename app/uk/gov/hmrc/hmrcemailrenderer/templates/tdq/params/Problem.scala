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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params

import play.api.libs.json.{ Json, Reads }

import java.text.DecimalFormat
import scala.annotation.tailrec

final case class Problem(message: String, percentage: Int, count: Int) {

  val percentageDescription: String =
    if (percentage < 1) {
      "found in fewer than 1% of your requests"
    } else {
      s"found in $percentage% of your requests"
    }

  val shortPercentageDescription: String =
    if (percentage < 1) {
      "Fewer than 1% of total"
    } else {
      s"$percentage% of total"
    }

  val prettyCount: String = {
    val suffix = if (count > 1) "requests" else "request"
    s"${Problem.prettyCount(count)} $suffix"
  }
}

object Problem {

  implicit val reads: Reads[Problem] = Json.reads[Problem]

  private[tdq] def prettyCount(count: Int): String = {

    val siPrefixes: Seq[String] = Seq("", "k", "m", "b")
    val decimalFormat: DecimalFormat = new DecimalFormat("#.#")
    val thousand: Double = 1000.0

    def format(double: Double): String = {
      val rounded = BigDecimal(double).setScale(1, BigDecimal.RoundingMode.FLOOR).toDouble
      decimalFormat.format(rounded)
    }

    @tailrec def loop(d: Double, prefixes: Seq[String]): String =
      if (prefixes.isEmpty) {
        format(d)
      } else if (d < thousand) {
        if (d < 10) {
          format(d) + prefixes.head
        } else {
          s"${d.toInt}${prefixes.head}"
        }
      } else {
        loop(d / thousand, prefixes.tail)
      }

    if (count < 0) {
      "-" + loop(Math.abs(count.toDouble), siPrefixes)
    } else {
      loop(count.toDouble, siPrefixes)
    }
  }
}
