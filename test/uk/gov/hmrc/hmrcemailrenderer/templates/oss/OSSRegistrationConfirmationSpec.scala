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

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import uk.gov.hmrc.play.test.UnitSpec

class OSSRegistrationConfirmationSpec extends UnitSpec with EitherValues with TemplateLoader with CommonParamsForSpec {

  "OSS Registration Confirmation" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map(
      "recipientName_line1" -> "Joe Bloggs",
      "businessName"        -> "Test Business",
      "reference"           -> "123456789"
    )
    val template = templateLocator
      .templateGroups("OSS")
      .find(_.templateId == "oss_registration_confirmation")
      .get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "HMRC: your registration to pay VAT to the EU"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("You are registered to pay VAT to the EU on sales of goods from Northern Ireland")
      htmlContent should include("Dear Joe Bloggs")
      htmlContent should include("HMRC has received the registration from Test Business.")
      htmlContent should include(
        "We will send you details about how to submit returns and make payments before your first VAT return for this scheme is due.")
      htmlContent should include("If you need to contact us, quote your UK VAT registration number:")
      htmlContent should include("123456789")
      htmlContent should include("From Pay VAT on sales of goods from Northern Ireland to the EU")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("You are registered to pay VAT to the EU on sales of goods from Northern Ireland")
      txtContent should include("Dear Joe Bloggs")
      txtContent should include("HMRC has received the registration from Test Business.")
      txtContent should include(
        "We will send you details about how to submit returns and make payments before your first VAT return for this scheme is due.")
      txtContent should include("If you need to contact us, quote your UK VAT registration number:")
      txtContent should include("123456789")
      txtContent should include("From Pay VAT on sales of goods from Northern Ireland to the EU")
    }
  }
}
