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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Tdq
import uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params._

object TdqTemplates {

  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "tdq_fph_self_serve_nudge",
      fromAddress = FromAddress.noReply("HMRC fraud prevention"),
      service = Tdq,
      subject = extractSubject,
      plainTemplate = txt.tdqFphSelfServeNudge.f,
      htmlTemplate = html.tdqFphSelfServeNudge.f,
      priority = Some(MessagePriority.Standard)
    )
  )

  def extractSubject(params: Map[String, String]): String = {
    val reportParams = TdqFphReportParams(params)
    selfServeNudgeSubject(reportParams.status, reportParams.applicationName)
  }

  def selfServeNudgeSubject(status: Status, applicationName: String): String =
    s"${status.subjectVerb} fraud prevention headers for $applicationName".trim.capitalize

}
