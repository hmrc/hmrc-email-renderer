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

class NewMessageAlert_GIOSSSpec extends PlaySpec with CommonParamsForSpec {

  "NewMessageAlert_GIOSS" must {

    val newMessageAlert: MessageTemplate = MessageTemplate.create(
      templateId = "new_message_alert_gioss",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = Ioss,
      subject = "You have a new message from HMRC",
      plainTemplate = txt.new_message_alert_gioss.f,
      htmlTemplate = html.new_message_alert_gioss.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      newMessageAlert.subject(commonParameters) mustBe "You have a new message from HMRC"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = newMessageAlert
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("You have a new message from HMRC")
      htmlContent must include("Dear")
      htmlContent must include("Mrs John")
      htmlContent must include("We have sent you a new message about VAT Import One Stop Shop.")
      htmlContent must include("To view it, sign in to your Import One Stop Shop intermediary account.")
      htmlContent must include("For security reasons, we have not included a link in this email.")
      htmlContent must include("From the VAT Import One Stop Shop team")
    }
  }
}
