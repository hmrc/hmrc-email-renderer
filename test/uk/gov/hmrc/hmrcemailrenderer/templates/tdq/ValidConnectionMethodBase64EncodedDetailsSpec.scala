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

import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json.{parse, stringify}
import uk.gov.hmrc.hmrcemailrenderer.templates.tdq.extraparams.{HeadersValidation, Problem, ValidConnectionMethodBase64EncodedDetails}

class ValidConnectionMethodBase64EncodedDetailsSpec extends WordSpec with Matchers {

  "Extra details needed" should {

    "deserialise from a base64 encoded string" in {

      val base64EncodedDetails: String =
        Base64.getEncoder.encodeToString(stringify(parse("""
          {
            "connectionMethod": "MOBILE_APP_DIRECT",
            "requestCount": 100,
            "headerValidations": [
              {
                "headerOrHeaders": "gov-client-timezone",
                "errors": [
                  {
                    "message": "Some error",
                    "percentage": 10
                  }
                ],
                "warnings": [
                  {
                    "message": "Some warning",
                    "percentage": 20
                  }
                ]
              }
            ]
          }
          """)).getBytes("UTF-8"))

      val result = ValidConnectionMethodBase64EncodedDetails.parse(base64EncodedDetails)

      result shouldBe ValidConnectionMethodBase64EncodedDetails(
        connectionMethod = "MOBILE_APP_DIRECT",
        requestCount = 100,
        headerValidations = Set(
          HeadersValidation(
            headerOrHeaders = "gov-client-timezone",
            errors = Set(Problem("Some error", percentage = 10)),
            warnings = Set((Problem("Some warning", percentage = 20)))
          )
        )
      )

    }

  }

}
