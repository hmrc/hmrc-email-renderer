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

class UpdatedAsPlatformOperatorSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_updated_as_platform_operator" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_updated_as_platform_operator",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "Your platform operator details have been updated in the digital platform reporting service",
      plainTemplate = txt.dprs_updated_as_platform_operator.f,
      htmlTemplate = html.dprs_updated_as_platform_operator.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "Your platform operator details have been updated in the digital platform reporting service"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName" -> "Tim Vinted",
            "poBusinessName"       -> "Vinted"
          )
        )
        .toString
      htmlContent must include("Your platform operator details have been updated")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include(
        "The details for Vinted have been updated in the digital platform reporting service."
      )
      htmlContent must include("Why you are receiving this email")
      htmlContent must include("You are listed as a contact for Vinted.")
      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
