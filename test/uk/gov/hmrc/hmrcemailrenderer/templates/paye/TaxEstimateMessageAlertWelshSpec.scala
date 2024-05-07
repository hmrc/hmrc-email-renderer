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

package uk.gov.hmrc.hmrcemailrenderer.templates.paye

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator, TemplateUtils }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class TaxEstimateMessageAlertWelshSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "tax_estimate_message_alert_cy" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("fullName" -> "Matthew Groom")
    val template = templateLocator.templateGroups("PAYE").find(_.templateId == "tax_estimate_message_alert_cy").get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Gwirio newid i’ch cod TWE ar-lein"
      template.fromAddress(Map.empty) shouldBe "CThEF – Gwasanaeth Gwirio eich Treth Incwm <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Mae’ch cod treth wedi newid")
      htmlContent should include("Annwyl Matthew Groom")
      htmlContent should include(
        "Mae’ch cofnodion Treth Incwm TWE wedi newid yn ddiweddar, sy’n golygu y bydd swm y dreth rydych yn ei thalu yn newid."
      )
      htmlContent should include(
        "Oherwydd rhesymau diogelwch, nid ydym yn rhoi’r manylion llawn yma ond gallai fod oherwydd y canlynol:"
      )
      if (TemplateUtils.isP2TemplateAnnual) {
        htmlContent should include("rydym bellach wedi cyfrifo’ch cod treth ar gyfer y flwyddyn dreth nesaf")
      } else {
        htmlContent should not include "rydym bellach wedi cyfrifo’ch cod treth ar gyfer y flwyddyn dreth nesaf"
      }
      htmlContent should include("newidiodd eich swydd")
      htmlContent should include("newidiodd eich cyflog")
      htmlContent should include("newidiodd eich buddiannau cwmni, megis car cwmni")
      htmlContent should include("newidiodd eich pensiwn")
      htmlContent should include("Sut i wirio’ch cofnodion i wneud yn siŵr eich bod yn talu’r swm cywir o dreth")
      htmlContent should include(
        "Chwiliwch am ‘personal tax account’ ar GOV.UK, mewngofnodwch ac ewch i’r adran ‘Talu Wrth Ennill (TWE)’."
      )
      htmlContent should include(
        "Os ydych yn mewngofnodi gan ddefnyddio cyfrif treth busnes, mae’n bosibl y gallwch ei ddefnyddio i gael mynediad at eich cyfrif treth personol."
      )
      htmlContent should include("Os nad oes cyfrif treth personol gennych")
      htmlContent should include("Mae angen i chi greu un cyn y gallwch weld y newid i’ch cod treth.")
      htmlContent should include("Chwiliwch am ‘Personal tax account: sign in or set up’ ar GOV.UK.")
      htmlContent should include("Pam y cawsoch yr e-bost hwn")
      htmlContent should include(
        "Rydych wedi dewis cael diweddariadau drwy e-bost yn hytrach na chael llythyrau drwy’r post."
      )
      htmlContent should include("Am resymau diogelwch, nid ydym wedi cynnwys unrhyw gysylltiadau yn yr e-bost hwn.")
      htmlContent should include("Oddi wrth CThEF: Gwirio’ch Treth Incwm")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("Mae’ch cod treth wedi newid")
      txtContent should include("Annwyl Matthew Groom")
      txtContent should include(
        "Mae’ch cofnodion Treth Incwm TWE wedi newid yn ddiweddar, sy’n golygu y bydd swm y dreth rydych yn ei thalu yn newid."
      )
      txtContent should include(
        "Oherwydd rhesymau diogelwch, nid ydym yn rhoi’r manylion llawn yma ond gallai fod oherwydd y canlynol:"
      )
      if (TemplateUtils.isP2TemplateAnnual) {
        txtContent should include("rydym bellach wedi cyfrifo’ch cod treth ar gyfer y flwyddyn dreth nesaf")
      } else {
        txtContent should not include "rydym bellach wedi cyfrifo’ch cod treth ar gyfer y flwyddyn dreth nesaf"
      }
      txtContent should include("newidiodd eich swydd")
      txtContent should include("newidiodd eich cyflog")
      txtContent should include("newidiodd eich buddiannau cwmni, megis car cwmni")
      txtContent should include("newidiodd eich pensiwn")
      txtContent should include("Sut i wirio’ch cofnodion i wneud yn siŵr eich bod yn talu’r swm cywir o dreth")
      txtContent should include(
        "Chwiliwch am ‘personal tax account’ ar GOV.UK, mewngofnodwch ac ewch i’r adran ‘Talu Wrth Ennill (TWE)’."
      )
      txtContent should include(
        "Os ydych yn mewngofnodi gan ddefnyddio cyfrif treth busnes, mae’n bosibl y gallwch ei ddefnyddio i gael mynediad at eich cyfrif treth personol."
      )
      txtContent should include("Os nad oes cyfrif treth personol gennych")
      txtContent should include("Mae angen i chi greu un cyn y gallwch weld y newid i’ch cod treth.")
      txtContent should include("Chwiliwch am ‘Personal tax account: sign in or set up’ ar GOV.UK.")
      txtContent should include("Pam y cawsoch yr e-bost hwn")
      txtContent should include(
        "Rydych wedi dewis cael diweddariadau drwy e-bost yn hytrach na chael llythyrau drwy’r post."
      )
      txtContent should include("Am resymau diogelwch, nid ydym wedi cynnwys unrhyw gysylltiadau yn yr e-bost hwn.")
      txtContent should include("Oddi wrth CThEF: Gwirio’ch Treth Incwm")
    }
  }

}
