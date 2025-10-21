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

class TreThirdPartyAccessRemovedSpec extends PlaySpec with CommonParamsForSpec {

  val treReportAvailable: MessageTemplate = MessageTemplate.createWithDynamicSubject(
    templateId = "tre_third_party_access_removed",
    fromAddress = "Trade Reporting Extracts <noreply@confirmation.tax.service.gov.uk>",
    service = TradeReportingExtracts,
    subject = params =>
      s"Your third-party access to CDS data for ${params.getOrElse("businessName", "a business")} has been removed",
    plainTemplate = txt.treThirdPartyAccessRemoved.f,
    htmlTemplate = html.treThirdPartyAccessRemoved.f,
    priority = Some(MessagePriority.Urgent)
  )

  val params: Map[String, String] = Map(
    "businessName" -> "TestBusiness"
  )

  "tre_report_available" must {

    "include correct subject when businessName does not exist" in {
      treReportAvailable.subject(
        commonParameters
      ) mustBe "Your third-party access to CDS data for a business has been removed"
    }

    "include correct subject when businessName does exist" in {
      treReportAvailable.subject(
        commonParameters ++ params
      ) mustBe "Your third-party access to CDS data for TestBusiness has been removed"
    }

    "include correct htmlTemplate body and footer when businessName does exist" in {
      val htmlContent = treReportAvailable.htmlTemplate(commonParameters ++ params).toString
      htmlContent must include("Dear customer")
      htmlContent must include(
        "TestBusiness has removed your third-party access to their customs declaration data. You can no longer request or download CDS reports on their behalf."
      )
      htmlContent must include("This change only affects access to this business.")
      htmlContent must include("You do not need to take any action.")
      htmlContent must include("From the HMRC Customs declaration data team")
    }

    "include correct htmlTemplate body and footer when businessName does NOT exist" in {
      val htmlContent = treReportAvailable.htmlTemplate(commonParameters).toString
      htmlContent must include("Dear customer")
      htmlContent must include(
        "A business has removed your third-party access to their customs declaration data. You can no longer request or download CDS reports on their behalf."
      )
      htmlContent must include("This change only affects access to that business.")
      htmlContent must include("You do not need to take any action.")
      htmlContent must include("From the HMRC Customs declaration data team")
    }

  }
}
