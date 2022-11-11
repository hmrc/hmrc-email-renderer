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

final case class TdqFphReportParams(
  developerName: String,
  applicationName: String,
  applicationId: String,
  fromDate: String,
  toDate: String,
  month: String,
  year: Int,
  status: Status,
  regimeShortForm: String,
  regimeLongForm: String,
  allHeadersMissingPercentage: Int,
  invalidConnectionMethodPercentage: Int,
  allHeadersMissingCount: Int,
  invalidConnectionMethodCount: Int,
  relatesToMultipleVersions: Boolean,
  extraDetails: Option[ValidConnectionMethodBase64EncodedDetails],
  hasOtherConnectionMethods: Boolean
) {

  def hasAllHeadersMissing: Boolean = allHeadersMissingPercentage > 0

  def hasInvalidConnectionMethod: Boolean = invalidConnectionMethodPercentage > 0

  def hasWarnings: Boolean = extraDetails.exists(_.headerValidations.exists(_.warnings.nonEmpty))

  def hasErrors: Boolean = extraDetails.exists(_.headerValidations.exists(_.errors.nonEmpty))

  def statusContents: Seq[String] = status match {
    case AllRequiredHeadersMissing =>
      Seq(
        "Your application has missing fraud prevention headers.",
        s"In production, so far in $month $year, $applicationName does not meet the fraud prevention specification."
      )
    case InvalidConnectionMethod =>
      Seq(
        "Your application has an invalid connection method in some requests.",
        s"In production, so far in $month $year, $applicationName does not meet the fraud prevention specification."
      )
    case HeadersWithErrors =>
      Seq(
        "Your application’s fraud prevention headers have errors.",
        s"In production, so far in $month $year, $applicationName does not meet the fraud prevention specification."
      )
    case HeadersWithWarnings =>
      Seq(
        "Your application’s fraud prevention headers have advisories.",
        s"In production, so far in $month $year, $applicationName has advisories that you need to review."
      )
    case HeadersHeuristicallyCompliant =>
      Seq(
        "Your application’s fraud prevention headers are correct.",
        s"In production, so far in $month $year, $applicationName meets the fraud prevention specification."
      )
  }

  val actionContent: String = status match {
    case AllRequiredHeadersMissing     => "find out how to fix issues with your headers"
    case InvalidConnectionMethod       => "find out how to fix issues with your headers"
    case HeadersWithErrors             => "find out which errors you need to fix"
    case HeadersWithWarnings           => "find out which advisories you need to review"
    case HeadersHeuristicallyCompliant => "make sure your application keeps meeting the specification"
  }
}

object TdqFphReportParams {

  def apply(params: Map[String, Any]): TdqFphReportParams =
    TdqFphReportParams(
      params("developerName").toString,
      params("applicationName").toString,
      params("applicationId").toString,
      params("fromDate").toString,
      params("toDate").toString,
      params("month").toString,
      params("year").toString.toInt,
      Status.forName(params("status").toString),
      params("regimeShortForm").toString,
      params("regimeLongForm").toString,
      params.get("allHeadersMissingPercentage").fold(0)(_.toString.toInt),
      params.get("invalidConnectionMethodPercentage").fold(0)(_.toString.toInt),
      params.get("allHeadersMissingCount").fold(0)(_.toString.toInt),
      params.get("invalidConnectionMethodCount").fold(0)(_.toString.toInt),
      params.get("relatesToMultipleVersions").fold(false)(_.toString.toBoolean),
      params.get("extraDetails").map(details => ValidConnectionMethodBase64EncodedDetails.parse(details.toString)),
      params.get("hasOtherConnectionMethods").fold(false)(_.toString.toBoolean)
    )

}
