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

class SuccessfulXmlSubmissionUserSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_successful_xml_submission_user" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_successful_xml_submission_user",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "File successfully sent for digital platform reporting",
      plainTemplate = txt.dprs_successful_xml_submission_user.f,
      htmlTemplate = html.dprs_successful_xml_submission_user.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "File successfully sent for digital platform reporting"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "userPrimaryContactName"  -> "Ashley Smith",
            "poBusinessName"          -> "Vinted",
            "poId"                    -> "PO12345678",
            "checksCompletedDateTime" -> "9:15am on 25 January 2024",
            "reportingPeriod"         -> "2024",
            "fileName"                -> "some-file-name.xml"
          )
        )
        .toString
      htmlContent must include("File successfully sent for digital platform reporting")
      htmlContent must include("Dear")
      htmlContent must include("Ashley Smith")
      htmlContent must include("We have received a file for Vinted with the platform operator ID PO12345678.")
      htmlContent must include("The file passed the reporting business rules checks at 9:15am on 25 January 2024.")
      htmlContent must include("This is for the reportable period ending 31 December 2024")
      htmlContent must include("Print or save a copy of this email for your records.")
      htmlContent must include("For reference, the file name is:")
      htmlContent must include("some-file-name.xml")
      htmlContent must include("What happens next")
      htmlContent must include("We will contact you if we have any questions about this report.")
      htmlContent must include("For more information, search GOV.UK for 'manage your digital platform reporting'.")
      htmlContent must include("For security reasons, we have not included a link to this service in this email.")
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
