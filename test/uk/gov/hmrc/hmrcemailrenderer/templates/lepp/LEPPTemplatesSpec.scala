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

package uk.gov.hmrc.hmrcemailrenderer.templates.lepp

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PensionsAndSavings
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.utils.SpecBase
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority.Standard

class LEPPTemplatesSpec extends SpecBase {
  "LEPP templates" should {

    "have correct details for English templates" in {
      validateTemplateDetails("newMessageAlert_LEPP1", "You’ve got a new message from HMRC")
      validateTemplateDetails("newMessageAlert_LEPP2", "You’ve got a new message from HMRC")
      validateTemplateDetails("newMessageAlert_LEPP3", "You’ve got a new message from HMRC")
      validateTemplateDetails("newMessageAlert_LEPP4", "You’ve got a new message from HMRC")
    }

    "have correct details for Welsh templates" in {
      validateTemplateDetails(
        templateId = "newMessageAlert_LEPP1_cy",
        expectedSubject = "Mae gennych neges newydd oddi wrth CThEF"
      )

      validateTemplateDetails(
        templateId = "newMessageAlert_LEPP2_cy",
        expectedSubject = "Mae gennych neges newydd oddi wrth CThEF"
      )

      validateTemplateDetails(
        templateId = "newMessageAlert_LEPP3_cy",
        expectedSubject = "Mae gennych neges newydd oddi wrth CThEF"
      )

      validateTemplateDetails(
        templateId = "newMessageAlert_LEPP4_cy",
        expectedSubject = "Mae gennych neges newydd oddi wrth CThEF"
      )
    }
  }

  private def validateTemplateDetails(
    templateId: String,
    expectedSubject: String,
    expectedPriority: MessagePriority = Standard
  ) = {
    val template: MessageTemplate = findTemplate(templateId)
    val subject: (Map[String, String]) => String = template.subject.f

    template.fromAddress.apply(Map.empty) mustBe govUkTeamAddress
    template.service must be(PensionsAndSavings)
    subject(Map.empty) must be(expectedSubject)

    Option(template.plainTemplate) must not be empty
    Option(template.htmlTemplate) must not be empty

    template.priority.get must be(expectedPriority)
  }

  private def findTemplate(templateId: String): MessageTemplate =
    LEPPTemplates.templates.filter(t => t.templateId == templateId).head
}
