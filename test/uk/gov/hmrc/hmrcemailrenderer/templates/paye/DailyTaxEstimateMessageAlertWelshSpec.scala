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

package uk.gov.hmrc.hmrcemailrenderer.templates.paye

import org.scalatest.{ EitherValues, OptionValues }
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }

class DailyTaxEstimateMessageAlertWelshSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "daily_tax_estimate_message_alert_cy" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("fullName" -> "Leslie Carter")
    val template =
      templateLocator.templateGroups("PAYE").find(_.templateId == "daily_tax_estimate_message_alert_cy").get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Gwiriwch eich diweddariad treth ar-lein"
      template.fromAddress(Map.empty) shouldBe "CThEF – Gwasanaeth Gwirio eich Treth Incwm <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Mae eich cod treth yn newid")
      htmlContent should include("Annwyl Leslie Carter")
      htmlContent should include(
        "Mae eich cofnodion Treth Incwm TWE wedi newid yn ddiweddar, sy’n golygu y gall swm y dreth rydych yn ei thalu newid."
      )
      htmlContent should include(
        "Am resymau diogelwch, nid ydym yn rhoi’r manylion llawn yma. Gallai hyn fod oherwydd newidiadau i’ch swydd," +
          " eich cyflog, buddion cwmni (fel car cwmni) neu eich pensiwn."
      )

      htmlContent should include("Sut i wirio eich bod yn talu’r swm cywir o dreth")
      htmlContent should include(
        "Mewngofnodwch i’ch cyfrif ar-lein CThEF ar GOV.UK neu defnyddiwch ap CThEF. Ewch i’r adran ‘Talu Wrth Ennill (TWE)’."
      )
      htmlContent should include(
        "Os ydych yn mewngofnodi gan ddefnyddio cyfrif treth busnes, mae’n bosibl y gallwch ei ddefnyddio i gael mynediad at eich cyfrif treth personol."
      )

      htmlContent should include("Pam rydych yn cael yr e-bost hwn")
      htmlContent should include(
        "Rydych yn cael yr e-bost hwn oherwydd eich bod wedi dewis cael diweddariadau drwy e-bost yn hytrach na llythyrau drwy’r post."
      )
      htmlContent should include("Am resymau diogelwch, nid ydym wedi cynnwys unrhyw gysylltiadau yn yr e-bost hwn.")
      htmlContent should include("Oddi wrth CThEF: Gwirio’ch Treth Incwm")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("Mae eich cod treth yn newid")
      txtContent should include("Annwyl Leslie Carter")
      txtContent should include(
        "Mae eich cofnodion Treth Incwm TWE wedi newid yn ddiweddar, sy’n golygu y gall swm y dreth rydych yn ei thalu newid."
      )
      txtContent should include(
        "Am resymau diogelwch, nid ydym yn rhoi’r manylion llawn yma. Gallai hyn fod oherwydd newidiadau i’ch swydd," +
          " eich cyflog, buddion cwmni (fel car cwmni) neu eich pensiwn."
      )

      txtContent should include("Sut i wirio eich bod yn talu’r swm cywir o dreth")
      txtContent should include(
        "Mewngofnodwch i’ch cyfrif ar-lein CThEF ar GOV.UK neu defnyddiwch ap CThEF. Ewch i’r adran ‘Talu Wrth Ennill (TWE)’."
      )
      txtContent should include(
        "Os ydych yn mewngofnodi gan ddefnyddio cyfrif treth busnes, mae’n bosibl y gallwch ei ddefnyddio i gael mynediad at eich cyfrif treth personol."
      )

      txtContent should include("Pam rydych yn cael yr e-bost hwn")
      txtContent should include(
        "Rydych yn cael yr e-bost hwn oherwydd eich bod wedi dewis cael diweddariadau drwy e-bost yn hytrach na llythyrau drwy’r post."
      )
      txtContent should include("Am resymau diogelwch, nid ydym wedi cynnwys unrhyw gysylltiadau yn yr e-bost hwn.")
      txtContent should include("Oddi wrth CThEF: Gwirio’ch Treth Incwm")
    }
  }
}
