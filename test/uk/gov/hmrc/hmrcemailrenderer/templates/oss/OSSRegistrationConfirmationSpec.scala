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

import org.scalatest.{ EitherValues, OptionValues }
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.OSS

class OSSRegistrationConfirmationSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "OSS Registration Confirmation" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map(
      "recipientName_line1"  -> "Joe Bloggs",
      "businessName"         -> "Test Business",
      "periodOfFirstReturn"  -> "July to September 2021",
      "firstDayOfNextPeriod" -> "1 October 2021",
      "commencementDate"     -> "12 June 2021",
      "redirectLink"         -> "http://test.com/blah-blah"
    )
    val template = templateLocator
      .templateGroups("OSS")
      .find(_.templateId == "oss_registration_confirmation")
      .get

    "render correct meta information" in {
      template.templateId shouldBe "oss_registration_confirmation"
      template.service shouldBe OSS
      template.fromAddress(Map.empty) shouldBe "VAT One Stop Shop Team <noreply@tax.service.gov.uk>"
      template.subject(Map.empty) shouldBe "HMRC: your registration for the One Stop Shop Union scheme"
      template.priority shouldBe Some(MessagePriority.Background)
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Dear Joe Bloggs")
      htmlContent should include("You are registered for the One Stop Shop VAT scheme")
      htmlContent should include("We’ve received your registration for Test Business")
      htmlContent should include(
        "You can now use this service to fill out quarterly returns for goods sold to consumers in the EU."
      )
      htmlContent should include("You can also pay any One Stop Shop VAT that you owe.")
      htmlContent should include(
        "You can begin your July to September 2021 return on 1 October 2021. Include any sales from 12 June 2021."
      )
      htmlContent should include("What happens next")
      htmlContent should include("We will contact you if we need to check any information.")
      htmlContent should include(
        "Read more information about <a href=\"http://test.com/blah-blah\" style=\"color: #005EA5;\"> how to complete an OSS return.</a>"
      )
      htmlContent should include("From the VAT One Stop Shop team")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("Dear Joe Bloggs")
      txtContent should include("You are registered for the One Stop Shop VAT scheme")
      txtContent should include("We’ve received your registration for Test Business")
      txtContent should include(
        "You can now use this service to fill out quarterly returns for goods sold to consumers in the EU."
      )
      txtContent should include("You can also pay any One Stop Shop VAT that you owe.")
      txtContent should include(
        "You can begin your July to September 2021 return on 1 October 2021. Include any sales from 12 June 2021."
      )
      txtContent should include("What happens next")
      txtContent should include("We will contact you if we need to check any information.")
      txtContent should include("Read more information about http://test.com/blah-blah how to complete an OSS return.")
      txtContent should include("From the VAT One Stop Shop team")
    }
  }
}
