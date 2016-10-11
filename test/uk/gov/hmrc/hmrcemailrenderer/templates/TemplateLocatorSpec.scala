/*
 * Copyright 2016 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.services._
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.play.test.UnitSpec

class TemplateLocatorSpec extends UnitSpec {

  "The template locator" should {

    "loop through all groups and return the first template matching the provided template id" in new TestCase {
      templateLocator.findTemplate("template-templateGroup-1-2").get.templateId shouldBe "template-templateGroup-1-2"
      templateLocator.findTemplate("template-templateGroup-1-2").get.fromAddress shouldBe "from@test"
      templateLocator.findTemplate("template-templateGroup-1-2").get.service shouldBe SelfAssessment
    }

    "return none if the template is not found" in new TestCase {
      templateLocator.findTemplate("template-templateGroup-10-2") shouldBe None
    }
  }

  trait TestCase {
    def messageTemplates(templateName: String): Seq[MessageTemplate] = (1 to 5) map { i =>
      MessageTemplate.create(
        templateId = s"template-$templateName-$i",
        fromAddress = "from@test",
        service = SelfAssessment,
        subject = "a subject",
        plainTemplate = txt.templateSample.f,
        htmlTemplate = html.templateSample.f
      )
    }

    val templateLocator = new TemplateLocator {
      override lazy val all: Seq[MessageTemplate] = (1 to 5) flatMap { i => messageTemplates(s"templateGroup-$i") }
    }
  }

}
