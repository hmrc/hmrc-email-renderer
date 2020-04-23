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

package uk.gov.hmrc.hmrcemailrenderer.templates.paye

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import uk.gov.hmrc.play.test.UnitSpec

class TaxEstimateMessageAlertWelshSpec extends UnitSpec with EitherValues with TemplateLoader with CommonParamsForSpec {

  "tax_estimate_message_alert_cy" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("fullName" -> "Matthew Groom")
    val template = templateLocator.templateGroups("PAYE").find(_.templateId == "tax_estimate_message_alert_cy").get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe ("Mae amcangyfrif o’ch Treth Incwm wedi newid")
      template.fromAddress(Map.empty) shouldBe "CThEM – Gwasanaeth Gwirio eich Treth Incwm <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Ewch i hafan GOV.UK")
      htmlContent should include("Annwyl Matthew Groom")
      htmlContent should include("Mae gennych newid i’ch cod treth")
      htmlContent should include(
        "Mae’ch cofnodion Treth Incwm TWE wedi newid yn ddiweddar. Oherwydd rhesymau diogelwch nid ydym yn rhoi’r manylion llawn yma ond gallai fod oherwydd newid i rywbeth fel y canlynol:")
      htmlContent should include("swydd")
      htmlContent should include("eich cyflog")
      htmlContent should include("eich buddiannau cwmni megis car cwmni")
      htmlContent should include("eich pensiwn")
      htmlContent should include("Mae hyn yn golygu bydd swm y Dreth Incwm y byddwch yn ei dalu yn newid.")
      htmlContent should include(
        "Dylech wirio’ch manylion i wneud yn siŵr eu bod yn gywir. Mae hyn fel eich bod yn talu’r swm cywir o Dreth Incwm.")
      htmlContent should include("Gwiriwch eich manylion")
      htmlContent should include("Mewngofnodwch i’ch Cyfrif Treth Personol ac ewch i’r adran ‘Talu Wrth Ennill (TWE)’.")
      htmlContent should include(
        "Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad yn yr e-bost hwn. I gyrraedd eich Cyfrif Treth Personol, chwiliwch am ‘Cyfrif Treth Personol CThEM’.")
      htmlContent should include("Mewngofnodi")
      htmlContent should include(
        "Defnyddiwch eich manylion Dynodydd Defnyddiwr neu Ddilysu i fewngofnodi i’ch Cyfrif Treth Personol.")
      htmlContent should include(
        "Dylech gael mynediad at y rhain gan eich bod eisoes wedi defnyddio’r gwasanaeth i ddewis cael e-byst.")

      //TODO: This content is missing in html version but is there in txt version, we are not sure which one is write(DC-2251)
      // htmlContent should include("Cysylltwch â CThEM os nad oes gennych eich manylion Dynodydd Defnyddiwr neu Ddilysu.")
      htmlContent should include("Pam y cawsoch yr e-bost hwn")
      htmlContent should include(
        "Cawsoch yr e-bost hwn am eich bod wedi dewis cael diweddariadau e-bost yn lle llythyrau drwy’r bost")
      htmlContent should include("Oddi wrth CThEM: Gwirio’ch Treth Incwm")
      htmlContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEM:")
      htmlContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      htmlContent should include(
        "Rhowch wybod i CThEM am yr e-bost amheus - er mwyn gweld sut, ewch i gov.uk a chwilio am ‘gwe-rwydo a sgamiau’")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("Annwyl Matthew Groom")
      txtContent should include("Mae gennych newid i’ch cod treth")
      txtContent should include(
        "Mae’ch cofnodion Treth Incwm TWE wedi newid yn ddiweddar. Oherwydd rhesymau diogelwch nid ydym yn rhoi’r manylion llawn yma ond gallai fod oherwydd newid i rywbeth fel y canlynol:")
      txtContent should include("swydd")
      txtContent should include("eich cyflog")
      txtContent should include("eich buddiannau cwmni megis car cwmni")
      txtContent should include("eich pensiwn")
      txtContent should include("Mae hyn yn golygu bydd swm y Dreth Incwm y byddwch yn ei dalu yn newid.")
      txtContent should include(
        "Dylech wirio’ch manylion i wneud yn siŵr eu bod yn gywir. Mae hyn fel eich bod yn talu’r swm cywir o Dreth Incwm.")
      txtContent should include("Gwiriwch eich manylion")
      txtContent should include("Mewngofnodwch i’ch Cyfrif Treth Personol ac ewch i’r adran ‘Talu Wrth Ennill (TWE)’.")
      txtContent should include(
        "Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad yn yr e-bost hwn. I gyrraedd eich Cyfrif Treth Personol, chwiliwch am ‘Cyfrif Treth Personol CThEM’.")
      txtContent should include("Mewngofnodi")
      txtContent should include(
        "Defnyddiwch eich manylion Dynodydd Defnyddiwr neu Ddilysu i fewngofnodi i’ch Cyfrif Treth Personol.")
      txtContent should include(
        "Dylech gael mynediad at y rhain gan eich bod eisoes wedi defnyddio’r gwasanaeth i ddewis cael e-byst.")
      txtContent should include("Cysylltwch â CThEM os nad oes gennych eich manylion Dynodydd Defnyddiwr neu Ddilysu.")
      txtContent should include("Pam y cawsoch yr e-bost hwn")
      txtContent should include(
        "Cawsoch yr e-bost hwn am eich bod wedi dewis cael diweddariadau e-bost yn lle llythyrau drwy’r bost")
      txtContent should include("Oddi wrth CThEM: Gwirio’ch Treth Incwm")
      txtContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEM:")
      txtContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      txtContent should include(
        "Rhowch wybod i CThEM am yr e-bost amheus - er mwyn gweld sut, ewch i gov.uk a chwilio am ‘gwe-rwydo a sgamiau’")
    }
  }

}
