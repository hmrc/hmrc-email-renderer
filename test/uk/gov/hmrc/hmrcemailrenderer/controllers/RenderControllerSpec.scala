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

package uk.gov.hmrc.hmrcemailrenderer.controllers

import org.mockito.Mockito
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import org.scalatest.mock.MockitoSugar
import play.api.http.Status
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Result
import play.api.test.FakeRequest
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.ErrorMessage
import uk.gov.hmrc.hmrcemailrenderer.services.TemplateRenderer
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

import scala.concurrent.Future


class RenderControllerSpec extends UnitSpec with WithFakeApplication with MockitoSugar with ScalaFutures with IntegrationPatience {

  "POST /templates/:templateid" should {
    "return 200 and the rendered template with parameters" in new TestCase {
      Mockito.when(templateRendererMock.render("a-template-id", Map("key" -> "value")))
        .thenReturn(Some(Right(RenderResult("plain body", "<html>html body</hmtl>", "from@test", "subject", "sa"))))

      val result: Future[Result] = controller.renderTemplate("a-template-id")(fakeRequest("a-template-id", Map("key" -> "value")))
      status(result) shouldBe Status.OK
      val jsValue: JsValue = jsonBodyOf(result).futureValue
      (jsValue \ "plain").as[String] shouldBe "plain body"
      (jsValue \ "html").as[String] shouldBe "<html>html body</hmtl>"
      (jsValue \ "fromAddress").as[String] shouldBe "from@test"
      (jsValue \ "subject").as[String] shouldBe "subject"
      (jsValue \ "service").as[String] shouldBe "sa"
    }

    "return 404 if the template is not found" in new TestCase {

      Mockito.when(templateRendererMock.render("unknown", Map.empty))
        .thenReturn(None)

      val result: Future[Result] = controller.renderTemplate("unknown")(fakeRequest("unknown", Map.empty))
      status(result) shouldBe Status.NOT_FOUND
    }

    "return 400 if the template fails to render" in new TestCase {
      Mockito.when(templateRendererMock.render("a-template-id", Map.empty))
        .thenReturn(Some(Left(ErrorMessage("No value for 'missing-parameter'"))))

      val result: Future[Result] = controller.renderTemplate("a-template-id")(fakeRequest("a-template-id", Map.empty))
      status(result) shouldBe Status.BAD_REQUEST
      (jsonBodyOf(result).futureValue \ "reason").as[String] shouldBe "No value for 'missing-parameter'"
    }
  }

  trait TestCase {
    def fakeRequest(templateId: String, parameters: Map[String, String]) =
      FakeRequest("POST", s"/template/$templateId").withBody(Json.obj("parameters" -> parameters))

    val templateRendererMock = mock[TemplateRenderer]

    val controller = new RendererController {
      override def templateRenderer: TemplateRenderer = templateRendererMock
    }
  }
}
