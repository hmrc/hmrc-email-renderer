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
      val registrationSubmittedParams = commonParameters ++ Map(
        "name"                     -> "John Doe",
        "eclRegistrationReference" -> "XMECL0000000001",
        "eclRegistrationDate"      -> "20 September 2023",
        "dateDue"                  -> "30 September 2023",
        "isPrimaryContact"         -> "true",
        "secondContactEmail"       -> "joe.smith@test.com",
        "previousFY"               -> "2022",
        "currentFY"                -> "2023"
      )

      compareContent("ecl_registration_submitted", registrationSubmittedParams)(ecl)
    }

    "include registration submitted content cy" in {
      val registrationSubmittedParams = commonParameters ++ Map(
        "name"                     -> "John Doe",
        "eclRegistrationReference" -> "XMECL0000000001",
        "eclRegistrationDate"      -> "20 September 2023",
        "dateDue"                  -> "30 September 2023",
        "isPrimaryContact"         -> "true",
        "secondContactEmail"       -> "joe.smith@test.com",
        "previousFY"               -> "2022",
        "currentFY"                -> "2023"
      )

      compareContent("ecl_registration_submitted_cy", registrationSubmittedParams, isWelsh = true)(ecl)
    }

    "include registration received content" in {
      val registrationSubmittedParams = commonParameters + (
        "name" -> "John Doe"
      )

      compareContent("ecl_registration_received", registrationSubmittedParams)(ecl)
    }

    "include registration received content cy" in {
      val registrationSubmittedParams = commonParameters + (
        "name" -> "John Doe"
      )

      compareContent("ecl_registration_received_cy", registrationSubmittedParams, isWelsh = true)(ecl)
    }

    "include return submitted content" in {
      val returnSubmittedParams = commonParameters ++ Map(
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

    "include return submitted content cy" in {
      val returnSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 Medi 2023",
        "periodStartDate" -> "1 Ebrill 2022",
        "periodEndDate"   -> "31 Mawrth 2023",
        "chargeReference" -> "XY007000075424",
        "fyStartYear"     -> "2022",
        "fyEndYear"       -> "2023",
        "datePaymentDue"  -> "30 Medi 2023",
        "amountDue"       -> "£10,000"
      )

      compareContent("ecl_return_submitted_cy", returnSubmittedParams, isWelsh = true)(ecl)
    }

    "include nil return submitted content" in {
      val nilReturnSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "periodStartDate" -> "1 April 2022",
        "periodEndDate"   -> "31 March 2023",
        "fyStartYear"     -> "2022",
        "fyEndYear"       -> "2023",
        "amountDue"       -> "£0"
      )

      compareContent("ecl_nil_return_submitted", nilReturnSubmittedParams)(ecl)
    }

    "include nil return submitted content cy" in {
      val nilReturnSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 Medi 2023",
        "periodStartDate" -> "1 Ebrill 2022",
        "periodEndDate"   -> "31 Mawrth 2023",
        "fyStartYear"     -> "2022",
        "fyEndYear"       -> "2023",
        "amountDue"       -> "£0"
      )

      compareContent("ecl_nil_return_submitted_cy", nilReturnSubmittedParams, isWelsh = true)(ecl)
    }

    "include amend registration submitted content when no address is present" in {
      val amendRegistrationSubmittedParams = commonParameters ++ Map(
        "name"          -> "John Doe",
        "dateSubmitted" -> "1 September 2023"
      )

      compareContent("ecl_amend_registration_submitted", amendRegistrationSubmittedParams)(ecl)
    }

    "include amend registration submitted content when no address is present in Welsh" in {
      val amendRegistrationSubmittedParams = commonParameters ++ Map(
        "name"          -> "John Doe",
        "dateSubmitted" -> "1 September 2023"
      )

      compareContent("ecl_amend_registration_submitted_cy", amendRegistrationSubmittedParams, isWelsh = true)(ecl)
    }

    "include amend registration submitted content when an address is present" in {
      val amendRegistrationSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "addressLine1"    -> "testLine1",
        "addressLine2"    -> "testLine2",
        "addressLine3"    -> "testLine3",
        "addressLine4"    -> "testLine4",
        "containsAddress" -> "true"
      )

      compareContent("ecl_amend_registration_submitted", amendRegistrationSubmittedParams)(ecl)
    }

    "include amend registration submitted content when an address is present in Welsh" in {
      val amendRegistrationSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "addressLine1"    -> "testLine1",
        "addressLine2"    -> "testLine2",
        "addressLine3"    -> "testLine3",
        "addressLine4"    -> "testLine4",
        "containsAddress" -> "true"
      )

      compareContent("ecl_amend_registration_submitted_cy", amendRegistrationSubmittedParams, isWelsh = true)(ecl)
    }

    "include amend return submitted content when no address is present" in {
      val amendReturnSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "periodStartDate" -> "1 April 2022",
        "periodEndDate"   -> "31 March 2023"
      )

      compareContent("ecl_amend_return_submitted", amendReturnSubmittedParams)(ecl)
    }

    "include amend return submitted content when no address is present in Welsh" in {
      val amendReturnSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "periodStartDate" -> "1 April 2022",
        "periodEndDate"   -> "31 March 2023"
      )

      compareContent("ecl_amend_return_submitted_cy", amendReturnSubmittedParams, isWelsh = true)(ecl)
    }

    "include amend returns submitted content when an address is present" in {
      val amendReturnSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "periodStartDate" -> "1 April 2022",
        "periodEndDate"   -> "31 March 2023",
        "addressLine1"    -> "testLine1",
        "addressLine2"    -> "testLine2",
        "addressLine3"    -> "testLine3",
        "addressLine4"    -> "testLine4",
        "containsAddress" -> "true"
      )

      compareContent("ecl_amend_return_submitted", amendReturnSubmittedParams)(ecl)
    }

    "include amend returns submitted content when an address is present in Welsh" in {
      val amendReturnSubmittedParams = commonParameters ++ Map(
        "name"            -> "John Doe",
        "dateSubmitted"   -> "1 September 2023",
        "periodStartDate" -> "1 April 2022",
        "periodEndDate"   -> "31 March 2023",
        "addressLine1"    -> "testLine1",
        "addressLine2"    -> "testLine2",
        "addressLine3"    -> "testLine3",
        "addressLine4"    -> "testLine4",
        "containsAddress" -> "true"
      )

      compareContent("ecl_amend_return_submitted_cy", amendReturnSubmittedParams, isWelsh = true)(ecl)
    }
  }
}
