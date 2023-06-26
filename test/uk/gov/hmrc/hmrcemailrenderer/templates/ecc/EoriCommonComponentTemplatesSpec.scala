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

package uk.gov.hmrc.hmrcemailrenderer.templates.ecc

import org.scalatestplus.play.OneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec, ecc }

class EoriCommonComponentTemplatesSpec extends TemplateComparisonSpec with CommonParamsForSpec with OneAppPerSuite {

  private def eoriCommonComponents(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(ecc.EoriCommonComponentTemplates.templates)

  private def fullParams(enrolmentKey: String) = {
    val fullParams = commonParameters + (
      "recipientName_FullName" -> "Jane Jones",
      "recipientOrgName"       -> "JJ Components",
      "serviceName"            -> "Advance Tariff Rulings",
      "completionDate"         -> "22 March 2019",
      "enrolmentKey"           -> enrolmentKey,
    )
    fullParams
  }

  private def fullParamsStandalone(serviceName: String) = {
    val fullParams = commonParameters + (
      "recipientName_FullName" -> "Jane Jones",
      "recipientOrgName"       -> "JJ Components",
      "serviceName"            -> serviceName,
      "completionDate"         -> "22 March 2019",
      "enrolmentKey"           -> "HMRC-CUS-ORG",
    )
    fullParams
  }

  private val registrationParams = commonParameters + (
    "recipientName_FullName" -> "Jane Jones",
    "enrolmentKey"           -> "HMRC-ATAR-ORG"
  )

  private val registrationParamsESC = commonParameters + (
    "recipientName_FullName" -> "Jane Jones",
    "enrolmentKey"           -> "HMRC-ESC-ORG",
    "serviceName"            -> "Report and manage your allowance for Customs Duty waiver claims"
  )

  "Templates for which the text and html content are identical" should {

    "include subscription successful content" in {
      compareContent("ecc_subscription_successful", fullParams("HMRC-ATAR-ORG"))(eoriCommonComponents)
    }

    "include subscription successful content HMRC-CTS-ORG" in {
      compareContent("ecc_subscription_successful", fullParams("HMRC-CTS-ORG"))(eoriCommonComponents)
    }

    "include subscription successful content HMRC-GVMS-ORG" in {
      compareContent("ecc_subscription_successful", fullParams("HMRC-GVMS-ORG"))(eoriCommonComponents)
    }
    "include subscription successful content HMRC-CTC-ORG" in {
      compareContent("ecc_subscription_successful", fullParams("HMRC-CTC-ORG"))(eoriCommonComponents)
    }
    "include subscription successful content HMRC-SS-ORG" in {
      compareContent("ecc_subscription_successful", fullParams("HMRC-SS-ORG"))(eoriCommonComponents)
    }

    "include subscription successful content HMRC-CTS-ORG in welsh" in {
      compareContent("ecc_subscription_successful_cy", fullParams("HMRC-CTS-ORG"), isWelsh = true)(eoriCommonComponents)
    }
    "include subscription successful content HMRC-SS-ORG in welsh" in {
      compareContent("ecc_subscription_successful_cy", fullParams("HMRC-SS-ORG"), isWelsh = true)(eoriCommonComponents)
    }
    "include subscription successful content HMRC-CTC-ORG in welsh" in {
      compareContent("ecc_subscription_successful_cy", fullParams("HMRC-CTC-ORG"), isWelsh = true)(eoriCommonComponents)
    }

    "include subscription successful content in welsh" in {
      compareContent("ecc_subscription_successful_cy", fullParams("HMRC-GVMS-ORG"), isWelsh = true)(
        eoriCommonComponents)
    }

    "include registration successful content for standalone journey" in {
      compareContent("ecc_registration_successful", fullParamsStandalone("Get an EORI"))(eoriCommonComponents)
    }

    "include registration successful content in welsh for standalone journey" in {
      compareContent("ecc_registration_successful_cy", fullParamsStandalone("Cael rhif EORI"), isWelsh = true)(
        eoriCommonComponents)
    }

    "include registration successful content" in {
      compareContent("ecc_registration_successful", registrationParams)(eoriCommonComponents)
    }

    "include registration successful content in welsh" in {
      compareContent("ecc_registration_successful_cy", registrationParams, isWelsh = true)(eoriCommonComponents)
    }

    "include subscription not successful content" in {
      compareContent("ecc_subscription_not_successful", fullParams("HMRC-CTC-ORG"))(eoriCommonComponents)
    }

    "include subscription not successful content in welsh" in {
      compareContent("ecc_subscription_not_successful_cy", fullParams("HMRC-SS-ORG"), isWelsh = true)(
        eoriCommonComponents)
    }
  }

  "Email notifications " should {
    "have matching content in the html and the text for ecc_subscription_successful" in {
      compareContent("ecc_subscription_successful", commonParameters)(eoriCommonComponents)
    }

    "have matching content in the html and the text for ecc_subscription_successful_cy" in {
      compareContent("ecc_subscription_successful_cy", commonParameters, isWelsh = true)(eoriCommonComponents)
    }

    "have matching content in the html and the text for customs_registration_successful" in {
      compareContent("ecc_registration_successful", registrationParams)(eoriCommonComponents)
    }

    "have matching content in the html and the text for customs_registration_successful_cy" in {
      compareContent("ecc_registration_successful_cy", registrationParams, isWelsh = true)(eoriCommonComponents)
    }

    "have matching content in the html and the text for customs_registration_successful ESC" in {
      compareContent("ecc_registration_successful", registrationParamsESC)(eoriCommonComponents)
    }

    "have matching content in the html and the text for customs_registration_successful_cy ESC" in {
      compareContent("ecc_registration_successful_cy", registrationParamsESC, isWelsh = true)(eoriCommonComponents)
    }

    "have matching content in the html and the text for ecc_subscription_not_successful" in {
      compareContent("ecc_subscription_not_successful", commonParameters)(eoriCommonComponents)
    }

    "have matching content in the html and the text for ecc_subscription_not_successful_cy" in {
      compareContent("ecc_subscription_not_successful_cy", commonParameters, isWelsh = true)(eoriCommonComponents)
    }

  }

}
