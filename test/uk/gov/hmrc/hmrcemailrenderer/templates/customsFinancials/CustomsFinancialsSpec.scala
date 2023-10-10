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

package uk.gov.hmrc.hmrcemailrenderer.templates.customsFinancials

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec, customsfinancials }

class CustomsFinancialsSpec extends TemplateComparisonSpec with CommonParamsForSpec with GuiceOneAppPerSuite {

  private def customsFinancialsTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(customsfinancials.CustomsFinancialsTemplates.templates)

  "Templates for which the text and html content are identical" should {

    "include Supplementary statement content" in {
      val params = commonParameters ++ Map(
        "DefermentStatementType" -> "supplementary",
        "date"                   -> "15 June 2018",
        "DutyText"               -> "The total Duty and VAT owed will be collected by direct debit on or after"
      )
      compareContent("customs_financials_new_statement_notification", params)(customsFinancialsTemplate)
    }

    "include Excise statement content" in {
      val params = commonParameters ++ Map(
        "DefermentStatementType" -> "excise",
        "date"                   -> "29 June 2018",
        "DutyText"               -> "The total excise owed will be collected by direct debit on or before"
      )
      compareContent("customs_financials_new_statement_notification", params)(customsFinancialsTemplate)
    }

    "include 4th week statement content" in {
      val params = commonParameters ++ Map(
        "DefermentStatementType" -> "weekly",
        "PeriodIssueNumber"      -> "4",
        "date"                   -> "15 June 2018",
        "DutyText"               -> "The total Duty and VAT owed will be collected by direct debit on or after"
      )
      compareContent("customs_financials_new_statement_notification", params)(customsFinancialsTemplate)
    }

    "include 1st week statement content" in {
      val params = commonParameters ++ Map(
        "DefermentStatementType" -> "weekly",
        "PeriodIssueNumber"      -> "1",
        "date"                   -> "15 June 2018",
        "DutyText"               -> "The total Duty and VAT owed will be collected by direct debit on or after"
      )
      compareContent("customs_financials_new_statement_notification", params)(customsFinancialsTemplate)
    }
  }

  "Email notifications " should {
    "have matching content in the html and the text for requested duty deferment statements" in {
      compareContent("customs_financials_requested_duty_deferment_statement", commonParameters)(
        customsFinancialsTemplate)
    }

    "have matching content in the html and the text for import adjustment statements" in {
      compareContent("customs_financials_new_import_adjustment", commonParameters)(customsFinancialsTemplate)
    }

    "have matching content in the html and the text for requested import adjustment statements" in {
      compareContent("customs_financials_requested_import_adjustment", commonParameters)(customsFinancialsTemplate)
    }

    "have matching content in the html and the text for C79 certificates" in {
      compareContent("customs_financials_new_c79_certificate", commonParameters)(customsFinancialsTemplate)
    }

    "have matching content in the html and the text for historic C79 certificates" in {
      compareContent("customs_financials_historic_c79_certificate", commonParameters)(customsFinancialsTemplate)
    }

    "have matching content in the html and the text for postponed VAT statements" in {
      compareContent("customs_financials_new_postponed_vat_notification", commonParameters)(customsFinancialsTemplate)
    }

    "have matching content in the html and the text for requested postponed VAT statements" in {
      compareContent("customs_financials_requested_postponed_vat_notification", commonParameters)(
        customsFinancialsTemplate)
    }

    "have matching content in customs_financials_requested_duty_deferment_not_found" in {
      val params = commonParameters ++ Map("recipientName_FullName" -> "ABC ltd")

      compareContent("customs_financials_requested_duty_deferment_not_found", params)(customsFinancialsTemplate)
    }

    "have matching content in customs_financials_requested_c79_certificate_not_found" in {
      val params = commonParameters ++ Map("recipientName_FullName" -> "ABC ltd")

      compareContent("customs_financials_requested_c79_certificate_not_found", params)(customsFinancialsTemplate)
    }

    "have matching content in customs_financials_requested_postponed_import_vat_statements_not_found" in {
      val params = commonParameters ++ Map("recipientName_FullName" -> "ABC ltd")

      compareContent("customs_financials_requested_postponed_import_vat_statements_not_found", params)(
        customsFinancialsTemplate)
    }

    "have matching content in customs_financials_requested_notification_adjustment_statements_not_found" in {
      val params = commonParameters ++ Map("recipientName_FullName" -> "ABC ltd")

      compareContent("customs_financials_requested_notification_adjustment_statements_not_found", params)(
        customsFinancialsTemplate)
    }

  }

}
