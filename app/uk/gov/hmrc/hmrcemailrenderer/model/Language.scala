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

package uk.gov.hmrc.hmrcemailrenderer.model

import enumeratum.{ Enum, EnumEntry }
import play.api.libs.json._

sealed abstract class Language(override val entryName: String) extends EnumEntry

case object Language extends Enum[Language] {

  val values = findValues

  case object English extends Language("en")

  case object Welsh extends Language("cy")

  implicit val languageReads = Reads[Language] { js =>
    js match {
      case JsString(value) => JsSuccess(Language.withNameInsensitiveOption(value).getOrElse(Language.English))
      case _               => JsSuccess(Language.English)
    }
  }
  implicit val languageWrites = new Writes[Language] {
    override def writes(e: Language): JsValue = JsString(e.entryName)
  }
}
