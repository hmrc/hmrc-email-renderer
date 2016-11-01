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

import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate, MissingTemplateId, TemplateRenderFailure}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.play.test.UnitSpec

class TemplateRendererSpec extends UnitSpec with MockitoSugar {

  "The template renderer" should {

    "render an existing template using the common parameters" in new TestCase {
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
      templateRenderer.render(templateId, Map("KEY" -> "VALUE")) shouldBe Right(validRenderedResult)
    }

    "return None if the template is not found" in new TestCase {
      when(locatorMock.findTemplate("unknown")).thenReturn(None)
      templateRenderer.render("unknown", Map.empty) shouldBe Left(MissingTemplateId("unknown"))
    }

    "return error message in Left if it can't render the template" in new TestCase {
      val errorMessage = TemplateRenderFailure("key not found: KEY")
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))

      templateRenderer.render(templateId, Map.empty) shouldBe Left(errorMessage)
    }
  }

  class TestCase {
    val locatorMock = mock[TemplateLocator]
    val templateId = "a-template-id"

    val templateRenderer = new TemplateRenderer {
      override def locator: TemplateLocator = locatorMock

      override def commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
    }

    val validTemplate = MessageTemplate.create(
      templateId = templateId,
      fromAddress = "from@test",
      service = SelfAssessment,
      subject = "a subject",
      plainTemplate = txt.templateSample.f,
      htmlTemplate = html.templateSample.f,
      MessagePriority.Urgent
    )

    val validRenderedResult = RenderResult(
      fromAddress = "from@test",
      service = "sa",
      subject = "a subject",
      plain = "Test template with parameter value: VALUE using common parameters: commonValue",
      html = "<p>Test template with parameter value: VALUE using common parameters: commonValue</p>",
      priority = MessagePriority.Urgent
    )
  }

}
