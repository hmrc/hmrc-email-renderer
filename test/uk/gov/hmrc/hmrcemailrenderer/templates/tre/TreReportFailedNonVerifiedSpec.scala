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
import uk.gov.hmrc.hmrcemailrenderer.templates.CommonParamsForSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.TradeReportingExtracts

class TreReportFailedNonVerifiedSpec extends PlaySpec with CommonParamsForSpec {

  val treReportFaieldNonVerified: MessageTemplate = MessageTemplate.create(
    templateId = "tre_report_failed_non_verified",
    fromAddress = "Trade Reporting Extracts <noreply@confirmation.tax.service.gov.uk",
    service = TradeReportingExtracts,
    subject = "There is a problem with a CDS report",
    plainTemplate = txt.treReportFailedNonVerified.f,
    htmlTemplate = html.treReportFailedNonVerified.f,
    priority = Some(MessagePriority.Urgent)
  )

  val params: Map[String, String] = Map(
    "reportRequestId" -> "XXXXX678"
  )

  "tre_report_failed_non_verified" must {

    "include correct subject" in {
      treReportFaieldNonVerified.subject(commonParameters) mustBe "There is a problem with a CDS report"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = treReportFaieldNonVerified.htmlTemplate(commonParameters ++ params).toString
      htmlContent must include("Dear customer")
      htmlContent must include("We could not complete the CDS report XXXXX678 because of an error.")
      htmlContent must include("What you need to do next")
      htmlContent must include("Go to GOV.UK.")
      htmlContent must include("Search for 'Get customs declaration data for imports and exports'.")
      htmlContent must include("Log in to your account.")
      htmlContent must include(
        "Select 'Requested reports' in the reports section of your dashboard to view details of the error."
      )
      htmlContent must include("From the HMRC Customs declaration data team")
      htmlContent must include(
        "If you did not request this report, please speak to the person in your organisation who did."
      )
    }
  }
}
