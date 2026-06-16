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

class SubcontractorVerificationSpec extends AnyWordSpec with Matchers {

  private val config = ConfigFactory.load().getConfig("templates.config")

  private val layoutParams: Map[String, Any] = Map(
    "staticAssetUrlPrefix"      -> config.getString("staticAssetUrlPrefix"),
    "staticHmrcFrontendVersion" -> config.getString("staticHmrcFrontendVersion")
  )

  private def render(params: Map[String, Any] = layoutParams): String =
    subcontractorVerification.render(params).body

  private def oneLine(value: String): String =
    value.stripMargin.replace("\n", " ")

  "subcontractorVerification.scala.html" should {

    "render the verification received email content" in {
      val html = render()

      html must include("Verification request received by HMRC")
      html must include("Dear customer")
      html must include(
        oneLine(
          """We have received your verification request. You can now view the results of this request by
            |signing in to the Construction Industry Scheme (CIS) online service."""
        )
      )
      html must include(
        oneLine(
          """Contact HMRC if you have any questions about this verification request. To find the correct
            |contact details, go to GOV.UK and search for CIS general enquiries."""
        )
      )
      html must include("Why you are receiving this email")
      html must include(
        "You recently submitted a verification request via the CIS online service and asked for confirmation to be sent to this email address."
      )
      html must include("From the Construction Industry Service team")
    }

    "render the reason section as a heading" in {
      val html = render()

      html must include("""<h2 style="margin: 0 0 30px 0;">Why you are receiving this email</h2>""")
    }

    "fail clearly if required layout params are missing" in {
      an[NoSuchElementException] must be thrownBy render(layoutParams - "staticAssetUrlPrefix")
      an[NoSuchElementException] must be thrownBy render(layoutParams - "staticHmrcFrontendVersion")
    }
  }
}
