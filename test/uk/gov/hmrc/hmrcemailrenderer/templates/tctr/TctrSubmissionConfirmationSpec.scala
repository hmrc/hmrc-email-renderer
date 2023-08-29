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

package uk.gov.hmrc.hmrcemailrenderer.templates.tctr

import org.scalatest.OptionValues
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpecLike
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.tctr.TctrTemplates.{ tctrGroup, tctr_submission_confirmation }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

import scala.annotation.nowarn

/**
  * @author Yuriy Tumakha
  */
class TctrSubmissionConfirmationSpec
    extends AnyWordSpecLike with should.Matchers with OptionValues with CommonParamsForSpec {

  private val params = commonParameters ++ TemplateParams.exampleParams(tctr_submission_confirmation)
  private val template = TemplateLocator
    .templateGroups(tctrGroup)
    .find(_.templateId == tctr_submission_confirmation)
    .value

  @nowarn("msg=discarded non-Unit value")
  private def verifyContent(content: String): Unit = {
    content should include("We have received your business trade and cost information")
    content should include("Dear John Doe")
    content should include(
      "This email is confirmation that we have received your business trade and cost information form.")
    content should include("We may need to contact you to check some of the details you provided.")
    content should include("From Valuation Office Agency - Tenure Cost and Trade Records service")
    content should include("Report the suspicious email to HMRC")
  }

  tctr_submission_confirmation should {
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Valuation Office Agency: We have received your business trade and cost information"
    }

    "render correct from address" in {
      template.fromAddress(Map.empty) shouldBe "Valuation Office Agency <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("HM Revenue &amp; Customs")
      verifyContent(htmlContent)
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      verifyContent(txtContent)
    }
  }

}
