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

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateLoader, TemplateLocator}
import uk.gov.hmrc.play.test.UnitSpec

class VerificationReminderWelshSpec  extends UnitSpec with EitherValues with TemplateLoader with CommonParamsForSpec {
  "verificationReminder_cy" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("verificationLink" -> "/whatever", "verificationLinkSentDate" -> "2019-04-02")

    val template = templateLocator.templateGroups("Self Assessment").find(_.templateId == "verificationReminder_cy").get
    "render correct subject" in {
      template.subject(Map.empty) shouldBe ("Cyfathrebu drwy ddull electronig CThEM: cwblhau’r broses fewngofnodi")
      template.fromAddress(Map.empty) shouldBe "CThEM Digidol <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent should include("Ewch i hafan GOV.UK")
      htmlContent should include("Dilyswch eich cyfeiriad e-bost")
      htmlContent should include("Annwyl Gwsmer")
      htmlContent should include("Rydych wedi dewis i CThEM gyfathrebu â chi drwy ddull electronig.")
      htmlContent should include("Mae dal angen i chi ddilysu’ch cyfeiriad e-bost â CThEM i gwblhau’r broses fewngofnodi.")
      htmlContent should include("Cliciwch ar y cysylltiad isod er mwyn dilysu’ch cyfeiriad e-bost.")
      htmlContent should include("Oddi wrth Adran Ddigidol CThEM")
      htmlContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEM:")
      htmlContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      htmlContent should include("Rhowch wybod i CThEM am yr e-bost amheus - er mwyn gweld sut, ewch i gov.uk a chwilio am ‘gwe-rwydo a sgamiau’")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent should include("Dilyswch eich cyfeiriad e-bost")
      txtContent should include("Annwyl Gwsmer")
      txtContent should include("Rydych wedi dewis i CThEM gyfathrebu â chi drwy ddull electronig.")
      txtContent should include("Mae dal angen i chi ddilysu’ch cyfeiriad e-bost â CThEM i gwblhau’r broses fewngofnodi.")
      txtContent should include("Cliciwch ar y cysylltiad isod er mwyn dilysu’ch cyfeiriad e-bost.")
      txtContent should include("Oddi wrth Adran Ddigidol CThEM")
      txtContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEM:")
      txtContent should include("Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      txtContent should include("Rhowch wybod i CThEM am yr e-bost amheus - er mwyn gweld sut, ewch i gov.uk a chwilio am ‘gwe-rwydo a sgamiau’")
    }

  }
}
