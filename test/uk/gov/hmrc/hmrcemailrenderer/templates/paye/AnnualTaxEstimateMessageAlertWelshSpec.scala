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

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class AnnualTaxEstimateMessageAlertWelshSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "annual_tax_estimate_message_alert_cy" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("fullName" -> "Leslie Carter", "taxYear" -> "2027")
    val template =
      templateLocator.templateGroups("PAYE").find(_.templateId == "annual_tax_estimate_message_alert_cy").get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Gwiriwch eich diweddariad treth ar-lein"
      template.fromAddress(Map.empty) shouldBe "CThEF – Gwasanaeth Gwirio eich Treth Incwm <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Bydd eich cod treth yn newid o 6 Ebrill 2027")
      htmlContent should include("Annwyl Leslie Carter")
      htmlContent should include(
        "Rydym wedi cyfrifo eich Treth Incwm ar gyfer y flwyddyn dreth nesaf (6 Ebrill 2027 i 5 Ebrill 2028)." +
          " Gall swm y dreth rydych yn ei thalu newid."
      )
      htmlContent should include("Am resymau diogelwch, nid ydym yn rhoi manylion llawn yma.")

      htmlContent should include("Sut i wirio eich manylion treth newydd")

      htmlContent should include(
        "Mewngofnodwch i’ch cyfrif ar-lein CThEF ar GOV.UK neu defnyddiwch ap CThEF. Ewch i’r adran ‘Talu Wrth Ennill (TWE)’."
      )
      htmlContent should include(
        "Os ydych yn mewngofnodi gan ddefnyddio cyfrif treth busnes," +
          " mae’n bosibl y gallwch ei ddefnyddio i gael mynediad at eich cyfrif treth personol."
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

      txtContent should include("Bydd eich cod treth yn newid o 6 Ebrill 2027")
      txtContent should include("Annwyl Leslie Carter")
      txtContent should include(
        "Rydym wedi cyfrifo eich Treth Incwm ar gyfer y flwyddyn dreth nesaf (6 Ebrill 2027 i 5 Ebrill 2028)." +
          " Gall swm y dreth rydych yn ei thalu newid"
      )
      txtContent should include("Am resymau diogelwch, nid ydym yn rhoi manylion llawn yma.")

      txtContent should include("Sut i wirio eich manylion treth newydd")

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
