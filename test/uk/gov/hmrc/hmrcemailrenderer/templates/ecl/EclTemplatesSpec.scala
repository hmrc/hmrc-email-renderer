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

package uk.gov.hmrc.hmrcemailrenderer.templates.ecl

import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class EclTemplatesSpec extends TemplateComparisonSpec with CommonParamsForSpec {

  private def ecl(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(EclTemplates.templates)

  "Templates for which the text and html content are identical" should {

    "include registration submitted content" in {
      val registrationSubmittedParams = commonParameters + (
        "name"                     -> "John Doe",
        "eclRegistrationReference" -> "XMECL0000000001",
        "eclRegistrationDate"      -> "20 September 2023",
        "dateDue"                  -> "30 September 2023",
        "isPrimaryContact"         -> "true",
        "secondContactEmail"       -> "joe.smith@test.com",
        "privateBetaEnabled"       -> "true"
      )

      compareContent("ecl_registration_submitted", registrationSubmittedParams)(ecl)
    }

    "include return submitted content" in {
      val returnSubmittedParams = commonParameters + (
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "periodStartDate" -> "1 April 2022",
        "periodEndDate"   -> "31 March 2023",
        "chargeReference" -> "XY007000075424",
        "fyStartYear"     -> "2022",
        "fyEndYear"       -> "2023",
        "datePaymentDue"  -> "30 September 2023",
        "amountDue"       -> "£10,000"
      )

      compareContent("ecl_return_submitted", returnSubmittedParams)(ecl)
    }

  }

}
