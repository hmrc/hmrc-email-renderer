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

package uk.gov.hmrc.hmrcemailrenderer.templates.AtsTemplates

import org.scalatest.EitherValues
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

import java.time.LocalDate

class AtsAnnualTaxReturnWelshSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "annual_tax_summaries_message_alert_cy" should {

    val templateLocator = new TemplateLocator {}
    val template =
      templateLocator.templateGroups("ATS").find(_.templateId == "annual_tax_summaries_message_alert_cy").get
    val params = commonParameters ++ TemplateParams.newMessageAlert_Names

    "render correct subject" in {
      val taxYearFrom = LocalDate.now().getYear - 2
      val taxYearTo = LocalDate.now().getYear - 1
      template.subject(
        Map.empty
      ) shouldBe s"Mae’ch Crynodeb Treth Blynyddol ar gyfer $taxYearFrom i $taxYearTo bellach yn barod"
      template.fromAddress(Map.empty) shouldBe "CThEF – Eich Crynodeb Treth Blynyddol <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Ewch i hafan GOV.UK")
      htmlContent should include("Mae’ch Crynodeb Treth Blynyddol yn barod")
      htmlContent should include("Annwyl Mr Johnston")
      htmlContent should include("Diolch am lenwi’ch Ffurflen Dreth Hunanasesiad.")
      htmlContent should include(
        "Erbyn hyn, gallwch gael at eich Crynodeb Treth Blynyddol ar-lein. Mae’n dangos sut y gwnaeth y llywodraeth wario’ch Treth Incwm a’ch cyfraniadau Yswiriant Gwladol."
      )
      htmlContent should include("Sut i fwrw golwg dros eich Crynodeb Treth Blynyddol")
      htmlContent should include(
        "Mewngofnodwch i wasanaethau ar-lein CThEF gan ddefnyddio’r Dynodydd Defnyddiwr (ID) a’r cyfrinair yr ydych yn ei ddefnyddio ar gyfer Hunanasesiad ar-lein. Ar ôl mewngofnodi, dewiswch ‘Bwrw golwg dros eich Crynodeb Treth Blynyddol’."
      )
      htmlContent should include(
        "Ar gyfer y rhai sydd â Chyfrif Treth Busnes, dewiswch ‘Hunanasesiad’ ac yna ‘rhagor o fanylion am eich Ffurflenni Treth a’ch taliadau Hunanasesiad’, ac yna dewiswch ‘gweld sut y caiff eich treth ei gwario’."
      )
      htmlContent should include(
        "Mae crynodebau treth er gwybodaeth yn unig, felly nid oes angen cymryd unrhyw gamau pellach."
      )
      htmlContent should include("Cyfarwyddwr Cyffredinol Gwasanaethau i Gwsmeriaid CThEF")
      htmlContent should include("I reoli’ch hysbysiadau di-bapur - mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      htmlContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      htmlContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      htmlContent should include(
        "Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’"
      )
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("Mae’ch Crynodeb Treth Blynyddol yn barod")
      txtContent should include("Annwyl Mr Johnston")
      txtContent should include("Diolch am lenwi’ch Ffurflen Dreth Hunanasesiad.")
      txtContent should include(
        "Erbyn hyn, gallwch gael at eich Crynodeb Treth Blynyddol ar-lein. Mae’n dangos sut y gwnaeth y llywodraeth wario’ch Treth Incwm a’ch cyfraniadau Yswiriant Gwladol."
      )
      txtContent should include("Sut i fwrw golwg dros eich Crynodeb Treth Blynyddol")
      txtContent should include(
        "Mewngofnodwch i wasanaethau ar-lein CThEF gan ddefnyddio’r Dynodydd Defnyddiwr (ID) a’r cyfrinair yr ydych yn ei ddefnyddio ar gyfer Hunanasesiad ar-lein. Ar ôl mewngofnodi, dewiswch ‘Bwrw golwg dros eich Crynodeb Treth Blynyddol’."
      )
      txtContent should include(
        "Ar gyfer y rhai sydd â Chyfrif Treth Busnes, dewiswch ‘Hunanasesiad’ ac yna ‘rhagor o fanylion am eich Ffurflenni Treth a’ch taliadau Hunanasesiad’, ac yna dewiswch ‘gweld sut y caiff eich treth ei gwario’."
      )
      txtContent should include(
        "Mae crynodebau treth er gwybodaeth yn unig, felly nid oes angen cymryd unrhyw gamau pellach."
      )
      txtContent should include("Cyfarwyddwr Cyffredinol Gwasanaethau i Gwsmeriaid CThEF")

      // TODO This text is commented becuase "To manage your paperless notifications - sign in to your HMRC online account." is missing in english version just on txt and not on HTML version
      // not sure which one is right. referer to DC-2251 for updates

      //  txtContent should include("I reoli’ch hysbysiadau di-bapur - mewngofnodwch i’ch cyfrif CThEF ar-lein.")
      txtContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      txtContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      txtContent should include(
        "Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’"
      )
    }
  }

}
