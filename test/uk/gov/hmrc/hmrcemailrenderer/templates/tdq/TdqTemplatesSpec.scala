/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq

import java.util.Base64
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.libs.json.Json.{ parse, stringify }
import uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params._
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class TdqTemplatesSpec extends TemplateComparisonSpec with CommonParamsForSpec with GuiceOneAppPerSuite {

  private val headerWithErrors =
    """{
          "headerOrHeaders": "gov-client-public-ip",
          "errors": [
            {
              "message": "Value is not an IP address",
              "percentage": 5,
              "count": 25
            },
            {
              "message": "Value is not a public IP address",
              "percentage": 10,
              "count": 50
            }
          ],
          "warnings": []
        }"""

  private val headerWithWarnings =
    """{
          "headerOrHeaders": "gov-client-device-id",
          "errors" : [],
          "warnings": [
            {
              "message": "Use a recommended UUID. Check the specification.",
              "percentage": 0,
              "count": 1
            },
            {
              "message": "ID must be longer to ensure it is unique. It is best to use a UUID which is at least 128 bits or 32 hex characters long.",
              "percentage": 17,
              "count": 34
            },
            {
              "message": "Contains an email address. User specific data must not be used to generate Device IDs.",
              "percentage": 22,
              "count": 44
            }
          ]
        }"""

  private val headerWithErrorsAndWarnings =
    """{
          "headerOrHeaders": "gov-vendor-version",
          "errors": [
            {
              "message": "Value must be a key-value data structure",
              "percentage": 10,
              "count": 20
            },
            {
              "message": "At least 1 key or value is not percent encoded",
              "percentage": 25,
              "count": 50
            },
            {
              "message": "At least 1 software version value is missing",
              "percentage": 15,
              "count": 30
            },
            {
              "message": "At least 1 separator is percent encoded. Check ampersands and equal signs.",
              "percentage": 0,
              "count": 1
            }
          ],
          "warnings": [
            {
              "message": "For client server architectures, submit a version for the client and the server. For all other architectures, submit at least 1 version.",
              "percentage": 10,
              "count": 20
            }
          ]
        }"""

  "tdq_fph_report_heuristically_compliant" should {

    val baseParams = commonParameters + (
      "developerName"   -> "John Smith",
      "fromDate"        -> "22 September 2019",
      "toDate"          -> "22 October 2019",
      "month"           -> "October",
      "year"            -> "2019",
      "status"          -> "HEADERS_HEURISTICALLY_COMPLIANT",
      "applicationName" -> "MTD VAT Test Application",
      "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
      "regimeLongForm"  -> "VAT (Making Tax Digital)",
      "regimeShortForm" -> "VAT (MTD)",
    )

    "be the same for text and html content" in {
      compareContent("tdq_fph_report_heuristically_compliant", baseParams)(tdqTemplate)
    }

    "include the connection method when present in the parameters" in {
      val params = baseParams + (
        "extraDetails" -> extraDetails()
      )
      renderedEmail("tdq_fph_report_heuristically_compliant", params) must include
      "using web application via server"
    }

    "render without the connection method when not present in the parameters" in {
      renderedEmail("tdq_fph_report_heuristically_compliant", baseParams) must not include
        "using web application via server"
    }

    "include a message about other connection method reports when there are some" in {
      val params = baseParams + (
        "hasOtherConnectionMethods" -> "true"
      )
      renderedEmail("tdq_fph_report_heuristically_compliant", params) must include
      "Your application sent requests using another connection method, you'll receive a separate report"
    }

    "not include a message about other connection method reports when there are none" in {
      renderedEmail("tdq_fph_report_heuristically_compliant", baseParams) must not include
        "Your application sent requests using another connection method, you'll receive a separate report"
    }

    "contain subject with application name" in {
      val template = findTemplate("tdq_fph_report_heuristically_compliant")
      template.subject.f(baseParams) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }

    "include the regime" when {
      "the email is for VAT" in {
        val email = renderedEmail("tdq_fph_report_heuristically_compliant", baseParams)

        email must include("Fraud prevention headers report for VAT (Making Tax Digital)")
        email must include(
          "Our logs show that all of the fraud prevention headers submitted for <b>MTD VAT Test Application</b> to VAT (MTD) APIs"
        )
      }

      "the email is for ITSA" in {
        val params = baseParams + (
          "regimeLongForm"  -> "Income Tax (Making Tax Digital)",
          "regimeShortForm" -> "Income Tax (MTD)",
        )

        val email = renderedEmail("tdq_fph_report_heuristically_compliant", params)

        email must include("Fraud prevention headers report for Income Tax (Making Tax Digital)")
        email must include(
          "Our logs show that all of the fraud prevention headers submitted for <b>MTD VAT Test Application</b> to Income Tax (MTD) APIs"
        )
      }
    }
  }

  "tdq_fph_report_non_compliant" should {

    val baseParams = commonParameters + (
      "developerName"                     -> "John Smith",
      "fromDate"                          -> "22 September 2019",
      "toDate"                            -> "22 October 2019",
      "month"                             -> "October",
      "year"                              -> "2019",
      "status"                            -> "HEADERS_WITH_ERRORS",
      "applicationName"                   -> "MTD VAT Test Application",
      "applicationId"                     -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
      "regimeLongForm"                    -> "VAT (Making Tax Digital)",
      "regimeShortForm"                   -> "VAT (MTD)",
      "allHeadersMissingPercentage"       -> "10",
      "invalidConnectionMethodPercentage" -> "4",
      "relatesToMultipleVersions"         -> "true",
      "extraDetails"                      -> extraDetails(headerWithErrors, headerWithErrorsAndWarnings, headerWithWarnings)
    )

    "be the same for text and html content" in {
      compareContent("tdq_fph_report_non_compliant", baseParams)(tdqTemplate)
    }

    "contain subject with application name" in {
      val template = findTemplate("tdq_fph_report_non_compliant")
      template.subject.f(baseParams) mustEqual "Submit fraud prevention headers for MTD VAT Test Application"
    }

    "include optional content when a percentage of requests have an invalid connection method" in {
      val params = baseParams + (
        "invalidConnectionMethodPercentage" -> "4",
        "invalidConnectionMethodCount"      -> "40"
      )
      renderedEmail("tdq_fph_report_non_compliant", params) must include(
        "Your application has an invalid connection method in 40 requests (4% of all VAT (MTD) API requests).")
    }
    "not include optional content when there are no requests with invalid connection method" in {
      val params = baseParams + ("invalidConnectionMethodPercentage" -> "0")
      renderedEmail("tdq_fph_report_non_compliant", params) mustNot include(
        "Your application has an invalid connection method")
    }

    "include optional content when a percentage of requests have all headers missing" in {
      val params = baseParams + ("allHeadersMissingPercentage" -> "10")
      renderedEmail("tdq_fph_report_non_compliant", params) must include(
        "Your application is missing all of the header data in 10% of VAT (MTD) API requests.")
    }
    "not include optional content when there are no invalid connection methods" in {
      val params = baseParams + ("allHeadersMissingPercentage" -> "0")
      renderedEmail("tdq_fph_report_non_compliant", params) mustNot include(
        "Your application is missing all of the header data")
    }

    "include optional content when errors and advisories relate to more than 1 version" in {
      val params = baseParams + ("relatesToMultipleVersions" -> "true")
      renderedEmail("tdq_fph_report_non_compliant", params) must include(
        "Errors and advisories relate to more than 1 version of your software")
    }

    "not include optional content when the errors and advisories do not relate to more than 1 version" in {
      val params = baseParams + ("relatesToMultipleVersions" -> "false")
      renderedEmail("tdq_fph_report_non_compliant", params) mustNot include(
        "Errors and advisories relate to more than 1 version of your software")
    }

    "include a report when there are errors but no advisories" in {
      val params = baseParams + ("extraDetails" -> extraDetails(headerWithErrors))
      val email = renderedEmail("tdq_fph_report_non_compliant", params)

      email must include("Fix all of the errors shown in this report")
      email mustNot include("Fix all of the errors and check the advisories shown in this report")
      email mustNot include("Check the advisories shown in this report")

      email must include("You need to fix all errors")
      email mustNot include("You need to fix all errors and check advisories")
      email mustNot include("You need to check advisories")
    }

    "include a report when there are errors and advisories" in {
      val params = baseParams + ("extraDetails" -> extraDetails(headerWithErrors, headerWithWarnings))
      val email = renderedEmail("tdq_fph_report_non_compliant", params)

      email must include("Fix all of the errors and check the advisories shown in this report")
      email mustNot include("Fix all of the errors shown in this report")
      email mustNot include("Check the advisories shown in this report")

      email must include("You need to fix all errors and check advisories")
      email mustNot include("You need to check advisories")
    }

    "include a report when there are advisories but no errors" in {
      val params = baseParams + ("extraDetails" -> extraDetails(headerWithWarnings))
      val email = renderedEmail("tdq_fph_report_non_compliant", params)

      email must include("Check the advisories shown in this report")
      email mustNot include("Fix all of the errors shown in this report")
      email mustNot include("Fix all of the errors and check the advisories shown in this report")

      email must include("You need to check advisories")
      email mustNot include("You need to fix all errors")
      email mustNot include("You need to fix all errors and check advisories")
    }

    "not include a report when there are no errors or warnings" in {
      val params = baseParams - "extraDetails"
      val email = renderedEmail("tdq_fph_report_non_compliant", params)

      email mustNot include("Consider the warnings shown in this report")
      email mustNot include("Correct the errors shown in this report")
      email mustNot include("Correct the errors and consider the warnings shown in this report")

      email mustNot include("You need to consider warnings")
      email mustNot include("You need to correct errors")
      email mustNot include("You need to correct errors and consider warnings")
    }

    "include the regime" when {

      "the email is for VAT" in {
        val params = baseParams + (
          "invalidConnectionMethodPercentage" -> "4",
          "invalidConnectionMethodCount"      -> "40",
          "allHeadersMissingPercentage"       -> "10",
        )
        val email = renderedEmail("tdq_fph_report_non_compliant", params)

        email must include("Fraud prevention headers report for VAT (Making Tax Digital)")
        email must include(
          "Our logs show that the fraud prevention headers submitted for <b>MTD VAT Test Application</b> to VAT (MTD) APIs"
        )
        email must include(
          "Submitting header data for VAT (MTD) APIs is required by law"
        )
        email must include(
          "Your application is missing all of the header data in 10% of VAT (MTD) API requests."
        )
        email must include(
          "Your application has an invalid connection method in 40 requests (4% of all VAT (MTD) API requests)."
        )
      }

      "the email is for ITSA" in {
        val params = baseParams + (
          "regimeLongForm"                    -> "Income Tax (Making Tax Digital)",
          "regimeShortForm"                   -> "Income Tax (MTD)",
          "invalidConnectionMethodPercentage" -> "4",
          "invalidConnectionMethodCount"      -> "40",
          "allHeadersMissingPercentage"       -> "10",
        )

        val email = renderedEmail("tdq_fph_report_non_compliant", params)

        email must include("Fraud prevention headers report for Income Tax (Making Tax Digital)")
        email must include(
          "Our logs show that the fraud prevention headers submitted for <b>MTD VAT Test Application</b> to Income Tax (MTD) APIs"
        )
        email must include(
          "Submitting header data for Income Tax (MTD) APIs is required by law"
        )
        email must include(
          "Your application is missing all of the header data in 10% of Income Tax (MTD) API requests."
        )
        email must include(
          "Your application has an invalid connection method in 40 requests (4% of all Income Tax (MTD) API requests)."
        )
      }
    }
  }

  "tdq_fph_self_serve_nudge" should {

    val baseParams = commonParameters + (
      "developerName"   -> "John Smith",
      "fromDate"        -> "22 September 2019",
      "toDate"          -> "22 October 2019",
      "month"           -> "October",
      "year"            -> "2019",
      "status"          -> "HEADERS_WITH_ERRORS",
      "applicationName" -> "MTD VAT Test Application",
      "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
      "regimeLongForm"  -> "VAT (Making Tax Digital)",
      "regimeShortForm" -> "VAT (MTD)",
    )

    "be the same for text and html content" in {
      compareContent("tdq_fph_self_serve_nudge", baseParams)(tdqTemplate)
    }

    "contain subject with application name for application with no requests" in {
      val params = baseParams + ("status" -> NoRequests.name)
      val template = findTemplate("tdq_fph_self_serve_nudge")
      template.subject.f(params) mustEqual "Check fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for missing headers" in {
      val params = baseParams + ("status" -> AllRequiredHeadersMissing.name)
      val template = findTemplate("tdq_fph_self_serve_nudge")
      template.subject.f(params) mustEqual "Submit fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for invalid connection method" in {
      val params = baseParams + ("status" -> InvalidConnectionMethod.name)
      val template = findTemplate("tdq_fph_self_serve_nudge")
      template.subject.f(params) mustEqual "Submit fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for headers with errors" in {
      val params = baseParams + ("status" -> HeadersWithErrors.name)
      val template = findTemplate("tdq_fph_self_serve_nudge")
      template.subject.f(params) mustEqual "Fix fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for headers with advisories" in {
      val params = baseParams + ("status" -> HeadersWithWarnings.name)
      val template = findTemplate("tdq_fph_self_serve_nudge")
      template.subject.f(params) mustEqual "Improve fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for heuristically compliant headers" in {
      val params = baseParams + ("status" -> HeadersHeuristicallyCompliant.name)
      val template = findTemplate("tdq_fph_self_serve_nudge")
      template.subject.f(params) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name" in {
      val template = findTemplate("tdq_fph_self_serve_nudge")
      template.subject.f(baseParams) mustEqual "Fix fraud prevention headers for MTD VAT Test Application"
    }

    "include subject as the title" in {
      renderedEmail("tdq_fph_self_serve_nudge", baseParams) must include(
        "Fix fraud prevention headers for MTD VAT Test Application")
    }

    "include status contents for headers with errors" in {
      val email = renderedEmail("tdq_fph_self_serve_nudge", baseParams)
      email must include("Your application’s fraud prevention headers have errors.")
      email must include(
        "In production, so far in October 2019, MTD VAT Test Application does not meet the fraud prevention specification.")
    }

    "include status contents for application with no requests" in {
      val email = renderedEmail("tdq_fph_self_serve_nudge", baseParams + ("status" -> NoRequests.name))
      email must include("MTD VAT Test Application hasn’t sent any requests so far in October 2019.")
    }

    "include action content for headers with errors" in {
      renderedEmail("tdq_fph_self_serve_nudge", baseParams) must include("find out which errors you need to fix")
    }

    "include action content for application with no requests" in {
      renderedEmail("tdq_fph_self_serve_nudge", baseParams + ("status" -> NoRequests.name)) must include(
        "check the status of your application"
      )
    }
  }

  private def extraDetails(headerValidations: String*) = {
    val json = s"""
        {
          "connectionMethod": "WEB_APP_VIA_SERVER",
          "requestCount": 100,
          "headerValidations": [
            ${headerValidations.mkString(",")}
          ]
        }
        """

    Base64.getEncoder.encodeToString(stringify(parse(json)).getBytes("UTF-8"))
  }

  private def tdqTemplate(templateId: String) = messageTemplateF(templateId)(TdqTemplates.templates)

  private def findTemplate(templateId: String) = TdqTemplates.templates.filter(t => t.templateId == templateId).head

  private def renderedEmail(templateId: String, params: Map[String, String]): String =
    tdqTemplate(templateId) match {
      case Some((htmlTemplate, _)) => htmlTemplate(params).body
      case _                       => fail(s"could not locate template with id $templateId")
    }

}
