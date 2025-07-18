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

package uk.gov.hmrc.hmrcemailrenderer.templates.ngr
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.ngr.NgrTemplates.ngr_add_property_request_sent
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

class NgrAddPropertyRequestSentSpec extends AnyWordSpecLike with Matchers with OptionValues with CommonParamsForSpec {

  private val params = commonParameters ++ Map(
    "firstName"         -> "Jim",
    "lastName"          -> "Ferguson",
    "reference"         -> "123ABC",
    "postcodeFirstPart" -> "BS15"
  )

  private val template = TemplateLocator
    .findTemplate(ngr_add_property_request_sent)
    .value

  private def verifyContent(content: String): Unit = {
    content should include("Add a property request sent")
    content should include("Dear Jim Ferguson")
    content should include(
      "You have sent us a request to add a property on the manage your business rates valuation service."
    )
    content should include("First part of property postcode: BS15")
    content should include("Your reference: 123ABC")
    content should include(
      "We can usually give you a decision on your request to add a property within 15 working days."
    )
    content should include("Go to GOV.UK and search 'HMRC online services'")
    content should include("From HMRC on behalf of the Valuation Officer")
  }

  "The property linking request sent email template" should {
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Add a property request sent"
    }

    "render correct from address" in {
      template.fromAddress(Map.empty) shouldBe "Valuation Office Agency <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent should include("HM Revenue &amp; Customs")
      verifyContent(htmlContent)
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString
      verifyContent(txtContent)
    }
  }
}
