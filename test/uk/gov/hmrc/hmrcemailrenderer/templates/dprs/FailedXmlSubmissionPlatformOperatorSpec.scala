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

class FailedXmlSubmissionPlatformOperatorSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_failed_xml_submission_platform_operator" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_failed_xml_submission_platform_operator",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "There is a problem with the file submitted for you for digital platform reporting",
      plainTemplate = txt.dprs_failed_xml_submission_platform_operator.f,
      htmlTemplate = html.dprs_failed_xml_submission_platform_operator.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "There is a problem with the file submitted for you for digital platform reporting"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName"    -> "Tim Vinted",
            "poBusinessName"          -> "Vinted",
            "checksCompletedDateTime" -> "9:15am on 25 January 2024"
          )
        )
        .toString
      htmlContent must include("There is a problem with the file submitted for you for digital platform reporting")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include("There is a problem with the file submitted at 9:15am on 25 January 2024 for Vinted.")
      htmlContent must include("A correct submission must be made on time otherwise Vinted may receive a penalty.")
      htmlContent must include("If you need help")
      htmlContent must include("Contact the person or team that submitted this for you.")
      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("For security reasons, we have not included a link to this service in this email.")
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
