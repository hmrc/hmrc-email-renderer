/*
 * Copyright 2025 HM Revenue & Customs
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

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.TradeReportingExtracts
import uk.gov.hmrc.hmrcemailrenderer.templates.CommonParamsForSpec

class TreReportAvailableSpec extends PlaySpec with CommonParamsForSpec {

  val treReportAvailable: MessageTemplate = MessageTemplate.create(
    templateId = "tre_report_available",
    fromAddress = "Trade Reporting Extracts <noreply@confirmation.tax.service.gov.uk>",
    service = TradeReportingExtracts,
    subject = "Your CDS report is ready to download",
    plainTemplate = txt.treReportAvailable.f,
    htmlTemplate = html.treReportAvailable.f,
    priority = Some(MessagePriority.Urgent)
  )

  val params: Map[String, String] = Map(
    "reportRequestId" -> "ABC123456"
  )

  "tre_report_available" must {

    "include correct subject" in {
      treReportAvailable.subject(commonParameters) mustBe "Your CDS report is ready to download"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = treReportAvailable.htmlTemplate(commonParameters ++ params).toString
      htmlContent must include("Dear customer")
      htmlContent must include("Your CDS report ABC123456 that you requested is now ready to download.")
      htmlContent must include("How to get your report")
      htmlContent must include("Go to GOV.UK.")
      htmlContent must include("Search for 'Get customs declaration data for imports and exports'.")
      htmlContent must include("Log in to your account.")
      htmlContent must include("Select 'Available to download' in the reports section of your dashboard.")
      htmlContent must include("You have 30 days to download your report.")
      htmlContent must include("From the HMRC Customs declaration data team")
    }

  }
}
