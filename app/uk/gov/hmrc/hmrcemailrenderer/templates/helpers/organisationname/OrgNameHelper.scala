/*
 * Copyright 2018 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.helpers.organisationname

object OrgNameHelper {

  def capitalised(param: Option[Any]) =
    param.map { value =>
      val buffer = scala.collection.mutable.ArrayBuffer.empty[Char]
      value.toString.copyToBuffer(buffer)
      buffer.zipWithIndex.map { case (char, idx) =>
        if (idx == 0 || !buffer(idx - 1).isLetter) char.toUpper
        else char.toLower
      }.mkString
    }


  def orgNameOrIndividual(params: Map[String, Any]): String = {
    val orgNameParams: List[Option[String]] = List(
      capitalised(params.getNonEmpty("recipientOrgName"))
    )

    orgNameParams match {
      case List(Some(orgName)) => s"$orgName is"
      case _ => "You are"
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
