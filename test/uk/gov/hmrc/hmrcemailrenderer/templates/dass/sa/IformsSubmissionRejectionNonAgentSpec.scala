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

import org.scalatest.{ EitherValues, OptionValues }
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator.templateGroups
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress, TemplateLoader }

class IformsSubmissionRejectionNonAgentSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "iforms_submission_rejection_email_non_agent" when {
    "rendering the English Language version" should {

      val template = templateGroups("DASS")
        .find(_.templateId == "iforms_submission_rejection_email_non_agent")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "iforms_submission_rejection_email_non_agent"
        template.service shouldBe SelfAssessment
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(Map.empty) shouldBe "Action Required: HMRC Application Rejected"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters + ("name" -> "SomeName")).toString

        htmlContent should include("Action Required: HMRC Application Rejected")
        htmlContent should include("Dear SomeName,")
        htmlContent should include("We have received your application to register for Self Assessment.")
        htmlContent should include(
          "We are unable to process your application because the information you provided does not match our records.")
        htmlContent should include("WHAT TO DO NOW")
        htmlContent should include(
          "You will need to check or update your personal details before resubmitting the form.")
        htmlContent should include(
          "You can check and update your personal details online using your personal tax account.")
        htmlContent should include(
          """If you don’t have a personal tax account, you can set one up at GOV.UK. On the GOV.UK website, search for PTA and look for “Personal tax account: sign in or set up”.""")
        htmlContent should include("From HMRC Digital")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "SomeName")).toString

        txtContent should include("Action Required: HMRC Application Rejected")
        txtContent should include("Dear SomeName,")
        txtContent should include("We have received your application to register for Self Assessment.")
        txtContent should include(
          "We are unable to process your application because the information you provided does not match our records.")
        txtContent should include("WHAT TO DO NOW")
        txtContent should include(
          "You will need to check or update your personal details before resubmitting the form.")
        txtContent should include(
          "You can check and update your personal details online using your personal tax account.")
        txtContent should include(
          """If you don’t have a personal tax account, you can set one up at GOV.UK. On the GOV.UK website, search for PTA and look for “Personal tax account: sign in or set up”.""")
        txtContent should include("From HMRC Digital")
      }
    }
    "rendering the Welsh Language version" should {

      val template = templateGroups("DASS")
        .find(_.templateId == "iforms_submission_rejection_email_non_agent_cy")
        .get

      "render correct meta information" in {
        template.templateId shouldBe "iforms_submission_rejection_email_non_agent_cy"
        template.service shouldBe SelfAssessment
        template.fromAddress(Map.empty) shouldBe FromAddress.govUkTeamAddress
        template.subject(Map.empty) shouldBe "Camau i’w cymryd: Cais i CThEF wedi’i wrthod"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters + ("name" -> "SomeName")).toString

        htmlContent should include("Camau i’w cymryd: Cais i CThEF wedi’i wrthod")
        htmlContent should include("Annwyl SomeName,")
        htmlContent should include("Mae’ch cais i gofrestru ar gyfer Hunanasesiad wedi dod i law.")
        htmlContent should include(
          "Ni allwn brosesu’ch cais oherwydd nid yw’r wybodaeth rydych wedi’i rhoi yn cyd-fynd â’n cofnodion.")
        htmlContent should include("YR HYN I’W WNEUD NAWR")
        htmlContent should include(
          "Bydd angen i chi wirio neu ddiweddaru’ch manylion personol cyn ail-gyflwyno’r ffurflen.")
        htmlContent should include(
          "Gallwch wirio a diweddaru’ch manylion personol ar-lein gan ddefnyddio’ch cyfrif treth personol.")
        htmlContent should include(
          """Os nad oes gennych gyfrif treth personol, gallwch greu un ar GOV.UK. Ar wefan GOV.UK, chwiliwch am PTA ac yna “Personal tax account: sign in or set up”.""")
        htmlContent should include("Oddi wrth Adran Ddigidol CThEF")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "SomeName")).toString

        txtContent should include("Camau i’w cymryd: Cais i CThEF wedi’i wrthod")
        txtContent should include("Annwyl SomeName,")
        txtContent should include("Mae’ch cais i gofrestru ar gyfer Hunanasesiad wedi dod i law.")
        txtContent should include(
          "Ni allwn brosesu’ch cais oherwydd nid yw’r wybodaeth rydych wedi’i rhoi yn cyd-fynd â’n cofnodion.")
        txtContent should include("YR HYN I’W WNEUD NAWR")
        txtContent should include(
          "Bydd angen i chi wirio neu ddiweddaru’ch manylion personol cyn ail-gyflwyno’r ffurflen.")
        txtContent should include(
          "Gallwch wirio a diweddaru’ch manylion personol ar-lein gan ddefnyddio’ch cyfrif treth personol.")
        txtContent should include(
          """Os nad oes gennych gyfrif treth personol, gallwch greu un ar GOV.UK. Ar wefan GOV.UK, chwiliwch am PTA ac yna “Personal tax account: sign in or set up”.""")
        txtContent should include("Oddi wrth Adran Ddigidol CThEF")
      }
    }
  }
}
