/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.ecc

import org.scalatestplus.play.OneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec, ecc }

class EoriCommonComponentTemplatesSpec extends TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  private def eoriCommonComponents(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(ecc.EoriCommonComponentTemplates.templates)

  private val fullParams = commonParameters + (
    "recipientName_FullName" -> "Jane Jones",
    "recipientOrgName"       -> "JJ Components",
    "serviceName"            -> "Advance Tariff Rulings",
    "completionDate"         -> "22 March 2019"
  )

  "Templates for which the text and html content are identical" should {

    "include subscription successful content" in {
      compareContent("ecc_subscription_successful", fullParams)(eoriCommonComponents)
    }

    "include subscription successful content in welsh" in {
      compareContent("ecc_subscription_successful_cy", fullParams, isWelsh = true)(eoriCommonComponents)
    }

    "include subscription not successful content" in {
      compareContent("ecc_subscription_not_successful", fullParams)(eoriCommonComponents)
    }

    "include subscription not successful content in welsh" in {
      compareContent("ecc_subscription_not_successful_cy", fullParams, isWelsh = true)(eoriCommonComponents)
    }

  }

  "Email notifications " should {
    "have matching content in the html and the text for ecc_subscription_successful" in {
      compareContent("ecc_subscription_successful", commonParameters)(eoriCommonComponents)
    }

    "have matching content in the html and the text for ecc_subscription_successful_cy" in {
      compareContent("ecc_subscription_successful_cy", commonParameters, isWelsh = true)(eoriCommonComponents)
    }

    "have matching content in the html and the text for ecc_subscription_not_successful" in {
      compareContent("ecc_subscription_not_successful", commonParameters)(eoriCommonComponents)
    }

    "have matching content in the html and the text for ecc_subscription_not_successful_cy" in {
      compareContent("ecc_subscription_not_successful_cy", commonParameters, isWelsh = true)(eoriCommonComponents)
    }

  }

}
