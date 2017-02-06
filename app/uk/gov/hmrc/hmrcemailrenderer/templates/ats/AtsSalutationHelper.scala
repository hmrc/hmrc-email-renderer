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

package uk.gov.hmrc.hmrcemailrenderer.templates.ats

object AtsSalutationHelper {
  def salutationFrom(salutationParams: Map[String, Any]) = {
    (salutationParams.get("recipientName_title"),
      salutationParams.get("recipientName_forename"),
      salutationParams.get("recipientName_surname")) match {
     case (_, Some(forename), _) => s"Dear $forename"
     case (Some(title), None, Some(surname)) => s"Dear $title $surname"
     case _ => "Dear customer"
   }
  }
}
