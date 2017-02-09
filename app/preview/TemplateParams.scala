/*
 * Copyright 2017 HM Revenue & Customs
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

import java.util.UUID

object TemplateParams {
  val exampleLinkWithRandomId = s"http://host:8080/your/link/${UUID.randomUUID}"

  val newMessageAlert_Names = Map(
    "recipientName_title" -> "Mr",
    "recipientName_forename" -> "Rich",
    "recipientName_secondForename" -> "The Cat",
    "recipientName_surname" -> "Johnston",
    "recipientName_honours" -> "PA"
  )

  val testServiceUpdate = "[Service Name]"

  val exampleParams = Map(
    "apiDeveloperEmailVerification" -> Map(
      "verificationLink" -> exampleLinkWithRandomId,
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiDeveloperPasswordReset" -> Map(
      "resetPasswordLink" -> exampleLinkWithRandomId,
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiDeveloperChangedPasswordConfirmation" -> Map(
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiAddedRegisteredDeveloperAsCollaboratorConfirmation" -> Map(
      "role" -> "admin",
      "applicationName" -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation" -> Map(
      "role" -> "admin",
      "applicationName" -> "Test Application",
      "developerHubLink" -> exampleLinkWithRandomId,
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiAddedDeveloperAsCollaboratorNotification" -> Map(
      "email" -> "joe.bloggs@gmail.com",
      "role" -> "admin",
      "applicationName" -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiRemovedCollaboratorConfirmation" -> Map(
      "applicationName" -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiRemovedCollaboratorNotification" -> Map(
      "email" -> "joe.bloggs@gmail.com",
      "applicationName" -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiApplicationApprovedGatekeeperConfirmation" -> Map(
      "email" -> "joe.bloggs@gmail.com",
      "applicationName" -> "Test Application"
    ),
    "apiApplicationApprovedAdminConfirmation" -> Map(
      "developerHubLink" -> exampleLinkWithRandomId,
      "applicationName" -> "Test Application"
    ),
    "apiApplicationApprovedNotification" -> Map(
      "applicationName" -> "Test Application"
    ),
    "apiApplicationRejectedNotification" -> Map(
      "applicationName" -> "Test Application",
      "guidelinesUrl" -> exampleLinkWithRandomId,
      "reason" -> "The name is too similar to an existing app."
    ),
    "changeOfEmailAddressNewAddress" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "newMessageAlert" -> newMessageAlert_Names,
    "rescindedMessageAlert" -> newMessageAlert_Names,
    "newMessageAlert_SA300" -> newMessageAlert_Names,
    "newMessageAlert_SS300" -> newMessageAlert_Names,

    "newMessageAlert_SA316" -> (Map(
      "isCurrentYear" -> "true",
      "taxYearStart" -> "2014",
      "taxYearEnd" -> "2015",
      "paperDeadline" -> "2014-10-31",
      "onlineDeadline" -> "2015-01-31"
    ) ++ newMessageAlert_Names),

    "newMessageAlert_SA309" -> newMessageAlert_Names,

    "verificationReminder" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "verifyEmailAddress" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "awrs_notification_template_reg_change" -> Map(
      "name" -> "Mr Joe Bloggs"
    ),
    "awrs_notification_template_app_change" -> Map(
      "name" -> "Mr Joe Bloggs"
    ),
    "awrs_notification_template_comfirmation_api4" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api4_new_business" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6_pending" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6_new_business" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6_new_business_pending" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "tamc_confirmation_template_id" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_confirmation_pta" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_update_cancel" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_update_reject" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_update_divorce_transferor_boy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_update_divorce_recipient_eoy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_current_year" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_retro_year" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_current_retro_year" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_transferor_divorce_previous_yr" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_recipient_divorce_previous_yr" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "endDate" -> "5 April 2016"
    ),
    "tamc_transferor_divorce_current_yr" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_recipient_rejects_retro_yr" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_update_cancel_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_update_reject_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_update_divorce_transferor_boy_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_update_divorce_recipient_eoy_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_current_year_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_retro_year_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_current_retro_year_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_transferor_divorce_previous_yr_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_recipient_divorce_previous_yr_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "endDate" -> "5 April 2016"
    ),
    "tamc_transferor_divorce_current_yr_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017"
    ),
    "tamc_recipient_rejects_retro_yr_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "dfs_submission_success_r39_2015" -> Map(
      "name" -> "Mr Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_cis_2015" -> Map(
      "name" -> "Mr Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_sptu_2015" -> Map(
      "name" -> "Mr Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_generic_2015" -> Map(
      "subject" -> "Test Subject",
      "greeting" -> "Mr Joe Bloggs",
      "confirmation" -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo" -> "If you’re not entitled to a refund we will write and explain the reason why",
      "warningInformation" -> "true",
      "turnAroundTime" -> "35 days"
    ),
    "dfs_submission_success_empty_turn_around_time_2015" -> Map(
      "subject" -> "Test Subject",
      "greeting" -> "Mr Joe Bloggs",
      "confirmation" -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo" -> "If you’re not entitled to a refund we will write and explain the reason why",
      "warningInformation" -> "true"
    ),
    "generic_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "cato_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agents_access_invitation_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agents_opt_in_exclude_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agents_opt_in_rejoin_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "tamc_access_invitation_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "cc_registration_email" -> Map(
      "name" -> "Mr Joe Bloggs"
    ),
    "tax_estimate_message_alert" -> Map(
      "fullName" -> "Mr Joe Bloggs"
    ),
    "fandf_ask_help_notification" -> Map(
      "helperLastName" -> "Bloggs",
      "helperFirstName" -> "Joe",
      "helpeeLastName" -> "Densmore",
      "helpeeFirstName" -> "John"
    ),
    "fandf_offer_help_notification" -> Map(
      "helperLastName" -> "Bloggs",
      "helperFirstName" -> "Joe",
      "helpeeLastName" -> "Densmore",
      "helpeeFirstName" -> "John"
    ),
    "tcs_renewal_confirmation" -> Map(
      "renewalReference" -> "123 456 789 123 456",
      "startDate" -> "6 April 2016",
      "endDate" -> "5 April 2017",
      "noticeDate" -> "21 October 2016"
    ),
    "iht_access_invitation_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "gmp_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "gmp_bulk_upload_received" -> Map(
      "fileUploadReference" -> "Reference1234"
    ),
    "gmp_bulk_upload_processed" -> Map(
      "fileUploadReference" -> "Reference1234",
      "uploadDate" -> "10 February 2016",
      "userId" -> "*****123"
    ),
    "rald_alert" -> Map(
      "referenceNumber" -> "Reference number: 9999000666",
      "postcode" -> "Postcode: BN12 4AX",
      "expiryDate" -> "We will delete any unsubmitted information on 28 July 2016"
    ),
    "bars_alert" -> Map(
      "baRefNumber" -> "BA : ba5090",
      "fileName" -> "File name : Barnet_CT.xml",
      "dateSubmitted" -> "Date Submitted : 2016-08-09T14:02:09.747+01:00",
      "errorList" -> "Brap Brap"
    ),
    "register_your_company_verification_email" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "register_your_company_welcome_email" -> Map(
      "returnLink" -> "http://registeryourcompany.gov.uk"
    ),
    "annual_tax_summaries_message_alert" -> (newMessageAlert_Names + ("taxYear" -> "2014-15")),
    "indefensible_upgrades" -> (newMessageAlert_Names),
    "indefensible_upgrades_with_dates" -> (newMessageAlert_Names),

    "client_approves_mandate" -> Map(
      "service" -> testServiceUpdate
    ),
    "agent_activates_mandate" -> Map(
      "service" -> testServiceUpdate
    ),
    "agent_rejects_mandate" -> Map(
      "service" -> testServiceUpdate
    ),
    "agent_removes_mandate" -> Map(
      "service" -> testServiceUpdate
    ),
    "client_removes_mandate" -> Map(
      "service" -> testServiceUpdate
    ),
    "client_cancels_active_mandate" -> Map(
      "service" -> testServiceUpdate
    ),
    "offpayroll_private_beta_invitation" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "gg_userid_notification" -> Map(
      "user_id" -> "914657894302",
      "full_name" -> "Joe Bloggs"
    ),
    "customs_declaration_success" -> Map(
      "details" -> "declaration success details will appear here"
    ),
    "customs_payment_required" -> Map(
      "details" -> "payment required details will appear here"
    ),
    "customs_payment_success" -> Map(
      "details" -> "payment success details will appear here"
    ),
    "customs_validation_success" -> Map(
      "details" -> "validation success details will appear here"
    )
  )
}
