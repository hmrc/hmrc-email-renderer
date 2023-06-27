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

package uk.gov.hmrc.hmrcemailrenderer.templates.cf

import org.scalatest.OptionValues
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpecLike
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.cf.ContactFormsTemplates.{ cf_enquiry_confirmation_cy, contactFormsGroup }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

import scala.annotation.nowarn

/**
  * @author Yuriy Tumakha
  */
class ContactFormsEnquiryConfirmationCySpec
    extends AnyWordSpecLike with should.Matchers with OptionValues with CommonParamsForSpec {

  private val params = commonParameters ++ TemplateParams.exampleParams(cf_enquiry_confirmation_cy)
  private val template = TemplateLocator
    .templateGroups(contactFormsGroup)
    .find(_.templateId == cf_enquiry_confirmation_cy)
    .value

  @nowarn("msg=discarded non-Unit value")
  private def verifyContent(content: String): Unit = {
    content should include("Rydym wedi derbyn eich ymholiad")
    content should include("Annwyl David Jones")
    content should include("Diolch am gysylltu â ni. Mae’r e-bost hwn yn gadarnhad ein bod wedi derbyn eich ymholiad.")
    content should include(
      "Rydym yn ymateb i’r mwyafrif o ymholiadau o fewn ychydig ddyddiau. Fodd bynnag, gall ymholiadau cymhleth gymryd hyd at 28 diwrnod.")
    content should include("Oddi wrth Asiantaeth y Swyddfa Brisio")
    content should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEM")
  }

  cf_enquiry_confirmation_cy should {
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Rydych wedi anfon ymholiad at Asiantaeth y Swyddfa Brisio"
    }

    "render correct from address" in {
      template.fromAddress(Map.empty) shouldBe "Asiantaeth y Swyddfa Brisio <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Cyllid a Thollau EM")
      verifyContent(htmlContent)
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      verifyContent(txtContent)
    }
  }

}
