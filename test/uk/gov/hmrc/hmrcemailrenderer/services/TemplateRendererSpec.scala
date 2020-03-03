/*
 * Copyright 2020 HM Revenue & Customs
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
import org.scalatest.concurrent.Eventually
import org.scalatest.mock.MockitoSugar
import play.api.Configuration
import uk.gov.hmrc.emailaddress.EmailAddress
import uk.gov.hmrc.hmrcemailrenderer.connectors.PreferencesConnector
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate, MissingTemplateId, TemplateRenderFailure}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.test.UnitSpec

import scala.concurrent.Future

class TemplateRendererSpec extends UnitSpec with MockitoSugar   {

  "The template renderer" should {

    "render an existing template using the common parameters" in new TestCase with Eventually {
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
     await(templateRenderer.render(templateId, Map("KEY" -> "VALUE"))) shouldBe Right(validRenderedResult)
    }

    "return None if the template is not found" in new TestCase {
      when(locatorMock.findTemplate("unknown")).thenReturn(None)
     await(templateRenderer.render("unknown", Map.empty)) shouldBe Left(MissingTemplateId("unknown"))
    }

    "return error message in Left if it can't render the template" in new TestCase {
      val errorMessage = TemplateRenderFailure("key not found: KEY")
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))

      await(templateRenderer.render(templateId, Map.empty)) shouldBe Left(errorMessage)
    }

  }

  "Welsh templates" should {

    "render template normally if the template doesnt exist in WelshTemplatesByLangPreference object" in new TestCase {
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
     await(templateRenderer.render(templateId, Map("KEY" -> "VALUE"))) shouldBe Right(validRenderedResult)
    }

    "render welsh template if template exists in WelshTemplatesByLangPreference" in new TestCase {
      override  val templateId = s"newMessageAlert"
      val welshTemplate = s"${templateId}_cy"

      when(locatorMock.findTemplate(welshTemplate)).thenReturn(Some(MessageTemplate.create(
        templateId = welshTemplate,
        fromAddress = "from@test",
        service = SelfAssessment,
        subject = "welsh subject",
        plainTemplate = txt.templateSample_cym.f,
        htmlTemplate = html.templateSample_cym.f,
        Some(MessagePriority.Urgent)
      )))

      when(templateRenderer.preferencesConnector.isWelsh(EmailAddress("test@test.com"))).thenReturn(Future.successful(true))

      templateRenderer.templatesByLangPreference.contains(templateId) shouldBe true

      await(templateRenderer.render(templateId, Map("KEY" -> "VALUE"), Option(EmailAddress("test@test.com")))) shouldBe
        Right(RenderResult(
          fromAddress = "from@test",
          service = "sa",
          subject = "welsh subject",
          plain = "welsh content",
          html = "<p>welsh content</p>",
          priority = Some(MessagePriority.Urgent)
        ))
    }


    "render english template if template is in WelshTemplatesByLangPreference object and preferences set to English" in new TestCase {
      override  val templateId = s"newMessageAlert"
      val welshTemplate = s"${templateId}_cy"

      when(locatorMock.findTemplate(welshTemplate)).thenReturn(Some(MessageTemplate.create(
        templateId = welshTemplate,
        fromAddress = "from@test",
        service = SelfAssessment,
        subject = "welsh subject",
        plainTemplate = txt.templateSample_cym.f,
        htmlTemplate = html.templateSample_cym.f,
        Some(MessagePriority.Urgent)
      )))

      when(locatorMock.findTemplate(templateId)).thenReturn(Some(MessageTemplate.create(
        templateId = templateId,
        fromAddress = "from@test",
        service = SelfAssessment,
        subject = "english subject",
        plainTemplate = txt.templateSample.f,
        htmlTemplate = html.templateSample.f,
        Some(MessagePriority.Urgent)
      )))

      when(templateRenderer.preferencesConnector.isWelsh(EmailAddress("test@test.com"))).thenReturn(Future.successful(false))

      templateRenderer.templatesByLangPreference.contains(templateId) shouldBe true

      await(templateRenderer.render(templateId, Map("KEY" -> "VALUE"), Option(EmailAddress("test@test.com")))) shouldBe
       Right(RenderResult(
          fromAddress = "from@test",
          service = "sa",
          subject = "english subject",
          plain = "Test template with parameter value: VALUE using common parameters: commonValue",
          html = "<p>Test template with parameter value: VALUE using common parameters: commonValue</p>",
          priority = Some(MessagePriority.Urgent)
        ))
    }

    "render template normally if emailAddress is None" in new TestCase {
      override  val templateId = s"newMessageAlert"
      val welshTemplate = s"${templateId}_cy"
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))

      templateRenderer.templatesByLangPreference.contains(templateId) shouldBe true

      await(templateRenderer.render(templateId, Map("KEY" -> "VALUE"), None)) shouldBe
        Right(RenderResult(
          fromAddress = "from@test",
          service = "sa",
          subject = "a subject",
          plain = "Test template with parameter value: VALUE using common parameters: commonValue",
          html = "<p>Test template with parameter value: VALUE using common parameters: commonValue</p>",
          priority = Some(MessagePriority.Urgent)
        ))
    }
  }

  class TestCase {
    val locatorMock = mock[TemplateLocator]
    val templateId = "a-template-id"

    val preferences = mock[PreferencesConnector]

    val templateRenderer = new TemplateRenderer {
      override def locator: TemplateLocator = locatorMock

      override def commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")

      override val  preferencesConnector =  mock[PreferencesConnector]

      override def runModeConfiguration: Configuration = Configuration.from(LocalConfig.config)

      override val templatesByLangPreference: Map[String, String] = Map("newMessageAlert"-> "newMessageAlert_cy")
    }

    val validTemplate = MessageTemplate.create(
      templateId = templateId,
      fromAddress = "from@test",
      service = SelfAssessment,
      subject = "a subject",
      plainTemplate = txt.templateSample.f,
      htmlTemplate = html.templateSample.f,
      Some(MessagePriority.Urgent)
    )

    val validRenderedResult = RenderResult(
      fromAddress = "from@test",
      service = "sa",
      subject = "a subject",
      plain = "Test template with parameter value: VALUE using common parameters: commonValue",
      html = "<p>Test template with parameter value: VALUE using common parameters: commonValue</p>",
      priority = Some(MessagePriority.Urgent)
    )
    implicit val headerCarrier: HeaderCarrier = new HeaderCarrier()

    object LocalConfig {
      val config = Map(
        "Dev.services.preferences.host" -> "localhost",
        "Dev.services.preferences.port" -> "1111",
        "Dev.services.preferences.protocol" -> "http"
      )
    }
  }
}
