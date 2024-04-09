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

package uk.gov.hmrc.hmrcemailrenderer.templates.cf

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.OptionValues
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.cf.ContactFormsTemplates.{ cf_enquiry_confirmation, contactFormsGroup }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

/** @author
  *   Yuriy Tumakha
  */
class ContactFormsEnquiryConfirmationSpec
    extends AnyWordSpecLike with should.Matchers with OptionValues with CommonParamsForSpec {

  private val params = commonParameters ++ TemplateParams.exampleParams(cf_enquiry_confirmation)
  private val template = TemplateLocator
    .templateGroups(contactFormsGroup)
    .find(_.templateId == cf_enquiry_confirmation)
    .value

  cf_enquiry_confirmation should {
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "You have sent an enquiry to the Valuation Office Agency"
    }

    "render correct from address" in {
      template.fromAddress(Map.empty) shouldBe "Valuation Office Agency <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("HM Revenue &amp; Customs")
      htmlContent should include("We have received your enquiry")
      htmlContent should include("Dear David Jones")
      htmlContent should include(
        "Thank you for contacting us. This email is confirmation that we have received your enquiry."
      )
      htmlContent should include(
        "We usually respond to enquiries within a few days. However, complex enquiries can take up to 28 days."
      )
      htmlContent should include("From Valuation Office Agency")
      htmlContent should include("Report the suspicious email to HMRC")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("We have received your enquiry")
      txtContent should include("Dear David Jones")
      txtContent should include(
        "Thank you for contacting us. This email is confirmation that we have received your enquiry."
      )
      txtContent should include(
        "We usually respond to enquiries within a few days. However, complex enquiries can take up to 28 days."
      )
      txtContent should include("From Valuation Office Agency")
      txtContent should include("Report the suspicious email to HMRC")
    }
  }

}
