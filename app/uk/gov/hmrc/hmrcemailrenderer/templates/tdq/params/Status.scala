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

import play.api.libs.json.{ JsError, JsString, JsSuccess, Reads, Writes }

sealed abstract class Status(val name: String, val subjectVerb: String, val action: String)
    extends Product with Serializable {
  override val toString: String = name
  def contents(applicationName: String, month: String, year: Int): Seq[String]
}

case object NoRequests extends Status("NO_REQUESTS", "Check", "check the status of your application") {
  override def contents(applicationName: String, month: String, year: Int): Seq[String] = Seq(
    s"$applicationName has not sent any requests so far in $month $year."
  )
}

case object AllRequiredHeadersMissing
    extends Status("ALL_REQUIRED_HEADERS_MISSING", "Submit", "find out how to fix issues with your headers") {
  override def contents(applicationName: String, month: String, year: Int): Seq[String] = Seq(
    "Your application has missing fraud prevention headers.",
    s"In production, so far in $month $year, $applicationName does not meet the fraud prevention specification."
  )
}

case object InvalidConnectionMethod
    extends Status("INVALID_CONNECTION_METHOD", "Submit", "find out how to fix issues with your headers") {
  override def contents(applicationName: String, month: String, year: Int): Seq[String] = Seq(
    "Your application has an invalid connection method in some requests.",
    s"In production, so far in $month $year, $applicationName does not meet the fraud prevention specification."
  )
}

case object HeadersWithErrors extends Status("HEADERS_WITH_ERRORS", "Fix", "find out which errors you need to fix") {
  override def contents(applicationName: String, month: String, year: Int): Seq[String] = Seq(
    "Your application’s fraud prevention headers have errors.",
    s"In production, so far in $month $year, $applicationName does not meet the fraud prevention specification."
  )
}

case object HeadersWithWarnings
    extends Status("HEADERS_WITH_WARNINGS", "Improve", "find out which advisories you need to review") {
  override def contents(applicationName: String, month: String, year: Int): Seq[String] = Seq(
    "Your application’s fraud prevention headers have advisories.",
    s"In production, so far in $month $year, $applicationName has advisories that you need to review."
  )
}

case object HeadersHeuristicallyCompliant
    extends Status("HEADERS_HEURISTICALLY_COMPLIANT", "", "make sure your application keeps meeting the specification") {
  override def contents(applicationName: String, month: String, year: Int): Seq[String] = Seq(
    "Your application’s fraud prevention headers are correct.",
    s"In production, so far in $month $year, $applicationName meets the fraud prevention specification."
  )
}

object Status {

  private val all: Seq[Status] = List(
    NoRequests,
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
