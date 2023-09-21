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

package uk.gov.hmrc.hmrcemailrenderer.templates.onlinepaymentservice

import java.util.{ Currency, Locale }
import play.api.Logging

import scala.util.Try
import scala.util.control.NonFatal

object AmountFormatter extends Logging {

  private val formatter = {
    Locale.setDefault(Locale.UK)
    val en = Currency.getInstance(Locale.UK)
    val f = java.text.NumberFormat.getCurrencyInstance
    f.setCurrency(en)
    f
  }

  def formatAmount(amount: String): String = formatter.format(toDouble(amount))
  def formatAmountInPence(amountInPence: String): String = formatter.format(toDouble(amountInPence) / 100)
  def formatAmountInPenceGdsFormat(amountInPence: String): String = formatter.format(toDouble(amountInPence) / 100)
    .replace(".00", "")

  private def toDouble(s: String): Double =
    Try(s.toDouble)
      .recover {
        case NonFatal(e) => logger.warn(s"Amount formatter number parse exception: ${e.getMessage}"); 0D
      }
      .getOrElse(0D)

}
