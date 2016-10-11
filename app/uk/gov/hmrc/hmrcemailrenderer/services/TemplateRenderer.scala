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

package uk.gov.hmrc.hmrcemailrenderer.services

import com.ning.http.util.Base64
import org.apache.commons.codec.Charsets
import play.api.Play
import play.twirl.api.Format
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.{ErrorMessage, MissingTemplateId, TemplateRenderFailure}
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.play.config.RunMode

import scala.util.{Failure, Success, Try}

object TemplateRenderer extends TemplateRenderer with RunMode {

  val locator = TemplateLocator
  lazy val commonParameters: Map[String, String] = {
    import play.api.Play.current

    Play.configuration
      .getConfig(s"$env.templates.config")
      .map(_.entrySet.toMap.mapValues(_.unwrapped.toString))
      .getOrElse(Map.empty[String, String])
  }
}

trait TemplateRenderer {

  def commonParameters: Map[String, String]

  def locator: TemplateLocator

  def render(templateId: String, parameters: Map[String, String]): Either[ErrorMessage, RenderResult] = {
    val allParams = commonParameters ++ parameters
    for {
      template  <- locator.findTemplate(templateId).toRight[ErrorMessage](MissingTemplateId(templateId)).right
      plainText <- render(template.plainTemplate, allParams).right
      htmlText  <- render(template.htmlTemplate, allParams).right
    } yield RenderResult(plain = Base64.encode(plainText.getBytes(Charsets.UTF_8)),
                         html = Base64.encode(htmlText.getBytes(Charsets.UTF_8)),
                         fromAddress = template.fromAddress,
                         subject = template.subject(allParams),
                         service = template.service.name)
  }

  private def render(template: Map[String, String] => Format[_]#Appendable,
                     params: Map[String, String]): Either[ErrorMessage, String] =
    Try(template (params)) match {
      case Success(output) => Right(output.toString)
      case Failure(error) => Left(TemplateRenderFailure(error.getMessage))
    }
}


