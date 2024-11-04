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

class RemovedAsPlatformOperatorSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_removed_as_platform_operator" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_removed_as_platform_operator",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "You have been removed as a platform operator from the digital platform reporting service",
      plainTemplate = txt.dprs_removed_as_platform_operator.f,
      htmlTemplate = html.dprs_removed_as_platform_operator.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "You have been removed as a platform operator from the digital platform reporting service"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName" -> "Tim Vinted",
            "poId"                 -> "PO12345678",
            "poBusinessName"       -> "Vinted"
          )
        )
        .toString
      htmlContent must include("You have been removed as a platform operator")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include("Vinted with platform operator ID PO12345678 has been removed as ")
      htmlContent must include("a platform operator from the digital platform reporting service.")
      htmlContent must include("Why you are receiving this email")
      htmlContent must include("You are listed as a contact for Vinted.")
      htmlContent must include("If the reporting rules still apply to you")
      htmlContent must include("If the reporting rules still apply to you, you must tell HMRC if you are")
      htmlContent must include("a reporting platform operator or an excluded platform operator.")
      htmlContent must include("You need to register first to do this.")
      htmlContent must include(
        "Go to GOV.UK and search for 'reporting rules for digital platforms' to register for the service."
      )
      htmlContent must include("You may have to pay a penalty if you do not tell HMRC by the deadline.")
      htmlContent must include("If the reporting rules do not apply to you")
      htmlContent must include("You do not need to do anything.")
      htmlContent must include("For security reasons, we have not included a link to this service in this email.")
      htmlContent must include("For more information, search GOV.UK for 'reporting rules for digital platforms'.")
      htmlContent must include("From the HMRC Digital Platform Reporting team")
    }
  }
}
