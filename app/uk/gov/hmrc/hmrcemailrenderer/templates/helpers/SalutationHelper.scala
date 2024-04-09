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

import uk.gov.hmrc.lingua.NameCase
import Salutation.{ EnglishSalutation, WelshSalutation }
import DefaultName.{ DefaultEnglishName, DefaultWelshName }

object SalutationHelper {

  private def capitalised(param: Option[Any]) =
    param.map { value =>
      val buffer = scala.collection.mutable.ArrayBuffer.empty[Char]
      buffer ++= value.toString
      buffer.zipWithIndex.map { case (char, idx) =>
        if (idx == 0 || !buffer(idx - 1).isLetter) {
          char.toUpper
        } else {
          char.toLower
        }
      }.mkString
    }

  def salutationFrom(params: Map[String, Any], isWelsh: Boolean = false): String = {

    val defaultName = if (isWelsh) DefaultWelshName else DefaultEnglishName
    val salutation = if (isWelsh) WelshSalutation else EnglishSalutation

    val salutationParams = (
      capitalised(params.getNonEmpty("recipientName_title")),
      capitalised(params.getNonEmpty("recipientName_surname")),
      params.getNonEmpty("recipientName_line1").map { line1 =>
        NameCase.nc(s"$line1")
      }
    )

    salutationParams match {
      case (Some(title), Some(surname), _) => s"$salutation $title $surname"
      case (_, _, Some(line1))             => s"$salutation $line1"
      case _                               => s"$salutation $defaultName"
    }
  }

  def informalSalutationFrom(params: Map[String, Any]): String = {
    val salutationParams: List[Option[String]] = List(
      capitalised(params.getNonEmpty("recipientName_forename")),
      capitalised(params.getNonEmpty("recipientName_surname"))
    )

    salutationParams match {
      case List(Some(forename), Some(surname)) => s"$EnglishSalutation $forename $surname"
      case _                                   => s"$EnglishSalutation $DefaultEnglishName"
    }
  }

  def saluteFullName(params: Map[String, Any], isWelsh: Boolean = false): String = {
    val defaultName = if (isWelsh) DefaultWelshName else DefaultEnglishName
    val salutation = if (isWelsh) WelshSalutation else EnglishSalutation

    val salutationParams: List[Option[String]] = List(
      capitalised(params.getNonEmpty("recipientName_FullName"))
    )

    salutationParams match {
      case List(Some(fullName)) => s"$salutation $fullName"
      case _                    => s"$salutation $defaultName"
    }
  }

  private implicit class ParamsOps(params: Map[String, Any]) {
    def getNonEmpty(key: String): Option[Any] =
      params.get(key) match {
        case Some(value) if value.toString.trim.length > 0 => Some(value)
        case _                                             => None
      }
  }
}

object Salutation {
  val WelshSalutation = "Annwyl"
  val EnglishSalutation = "Dear"
}

object DefaultName {
  val DefaultWelshName = "Gwsmer"
  val DefaultEnglishName = "Customer"
}
