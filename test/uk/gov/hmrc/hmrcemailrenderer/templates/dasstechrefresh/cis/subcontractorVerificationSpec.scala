/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.dasstechrefresh.cis

import com.typesafe.config.ConfigFactory
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.dasstechrefresh.cis.html.subcontractorVerification

class subcontractorVerificationSpec extends AnyWordSpec with Matchers {

  private val config = ConfigFactory.load().getConfig("templates.config")

  private val layoutParams: Map[String, Any] = Map(
    "staticAssetUrlPrefix"      -> config.getString("staticAssetUrlPrefix"),
    "staticHmrcFrontendVersion" -> config.getString("staticHmrcFrontendVersion")
  )

  private def render(params: Map[String, Any] = layoutParams): String =
    subcontractorVerification.render(params).body

  "subcontractorVerification.scala.html" should {

    "render title and main copy" in {
      val html = render()

      html must include("CIS Online submission received by HM Revenue and Customs")
      html must include("Thank you for using CIS Online.")
      html must include(
        "Your verification request has been received by HM Revenue &amp; Customs (HMRC) and a response has been provided."
      )
      html must include("If you require any further assistance please contact our Online Services Helpdesk.")
      html must include(
        "Opening hours 8.00 am to 8.00 pm, seven days a week. Closed Christmas Day, Boxing Day and New Years Day."
      )
      html must include("Tel: 0845 60 55 999")
      html must include("For customers who are deaf or hearing or speech impaired:  0845 366 7805 (Textphone)")
      html must include("If you're calling from abroad please telephone: +44 161 930 8445")
      html must include("helpdesk@ir-efile.gov.uk")
      html must not include "helpdesk@@ir-efile.gov.uk"
    }

    "fail clearly if required layout params are missing" in {
      an[NoSuchElementException] must be thrownBy render(layoutParams - "staticAssetUrlPrefix")
      an[NoSuchElementException] must be thrownBy render(layoutParams - "staticHmrcFrontendVersion")
    }
  }
}
