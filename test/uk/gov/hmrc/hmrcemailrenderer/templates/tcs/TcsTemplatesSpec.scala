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

package uk.gov.hmrc.hmrcemailrenderer.templates.tcs

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class TcsTemplatesSpec extends TemplateComparisonSpec with GuiceOneAppPerSuite with CommonParamsForSpec {

  def tcsTemplate(templateId: String) =
    messageTemplateF(templateId)(TcsTemplates.templates)

  "TcsTemplates" should {

    "render the identical tcs_renewal_confirmation content for both the text and html versions with zero incomplete claims and estimates" in {
      val params = Map(
        "awardStartDate"   -> "6 April 2016",
        "awardEndDate"     -> "10 January 2017",
        "customerFName"    -> "Elisha",
        "renewalReference" -> "123 456 789 123 456",
        "startDate"        -> "6 April 2016",
        "endDate"          -> "5 April 2017",
        "contactDeadline"  -> "31 January 2018",
        "noticeDate"       -> "21 October 2016",
        "incompleteClaims" -> "0",
        "anyEstimates"     -> "0",
        "currentTaxYear"   -> "2018"
      ) ++ commonParameters

      compareContent("tcs_renewal_confirmation", params)(tcsTemplate)
    }

    "render the identical tcs_renewal_confirmation content for both the text and html versions with ome incomplete claim and estimate" in {
      val params = Map(
        "awardStartDate"   -> "6 April 2016",
        "awardEndDate"     -> "10 January 2017",
        "customerFName"    -> "Elisha",
        "renewalReference" -> "123 456 789 123 456",
        "startDate"        -> "6 April 2016",
        "endDate"          -> "5 April 2017",
        "contactDeadline"  -> "31 January 2018",
        "noticeDate"       -> "21 October 2016",
        "incompleteClaims" -> "1",
        "anyEstimates"     -> "1",
        "currentTaxYear"   -> "2018"
      ) ++ commonParameters

      compareContent("tcs_renewal_confirmation", params)(tcsTemplate)
    }

    "render the identical tcs_renewal_confirmation content for both the text and html versions with more than one incomplete claim and estimate" in {
      val params = Map(
        "awardStartDate"   -> "6 April 2016",
        "awardEndDate"     -> "10 January 2017",
        "customerFName"    -> "Elisha",
        "renewalReference" -> "123 456 789 123 456",
        "startDate"        -> "6 April 2016",
        "endDate"          -> "5 April 2017",
        "contactDeadline"  -> "31 January 2018",
        "noticeDate"       -> "21 October 2016",
        "incompleteClaims" -> "2",
        "anyEstimates"     -> "2",
        "currentTaxYear"   -> "2018"
      ) ++ commonParameters

      compareContent("tcs_renewal_confirmation", params)(tcsTemplate)
    }

  }
}
