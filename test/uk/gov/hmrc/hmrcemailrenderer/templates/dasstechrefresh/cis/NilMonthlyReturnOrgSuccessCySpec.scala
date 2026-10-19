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
import uk.gov.hmrc.hmrcemailrenderer.templates.dasstechrefresh.cis.html.nilMonthlyReturnOrgSuccess_cy

class NilMonthlyReturnOrgSuccessCySpec extends AnyWordSpec with Matchers {

  private val config = ConfigFactory.load().getConfig("templates.config")

  private val layoutParams: Map[String, Any] = Map(
    "staticAssetUrlPrefix"      -> config.getString("staticAssetUrlPrefix"),
    "staticHmrcFrontendVersion" -> config.getString("staticHmrcFrontendVersion")
  )

  private val baseParams: Map[String, Any] =
    layoutParams ++ Map(
      "month" -> "Medi",
      "year"  -> "2025"
    )

  private def render(params: Map[String, Any] = baseParams): String =
    nilMonthlyReturnOrgSuccess_cy.render(params).body

  "nilMonthlyReturnOrgSuccess_cy.scala.html" should {

    "render Welsh title and main copy with month/year interpolation" in {
      val html = render()

      html must include("Cyflwyniad CIS Ar-lein a ddaeth i law gan Gyllid a Thollau EF")
      html must include("Diolch am ddefnyddio CIS Ar-lein.")
      html must include("Mae'ch datganiad misol ar gyfer Medi 2025 wedi dod i law Cyllid a Thollau EF (CT).")
      html must include("https://www.gov.uk/government/collections/talu-cthef-gwybodaeth-fanwl.cy")
      html must include("Os bydd angen unrhyw gymorth ychwanegol arnoch, cysylltwch â ni ar Online Services Helpdesk.")
      html must include(
        "Oriau agor 8.00 y.b. i 8.00 y.h., saith diwrnod yr wythnos. Ar gau ar Ddydd Nadolig, Gŵyl San Steffan a Dydd Calan"
      )
      html must include("Rhif ffôn: 0845 60 55 999")
      html must include(
        "Ar gyfer cwsmeriaid sy'n fyddar neu sydd â nam ar eu clyw neu leferydd: 0845 366 7805 (Ffôn testun)"
      )
      html must include("Os ydych yn ffonio o dramor, ffoniwch: +44 161 930 8445")
      html must include("helpdesk@ir-efile.gov.uk")
      html must not include "helpdesk@@ir-efile.gov.uk"
    }

    "interpolate different month/year values" in {
      val html = render(baseParams.updated("month", "Hydref").updated("year", "2026"))
      html must include("Mae'ch datganiad misol ar gyfer Hydref 2026 wedi dod i law Cyllid a Thollau EF (CT).")
    }

    "fail clearly if required params are missing" in {
      an[NoSuchElementException] must be thrownBy render(baseParams - "month")
      an[NoSuchElementException] must be thrownBy render(baseParams - "year")
      an[NoSuchElementException] must be thrownBy render(baseParams - "staticAssetUrlPrefix")
      an[NoSuchElementException] must be thrownBy render(baseParams - "staticHmrcFrontendVersion")
    }
  }
}
