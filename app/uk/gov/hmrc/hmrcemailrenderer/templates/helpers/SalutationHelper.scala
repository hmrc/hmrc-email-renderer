/*
 * Copyright 2020 HM Revenue & Customs
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

object SalutationHelper {

  def capitalised(param: Option[Any]) =
    param.map { value =>
      val buffer = scala.collection.mutable.ArrayBuffer.empty[Char]
      value.toString.copyToBuffer(buffer)
      buffer.zipWithIndex.map { case (char, idx) =>
        if (idx == 0 || !buffer(idx - 1).isLetter) char.toUpper
        else char.toLower
      }.mkString
    }

  def salutationFrom(params: Map[String, Any]): String = {
    val salutationParams = (
      capitalised(params.getNonEmpty("recipientName_title")),
      capitalised(params.getNonEmpty("recipientName_surname")),

      params.getNonEmpty("recipientName_line1").map{line1 => NameCase.nc(s"${line1}")}
    )

    salutationParams match {
      case (Some(title), Some(surname), _) => s"Dear $title $surname"
      case (_, _, Some(line1)) => s"Dear $line1"
      case _ => "Dear Customer"
    }
  }

  def informalSalutationFrom(params: Map[String, Any]): String = {
    val salutationParams: List[Option[String]] = List(
      capitalised(params.getNonEmpty("recipientName_forename")),
      capitalised(params.getNonEmpty("recipientName_surname"))
    )

    salutationParams match {
      case List(Some(forename), Some(surname)) => s"Dear $forename $surname"
      case _ => "Dear Customer"
    }
  }

  def saluteFullName(params: Map[String, Any]): String = {
    val salutationParams: List[Option[String]] = List(
      capitalised(params.getNonEmpty("recipientName_FullName"))
    )

    salutationParams match {
      case List(Some(fullName)) => s"Dear $fullName"
      case _ => "Dear Customer"
    }
  }

  private implicit class ParamsOps(params: Map[String,Any]){
    def getNonEmpty(key: String): Option[Any] = {
      params.get(key) match {
        case Some(value) if value.toString.trim.length > 0 => Some(value)
        case _ => None
      }
    }
  }
}
