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
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class VerificationReminderWelshSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {
  "verificationReminder_cy" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map(
      "verificationLink"         -> "/whatever",
      "daysAgo"                  -> "3",
      "verificationLinkSentDate" -> "2019-04-02"
    )

    val template = templateLocator.templateGroups("Self Assessment").find(_.templateId == "verificationReminder_cy").get
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Cyfathrebu drwy ddull electronig CThEF: cwblhau’r broses fewngofnodi"
      template.fromAddress(Map.empty) shouldBe "CThEF Digidol <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent should include("Dilyswch eich cyfeiriad e-bost i gael llythyrau treth ar-lein")
      htmlContent should include("Annwyl Gwsmer")
      htmlContent should include("Ddeuddydd yn ôl rhoesoch wybod i ni eich bod am gael llythyrau treth ar-lein.")
      htmlContent should include(
        "Mae dal angen i chi glicio’r cysylltiad hwn cyn y gallwn ddechrau anfon llythyrau a gwybodaeth atoch ar-lein:"
      )
      htmlContent should include(
        "Mae angen i chi wneud hyn cyn pen 5 diwrnod, neu byddwn yn parhau i anfon llythyrau treth atoch drwy’r post."
      )
      htmlContent should include("Pam ein bod wedi anfon e-bost atoch")
      htmlContent should include(
        "Rydym yn gwneud i chi ddilysu’ch cyfeiriad e-bost er mwyn helpu i gadw’ch manylion yn ddiogel."
      )
      htmlContent should include("Oddi wrth adran Ddigidol CThEF")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent should include("Dilyswch eich cyfeiriad e-bost i gael llythyrau treth ar-lein")
      txtContent should include("Annwyl Gwsmer")
      txtContent should include("Ddeuddydd yn ôl rhoesoch wybod i ni eich bod am gael llythyrau treth ar-lein.")
      txtContent should include(
        "Mae dal angen i chi glicio’r cysylltiad hwn cyn y gallwn ddechrau anfon llythyrau a gwybodaeth atoch ar-lein:"
      )
      txtContent should include(
        "Mae angen i chi wneud hyn cyn pen 5 diwrnod, neu byddwn yn parhau i anfon llythyrau treth atoch drwy’r post."
      )
      txtContent should include("Pam ein bod wedi anfon e-bost atoch")
      txtContent should include(
        "Rydym yn gwneud i chi ddilysu’ch cyfeiriad e-bost er mwyn helpu i gadw’ch manylion yn ddiogel."
      )
      txtContent should include("Oddi wrth adran Ddigidol CThEF")
    }

  }
}
