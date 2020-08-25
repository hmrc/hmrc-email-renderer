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

package uk.gov.hmrc.hmrcemailrenderer.templates.eotho

import org.scalatest.EitherValues
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import uk.gov.hmrc.play.test.UnitSpec

class DiscountedDiningPaymentSentCySpec
    extends UnitSpec with EitherValues with TemplateLoader with CommonParamsForSpec {

  "discounted_dining_payment_sent_cy" should {
    val templateLocator = new TemplateLocator {}
    val template = templateLocator.templateGroups("EOTHO").find(_.templateId == "discounted_dining_payment_sent_cy").get
    val params = commonParameters ++ TemplateParams.newMessageAlert_Names ++ Map("claimRefNo" -> "1234")

    "render correct subject and fromAddress" in {
      template.subject(Map.empty) shouldBe ("Mae CThEM wedi anfon taliad ar gyfer y Cynllun Bwyta Allan i Helpu Allan")
      template.fromAddress(Map.empty) shouldBe "Cynllun Bwyta Allan i Helpu Allan <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString
      htmlContent should include(
        "Erbyn hyn rydym wedi gwirio’ch hawliad 1234, ac wedi anfon taliad i’r manylion cyfrif a roddwyd pan gofrestrwyd y busnes.")
      htmlContent should include("Bydd y taliad yn cyrraedd y cyfrif o fewn 3 i 5 diwrnod gwaith.")
      htmlContent should include("Cynllun Bwyta Allan i Helpu Allan")
    }

    "render correct text content" in {
      val htmlContent = template.plainTemplate(params).toString
      htmlContent should include(
        "Erbyn hyn rydym wedi gwirio’ch hawliad 1234, ac wedi anfon taliad i’r manylion cyfrif a roddwyd pan gofrestrwyd y busnes.")
      htmlContent should include("Bydd y taliad yn cyrraedd y cyfrif o fewn 3 i 5 diwrnod gwaith.")
      htmlContent should include("Cynllun Bwyta Allan i Helpu Allan")
    }
  }
}
