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

class TreThirdPartyAccessSelfRemovedSpec extends PlaySpec with CommonParamsForSpec {

  val treThirdPartyAccessSelfRemoved: MessageTemplate = MessageTemplate.create(
    templateId = "tre_third_party_access_self_removed",
    fromAddress = "Get customs data for import and export declarations <noreply@confirmation.tax.service.gov.uk>",
    service = TradeReportingExtracts,
    subject = "Your third-party has removed their access to your data",
    plainTemplate = txt.treThirdPartyAccessSelfRemoved.f,
    htmlTemplate = html.treThirdPartyAccessSelfRemoved.f,
    priority = Some(MessagePriority.Urgent)
  )

  "tre_third_party_access_self_removed" must {

    "include correct subject" in {
      treThirdPartyAccessSelfRemoved.subject(
        commonParameters
      ) mustBe "Your third-party has removed their access to your data"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = treThirdPartyAccessSelfRemoved.htmlTemplate(commonParameters).toString
      htmlContent must include("Dear customer")
      htmlContent must include(
        "Your third-party has removed their access to your data. This means they can no longer request reports for your data using the ‘Get customs data for import and export declarations’ service. You do not need to take any action."
      )
      htmlContent must include("Why are you receiving this email")
      htmlContent must include("We send emails to notify you when there’s been a change to who can access your data.")
      htmlContent must include("From the HMRC Customs declaration data team")
    }

  }
}
