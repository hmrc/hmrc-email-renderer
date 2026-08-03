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

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.{ EitherValues, OptionValues }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator, TemplateUtils }

class DailyTaxEstimateMessageAlertSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {
  "daily_tax_estimate_message_alert" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("fullName" -> "Leslie Carter")
    val template = templateLocator.templateGroups("PAYE").find(_.templateId == "daily_tax_estimate_message_alert").get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Check your PAYE code change online"
      template.fromAddress(Map.empty) shouldBe "HMRC Check your Income Tax service <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Your tax code is changing")
      htmlContent should include("Dear Leslie Carter")
      htmlContent should include(
        "Your PAYE Income Tax records have recently changed, which means the amount of tax you pay may change."
      )
      htmlContent should include(
        "For security reasons we do not give the full details here. " +
          "It could be because there's been changes to your job, pay, company benefits (like a company car) or pension."
      )
      htmlContent should include("How to check you're paying the right amount of tax")
      htmlContent should include(
        "Sign in to your HMRC online account on GOV.UK or use the HMRC app. Go to the ‘Pay As You Earn (PAYE)’ section."
      )
      htmlContent should include(
        "If you sign in using a business tax account, you may be able to use it to access your personal tax account."
      )
      htmlContent should include("Why you’re receiving this email")
      htmlContent should include(
        "You’re receiving this email because you chose to receive email updates instead of letters by post."
      )
      htmlContent should include("For security reasons we have not included any links in this email.")
      htmlContent should include("From HMRC Check your Income Tax")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent should include("Your tax code is changing")
      txtContent should include("Dear Leslie Carter")
      txtContent should include(
        "Your PAYE Income Tax records have recently changed, which means the amount of tax you pay may change."
      )
      txtContent should include(
        "For security reasons we do not give the full details here. " +
          "It could be because there's been changes to your job, pay, company benefits (like a company car) or pension."
      )
      txtContent should include("How to check you're paying the right amount of tax")
      txtContent should include(
        "Sign in to your HMRC online account on GOV.UK or use the HMRC app. Go to the ‘Pay As You Earn (PAYE)’ section."
      )
      txtContent should include(
        "If you sign in using a business tax account, you may be able to use it to access your personal tax account."
      )
      txtContent should include("Why you’re receiving this email")
      txtContent should include(
        "You’re receiving this email because you chose to receive email updates instead of letters by post."
      )
      txtContent should include("For security reasons we have not included any links in this email.")
      txtContent should include("From HMRC Check your Income Tax")
    }
  }
}
