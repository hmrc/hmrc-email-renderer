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

package uk.gov.hmrc.hmrcemailrenderer.controllers.model

import java.util.Base64

import play.api.libs.json._
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority.MessagePriority

case class RenderRequest(parameters: Map[String, String], email: Option[String])

object RenderRequest {
  implicit val reads: Reads[RenderRequest] = Json.reads[RenderRequest]
}

case class RenderResult(
  plain: String,
  html: String,
  fromAddress: String,
  subject: String,
  service: String,
  priority: Option[MessagePriority])

object RenderResult {
  private def base64Encoded(value: String) = Base64.getEncoder.encodeToString(value.getBytes("UTF-8"))

  implicit val writes: Writes[RenderResult] = Writes[RenderResult] { (toRender: RenderResult) =>
    Json.obj(
      "plain"       -> base64Encoded(toRender.plain),
      "html"        -> base64Encoded(toRender.html),
      "fromAddress" -> toRender.fromAddress,
      "subject"     -> toRender.subject,
      "service"     -> toRender.service
    ) ++ toRender.priority.fold(Json.obj()) { priority =>
      Json.obj("priority" -> priority.toString)
    }
  }
}
