/*
 * Copyright 2018 HM Revenue & Customs
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
    "newMessageAlert_TAVC" -> newMessageAlert_Names,

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
    "awrs_notification_template_cancellation_api10" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016",
      "deregistrationDate" -> "23 April 2017"
    ),
    "awrs_notification_template_withdrawn_api8" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate" -> "12 March 2016"
    ),
    "awrs_email_verification" -> Map(
      "verificationLink" -> "http://host:8080/your/link/d2cbc3df-1895-45c8-9e22-1e79a087ad78"
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
    "dfs_submission_success_generic_2017" -> Map(
      "subject" -> "Test Subject",
      "greeting" -> "Mr Joe Bloggs",
      "confirmation" -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo" -> "If you’re not entitled to a refund we will write and explain the reason why",
      "paragraphThree" -> "Some extra content for paragraph three...",
      "warningInformation" -> "false",
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
    "dfs_admin_notification" -> Map.empty[String,String],
    "generic_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "dfs_trusts_submission_success" -> Map(
      "subject" -> "Trust/Estate email confirmation",
      "greeting" -> "Mr Joe Bloggs",
      "confirmation" -> "HM Revenue and Customs (HMRC) has received your registration of a trust",
      "submissionReference" -> "XWTRN0000000875",
      "paragraphOne" -> "There is no need to call us, we will contact you if we need any more information",
      "warningInformation" -> "false",
      "turnAroundTime" -> "15 days"
    ),
    "cato_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agents_access_invitation_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "cbcr_subscription" -> Map(
      "f_name" -> "Tyrion",
      "s_name" -> "Lannister",
      "cbcrId" -> "XGCBC0000000001"
    ),
    "cbcr_report_confirmation" -> Map(
      "name" -> "Tyrion Lannister",
      "received_at" -> "31 December 2017",
      "hash" -> "6753c4e3bf192b0f9881ceb2d822a75e1b618269fbdb44112d35a10b1987f6"
    ),
     "cbcr_cbcid_regeneration" -> Map(
      "f_name" -> "Tyrion",
      "s_name" -> "Lannister",
      "received_at" -> "31 December 2017",
      "cbcrId" -> "XGCBC0000000001"
    ),
   "agent_mapping_invitation_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agent_subscription_invitation_template_id" -> Map(
      "name" -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agent_fi_invitation_template_id" -> Map(
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
      "awardStartDate" -> "6 April 2016",
      "awardEndDate" -> "10 January 2017",
      "customerFName" -> "Tom",
      "renewalReference" -> "123 456 789 123 456",
      "startDate" -> "6 April 2017",
      "endDate" -> "5 April 2018",
      "noticeDate" -> "7 July 2017",
      "incompleteClaims" -> "2",
      "anyEstimates" -> "3"
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
    "investment_tax_relief_verification_email" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "investment_tax_relief_confirmation_email" -> Map(
      "companyName" -> "Test company name",
      "date" -> "09-09-2999",
      "formBundleRefNumber" -> "XAFORMBUNDLEREF"
    ),
    "investment_tax_relief_no_docs_confirmation_email" -> Map(
      "companyName" -> "Test company name",
      "date" -> "09-09-2999",
      "formBundleRefNumber" -> "XAFORMBUNDLEREF"
    ),
    "annual_tax_summaries_message_alert" -> (newMessageAlert_Names + ("taxYear" -> "2014-15")),
    "indefensible_upgrades" -> newMessageAlert_Names,
    "indefensible_upgrades_with_dates" -> newMessageAlert_Names,

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
    "agent_self_auth_activates_mandate" -> Map(
      "service" -> testServiceUpdate
    ),
    "agent_self_auth_deactivates_mandate" -> Map(
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
    "2SV_reset_confirmation" -> Map(
      "full_name" -> "Joe Bloggs"
    ),
    "password_change_confirmation" -> Map(
      "full_name" -> "Joe Bloggs"
    ),
    "customs_registration_successful" -> Map(
      "recipientName_forename" -> "Firstname",
      "recipientName_surname" -> "Lastname"
    ),
    "customs_registration_not_successful" -> Map(
      "recipientName_forename" -> "Firstname",
      "recipientName_surname" -> "Lastname"
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
    ),
    "transactionEngineHMRCSASA100Success" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA100Failure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTSuccess" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTFailure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTTILSuccess" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTTILFailure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA100TILSuccess" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA100TILFailure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier" -> "1234567890",
      "subject" -> "subject"
    ),
    "transactionEngineECSLORGV101Success" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineECSLORGV101Failure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRAACTSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRAACTFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRAAPAYESuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRAAPAYEFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRAASASuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRAASAFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRCISCIS300MRSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRCISCIS300MRFailure" -> Map(
      "errorType" -> "business",
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber" -> "1001",
      "errorMessage" -> "Fatal Error Message"
    ),
    "transactionEngineIRCISVERIFYSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRCISVERIFYFailure" -> Map(
      "errorType" -> "business",
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber" -> "1001",
      "errorMessage" -> "Fatal Error Message"
    ),
    "transactionEngineIRCTFANNUALRETURNSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRCTFANNUALRETURNFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEEOYSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEEOYFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEEOYTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEEOYTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEEXBSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEEXBFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEMOVSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEMOVFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEMOVTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEMOVTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEP38ASuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEP38AFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEUPDATESuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRPAYEUPDATEFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRSDLTLTRSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineIRSDLTLTRFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAACCTTAXSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAACCTTAXFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAADDSCHASuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAADDSCHAFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAAMDDETSSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAAMDDETSFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAASSCSASuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAASSCSAFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSACOMBINEDREGSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSACOMBINEDREGFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAEVNTREPSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAEVNTREPFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAMAINTSCMSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAMAINTSCMFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSARASSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSARASFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAREGSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAREGFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSARETSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSARETFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAPRACAUTHSuccess" -> Map(
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAPRACAUTHFailure" -> Map(
      "errorType" -> "business",
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber" -> "1001",
      "errorMessage" -> "Fatal Error Message"
    ),
    "transactionEngineHMRCPSAPRACDEAUTHSuccess" -> Map(
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPSAPRACDEAUTHFailure" -> Map(
      "errorType" -> "business",
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber" -> "1001",
      "errorMessage" -> "Fatal Error Message"
    ),
    "transactionEngineHMRCSASA800ATTSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA800ATTFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA800TILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA800TILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA800ATTTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA800ATTTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA800Success" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA800Failure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900TILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900TILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900Success" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCSASA900Failure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMCENESEDIFACTSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMCENESEDIFACTFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCVATDECSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCVATDECFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCVATDECTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCVATDECTILFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCCTCT600Success" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCCTCT600Failure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCCTCT600TILSuccess" -> Map(
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCCTCT600TILFailure" -> Map(
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject", "errorType" -> "business",
      "errorTextBlock" -> "<p>Error Code: 123 Error Message: An Error</p>"
    ),
    "transactionEngineHMRCCTCT600TILFailure" -> Map(
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorType" -> "fatal",
      "errorNumber" -> "123", "errorMessage" -> "This is an error"
    ),
    "transactionEngineHMRCPPACCTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPAMDFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPEVNTFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPEVNTFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPEVNTSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPMAINTFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPPRACSuccess" -> Map(
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPPRACFailure" -> Map(
      "errorType" -> "business",
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber" -> "1001",
      "errorMessage" -> "Fatal Error Message"
    ),
    "transactionEngineHMRCPPRETFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPRETSuccess" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineCHARCLMSuccess" -> Map(
      "receivedTime" -> "09:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineCHARCLMFailure" -> Map(
      "errorType" -> "business",
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber" -> "1001",
      "errorMessage" -> "Fatal Error Message"
    ),
    "transactionEngineCHARCLMMULTIFailure" -> Map(
      "errorType" -> "business",
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber" -> "1001",
      "errorMessage" -> "Fatal Error Message"
    ),
    "transactionEngineCHARCLMMULTISuccess" -> Map(
      "receivedTime" -> "21:45", "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "transactionEngineHMRCPPRASFailure" -> Map(
      "receivedDate" -> "20 April 2017", "identifier" -> "12345",
      "subject" -> "subject"
    ),
    "chargeable_return_submit" -> Map(
      "company_name" -> "Acme Limited",
      "date" -> "23 September 2017"
    ),
    "relief_return_submit" -> Map(
      "company_name" -> "Acme Limited",
      "date" -> "23 September 2017",
      "reference" -> "1234567890"
    ),
    "amended_return_submit" -> Map(
      "company_name" -> "Acme Limited",
      "date" -> "23 September 2017"
    ),
    "further_return_submit" -> Map(
      "company_name" -> "Acme Limited",
      "date" -> "23 September 2017"
    ),
    "change_details_return_submit" -> Map(
      "company_name" -> "Acme Limited",
      "date" -> "23 September 2017"
    ),
    "disposal_return_submit" -> Map(
      "company_name" -> "Acme Limited",
      "date" -> "23 September 2017"
    ),
    "lisa_application_submit" -> Map(
      "application_reference" -> "ABC1234567890",
      "email" -> "lisaTest@test.com"
    ),
    "emac_helpdesk_failure_confirmation_email" -> Map(
      "service_name" -> "Self Assessment (SA)",
      "full_name" -> "Troy Barnes",
      "correlation_id" -> "H5JK4ITURY84783HJ345HJ345HJ342N3"
    ),
    "emac_helpdesk_successful_confirmation_email" -> Map(
      "service_name" -> "Alcohol and Tobacco Warehousing Declarations (ATWD)",
      "full_name" -> "Abed Nadir",
      "correlation_id" -> "HJ345HJ345HJ342N3H5JK4ITURY84783"
    ),
    "eeitt_submission_confirmation" -> Map(
      "" -> ""
    ),
    "fhdds_submission_confirmation" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "payment_successful" -> Map("taxType" -> "Self Assessment",
      "taxReference" -> "1234567890K",
      "paymentReference" -> "4f3e3db2-c8e1-4db0-86ae-000bc992faa8",
      "amountPaid" -> "123.45",
      "commission" -> "2.55",
      "totalPaid" -> "126.00"
    ),
    "hts_verification_email" -> Map(
      "name" -> "Joe",
      "verificationLink" -> exampleLinkWithRandomId
    )
  )
}
