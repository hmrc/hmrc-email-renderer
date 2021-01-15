/*
 * Copyright 2021 HM Revenue & Customs
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

import org.scalatestplus.play.OneAppPerSuite
import play.api.libs.json.Json.{ parse, stringify }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class TdqTemplatesSpec extends TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  private val headerWithErrors =
    """{
          "headerOrHeaders": "gov-client-public-ip",
          "errors": [
            {
              "message": "Value is not an IP address",
              "percentage": 5
            },
            {
              "message": "Value is not a public IP address",
              "percentage": 10
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
              "percentage": 0
            },
            {
              "message": "ID must be longer to ensure it is unique. It is best to use a UUID which is at least 128 bits or 32 hex characters long.",
              "percentage": 17
            },
            {
              "message": "Contains an email address. User specific data must not be used to generate Device IDs.",
              "percentage": 22
            }
          ]
        }"""

  private val headerWithErrorsAndWarnings =
    """{
          "headerOrHeaders": "gov-vendor-version",
          "errors": [
            {
              "message": "Value must be a key-value data structure",
              "percentage": 10
            },
            {
              "message": "At least 1 key or value is not percent encoded",
              "percentage": 25
            },
            {
              "message": "At least 1 software version value is missing",
              "percentage": 15
            },
            {
              "message": "At least 1 separator is percent encoded. Check ampersands and equal signs.",
              "percentage": 0
            }
          ],
          "warnings": [
            {
              "message": "For client server architectures, submit a version for the client and the server. For all other architectures, submit at least 1 version.",
              "percentage": 10
            }
          ]
        }"""

  "tdq_compliance_all_required_headers_missing template" should {

    "be the same for text and html content" in {

      val params = commonParameters + (
        "developerName"                     -> "John Smith",
        "fromDate"                          -> "22 September 2019",
        "toDate"                            -> "22 October 2019",
        "applicationName"                   -> "MTD VAT Test Application",
        "applicationId"                     -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
        "invalidConnectionMethodPercentage" -> "30",
        "allHeadersMissingPercentage"       -> "70"
      )

      compareContent("tdq_compliance_all_required_headers_missing", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_all_required_headers_missing")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }
  }

  "tdq_compliance_partially_compliant_invalid_or_missing_connection_method" should {

    "be the same for text and html content" in {

      val params = commonParameters + (
        "developerName"   -> "John Smith",
        "fromDate"        -> "22 September 2019",
        "toDate"          -> "22 October 2019",
        "applicationName" -> "MTD VAT Test Application",
        "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
      )

      compareContent("tdq_compliance_partially_compliant_invalid_or_missing_connection_method", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_partially_compliant_invalid_or_missing_connection_method")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }
  }

  "tdq_compliance_partially_compliant_valid_connection_method" should {

    "be the same for text and html content" in {

      val params = commonParameters + (
        "developerName"   -> "John Smith",
        "fromDate"        -> "22 September 2019",
        "toDate"          -> "22 October 2019",
        "applicationName" -> "MTD VAT Test Application",
        "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
        "extraDetails"    -> extraDetails(headerWithErrors, headerWithErrorsAndWarnings, headerWithWarnings)
      )

      compareContent("tdq_compliance_partially_compliant_valid_connection_method", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_partially_compliant_valid_connection_method")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }
  }

  "tdq_fph_report_heuristically_compliant" should {

    val params = commonParameters + (
      "developerName"   -> "John Smith",
      "fromDate"        -> "22 September 2019",
      "toDate"          -> "22 October 2019",
      "applicationName" -> "MTD VAT Test Application",
      "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
    )

    "be the same for text and html content" in {
      compareContent("tdq_fph_report_heuristically_compliant", params)(tdqTemplate)
    }

    "contain subject with application name" in {
      val template = findTemplate("tdq_fph_report_heuristically_compliant")
      template.subject.f(params) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }
  }

  "tdq_fph_report_non_compliant" should {

    val baseParams = commonParameters + (
      "developerName"                     -> "John Smith",
      "fromDate"                          -> "22 September 2019",
      "toDate"                            -> "22 October 2019",
      "applicationName"                   -> "MTD VAT Test Application",
      "applicationId"                     -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
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
      val params = baseParams + ("invalidConnectionMethodPercentage" -> "4")
      renderedEmail("tdq_fph_report_non_compliant", params) must include(
        "Your application has an invalid connection method in 4% of requests.")
    }
    "not include optional content when there are no requests with invalid connection method" in {
      val params = baseParams + ("invalidConnectionMethodPercentage" -> "0")
      renderedEmail("tdq_fph_report_non_compliant", params) mustNot include(
        "Your application has an invalid connection method")
    }

    "include optional content when a percentage of requests have all headers missing" in {
      val params = baseParams + ("allHeadersMissingPercentage" -> "10")
      renderedEmail("tdq_fph_report_non_compliant", params) must include(
        "Your application is missing all of the header data in 10% of requests.")
    }
    "not include optional content when there are no invalid connection methods" in {
      val params = baseParams + ("allHeadersMissingPercentage" -> "0")
      renderedEmail("tdq_fph_report_non_compliant", params) mustNot include(
        "Your application is missing all of the header data")
    }

    "include optional content when errors and warnings relate to more than 1 version" in {
      val params = baseParams + ("relatesToMultipleVersions" -> "true")
      renderedEmail("tdq_fph_report_non_compliant", params) must include(
        "Errors and warnings relate to more than 1 version of your software")
    }
    "not include optional content when the errors and warnings do not relate to more than 1 version" in {
      val params = baseParams + ("relatesToMultipleVersions" -> "false")
      renderedEmail("tdq_fph_report_non_compliant", params) mustNot include(
        "Errors and warnings relate to more than 1 version of your software")
    }

    "include a report when there are errors but no warnings" in {
      val params = baseParams + ("extraDetails" -> extraDetails(headerWithErrors))
      val email = renderedEmail("tdq_fph_report_non_compliant", params)

      email must include("Correct the errors shown in this report")
      email mustNot include("Correct the errors and consider the warnings shown in this report")
      email mustNot include("Consider the warnings shown in this report")

      email must include("You need to correct errors")
      email mustNot include("You need to correct errors and consider warnings")
      email mustNot include("You need to consider warnings")
    }

    "include a report when there are errors and warnings" in {
      val params = baseParams + ("extraDetails" -> extraDetails(headerWithErrors, headerWithWarnings))
      val email = renderedEmail("tdq_fph_report_non_compliant", params)

      email must include("Correct the errors and consider the warnings shown in this report")
      email mustNot include("Correct the errors shown in this report")
      email mustNot include("Consider the warnings shown in this report")

      email must include("You need to correct errors and consider warnings")
      email mustNot include("You need to consider warnings")
    }

    "include a report when there are warnings but no errors" in {
      val params = baseParams + ("extraDetails" -> extraDetails(headerWithWarnings))
      val email = renderedEmail("tdq_fph_report_non_compliant", params)

      email must include("Consider the warnings shown in this report")
      email mustNot include("Correct the errors shown in this report")
      email mustNot include("Correct the errors and consider the warnings shown in this report")

      email must include("You need to consider warnings")
      email mustNot include("You need to correct errors")
      email mustNot include("You need to correct errors and consider warnings")
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
