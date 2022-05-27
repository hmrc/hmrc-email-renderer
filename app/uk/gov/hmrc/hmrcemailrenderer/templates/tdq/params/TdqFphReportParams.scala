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
}

object TdqFphReportParams {

  def apply(params: Map[String, Any]): TdqFphReportParams =
    TdqFphReportParams(
      params("developerName").toString,
      params("applicationName").toString,
      params("applicationId").toString,
      params("fromDate").toString,
      params("toDate").toString,
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
