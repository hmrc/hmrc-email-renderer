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

package uk.gov.hmrc.hmrcemailrenderer.templates.ioss

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.CommonParamsForSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Ioss

class NewMessageAlert_IOSSSpec extends PlaySpec with CommonParamsForSpec {

  "NewMessageAlert_IOSS" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "new_message_alert_ioss",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_ioss.f,
      htmlTemplate = html.new_message_alert_ioss.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      newMessageAlert.subject(commonParameters) mustBe "You’ve got a new message from HMRC"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = newMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("You’ve got a new message from HMRC")
      htmlContent must include("Dear")
      htmlContent must include("Mrs John")
      htmlContent must include("You have a new message from HMRC.")
      htmlContent must include("To view it, sign in to your HMRC online account.")
      htmlContent must include("For security reasons, we have not included a link with this email.")
      htmlContent must include("Why you got this email")
      htmlContent must include("You chose to get paperless notifications.")
      htmlContent must include("This means we send you an email when you have a new message in your account.")
      htmlContent must include("From HMRC digital")
      htmlContent must include("If you&#8217;re unsure an email is from HMRC:")
      htmlContent must include("Do not reply to it or click on any links")
      htmlContent must include(
        "Report the suspicious email to HMRC - to find out how, go to GOV.UK and search for 'Avoid and report internet scams and phishing'"
      )
    }
  }

  "NewMessageAlert_ioss_cy welsh template" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_ioss_cy",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_ioss_cy.f,
      htmlTemplate = html.new_message_alert_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      newMessageAlert.subject(commonParameters) mustBe "Mae gennych neges newydd oddi wrth CThEF"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = newMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Mae gennych neges newydd oddi wrth CThEF")
      htmlContent must include("Annwyl")
      htmlContent must include("Mrs John")
      htmlContent must include("Mae gennych neges newydd oddi wrth CThEF.")
      htmlContent must include("I’w gweld, mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      htmlContent must include("Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn.")
      htmlContent must include("Pam y cawsoch yr e-bost hwn")
      htmlContent must include("Gwnaethoch ddewis cael hysbysiadau di-bapur.")
      htmlContent must include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch pan fydd gennych neges newydd yn eich cyfrif."
      )
      htmlContent must include("Oddi wrth adran Ddigidol CThEF")
      htmlContent must include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      htmlContent must include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      htmlContent must include(
        "Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’"
      )
    }
  }

}
