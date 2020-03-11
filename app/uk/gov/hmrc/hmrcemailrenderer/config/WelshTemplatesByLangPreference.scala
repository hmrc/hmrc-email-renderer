/*
 * Copyright 2020 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.config

object WelshTemplatesByLangPreference {
  val list = Map(
    "changeOfEmailAddress" -> "changeOfEmailAddress_cy",
    "verifyEmailAddress" -> "verifyEmailAddress_cy",
    "digitalOptOutConfirmation" -> "digitalOptOutConfirmation_cy",
    "changeOfEmailAddressNewAddress" -> "changeOfEmailAddressNewAddress_cy",
    "newMessageAlert" -> "newMessageAlert_cy",
    "rescindedMessageAlert" -> "rescindedMessageAlert_cy",
    "verificationReminder" -> "verificationReminder_cy",
    "annual_tax_summaries_message_alert" -> "tax_estimate_message_alert_cy",
    "annual_tax_summaries_message_alert" -> "annual_tax_summaries_message_alert_cy"
  )
}
