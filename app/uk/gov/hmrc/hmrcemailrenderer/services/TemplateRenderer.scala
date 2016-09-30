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

import play.api.Play
import play.twirl.api.{Format, HtmlFormat, TxtFormat}
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.templates.{Service, TemplateLocator}
import uk.gov.hmrc.play.config.RunMode


trait TemplateRenderer {

  def commonParameters: Map[String, String]

  def locator: TemplateLocator

  def render(templateId: String, parameters: Map[String, String]): Option[RenderResult] = {
    val allParams = commonParameters ++ parameters
    locator.findTemplate(templateId).map(template =>
      RenderResult(
        plain = render(template.plainTemplate, allParams),
        html = render(template.htmlTemplate, allParams),
        fromAddress = template.fromAddress,
        subject = template.subject(allParams),
        service = template.service.name
      )
    )
  }

  private def render (template: Map[String, String] => Format[_] #Appendable, params: Map[String, String]): String =
    template (params.withDefault (name => throw new MissingTemplateParameterException (name) ) ).toString

}


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

case class MessageTemplate(templateId: String,
                           fromAddress: String,
                           service: Service,
                           subject: Subject,
                           plainTemplate: Body.Plain,
                           htmlTemplate: Body.Html)

case class Subject(f: Map[String, String] => String) {
  def apply(p: Map[String, String]) = f(p)
}

object Subject {

  import scala.language.implicitConversions

  implicit def subjectFromPlainString(text: String): Subject = Subject(_ => text)

  implicit def subjectFromFunction(f: Map[String, String] => String): Subject = Subject(f)
}

object Body {

  type Plain = Map[String, Any] => TxtFormat.Appendable
  type Html = Map[String, Any] => HtmlFormat.Appendable
}

case class MissingTemplateParameterException(parameterName: String) extends RuntimeException(s"No value for '$parameterName'")
