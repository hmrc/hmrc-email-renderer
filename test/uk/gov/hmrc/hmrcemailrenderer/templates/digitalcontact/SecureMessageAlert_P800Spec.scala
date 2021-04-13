/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import org.scalatestplus.play.{ OneAppPerSuite, PlaySpec }
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class SecureMessageAlert_P800Spec extends PlaySpec with CommonParamsForSpec {

  "SecureMessageAlert_P800" must {

    val secureMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "secureMessageAlert_P800",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = SelfAssessment,
      subject = "You have a new message from HMRC",
      plainTemplate = txt.secureMessageAlert_P800.f,
      htmlTemplate = html.secureMessageAlert_P800.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      secureMessageAlert.subject(commonParameters) mustBe "You have a new message from HMRC"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = secureMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Mrs John")
      htmlContent must include("You can now view your latest tax calculation.")
      htmlContent must include(
        "Sign in to HMRC online with your Government Gateway password and ID, and go to your messages.")
      htmlContent must include("For security reasons, we have not included a link with this email.")
      htmlContent must include("Why you got this email")
      htmlContent must include("You chose to get online tax letters instead of letters by post.")
      htmlContent must include("This means we send you an email to let you know when you have a new message.")
      htmlContent must include("If you&#8217;re unsure an email is from HMRC:")
      htmlContent must include("Do not reply to it or click on any links")
      htmlContent must include(
        "Report the suspicious email to HMRC - to find out how, go to GOV.UK and search for 'Avoid and report internet scams and phishing'")
    }
  }
}
