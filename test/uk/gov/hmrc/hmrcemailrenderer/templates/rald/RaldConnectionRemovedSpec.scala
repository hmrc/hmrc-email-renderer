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

package uk.gov.hmrc.hmrcemailrenderer.templates.rald

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.OptionValues
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.rald.RaldTemplates.{ raldGroup, rald_connection_removed }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

import scala.annotation.nowarn

/**
  * @author Yuriy Tumakha
  */
class RaldConnectionRemovedSpec
    extends AnyWordSpecLike with should.Matchers with OptionValues with CommonParamsForSpec {

  private val params = commonParameters ++ TemplateParams.exampleParams(rald_connection_removed)
  private val template = TemplateLocator
    .templateGroups(raldGroup)
    .find(_.templateId == rald_connection_removed)
    .value

  @nowarn("msg=discarded non-Unit value")
  private def verifyContent(content: String): Unit = {
    content should include("We have received your request")
    content should include("Dear David Jones")
    content should include(
      "Thank you for contacting us. This email is confirmation that you have asked us to remove your connection to a property.")
    content should include(
      "We will remove your details from our records. You should not receive any further letters from us about this property.")
    content should include("From Valuation Office Agency")
    content should include("Report the suspicious email to HMRC")
  }

  rald_connection_removed should {
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "Valuation Office Agency: You have removed your connection to a property"
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
