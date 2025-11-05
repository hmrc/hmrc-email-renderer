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
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress }

class TreThirdPartyAddedTPSpec extends PlaySpec with CommonParamsForSpec {

  val treThirdPartyAddedTP: MessageTemplate = MessageTemplate.create(
    templateId = "tre_third_party_added_tp",
    fromAddress = FromAddress.noReply("Trade Reporting Extracts"),
    service = TradeReportingExtracts,
    subject = "You have third-party access to CDS data",
    plainTemplate = txt.treThirdPartyAddedTP.f,
    htmlTemplate = html.treThirdPartyAddedTP.f,
    priority = Some(MessagePriority.Urgent)
  )

  val params: Map[String, String] = Map(
  )

  "tre_third_party_added_tp" must {

    "include correct subject" in {
      treThirdPartyAddedTP.subject(commonParameters) mustBe
        "You have third-party access to CDS data"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = treThirdPartyAddedTP.htmlTemplate(commonParameters ++ params).toString
      htmlContent must include("Dear customer")
      htmlContent must include(
        "A business has given you third-party access on our service. This means you can request and download CDS reports on their behalf."
      )
      htmlContent must include("How to access CDS data")
      htmlContent must include("Go to GOV.UK.")
      htmlContent must include("Search for 'Get customs data for import and export declarations'.")
      htmlContent must include(
        "Log in to your account. If you’re not subscribed to the CDS service, the ‘Request a report’ section on the guidance page shows the steps to set this up."
      )
      htmlContent must include(
        "Select ‘Businesses you have third-party access to’ in the view data access section of your dashboard to check the details of your access."
      )
      htmlContent must include("Why you are receiving this email")
      htmlContent must include(
        "A business gave us your EORI number when setting up third-party access to their CDS data."
      )
    }
  }

}
