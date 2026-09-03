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

package uk.gov.hmrc.hmrcemailrenderer.templates.vpd

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

class VpdReturnSubmittedEmailsSpec extends PlaySpec with CommonParamsForSpec {

  private def getTemplate(templateId: String): MessageTemplate =
    TemplateLocator
      .templateGroups("VPD")
      .find(_.templateId == templateId)
      .value

  "vpd_duty_due_confirmation" must {

    val template: MessageTemplate = getTemplate("vpd_duty_due_confirmation")

    val params = commonParameters ++ Map(
      "recipientName" -> "John Smith",
      "returnPeriod" -> "October 2026",
      "submissionDate" -> "3 November 2026",
      "chargeReference" -> "VPD38270541977",
      "amountDue" -> "£1,234.50",
      "paymentDueDate" -> "15 November 2026"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe "Payment due for your Vaping Products Duty return"
      template.fromAddress(Map.empty) mustBe "HMRC Vaping Products Duty Team <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Dear John Smith,")
      htmlContent must include("We received your October 2026 Vaping Products Duty return on 3 November 2026.")
      htmlContent must include("VPD38270541977")
      htmlContent must include("You need to pay £1,234.50 by 15 November 2026.")
      htmlContent must include("If you have set up a Direct Debit, we will collect your payment automatically on 15 November 2026.")
      htmlContent must include("If the amount due is more than £20 million, Direct Debit cannot be used.")
      htmlContent must include("Interest may be charged on payments received after 15 November 2026.")
      htmlContent must include("From HMRC Vaping Products Duty Team")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("Dear John Smith,")
      txtContent must include("Charge reference number: VPD38270541977")
      txtContent must include("You need to pay £1,234.50 by 15 November 2026.")
      txtContent must include("If you’re unsure an email is from HMRC:")
    }
  }

  "vpd_nil_return_confirmation" must {

    val template: MessageTemplate = getTemplate("vpd_nil_return_confirmation")

    val params = commonParameters ++ Map(
      "recipientName" -> "John Smith",
      "returnPeriod" -> "October 2026",
      "submissionDate" -> "3 November 2026"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe "Your Vaping Products Duty return has been submitted"
      template.fromAddress(Map.empty) mustBe "HMRC Vaping Products Duty Team <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Dear John Smith,")
      htmlContent must include("We received your October 2026 Vaping Products Duty return on 3 November 2026.")
      htmlContent must include("There is no Vaping Products Duty to pay for this period.")
      htmlContent must include("There is no credit due to you and no further action is required.")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("Your return has been processed successfully.")
      txtContent must include("If you’re unsure an email is from HMRC:")
    }
  }

  "vpd_credit_due_confirmation" must {

    val template: MessageTemplate = getTemplate("vpd_credit_due_confirmation")

    val params = commonParameters ++ Map(
      "recipientName" -> "John Smith",
      "returnPeriod" -> "October 2026",
      "submissionDate" -> "3 November 2026",
      "creditAmount" -> "£50"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe "Credit due on your Vaping Products Duty return"
      template.fromAddress(Map.empty) mustBe "HMRC Vaping Products Duty Team <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Dear John Smith,")
      htmlContent must include("As a result of this adjustment, a credit of £50 is available to you.")
      htmlContent must include("use this credit to offset another Vaping Products Duty liability, or")
      htmlContent must include("request a repayment.")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("As a result of this adjustment, a credit of £50 is available to you.")
      txtContent must include("If you’re unsure an email is from HMRC:")
    }
  }
}
