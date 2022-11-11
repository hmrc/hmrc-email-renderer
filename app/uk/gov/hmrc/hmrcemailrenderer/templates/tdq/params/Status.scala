/*
 * Copyright 2022 HM Revenue & Customs
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

import play.api.libs.json.{ JsError, JsString, JsSuccess, Reads, Writes }

sealed abstract class Status(val name: String) extends Product with Serializable {
  override val toString: String = name
}

case object AllRequiredHeadersMissing extends Status("ALL_REQUIRED_HEADERS_MISSING")
case object InvalidConnectionMethod extends Status("INVALID_CONNECTION_METHOD")
case object HeadersWithErrors extends Status("HEADERS_WITH_ERRORS")
case object HeadersWithWarnings extends Status("HEADERS_WITH_WARNINGS")
case object HeadersHeuristicallyCompliant extends Status("HEADERS_HEURISTICALLY_COMPLIANT")

object Status {

  private val all: Seq[Status] = List(
    AllRequiredHeadersMissing,
    InvalidConnectionMethod,
    HeadersWithErrors,
    HeadersWithWarnings,
    HeadersHeuristicallyCompliant
  )

  def forNameOption(s: String): Option[Status] = all.find(_.name.equalsIgnoreCase(s))

  def forName(s: String): Status = forNameOption(s) match {
    case Some(status) => status
    case None         => throw new IllegalArgumentException(s"Value: '$s' is not a valid Status")
  }

  implicit val jsonReads: Reads[Status] = Reads { json =>
    json.validate[String].flatMap { s =>
      forNameOption(s) match {
        case Some(status) => JsSuccess(status)
        case None         => JsError(s"Value: '$s' is not a valid Status")
      }
    }
  }

  implicit val jsonWrites: Writes[Status] = Writes(status => JsString(status.name))

}
