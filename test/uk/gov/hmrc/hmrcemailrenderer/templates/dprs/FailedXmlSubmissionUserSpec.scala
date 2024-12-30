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

class FailedXmlSubmissionUserSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_failed_xml_submission_user" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_failed_xml_submission_user",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "There is a problem with your file for digital platform reporting",
      plainTemplate = txt.dprs_failed_xml_submission_user.f,
      htmlTemplate = html.dprs_failed_xml_submission_user.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "There is a problem with your file for digital platform reporting"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "userPrimaryContactName"  -> "Ashley Smith",
            "poBusinessName"          -> "Vinted",
            "checksCompletedDateTime" -> "9:15am on 25 January 2024",
            "fileName"                -> "some-file-name.xml"
          )
        )
        .toString
      htmlContent must include("There is a problem with your file for digital platform reporting")
      htmlContent must include("Dear")
      htmlContent must include("Ashley Smith")
      htmlContent must include(
        "There is a problem with the file you submitted at 9:15am on 25 January 2024 for the platform operator Vinted."
      )
      htmlContent must include("You can check the errors in the online service and upload an updated XML file.")
      htmlContent must include("The error details are only available for 28 days.")
      htmlContent must include("For reference, the file name is:")
      htmlContent must include("some-file-name.xml")
      htmlContent must include("What you need to do next")
      htmlContent must include(
        "You must send another report. Not sending another report on time may result in a penalty for the platform operator."
      )
      htmlContent must include("If you need help")
      htmlContent must include("Email aeoi.enquiries@hmrc.gov.uk for help with file submissions for this service.")
      htmlContent must include("For more information, search GOV.UK for 'manage your digital platform reporting'.")
      htmlContent must include("For security reasons, we have not included a link to this service in this email.")
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
