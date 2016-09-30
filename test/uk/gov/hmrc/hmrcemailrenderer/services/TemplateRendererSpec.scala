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

package uk.gov.hmrc.hmrcemailrenderer.services

import org.mockito.Mockito.when
import org.scalatest.mock.MockitoSugar
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.templates.Service.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.play.test.UnitSpec

class TemplateRendererSpec extends UnitSpec with MockitoSugar {

  "The template renderer" should {

    "render an existing template" in new TestCase {
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
      templateRenderer.render(templateId, Map("KEY" -> "VALUE")) shouldBe Some(validRenderedResult)
    }

    "return None if the template is not found" in new TestCase {

      when(locatorMock.findTemplate("unknown")).thenReturn(None)
      templateRenderer.render("unknown", Map.empty) shouldBe None
    }

    "throw an exception if it can't render the template" in new TestCase {
      intercept[MissingTemplateParameterException] {
        when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
        templateRenderer.render(templateId, Map.empty)
      }.getMessage shouldBe "No value for 'KEY'"
    }

    "append the pre configured common parameters" in new TestCase {
      pending
    }
  }

  class TestCase {
    val locatorMock = mock[TemplateLocator]
    val templateRenderer = new TemplateRenderer {

      override def locator: TemplateLocator = locatorMock

      override def commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
    }
    val templateId = "a-template-id"
    val validTemplate = MessageTemplate(
      templateId = templateId,
      fromAddress = "from@test",
      service = SelfAssessment,
      subject = "a subject",
      plainTemplate = txt.templateSample.apply,
      htmlTemplate = html.templateSample.apply
    )

    val validRenderedResult = RenderResult(
      fromAddress = "from@test",
      service = "sa",
      subject = "a subject",
      plain = "Test template with parameter value: VALUE",
      html = "<p>Test template with parameter value: VALUE</p>"
    )
  }

}
