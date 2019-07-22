/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.customsFinancials

import org.scalatestplus.play.OneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateComparisonSpec, customsfinancials}

class CustomsFinancialsSpec extends TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  private def customsFinancialsTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(customsfinancials.CustomsFinancialsTemplates.templates)

  "Templates for which the text and html content are identical" should {

    "include Supplementary statement content" in {
      val params = commonParameters + (
        "DefermentStatementType" -> "Supplementary",
        "date" -> "15 June 2018"
      )
      compareContent("customs_financials_new_statement_notification", params)(customsFinancialsTemplate)
    }

    "include Excise statement content" in {
      val params = commonParameters + (
        "DefermentStatementType" -> "Excise",
        "date" -> "15 June 2018"
      )
      compareContent("customs_financials_new_statement_notification", params)(customsFinancialsTemplate)
    }

    "include 4th week statement content" in {
      val params = commonParameters + (
        "DefermentStatementType" -> "Weekly",
        "date" -> "15 June 2018"
      )
      compareContent("customs_financials_new_statement_notification", params)(customsFinancialsTemplate)
    }
  }
}
