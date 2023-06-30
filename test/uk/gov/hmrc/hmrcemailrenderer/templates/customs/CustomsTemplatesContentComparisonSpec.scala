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

package uk.gov.hmrc.hmrcemailrenderer.templates.customs

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class CustomsTemplatesContentComparisonSpec
    extends TemplateComparisonSpec with CommonParamsForSpec with GuiceOneAppPerSuite {

  private def customsTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(CustomsTemplates.templates)

  "Templates for which the text and html content are identical" should {

    "include customs_registration_successful" in {
      val params = commonParameters ++ Map(
        "recipientName_forename" -> "Forename",
        "recipientName_surname"  -> "Surname",
        "completionDate"         -> "17-06-2018"
      )

      compareContent("customs_registration_successful", params)(customsTemplate)
    }

    "include customs_registration_not_successful" in {
      val params = commonParameters ++ Map(
        "recipientName_forename" -> "Forename",
        "recipientName_surname"  -> "Surname"
      )

      compareContent("customs_registration_not_successful", params)(customsTemplate)
    }

    "include customs_migrate_successful" in {
      val params = commonParameters ++ Map(
        "recipientName_forename" -> "Forename",
        "recipientName_surname"  -> "Surname",
        "completionDate"         -> "17-06-2018"
      )

      compareContent("customs_migrate_successful", params)(customsTemplate)
    }

    "include customs_migrate_not_successful" in {
      val params = commonParameters ++ Map(
        "recipientName_forename" -> "Forename",
        "recipientName_surname"  -> "Surname"
      )

      compareContent("customs_migrate_not_successful", params)(customsTemplate)
    }

    "include customs_declaration_success" in {
      val params = Map("details" -> "details") ++ commonParameters

      compareContent("customs_declaration_success", params)(customsTemplate)
    }

    "include customs_validation_success" in {
      val params = Map("details" -> "details") ++ commonParameters

      compareContent("customs_validation_success", params)(customsTemplate)
    }

    "include customs_payment_required" in {
      val params = Map("details" -> "details") ++ commonParameters

      compareContent("customs_payment_required", params)(customsTemplate)
    }

    "include customs_payment_success" in {
      val params = Map("details" -> "details") ++ commonParameters

      compareContent("customs_payment_success", params)(customsTemplate)
    }

  }
}
