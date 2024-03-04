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

package uk.gov.hmrc.hmrcemailrenderer.templates.apicatalogue

import org.apache.pekko.actor.setup.Setup
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.templates.apicatalogue.params.ApiCatalogueReportParams

class ApiCatalogueReportParamsSpec extends AnyWordSpecLike with OptionValues with Matchers {

  val paramsWithReasons = Map(
    "apiTitle"                  -> "Corporation Tax",
    "senderName"                -> "Joe Bloggs",
    "senderEmail"               -> "joe.bloggs@example.com",
    "contactReasons"            -> "Test contact reason one|Test contact reason two|Test contact reason three",
    "specificQuestion"          -> "How many engineers does it to change a light bulb?",
    "staticAssetUrlPrefix"      -> "http://uri",
    "staticHmrcFrontendVersion" -> "v1",
    "borderColour"              -> "#005EA5"
  )

  val paramsWithOneReason = Map(
    "apiTitle"                  -> "Corporation Tax",
    "senderName"                -> "Joe Bloggs",
    "senderEmail"               -> "joe.bloggs@example.com",
    "contactReasons"            -> "Test contact reason one",
    "specificQuestion"          -> "How many engineers does it to change a light bulb?",
    "staticAssetUrlPrefix"      -> "http://uri",
    "staticHmrcFrontendVersion" -> "v1",
    "borderColour"              -> "#005EA5"
  )

  val paramsWithNoReasons = Map(
    "apiTitle"                  -> "Corporation Tax",
    "senderName"                -> "Joe Bloggs",
    "senderEmail"               -> "joe.bloggs@example.com",
    "contactReasons"            -> "",
    "specificQuestion"          -> "How many engineers does it to change a light bulb?",
    "staticAssetUrlPrefix"      -> "http://uri",
    "staticHmrcFrontendVersion" -> "v1",
    "borderColour"              -> "#005EA5"
  )

  "ApiCatalogueReportParams" should {
    "getQuestions splits the string correctly into a List" in new Setup {
      ApiCatalogueReportParams.getQuestions(paramsWithReasons) shouldBe List(
        "Test contact reason one",
        "Test contact reason two",
        "Test contact reason three")

    }

    "getQuestions splits the string correctly when there is only one reason" in new Setup {
      ApiCatalogueReportParams.getQuestions(paramsWithOneReason) shouldBe List("Test contact reason one")

    }

    "getQuestions returns correctly if there are no reasons" in new Setup {
      ApiCatalogueReportParams.getQuestions(paramsWithNoReasons) shouldBe List("")

    }
  }

}
