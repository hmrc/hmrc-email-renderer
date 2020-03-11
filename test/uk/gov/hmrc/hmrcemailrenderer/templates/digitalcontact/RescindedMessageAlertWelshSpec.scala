/*
 * Copyright 2020 HM Revenue & Customs
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

import com.sun.xml.internal.bind.v2.TODO
import org.scalatest.EitherValues
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateLoader, TemplateLocator}
import uk.gov.hmrc.play.test.UnitSpec

class RescindedMessageAlertWelshSpec extends UnitSpec with EitherValues with TemplateLoader with CommonParamsForSpec {

  "rescindedMessageAlert_cy" should {
    val templateLocator = new TemplateLocator {}
    val template = templateLocator.templateGroups("Self Assessment").find(_.templateId == "rescindedMessageAlert_cy").get
    val params = commonParameters ++ TemplateParams.newMessageAlert_Names

    "render correct subject" in {
      template.subject(Map.empty) shouldBe ("Gwnaeth CThEM alw neges ynghylch Hunanasesiad yn ei hôl")
      template.fromAddress(Map.empty) shouldBe ("CThEM – (Tîm) Cyswllt Digidol <noreply@tax.service.gov.uk>")
    }


    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

       htmlContent should include("Ewch i hafan GOV.UK")
       htmlContent should include("Diddymiad: Cyflwyno’ch Ffurflen Dreth Hunanasesiad")
       htmlContent should include("Anfonodd CThEM e-bost hysbysu a neges ar-lein atoch ar")
       htmlContent should include("Annwyl Mr Johnston")
       htmlContent should include("Anfonom hon atoch yn rhy gynnar mewn camgymeriad, ac mae’n flin gennym am y camgymeriad.")
       htmlContent should include("Rydym bellach wedi dileu’r neges anghywir o’ch cyfrif CThEM.")
       htmlContent should include("Byddwch yn cael e-bost hysbysu a neges newydd yn fuan ar ôl i’r flwyddyn dreth newydd ddechrau ar 6 Ebrill.")
       htmlContent should include("Oddi wrth adran Ddigidol CThEM")
       htmlContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEM:")
       htmlContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
       htmlContent should include("Rhowch wybod i CThEM am yr e-bost amheus - er mwyn gweld sut, ewch i gov.uk a chwilio am ‘gwe-rwydo a sgamiau’")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent should include("Diddymiad: Cyflwyno’ch Ffurflen Dreth Hunanasesiad")
      txtContent should include("Anfonodd CThEM e-bost hysbysu a neges ar-lein atoch ar")
      txtContent should include("Annwyl Mr Johnston")
      txtContent should include("Anfonom hon atoch yn rhy gynnar mewn camgymeriad, ac mae’n flin gennym am y camgymeriad.")
      txtContent should include("Rydym bellach wedi dileu’r neges anghywir o’ch cyfrif CThEM.")
      txtContent should include("Byddwch yn cael e-bost hysbysu a neges newydd yn fuan ar ôl i’r flwyddyn dreth newydd ddechrau ar 6 Ebrill.")
      txtContent should include("Oddi wrth adran Ddigidol CThEM")
      txtContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEM:")
      txtContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      txtContent should include("Rhowch wybod i CThEM am yr e-bost amheus - er mwyn gweld sut, ewch i gov.uk a chwilio am ‘gwe-rwydo a sgamiau’")
    }
  }
}
