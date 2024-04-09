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

package uk.gov.hmrc.hmrcemailrenderer.templates.registeryourcompany

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.RegisterYourCompany
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress, TemplateLoader, TemplateLocator }

class RegisterYourCompanyRegisterVATEmailSpec
    extends AnyWordSpec with Matchers with TemplateLoader with TemplateLocator with CommonParamsForSpec {

  "Rendering the registerYourCompanyRegisterVATEmail" when {

    "rendering the English Language version" should {

      val template = templateGroups(RegisterYourCompany.name)
        .find(_.templateId == "register_your_company_register_vat_email")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "register_your_company_register_vat_email"
        template.service shouldBe RegisterYourCompany
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(Map.empty) shouldBe "Register for VAT online - new service"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters).toString

        htmlContent should include("You can now register for VAT online")
        htmlContent should include("You must register as soon as your VAT taxable turnover:")
        htmlContent should include("is more than £85,000 for any 12-month period")
        htmlContent should include("is more than £85,000 for a single 30-day period")
        htmlContent should include(
          "You can still register voluntarily if the company's VAT taxable turnover is less than £85,000 a year."
        )
        htmlContent should include(
          "To access the service, use the link you received previously in the 'Register your company' welcome email"
        )
        htmlContent should include("From HMRC VAT")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters).toString

        txtContent should include("You can now register for VAT online")
        txtContent should include("You must register as soon as your VAT taxable turnover:")
        txtContent should include("is more than £85,000 for any 12-month period")
        txtContent should include("is more than £85,000 for a single 30-day period")
        txtContent should include(
          "You can still register voluntarily if the company's VAT taxable turnover is less than £85,000 a year."
        )
        txtContent should include(
          "To access the service, use the link you received previously in the 'Register your company' welcome email"
        )
        txtContent should include("From HMRC VAT")
      }
    }

    "rendering the Welsh Language version" should {
      val template = templateGroups(RegisterYourCompany.name)
        .find(_.templateId == "register_your_company_register_vat_email_cy")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "register_your_company_register_vat_email_cy"
        template.service shouldBe RegisterYourCompany
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(Map.empty) shouldBe "Cofrestrwch ar gyfer TAW ar-lein – gwasanaeth newydd"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters).toString

        htmlContent should include("Gallwch nawr gofrestru ar gyfer TAW ar-lein")
        htmlContent should include("Mae’n rhaid i chi gofrestru cyn gynted ag y bydd eich trosiant trethadwy TAW:")
        htmlContent should include("yn fwy nag £85,000 am unrhyw gyfnod o 12 mis")
        htmlContent should include("yn fwy nag £85,000 am un cyfnod o 30 diwrnod")
        htmlContent should include(
          "Gallwch gofrestru’n wirfoddol o hyd os yw trosiant trethadwy TAW y cwmni yn llai nag £85,000 y flwyddyn."
        )
        htmlContent should include(
          "I gael mynediad at y gwasanaeth, defnyddiwch y cysylltiad a gawsoch yn flaenorol yn yr e-bost croeso wrth i chi gofrestru’ch cwmni"
        )
        htmlContent should include("Oddi wrth adran TAW CThEF")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters).toString

        txtContent should include("Gallwch nawr gofrestru ar gyfer TAW ar-lein")
        txtContent should include("Mae’n rhaid i chi gofrestru cyn gynted ag y bydd eich trosiant trethadwy TAW:")
        txtContent should include("yn fwy nag £85,000 am unrhyw gyfnod o 12 mis")
        txtContent should include("yn fwy nag £85,000 am un cyfnod o 30 diwrnod")
        txtContent should include(
          "Gallwch gofrestru’n wirfoddol o hyd os yw trosiant trethadwy TAW y cwmni yn llai nag £85,000 y flwyddyn."
        )
        txtContent should include(
          "I gael mynediad at y gwasanaeth, defnyddiwch y cysylltiad a gawsoch yn flaenorol yn yr e-bost croeso wrth i chi gofrestru’ch cwmni"
        )
        txtContent should include("Oddi wrth adran TAW CThEF")
      }
    }
  }
}
