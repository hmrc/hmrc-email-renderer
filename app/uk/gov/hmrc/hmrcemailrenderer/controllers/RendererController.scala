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

import play.api.libs.json.Json
import play.api.mvc._
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderRequest
import uk.gov.hmrc.hmrcemailrenderer.domain.{MissingTemplateId, TemplateRenderFailure}
import uk.gov.hmrc.hmrcemailrenderer.services.TemplateRenderer
import uk.gov.hmrc.play.microservice.controller.BaseController

import scala.concurrent.Future

object RendererController extends RendererController {
  override def templateRenderer: TemplateRenderer = TemplateRenderer
}

trait RendererController extends BaseController {

  def templateRenderer: TemplateRenderer

  def renderTemplate(templateId: String) = Action.async(parse.json) { implicit request =>
    withJsonBody[RenderRequest] { renderReq =>
      val result = templateRenderer.render(templateId, renderReq.parameters) match {
        case Right(rendered) => Ok(Json.toJson(rendered))
        case Left(MissingTemplateId(_)) => NotFound
        case Left(x@TemplateRenderFailure(_)) => BadRequest(Json.toJson(x))
      }
      Future.successful(result)
    }
  }
}
