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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq

import java.util.Base64

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import play.api.libs.json.Json.{ parse, stringify }
import uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params.ValidConnectionMethodBase64EncodedDetails

class ValidConnectionMethodBase64EncodedDetailsSpec extends AnyWordSpec with Matchers {

  val requestCount = 100

  "Details" should {

    "have connection method in the same format as the specification" in {
      val details = ValidConnectionMethodBase64EncodedDetails("WEB_APP_VIA_SERVER", requestCount)
      details.prettyConnectionMethod shouldBe "Web application via server"
    }
  }

  "Extra details" should {

    "deserialise from a base64 encoded string" in {

      val errorPercentage = 10
      val errorCount = 10
      val warningPercentage = 20
      val warningCount = 20

      val base64EncodedDetails: String =
        Base64.getEncoder.encodeToString(stringify(parse(s"""
          {
            "connectionMethod": "MOBILE_APP_DIRECT",
            "requestCount": $requestCount,
            "headerValidations": [
              {
                "headerOrHeaders": "gov-client-timezone",
                "errors": [
                  {
                    "message": "Some error",
                    "percentage": $errorPercentage,
                    "count": $errorCount
                  }
                ],
                "warnings": [
                  {
                    "message": "Some warning",
                    "percentage": $warningPercentage,
                    "count": $warningCount
                  }
                ]
              }
            ]
          }
          """)).getBytes("UTF-8"))

      val result = ValidConnectionMethodBase64EncodedDetails.parse(base64EncodedDetails)

      result shouldBe ValidConnectionMethodBase64EncodedDetails(
        connectionMethod = "MOBILE_APP_DIRECT",
        requestCount = requestCount
      )
    }
  }
}
