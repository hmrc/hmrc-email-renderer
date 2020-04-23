/*
 * Copyright 2020 HM Revenue & Customs
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

object TdqTemplates {

  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "tdq_compliance_all_required_headers_missing",
      fromAddress = FromAddress.noReply("Transaction Monitoring Team – HMRC Digital"),
      service = Tdq,
      subject = extractSubject,
      plainTemplate = txt.tdqHeaderComplianceEmailNoHeaders.f,
      htmlTemplate = html.tdqHeaderComplianceEmailNoHeaders.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "tdq_compliance_partially_compliant_invalid_or_missing_connection_method",
      fromAddress = FromAddress.noReply("Transaction Monitoring Team – HMRC Digital"),
      service = Tdq,
      subject = extractSubject,
      plainTemplate = txt.tdqHeaderCompliancePartiallyCompliantInvalidOrMissingConnectionMethod.f,
      htmlTemplate = html.tdqHeaderCompliancePartiallyCompliantInvalidOrMissingConnectionMethod.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "tdq_compliance_partially_compliant_valid_connection_method",
      fromAddress = FromAddress.noReply("Transaction Monitoring Team – HMRC Digital"),
      service = Tdq,
      subject = extractSubject,
      plainTemplate = txt.tdqHeaderCompliancePartiallyCompliantValidConnectionMethod.f,
      htmlTemplate = html.tdqHeaderCompliancePartiallyCompliantValidConnectionMethod.f,
      priority = Some(MessagePriority.Standard)
    )
  )

  private def extractSubject(params: Map[String, String]) =
    params
      .get("applicationName")
      .map(appName => s"Fraud prevention headers for '$appName'")
      .getOrElse(throw new RuntimeException("Missing parameter applicationName"))
}
