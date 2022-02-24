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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Tdq
import uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params.TdqFphReportParams

object TdqTemplates {

  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "tdq_fph_report_non_compliant",
      fromAddress = FromAddress.noReply("HMRC fraud prevention"),
      service = Tdq,
      subject = extractNonCompliantSubject,
      plainTemplate = txt.tdqFphReportNonCompliant.f,
      htmlTemplate = html.tdqFphReportNonCompliant.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "tdq_fph_report_heuristically_compliant",
      fromAddress = FromAddress.noReply("HMRC fraud prevention"),
      service = Tdq,
      subject = extractSubject,
      plainTemplate = txt.tdqFphReportHeuristicallyCompliant.f,
      htmlTemplate = html.tdqFphReportHeuristicallyCompliant.f,
      priority = Some(MessagePriority.Standard)
    )
  )

  private def extractSubject(params: Map[String, String]) =
    params
      .get("applicationName")
      .map(appName => s"Fraud prevention headers for $appName")
      .getOrElse(throw new RuntimeException("Missing parameter applicationName"))

  private def extractNonCompliantSubject(params: Map[String, String]) = {
    val reportParams = TdqFphReportParams(params)

    val verb =
      (
        reportParams.hasAllHeadersMissing,
        reportParams.hasInvalidConnectionMethod,
        reportParams.hasErrors,
        reportParams.hasWarnings) match {
        case (true, _, _, _)         => "Submit"
        case (_, true, false, false) => "Submit"
        case (_, false, true, false) => "Correct"
        case _                       => "Improve"
      }

    s"$verb fraud prevention headers for ${reportParams.applicationName}"
  }
}
