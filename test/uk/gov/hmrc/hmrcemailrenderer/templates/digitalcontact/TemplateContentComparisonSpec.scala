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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class TemplateContentComparisonSpec
    extends PlaySpec with TemplateComparisonSpec with CommonParamsForSpec with GuiceOneAppPerSuite {

  val commonParamsWithName = commonParameters.updated("recipientName_forename", "forename")

  def digitalContactTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(DigitalContactTemplates.templates)

  "Templates for which the text and html content are identical" should {

    "include newMessageAlert" in {
      val params = Map(
        "recipientName_title"          -> "title",
        "recipientName_forename"       -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname"        -> "b",
        "recipientName_honours"        -> "c"
      ) ++ commonParameters
      compareContent("newMessageAlert", params)(digitalContactTemplate)
    }

    "include changeOfEmailAddress" in {
      val params = commonParamsWithName

      compareContent("changeOfEmailAddress", params)(digitalContactTemplate)
    }

    "include digitalOptOutConfirmation" in {
      val params = commonParamsWithName

      compareContent("digitalOptOutConfirmation", params)(digitalContactTemplate)
    }

    "render the identical rescindedMessageAlert content for both the text and html versions" in {
      val params = Map(
        "recipientName_title"          -> "title",
        "recipientName_forename"       -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname"        -> "b",
        "recipientName_honours"        -> "c"
      ) ++ commonParameters

      compareContent("rescindedMessageAlert", params)(digitalContactTemplate)
    }

    "render the identical penaltyChargeApologies content for both the text and html versions" in {
      val params = Map(
        "recipientName_title"          -> "title",
        "recipientName_forename"       -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname"        -> "b",
        "recipientName_honours"        -> "c"
      ) ++ commonParameters

      compareContent("penaltyChargeApologies", params)(digitalContactTemplate)
    }

    "include verificationReminder content for both the text and html versions" in {
      val params = Map(
        "verificationLink"         -> "/some/link",
        "daysAgo"                  -> "3",
        "verificationLinkSentDate" -> DateTimeFormat.forPattern("YYYY-MM-dd").print(new LocalDate())
      ) ++ commonParamsWithName

      compareContent("verificationReminder", params)(digitalContactTemplate)
    }

    "include SA300 templates" in {
      val params = commonParameters

      compareContent("newMessageAlert_SS300", params)(digitalContactTemplate)
      compareContent("newMessageAlert_SA300", params)(digitalContactTemplate)
    }

    "include SA309 templates" in {
      val params = Map(
        "recipientName_title"          -> "title",
        "recipientName_forename"       -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_surname"        -> "b",
        "recipientName_honours"        -> "c"
      ) ++ commonParameters

      compareContent("newMessageAlert_SA309", params)(digitalContactTemplate)
    }

    "include SA316 templates" in {
      val params = Map(
        "recipientName_title"          -> "title",
        "recipientName_forename"       -> "forename",
        "recipientName_secondForename" -> "a",
        "recipientName_honours"        -> "c"
      ) ++ commonParameters

      compareContent("newMessageAlert_SA316", params)(digitalContactTemplate)
    }

  }

}
