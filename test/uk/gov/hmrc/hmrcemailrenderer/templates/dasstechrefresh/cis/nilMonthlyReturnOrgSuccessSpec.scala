/*
 * Copyright 2025 HM Revenue & Customs
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
import uk.gov.hmrc.hmrcemailrenderer.templates.dasstechrefresh.cis.html.nilMonthlyReturnOrgSuccess

class nilMonthlyReturnOrgSuccessSpec extends AnyWordSpec with Matchers {
  private val config = ConfigFactory.load().getConfig("templates.config")

  private val layoutParams: Map[String, Any] = Map(
    "staticAssetUrlPrefix"      -> config.getString("staticAssetUrlPrefix"),
    "staticHmrcFrontendVersion" -> config.getString("staticHmrcFrontendVersion")
  )

  private val baseParams: Map[String, Any] =
    layoutParams ++ Map(
      "month" -> "September",
      "year"  -> "2025"
    )

  private def render(params: Map[String, Any] = baseParams): String =
    nilMonthlyReturnOrgSuccess.render(params).body

  "nilMonthlyReturnOrgSuccess.scala.html" should {

    "render title and main copy with month/year interpolation" in {
      val html = render()

      html must include("CIS Online submission received by HM Revenue and Customs")
      html must include("Thank you for using CIS Online.")
      html must include("Your monthly return for September 2025 has been received by HM Revenue &amp; Customs (HMRC).")
      html must include("http://www.hmrc.gov.uk/payinghmrc/index.html")
      html must include("Tel: 0845 60 55 999")
      html must include("helpdesk@ir-efile.gov.uk")
      html must not include "helpdesk@@ir-efile.gov.uk"
    }

    "interpolate different month/year values" in {
      val html = render(baseParams.updated("month", "October").updated("year", "2026"))
      html must include("Your monthly return for October 2026 has been received")
    }

    "fail clearly if required params are missing" in {
      an[NoSuchElementException] must be thrownBy render(baseParams - "month")
      an[NoSuchElementException] must be thrownBy render(baseParams - "year")
      an[NoSuchElementException] must be thrownBy render(baseParams - "staticAssetUrlPrefix")
      an[NoSuchElementException] must be thrownBy render(baseParams - "staticHmrcFrontendVersion")
    }
  }
}
