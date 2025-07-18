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
import uk.gov.hmrc.hmrcemailrenderer.templates.ngr.NgrTemplates.ngr_registration_successful
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

class NgrRegistrationSuccessfulSpec extends AnyWordSpecLike with Matchers with OptionValues with CommonParamsForSpec {

  private val params = commonParameters ++ Map(
    "firstName" -> "Jim",
    "lastName"  -> "Ferguson",
    "reference" -> "123ABC"
  )

  private val template = TemplateLocator
    .findTemplate(ngr_registration_successful)
    .value

  private def verifyContent(content: String): Unit = {
    content should include("Manage your business rates valuation – registration successful")
    content should include("Dear Jim Ferguson")
    content should include("You have registered for the manage your business rates valuation service.")
    content should include(
      "Your reference is 123ABC. You will need this if you have a problem signing in to the service."
    )
    content should include(
      "From 1 April 2026, you must tell us within 60 days if you become the ratepayer of a property."
    )
    content should include("Go to GOV.UK and search 'HMRC online services'")
    content should include("From HMRC on behalf of the Valuation Officer")
  }

  "The registration successful email template" should {
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Manage your business rates valuation – registration successful"
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
