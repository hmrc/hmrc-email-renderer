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

package uk.gov.hmrc.hmrcemailrenderer.templates.oss

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.{ EitherValues, OptionValues }
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.OSS
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }

class OSSReturnsEmailConfirmationNoVatOwedSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "OSS Returns Email Confirmation No VAT Owed" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map(
      "recipientName_line1" -> "Joe Bloggs",
      "period"              -> "1 July to 30 September 2021"
    )
    val template = templateLocator
      .templateGroups("OSS")
      .find(_.templateId == "oss_returns_email_confirmation_no_vat_owed")
      .get

    "render correct meta information" in {
      template.templateId shouldBe "oss_returns_email_confirmation_no_vat_owed"
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
      htmlContent should include("From the VAT One Stop Shop team")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("You submitted a VAT return for the One Stop Shop Union scheme")
      txtContent should include("Dear Joe Bloggs")
      txtContent should include("HMRC has received your VAT return for 1 July to 30 September 2021.")
      txtContent should include("From the VAT One Stop Shop team")
    }
  }
}
