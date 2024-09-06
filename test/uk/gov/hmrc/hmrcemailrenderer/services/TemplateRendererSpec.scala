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

import org.scalatest.OptionValues
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.{ verify, when }
import org.mockito.ArgumentMatchers.{ any, anyString }
import play.api.Configuration
import uk.gov.hmrc.hmrcemailrenderer.connectors.PreferencesConnector
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate, MissingTemplateId, TemplateRenderFailure }
import uk.gov.hmrc.hmrcemailrenderer.model.Language
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.audit.http.connector.{ AuditConnector, AuditResult }
import uk.gov.hmrc.play.audit.model.DataEvent

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ ExecutionContext, Future }
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar

class TemplateRendererSpec extends AnyWordSpec with Matchers with OptionValues with MockitoSugar with ScalaFutures {
  "The template renderer" should {
    "render an existing template using the common parameters" in new TestCase {
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
      templateRenderer.render(templateId, Map("KEY" -> "VALUE")) shouldBe Right(validRenderedResult(templateId))
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

  "LanguageTemplateId" should {

    "return the same template if the template doesn't exist in WelshTemplatesByLangPreference object and email preference is English" in new TestCase {
      val dataEventArgumentCaptor: ArgumentCaptor[DataEvent] = ArgumentCaptor.forClass(classOf[DataEvent])

      when(auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(locatorMock.findTemplate(templateId)).thenReturn(Some(validTemplate))
      when(preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(Language.English))

      override val templateRenderer =
        new TemplateRenderer(configuration, auditConnector, preferencesConnector) {
          override val locator = locatorMock
          override lazy val templatesByLangPreference: Map[String, String] = Map(engTemplateId -> welshTemplateId)
          override lazy val commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
        }
      templateRenderer.languageTemplateId(templateId, Some("test@test.com")).futureValue shouldBe templateId
      verify(auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])
      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> templateId,
        "selectedTemplateId" -> templateId,
        "language"           -> "English"
      )
    }

    "return welsh template if template is in WelshTemplatesByLangPreference and language preferences set to welsh" in new TestCase {
      val dataEventArgumentCaptor: ArgumentCaptor[DataEvent] = ArgumentCaptor.forClass(classOf[DataEvent])

      when(auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(Language.Welsh))
      override val templateRenderer =
        new TemplateRenderer(configuration, auditConnector, preferencesConnector) {
          override val locator = locatorMock
          override lazy val templatesByLangPreference: Map[String, String] = Map(engTemplateId -> welshTemplateId)
          override lazy val commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
        }

      templateRenderer.languageTemplateId(engTemplateId, Some("test@test.com")).futureValue shouldBe welshTemplateId

      verify(auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Language preference found",
        "originalTemplateId" -> engTemplateId,
        "selectedTemplateId" -> welshTemplateId,
        "language"           -> "Welsh"
      )
    }

    "return english template if template is in WelshTemplatesByLangPreference and language preferences set to english" in new TestCase {
      val dataEventArgumentCaptor: ArgumentCaptor[DataEvent] = ArgumentCaptor.forClass(classOf[DataEvent])

      when(auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(Language.English))

      override val templateRenderer =
        new TemplateRenderer(configuration, auditConnector, preferencesConnector) {
          override val locator = locatorMock
          override lazy val templatesByLangPreference: Map[String, String] = Map(engTemplateId -> welshTemplateId)
          override lazy val commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
        }

      templateRenderer.languageTemplateId(engTemplateId, Some("test@test.com")).futureValue shouldBe engTemplateId

      verify(auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Language preference found",
        "originalTemplateId" -> engTemplateId,
        "selectedTemplateId" -> engTemplateId,
        "language"           -> "English"
      )
    }

    "return same template if the template doesn't exist in WelshTemplatesByLangPreference object and language preference is Welsh" in new TestCase {
      val dataEventArgumentCaptor: ArgumentCaptor[DataEvent] = ArgumentCaptor.forClass(classOf[DataEvent])

      when(auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      when(preferencesConnector.languageByEmail(anyString())(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(Language.Welsh))

      override val templateRenderer =
        new TemplateRenderer(configuration, auditConnector, preferencesConnector) {
          override val locator = locatorMock
          override lazy val templatesByLangPreference: Map[String, String] = Map(engTemplateId -> welshTemplateId)
          override lazy val commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
        }

      templateRenderer.languageTemplateId(templateId, Some("test@test.com")).futureValue shouldBe templateId

      verify(auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "test@test.com",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> templateId,
        "selectedTemplateId" -> templateId,
        "language"           -> "English"
      )
    }

    "return same template if the template doesn't exist in WelshTemplatesByLangPreference object and no email is provided" in new TestCase {
      val dataEventArgumentCaptor: ArgumentCaptor[DataEvent] = ArgumentCaptor.forClass(classOf[DataEvent])

      when(auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))

      override val templateRenderer =
        new TemplateRenderer(configuration, auditConnector, preferencesConnector) {
          override val locator = locatorMock
          override lazy val templatesByLangPreference: Map[String, String] = Map(engTemplateId -> welshTemplateId)
          override lazy val commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
        }

      templateRenderer.languageTemplateId(templateId, None).futureValue shouldBe templateId

      verify(auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "N/A",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> templateId,
        "selectedTemplateId" -> templateId,
        "language"           -> "English"
      )
    }

    "return same template if the template exist in WelshTemplatesByLangPreference object and no email is provided" in new TestCase {
      val dataEventArgumentCaptor: ArgumentCaptor[DataEvent] = ArgumentCaptor.forClass(classOf[DataEvent])

      when(auditConnector.sendEvent(any[DataEvent])(any[HeaderCarrier], any[ExecutionContext]))
        .thenReturn(Future.successful(AuditResult.Success))
      override val templateRenderer =
        new TemplateRenderer(configuration, auditConnector, preferencesConnector) {
          override val locator = locatorMock
          override lazy val templatesByLangPreference: Map[String, String] = Map(engTemplateId -> welshTemplateId)
          override lazy val commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
        }

      templateRenderer.languageTemplateId(engTemplateId, None).futureValue shouldBe engTemplateId

      verify(auditConnector)
        .sendEvent(dataEventArgumentCaptor.capture())(any[HeaderCarrier], any[ExecutionContext])

      dataEventArgumentCaptor.getValue.auditSource shouldBe "hmrc-email-renderer"
      dataEventArgumentCaptor.getValue.auditType shouldBe "TxSucceeded"
      dataEventArgumentCaptor.getValue.detail shouldBe Map(
        "email"              -> "N/A",
        "description"        -> "Defaulting to English",
        "originalTemplateId" -> engTemplateId,
        "selectedTemplateId" -> engTemplateId,
        "language"           -> "English"
      )
    }
  }

  class TestCase {

    val locatorMock = mock[TemplateLocator]
    val templateId = "a-template-id"
    val engTemplateId = "engTemplateId"
    val welshTemplateId = "welshTemplateId"

    val configuration = mock[Configuration]

    val auditConnector = mock[AuditConnector]
    val preferencesConnector = mock[PreferencesConnector]

    val templateRenderer = new TemplateRenderer(configuration, auditConnector, preferencesConnector) {
      override val locator = locatorMock
      override lazy val templatesByLangPreference: Map[String, String] = Map(engTemplateId -> welshTemplateId)
      override lazy val commonParameters: Map[String, String] = Map("commonKey" -> "commonValue")
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

    val validRenderedResult = (templateId: String) =>
      RenderResult(
        fromAddress = "from@test",
        service = "sa",
        subject = "a subject",
        plain = "Test template with parameter value: VALUE using common parameters: commonValue",
        html = "<p>Test template with parameter value: VALUE using common parameters: commonValue</p>",
        templateId,
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
