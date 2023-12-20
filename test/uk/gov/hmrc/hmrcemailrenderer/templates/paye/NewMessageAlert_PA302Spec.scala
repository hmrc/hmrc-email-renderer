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
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PayAsYouEarn

class NewMessageAlert_PA302Spec extends PlaySpec with CommonParamsForSpec {

  "NewMessageAlert_PA302" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_PA302",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = PayAsYouEarn,
      subject = "You have a new message from HMRC",
      plainTemplate = txt.newMessageAlert_PA302.f,
      htmlTemplate = html.newMessageAlert_PA302.f,
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
      htmlContent must include("Your latest tax calculation is now ready to view online.")
      htmlContent must include(
        "Sign in to HMRC online with your Government Gateway password and ID, and go to your messages. Or download the free HMRC app.")
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

  "NewMessageAlert_PA302_cy welsh template" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_PA302_cy",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = PayAsYouEarn,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlert_PA302_cy.f,
      htmlTemplate = html.newMessageAlert_PA302_cy.f,
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
      htmlContent must include("Mae’ch cyfrifiad treth diweddaraf nawr yn barod i chi fwrw golwg drosto ar-lein.")
      htmlContent must include(
        "Mewngofnodwch i CThEF ar-lein gyda’ch Dynodydd Defnyddiwr (ID) a’ch cyfrinair ar gyfer Porth y Llywodraeth, ac ewch i’ch negeseuon. Neu lawrlwythwch ap CThEF sy’n rhad ac am ddim.")
      htmlContent must include("Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn.")
      htmlContent must include("Pam y cawsoch yr e-bost hwn")
      htmlContent must include("Gwnaethoch ddewis cael llythyrau treth ar-lein yn lle llythyrau drwy’r post.")
      htmlContent must include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch er mwyn rhoi gwybod i chi pan fydd gennych neges newydd.")
      htmlContent must include("Oddi wrth adran TWE CThEF")
      htmlContent must include("If you&#8217;re unsure an email is from HMRC:")
      htmlContent must include("Do not reply to it or click on any links")
      htmlContent must include(
        "Report the suspicious email to HMRC - to find out how, go to GOV.UK and search for 'Avoid and report internet scams and phishing'")
    }
  }

  "NewMessageAlert_PA302_D2" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_PA302_D2",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = PayAsYouEarn,
      subject = "You have a new message from HMRC",
      plainTemplate = txt.newMessageAlert_PA302.f,
      htmlTemplate = html.newMessageAlert_PA302.f,
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
      htmlContent must include("Your latest tax calculation is now ready to view online.")
      htmlContent must include(
        "Sign in to HMRC online with your Government Gateway password and ID, and go to your messages. Or download the free HMRC app.")
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

  "NewMessageAlert_PA302_D2_cy welsh template" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_PA302_D2_cy",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = PayAsYouEarn,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlert_PA302_cy.f,
      htmlTemplate = html.newMessageAlert_PA302_cy.f,
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
      htmlContent must include("Mae’ch cyfrifiad treth diweddaraf nawr yn barod i chi fwrw golwg drosto ar-lein.")
      htmlContent must include(
        "Mewngofnodwch i CThEF ar-lein gyda’ch Dynodydd Defnyddiwr (ID) a’ch cyfrinair ar gyfer Porth y Llywodraeth, ac ewch i’ch negeseuon. Neu lawrlwythwch ap CThEF sy’n rhad ac am ddim.")
      htmlContent must include("Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn.")
      htmlContent must include("Pam y cawsoch yr e-bost hwn")
      htmlContent must include("Gwnaethoch ddewis cael llythyrau treth ar-lein yn lle llythyrau drwy’r post.")
      htmlContent must include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch er mwyn rhoi gwybod i chi pan fydd gennych neges newydd.")
      htmlContent must include("Oddi wrth adran TWE CThEF")
      htmlContent must include("If you&#8217;re unsure an email is from HMRC:")
      htmlContent must include("Do not reply to it or click on any links")
      htmlContent must include(
        "Report the suspicious email to HMRC - to find out how, go to GOV.UK and search for 'Avoid and report internet scams and phishing'")
    }
  }

}
