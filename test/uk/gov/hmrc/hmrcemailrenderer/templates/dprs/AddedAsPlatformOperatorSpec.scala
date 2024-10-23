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

package uk.gov.hmrc.hmrcemailrenderer.templates.dprs

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DigitalPlatformReporting
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress }

class AddedAsPlatformOperatorSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_added_as_platform_operator" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_added_as_platform_operator",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "You have been added as a platform operator in the digital platform reporting service",
      plainTemplate = txt.dprs_added_as_platform_operator.f,
      htmlTemplate = html.dprs_added_as_platform_operator.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "You have been added as a platform operator in the digital platform reporting service"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName" -> "Tim Vinted",
            "userBusinessName"     -> "Smith Advisory Services",
            "poId"                 -> "PO12345678",
            "poBusinessName"       -> "Vinted"
          )
        )
        .toString
      htmlContent must include("You have been added as a platform operator")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include(
        "Vinted has been added as a platform operator in the digital platform reporting service."
      )
      htmlContent must include("This was done by Smith Advisory Services.")
      htmlContent must include("Your platform operator ID is PO12345678.")
      htmlContent must include("You are receiving this email because you have been added as a contact for Vinted.")
      htmlContent must include("What happens next")
      htmlContent must include("You do not need to do anything.")
      htmlContent must include("Smith Advisory Services can now submit digital platform reports for you.")
      htmlContent must include("For more information, search GOV.UK for 'reporting rules for digital platforms'.")
      htmlContent must include("From the HMRC Digital Platform Reporting team")
    }
  }
}
