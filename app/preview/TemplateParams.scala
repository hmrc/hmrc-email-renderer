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

package preview

import java.util.{ Base64, UUID }
import play.api.libs.json.Json.{ parse, stringify }
import preview.TemplateParams.newMessageAlert_Names

object TemplateParams {
  val exampleLinkWithRandomId = s"http://host:8080/your/link/${UUID.randomUUID}"

  val newMessageAlert_Names = Map(
    "recipientName_title"          -> "Mr",
    "recipientName_forename"       -> "Rich",
    "recipientName_secondForename" -> "The Cat",
    "recipientName_surname"        -> "Johnston",
    "recipientName_honours"        -> "PA"
  )

  val testServiceUpdate = "[Service Name]"

  val exampleParams = Map(
    "aeo_mra_row_data_exchange_report" -> Map(
      "country_rows" -> Base64.getEncoder.encodeToString(stringify(
        parse("""
          [
            {"sendingCountry": "JP", "receivingCountry": "GB", "status": "MRA-AEO data received", "dateTime": "2021-05-04T11:16:49.938044Z"},
            {"sendingCountry": "JP", "receivingCountry": "GB", "status": "MRA-AEO data received", "dateTime": "2021-05-04T11:17:49.938044Z"},
            {"sendingCountry": "JP", "receivingCountry": "GB", "status": "MRA-AEO data received", "dateTime": "2021-05-04T11:18:49.938044Z"}
          ]
          """)).getBytes("UTF-8"))
    ),
    "email_verification_passcode" -> Map(
      "passcode"  -> "NVFYRY",
      "team_name" -> "Government Gateway"
    ),
    "email_verification_passcode_welsh" -> Map(
      "passcode"  -> "NVFYRY",
      "team_name" -> "Government Gateway"
    ),
    "overseas_application_rejected" -> Map(
      "tradingName"    -> "ABC Accountants Ltd",
      "reason1"        -> "We could not confirm your money laundering supervisory body",
      "reason2"        -> "We could not confirm your identity",
      "reason3"        -> "We could not confirm your business address",
      "otherReason"    -> "We had other reasons that are given here",
      "additionalText" -> "Additional text goes here."
    ),
    "overseas_application_accepted" -> Map(
      "tradingName" -> "ABC Accountants Ltd"
    ),
    "overseas_application_received" -> Map(
      "tradingName"  -> "ABC Accountants Ltd",
      "receivedDate" -> "20190214"
    ),
    "client_rejected_authorisation_request" -> Map(
      "agencyName" -> "Agent 1",
      "clientName" -> "Client 2",
      "service"    -> "submit their VAT returns through software."
    ),
    "client_accepted_authorisation_request" -> Map(
      "agencyName"     -> "Agent 1",
      "clientName"     -> "Client 2",
      "service"        -> "Your client Client 2 has authorised you to manage their Income Tax.",
      "additionalInfo" -> "You now have 4 months to sign Client 2 up to Making Tax Digital for Income Tax."
    ),
    "client_expired_authorisation_request" -> Map(
      "agencyName" -> "Agent 1",
      "clientName" -> "Client 2",
      "expiryDate" -> "1 October 2020",
      "service"    -> "send their Income Tax updates through software."
    ),
    "agent_services_account_created" -> Map(
      "agencyName" -> "Agent 1",
      "arn"        -> "XARN 123 4567"
    ),
    "agent_services_account_created_cy" -> Map(
      "agencyName" -> "Agent 1",
      "arn"        -> "XARN 123 4567"
    ),
    "agent_invitations_about_to_expire" -> Map(
      "agencyName"          -> "My Tax Agency",
      "numberOfInvitations" -> "22",
      "createdDate"         -> "22 March 2021",
      "expiryDate"          -> "4 April 2021"
    ),
    "agent_invitation_about_to_expire_single" -> Map(
      "agencyName"  -> "My Tax Agency",
      "createdDate" -> "22 March 2021",
      "expiryDate"  -> "4 April 2021"
    ),
    "apiDeveloperEmailVerification" -> Map(
      "verificationLink"  -> exampleLinkWithRandomId,
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
      "role"              -> "admin",
      "applicationName"   -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation" -> Map(
      "role"              -> "admin",
      "applicationName"   -> "Test Application",
      "developerHubLink"  -> exampleLinkWithRandomId,
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiAddedDeveloperAsCollaboratorConfirmation" -> Map(
      "article"           -> "an",
      "role"              -> "admin",
      "applicationName"   -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiAddedDeveloperAsCollaboratorNotification" -> Map(
      "email"             -> "joe.bloggs@gmail.com",
      "role"              -> "admin",
      "applicationName"   -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiRemovedCollaboratorConfirmation" -> Map(
      "applicationName"   -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiRemovedCollaboratorNotification" -> Map(
      "email"             -> "joe.bloggs@gmail.com",
      "applicationName"   -> "Test Application",
      "developerHubTitle" -> "Developer Hub Title"
    ),
    "apiApplicationApprovedGatekeeperConfirmation" -> Map(
      "email"           -> "joe.bloggs@gmail.com",
      "applicationName" -> "Test Application"
    ),
    "apiApplicationApprovedAdminConfirmation" -> Map(
      "developerHubLink" -> exampleLinkWithRandomId,
      "applicationName"  -> "Test Application"
    ),
    "apiApplicationApprovedNotification" -> Map(
      "applicationName" -> "Test Application"
    ),
    "apiApplicationDeletedNotification" -> Map(
      "applicationName" -> "Test Application",
      "requestor"       -> "joe.bloggs@gmail.com"
    ),
    "apiDeveloperDeletedConfirmation" -> Map(
      "applicationName" -> "Test Application",
      "requestor"       -> "joe.bloggs@gmail.com"
    ),
    "apiApplicationRejectedNotification" -> Map(
      "applicationName" -> "Test Application",
      "supportUrl"      -> exampleLinkWithRandomId,
      "reason"          -> "the name is too similar to an existing application"
    ),
    "apiStatusChangedNotification" -> Map(
      "apiName"         -> "Test Microservice",
      "apiVersion"      -> "2.0",
      "currentStatus"   -> "ALPHA",
      "newStatus"       -> "BETA",
      "environmentName" -> "Production"
    ),
    "apiAddedClientSecretNotification" -> Map(
      "actorEmailAddress"  -> "joe.bloggs@gmail.com",
      "clientSecretEnding" -> "1234",
      "environmentName"    -> "sandbox",
      "applicationName"    -> "Tax Software"
    ),
    "apiRemovedClientSecretNotification" -> Map(
      "actorEmailAddress"  -> "joe.bloggs@gmail.com",
      "clientSecretEnding" -> "1234",
      "environmentName"    -> "sandbox",
      "applicationName"    -> "Tax Software"
    ),
    "apiApplicationToBeDeletedNotification" -> Map(
      "userFirstName"           -> "Fred",
      "userLastName"            -> "Bloggs",
      "applicationName"         -> "Test Application",
      "environmentName"         -> "Sandbox",
      "timeSinceLastUse"        -> "11 months",
      "dateOfScheduledDeletion" -> "1 April 2025"
    ),
    "ppnsCallbackUrlChangedNotification" -> Map(
      "applicationName" -> "Test Application",
      "dateOfChange"    -> "28 October 2020",
      "timeOfChange"    -> "12:23"
    ),
    "changeOfEmailAddressNewAddress" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "changeOfEmailAddressNewAddress_cy" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "changeOfEmailAddress_cy" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "verifyEmailAddress_cy" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "newMessageAlert"        -> newMessageAlert_Names,
    "newMessageAlert_cy"     -> newMessageAlert_Names,
    "rescindedMessageAlert"  -> newMessageAlert_Names,
    "penaltyChargeApologies" -> newMessageAlert_Names,
    "newMessageAlert_SA300"  -> Map("recipientName_line1" -> "this is a line 1"),
    "newMessageAlert_SS300"  -> newMessageAlert_Names,
    "newMessageAlert_SA316" -> (Map(
      "isCurrentYear"  -> "true",
      "taxYearStart"   -> "2014",
      "taxYearEnd"     -> "2015",
      "paperDeadline"  -> "2014-10-31",
      "onlineDeadline" -> "2015-01-31"
    ) ++ newMessageAlert_Names),
    "newMessageAlert_SA309" -> newMessageAlert_Names,
    "newMessageAlert_VRT1214A" -> Map(
      "recipientName_line1" -> "Mr Bump"
    ),
    "newMessageAlert_VRT1214C" -> Map(
      "recipientName_line1" -> "Mrs Bump"
    ),
    "newMessageAlert_VRT12B" -> Map(
      "clientName"     -> "Tesla Limited",
      "transactorName" -> "Musk's Agent",
      "clientVrn"      -> "1234567890"
    ),
    "newMessageAlert_VRT14B" -> Map(
      "clientName"     -> "Tesla Limited",
      "transactorName" -> "Musk's Agent",
      "clientVrn"      -> "1234567890"
    ),
    "newMessageAlert_CC07C_SM11C" -> Map(
      "clientName"     -> "Tesla Limited",
      "transactorName" -> "Musk's Agent",
      "clientVrn"      -> "1234567890"
    ),
    "verificationReminder" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "verificationReminder_cy" -> Map(
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
      "organisationName"     -> "Booze Inc.",
      "submissionDate"       -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api4_new_business" -> Map(
      "organisationName"     -> "Booze Inc.",
      "submissionDate"       -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6" -> Map(
      "organisationName"     -> "Booze Inc.",
      "submissionDate"       -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6_pending" -> Map(
      "organisationName"     -> "Booze Inc.",
      "submissionDate"       -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6_new_business" -> Map(
      "organisationName"     -> "Booze Inc.",
      "submissionDate"       -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_comfirmation_api6_new_business_pending" -> Map(
      "organisationName"     -> "Booze Inc.",
      "submissionDate"       -> "12 March 2016",
      "applicationReference" -> "123456789012"
    ),
    "awrs_notification_template_cancellation_api10" -> Map(
      "organisationName"   -> "Booze Inc.",
      "submissionDate"     -> "12 March 2016",
      "deregistrationDate" -> "23 April 2017"
    ),
    "awrs_notification_template_withdrawn_api8" -> Map(
      "organisationName" -> "Booze Inc.",
      "submissionDate"   -> "12 March 2016"
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
      "endDate"   -> "5 April 2017"
    ),
    "tamc_update_reject" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_update_divorce_transferor_boy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate"   -> "5 April 2017"
    ),
    "tamc_update_divorce_recipient_eoy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate"   -> "5 April 2017"
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
      "endDate"   -> "5 April 2017"
    ),
    "tamc_recipient_divorce_previous_yr" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "endDate"   -> "5 April 2016"
    ),
    "tamc_transferor_divorce_current_yr" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate"   -> "5 April 2017"
    ),
    "tamc_recipient_rejects_retro_yr" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_update_cancel_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate"   -> "5 April 2017"
    ),
    "tamc_update_reject_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "tamc_update_divorce_transferor_boy_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate"   -> "5 April 2017"
    ),
    "tamc_update_divorce_recipient_eoy_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate"   -> "5 April 2017"
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
      "endDate"   -> "5 April 2017"
    ),
    "tamc_recipient_divorce_previous_yr_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "endDate"   -> "5 April 2016"
    ),
    "tamc_transferor_divorce_current_yr_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs",
      "startDate" -> "6 April 2016",
      "endDate"   -> "5 April 2017"
    ),
    "tamc_recipient_rejects_retro_yr_cy" -> Map(
      "full_name" -> "Mr Joe Bloggs"
    ),
    "dfs_submission_success_r39_2015" -> Map(
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_r39_2015_welsh" -> Map(
      "name"                -> "Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_cis_2015" -> Map(
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_cis_2015_welsh" -> Map(
      "name"                -> "Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_sptu_2015" -> Map(
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_sptu_2015_welsh" -> Map(
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "1234"
    ),
    "dfs_submission_success_generic_2015" -> Map(
      "subject"             -> "Test Subject",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne"        -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo"        -> "If you’re not entitled to a refund we will write and explain the reason why",
      "warningInformation"  -> "true",
      "turnAroundTime"      -> "35 days"
    ),
    "dfs_submission_success_generic_2015_welsh" -> Map(
      "subject"             -> "Test Subject",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne"        -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo"        -> "If you’re not entitled to a refund we will write and explain the reason why",
      "warningInformation"  -> "true",
      "turnAroundTime"      -> "35 days"
    ),
    "dfs_submission_success_generic_2017" -> Map(
      "subject"             -> "Test Subject",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne"        -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo"        -> "If you’re not entitled to a refund we will write and explain the reason why",
      "paragraphThree"      -> "Some extra content for paragraph three...",
      "warningInformation"  -> "false",
      "turnAroundTime"      -> "35 days"
    ),
    "dfs_submission_success_generic_2017_welsh" -> Map(
      "subject"             -> "Test Subject",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne"        -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo"        -> "If you’re not entitled to a refund we will write and explain the reason why",
      "paragraphThree"      -> "Some extra content for paragraph three...",
      "warningInformation"  -> "false",
      "turnAroundTime"      -> "35 days"
    ),
    "dfs_submission_success_empty_turn_around_time_2015" -> Map(
      "subject"             -> "Test Subject",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne"        -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo"        -> "If you’re not entitled to a refund we will write and explain the reason why",
      "warningInformation"  -> "true"
    ),
    "dfs_submission_success_empty_turn_around_time_2015_welsh" -> Map(
      "subject"             -> "Test Subject",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne"        -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo"        -> "If you’re not entitled to a refund we will write and explain the reason why",
      "warningInformation"  -> "true"
    ),
    "dfs_submission_success_empty_turn_around_time_2020" -> Map(
      "subject"             -> "Test Subject",
      "heading"             -> "Test Heading",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
      "submissionReference" -> "1234",
      "paragraphOne"        -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
      "paragraphTwo"        -> "If you’re not entitled to a refund we will write and explain the reason why",
      "paragraphThree"      -> "If you've asked us to write to you, we'll send you a letter within 15 working days",
      "paragraphFour"       -> "Some extra content for paragraph four...",
      "warningInformation"  -> "true"
    ),
    "dfs_admin_notification" -> Map.empty[String, String],
    "generic_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "dfs_trusts_submission_success" -> Map(
      "subject"             -> "Trust/Estate email confirmation",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your registration of a trust",
      "submissionReference" -> "XWTRN0000000875",
      "paragraphOne"        -> "There is no need to call us, we will contact you if we need any more information",
      "warningInformation"  -> "false",
      "turnAroundTime"      -> "15 days"
    ),
    "dfs_trusts_submission_success_welsh" -> Map(
      "subject"             -> "Trust/Estate email confirmation",
      "greeting"            -> "Mr Joe Bloggs",
      "confirmation"        -> "HM Revenue and Customs (HMRC) has received your registration of a trust",
      "submissionReference" -> "XWTRN0000000875",
      "paragraphOne"        -> "There is no need to call us, we will contact you if we need any more information",
      "warningInformation"  -> "false",
      "turnAroundTime"      -> "15 days"
    ),
    "dfs_submission_success_rcgt_2018" -> Map(
      "subject"             -> "Capital Gains Tax real time transaction return submission confirmation",
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "123-ABCD-456"
    ),
    "dfs_submission_success_rcgt_2018_welsh" -> Map(
      "subject"             -> "Capital Gains Tax real time transaction return submission confirmation",
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "123-ABCD-456"
    ),
    "dfs_submission_success_gencompsub_2021" -> Map(
      "subject"             -> "Test subject",
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "123-ABCD-456"
    ),
    "dfs_submission_success_gencompsub_2021_welsh" -> Map(
      "subject"             -> "Test Subject",
      "name"                -> "Mr Joe Bloggs",
      "submissionReference" -> "123-ABCD-456"
    ),
    "cato_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agents_access_invitation_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "cbcr_subscription" -> Map(
      "f_name" -> "Tyrion",
      "s_name" -> "Lannister",
      "cbcrId" -> "XGCBC0000000001"
    ),
    "cbcr_report_confirmation" -> Map(
      "name"        -> "Tyrion Lannister",
      "received_at" -> "31 December 2017",
      "hash"        -> "6753c4e3bf192b0f9881ceb2d822a75e1b618269fbdb44112d35a10b1987f6",
      "cbcrId"      -> "XGCBC0000000001"
    ),
    "cbcr_cbcid_regeneration" -> Map(
      "f_name"      -> "Tyrion",
      "s_name"      -> "Lannister",
      "received_at" -> "31 December 2017",
      "cbcrId"      -> "XGCBC0000000001"
    ),
    "agent_mapping_invitation_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agent_subscription_invitation_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agent_fi_invitation_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agents_opt_in_exclude_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "agents_opt_in_rejoin_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "tamc_access_invitation_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "cc_registration_email" -> Map(
      "name" -> "Mr Joe Bloggs"
    ),
    "tax_estimate_message_alert" -> Map(
      "fullName" -> "Mr Joe Bloggs"
    ),
    "tax_estimate_message_alert_cy" -> Map(
      "fullName" -> "Mr Joe Bloggs"
    ),
    "fandf_ask_help_notification" -> Map(
      "helperLastName"  -> "Bloggs",
      "helperFirstName" -> "Joe",
      "helpeeLastName"  -> "Densmore",
      "helpeeFirstName" -> "John"
    ),
    "fandf_offer_help_notification" -> Map(
      "helperLastName"  -> "Bloggs",
      "helperFirstName" -> "Joe",
      "helpeeLastName"  -> "Densmore",
      "helpeeFirstName" -> "John"
    ),
    "tcs_renewal_confirmation" -> Map(
      "awardStartDate"   -> "6 April 2016",
      "awardEndDate"     -> "10 January 2017",
      "customerFName"    -> "Tom",
      "renewalReference" -> "123 456 789 123 456",
      "startDate"        -> "6 April 2017",
      "endDate"          -> "5 April 2018",
      "noticeDate"       -> "7 July 2017",
      "incompleteClaims" -> "2",
      "anyEstimates"     -> "3",
      "currentTaxYear"   -> "2018"
    ),
    "iht_access_invitation_template_id" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "gmp_access_invitation_template_id" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "gmp_bulk_upload_received" -> Map(
      "fileUploadReference" -> "Reference1234"
    ),
    "hts_reminder_email" -> Map(
      "name"  -> "Joe Bloggs",
      "month" -> "April"
    ),
    "gmp_bulk_upload_processed" -> Map(
      "fileUploadReference" -> "Reference1234",
      "uploadDate"          -> "10 February 2016",
      "userId"              -> "*****123"
    ),
    "rald_alert" -> Map(
      "referenceNumber" -> "Reference number: 9999000666",
      "postcode"        -> "Postcode: BN12 4AX",
      "expiryDate"      -> "We will delete any unsubmitted information on 28 July 2016"
    ),
    "rald_not_connected" -> Map(
      "referenceNumber" -> "9999000666",
      "email"           -> "jimm@jimmjimm.com",
      "phoneNumber"     -> "01234567890"
    ),
    "rald_submission_confirmation" -> Map(
      "customerName" -> "John Doe"
    ),
    "bars_alert" -> Map(
      "baRefNumber"   -> "BA : ba5090",
      "fileName"      -> "File name : Barnet_CT.xml",
      "dateSubmitted" -> "Date Submitted : 2016-08-09T14:02:09.747+01:00",
      "errorList"     -> "Brap Brap"
    ),
    "bars_alert_transaction" -> Map(
      "baRefNumber"   -> "BA : ba5090",
      "transactionId" -> "Transaction id : 78918c8a-216a-4472-b886-9b81fcf4f64d",
      "fileName"      -> "File name : Barnet_CT.xml",
      "dateSubmitted" -> "Date Submitted : 2016-08-09T14:02:09.747+01:00",
      "errorList"     -> "Brap Brap"
    ),
    "register_your_company_welcome_email" -> Map(
      "returnLink" -> "http://registeryourcompany.gov.uk"
    ),
    "register_your_company_verification_email" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "register_your_company_register_paye_confirmation_current_tax_year" -> Map(
      "companyName"     -> "ABC Logistics Ltd",
      "referenceNumber" -> "12345678910"
    ),
    "register_your_company_register_paye_confirmation_new_tax_year" -> Map(
      "companyName"     -> "Foo bar Wizz And Bang Ltd",
      "referenceNumber" -> "reference-test-12345678910"
    ),
    "investment_tax_relief_verification_email" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "investment_tax_relief_confirmation_email" -> Map(
      "companyName"         -> "Test company name",
      "date"                -> "09-09-2999",
      "formBundleRefNumber" -> "XAFORMBUNDLEREF"
    ),
    "investment_tax_relief_no_docs_confirmation_email" -> Map(
      "companyName"         -> "Test company name",
      "date"                -> "09-09-2999",
      "formBundleRefNumber" -> "XAFORMBUNDLEREF"
    ),
    "annual_tax_summaries_message_alert" -> (newMessageAlert_Names + ("taxYear" -> "2014-15")),
    "indefensible_upgrades"              -> newMessageAlert_Names,
    "indefensible_upgrades_with_dates"   -> newMessageAlert_Names,
    "client_approves_mandate" -> Map(
      "service"   -> testServiceUpdate,
      "recipient" -> "Mrs Agent"
    ),
    "agent_activates_mandate" -> Map(
      "service"   -> testServiceUpdate,
      "recipient" -> "Mrs Brown"
    ),
    "agent_rejects_mandate" -> Map(
      "service"   -> testServiceUpdate,
      "recipient" -> "Mrs Brown"
    ),
    "agent_removes_mandate" -> Map(
      "service"      -> testServiceUpdate,
      "recipient"    -> "Mrs Brown",
      "uniqueAuthNo" -> "12345678"
    ),
    "client_removes_mandate" -> Map(
      "service"   -> testServiceUpdate,
      "recipient" -> "Mrs Agent"
    ),
    "client_cancels_active_mandate" -> Map(
      "service"   -> testServiceUpdate,
      "recipient" -> "Mrs Agent"
    ),
    "agent_self_auth_activates_mandate" -> Map(
      "service"   -> testServiceUpdate,
      "recipient" -> "Mrs Agent"
    ),
    "agent_self_auth_deactivates_mandate" -> Map(
      "service"   -> testServiceUpdate,
      "recipient" -> "Mrs Agent"
    ),
    "offpayroll_private_beta_invitation" -> Map(
      "name"             -> "Mr Joe Bloggs",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "gg_userid_notification" -> Map(
      "user_id"   -> "914657894302",
      "full_name" -> "Joe Bloggs"
    ),
    "2SV_reset_confirmation" -> Map(
      "full_name" -> "Joe Bloggs"
    ),
    "password_change_confirmation" -> Map(
      "full_name" -> "Joe Bloggs"
    ),
    "customs_registration_successful" -> Map(
      "recipientName_FullName" -> "Alex Smith",
      "recipientOrgName"       -> "SHD Fashion House",
      "completionDate"         -> "15 March 2019"
    ),
    "customs_registration_not_successful" -> Map(
      "recipientName_FullName" -> "Alex Smith",
      "recipientOrgName"       -> "SHD Fashion House",
      "completionDate"         -> "15 March 2019"
    ),
    "customs_migrate_successful" -> Map(
      "recipientName_FullName" -> "Alex Smith",
      "recipientOrgName"       -> "SHD Fashion House",
      "completionDate"         -> "22 March 2019"
    ),
    "customs_migrate_not_successful" -> Map(
      "recipientName_FullName" -> "Alex Smith",
      "recipientOrgName"       -> "SHD Fashion House",
      "completionDate"         -> "22 March 2019"
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
    "customs_pull_notifications_warning" -> Map(
      "queueThreshold"       -> "1000",
      "clientId_0"           -> "3d34882b-0e73-4aaa-b156-afc037208871",
      "notificationTotal_0"  -> "1001",
      "oldestNotification_0" -> "2011-08-08T15:38:09.747+01:00",
      "latestNotification_0" -> "2018-08-08T10:02:10.627+01:00",
      "clientId_1"           -> "3d34882b-0e73-4aaa-b156-afc037208872",
      "notificationTotal_1"  -> "2001",
      "oldestNotification_1" -> "2012-08-08T15:38:09.747+01:00",
      "latestNotification_1" -> "2018-08-08T10:02:10.627+01:00",
      "clientId_2"           -> "3d34882b-0e73-4aaa-b156-afc037208873",
      "notificationTotal_2"  -> "3001",
      "oldestNotification_2" -> "2013-08-08T15:38:09.747+01:00",
      "latestNotification_2" -> "2018-08-08T10:02:10.627+01:00"
    ),
    "customs_push_notifications_warning" -> Map(
      "timestamp" -> "2018-07-05T09:08:12.831Z"
    ),
    "transactionEngineHMRCSASA100Success" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA100Failure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTSuccess" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTFailure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTTILSuccess" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA100ATTTILFailure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA100TILSuccess" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA100TILFailure" -> Map(
      "receivedDate" -> "01/01/01",
      "identifier"   -> "1234567890",
      "subject"      -> "subject"
    ),
    "transactionEngineECSLORGV101Success" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineECSLORGV101Failure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRAACTSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRAACTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRAAPAYESuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRAAPAYEFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRAASASuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRAASAFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRCISCIS300MRSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRCISCIS300MRFailure" -> Map(
      "errorType"      -> "business",
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber"    -> "1001",
      "errorMessage"   -> "Fatal Error Message"
    ),
    "transactionEngineIRCISVERIFYSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRCISVERIFYFailure" -> Map(
      "errorType"      -> "business",
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber"    -> "1001",
      "errorMessage"   -> "Fatal Error Message"
    ),
    "transactionEngineIRCTFANNUALRETURNSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRCTFANNUALRETURNFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEEOYSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEEOYFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEEOYTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEEOYTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEEXBSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEEXBFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEMOVSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEMOVFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEMOVTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEMOVTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEP38ASuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEP38AFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEUPDATESuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRPAYEUPDATEFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRSDLTLTRSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineIRSDLTLTRFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEASTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEPSTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIEYUTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTIFPSTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPAYERTINVRTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAACCTTAXSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAACCTTAXFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAADDSCHASuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAADDSCHAFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAAMDDETSSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAAMDDETSFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAASSCSASuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAASSCSAFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSACOMBINEDREGSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSACOMBINEDREGFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAEVNTREPSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAEVNTREPFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAMAINTSCMSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAMAINTSCMFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSARASSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSARASFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAREGSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAREGFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSARETSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSARETFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAPRACAUTHSuccess" -> Map(
      "receivedTime" -> "21:45",
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAPRACAUTHFailure" -> Map(
      "errorType"      -> "business",
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber"    -> "1001",
      "errorMessage"   -> "Fatal Error Message"
    ),
    "transactionEngineHMRCPSAPRACDEAUTHSuccess" -> Map(
      "receivedTime" -> "21:45",
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPSAPRACDEAUTHFailure" -> Map(
      "errorType"      -> "business",
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber"    -> "1001",
      "errorMessage"   -> "Fatal Error Message"
    ),
    "transactionEngineHMRCSASA800ATTSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA800ATTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA800TILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA800TILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA800ATTTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA800ATTTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA800Success" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA800Failure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900TILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900TILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900ATTTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900Success" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCSASA900Failure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMCENESEDIFACTSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMCENESEDIFACTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCVATDECSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCVATDECFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCVATDECTILSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCVATDECTILFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCCTCT600Success" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCCTCT600Failure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCCTCT600TILSuccess" -> Map(
      "receivedTime" -> "21:45",
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCCTCT600TILFailure" -> Map(
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorType"      -> "business",
      "errorTextBlock" -> "<p>Error Code: 123 Error Message: An Error</p>"
    ),
    "transactionEngineHMRCCTCT600TILFailure" -> Map(
      "receivedTime" -> "21:45",
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject",
      "errorType"    -> "fatal",
      "errorNumber"  -> "123",
      "errorMessage" -> "This is an error"
    ),
    "transactionEngineHMRCPPACCTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPAMDFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPEVNTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPEVNTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPEVNTSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPMAINTFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPPRACSuccess" -> Map(
      "receivedTime" -> "21:45",
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPPRACFailure" -> Map(
      "errorType"      -> "business",
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber"    -> "1001",
      "errorMessage"   -> "Fatal Error Message"
    ),
    "transactionEngineHMRCPPRETFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPRETSuccess" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineCHARCLMSuccess" -> Map(
      "receivedTime" -> "09:45",
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineCHARCLMFailure" -> Map(
      "errorType"      -> "business",
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber"    -> "1001",
      "errorMessage"   -> "Fatal Error Message"
    ),
    "transactionEngineCHARCLMMULTIFailure" -> Map(
      "errorType"      -> "business",
      "receivedTime"   -> "21:45",
      "receivedDate"   -> "20 April 2017",
      "identifier"     -> "12345",
      "subject"        -> "subject",
      "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
      "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
      "errorNumber"    -> "1001",
      "errorMessage"   -> "Fatal Error Message"
    ),
    "transactionEngineCHARCLMMULTISuccess" -> Map(
      "receivedTime" -> "21:45",
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "transactionEngineHMRCPPRASFailure" -> Map(
      "receivedDate" -> "20 April 2017",
      "identifier"   -> "12345",
      "subject"      -> "subject"
    ),
    "chargeable_return_submit" -> Map(
      "first_name"   -> "FirstName",
      "last_name"    -> "SecondName",
      "company_name" -> "Acme Limited",
      "date"         -> "23 September 2017"
    ),
    "relief_return_submit" -> Map(
      "first_name"   -> "FirstName",
      "last_name"    -> "SecondName",
      "company_name" -> "Acme Limited",
      "date"         -> "23 September 2017",
      "reference"    -> "1234567890"
    ),
    "amended_return_submit" -> Map(
      "first_name"   -> "FirstName",
      "last_name"    -> "SecondName",
      "company_name" -> "Acme Limited",
      "date"         -> "23 September 2017"
    ),
    "further_return_submit" -> Map(
      "first_name"   -> "FirstName",
      "last_name"    -> "SecondName",
      "company_name" -> "Acme Limited",
      "date"         -> "23 September 2017"
    ),
    "change_details_return_submit" -> Map(
      "first_name"   -> "FirstName",
      "last_name"    -> "SecondName",
      "company_name" -> "Acme Limited",
      "date"         -> "23 September 2017"
    ),
    "disposal_return_submit" -> Map(
      "first_name"   -> "FirstName",
      "last_name"    -> "SecondName",
      "company_name" -> "Acme Limited",
      "date"         -> "23 September 2017"
    ),
    "lisa_application_submit" -> Map(
      "application_reference" -> "ABC1234567890",
      "email"                 -> "lisaTest@test.com",
      "review_date"           -> "7 February 2019",
      "first_name"            -> "Frank",
      "last_name"             -> "Customer"
    ),
    "emac_helpdesk_failure_confirmation_email" -> Map(
      "service_name"   -> "Self Assessment (SA)",
      "full_name"      -> "Troy Barnes",
      "correlation_id" -> "H5JK4ITURY84783HJ345HJ345HJ342N3"
    ),
    "emac_helpdesk_successful_confirmation_email" -> Map(
      "service_name"   -> "Alcohol and Tobacco Warehousing Declarations (ATWD)",
      "full_name"      -> "Abed Nadir",
      "correlation_id" -> "HJ345HJ345HJ342N3H5JK4ITURY84783"
    ),
    "emac_activation_code_not_received" -> Map(
      "serviceName" -> "Enrolment Team",
      "name"        -> "David Smith"
    ),
    "eeitt_submission_confirmation" -> Map(
      "" -> ""
    ),
    "cir_revocation_confirmation" -> Map(
      "" -> ""
    ),
    "cir_appointment_confirmation" -> Map(
      "" -> ""
    ),
    "eeitt_ce930_confirmation" -> Map(
      "" -> ""
    ),
    "eeitt_ho930_confirmation" -> Map(
      "" -> ""
    ),
    "cir_return_confirmation" -> Map(
      "" -> ""
    ),
    "randd_confirmation_submission" -> Map(
      "" -> ""
    ),
    "ho10_confirmation_submission" -> Map(
      "" -> ""
    ),
    "apd_return_confirmation" -> Map(
      "" -> ""
    ),
    "fhdds_submission_confirmation" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "fhdds_submission_withdrawal" -> Map(
      "withdrawalDate" -> "3 May 2018"
    ),
    "fhdds_email_verification" -> Map(
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "fhdds_submission_deregister" -> Map(
      "deregisterDate" -> "6 June 2018"
    ),
    "oss_registration_confirmation_pre_10th_of_month" -> Map(
      "recipientName_line1"                -> "Joe Bloggs",
      "businessName"                       -> "Test Business",
      "startDate"                          -> "12 June 2021",
      "reference"                          -> "123456789",
      "lastDayOfCalendarQuarter"           -> "30 September 2021",
      "lastDayOfMonthAfterCalendarQuarter" -> "31 October 2021"
    ),
    "oss_registration_confirmation_post_10th_of_month" -> Map(
      "recipientName_line1"                    -> "Joe Bloggs",
      "businessName"                           -> "Test Business",
      "reference"                              -> "123456789",
      "lastDayOfCalendarQuarter"               -> "30 September 2021",
      "firstDayOfNextCalendarQuarter"          -> "1 October 2021",
      "startDate"                              -> "1 October 2021",
      "lastDayOfNextCalendarQuarter"           -> "31 December 2021",
      "lastDayOfMonthAfterNextCalendarQuarter" -> "31 January 2022"
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
    "platformContact" -> Map(
      "apiTitle"    -> "Individuals Tax Relief for Kitten Ownership",
      "senderName"  -> "Alice Example",
      "senderEmail" -> "alice@example.com",
      "contactReasons" -> Base64.getEncoder.encodeToString(
        stringify(parse("""[
          "I want to know if I can reuse this API",
          "I need more information, like schemas or examples"
        ]""")).getBytes("UTF-8")),
      "specificQuestion" -> "I need some stuff."
    ),
    "platformContactConfirmation" -> Map(
      "apiTitle"    -> "Individuals Tax Relief for Kitten Ownership",
      "senderName"  -> "Alice Example",
      "senderEmail" -> "alice@example.com",
      "contactReasons" -> Base64.getEncoder.encodeToString(
        stringify(parse("""[
          "I want to know if I can reuse this API",
          "I need more information, like schemas or examples"
        ]""")).getBytes("UTF-8")),
      "specificQuestion" -> "I need some stuff.",
      "apiEmail"         -> "api-platform@example.com"
    )
  )
}
object TemplateParams2 {

  val exampleLinkWithRandomId = s"http://host:8080/your/link/${UUID.randomUUID}"
  val exampleParams = Map(
    "open_banking_payment_successful" -> Map(
      "taxType"    -> "Self Assessment",
      "reference"  -> "1234567890K",
      "amountPaid" -> "123.45"
    ),
    "open_banking_payment_successful_cy" -> Map(
      "taxType"    -> "Self Assessment",
      "reference"  -> "1234567890K",
      "amountPaid" -> "123.45"
    ),
    "payment_successful" -> Map(
      "taxType"          -> "Self Assessment",
      "taxReference"     -> "1234567890K",
      "paymentReference" -> "4f3e3db2-c8e1-4db0-86ae-000bc992faa8",
      "amountPaid"       -> "123.45",
      "commission"       -> "2.55",
      "totalPaid"        -> "126.00"
    ),
    "payment_successful_cy" -> Map(
      "taxType"          -> "Self Assessment",
      "taxReference"     -> "1234567890K",
      "paymentReference" -> "4f3e3db2-c8e1-4db0-86ae-000bc992faa8",
      "amountPaid"       -> "123.45",
      "commission"       -> "2.55",
      "totalPaid"        -> "126.00"
    ),
    "payment_successful_parcels" -> Map(
      "taxType"      -> "Import VAT on parcels",
      "taxReference" -> "1234 5678 90K",
      "amountPaid"   -> "123.45",
      "commission"   -> "2.55",
      "totalPaid"    -> "126.00"),
    "ddi_migration_letter" -> Map(
      "NAME"         -> "Customer",
      "ADDRESSLINE1" -> "15 Grand Avenue",
      "ADDRESSLINE2" -> "Floor 104",
      "ADDRESSLINE3" -> "Capital City",
      "ADDRESSLINE4" -> "",
      "ADDRESSLINE5" -> "",
      "POSTCODE"     -> "MZ1 1AA",
      "COUNTRY"      -> "United Kingdom",
      "REGIME"       -> "VATC",
      "OLDSUN"       -> "123456",
      "NEWSUN"       -> "448610",
      "TRANSFERDATE" -> "20180501",
      "DDIREFERENCE" -> "123456789",
      "OLDSUNNAME"   -> "HMRC eVAT",
      "NEWSUNNAME"   -> "HMRC E VAT DDS",
      "PHONENUMBER"  -> "0300 200 3700"
    ),
    "ddi_advance_notice" -> Map(
      "NAME"           -> "Customer",
      "DDIREFERENCE"   -> "123456789",
      "REGIME"         -> "VATC",
      "AMOUNT"         -> "1215003.18",
      "COLLECTIONDATE" -> "20180501",
      "NEWSUNNAME"     -> "HMRC E VAT DDS",
      "PHONENUMBER"    -> "0300 200 3700",
      "CHARGETYPE_0"   -> "VAT Return",
      "PERIOD_0"       -> "0118",
      "AMOUNT_0"       -> "5001.43",
      "CHARGETYPE_1"   -> "VAT Return",
      "PERIOD_1"       -> "0418",
      "AMOUNT_1"       -> "4049.57",
      "CHARGETYPE_2"   -> "VAT Return",
      "PERIOD_2"       -> "0718",
      "AMOUNT_2"       -> "5952"
    ),
    "ddi_setup_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith"
    ),
    "ddi_amended_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith"
    ),
    "ddi_cancelled_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith"
    ),
    "ddi_reminder_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith"
    ),
    "ddi_unpaid_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith"
    ),
    "ddi_08_alert_aa" -> Map(
      "recipientName_line1" -> "Colm Cavanagh"
    ),
    "sdds_ddi_setup_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_amended_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_cancelled_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_reminder_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_unpaid_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "dd_email_verifcation" -> Map(
      "name"             -> "Joe",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "recon_tps_report" -> Map(
      "subject"       -> "Telephone Payment System (TPS) Finance Report 22/01/1989",
      "vatLegal"      -> "2,19400000,0,0,2,19400000",
      "shipley"       -> "4,20744424,1,9886240,5,30630664",
      "debitCardFee"  -> "3,0,0,0,3,0",
      "vatAccount"    -> "1,9700000,0,0,1,9700000",
      "nirs"          -> "1,9700000,0,0,1,9700000",
      "commisionCard" -> "7,1344420,1,186240,8,1530660",
      "total"         -> "10,70588846,1,10072480,11,80661326",
      "cumbernauld"   -> "2,9700002,0,0,2,9700002"
    ),
    "recon_tops_report" -> Map(
      "subject"         -> "ETMP Telephone Payment Service (TPS) Finance report 27 September 2027",
      "TOPS_ROW_P800"   -> "P800,4,11842279,2,0,2,14443,4,11842279",
      "TOPS_ROW_SA"     -> "SA,94,911842279,92,90,92,914443,94,911842279",
      "TOPS_ROW_TOTALS" -> "Totals,84,811842279,82,80,82,814443,84,811842279"
    ),
    "recon_surcharge_report" -> Map(
      "subject"                                            -> "Surcharge report 27/09/2027",
      "tpsRcsSurchargeReport_sdlt"                         -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_vat"                          -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_sa"                           -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_safe"                         -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_ct"                           -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_epaye"                        -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_ntc"                          -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_nps"                          -> "1,10.0,2,20.0,3,30.0",
      "tpsRcsSurchargeReport_total"                        -> "8,80.0,16,160.0,24,240.0",
      "opsRcsSurchargeReport_sa"                           -> "1,10.0,2,20.0,3,30.0",
      "opsRcsSurchargeReport_cotax"                        -> "1,10.0,2,20.0,3,30.0",
      "opsRcsSurchargeReport_paye"                         -> "1,10.0,2,20.0,3,30.0",
      "opsRcsSurchargeReport_misc"                         -> "1,10.0,2,20.0,3,30.0",
      "opsRcsSurchargeReport_sdlt"                         -> "1,10.0,2,20.0,3,30.0",
      "opsRcsSurchargeReport_totalShipley"                 -> "5,50.0,10,100.0,15,150.0",
      "opsRcsSurchargeReport_vat"                          -> "1,10.0,2,20.0,3,30.0",
      "opsRcsSurchargeReport_totalCumbernauld"             -> "1,10.0,2,20.0,3,30.0",
      "topsNoModsSurchargeReport_p800"                     -> "1,10.0,2,20.0,3,30.0",
      "topsNoModsSurchargeReport_pngr"                     -> "1,10.0,2,20.0,3,30.0",
      "topsNoModsSurchargeReport_childBenefitRepayments"   -> "1,10.0,2,20.0,3,30.0",
      "topsNoModsSurchargeReport_total"                    -> "3,30.0,6,60.0,9,90.0",
      "topsJustModsSurchargeReport_mods"                   -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_p800"                   -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_simpleAssessment"       -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_cgt"                    -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_pngr"                   -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_cds"                    -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_childBenefitRepayments" -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_total"                  -> "6,60.0,12,120.0,18,180.0",
      "opsDesJustModsSurchargeReport_mods"                 -> "1,10.0,2,20.0,3,30.0"
    ),
    "recon_mods_finance_report" -> Map(
      "subject"                   -> "MODS Finance Report 27/09/2027",
      "MODS_ROW_OPS_123-456-789"  -> "123-456-789,OPSMIBREF1234,100,100,200,100,300",
      "MODS_ROW_OPS_234-567-890"  -> "234-567-890,OPSMIBREF2345,100,100,200,100,300",
      "MODS_ROW_OPS_098-765-432"  -> "098-765-432,OPSMIBREF3456,100,100,200,100,300",
      "MODS_ROW_OPS_987-654-321"  -> "987-654-321,OPSMIBREF4567,100,100,200,100,300",
      "MODS_ROW_TOPS_123-456-789" -> "123-456-789,TOPSMIBREF1234,100,100,200,100,300",
      "MODS_ROW_TOPS_234-567-890" -> "234-567-890,TOPSMIBREF2345,100,100,200,100,300",
      "MODS_ROW_TOPS_098-765-432" -> "098-765-432,TOPSMIBREF3456,100,100,200,100,300",
      "MODS_ROW_TOPS_987-654-321" -> "987-654-321,TOPSMIBREF4567,100,100,200,100,300"
    ),
    "hts_verification_email" -> Map(
      "name"             -> "Joe",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "sdil_registration_accepted" -> Map(
      "sdilNumber"  -> "ZZSDIL0009999",
      "companyName" -> "Some company Ltd."
    ),
    "sdil_registration_received" -> Map(
      "companyName" -> "Some company Ltd.",
      "sdilNumber"  -> "ZZSDIL0009999"
    ),
    "retrieve_userid_notification" -> Map(
      "user_id"   -> "914657894302",
      "full_name" -> "Joe Bloggs"
    ),
    "cca_appeals_submission_link" -> Map(
      "proposalNumber" -> "341112111",
      "submissionUrl"  -> "http://test.com/blah-blah",
      "submissionDate" -> "15 Sep 2021",
      "postcode"       -> "AA1 1AA"
    ),
    "cca_enrolment_migration_confirmation" -> Map(
      "name"     -> "test user",
      "personId" -> "123456789",
      "orgName"  -> "Test Organisation"
    ),
    "cca_enrolment_confirmation" -> Map(
      "name"     -> "test user",
      "personId" -> "123456789",
      "orgName"  -> "Test Organisation"
    ),
    "cca_enrolment_confirmation_agent" -> Map(
      "name"      -> "test user",
      "personId"  -> "123456789",
      "orgName"   -> "Test Organisation",
      "agentCode" -> "8888888"
    ),
    "cca_enrolment_confirmation_individual" -> Map(
      "name"     -> "test user",
      "personId" -> "123456789"
    ),
    "cca_revaluation_subscription_confirmation" -> Map(
      "name" -> "test user"
    ),
    "cdsEmailTemplate" -> Map(
      "ref" -> "NAT-VAT-0001-18 Operation: Wheelbarrow"
    ),
    "pods_scheme_register" -> Map(
      "psaName" -> "Jane Doe",
      "srn"     -> "S12345 67890"
    ),
    "pods_racdac_scheme_register" -> Map(
      "psaName"    -> "Jane Doe",
      "schemeName" -> "test scheme"
    ),
    "pods_scheme_migration_confirmation" -> Map(
      "psaName"    -> "Jane Doe",
      "schemeName" -> "Some Pension Scheme"
    ),
    "pods_racdac_bulk_migration_confirmation" -> Map(
      "psaName" -> "Jane Doe"
    ),
    "pods_racdac_individual_migration_confirmation" -> Map(
      "psaName"    -> "Jane Doe",
      "schemeName" -> "Test RAC/DAC"
    ),
    "mtdfb_vat_agent_sign_up_successful" -> Map(
      "vatNumber" -> "123456782"
    ),
    "mtdfb_vat_principal_sign_up_successful" -> Map(
      "vatNumber" -> "123456782"
    ),
    "pods_psa_invited" -> Map(
      "inviteeName" -> "Jane Doe",
      "schemeName"  -> "Some Pension Scheme",
      "expiryDate"  -> "20 July 1969"
    ),
    "parcels_registration_confirmation" -> Map(
      "name"            -> "Joe Bloggs",
      "referenceNumber" -> "IM123456789A"
    ),
    "digital_tariffs_case_completed" -> Map(
      "recipientName_line1" -> "FULL NAME",
      "reference"           -> "ATaR REFERENCE",
      "goodsName"           -> "GOODS NAME",
      "dateSubmitted"       -> "20 December 2020",
      "officerName"         -> "Dan Officer"
    ),
    "passengers_payment_confirmation" -> Map(
      "subject"         -> "Receipt for payment on goods brought into the UK - Reference number XAPR9876543210",
      "NAME"            -> "Jura Smith",
      "DATE"            -> "5 December 2020",
      "PLACEOFARRIVAL"  -> "Heathrow Airport",
      "DATEOFARRIVAL"   -> "4 December 2020",
      "TIMEOFARRIVAL"   -> "12:15 PM",
      "REFERENCE"       -> "XAPR9876543210",
      "TOTAL"           -> "£50.00",
      "TOTALEXCISEGBP"  -> "£10.50",
      "TOTALCUSTOMSGBP" -> "£5.50",
      "TOTALVATGBP"     -> "£20.50",
      "TRAVELLINGFROM"  -> "Great Britain",
      "AllITEMS"        -> "[{\"commodityDescription\":\"Beer\",\"volume\":\"100\",\"goodsValue\":\"400.00\",\"valueCurrency\":\"EUR\",\"valueCurrencyName\":\"Euro (EUR)\",\"originCountry\":\"FR\",\"originCountryName\":\"France\",\"exchangeRate\":\"1.1577\",\"exchangeRateDate\":\"2021-03-09\",\"goodsValueGBP\":\"345.51\",\"VATRESClaimed\":false,\"exciseGBP\":\"80.00\",\"customsGBP\":\"0.00\",\"vatGBP\":\"85.10\",\"ukVATPaid\":false,\"ukExcisePaid\":false}]"
    ),
    "digital_tariffs_advice_request" -> Map(
      "reference"             -> "REFERENCE",
      "contactName"           -> "FULL NAME",
      "contactEmail"          -> "EMAIL ADDRESS",
      "itemName"              -> "ITEM NAME",
      "itemDescription"       -> "ITEM DESCRIPTION",
      "supportingDocuments"   -> "www.hmrc.gov.uk|www.gov.co.uk",
      "supportingInformation" -> "SUPPORTING INFO"
    ),
    "digital_tariffs_application_submitted" -> Map(
      "recipientName_line1" -> "FULL NAME",
      "reference"           -> "REFERENCE"
    ),
    "digital_tariffs_application_submitted_cy" -> Map(
      "recipientName_line1" -> "FULL NAME",
      "reference"           -> "REFERENCE"
    ),
    "newMessageAlert_2WSM-question" -> Map(
      "recipientName_line1" -> "Alex Brown"
    ),
    "newMessageAlert_2WSM-reply" -> Map(
      "recipientName_line1" -> "Alex Brown",
      "date"                -> "2019-04-03"
    ),
    "cgtpd_email_verification" -> Map(
      "verificationLink" -> exampleLinkWithRandomId,
      "name"             -> "Susan Bartlett"
    ),
    "cgtpd_email_verification_cy" -> Map(
      "verificationLink" -> exampleLinkWithRandomId,
      "name"             -> "Susan Bartlett"
    ),
    "tdq_compliance_all_required_headers_missing" -> Map(
      "developerName"   -> "John Smith",
      "fromDate"        -> "22 September 2019",
      "toDate"          -> "22 October 2019",
      "applicationName" -> "MTD VAT Test Application",
      "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
    ),
    "tdq_compliance_partially_compliant_invalid_or_missing_connection_method" -> Map(
      "developerName"               -> "Joe Williams",
      "fromDate"                    -> "1 December 2019",
      "toDate"                      -> "31 December 2019",
      "applicationName"             -> "MTD VAT InvalidConnection App",
      "applicationId"               -> "1434b966-ea76-40a6-a312-1d58ff873a16",
      "allHeadersMissingPercentage" -> "10"
    ),
    "tdq_compliance_partially_compliant_valid_connection_method" -> Map(
      "developerName"               -> "James Black",
      "fromDate"                    -> "1 January 2020",
      "toDate"                      -> "31 January 2020",
      "applicationName"             -> "MTD VAT ValidCM App",
      "applicationId"               -> "07b587d7-34d9-40b6-9d59-a0917490cf02",
      "allHeadersMissingPercentage" -> "10",
      "extraDetails" -> Base64.getEncoder.encodeToString(stringify(
        parse("""
        {
          "connectionMethod": "WEB_APP_VIA_SERVER",
          "requestCount": 100,
          "headerValidations": [
            {
              "headerOrHeaders": "gov-client-public-ip",
              "errors": [
                {
                  "message": "Value is not an IP address",
                  "percentage": 5,
                  "count": 5
                }, {
                  "message": "Value is not a public IP address",
                  "percentage": 10,
                  "count": 10
                }
              ],
              "warnings": []
            }, {
              "headerOrHeaders": "gov-vendor-version",
              "errors": [
                {
                  "message": "Value must be a key-value data structure",
                  "percentage": 10,
                  "count": 10
                }, {
                  "message": "At least 1 key or value is not percent encoded",
                  "percentage": 25,
                  "count": 25
                }, {
                  "message": "At least 1 software version value is missing",
                  "percentage": 15,
                  "count": 15
                }, {
                  "message": "At least 1 separator is percent encoded. Check ampersands and equal signs.",
                  "percentage": 0,
                  "count": 1
                }
              ],
              "warnings": [
                {
                  "message": "For client server architectures, submit a version for the client and the server. For all other architectures, submit at least 1 version.",
                  "percentage": 10,
                  "count": 10
                }
              ]
            },
            {
              "headerOrHeaders": "gov-client-device-id",
              "errors" : [],
              "warnings": [
                {
                  "message": "Use a recommended UUID. Check the specification.",
                  "percentage": 0,
                  "count": 0
                }, {
                  "message": "ID must be longer to ensure it is unique. It is best to use a UUID which is at least 128 bits or 32 hex characters long.",
                  "percentage": 17,
                  "count": 17
                }, {
                  "message": "Contains an email address. User specific data must not be used to generate Device IDs.",
                  "percentage": 22,
                  "count": 22
                }
              ]
            }
          ]
        }
          """)).getBytes("UTF-8"))
    ),
    "tdq_fph_report_non_compliant" -> Map(
      "developerName"                     -> "John Smith",
      "fromDate"                          -> "22 September 2019",
      "toDate"                            -> "22 October 2019",
      "applicationName"                   -> "My Basic MTD App",
      "applicationId"                     -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
      "allHeadersMissingPercentage"       -> "5",
      "invalidConnectionMethodPercentage" -> "23",
      "allHeadersMissingCount"            -> "729",
      "invalidConnectionMethodCount"      -> "3354",
      "relatesToMultipleVersions"         -> "true",
      "extraDetails" -> Base64.getEncoder.encodeToString(stringify(
        parse("""
        {
          "connectionMethod": "WEB_APP_VIA_SERVER",
          "requestCount": 10500,
          "headerValidations": [
            {
              "headerOrHeaders": "gov-client-public-ip",
              "errors": [
                {
                  "message": "Value is not an IP address",
                  "percentage": 5,
                  "count": 525
                }, {
                  "message": "Value is not a public IP address",
                  "percentage": 10,
                  "count": 1050
                }
              ],
              "warnings": []
            }, {
              "headerOrHeaders": "gov-vendor-version",
              "errors": [
                {
                  "message": "Value must be a key-value data structure",
                  "percentage": 10,
                  "count": 1075
                }, {
                  "message": "At least 1 software version value is missing",
                  "percentage": 15,
                  "count": 1580
                }, {
                  "message": "At least 1 separator is percent encoded. Check ampersands and equal signs.",
                  "percentage": 0,
                  "count": 10
                }
              ],
              "warnings": [
                {
                  "message": "For client server architectures, submit a version for the client and the server. For all other architectures, submit at least 1 version.",
                  "percentage": 10,
                  "count": 107
                }
              ]
            },
            {
              "headerOrHeaders": "gov-client-device-id",
              "errors" : [],
              "warnings": [
                {
                  "message": "ID must be longer to ensure it is unique. It is best to use a UUID which is at least 128 bits or 32 hex characters long.",
                  "percentage": 17,
                  "count": 1801
                }, {
                  "message": "Contains an email address. User specific data must not be used to generate Device IDs.",
                  "percentage": 22,
                  "count": 2315
                }
              ]
            }
          ]
        }
        """)).getBytes("UTF-8"))
    ),
    "tdq_fph_report_heuristically_compliant" -> Map(
      "developerName"             -> "John Smith",
      "fromDate"                  -> "22 September 2019",
      "toDate"                    -> "22 October 2019",
      "applicationName"           -> "My Well Behaved MTD App",
      "applicationId"             -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff",
      "hasOtherConnectionMethods" -> "true",
      "extraDetails"              -> Base64.getEncoder.encodeToString(stringify(parse("""
        {
          "connectionMethod": "WEB_APP_VIA_SERVER",
          "requestCount": 10500,
          "headerValidations": []
        }
        """)).getBytes("UTF-8"))
    ),
    "cgtpd_account_created" -> Map(
      "cgtReference" -> "XYCGTP123456780",
      "name"         -> "Jamie Wilson"
    ),
    "cgtpd_account_created_cy" -> Map(
      "cgtReference" -> "XYCGTP123456780",
      "name"         -> "Jamie Wilson"
    ),
    "cgtpd_private_beta_access" -> Map(
      "name"             -> "Jamie Wilson",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "cgtpd_submission_confirmation" -> Map(
      "name"         -> "Jamie Wilson",
      "submissionId" -> "000000000006"
    ),
    "cgtpd_submission_confirmation_cy" -> Map(
      "name"         -> "Jamie Wilson",
      "submissionId" -> "000000000006"
    ),
    "dst_registration_accepted" -> Map(
      "dstNumber"            -> "XADST0000010000",
      "name"                 -> "Joe Bloggs",
      "companyName"          -> "Some company Ltd.",
      "groupCompanyName"     -> "Some group company Ltd.",
      "paymentDeadline"      -> "20210401",
      "submitReturnDeadline" -> "20210731"
    ),
    "dst_registration_received" -> Map(
      "name"             -> "Joe Bloggs",
      "companyName"      -> "Some company Ltd.",
      "groupCompanyName" -> "Some group company Ltd."
    ),
    "pods_file_aft_return" -> Map(
      "schemeName"       -> "Smith Harper pension scheme",
      "accountingPeriod" -> "1 April to 30 June 2020",
      "dateSubmitted"    -> "2 July 2020 at 8:20pm",
      "hmrcEmail"        -> "pensions.administration@hmrc.gov.uk",
      "psaName"          -> "Jane Doe"
    ),
    "pods_aft_amended_return_decrease" -> Map(
      "schemeName"       -> "Smith Harper pension scheme",
      "accountingPeriod" -> "1 April to 30 June 2020",
      "dateSubmitted"    -> "2 July 2020 at 8:20pm",
      "hmrcEmail"        -> "pensions.administration@hmrc.gov.uk",
      "psaName"          -> "Jane Doe",
      "submissionNumber" -> "3"
    ),
    "pods_aft_amended_return_no_change" -> Map(
      "schemeName"       -> "Smith Harper pension scheme",
      "accountingPeriod" -> "1 April to 30 June 2020",
      "dateSubmitted"    -> "2 July 2020 at 8:20pm",
      "hmrcEmail"        -> "pensions.administration@hmrc.gov.uk",
      "psaName"          -> "Jane Doe",
      "submissionNumber" -> "3"
    ),
    "pods_aft_amended_return_increase" -> Map(
      "schemeName"       -> "Smith Harper pension scheme",
      "accountingPeriod" -> "1 April to 30 June 2020",
      "dateSubmitted"    -> "2 July 2020 at 8:20pm",
      "hmrcEmail"        -> "pensions.administration@hmrc.gov.uk",
      "psaName"          -> "Jane Doe",
      "submissionNumber" -> "3"
    ),
    "pods_psa_register" -> Map(
      "psaName" -> "Jane Doe"
    ),
    "pods_psa_register_company" -> Map(
      "psaName" -> "Jane Doe"
    ),
    "pods_psp_register" -> Map(
      "pspName" -> "Jane Doe"
    ),
    "pods_psp_amend" -> Map(
      "pspName" -> "Jane Doe"
    ),
    "pods_psp_de_auth_psp_individual" -> Map(
      "pspName"            -> "Jane Doe",
      "schemeName"         -> "Smith Harper pension scheme",
      "authorisingPsaName" -> "Nigel Robert Smith"
    ),
    "pods_psp_de_auth_psp_company_partnership" -> Map(
      "pspName"            -> "Jane Doe Inc",
      "schemeName"         -> "Smith Harper pension scheme",
      "authorisingPsaName" -> "Nigel Robert Smith"
    ),
    "pods_authorise_psp" -> Map(
      "psaInvitor" -> "Jane Doe",
      "pspInvitee" -> "Joe Bloggs",
      "schemeName" -> "XYZ PENSION SCHEME"
    ),
    "pods_psa_deauthorise_psp" -> Map(
      "psaName"    -> "Bill Bloggs",
      "pspName"    -> "Jane Doe",
      "schemeName" -> "Smith Harper pension scheme"
    ),
    "pods_psp_deregister_self" -> Map(
      "pspName" -> "Jane Doe"
    ),
    "dac6_registration_successful" -> Map(
      "name"   -> "Joe Bloggs",
      "dac6ID" -> "XXDAC000012345"
    ),
    "dac6_new_disclosure_confirmation" -> Map(
      "name"          -> "Joe New",
      "arrangementID" -> "GBA20200101AAA123",
      "disclosureID"  -> "GBD20200101AAA123",
      "dateSubmitted" -> "12:00pm on 1 August 2020",
      "messageRefID"  -> "GB0000000XXX"
    ),
    "dac6_additional_disclosure_confirmation" -> Map(
      "name"          -> "Joe Add",
      "arrangementID" -> "GBA20200101AAA123",
      "disclosureID"  -> "GBD20200101AAA123",
      "dateSubmitted" -> "12:00pm on 2 August 2020",
      "messageRefID"  -> "GB0000000XXX"
    ),
    "dac6_replace_disclosure_confirmation" -> Map(
      "name"          -> "Joe Replace",
      "arrangementID" -> "GBA20200101AAA123",
      "disclosureID"  -> "GBD20200101AAA123",
      "dateSubmitted" -> "12:00pm on 3 August 2020",
      "messageRefID"  -> "GB0000000XXX"
    ),
    "dac6_delete_disclosure_confirmation" -> Map(
      "name"          -> "Joe Delete",
      "arrangementID" -> "GBA20200101AAA123",
      "disclosureID"  -> "GBD20200101AAA123",
      "dateSubmitted" -> "12:00pm on 4 August 2020",
      "messageRefID"  -> "GB0000000XXX"
    ),
    "ecc_subscription_successful" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "recipientOrgName"       -> "JJ Components",
      "serviceName"            -> "Advance Tariff Rulings",
      "completionDate"         -> "22 March 2019"
    ),
    "ecc_subscription_successful_ey" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "recipientOrgName"       -> "JJ Components",
      "serviceName"            -> "Advance Tariff Rulings",
      "completionDate"         -> "22 March 2019"
    ),
    "ecc_subscription_not_successful" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "recipientOrgName"       -> "JJ Components",
      "serviceName"            -> "Advance Tariff Rulings",
      "completionDate"         -> "22 March 2019"
    ),
    "ecc_subscription_not_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "recipientOrgName"       -> "JJ Components",
      "serviceName"            -> "Advance Tariff Rulings",
      "completionDate"         -> "22 March 2019"
    ),
    "ecc_rcm_notifications" -> Map(
      "timestamp"   -> "2018-07-05T09:08:12.831Z",
      "name"        -> "Joe Bloggs",
      "email"       -> "joebloggs@email.com",
      "eori"        -> "GB1234456789000",
      "serviceName" -> "Advance Tariff Rulings"
    ),
    "mods_import_declaration" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010000",
      "dateOfDeclaration"         -> "11 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsProducedInEu_0"       -> "I do not know",
      "goodsPrice_0"              -> "150, Euro (EUR)",
      "goodsCategory_1"           -> "hats",
      "goodsCountry_1"            -> "Mexico",
      "goodsPrice_1"              -> "150, Peso (MXN)",
      "customsDuty"               -> "£4.53",
      "vat"                       -> "£30.91",
      "total"                     -> "£35.44",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "mods_amend_import_declaration" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010000",
      "dateOfDeclaration"         -> "11 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsProducedInEu_0"       -> "I do not know",
      "goodsPrice_0"              -> "150, Euro (EUR)",
      "goodsCategory_1"           -> "hats",
      "goodsCountry_1"            -> "Mexico",
      "goodsPrice_1"              -> "150, Peso (MXN)",
      "customsDuty"               -> "£4.53",
      "vat"                       -> "£30.91",
      "total"                     -> "£35.44",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "mods_export_declaration" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010001",
      "dateOfDeclaration"         -> "26 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsDestination_0"        -> "Spain",
      "goodsPrice_0"              -> "£150",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "mods_amend_export_declaration" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010001",
      "dateOfDeclaration"         -> "26 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsDestination_0"        -> "Spain",
      "goodsPrice_0"              -> "£150",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "mods_import_declaration_cy" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010002",
      "dateOfDeclaration"         -> "11 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsProducedInEu_0"       -> "Iawn",
      "goodsPrice_0"              -> "150, Ewro (EUR)",
      "goodsCategory_1"           -> "hats",
      "goodsCountry_1"            -> "Mecsico",
      "goodsPrice_1"              -> "150, Peso (MXN)",
      "customsDuty"               -> "£4.53",
      "vat"                       -> "£30.91",
      "total"                     -> "£35.44",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "mods_amend_import_declaration_cy" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010002",
      "dateOfDeclaration"         -> "11 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsProducedInEu_0"       -> "Iawn",
      "goodsPrice_0"              -> "150, Ewro (EUR)",
      "goodsCategory_1"           -> "hats",
      "goodsCountry_1"            -> "Mecsico",
      "goodsPrice_1"              -> "150, Peso (MXN)",
      "customsDuty"               -> "£4.53",
      "vat"                       -> "£30.91",
      "total"                     -> "£35.44",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "mods_export_declaration_cy" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010003",
      "dateOfDeclaration"         -> "26 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsDestination_0"        -> "Sbaen",
      "goodsPrice_0"              -> "£150",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "mods_amend_export_declaration_cy" -> Map(
      "emailTo"                   -> "joebloggs@email.com",
      "recipientName_FullName"    -> "Joe Bloggs",
      "declarationReference"      -> "XADST0000010003",
      "dateOfDeclaration"         -> "26 November 2020, 4:22pm",
      "goodsCategory_0"           -> "shoes",
      "goodsDestination_0"        -> "Sbaen",
      "goodsPrice_0"              -> "£150",
      "nameOfPersonCarryingGoods" -> "Joe Bloggs",
      "surname"                   -> "Bloggs",
      "eori"                      -> "GB123456789000000"
    ),
    "dmsdoc_notification" -> Map(
      "mrn" -> "18GB9JLC3CU1LFGVR1"
    ),
    "customs_rcm_notifications" -> Map(
      "timestamp" -> "2018-07-05T09:08:12.831Z",
      "name"      -> "Joe Bloggs",
      "email"     -> "joebloggs@email.com",
      "eori"      -> "GB1234456789000"
    ),
    "reimbursement_claim_submission" -> Map(
      "name"        -> "Sir Arthur Dent",
      "caseNumber"  -> "0004201hog42",
      "claimAmount" -> "500"
    ),
    "reimbursement_claim_submission_cy" -> Map(
      "name"        -> "Sir Arthur Dent",
      "caseNumber"  -> "0004201hog42",
      "claimAmount" -> "500"
    ),
    "tsp_application_confirmation" -> Map(
      "appName"             -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "gd_application_confirmation" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "ipt100_registration_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "csr_submission_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cash_declaration" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cash_declaration_EU" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cash_declaration_UK" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cet_email_confirmation" -> Map(
      "regContactName1"     -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "gss_email_confirmation" -> Map(
      "regContactName1"     -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "register_for_duty_on_gas_for_road_fuel_use" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "register_for_duty_on_biofuels_and_other_fuel_substitutes" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "rdec_email_confirmation" -> Map(
      "fillerName"          -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "corporation_tax_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "register_for_fuel_duty_confirmation" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "adr_confirmation_submission" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ccg1_confirmation_submission" -> Map(
      "decName"             -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "tspDeReg_confirmation_submission" -> Map(
      "appName"             -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "tspCHIEF_confirmation_submission" -> Map(
      "fullNameFilling"     -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "challengeChildcare_confirmation_submission" -> Map(
      "name"                -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "bd600_confirmation_submission" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "civOffShore_confirmation_submission" -> Map(
      "name"                -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "civQualifying_confirmation_submission" -> Map(
      "name"                -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "civTransparency_confirmation_submission" -> Map(
      "name"                -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "confirmationCode_confirmation_submission" -> Map(
      "emailFormName"    -> "Form name",
      "confirmationCode" -> "HGDY",
      "emailContact"     -> "HMRC Contact",
      "emailTeam"        -> "HMRC Team"
    ),
    "civOffshore_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "civQualifying_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "civTransparency_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "civTransparency_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_code_submission_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_confirmation_submission" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cjrs_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "cjrs_code_submission_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "cjrs_confirmation_submission" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "seiss_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "seiss_code_submission_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "seiss_eligibility_submission" -> Map(
      "customerName" -> "Hugh Mann",
      "workingDays"  -> "contact you in..."
    ),
    "seiss_new_child_submission" -> Map(
      "customerName"    -> "Hugh Mann",
      "serviceName"     -> "We received your request for...",
      "slaDetails"      -> "We will reply in...",
      "serviceTeamName" -> "HMRC Team"
    ),
    "seiss_grant_submission" -> Map(
      "customerName" -> "Hugh Mann",
      "workingDays"  -> "contact you in..."
    ),
    "ipr1_confirmation_submission" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ipr2_confirmation_submission" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ipr3_confirmation_submission" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "seiss_repay_submission" -> Map(
      "customerName" -> "Hugh Mann",
      "miscText"     -> "When making the repayment, you must only use the bank details provided to repay the grant money. You must not use these bank details to make any other payment to HMRC.",
      "emailTeam"    -> "the Self-Employment Income Support team"
    ),
    "seiss_repay_submission_cy" -> Map(
      "customerName" -> "Hugh Mann",
      "miscText"     -> "Wrth wneud yr ad-daliad, dim ond i ad-dalu arian grant y dylech ddefnyddio’r manylion banc hyn. Peidiwch â defnyddio’r manylion banc hyn i wneud unrhyw daliad arall i CThEM.",
      "emailTeam"    -> "y tîm Cymhorthdal Incwm Hunangyflogaeth"
    ),
    "vishing_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "vishing_code_submission_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ipr1_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ipr2_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ipr3_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "vat_declaration_confirmation" -> Map(
      "customerName" -> "Hugh Mann",
      "companyName"  -> "Acquisitions Incorporated"
    ),
    "trading_status_before_seiss_claimed" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "settlement_request" -> Map(
      "customerName" -> "Hugh Mann",
      "slaParam"     -> "within..."
    ),
    "complaint_consultation_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "complaint_consultation_code_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "consultation_complaint_confirmation" -> Map(
      "customerName"     -> "Hugh Mann",
      "consultationName" -> "Mr P Staker"
    ),
    "dan_waiver_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "duty_deferment_account_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "duty_deferment_account_amend_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "eat_out_help_out_confirmation" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "ni_vat_Status_reporting_confirmation" -> Map(
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ni_vat_Status_withdrawal_confirmation" -> Map(
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "tor_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "tor_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "tor_confirmation_dynamic" -> Map(
      "torDySub"            -> "HMRC received the additions to your for transfer of residence tax relief",
      "heading1"            -> "You made additions to your application for transfer  of residence tax relief",
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "para1"               -> "received additions to your application",
      "para2"               -> "the additions to your application are",
      "para3"               -> "",
      "para4"               -> "more",
      "para5"               -> "",
      "para6"               -> "",
      "para7"               -> "You can still use your URN to make further additions.",
      "para8"               -> "Select ‘start now’ from the GOV.UK page you used to start your original application. You can then confirm your email, then select ‘Make additions to an already approved application’."
    ),
    "jrsRemoval_submission_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "nrsDLT_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "nrsDLT_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "seissOverPayment_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "seissOverPayment_confirmation_cy" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "pesm_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "pesm_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "pesm_code_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ctDormancy_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ctDormancy_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ctDormancy_code_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "elcb_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "elcb_code_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "elcb_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ioss_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "businessName"        -> "Acquisitions Incorporated"
    ),
    "ioss_confirmation_cy" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "businessName"        -> "Acquisitions Incorporated"
    ),
    "ioss_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ioss_code_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "xiEORI_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "businessName"        -> "Acquisitions Incorporated"
    ),
    "nipbe_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "nipbe_confirmation_cy" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "seiss_voluntary_disclosure_confirmation" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "newMessageAlert_P800"        -> newMessageAlert_Names,
    "newMessageAlert_P800_cy"     -> newMessageAlert_Names,
    "newMessageAlert_PA302"       -> newMessageAlert_Names,
    "newMessageAlert_PA302_cy"    -> newMessageAlert_Names,
    "newMessageAlert_P800_D2"     -> newMessageAlert_Names,
    "newMessageAlert_P800_D2_cy"  -> newMessageAlert_Names,
    "newMessageAlert_PA302_D2"    -> newMessageAlert_Names,
    "newMessageAlert_PA302_D2_cy" -> newMessageAlert_Names,
    "oss_registration_confirmation_pre_10th_of_month" -> Map(
      "recipientName_line1"                -> "Joe Bloggs",
      "businessName"                       -> "Test Business",
      "reference"                          -> "123456789",
      "startDate"                          -> "12 June 2021",
      "lastDayOfCalendarQuarter"           -> "30 September 2021",
      "lastDayOfMonthAfterCalendarQuarter" -> "31 October 2021"
    ),
    "oss_registration_confirmation_post_10th_of_month" -> Map(
      "recipientName_line1"                    -> "Joe Bloggs",
      "businessName"                           -> "Test Business",
      "reference"                              -> "123456789",
      "lastDayOfCalendarQuarter"               -> "30 September 2021",
      "firstDayOfNextCalendarQuarter"          -> "1 October 2021",
      "startDate"                              -> "1 October 2021",
      "lastDayOfNextCalendarQuarter"           -> "31 December 2021",
      "lastDayOfMonthAfterNextCalendarQuarter" -> "31 January 2022"
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
    )
  )
}
