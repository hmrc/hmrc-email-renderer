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
      "recipientName"   -> "John Smith",
      "returnPeriod"    -> "October 2026",
      "submissionDate"  -> "3 November 2026",
      "chargeReference" -> "VPD38270541977",
      "amountDue"       -> "£1,234.50",
      "paymentDueDate"  -> "15 November 2026"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe "Payment due for your Vaping Products Duty return"
      template.fromAddress(Map.empty) mustBe "HMRC Vaping Products Duty Team <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Dear John Smith")
      htmlContent must include("We received your October 2026 Vaping Products Duty return on 3 November 2026.")
      htmlContent must include("VPD38270541977")
      htmlContent must include("You need to pay £1,234.50 by 15 November 2026.")
      htmlContent must include(
        "If you have set up a Direct Debit, we will collect your payment automatically on 15 November 2026."
      )
      htmlContent must include("You cannot use Direct Debit for payments over £20 million.")
      htmlContent must include("We may charge you interest on payments received after 15 November 2026.")
      htmlContent must include("From HMRC Vaping Products Duty Team")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("Dear John Smith")
      txtContent must include("Charge reference number: VPD38270541977")
      txtContent must include("You need to pay £1,234.50 by 15 November 2026.")
      txtContent must include("If you’re unsure an email is from HMRC:")
    }
  }

  "vpd_nil_return_confirmation" must {

    val template: MessageTemplate = getTemplate("vpd_nil_return_confirmation")

    val params = commonParameters ++ Map(
      "recipientName"  -> "John Smith",
      "returnPeriod"   -> "October 2026",
      "submissionDate" -> "3 November 2026"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe "Your Vaping Products Duty return has been submitted"
      template.fromAddress(Map.empty) mustBe "HMRC Vaping Products Duty Team <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Dear John Smith")
      htmlContent must include("We received your October 2026 Vaping Products Duty return on 3 November 2026.")
      htmlContent must include("You do not need to pay any Vaping Products Duty for this period.")
      htmlContent must include("There is no credit due to you and no further action is required.")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("We have successfully processed your return.")
      txtContent must include("If you’re unsure an email is from HMRC:")
    }
  }

  "vpd_credit_due_confirmation" must {

    val template: MessageTemplate = getTemplate("vpd_credit_due_confirmation")

    val params = commonParameters ++ Map(
      "recipientName"  -> "John Smith",
      "returnPeriod"   -> "October 2026",
      "submissionDate" -> "3 November 2026",
      "creditAmount"   -> "£50"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe "Credit due on your Vaping Products Duty return"
      template.fromAddress(Map.empty) mustBe "HMRC Vaping Products Duty Team <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Dear John Smith")
      htmlContent must include("As a result of this adjustment, you have £50 credit available.")
      htmlContent must include("use this credit to offset another Vaping Products Duty liability")
      htmlContent must include("request a repayment")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("As a result of this adjustment, you have £50 credit available.")
      txtContent must include("If you’re unsure an email is from HMRC:")
    }
  }

  private val welshSubject = "Cadarnhad eich bod wedi cyflwyno’ch Datganiad Toll Cynhyrchion Fepio"

  "vpd_duty_due_confirmation_cy" must {

    val template: MessageTemplate = getTemplate("vpd_duty_due_confirmation_cy")

    val params = commonParameters ++ Map(
      "recipientName"   -> "John Smith",
      "returnPeriod"    -> "October 2026",
      "submissionDate"  -> "3 November 2026",
      "chargeReference" -> "VPD38270541977",
      "amountDue"       -> "£1,234.50",
      "paymentDueDate"  -> "15 November 2026"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe welshSubject
      template.fromAddress(Map.empty) mustBe "Tîm Toll Cynhyrchion Fepio CThEF <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Annwyl John Smith")
      htmlContent must include(
        "Daeth eich Datganiad Toll Cynhyrchion Fepio ar gyfer October 2026 i law ar 3 November 2026."
      )
      htmlContent must include("VPD38270541977")
      htmlContent must include("Mae angen i chi dalu £1,234.50 erbyn 15 November 2026.")
      htmlContent must include(
        "Os ydych wedi sefydlu Debyd Uniongyrchol, byddwn yn casglu’ch taliad yn awtomatig ar 15 November 2026."
      )
      htmlContent must include(
        "Ni allwch ddefnyddio Debyd Uniongyrchol ar gyfer taliadau sy'n fwy na £20 miliwn."
      )
      htmlContent must include(
        "Efallai y byddwn yn codi llog arnoch ar daliadau a dderbynnir ar ôl hynny 15 November 2026."
      )
      htmlContent must include("Oddi wrth Tîm Toll Cynhyrchion Fepio CThEF")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("Annwyl John Smith")
      txtContent must include("Rhif cyfeirnod y tâl: VPD38270541977")
      txtContent must include("Mae angen i chi dalu £1,234.50 erbyn 15 November 2026.")
      txtContent must include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
    }
  }

  "vpd_nil_return_confirmation_cy" must {

    val template: MessageTemplate = getTemplate("vpd_nil_return_confirmation_cy")

    val params = commonParameters ++ Map(
      "recipientName"  -> "John Smith",
      "returnPeriod"   -> "October 2026",
      "submissionDate" -> "3 November 2026"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe welshSubject
      template.fromAddress(Map.empty) mustBe "Tîm Toll Cynhyrchion Fepio CThEF <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Annwyl John Smith")
      htmlContent must include(
        "Daeth eich Datganiad Toll Cynhyrchion Fepio ar gyfer October 2026 i law ar 3 November 2026."
      )
      htmlContent must include(
        "Nid oes angen i chi dalu unrhyw Ddyletswydd ar Gynhyrchion Vapio ar gyfer y cyfnod hwn."
      )
      htmlContent must include("Does dim credyd yn ddyledus i chi a does dim angen i chi wneud dim byd arall.")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("Rydym wedi prosesu eich dychweliad yn llwyddiannus.")
      txtContent must include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
    }
  }

  "vpd_credit_due_confirmation_cy" must {

    val template: MessageTemplate = getTemplate("vpd_credit_due_confirmation_cy")

    val params = commonParameters ++ Map(
      "recipientName"  -> "John Smith",
      "returnPeriod"   -> "October 2026",
      "submissionDate" -> "3 November 2026",
      "creditAmount"   -> "£50"
    )

    "render correct subject and fromAddress" in {
      template.subject(commonParameters) mustBe welshSubject
      template.fromAddress(Map.empty) mustBe "Tîm Toll Cynhyrchion Fepio CThEF <noreply@tax.service.gov.uk>"
    }

    "render htmlTemplate body" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent must include("Annwyl John Smith")
      htmlContent must include("O ganlyniad i'r addasiad hwn, mae gennych chi £50 Credyd ar gael.")
      htmlContent must include("defnyddio’r credyd hwn i wrthbwyso rhwymedigaeth Toll Cynhyrchion Fepio arall")
      htmlContent must include("gwneud cais am ad-daliad")
    }

    "render text content and footer" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent must include("O ganlyniad i'r addasiad hwn, mae gennych chi £50 Credyd ar gael.")
      txtContent must include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
    }
  }
}
