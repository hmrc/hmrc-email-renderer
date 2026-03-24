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

package uk.gov.hmrc.hmrcemailrenderer.templates.bars

import org.scalatest.OptionValues
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpecLike
import preview.TemplateParams
import uk.gov.hmrc.hmrcemailrenderer.templates.bars.BarsTemplates.{ barsGroup, bars_alert }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLocator }

/** @author
  *   Yuriy Tumakha
  */
class BarsAlertSpec extends AnyWordSpecLike with should.Matchers with OptionValues with CommonParamsForSpec:

  private val params = commonParameters ++ TemplateParams.exampleParams(bars_alert)
  private val template = TemplateLocator
    .templateGroups(barsGroup)
    .find(_.templateId == bars_alert)
    .value

  bars_alert should {
    "render correct subject" in {
      template.subject(Map.empty) shouldBe "No BA CODE"
      template.subject(params) shouldBe "BA : ba5090"
    }

    "render correct from address" in {
      template.fromAddress(Map.empty) shouldBe "Business Rates <noreply@tax.service.gov.uk>"
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Valuation Office - Business Rates")
      htmlContent should include("BA Code")
      htmlContent should include("BA : ba5090")
      htmlContent should include("File name : Barnet_CT.xml")
      htmlContent should include("Date Submitted : 2016-08-09T14:02:09.747+01:00")
      htmlContent should include("Errors")
      htmlContent should include("Brap Brap")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString
      txtContent should include("Valuation Office - Business Rates")
      txtContent should include("BA : ba5090")
      txtContent should include("File name : Barnet_CT.xml")
      txtContent should include("Date Submitted : 2016-08-09T14:02:09.747+01:00")
      txtContent should include("Brap Brap")
    }
  }
