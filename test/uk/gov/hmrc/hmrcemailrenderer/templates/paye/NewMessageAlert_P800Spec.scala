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

package uk.gov.hmrc.hmrcemailrenderer.templates.paye

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.CommonParamsForSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment

class NewMessageAlert_P800Spec extends PlaySpec with CommonParamsForSpec {

  "NewMessageAlert_P800" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_P800",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = SelfAssessment,
      subject = "You have a new message from HMRC",
      plainTemplate = txt.newMessageAlert_P800.f,
      htmlTemplate = html.newMessageAlert_P800.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      newMessageAlert.subject(commonParameters) mustBe "You have a new message from HMRC"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = newMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Your new tax calculation is ready")
      htmlContent must include("Mrs John")
      htmlContent must include("Your tax calculation is now ready to access online.")
      htmlContent must include("How to view your tax calculation")
      htmlContent must include("<li>Visit GOV.UK and search for ‘personal tax account’.</li>")
      htmlContent must include("<li>Select ‘personal tax account: sign in or set up‘.</li>")
      htmlContent must include("<li>Sign in and check your messages.</li>")
      htmlContent must include("You can also access your tax calculation on the HMRC app.")
      htmlContent must include("Why you got this email")
      htmlContent must include("You chose to get online tax letters instead of letters by post.")
      htmlContent must include(
        "This means we send you an email to let you know when you have a new message in your personal tax account."
      )
      htmlContent must include("If you&#8217;re unsure an email is from HMRC:")
      htmlContent must include("Do not reply to it or click on any links")
      htmlContent must include(
        "Report the suspicious email to HMRC - to find out how, go to GOV.UK and search for 'Avoid and report internet scams and phishing'"
      )
    }
  }

  "NewMessageAlert_P800_cy welsh template" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_P800_cy",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = SelfAssessment,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlert_P800_cy.f,
      htmlTemplate = html.newMessageAlert_P800_cy.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      newMessageAlert.subject(commonParameters) mustBe "Mae gennych neges newydd oddi wrth CThEF"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = newMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Mae’ch cyfrifiad treth newydd yn barod")
      htmlContent must include("Annwyl")
      htmlContent must include("Mrs John")
      htmlContent must include("Mae’ch cyfrifiad treth nawr yn barod i chi ar-lein.")
      htmlContent must include("Sut i weld eich cyfrifiad treth")
      htmlContent must include("<li>Ewch i GOV.UK a chwilio am ‘personal tax account’.</li>")
      htmlContent must include(
        "<li>Dewiswch ‘Personal tax account: sign in or set up’, ac yna dewis yr opsiwn Cymraeg.</li>"
      )
      htmlContent must include("<li>Mewngofnodwch a gwirio’ch negeseuon.</li>")
      htmlContent must include("Gallwch hefyd gael mynediad at eich cyfrifiad treth yn ap CThEF.")
      htmlContent must include("Pam cawsoch chi’r e-bost hwn")
      htmlContent must include("Gwnaethoch ddewis i gael llythyrau treth ar-lein yn hytrach na llythyrau drwy’r post.")
      htmlContent must include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch er mwyn rhoi gwybod i chi fod gennych neges newydd yn eich cyfrif treth personol."
      )
      htmlContent must include("Oddi wrth dîm TWE CThEF")
      htmlContent must include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      htmlContent must include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      htmlContent must include(
        "Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’"
      )
    }
  }

  "NewMessageAlert_P800_D2" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_P800_D2",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = SelfAssessment,
      subject = "You have a new message from HMRC",
      plainTemplate = txt.newMessageAlert_P800.f,
      htmlTemplate = html.newMessageAlert_P800.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      newMessageAlert.subject(commonParameters) mustBe "You have a new message from HMRC"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = newMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Your new tax calculation is ready")
      htmlContent must include("Mrs John")
      htmlContent must include("Your tax calculation is now ready to access online.")
      htmlContent must include("How to view your tax calculation")
      htmlContent must include("<li>Visit GOV.UK and search for ‘personal tax account’.</li>")
      htmlContent must include("<li>Select ‘personal tax account: sign in or set up‘.</li>")
      htmlContent must include("<li>Sign in and check your messages.</li>")
      htmlContent must include("You can also access your tax calculation on the HMRC app.")
      htmlContent must include("Why you got this email")
      htmlContent must include("You chose to get online tax letters instead of letters by post.")
      htmlContent must include(
        "This means we send you an email to let you know when you have a new message in your personal tax account."
      )
      htmlContent must include("If you&#8217;re unsure an email is from HMRC:")
      htmlContent must include("Do not reply to it or click on any links")
      htmlContent must include(
        "Report the suspicious email to HMRC - to find out how, go to GOV.UK and search for 'Avoid and report internet scams and phishing'"
      )
    }
  }

  "NewMessageAlert_P800_D2_cy welsh template" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_P800_D2_cy",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = SelfAssessment,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlert_P800_cy.f,
      htmlTemplate = html.newMessageAlert_P800_cy.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      newMessageAlert.subject(commonParameters) mustBe "Mae gennych neges newydd oddi wrth CThEF"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = newMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Mae’ch cyfrifiad treth newydd yn barod")
      htmlContent must include("Annwyl")
      htmlContent must include("Mrs John")
      htmlContent must include("Mae’ch cyfrifiad treth nawr yn barod i chi ar-lein.")
      htmlContent must include("Sut i weld eich cyfrifiad treth")
      htmlContent must include("<li>Ewch i GOV.UK a chwilio am ‘personal tax account’.</li>")
      htmlContent must include(
        "<li>Dewiswch ‘Personal tax account: sign in or set up’, ac yna dewis yr opsiwn Cymraeg.</li>"
      )
      htmlContent must include("<li>Mewngofnodwch a gwirio’ch negeseuon.</li>")
      htmlContent must include("Gallwch hefyd gael mynediad at eich cyfrifiad treth yn ap CThEF.")
      htmlContent must include("Pam cawsoch chi’r e-bost hwn")
      htmlContent must include("Gwnaethoch ddewis i gael llythyrau treth ar-lein yn hytrach na llythyrau drwy’r post.")
      htmlContent must include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch er mwyn rhoi gwybod i chi fod gennych neges newydd yn eich cyfrif treth personol."
      )
      htmlContent must include("Oddi wrth dîm TWE CThEF")
      htmlContent must include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      htmlContent must include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      htmlContent must include(
        "Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’"
      )
    }
  }

}
