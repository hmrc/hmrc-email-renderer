/*
 * Copyright 2017 HM Revenue & Customs
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
    val salutationParams: List[Option[String]] = List(
      capitalised(params.get("recipientName_title")),
      capitalised(params.get("recipientName_forename")),
      capitalised(params.get("recipientName_surname"))
    )

    salutationParams match {
      case List(_, Some(forename), _) => s"Dear $forename"
      case List(Some(title), _, Some(surname)) => s"Dear $title $surname"
      case _ => "Dear Customer"
    }
  }
}
