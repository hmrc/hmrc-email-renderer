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
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.{RenderRequest, RenderResult}
import uk.gov.hmrc.hmrcemailrenderer.services.{MissingTemplateParameterException, TemplateRenderer}
import uk.gov.hmrc.play.http.BadRequestException
import uk.gov.hmrc.play.microservice.controller.BaseController

import scala.concurrent.Future

object RendererController extends RendererController {
  override def templateRenderer: TemplateRenderer = TemplateRenderer
}

trait RendererController extends BaseController {

  import RenderRequest.reads
  import RenderResult.writes

  def templateRenderer: TemplateRenderer

  def renderTemplate(templateId: String) = Action.async(parse.json) {
    implicit request =>
      withJsonBody[RenderRequest](body =>

        try {
          templateRenderer.render(templateId, body.parameters) match {
            case Some(renderedTemplate) => Future.successful(Ok(Json.toJson(renderedTemplate)))
            case None => Future.successful(NotFound)
          }
        } catch {
          case e: MissingTemplateParameterException => throw new BadRequestException(e.getMessage)
        }
      )
  }
}
