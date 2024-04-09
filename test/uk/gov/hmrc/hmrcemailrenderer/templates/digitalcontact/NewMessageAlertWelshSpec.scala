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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import org.scalatest.EitherValues
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class NewMessageAlertWelshSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "newMessageAlert_cy" should {
    val templateLocator = new TemplateLocator {}
    val template = templateLocator.templateGroups("Self Assessment").find(_.templateId == "newMessageAlert_cy").get
    val params = commonParameters ++ TemplateParams.newMessageAlert_Names

    "render correct subject and fromAddress" in {
      template.subject(Map.empty) shouldBe "Hysbysiadau di-bapur CThEF: neges newydd"
      template.fromAddress(Map.empty) shouldBe "CThEF Digidol <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Ewch i hafan GOV.UK")
      htmlContent should include("Mae gennych neges newydd oddi wrth CThEF</h1>")
      htmlContent should include("Annwyl Mr Johnston")
      htmlContent should include("Mae gennych neges newydd oddi wrth CThEF am Hunanasesiad.")
      htmlContent should include("I’w gweld, mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      htmlContent should include("Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn.")
      htmlContent should include("Pam y cawsoch yr e-bost hwn")
      htmlContent should include("Dewisoch i gael hysbysiadau di-bapur yn hytrach na lythyrau drwy’r post.")
      htmlContent should include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch er mwyn rhoi gwybod i chi fod gennych neges newydd yn eich cyfrif."
      )
      htmlContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      htmlContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      htmlContent should include(
        "Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’"
      )
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("Mae gennych neges newydd oddi wrth CThEF")
      txtContent should include("Annwyl Mr Johnston")
      txtContent should include("Mae gennych neges newydd oddi wrth CThEF am Hunanasesiad.")
      txtContent should include("I’w gweld, mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      txtContent should include("Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad gyda’r e-bost hwn.")
      txtContent should include("Pam y cawsoch yr e-bost hwn")
      txtContent should include("Dewisoch i gael hysbysiadau di-bapur yn hytrach na lythyrau drwy’r post.")
      txtContent should include(
        "Mae hyn yn golygu ein bod yn anfon e-bost atoch er mwyn rhoi gwybod i chi fod gennych neges newydd yn eich cyfrif."
      )
      txtContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      txtContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      txtContent should include(
        "Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’"
      )
    }
  }
}
