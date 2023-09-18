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
import org.scalatest.{EitherValues, OptionValues}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator.templateGroups
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, FromAddress, TemplateLoader}

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

        htmlContent should include("Your HMRC application has been rejected")
        htmlContent should include("Dear SomeName")
        htmlContent should include("We have received your application to register for Self Assessment.")
        htmlContent should include(
          "We could not process your application because your personal details do not match our records.")
        htmlContent should include("What to do next")
        htmlContent should include(
          "You need to check and update your details on your personal tax account before you can resubmit the application.")
        htmlContent should include(
          "If you do not have a personal tax account, you can set one up. On the GOV.UK website, search ‘PTA’ and find the page ‘Personal tax account: sign in or set up’.")
        htmlContent should include("From HMRC Digital")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "SomeName")).toString

        txtContent should include("Your HMRC application has been rejected")
        txtContent should include("Dear SomeName")
        txtContent should include("We have received your application to register for Self Assessment.")
        txtContent should include(
          "We could not process your application because your personal details do not match our records.")
        txtContent should include("What to do next")
        txtContent should include(
          "You need to check and update your details on your personal tax account before you can resubmit the application.")
        txtContent should include(
          "If you do not have a personal tax account, you can set one up. On the GOV.UK website, search ‘PTA’ and find the page ‘Personal tax account: sign in or set up’.")
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

        htmlContent should include("Mae’ch cais i CThEF wedi’i wrthod")
        htmlContent should include("Annwyl SomeName")
        htmlContent should include("Mae’ch cais i gofrestru ar gyfer Hunanasesiad wedi dod i law.")
        htmlContent should include(
          "Nid oeddem yn gallu prosesu’ch cais oherwydd nad yw’ch manylion personol yn cyd-fynd â’n cofnodion.")
        htmlContent should include("Yr hyn i’w wneud nesaf")
        htmlContent should include(
          "Mae angen i chi wirio a diweddaru’ch manylion ar eich cyfrif treth personol cyn i chi allu ailgyflwyno’r cais.")
        htmlContent should include(
          "Os nad oes gennych gyfrif treth personol, gallwch drefnu un. Ar wefan GOV.UK, chwiliwch am ‘PTA’ ac ewch i’r dudalen ‘Personal tax account: sign in or set up’.")
        htmlContent should include("Oddi wrth Adran Ddigidol CThEF")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "SomeName")).toString

        txtContent should include("Mae’ch cais i CThEF wedi’i wrthod")
        txtContent should include("Annwyl SomeName")
        txtContent should include("Mae’ch cais i gofrestru ar gyfer Hunanasesiad wedi dod i law.")
        txtContent should include(
          "Nid oeddem yn gallu prosesu’ch cais oherwydd nad yw’ch manylion personol yn cyd-fynd â’n cofnodion.")
        txtContent should include("Yr hyn i’w wneud nesaf")
        txtContent should include(
          "Mae angen i chi wirio a diweddaru’ch manylion ar eich cyfrif treth personol cyn i chi allu ailgyflwyno’r cais.")
        txtContent should include(
          "Os nad oes gennych gyfrif treth personol, gallwch drefnu un. Ar wefan GOV.UK, chwiliwch am ‘PTA’ ac ewch i’r dudalen ‘Personal tax account: sign in or set up’.")
        txtContent should include("Oddi wrth Adran Ddigidol CThEF")
      }
    }
  }
}
