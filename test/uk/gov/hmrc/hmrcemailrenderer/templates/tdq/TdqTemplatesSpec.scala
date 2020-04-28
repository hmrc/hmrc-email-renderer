/*
 * Copyright 2020 HM Revenue & Customs
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

  "tdq_compliance_all_required_headers_missing template" should {

    "be the same for text and html content" in {

      val params = commonParameters + (
        "developerName"   -> "John Smith",
        "fromDate"        -> "22/09/2019",
        "toDate"          -> "22/10/2019",
        "applicationName" -> "MTD VAT Test Application",
        "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
      )

      compareContent("tdq_compliance_all_required_headers_missing", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_all_required_headers_missing")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for 'MTD VAT Test Application'"
    }
  }

  "tdq_compliance_partially_compliant_invalid_or_missing_connection_method" should {

    "be the same for text and html content" in {

      val params = commonParameters + (
        "developerName"   -> "John Smith",
        "fromDate"        -> "22/09/2019",
        "toDate"          -> "22/10/2019",
        "applicationName" -> "MTD VAT Test Application",
        "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
      )

      compareContent("tdq_compliance_partially_compliant_invalid_or_missing_connection_method", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_partially_compliant_invalid_or_missing_connection_method")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for 'MTD VAT Test Application'"
    }
  }

  "tdq_compliance_partially_compliant_valid_connection_method" should {

    "be the same for text and html content" in {

      val params = commonParameters + (
        "developerName"   -> "John Smith",
        "fromDate"        -> "22/09/2019",
        "toDate"          -> "22/10/2019",
        "applicationName" -> "MTD VAT Test Application",
        "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
        "extraDetails" -> Base64.getEncoder.encodeToString(stringify(
          parse("""
        {
          "connectionMethod": "WEB_APP_VIA_SERVER",
          "requestCount": 100,
          "headerValidations": [
            {
              "headerOrHeaders": "gov-client-public-ip",
              "errors": [
                {
                  "message": "Header value is not an IP address",
                  "percentage": 5
                },
                {
                  "message": "Header value is not a public IP address ",
                  "percentage": 10
                }
              ],
              "warnings": []
            },
            {
              "headerOrHeaders": "gov-vendor-version",
              "errors": [
                {
                  "message": "Header value is not a key value data structure ",
                  "percentage": 10
                },
                {
                  "message": "At least one of the keys or values is not percent encoded",
                  "percentage": 25
                },
                {
                  "message": "At least one value for software version is missing",
                  "percentage": 15
                },
                {
                  "message": "At least one separator (ampersand or equal sign) is percent encoded",
                  "percentage": 0
                }
              ],
              "warnings": [
                {
                  "message": "For client server architecture, please supply at least a version for client and server",
                  "percentage": 10
                }
              ]
            },
            {
              "headerOrHeaders": "gov-client-device-id",
              "errors" : [],
              "warnings": [
                {
                  "message": "Use a UUID (also known as a GUID) as recommended in our documentation",
                  "percentage": 0
                },
                {
                  "message": "ID needs to be longer to ensure it is unique. As a benchmark we use a UUID which is 128 bits or 32 hex characters long",
                  "percentage": 17
                },
                {
                  "message": "Header value contains an email address. Device ID should not be derived from user-specific data ",
                  "percentage": 22
                }
              ]
            }
          ]
        }
          """)).getBytes("UTF-8"))
      )

      compareContent("tdq_compliance_partially_compliant_valid_connection_method", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_partially_compliant_valid_connection_method")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for 'MTD VAT Test Application'"
    }
  }

  private def tdqTemplate(templateId: String) = messageTemplateF(templateId)(TdqTemplates.templates)

  private def findTemplate(templateId: String) = TdqTemplates.templates.filter(t => t.templateId == templateId).head
}
