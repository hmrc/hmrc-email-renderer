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
        template.subject(Map.empty) shouldBe "The HMRC application for your client has been rejected"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters + ("name" -> "FirstName LastNam")).toString

        htmlContent should include("The HMRC application for your client has been rejected")
        htmlContent should include("Dear Agent")
        htmlContent should include(
          "We have received an application to register your client FirstName LastNam for Self Assessment. ")
        htmlContent should include(
          "We could not process the application because your client’s personal details do not match our records.")
        htmlContent should include("What to do next")
        htmlContent should include("Check that you entered your client’s details correctly on the application.")
        htmlContent should include(
          "If you did, then your client should check and update their details on their personal tax account.")
        htmlContent should include(
          "You can also ask HMRC to update your client’s details. On the GOV.UK website, search for ‘change personal details’ and find the page ‘Tell HMRC about a change to your personal details’. This may take up to 15 days.")
        htmlContent should include(
          "Once your client’s personal details have been updated, you can resubmit the application. ")
        htmlContent should include("From HMRC Digital")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "FirstName LastName")).toString

        txtContent should include("The HMRC application for your client has been rejected")
        txtContent should include("Dear Agent")
        txtContent should include(
          "We have received an application to register your client FirstName LastName for Self Assessment.")
        txtContent should include(
          "We could not process the application because your client’s personal details do not match our records.")
        txtContent should include("What to do next")
        txtContent should include("Check that you entered your client’s details correctly on the application.")
        txtContent should include(
          "If you did, then your client should check and update their details on their personal tax account.")
        txtContent should include(
          "You can also ask HMRC to update your client’s details. On the GOV.UK website, search for ‘change personal details’ and find the page ‘Tell HMRC about a change to your personal details’. This may take up to 15 days.")
        txtContent should include(
          "Once your client’s personal details have been updated, you can resubmit the application.")
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
        template.subject(Map.empty) shouldBe "Mae’r cais i CThEF ar gyfer eich cleient wedi’i wrthod"
        template.priority shouldBe None
      }

      "render correct html content" in {

        val htmlContent = template.htmlTemplate(commonParameters + ("name" -> "FirstName LastNam")).toString

        htmlContent should include("Mae’r cais i CThEF ar gyfer eich cleient wedi’i wrthod")
        htmlContent should include("Annwyl Asiant")
        htmlContent should include(
          "Mae cais i gofrestru’ch cleient FirstName LastNam ar gyfer Hunanasesiad wedi dod i law.")
        htmlContent should include(
          "Nid oeddem yn gallu prosesu’r cais oherwydd nad yw manylion personol eich cleient yn cyd-fynd â’n cofnodion. ")
        htmlContent should include("Yr hyn i’w wneud nesaf")
        htmlContent should include("Gwiriwch eich bod wedi nodi manylion eich cleient yn gywir ar y cais.")
        htmlContent should include(
          "Os felly, dylai’ch cleient wirio a diweddaru ei fanylion ar ei gyfrif treth personol.")
        htmlContent should include(
          "Gallwch hefyd ofyn i CThEF ddiweddaru manylion eich cleient. Ar wefan GOV.UK, chwiliwch am ‘change personal details’ ac ewch i’r dudalen ‘Tell HMRC about a change to your personal details’. Gallai hyn gymryd hyd at 15 diwrnod.")
        htmlContent should include(
          "Ar ôl i fanylion personol eich cleient gael eu diweddaru, gallwch ailgyflwyno’r cais.")
        htmlContent should include("Oddi wrth Adran Ddigidol CThEF")
      }

      "render correct text content" in {

        val txtContent = template.plainTemplate(commonParameters + ("name" -> "FirstName LastNam")).toString

        txtContent should include("Mae’r cais i CThEF ar gyfer eich cleient wedi’i wrthod")
        txtContent should include("Annwyl Asiant")
        txtContent should include(
          "Mae cais i gofrestru’ch cleient FirstName LastNam ar gyfer Hunanasesiad wedi dod i law.")
        txtContent should include(
          "Nid oeddem yn gallu prosesu’r cais oherwydd nad yw manylion personol eich cleient yn cyd-fynd â’n cofnodion.")
        txtContent should include("Yr hyn i’w wneud nesaf")
        txtContent should include("Gwiriwch eich bod wedi nodi manylion eich cleient yn gywir ar y cais.")
        txtContent should include(
          "Os felly, dylai’ch cleient wirio a diweddaru ei fanylion ar ei gyfrif treth personol.")
        txtContent should include(
          "Gallwch hefyd ofyn i CThEF ddiweddaru manylion eich cleient. Ar wefan GOV.UK, chwiliwch am ‘change personal details’ ac ewch i’r dudalen ‘Tell HMRC about a change to your personal details’. Gallai hyn gymryd hyd at 15 diwrnod.")
        txtContent should include(
          "Ar ôl i fanylion personol eich cleient gael eu diweddaru, gallwch ailgyflwyno’r cais.")
        txtContent should include("Oddi wrth Adran Ddigidol CThEF")
      }
    }
  }
}
