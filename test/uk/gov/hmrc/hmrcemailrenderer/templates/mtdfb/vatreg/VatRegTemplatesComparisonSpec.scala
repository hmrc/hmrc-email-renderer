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

package uk.gov.hmrc.hmrcemailrenderer.templates.mtdfb.vatreg

import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class VatRegTemplatesComparisonSpec extends TemplateComparisonSpec with CommonParamsForSpec {

  val registrationTemplate = "mtdfb_vatreg_registration_received"
  val registrationPostTemplate = "mtdfb_vatreg_registration_received_post"
  val registrationTemplateWelsh = "mtdfb_vatreg_registration_received_cy"
  val registrationPostTemplateWelsh = "mtdfb_vatreg_registration_received_post_cy"

  val testName = "Joe Bloggs"
  val testRef = "VRS 1234 5678 9012"

  val params = commonParameters ++ Map(
    "name" -> testName,
    "ref"  -> testRef
  )

  def templateContent(id: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(id)(VatRegTemplates.templates)

  "The basic registration received template" should {
    "have the same content in Text and HTML formats" in {
      compareContent(registrationTemplate, params)(templateContent)
    }
  }

  "the registration received template for users who are posting attachments" should {
    "have the same content in Text and HTML formats" in {
      compareContent(registrationPostTemplate, params)(templateContent)
    }
  }

}
