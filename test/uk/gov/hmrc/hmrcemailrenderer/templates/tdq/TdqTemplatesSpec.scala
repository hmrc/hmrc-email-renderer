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
        "fromDate"        -> "22 September 2019",
        "toDate"          -> "22 October 2019",
        "applicationName" -> "MTD VAT Test Application",
        "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
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
                  "message": "Value is not an IP address",
                  "percentage": 5
                },
                {
                  "message": "Value is not a public IP address",
                  "percentage": 10
                }
              ],
              "warnings": []
            },
            {
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
            },
            {
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
            }
          ]
        }
          """)).getBytes("UTF-8"))
      )

      compareContent("tdq_compliance_partially_compliant_valid_connection_method", params)(tdqTemplate)
    }

    "contain subject with application name" in {

      val template = findTemplate("tdq_compliance_partially_compliant_valid_connection_method")
      template.subject.f(Map("applicationName" -> "MTD VAT Test Application")) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }
  }

  private def tdqTemplate(templateId: String) = messageTemplateF(templateId)(TdqTemplates.templates)

  private def findTemplate(templateId: String) = TdqTemplates.templates.filter(t => t.templateId == templateId).head
}
