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

package uk.gov.hmrc.hmrcemailrenderer.domain

import play.api.libs.json.{ Json, Writes }
import play.twirl.api.{ HtmlFormat, TxtFormat }
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.templates.{ FromAddress, ServiceIdentifier }

case class MessageTemplate(
  templateId: String,
  fromAddress: FromAddress,
  service: ServiceIdentifier,
  subject: Subject,
  plainTemplate: Body.Plain,
  htmlTemplate: Body.Html,
  priority: Option[MessagePriority]
)
object MessageTemplate {

  def create(
    templateId: String,
    fromAddress: String,
    service: ServiceIdentifier,
    subject: String,
    plainTemplate: Body.Plain,
    htmlTemplate: Body.Html,
    priority: Option[MessagePriority] = None
  ): MessageTemplate =
    MessageTemplate(
      templateId,
      FromAddress(_ => fromAddress),
      service,
      Subject.fromPlainString(subject),
      plainTemplate,
      htmlTemplate,
      priority
    )

  def createWithDynamicSubject(
    templateId: String,
    fromAddress: String,
    service: ServiceIdentifier,
    subject: Map[String, String] => String,
    plainTemplate: Body.Plain,
    htmlTemplate: Body.Html,
    priority: Option[MessagePriority] = None
  ): MessageTemplate =
    MessageTemplate(
      templateId,
      FromAddress(_ => fromAddress),
      service,
      Subject(subject),
      plainTemplate,
      htmlTemplate,
      priority
    )

  def createWithDynamicFromAddress(
    templateId: String,
    fromAddress: Map[String, String] => String,
    service: ServiceIdentifier,
    subject: String,
    plainTemplate: Body.Plain,
    htmlTemplate: Body.Html,
    priority: Option[MessagePriority] = None
  ): MessageTemplate =
    MessageTemplate(
      templateId,
      FromAddress(fromAddress),
      service,
      Subject.fromPlainString(subject),
      plainTemplate,
      htmlTemplate,
      priority
    )
}

case class Subject(f: Map[String, String] => String) {
  def apply(p: Map[String, String]): String = f(p)
}

object Subject {
  def fromPlainString(text: String): Subject = Subject(_ => text)
}
object Body {
  type Plain = Map[String, Any] => TxtFormat.Appendable
  type Html = Map[String, Any] => HtmlFormat.Appendable
}

sealed trait ErrorMessage extends Product with Serializable
final case class MissingTemplateId(templateId: String) extends ErrorMessage
final case class TemplateRenderFailure(reason: String) extends ErrorMessage
object TemplateRenderFailure {
  implicit val writes: Writes[TemplateRenderFailure] =
    Writes[TemplateRenderFailure] { failure =>
      Json.obj("reason" -> failure.reason, "status" -> "Rendering of template failed")
    }
}
