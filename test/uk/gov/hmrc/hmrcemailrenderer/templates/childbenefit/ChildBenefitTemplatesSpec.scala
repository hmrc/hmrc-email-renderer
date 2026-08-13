/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.childbenefit

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.CommonParamsForSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ChildBenefit

class ChildBenefitTemplatesSpec extends PlaySpec with CommonParamsForSpec {

  "newMessageAlert_CH(A)1700" must {

    val template = MessageTemplate.create(
      templateId = "newMessageAlert_CH(A)1700",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = ChildBenefit,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.newMessageAlertCHA1700.f,
      htmlTemplate = html.newMessageAlertCHA1700.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      template.subject(commonParameters) mustBe "You’ve got a new message from HMRC"
    }

    "include correct body content" in {
      val htmlContent = template
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("You’ve got a new message from HMRC")
      htmlContent must include("Dear")
      htmlContent must include("Mrs John")
      htmlContent must include("From HMRC digital")
    }
  }

  "newMessageAlert_CH(A)1700_cy welsh template" must {

    val template = MessageTemplate.create(
      templateId = "newMessageAlert_CH(A)1700_cy",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = ChildBenefit,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlertCHA1700_cy.f,
      htmlTemplate = html.newMessageAlertCHA1700_cy.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      template.subject(commonParameters) mustBe "Mae gennych neges newydd oddi wrth CThEF"
    }

    "include correct body content" in {
      val htmlContent = template
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Mae gennych neges newydd oddi wrth CThEF")
      htmlContent must include("Annwyl")
      htmlContent must include("Mrs John")
      htmlContent must include("Oddi wrth adran Ddigidol CThEF")
    }
  }

  "newMessageAlert_CH(A)1708" must {

    val template = MessageTemplate.create(
      templateId = "newMessageAlert_CH(A)1708",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = ChildBenefit,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.newMessageAlertCHA1708.f,
      htmlTemplate = html.newMessageAlertCHA1708.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      template.subject(commonParameters) mustBe "You’ve got a new message from HMRC"
    }

    "include correct body content" in {
      val htmlContent = template
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("You’ve got a new message from HMRC")
      htmlContent must include("Dear")
      htmlContent must include("Mrs John")
      htmlContent must include("From HMRC digital")
    }
  }

  "newMessageAlert_CH(A)1708_cy welsh template" must {

    val template = MessageTemplate.create(
      templateId = "newMessageAlert_CH(A)1708_cy",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = ChildBenefit,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlertCHA1708_cy.f,
      htmlTemplate = html.newMessageAlertCHA1708_cy.f,
      priority = Some(MessagePriority.Standard)
    )

    "include correct subject" in {
      template.subject(commonParameters) mustBe "Mae gennych neges newydd oddi wrth CThEF"
    }

    "include correct body content" in {
      val htmlContent = template
        .htmlTemplate(commonParameters ++ Map("recipientName_surname" -> "John", "recipientName_title" -> "Mrs"))
        .toString
      htmlContent must include("Mae gennych neges newydd oddi wrth CThEF")
      htmlContent must include("Annwyl")
      htmlContent must include("Mrs John")
      htmlContent must include("Oddi wrth adran Ddigidol CThEF")
    }
  }
}
