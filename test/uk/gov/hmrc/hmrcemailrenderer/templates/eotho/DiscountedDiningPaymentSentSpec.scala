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

package uk.gov.hmrc.hmrcemailrenderer.templates.eotho

import org.scalatest.EitherValues
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class DiscountedDiningPaymentSentSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "discounted_dining_payment_sent" should {
    val templateLocator = new TemplateLocator {}
    val template = templateLocator.templateGroups("EOTHO").find(_.templateId == "discounted_dining_payment_sent").get
    val params = commonParameters ++ TemplateParams.newMessageAlert_Names ++ Map("claimRefNo" -> "1234")

    "render correct subject and fromAddress" in {
      template.subject(Map.empty) shouldBe "HMRC has sent a payment for the Eat Out to Help Out Scheme"
      template.fromAddress(Map.empty) shouldBe "Eat Out to Help Out Scheme <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent should include(
        "We have now checked your claim 1234, and sent a payment to the account details provided when the business was registered."
      )
      htmlContent should include("The payment will reach the account in 3 to 5 working days.")
      htmlContent should include("Eat Out to Help Out Scheme")
    }

    "render correct text content" in {
      val htmlContent = template.plainTemplate(params).toString
      htmlContent should include(
        "We have now checked your claim 1234, and sent a payment to the account details provided when the business was registered."
      )
      htmlContent should include("The payment will reach the account in 3 to 5 working days.")
      htmlContent should include("Eat Out to Help Out Scheme")
    }
  }
}
