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

class RegistrationSubmittedSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_registration_submitted" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_registration_submitted",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "Successful registration for digital platform reporting",
      plainTemplate = txt.dprs_registration_submitted.f,
      htmlTemplate = html.dprs_registration_submitted.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(commonParameters) mustBe "Successful registration for digital platform reporting"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = underTest
        .htmlTemplate(commonParameters ++ Map("name" -> "Homer Simpson", "dprsId" -> "XLDPI0023000377"))
        .toString
      htmlContent must include("You have registered for digital platform reporting")
      htmlContent must include("Dear")
      htmlContent must include("Homer Simpson")
      htmlContent must include("You have successfully registered for digital platform reporting.")
      htmlContent must include("Your digital platform reporting user ID is XLDPI0023000377.")
      htmlContent must include(
        "Keep a record of this ID. We will ask you for it if you contact us or need to recover your account."
      )
      htmlContent must include("What you need to do next")
      htmlContent must include("To send submissions, you must add a platform operator.")
      htmlContent must include(
        "Go to GOV.UK and search for 'manage your digital platform reporting' to access this service."
      )
      htmlContent must include("For security reasons, we have not included a link to this service in this email.")
      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
