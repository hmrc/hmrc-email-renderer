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

package uk.gov.hmrc.hmrcemailrenderer.templates

import org.jsoup.Jsoup
import org.scalatest.Assertion
import org.scalatestplus.play.PlaySpec
import play.twirl.api.{ HtmlFormat, TxtFormat }
import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate

trait TemplateComparisonSpec extends PlaySpec with TemplateLoader {
  def compareContent(id: String, params: Map[String, String], isWelsh: Boolean = false)(
    getTemplates: String => Option[(HtmlTemplate, TextTemplate)]
  ): Assertion =
    getTemplates(id) match {
      case Some((htmlTemplate, textTemplate)) =>
        val html = TemplateContentNormalisation.html(htmlTemplate(params))
        val text = TemplateContentNormalisation.text(textTemplate(params))
        html mustEqual s"GOV UK ${if (isWelsh) "Cyllid a Thollau EF" else "HM Revenue & Customs"} $text"

      case _ => fail(s"could not locate template with id $id")
    }
}

object TemplateContentNormalisation {

  def html(content: HtmlFormat.Appendable): String = normaliseWhiteSpace(
    Jsoup.parse(content.body).getElementsByTag("body").text()
  )

  def text(content: TxtFormat.Appendable): String = normaliseWhiteSpace(
    content.body.linesIterator.map(_.replaceAll("""^((\s*)- )""", "")).mkString(" ")
  )

  def normaliseWhiteSpace(input: String): String =
    input.replaceAll("""\s+""", " ")

}

trait TemplateLoader {
  type TextTemplate = Map[String, String] => TxtFormat.Appendable
  type HtmlTemplate = Map[String, String] => HtmlFormat.Appendable

  def messageTemplateF(id: String): Seq[MessageTemplate] => Option[(HtmlTemplate, TextTemplate)] =
    _.collectFirst { case x: MessageTemplate if x.templateId == id => (x.htmlTemplate, x.plainTemplate) }
}
