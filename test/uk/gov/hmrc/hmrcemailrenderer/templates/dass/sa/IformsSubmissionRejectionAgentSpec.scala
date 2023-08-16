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

package uk.gov.hmrc.hmrcemailrenderer.templates.dass.sa

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.{ EitherValues, OptionValues }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator.templateGroups
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress, TemplateLoader }

class IformsSubmissionRejectionAgentSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "iforms_submission_rejection_email_agent" when {
    "rendering the English Language version" should {

      val template = templateGroups("DASS")
        .find(_.templateId == "iforms_submission_rejection_email_agent")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "iforms_submission_rejection_email_agent"
        template.service shouldBe SelfAssessment
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(Map.empty) shouldBe "Action Required: HMRC Application Rejected"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters + ("name" -> "FirstName LastNam")).toString

        htmlContent should include("Action Required: HMRC Application Rejected")
        htmlContent should include(
          "We have received an application to register for Self Assessment for your client FirstName LastNam.")
        htmlContent should include(
          "We are unable to process your application because the personal details provided do not match our records.")
        htmlContent should include("WHAT TO DO NOW")
        htmlContent should include(
          "You will need to check or update your client’s personal details before resubmitting the form.")
        htmlContent should include(
          """You can ask HMRC to update your client’s personal details. Go to GOV.UK and search for “Tell HMRC about a change to your personal details” and look for “Change of name or address”. Changes may take up to 15 days to complete."""
        )
        htmlContent should include(
          "Alternatively, your client can update their personal details online immediately using their personal tax account.")
        htmlContent should include("From HMRC Digital")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "FirstName LastName")).toString

        txtContent should include("Action Required: HMRC Application Rejected")
        txtContent should include(
          "We have received an application to register for Self Assessment for your client FirstName LastName.")
        txtContent should include(
          "We are unable to process your application because the personal details provided do not match our records.")
        txtContent should include("WHAT TO DO NOW")
        txtContent should include(
          "You will need to check or update your client’s personal details before resubmitting the form.")
        txtContent should include(
          """You can ask HMRC to update your client’s personal details. Go to GOV.UK and search for “Tell HMRC about a change to your personal details” and look for “Change of name or address”. Changes may take up to 15 days to complete."""
        )
        txtContent should include(
          "Alternatively, your client can update their personal details online immediately using their personal tax account.")
        txtContent should include("From HMRC Digital")
      }
    }
    "rendering the Welsh Language version" should {

      val template = templateGroups("DASS")
        .find(_.templateId == "iforms_submission_rejection_email_agent_cy")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "iforms_submission_rejection_email_agent_cy"
        template.service shouldBe SelfAssessment
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(Map.empty) shouldBe "Camau i’w cymryd: Cais i CThEF wedi’i wrthod"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters + ("name" -> "FirstName LastNam")).toString

        htmlContent should include("Camau i’w cymryd: Cais i CThEF wedi’i wrthod")
        htmlContent should include(
          "Rydym wedi cael cais i gofrestru’ch cleient FirstName LastNam ar gyfer Hunanasesiad.")
        htmlContent should include(
          "Ni allwn brosesu’ch cais oherwydd nid yw’r manylion personol rydych wedi’u rhoi yn cyd-fynd â’n cofnodion.")
        htmlContent should include("YR HYN I’W WNEUD NAWR")
        htmlContent should include(
          "Bydd angen i chi wirio neu ddiweddaru manylion personol eich cleient cyn ail-gyflwyno’r ffurflen.")
        htmlContent should include(
          """Gallwch ofyn i CThEF ddiweddaru manylion personol eich cleient. Ewch i GOV.UK a chwilio am “Tell HMRC about a change to your personal details” ac yna “Change of name or address”. Gall newidiadau gymryd hyd at 15 diwrnod i’w cwblhau."""
        )
        htmlContent should include(
          "Fel arall, gall eich cleient ddiweddaru ei fanylion personol ar-lein, ar unwaith, drwy ddefnyddio’i gyfrif treth personol.")
        htmlContent should include("Oddi wrth Adran Ddigidol CThEF")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "FirstName LastNam")).toString

        txtContent should include("Camau i’w cymryd: Cais i CThEF wedi’i wrthod")
        txtContent should include(
          "Rydym wedi cael cais i gofrestru’ch cleient FirstName LastNam ar gyfer Hunanasesiad.")
        txtContent should include(
          "Ni allwn brosesu’ch cais oherwydd nid yw’r manylion personol rydych wedi’u rhoi yn cyd-fynd â’n cofnodion.")
        txtContent should include("YR HYN I’W WNEUD NAWR")
        txtContent should include(
          "Bydd angen i chi wirio neu ddiweddaru manylion personol eich cleient cyn ail-gyflwyno’r ffurflen.")
        txtContent should include(
          """Gallwch ofyn i CThEF ddiweddaru manylion personol eich cleient. Ewch i GOV.UK a chwilio am “Tell HMRC about a change to your personal details” ac yna “Change of name or address”. Gall newidiadau gymryd hyd at 15 diwrnod i’w cwblhau."""
        )
        txtContent should include(
          "Fel arall, gall eich cleient ddiweddaru ei fanylion personol ar-lein, ar unwaith, drwy ddefnyddio’i gyfrif treth personol.")
        txtContent should include("Oddi wrth Adran Ddigidol CThEF")
      }
    }
  }
}
