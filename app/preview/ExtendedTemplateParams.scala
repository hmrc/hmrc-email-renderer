/*
 * Copyright 2022 HM Revenue & Customs
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

package preview

object ExtendedTemplateParams {
  val exampleParams = Map(
    "oss_registration_confirmation" -> Map(
      "recipientName_line1"  -> "Joe Bloggs",
      "businessName"         -> "Test Business",
      "periodOfFirstReturn"  -> "July to September 2021",
      "firstDayOfNextPeriod" -> "1 October 2021",
      "commencementDate"     -> "12 June 2021",
      "redirectLink"         -> "http://test.com/blah-blah"
    ),
    "oss_returns_email_confirmation" -> Map(
      "recipientName_line1" -> "Joe Bloggs",
      "businessName"        -> "Test Business",
      "period"              -> "1 July to 30 September 2021",
      "paymentDeadline"     -> "31 October 2021"
    ),
    "oss_returns_email_confirmation_no_vat_owed" -> Map(
      "recipientName_line1" -> "Joe Bloggs",
      "period"              -> "1 July to 30 September 2021"
    ),
    "oss_overdue_returns_email_confirmation" -> Map(
      "recipientName_line1" -> "Joe Bloggs",
      "businessName"        -> "Test Business",
      "period"              -> "1 July to 30 September 2021",
      "paymentDeadline"     -> "31 October 2021"
    ),
    "pods_psa_amend" -> Map(
      "psaName" -> "Jane Doe"
    ),
    "hec_tax_check_code" -> Map(
      "currentDate"     -> "13 January 2022",
      "licenceType"     -> "Driver of taxis and private hires",
      "hecTaxCheckCode" -> "FK9 BRG 2JJ",
      "expiresAfter"    -> "13 May 2022"
    ),
    "hec_tax_check_code_cy" -> Map(
      "currentDate"     -> "13 Ionawr 2022",
      "licenceType"     -> "Gyrrwr tacsis a cherbydau hurio preifat",
      "hecTaxCheckCode" -> "FK9 BRG 2JJ",
      "expiresAfter"    -> "13 Mai 2022"
    ),
    "create_undertaking_email_to_lead" -> Map(
      "eori"            -> "GB123456789012",
      "undertakingName" -> "Test Undertaking"
    ),
    "undertaking_member_added_email_to_be" -> Map(
      "eori"            -> "GB123456789010",
      "undertakingName" -> "Test Undertaking"
    ),
    "undertaking_member_added_email_to_lead" -> Map(
      "eori"            -> "GB123456789012",
      "beEORI"          -> "GB123456789010",
      "undertakingName" -> "Test Undertaking"
    ),
    "undertaking_member_removed_email_to_lead" -> Map(
      "eori"            -> "GB123456789012",
      "beEORI"          -> "GB123456789010",
      "undertakingName" -> "Test Undertaking",
      "effectiveDate"   -> "27 January 2022"
    ),
    "undertaking_member_removed_email_to_be" -> Map(
      "eori"            -> "GB123456789012",
      "undertakingName" -> "Test Undertaking",
      "effectiveDate"   -> "27 January 2022"
    ),
    "promoted_other_as_lead_email_to_be" -> Map(
      "eori"            -> "GB123456789010",
      "undertakingName" -> "Test Undertaking"
    ),
    "promoted_other_as_lead_email_to_lead" -> Map(
      "eori"            -> "GB123456789012",
      "beEORI"          -> "GB123456789010",
      "undertakingName" -> "Test Undertaking"
    ),
    "member_remove_themself_email_to_lead" -> Map(
      "eori"            -> "GB123456789012",
      "undertakingName" -> "Test Undertaking",
      "effectiveDate"   -> "27 January 2022"
    ),
    "member_remove_themself_email_to_be" -> Map(
      "eori"            -> "GB123456789010",
      "undertakingName" -> "Test Undertaking",
      "effectiveDate"   -> "27 January 2022"
    ),
    "promoted_themself_as_lead_email_to_lead" -> Map(
      "eori"            -> "GB123456789010",
      "undertakingName" -> "Test Undertaking",
      "undertakingRef"  -> "UID0001234"
    ),
    "removed_as_lead_email_to_previous_lead" -> Map(
      "eori"            -> "GB123456789010",
      "undertakingName" -> "Test Undertaking"
    ),
    "disabled_undertaking_email_to_lead" -> Map(
      "eori"            -> "GB123456789010",
      "undertakingName" -> "Test Undertaking",
      "effectiveDate"   -> "27 January 2022"
    ),
    "disabled_undertaking_email_to_be" -> Map(
      "eori"            -> "GB123456789010",
      "undertakingName" -> "Test Undertaking",
      "effectiveDate"   -> "27 January 2022"
    )
  )
}
