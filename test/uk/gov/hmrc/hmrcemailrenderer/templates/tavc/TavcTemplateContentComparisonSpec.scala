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

package uk.gov.hmrc.hmrcemailrenderer.templates.tavc

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateComparisonSpec}

class TavcTemplateContentComparisonSpec extends PlaySpec with TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  def tavcTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(TavcTemplates.templates)

  "Tavc templates for which the text and html content are identical" should {
    "include newMessageAlert_TAVC" in {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname" -> "b",
        "recipientName_honours" -> "c"
      ) ++ commonParameters
      compareContent("newMessageAlert_TAVC", params)(tavcTemplate)
    }
  }
}
