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

package preview

import play.api.mvc.Action
import play.utils.UriEncoding
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.play.microservice.controller.BaseController
import scala.concurrent.ExecutionContext.Implicits.global

object PreviewController extends BaseController {
  def previewHome = Action {
    Ok(views.html.previews(previewGroups))
  }

  def previewHtml(templateId: String) = Action.async { implicit request =>
    Preview.html(templateId, flattenParameterValues(request.queryString)).map{html =>
        Ok(views.html.previewHtml(templateId, flattenParameterValues(request.queryString), html))
       }
  }

  def previewText(templateId: String) = Action.async { implicit request =>
    Preview.plain(templateId, flattenParameterValues(request.queryString)).map { txt =>
      Ok(views.txt.previewText(templateId, flattenParameterValues(request.queryString), txt))
    }
  }

  def previewSource(templateId: String) = Action.async { implicit request =>
    Preview.html(templateId, flattenParameterValues(request.queryString)).map { html =>
      Ok(views.html.previewHtml(templateId, flattenParameterValues(request.queryString), html).toString)
    }
  }

  private lazy val previewGroups: Stream[PreviewGroup] =
    TemplateLocator.templateGroups.toStream.map { case (identifier, templates) =>
      PreviewGroup.createPreviewGroup(identifier, templates)
    }

  private def flattenParameterValues(qs: Map[String, Seq[String]]): Map[String, String] = qs.map(t => (t._1, t._2.head))

}

final case class PreviewGroup private(name: String, items: Seq[PreviewListItem])
object PreviewGroup {
  def createPreviewGroup(title: String, templates: Seq[MessageTemplate]) =
    PreviewGroup(title, templates.map { template =>
      val params = TemplateParams.exampleParams.getOrElse(template.templateId, Map.empty)
      val priority = template.priority.getOrElse(MessagePriority.Standard)
      PreviewListItem(template.templateId, template.subject(params), priority, params)
    })
}

final case class PreviewListItem(templateId: String, subject: String, priority: MessagePriority, params: Map[String, String]) {
  lazy val queryString: String =
    if (params.isEmpty) ""
    else {
      val flattened = params.map(t => s"${t._1}=${UriEncoding.encodePathSegment(t._2, "UTF-8")}").mkString("&")
      s"?$flattened"
    }
}
