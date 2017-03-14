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
import org.scalatestplus.play.OneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateComparisonSpec}
import uk.gov.hmrc.hmrcemailrenderer.templates.customs.CustomsTemplates

class TemplateContentComparisonSpec extends TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  def digitalContactTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(DigitalContactTemplates.templates)

  def customsTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(CustomsTemplates.templates)

  "Templates for which the text and html content are identical" should {

    "include customs_registration_successful" in {
      val params = commonParameters + (
        "recipientName_forename" -> "Forename",
        "recipientName_surname" -> "Surname"
      )

      compareContent("customs_registration_successful", params)(customsTemplate)
    }

    "include customs_registration_not_successful" in {
      val params = commonParameters + (
        "recipientName_forename" -> "Forename",
        "recipientName_surname" -> "Surname"
      )

      compareContent("customs_registration_not_successful", params)(customsTemplate)
    }

    "include customs_declaration_success" in {
      val params = Map( "details" -> "details") ++ commonParameters

      compareContent("customs_declaration_success", params)(customsTemplate)
    }

    "include customs_validation_success" in {
      val params = Map( "details" -> "details") ++ commonParameters

      compareContent("customs_validation_success", params)(customsTemplate)
    }

    "include customs_payment_required" in {
      val params = Map( "details" -> "details") ++ commonParameters

      compareContent("customs_payment_required", params)(customsTemplate)
    }

    "include customs_payment_success" in {
      val params = Map( "details" -> "details") ++ commonParameters

      compareContent("customs_payment_success", params)(customsTemplate)
    }

    "include newMessageAlert" in {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname" -> "b",
        "recipientName_honours" -> "c"
      ) ++ commonParameters
      compareContent("newMessageAlert", params)(digitalContactTemplate)
    }

    "include changeOfEmailAddress" in {
      val params = commonParameters

      compareContent("changeOfEmailAddress", params)(digitalContactTemplate)
    }

    "include digitalOptOutConfirmation" in {
      val params = commonParameters

      compareContent("digitalOptOutConfirmation", params)(digitalContactTemplate)
    }

    "render the identical rescindedMessageAlert content for both the text and html versions" in {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname" -> "b",
        "recipientName_honours" -> "c"
      ) ++ commonParameters

      compareContent("rescindedMessageAlert", params)(digitalContactTemplate)
    }

    "include verificationReminder content for both the text and html versions" in {
      val params = Map(
        "verificationLinkSentDate" -> DateTimeFormat.forPattern("YYYY-MM-dd").print(new LocalDate())
      ) ++ commonParameters

      compareContent("verificationReminder", params)(digitalContactTemplate)
    }

    "include SA300 templates" in {
      val params = commonParameters

      compareContent("newMessageAlert_SS300", params)(digitalContactTemplate)
      compareContent("newMessageAlert_SA300", params)(digitalContactTemplate)
    }

    "include SA309 templates" in {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname" -> "b",
        "recipientName_honours" -> "c"
      ) ++ commonParameters

      compareContent("newMessageAlert_SA309", params)(digitalContactTemplate)
    }

    "include SA316 templates" in {
      val params = Map(
        "recipientName_title" -> "title",
        "recipientName_forename" -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_honours" -> "c"
      ) ++ commonParameters

      compareContent("newMessageAlert_SA316", params)(digitalContactTemplate)
    }

  }

}


