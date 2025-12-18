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

class TreThirdPartyAccessEditedTPSpec extends PlaySpec with CommonParamsForSpec {

  val tre_third_party_access_edited_tp: MessageTemplate = MessageTemplate.createWithDynamicSubject(
    templateId = "tre_third_party_access_edited_tp",
    fromAddress = "Get customs data for import and export declarations <noreply@confirmation.tax.service.gov.uk>",
    service = TradeReportingExtracts,
    subject = params =>
      s"Your third-party access to CDS data for ${params.getOrElse("businessName", "a business")} has been edited",
    plainTemplate = txt.treThirdPartyAccessEditedTP.f,
    htmlTemplate = html.treThirdPartyAccessEditedTP.f,
    priority = Some(MessagePriority.Urgent)
  )

  val params: Map[String, String] = Map(
    "businessName" -> "TestBusiness"
  )

  "tre_third_party_access_edited_tp" must {

    "include correct subject when businessName does not exist" in {
      tre_third_party_access_edited_tp.subject(
        commonParameters
      ) mustBe "Your third-party access to CDS data for a business has been edited"
    }

    "include correct subject when businessName does exist" in {
      tre_third_party_access_edited_tp.subject(
        commonParameters ++ params
      ) mustBe "Your third-party access to CDS data for TestBusiness has been edited"
    }

    "include correct htmlTemplate body and footer when businessName does exist" in {
      val htmlContent = tre_third_party_access_edited_tp.htmlTemplate(commonParameters ++ params).toString
      htmlContent must include("Dear customer")
      htmlContent must include(
        "TestBusiness has edited your third-party access to their customs declaration data."
      )
      htmlContent must include(
        "Your access to certain import and export data has been updated and any previous reports will no longer be available to view or download under ‘Available to download’. If you need to access import and export data for this business again, you will need to request a new report."
      )
      htmlContent must include("View the change to access")
      htmlContent must include("Go to GOV.UK.")
      htmlContent must include("Search for 'Get customs data for import and export declarations'.")
      htmlContent must include("Log in to your account.")
      htmlContent must include(
        "Select ‘Businesses you have third party access to’ in the ‘View data access’ section of your dashboard to view details of the change."
      )
      htmlContent must include("This change only affects access to this business.")
      htmlContent must include("From the HMRC Customs declaration data team")
    }

    "include correct htmlTemplate body and footer when businessName does NOT exist" in {
      val htmlContent = tre_third_party_access_edited_tp.htmlTemplate(commonParameters).toString
      htmlContent must include("Dear customer")
      htmlContent must include(
        "A business has edited your third-party access to their customs declaration data."
      )
      htmlContent must include(
        "Your access to certain import and export data has been updated and any previous reports will no longer be available to view or download under ‘Available to download’. If you need to access import and export data for this business again, you will need to request a new report."
      )
      htmlContent must include("View the change to access")
      htmlContent must include("Go to GOV.UK.")
      htmlContent must include("Search for 'Get customs data for import and export declarations'.")
      htmlContent must include("Log in to your account.")
      htmlContent must include(
        "Select ‘Businesses you have third party access to’ in the ‘View data access’ section of your dashboard to view details of the change."
      )
      htmlContent must include("This change only affects access to that business.")
      htmlContent must include("From the HMRC Customs declaration data team")
    }

  }
}
