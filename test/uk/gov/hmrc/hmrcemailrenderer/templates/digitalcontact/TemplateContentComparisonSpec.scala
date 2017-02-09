/*
 * Copyright 2017 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.jsoup.Jsoup
import org.scalatestplus.play.OneAppPerSuite
import play.twirl.api.{HtmlFormat, TxtFormat}
import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.customs.CustomsTemplates
import uk.gov.hmrc.play.test.UnitSpec

class TemplateContentComparisonSpec extends UnitSpec with TemplateLoader with OneAppPerSuite{

  "Templates for which the text and html content are identical" should {

    "include customs_declaration_success" in new TemplateComparison {
      val params = Map(
        "details" -> "details",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("customs_declaration_success", params)(customsTemplate)
    }

    "include customs_validation_success" in new TemplateComparison {
      val params = Map(
        "details" -> "details",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("customs_validation_success", params)(customsTemplate)
    }

    "include customs_payment_required" in new TemplateComparison {
      val params = Map(
        "details" -> "details",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("customs_payment_required", params)(customsTemplate)
    }

    "include customs_payment_success" in new TemplateComparison {
      val params = Map(
        "details" -> "details",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("customs_payment_success", params)(customsTemplate)
    }

    "include newMessageAlert" in new TemplateComparison {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname" -> "b",
        "recipientName_honours" -> "c",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("newMessageAlert", params)(digitalContactTemplate)
    }

    "include changeOfEmailAddress" in new TemplateComparison {
      val params = Map(
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("changeOfEmailAddress", params)(digitalContactTemplate)
    }

    "include digitalOptOutConfirmation" in new TemplateComparison {
      val params = Map(
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("digitalOptOutConfirmation", params)(digitalContactTemplate)
    }

    "render the identical rescindedMessageAlert content for both the text and html versions" in new TemplateComparison {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname" -> "b",
        "recipientName_honours" -> "c",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )

      compareContent("rescindedMessageAlert", params)(digitalContactTemplate)
    }

    "include verificationReminder content for both the text and html versions" in new TemplateComparison {
      val params = Map(
        "verificationLinkSentDate" -> DateTimeFormat.forPattern("YYYY-MM-dd").print(new LocalDate()),
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("verificationReminder", params)(digitalContactTemplate)
    }

    "include SA300 templates" in new TemplateComparison {
      val params = Map(
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )
      compareContent("newMessageAlert_SS300", params)(digitalContactTemplate)
      compareContent("newMessageAlert_SA300", params)(digitalContactTemplate)
    }

    "include SA309 templates" in new TemplateComparison {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname" -> "b",
        "recipientName_honours" -> "c",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )

      compareContent("newMessageAlert_SA309", params)(digitalContactTemplate)
    }

    "include SA316 templates" in new TemplateComparison {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_honours" -> "c",
        "staticAssetVersion" -> "version",
        "staticAssetUrlPrefix" -> "prefix",
        "borderColour" -> "#005EA5"
      )

      compareContent("newMessageAlert_SA316", params)(digitalContactTemplate)
    }

  }


  trait TemplateComparison {
    def compareContent(id: String, params: Map[String, String])(getTemplates: String => Option[(HtmlTemplate, TextTemplate)]) =
      getTemplates(id) match {
        case Some((htmlTemplate, textTemplate)) =>
          val html = TemplateContentNormalisation.html(htmlTemplate(params))
          val text = TemplateContentNormalisation.text(textTemplate(params))
          html should be (s"GOV.UK HM Revenue & Customs $text")

        case _ => fail(s"could not locate template with id $id")
      }
  }
}

trait TemplateLoader {
  type TextTemplate = Map[String, String] => TxtFormat.Appendable
  type HtmlTemplate = Map[String, String] => HtmlFormat.Appendable

  def messageTemplateF(id: String): Seq[MessageTemplate] => Option[(HtmlTemplate, TextTemplate)] =
    _.collectFirst { case x: MessageTemplate if x.templateId == id => (x.htmlTemplate, x.plainTemplate) }

  def digitalContactTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(DigitalContactTemplates.templates)

  def customsTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(CustomsTemplates.templates)

}

object TemplateContentNormalisation {

  def html(content: HtmlFormat.Appendable) = normaliseWhiteSpace(
    Jsoup.parse(content.body).getElementsByTag("body").text()
  )

  def text(content: TxtFormat.Appendable) = normaliseWhiteSpace(
    content.body.lines.
      map(_.replaceAll("""^((\s*)- )""", "")).
      mkString(" ")
  )

  def normaliseWhiteSpace(input: String) =
    input.replaceAll("""\s+""", " ")

}
