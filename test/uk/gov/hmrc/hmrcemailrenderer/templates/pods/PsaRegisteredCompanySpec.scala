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

package uk.gov.hmrc.hmrcemailrenderer.templates.pods

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.{ EitherValues, OptionValues }
import preview.{ TemplateParams2, TemplateParams3 }
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PODS
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader }

class PsaRegisteredCompanySpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "pods_psa_register_company" should {

    val params = commonParameters ++ TemplateParams2.exampleParams
      .getOrElse("pods_psa_register_company", Map.empty) ++ TemplateParams3.exampleParams
      .getOrElse("pods_psa_register_company", Map.empty)
    val templateRegisterCompany: MessageTemplate = MessageTemplate.create(
      templateId = "pods_psa_register_company",
      fromAddress = "HMRC paperless norepoy@tax.service.gov.uk",
      service = PODS,
      subject = s"${params("psaName")} has registered as a pension scheme administrator",
      plainTemplate = txt.psaRegisteredCompany.f,
      htmlTemplate = html.psaRegisteredCompany.f,
      priority = Some(MessagePriority.Standard)
    )

    "have the correct subject" in {
      templateRegisterCompany
        .subject(params) shouldBe s"${params("psaName")} has registered as a pension scheme administrator"
    }

    "have the correct body content" in {

      templateRegisterCompany
        .subject(params) shouldBe s"${params("psaName")} has registered as a pension scheme administrator"
      val htmlContent = templateRegisterCompany.htmlTemplate(params).toString
      htmlContent should include("Pension scheme administrator registration successful")
      htmlContent should include(s"Dear ${params("psaName")}")
      htmlContent should include(
        s"You have successfully registered ${params("psaName")} as a pension scheme administrator on the Managing Pension Schemes service."
      )
      htmlContent should include(s"The administrator ID for ${params("psaName")} has not changed.")
      htmlContent should include(
        "The pension scheme administrator can now manage pension schemes by applying to register a new pension scheme. " +
          "To do this search for ‘apply to register a pension scheme’ on GOV.UK and then choose to use the online service."
      )
      htmlContent should include(
        "They can also be invited to be a pension scheme administrator for an existing pension scheme."
      )
      htmlContent should include("For security reasons, we have not included a link with this email.")
      htmlContent should include("From HMRC Pension Schemes Services")
    }

  }
}
