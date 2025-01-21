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
import CdsDdiTemplateParameters.CdsRegime._

object CdsDdiTemplateParameters {

  sealed trait CdsRegime

  object CdsRegime {
    case object Cds extends CdsRegime

    case object Atwd extends CdsRegime

    case object Extp extends CdsRegime

    case object Exts extends CdsRegime

    case object Brvt extends CdsRegime

  }

  private val regimeKey: String = "cds_regime"

  def regime(fromParams: Map[String, Any]): CdsRegime =
    fromParams
      .get(regimeKey)
      .map { value =>
        value.toString.toLowerCase match {
          case "cds"  => Cds
          case "atwd" => Atwd
          case "extp" => Extp
          case "exts" => Exts
          case "brvt" => Brvt
          case other  => sys.error(s"Unknown CDS regime: $other")
        }
      }
      .getOrElse(Cds)

  def isDutyDeferment(fromParams: Map[String, Any]): Boolean =
    regime(fromParams) match {
      case Cds | Atwd         => true
      case Extp | Exts | Brvt => false
    }

  def regimeName(fromParams: Map[String, Any]): String =
    regime(fromParams) match {
      case Cds | Atwd => "HMRC Duty Deferred"
      case Extp       => "Tobacco Products Duty (TP7)"
      case Exts       => "Export Tax Shops"
      case Brvt       => "Beer Duty VAT (EX46)"
    }

  def `ifYouWantToContinueTo...`(formParams: Map[String, Any]): String =
    if (isDutyDeferment(formParams)) "use your duty deferment account" else "pay by Direct Debit"

  def `toPayYour...`(formParams: Map[String, Any]): String =
    regime(formParams) match {
      case Cds | Atwd => "duty deferment account balance"
      case Extp       => "Tobacco Products Duty return"
      case Exts       => "Export Tax Shops return"
      case Brvt       => "Beer Duty VAT return"
    }

  def ddiSetUpMessage(formParams: Map[String, Any]): String =
    if (isDutyDeferment(formParams)) "A Direct Debit is active on your duty deferment account."
    else "Your Direct Debit is active."

}
