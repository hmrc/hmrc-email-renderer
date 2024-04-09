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
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.RegisterYourCompany
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress, TemplateLoader, TemplateLocator }

class RegisterYourCompanyVerificationEmailSpec
    extends AnyWordSpec with Matchers with TemplateLoader with TemplateLocator with CommonParamsForSpec {

  val params = commonParameters ++ Map(
    "verificationLink" -> "/foo/bar"
  )

  "Rendering the registerYourCompanyVerificationEmail" when {

    "rendering the English Language version" should {

      val template = templateGroups(RegisterYourCompany.name)
        .find(_.templateId == "register_your_company_verification_email")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "register_your_company_verification_email"
        template.service shouldBe RegisterYourCompany
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(
          Map.empty
        ) shouldBe "Confirm your email address - Set up a limited company and register for Corporation Tax service"
        template.priority shouldBe Some(MessagePriority.Urgent)
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(params).toString

        htmlContent should include("Confirm your email address")
        htmlContent should include(
          "You are getting this email because you have signed up to use the 'Set up a limited company and register for Corporation Tax' service."
        )
        htmlContent should include("To confirm your email address, click this link:")
        htmlContent should include("""<a href="/foo/bar" style="color: #005EA5;">/foo/bar</a>""")
        htmlContent should include("This link will expire after 3 days")
        htmlContent should include(
          "If you do not confirm your email address within this time, you will have to log back into the service and request a new link."
        )
        htmlContent should include("From HM Revenue & Customs and Companies House")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(params).toString

        txtContent should include("Confirm your email address")
        txtContent should include(
          "You are getting this email because you have signed up to use the 'Set up a limited company and register for Corporation Tax' service."
        )
        txtContent should include("To confirm your email address, click this link:")
        txtContent should include("/foo/bar")
        txtContent should include("This link will expire after 3 days")
        txtContent should include(
          "If you do not confirm your email address within this time, you will have to log back into the service and request a new link."
        )
        txtContent should include("From HM Revenue & Customs and Companies House")
      }
    }

    "rendering the Welsh Language version" should {
      val template = templateGroups(RegisterYourCompany.name)
        .find(_.templateId == "register_your_company_verification_email_cy")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "register_your_company_verification_email_cy"
        template.service shouldBe RegisterYourCompany
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(
          Map.empty
        ) shouldBe "Cadarnhewch eich cyfeiriad e-bost – y gwasanaeth Sefydlu cwmni cyfyngedig a chofrestru ar gyfer Treth Gorfforaeth"
        template.priority shouldBe Some(MessagePriority.Urgent)
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(params).toString

        htmlContent should include("Cadarnhau’ch cyfeiriad e-bost")
        htmlContent should include(
          "Rydych yn cael yr e-bost hwn oherwydd eich bod wedi cofrestru i ddefnyddio’r gwasanaeth ‘Sefydlu cwmni cyfyngedig a chofrestru ar gyfer Treth Gorfforaeth’."
        )
        htmlContent should include("I gadarnhau’ch cyfeiriad e-bost, cliciwch y cysylltiad hwn:")
        htmlContent should include("""<a href="/foo/bar" style="color: #005EA5;">/foo/bar</a>""")
        htmlContent should include("Bydd y cysylltiad hwn yn dod i ben ar ôl 3 diwrnod")
        htmlContent should include(
          "Os na fyddwch yn cadarnhau eich cyfeiriad e-bost cyn pen y cyfnod hwn, bydd yn rhaid i chi fewngofnodi i’r gwasanaeth eto a gofyn am gysylltiad newydd."
        )
        htmlContent should include("Oddi wrth Gyllid a Thollau EF a Thŷ’r Cwmnïau")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(params).toString

        txtContent should include("Cadarnhau’ch cyfeiriad e-bost")
        txtContent should include(
          "Rydych yn cael yr e-bost hwn oherwydd eich bod wedi cofrestru i ddefnyddio’r gwasanaeth ‘Sefydlu cwmni cyfyngedig a chofrestru ar gyfer Treth Gorfforaeth’."
        )
        txtContent should include("I gadarnhau’ch cyfeiriad e-bost, cliciwch y cysylltiad hwn:")
        txtContent should include("/foo/bar")
        txtContent should include("Bydd y cysylltiad hwn yn dod i ben ar ôl 3 diwrnod")
        txtContent should include(
          "Os na fyddwch yn cadarnhau eich cyfeiriad e-bost cyn pen y cyfnod hwn, bydd yn rhaid i chi fewngofnodi i’r gwasanaeth eto a gofyn am gysylltiad newydd."
        )
        txtContent should include("Oddi wrth Gyllid a Thollau EF a Thŷ’r Cwmnïau")
      }
    }
  }
}
