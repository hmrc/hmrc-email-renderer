/*
 * Copyright 2018 HM Revenue & Customs
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

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateComparisonSpec}
import uk.gov.hmrc.hmrcemailrenderer.templates.voac.VoacTemplates

class VoacTemplatesSpec extends PlaySpec with TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  def voacTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(VoacTemplates.templates)

  "Voac templates for which the text and html content are identical" should {
    "include voaConfirmationMessageAlert" in {
      val params = Map(
        "firstName" -> "Alex",
        "lastName" -> "Smith",
        "email" -> "a@a",
        "contactNumber" -> "01234567891",
        "propertyAddress" -> "1A Street, Town, County, AA11AA",
        "enquiryCategoryMsg" -> "Council Tax",
        "subEnquiryCategoryMsg" -> "Other",
        "message" -> "Hello"
      ) ++ commonParameters
      compareContent("voa_confirmation_message_alert", params)(voacTemplate)
    }
  }
}
