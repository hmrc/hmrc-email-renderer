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
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DigitalPlatformReporting
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, FromAddress}

class DeleteAssumedReportingUserSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_delete_assumed_reporting_user" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_delete_assumed_reporting_user",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "Assumed reporting details deleted for digital platform reporting",
      plainTemplate = txt.dprs_delete_assumed_reporting_user.f,
      htmlTemplate = html.dprs_delete_assumed_reporting_user.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "Assumed reporting details deleted for digital platform reporting"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "userPrimaryContactName" -> "Ashley Smith",
            "checksCompletedDateTime" -> "9:15am on 25 January 2024",
            "assumingPlatformOperator" -> "Assuming PO",
            "poBusinessName" -> "Vinted",
            "reportingPeriod" -> "2024"
          )
        )
        .toString
      htmlContent must include("Assumed reporting details deleted for digital platform reporting")
      htmlContent must include("Dear")
      htmlContent must include("Ashley Smith")
      htmlContent must include("You have deleted details for assumed reporting at 9:15am on 25 January 2024.")
      htmlContent must include("Assuming PO will not send reports on behalf of Vinted for the 2024 reportable period.")
      htmlContent must include("What happens next")
      htmlContent must include("We will contact you if we have any questions.")
      htmlContent must include("For more information, search GOV.UK for ‘reporting rules for digital platforms’.")
      htmlContent must include("For security reasons, we have not included a link to this service in this email.")
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
