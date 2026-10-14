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
import uk.gov.hmrc.hmrcemailrenderer.templates.dasstechrefresh.cis.html.subcontractorVerification_cy

class SubcontractorVerificationCySpec extends AnyWordSpec with Matchers {

  private val config = ConfigFactory.load().getConfig("templates.config")

  private val layoutParams: Map[String, Any] = Map(
    "staticAssetUrlPrefix"      -> config.getString("staticAssetUrlPrefix"),
    "staticHmrcFrontendVersion" -> config.getString("staticHmrcFrontendVersion")
  )

  private def render(params: Map[String, Any] = layoutParams): String =
    subcontractorVerification_cy.render(params).body

  private def oneLine(value: String): String =
    value.stripMargin.replace("\n", " ")

  "subcontractorVerification_cy.scala.html" should {

    "render the Welsh verification received email content" in {
      val html = render()

      html must include("Cais am ddilysiad wedi&#x27;i ddod i law gan CThEF")
      html must include("Annwyl gwsmer")
      html must include(
        oneLine(
          """Mae'ch cais am ddilysiad wedi dod i law. Gallwch nawr bwrw golwg dros ganlyniadau'r cais hwn drwy
            |fewngofnodi i wasanaeth ar-lein Cynllun y Diwydiant Adeiladu (CIS)."""
        )
      )
      html must include(
        oneLine(
          """Cysylltwch â CThEF os oes gennych unrhyw gwestiynau am y cais dilysu hwn. I ddod o hyd i'r manylion
            |cyswllt cywir, ewch i GOV&#8203;.UK a chwilwch am 'CIS general enquiries'."""
        )
      )
      html must include("Pam eich bod yn cael yr e-bost hwn")
      html must include(
        "Yn ddiweddar, gwnaethoch gyflwyno cais am ddilysiad drwy wasanaeth ar-lein CIS a gofyn i gadarnhad gael ei anfon i'r cyfeiriad e-bost hwn."
      )
      html must include("Oddi wrth dim Gwasanaeth y Diwydiant Adeiladu")
    }

    "render the reason section as a heading" in {
      val html = render()

      html must include("""<h2 style="margin: 0 0 30px 0;">Pam eich bod yn cael yr e-bost hwn</h2>""")
    }

    "fail clearly if required layout params are missing" in {
      an[NoSuchElementException] must be thrownBy render(layoutParams - "staticAssetUrlPrefix")
      an[NoSuchElementException] must be thrownBy render(layoutParams - "staticHmrcFrontendVersion")
    }
  }
}
