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

import org.mockito.ArgumentCaptor
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.scalatest.concurrent.Eventually
import org.scalatest.mockito.MockitoSugar
import uk.gov.hmrc.hmrcemailrenderer.connectors.PreferencesConnector
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate, MissingTemplateId, TemplateRenderFailure }
import uk.gov.hmrc.hmrcemailrenderer.model.Language
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.audit.http.connector.{ AuditConnector, AuditResult }
import uk.gov.hmrc.play.audit.model.DataEvent
import uk.gov.hmrc.play.audit.model.EventTypes.Succeeded
import uk.gov.hmrc.play.test.UnitSpec

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ ExecutionContext, Future }

class TemplateRendererSpec extends UnitSpec with MockitoSugar {

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

  "LanguageTemplateId" should {

    "return the same template if the template doesn't exist in WelshTemplatesByLangPreference object and email preference is English" in new TestCase {
      val dataEventArgumentCaptor = ArgumentCaptor.forClass(classOf[DataEvent])

      when(templateRenderer.auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
      when(templateRenderer.preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier]))
        .thenReturn(Future.successful(Language.English))

      await(templateRenderer.languageTemplateId(templateId, Some("test@test.com"))) shouldBe templateId

      verify(templateRenderer.auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> templateId,
        "selectedTemplateId" -> templateId,
        "language"           -> "English",
        "engTemplateId"      -> "welshTemplateId"
      )
    }

    "return welsh template if template is in WelshTemplatesByLangPreference and language preferences set to welsh" in new TestCase {
      val dataEventArgumentCaptor = ArgumentCaptor.forClass(classOf[DataEvent])

      when(templateRenderer.auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(templateRenderer.preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier]))
        .thenReturn(Future.successful(Language.Welsh))

      await(templateRenderer.languageTemplateId(engTemplateId, Some("test@test.com"))) shouldBe welshTemplateId

      verify(templateRenderer.auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Language preference found",
        "originalTemplateId" -> engTemplateId,
        "selectedTemplateId" -> welshTemplateId,
        "language"           -> "Welsh",
        "engTemplateId"      -> "welshTemplateId"
      )
    }

    "return english template if template is in WelshTemplatesByLangPreference and language preferences set to english" in new TestCase {
      val dataEventArgumentCaptor = ArgumentCaptor.forClass(classOf[DataEvent])

      when(templateRenderer.auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(templateRenderer.preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier]))
        .thenReturn(Future.successful(Language.English))

      await(templateRenderer.languageTemplateId(engTemplateId, Some("test@test.com"))) shouldBe engTemplateId

      verify(templateRenderer.auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Language preference found",
        "originalTemplateId" -> engTemplateId,
        "selectedTemplateId" -> engTemplateId,
        "language"           -> "English",
        "engTemplateId"      -> "welshTemplateId"
      )
    }

    "return same template if the template doesn't exist in WelshTemplatesByLangPreference object and language preference is Welsh" in new TestCase {
      val dataEventArgumentCaptor = ArgumentCaptor.forClass(classOf[DataEvent])

      when(templateRenderer.auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(templateRenderer.preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier]))
        .thenReturn(Future.successful(Language.Welsh))

      await(templateRenderer.languageTemplateId(templateId, Some("test@test.com"))) shouldBe templateId

      verify(templateRenderer.auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> templateId,
        "selectedTemplateId" -> templateId,
        "language"           -> "English",
        "engTemplateId"      -> "welshTemplateId"
      )
    }

    "return same template if the template doesn't exist in WelshTemplatesByLangPreference object and no email is provided" in new TestCase {
      val dataEventArgumentCaptor = ArgumentCaptor.forClass(classOf[DataEvent])

      when(templateRenderer.auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))

      await(templateRenderer.languageTemplateId(templateId, None)) shouldBe templateId

      verify(templateRenderer.auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "N/A",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> templateId,
        "selectedTemplateId" -> templateId,
        "language"           -> "English",
        "engTemplateId"      -> "welshTemplateId"
      )
    }

    "return same template if the template exist in WelshTemplatesByLangPreference object and no email is provided" in new TestCase {
      val dataEventArgumentCaptor = ArgumentCaptor.forClass(classOf[DataEvent])

      when(templateRenderer.auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))

      await(templateRenderer.languageTemplateId(engTemplateId, None)) shouldBe engTemplateId

      verify(templateRenderer.auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "N/A",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> engTemplateId,
        "selectedTemplateId" -> engTemplateId,
        "language"           -> "English",
        "engTemplateId"      -> "welshTemplateId"
      )
    }
  }

  class TestCase {

    val locatorMock = mock[TemplateLocator]
    val templateId = "a-template-id"
    val engTemplateId = "engTemplateId"
    val welshTemplateId = "welshTemplateId"
    val preferences = mock[PreferencesConnector]

    val templateRenderer = new TemplateRenderer {
      override def locator: TemplateLocator = locatorMock

      override val templatesByLangPreference = Map(engTemplateId -> welshTemplateId)

      override def commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")

      override val preferencesConnector = mock[PreferencesConnector]

      override val auditConnector = mock[AuditConnector]
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
        "Dev.services.preferences.host"     -> "localhost",
        "Dev.services.preferences.port"     -> "1111",
        "Dev.services.preferences.protocol" -> "http"
      )
    }
  }
}
