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
      fromAddress = FromAddress.noReply("Get customs data for import and export declarations"),
      service = TradeReportingExtracts,
      subject = "Your CDS report is ready to download",
      plainTemplate = txt.treReportAvailable.f,
      htmlTemplate = html.treReportAvailable.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "tre_report_available_non_verified",
      fromAddress = FromAddress.noReply("Get customs data for import and export declarations"),
      service = TradeReportingExtracts,
      subject = "A CDS report is ready to download",
      plainTemplate = txt.treReportAvailableNonVerified.f,
      htmlTemplate = html.treReportAvailableNonVerified.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "tre_report_failed",
      fromAddress = FromAddress.noReply("Get customs data for import and export declarations"),
      service = TradeReportingExtracts,
      subject = "There is a problem with your CDS report",
      plainTemplate = txt.treReportFailed.f,
      htmlTemplate = html.treReportFailed.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "tre_report_failed_non_verified",
      fromAddress = FromAddress.noReply("Get customs data for import and export declarations"),
      service = TradeReportingExtracts,
      subject = "There is a problem with a CDS report",
      plainTemplate = txt.treReportFailedNonVerified.f,
      htmlTemplate = html.treReportFailedNonVerified.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "tre_third_party_added_tp",
      fromAddress = FromAddress.noReply("Get customs data for import and export declarations"),
      service = TradeReportingExtracts,
      subject = "You have third-party access to CDS data",
      plainTemplate = txt.treThirdPartyAddedTP.f,
      htmlTemplate = html.treThirdPartyAddedTP.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "tre_third_party_access_removed",
      fromAddress = FromAddress.noReply("Get customs data for import and export declarations"),
      service = TradeReportingExtracts,
      subject = params =>
        s"Your third-party access to CDS data for ${params.getOrElse("businessName", "a business")} has been removed",
      plainTemplate = txt.treThirdPartyAccessRemoved.f,
      htmlTemplate = html.treThirdPartyAccessRemoved.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
