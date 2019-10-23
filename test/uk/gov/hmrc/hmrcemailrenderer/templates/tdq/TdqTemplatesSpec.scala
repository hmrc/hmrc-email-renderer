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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq

import org.scalatestplus.play.OneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateComparisonSpec}

class TdqTemplatesSpec extends TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  "tdq_compliance_all_required_headers_missing template" should {

    "be the same for text and html content" in {

      val params = commonParameters + (
        "developerName" -> "John Smith",
        "fromDate" -> "22/09/2019",
        "toDate" -> "22/10/2019",
        "applicationName" -> "MTD VAT Test Application",
        "applicationId" -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
      )

      compareContent("tdq_compliance_all_required_headers_missing", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_all_required_headers_missing")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }
  }

  private def tdqTemplate(templateId: String) = messageTemplateF(templateId)(TdqTemplates.templates)

  private def findTemplate(templateId: String) = TdqTemplates.templates.filter(t => t.templateId == templateId).head
}
