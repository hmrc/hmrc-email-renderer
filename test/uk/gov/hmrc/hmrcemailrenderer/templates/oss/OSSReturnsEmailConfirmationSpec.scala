/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.oss

import org.scalatest.{ EitherValues, Matchers, OptionValues, WordSpecLike }
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.OSS
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }

class OSSReturnsEmailConfirmationSpec
    extends WordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "OSS Returns Email Confirmation" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map(
      "recipientName_line1"                -> "Joe Bloggs",
      "businessName"                       -> "Test Business",
      "period"                             -> "1 July to 30 September 2021",
      "lastDayOfMonthAfterCalendarQuarter" -> "31 October 2021",
      "VATOwed"                            -> "£1250"
    )
    val template = templateLocator
      .templateGroups("OSS")
      .find(_.templateId == "oss_returns_email_confirmation")
      .get

    "render correct meta information" in {
      template.templateId shouldBe "oss_returns_email_confirmation"
      template.service shouldBe OSS
      template.fromAddress(Map.empty) shouldBe "VAT One Stop Shop Team <noreply@tax.service.gov.uk>"
      template.subject(Map.empty) shouldBe "HMRC: VAT return submitted"
      template.priority shouldBe Some(MessagePriority.Background)
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("You submitted a VAT return for the One Stop Shop Union scheme")
      htmlContent should include("Dear Joe Bloggs")
      htmlContent should include("HMRC has received your VAT return for 1 July to 30 September 2021.")
      htmlContent should include("VAT owed")
      htmlContent should include("£1250")
      htmlContent should include("You need to pay by 31 October 2021.")
      htmlContent should include("EU countries can charge you interest or penalties for late payments.")
      htmlContent should include("How to pay")
      htmlContent should include("You can pay by signing back into your One Stop Shop account.")
      htmlContent should include("Search GOV.UK for ‘Submit your One Stop Shop return and pay VAT’.")
      htmlContent should include(
        "Sign in from that page using the Government Gateway user ID and password used to register for UK VAT.")
      htmlContent should include("Select ‘View past returns’ in your account.")
      htmlContent should include("Select your return period.")
      htmlContent should include("Select ‘Pay now’.")
      htmlContent should include("Choose a way to pay.")
      htmlContent should include("You can also pay using the ‘Pay your VAT bill’ service.")
      htmlContent should include("Search GOV.UK for ‘Pay your VAT bill’.")
      htmlContent should include("Select ‘Pay now’.")
      htmlContent should include(
        "When asked ‘Do you want to sign in to your tax account?’, select ‘No, continue to payment options’.")
      htmlContent should include("Enter your UK VAT registration number.")
      htmlContent should include("Confirm the return period.")
      htmlContent should include("From the VAT One Stop Shop team")
    }
  }
}
