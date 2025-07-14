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

package uk.gov.hmrc.hmrcemailrenderer.templates.tre

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.TradeReportingExtracts

object treTemplates {
  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.create(
      templateId = "tre_report_available",
      fromAddress = FromAddress.noReply("Trade Reporting Extracts"),
      service = TradeReportingExtracts,
      subject = "Your CDS report is ready to download",
      plainTemplate = txt.treReportAvailable.f,
      htmlTemplate = html.treReportAvailable.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "tre_report_available_non_verified",
      fromAddress = FromAddress.noReply("Trade Reporting Extracts"),
      service = TradeReportingExtracts,
      subject = "A CDS report is ready to download",
      plainTemplate = txt.treReportAvailableNonVerified.f,
      htmlTemplate = html.treReportAvailableNonVerified.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
