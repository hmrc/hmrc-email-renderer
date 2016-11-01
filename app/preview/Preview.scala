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

package preview

import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.{ErrorMessage, MissingTemplateId, TemplateRenderFailure}
import uk.gov.hmrc.hmrcemailrenderer.services.TemplateRenderer

trait Preview {
  type RenderedResult = Either[ErrorMessage, RenderResult]

  def renderer: TemplateRenderer

  def html(templateId: String, parameters: Map[String, Seq[String]]): String =
    extractHtml.orElse(handleErrors).apply(renderer.render(templateId, flattenParameterValues(parameters)))

  def plain(templateId: String, parameters: Map[String, Seq[String]]): String =
    extractPlainText.orElse(handleErrors)(renderer.render(templateId, flattenParameterValues(parameters)))

  private val extractHtml: PartialFunction[RenderedResult, String] =
    { case Right(RenderResult(_, html, _, _, _, _)) => html }

  private val extractPlainText: PartialFunction[RenderedResult, String] =
    { case Right(RenderResult(plain, _, _, _, _, _)) => plain }

  private val handleErrors: PartialFunction[RenderedResult, String] = {
    case Left(MissingTemplateId(templateId)) =>
      s"failed to rendered template with id == $templateId"
    case Left(TemplateRenderFailure(reason)) => reason
  }

  private val flattenParameterValues: Map[String, Seq[String]] => Map[String, String] = _.map(t => (t._1, t._2.head))
}

object Preview extends Preview {
  def renderer = TemplateRenderer
}
