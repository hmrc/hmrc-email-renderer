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

package uk.gov.hmrc.hmrcemailrenderer.domain

import play.api.libs.json.Json
import play.twirl.api.{HtmlFormat, TxtFormat}
import uk.gov.hmrc.hmrcemailrenderer.templates.Service

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

case class ErrorMessage(reason: String, status:String = "Rendering of template failed")
object ErrorMessage {
  implicit val format = Json.format[ErrorMessage]
}
