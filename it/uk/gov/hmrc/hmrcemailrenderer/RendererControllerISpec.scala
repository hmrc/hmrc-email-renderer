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

package uk.gov.hmrc.hmrcemailrenderer

import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.{OneServerPerSuite, PortNumber, ServerProvider, WsScalaTestClient}
import play.api.{Configuration, Play}
import play.api.Mode.Mode
import play.api.libs.json._
import play.api.libs.ws.WSClient
import uk.gov.hmrc.play.config.ServicesConfig
import uk.gov.hmrc.play.http.test.ResponseMatchers
import uk.gov.hmrc.play.test.UnitSpec

class RendererControllerISpec extends UnitSpec
  with ServicesConfig
  with WsScalaTestClient
  with OneServerPerSuite
  with ScalaFutures
  with ResponseMatchers
  with ServerProvider {
  "POST /templates/:templateId" should {
    "return 200 and yield the rendered template data when supplied a valid templateId" in {
      val params = Map(
        "verificationLink" -> "/abc"
      )

//      implicit lazy val wsc: WSClient = app.injector.instanceOf[WSClient]

      implicit val ws: WSClient = app.injector.instanceOf(classOf[WSClient])

      val response = wsUrl(s"/templates/verifyEmailAddress").post(Json.obj("parameters" -> params))
      response should have(
        status(200),
        jsonProperty(__ \ "fromAddress", "HMRC digital <noreply@tax.service.gov.uk>"),
        jsonProperty(__ \ "subject", "HMRC electronic communications: verify your email address"),
        jsonProperty(__ \ "service", "sa"),
        jsonProperty(__ \ "plain"),
        jsonProperty(__ \ "html")
      )
    }

    "return 404 when a non-existent templateId is specified on the path" in {
      implicit lazy val wsc: WSClient = app.injector.instanceOf[WSClient]

      wsUrl(s"/templates/nonExistentTemplateId").
        post(Json.obj("parameters" -> Map.empty[String, String])) should have(status(404))
    }

    "return 400 and indicate the first point of failure when the parameters for the template are not supplied" in {
      implicit lazy val wsc: WSClient = app.injector.instanceOf[WSClient]

      wsUrl(s"/templates/verifyEmailAddress")
        .post(Json.obj("parameters" -> Map.empty[String, String])) should have(
        status(400),
        jsonProperty(__ \ "reason", "key not found: verificationLink")
      )
    }
  }

  override protected def mode: play.api.Mode.Mode = Play.current.mode

  override protected def runModeConfiguration: Configuration = Play.current.configuration
}
