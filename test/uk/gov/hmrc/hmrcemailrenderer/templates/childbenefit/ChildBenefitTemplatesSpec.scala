/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.childbenefit

import org.scalatest.{ EitherValues, OptionValues }
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }

class ChildBenefitTemplatesSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  val templateLocator: TemplateLocator = new TemplateLocator {}

  private def getTemplate(templateId: String): MessageTemplate =
    templateLocator
      .templateGroups("Child Benefit")
      .find(_.templateId == templateId)
      .value

  "newMessageAlert_CH(A)1700" should {

    val template = getTemplate("newMessageAlert_CH(A)1700")

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "You’ve got a new message from HMRC"
      template.fromAddress(Map.empty) shouldBe "Gov.uk Team <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(commonParameters).toString

      htmlContent should include("You’ve got a new message from HMRC")
      htmlContent should include("You have a new message from HMRC.")
      htmlContent should include("To view it, sign in to your HMRC online account.")
      htmlContent should include("For security reasons, we have not included a link with this email.")
      htmlContent should include("Why you got this email")
      htmlContent should include("You chose to get paperless notifications.")
      htmlContent should include(
        "This means we send you an email when you have a new message in your account."
      )
      htmlContent should include("From HMRC digital")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(commonParameters).toString

      txtContent should include("You’ve got a new message from HMRC")
      txtContent should include("You have a new message from HMRC.")
      txtContent should include("To view it, sign in to your HMRC online account.")
      txtContent should include("For security reasons, we have not included a link with this email.")
      txtContent should include("Why you got this email")
      txtContent should include("You chose to get paperless notifications.")
      txtContent should include(
        "This means we send you an email when you have a new message in your account."
      )
      txtContent should include("From HMRC digital")
    }
  }

  "newMessageAlert_CH(A)1700_cy" should {

    val template = getTemplate("newMessageAlert_CH(A)1700_cy")

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Mae gennych neges newydd oddi wrth CThEF"
      template.fromAddress(Map.empty) shouldBe "Gov.uk Team <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(commonParameters).toString

      htmlContent should include("Mae gennych neges newydd oddi wrth CThEF")
      htmlContent should include("Mae gennych neges newydd oddi wrth CThEF.")
      htmlContent should include("I’w gweld, mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      htmlContent should include(
        "Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn."
      )
      htmlContent should include("Pam y cawsoch yr e-bost hwn")
      htmlContent should include("Gwnaethoch ddewis cael hysbysiadau di-bapur.")
      htmlContent should include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch pan fydd gennych neges newydd yn eich cyfrif."
      )
      htmlContent should include("Oddi wrth adran Ddigidol CThEF")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(commonParameters).toString

      txtContent should include("Mae gennych neges newydd oddi wrth CThEF")
      txtContent should include("Mae gennych neges newydd oddi wrth CThEF.")
      txtContent should include("I’w gweld, mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      txtContent should include(
        "Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn."
      )
      txtContent should include("Pam y cawsoch yr e-bost hwn")
      txtContent should include("Gwnaethoch ddewis cael hysbysiadau di-bapur.")
      txtContent should include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch pan fydd gennych neges newydd yn eich cyfrif."
      )
      txtContent should include("Oddi wrth adran Ddigidol CThEF")
    }
  }

  "newMessageAlert_CH(A)1708" should {

    val template = getTemplate("newMessageAlert_CH(A)1708")

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "You’ve got a new message from HMRC"
      template.fromAddress(Map.empty) shouldBe "Gov.uk Team <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(commonParameters).toString

      htmlContent should include("You’ve got a new message from HMRC")
      htmlContent should include("You have a new message from HMRC.")
      htmlContent should include("To view it, sign in to your HMRC online account.")
      htmlContent should include("For security reasons, we have not included a link with this email.")
      htmlContent should include("Why you got this email")
      htmlContent should include("You chose to get paperless notifications.")
      htmlContent should include(
        "This means we send you an email when you have a new message in your account."
      )
      htmlContent should include("From HMRC digital")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(commonParameters).toString

      txtContent should include("You’ve got a new message from HMRC")
      txtContent should include("You have a new message from HMRC.")
      txtContent should include("To view it, sign in to your HMRC online account.")
      txtContent should include("For security reasons, we have not included a link with this email.")
      txtContent should include("Why you got this email")
      txtContent should include("You chose to get paperless notifications.")
      txtContent should include(
        "This means we send you an email when you have a new message in your account."
      )
      txtContent should include("From HMRC digital")
    }
  }

  "newMessageAlert_CH(A)1708_cy" should {

    val template = getTemplate("newMessageAlert_CH(A)1708_cy")

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Mae gennych neges newydd oddi wrth CThEF"
      template.fromAddress(Map.empty) shouldBe "Gov.uk Team <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(commonParameters).toString

      htmlContent should include("Mae gennych neges newydd oddi wrth CThEF")
      htmlContent should include("Mae gennych neges newydd oddi wrth CThEF.")
      htmlContent should include("I’w gweld, mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      htmlContent should include(
        "Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn."
      )
      htmlContent should include("Pam y cawsoch yr e-bost hwn")
      htmlContent should include("Gwnaethoch ddewis cael hysbysiadau di-bapur.")
      htmlContent should include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch pan fydd gennych neges newydd yn eich cyfrif."
      )
      htmlContent should include("Oddi wrth adran Ddigidol CThEF")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(commonParameters).toString

      txtContent should include("Mae gennych neges newydd oddi wrth CThEF")
      txtContent should include("Mae gennych neges newydd oddi wrth CThEF.")
      txtContent should include("I’w gweld, mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      txtContent should include(
        "Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn."
      )
      txtContent should include("Pam y cawsoch yr e-bost hwn")
      txtContent should include("Gwnaethoch ddewis cael hysbysiadau di-bapur.")
      txtContent should include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch pan fydd gennych neges newydd yn eich cyfrif."
      )
      txtContent should include("Oddi wrth adran Ddigidol CThEF")
    }
  }
}
