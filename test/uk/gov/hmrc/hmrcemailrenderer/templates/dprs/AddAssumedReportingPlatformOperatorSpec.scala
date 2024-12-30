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

class AddAssumedReportingPlatformOperatorSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_add_assumed_reporting_platform_operator" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_add_assumed_reporting_platform_operator",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "Assumed reporting details submitted for you for digital platform reporting",
      plainTemplate = txt.dprs_add_assumed_reporting_platform_operator.f,
      htmlTemplate = html.dprs_add_assumed_reporting_platform_operator.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "Assumed reporting details submitted for you for digital platform reporting"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName"     -> "Tim Vinted",
            "checksCompletedDateTime"  -> "9:15am on 25 January 2024",
            "assumingPlatformOperator" -> "Assuming PO",
            "poBusinessName"           -> "Vinted",
            "reportingPeriod"          -> "2024"
          )
        )
        .toString
      htmlContent must include("Assumed reporting details submitted for you for digital platform reporting")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include("Assumed reporting details have been added for you at 9:15am on 25 January 2024.")
      htmlContent must include("Assuming PO will send reports on behalf of Vinted for the 2024 reportable period.")
      htmlContent must include("If this is not correct, contact the person or team that submitted this for you.")
      htmlContent must include("What happens next")
      htmlContent must include("We may contact you if we have any questions.")
      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("For security reasons, we have not included a link to this service in this email.")
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
