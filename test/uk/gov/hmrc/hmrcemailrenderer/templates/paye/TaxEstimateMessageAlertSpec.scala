/*
 * Copyright 2024 HM Revenue & Customs
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

import org.scalatest.{ EitherValues, OptionValues }
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator, TemplateUtils }

class TaxEstimateMessageAlertSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "new_tax_estimate_message_alert" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("fullName" -> "Some Person")
    val template = templateLocator.templateGroups("PAYE").find(_.templateId == "tax_estimate_message_alert").get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Check your PAYE code change online"
      template.fromAddress(Map.empty) shouldBe "HMRC Check your Income Tax service <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("You have a tax code change")
      htmlContent should include("Dear Some Person")
      htmlContent should include(
        "Your PAYE Income Tax records have recently changed, which means the amount of tax you pay will change."
      )
      htmlContent should include(
        "For security reasons we do not give the full details here, but it could be because:"
      )
      if (TemplateUtils.isP2TemplateAnnual) {
        htmlContent should include("we have now calculated your tax code for the next tax year")
      } else {
        htmlContent should not include "we have now calculated your tax code for the next tax year"
      }
      htmlContent should include("your job changed")
      htmlContent should include("your pay changed")
      htmlContent should include("your company benefits, such as a company car changed")
      htmlContent should include("your pension changed")
      htmlContent should include("How to check your details to make sure you pay the right amount of tax")
      htmlContent should include(
        "Search GOV.UK for ‘personal tax account’, sign in and go to the ‘Pay As You Earn (PAYE)’ section."
      )
      htmlContent should include(
        "If you sign in using a business tax account, you may be able to use it to access your personal tax account."
      )
      htmlContent should include("If you do not have a personal tax account")
      htmlContent should include("You need to set one up before you can see your tax code change.")
      htmlContent should include("Search GOV.UK for ‘Personal tax account: sign in or set up’.")
      htmlContent should include("Why you're receiving this email")
      htmlContent should include(
        "You're receiving this email because you chose to receive email updates instead of letters by post."
      )
      htmlContent should include("For security reasons we have not included any links in this email.")
      htmlContent should include("From HMRC Check your Income Tax")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("You have a tax code change")
      txtContent should include("Dear Some Person")
      txtContent should include(
        "Your PAYE Income Tax records have recently changed, which means the amount of tax you pay will change."
      )
      txtContent should include(
        "For security reasons we do not give the full details here, but it could be because:"
      )
      if (TemplateUtils.isP2TemplateAnnual) {
        txtContent should include("we have now calculated your tax code for the next tax year")
      } else {
        txtContent should not include "we have now calculated your tax code for the next tax year"
      }
      txtContent should include("your job changed")
      txtContent should include("your pay changed")
      txtContent should include("your company benefits, such as a company car changed")
      txtContent should include("your pension changed")
      txtContent should include("How to check your details to make sure you pay the right amount of tax")
      txtContent should include(
        "Search GOV.UK for ‘personal tax account’, sign in and go to the ‘Pay As You Earn (PAYE)’ section."
      )
      txtContent should include(
        "If you sign in using a business tax account, you may be able to use it to access your personal tax account."
      )
      txtContent should include("If you do not have a personal tax account")
      txtContent should include("You need to set one up before you can see your tax code change.")
      txtContent should include("Search GOV.UK for ‘Personal tax account: sign in or set up’.")
      txtContent should include("Why you're receiving this email")
      txtContent should include(
        "You're receiving this email because you chose to receive email updates instead of letters by post."
      )
      txtContent should include("For security reasons we have not included any links in this email.")
      txtContent should include("From HMRC Check your Income Tax")
    }
  }

}
