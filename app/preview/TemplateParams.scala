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

package preview

import play.api.libs.json.Json.{ parse, stringify }
import preview.TemplateParams.newMessageAlert_Names
import preview.examples.GG
import uk.gov.hmrc.hmrcemailrenderer.templates.cf.ContactFormsTemplates.{ cf_enquiry_confirmation, cf_enquiry_confirmation_cy }
import uk.gov.hmrc.hmrcemailrenderer.templates.rald.RaldTemplates.{ rald_connection_removed, rald_connection_removed_cy }
import uk.gov.hmrc.hmrcemailrenderer.templates.tctr.TctrTemplates._
import uk.gov.hmrc.hmrcemailrenderer.templates.customsfinancials.CustomsFinancialsTemplates.customsFinancialsChangeEmailAddress

import java.util.{ Base64, UUID }

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

  val exampleParams: Map[String, Map[String, String]] = GG.exampleParams ++
    Map(
      "aeo_mra_row_data_exchange_report" -> Map(
        "country_rows" -> Base64.getEncoder.encodeToString(stringify(parse("""
          [
            {"sendingCountry": "JP", "receivingCountry": "GB", "status": "MRA-AEO data received", "dateTime": "2021-05-04T11:16:49.938044Z"},
            {"sendingCountry": "JP", "receivingCountry": "GB", "status": "MRA-AEO data received", "dateTime": "2021-05-04T11:17:49.938044Z"},
            {"sendingCountry": "JP", "receivingCountry": "GB", "status": "MRA-AEO data received", "dateTime": "2021-05-04T11:18:49.938044Z"}
          ]
          """)).getBytes("UTF-8"))
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
      "cir_email_verification_code" -> Map(
        "team_name"         -> "CIR",
        "verification_code" -> "ABCDEF"
      ),
      "cir_email_verification_code_welsh" -> Map(
        "team_name"         -> "CIR",
        "verification_code" -> "ABCDEF"
      ),
      "client_rejected_authorisation_request" -> Map(
        "agencyName" -> "Agent 1",
        "clientName" -> "Client 2",
        "service"    -> "submit their VAT returns through software."
      ),
      "client_accepted_authorisation_request" -> Map(
        "agencyName"     -> "Agent 1",
        "clientName"     -> "Client 2",
        "service"        -> "manage their Making Tax Digital for Income Tax.",
        "additionalInfo" -> "You must now sign Client 2 up to Making Tax Digital for Income Tax."
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
      "agent_permissions_success" -> Map(
        "agencyName" -> "Agency"
      ),
      "agent_permissions_success_cy" -> Map(
        "agencyName" -> "Agency"
      ),
      "agent_permissions_some_failed" -> Map(
        "agencyName" -> "Agency"
      ),
      "agent_permissions_some_failed_cy" -> Map(
        "agencyName" -> "Agency"
      ),
      "agent_permissions_all_failed" -> Map(
        "agencyName" -> "Agency"
      ),
      "agent_permissions_all_failed_cy" -> Map(
        "agencyName" -> "Agency"
      ),
      "suspended_contact_details" -> Map(
        "agencyName"      -> "Romel W",
        "arn"             -> "TARN0000002",
        "contactName"     -> "Bobb Di Builder",
        "emailAddress"    -> "Rome@builders.com",
        "telephoneNumber" -> "+44(0) 208 123 4567",
        "description"     -> "This is where you add the details of issue"
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
        "applicationId"   -> "a4e14136-e283-4d79-be01-ebf230873285",
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
        "userFirstName"    -> "Fred",
        "userLastName"     -> "Bloggs",
        "applicationName"  -> "Test Application",
        "environmentName"  -> "Sandbox",
        "timeSinceLastUse" -> "11 months",
        "daysToDeletion"   -> "30 days"
      ),
      "apiProductionCredentialsRequestExpired" -> Map(
        "applicationName" -> "Test Application"
      ),
      "apiProductionCredentialsRequestExpiryWarning" -> Map(
        "applicationName" -> "Test Application"
      ),
      "apiVerifyResponsibleIndividual" -> Map(
        "developerHubLink"          -> exampleLinkWithRandomId,
        "applicationName"           -> "Test Application",
        "responsibleIndividualName" -> "Joe Bloggs",
        "requesterName"             -> "Bob Roberts"
      ),
      "apiVerifyResponsibleIndividualUpdate" -> Map(
        "developerHubLink"          -> exampleLinkWithRandomId,
        "applicationName"           -> "Test Application",
        "responsibleIndividualName" -> "Joe Bloggs",
        "requesterName"             -> "Bob Roberts"
      ),
      "apiResponsibleIndividualReminderToAdmin" -> Map(
        "applicationName"           -> "Test Application",
        "responsibleIndividualName" -> "Joe Bloggs",
        "requesterName"             -> "Bob Roberts"
      ),
      "apiResponsibleIndividualDeclined" -> Map(
        "applicationName"           -> "Test Application",
        "responsibleIndividualName" -> "Joe Bloggs",
        "requesterName"             -> "Bob Roberts"
      ),
      "apiResponsibleIndividualDidNotVerify" -> Map(
        "applicationName"           -> "Test Application",
        "responsibleIndividualName" -> "Joe Bloggs",
        "requesterName"             -> "Bob Roberts"
      ),
      "apiResponsibleIndividualNotChanged" -> Map(
        "applicationName"           -> "Test Application",
        "responsibleIndividualName" -> "Joe Bloggs"
      ),
      "apiChangeOfApplicationName" -> Map(
        "previousApplicationName" -> "Old Application Name",
        "newApplicationName"      -> "New Application Name",
        "requesterName"           -> "Bob Roberts"
      ),
      "apiChangeOfApplicationDetails" -> Map(
        "applicationName" -> "Nexus 6",
        "fieldName"       -> "application description",
        "previousValue"   -> "old description of what the application is and does",
        "newValue"        -> "new much better description of what the application is and does",
        "requesterName"   -> "Bob Roberts"
      ),
      "apiChangeOfResponsibleIndividual" -> Map(
        "applicationName"               -> "Nexus 6",
        "previousResponsibleIndividual" -> "Donald Trump",
        "newResponsibleIndividual"      -> "Joe Biden",
        "requesterName"                 -> "Bob Roberts"
      ),
      "apiAddedRegisteredMemberToOrganisationConfirmation" -> Map(
        "organisationName" -> "Test Organisation",
        "sdstEmailAddress" -> "SDSTeam@hmrc.gov.uk"
      ),
      "apiAddedUnregisteredMemberToOrganisationConfirmation" -> Map(
        "organisationName" -> "Test Organisation",
        "sdstEmailAddress" -> "SDSTeam@hmrc.gov.uk"
      ),
      "apiAddedMemberToOrganisationNotification" -> Map(
        "organisationName" -> "Test Organisation",
        "emailAddress"     -> "test.person@hmrc.gov.uk",
        "role"             -> "Admin"
      ),
      "apiRemovedMemberFromOrganisationConfirmation" -> Map(
        "organisationName" -> "Test Organisation"
      ),
      "apiRemovedMemberFromOrganisationNotification" -> Map(
        "organisationName" -> "Test Organisation",
        "emailAddress"     -> "test.person@hmrc.gov.uk",
        "role"             -> "Admin"
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
        "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
        "paragraphTwo"       -> "If you’re not entitled to a refund we will write and explain the reason why",
        "warningInformation" -> "true",
        "turnAroundTime"     -> "35 days"
      ),
      "dfs_submission_success_generic_2015_welsh" -> Map(
        "subject"             -> "Test Subject",
        "greeting"            -> "Mr Joe Bloggs",
        "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
        "submissionReference" -> "1234",
        "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
        "paragraphTwo"       -> "If you’re not entitled to a refund we will write and explain the reason why",
        "warningInformation" -> "true",
        "turnAroundTime"     -> "35 days"
      ),
      "dfs_submission_success_generic_2017" -> Map(
        "subject"             -> "Test Subject",
        "greeting"            -> "Mr Joe Bloggs",
        "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
        "submissionReference" -> "1234",
        "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
        "paragraphTwo"       -> "If you’re not entitled to a refund we will write and explain the reason why",
        "paragraphThree"     -> "Some extra content for paragraph three...",
        "warningInformation" -> "false",
        "turnAroundTime"     -> "35 days"
      ),
      "dfs_submission_success_generic_2017_welsh" -> Map(
        "subject"             -> "Test Subject",
        "greeting"            -> "Mr Joe Bloggs",
        "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
        "submissionReference" -> "1234",
        "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
        "paragraphTwo"       -> "If you’re not entitled to a refund we will write and explain the reason why",
        "paragraphThree"     -> "Some extra content for paragraph three...",
        "warningInformation" -> "false",
        "turnAroundTime"     -> "35 days"
      ),
      "dfs_submission_success_empty_turn_around_time_2015" -> Map(
        "subject"             -> "Test Subject",
        "greeting"            -> "Mr Joe Bloggs",
        "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
        "submissionReference" -> "1234",
        "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
        "paragraphTwo"       -> "If you’re not entitled to a refund we will write and explain the reason why",
        "warningInformation" -> "true"
      ),
      "dfs_submission_success_empty_turn_around_time_2015_welsh" -> Map(
        "subject"             -> "Test Subject",
        "greeting"            -> "Mr Joe Bloggs",
        "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
        "submissionReference" -> "1234",
        "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
        "paragraphTwo"       -> "If you’re not entitled to a refund we will write and explain the reason why",
        "warningInformation" -> "true"
      ),
      "dfs_submission_success_empty_turn_around_time_2020" -> Map(
        "subject"             -> "Test Subject",
        "heading"             -> "Test Heading",
        "greeting"            -> "Mr Joe Bloggs",
        "confirmation"        -> "HM Revenue and Customs (HMRC) has received your claim for a tax refund",
        "submissionReference" -> "1234",
        "paragraphOne" -> "If you’re entitled to a refund we will send you a revised tax calculation and pay you what you’re owed",
        "paragraphTwo"       -> "If you’re not entitled to a refund we will write and explain the reason why",
        "paragraphThree"     -> "If you’ve asked us to write to you, we’ll send you a letter within 15 working days",
        "paragraphFour"      -> "Some extra content for paragraph four...",
        "warningInformation" -> "true"
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
      "crs_fatca_registration_successful" -> Map(
        "name" -> "Joe Bloggs"
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
      "fandf_ask_help_notification_cy" -> Map(
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
      "fandf_offer_help_notification_cy" -> Map(
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
      rald_connection_removed -> Map(
        "recipientName_FullName" -> "David Jones",
        "submissionDate"         -> "22 March 2022",
        "submissionTime"         -> "15:45"
      ),
      rald_connection_removed_cy -> Map(
        "recipientName_FullName" -> "David Jones",
        "submissionDate"         -> "22 Mawrth 2022",
        "submissionTime"         -> "15:45"
      ),
      cf_enquiry_confirmation -> Map(
        "recipientName_FullName" -> "David Jones",
        "enquirySubject"         -> "Council Tax - My Council Tax bill",
        "submissionDate"         -> "28 January 2022",
        "submissionTime"         -> "13:45",
        "nextStep" -> "We usually respond to enquiries within a few days. However, complex enquiries can take up to 28 days."
      ),
      cf_enquiry_confirmation_cy -> Map(
        "recipientName_FullName" -> "David Jones",
        "enquirySubject"         -> "Treth Gyngor - Fy mil Treth Gyngor",
        "submissionDate"         -> "28 Ionawr 2022",
        "submissionTime"         -> "13:45",
        "nextStep" ->
          "Rydym yn ymateb i’r mwyafrif o ymholiadau o fewn ychydig ddyddiau. Fodd bynnag, gall ymholiadau cymhleth gymryd hyd at 28 diwrnod."
      ),
      tctr_submission_confirmation -> Map(
        "customerName" -> "John Doe"
      ),
      tctr_vacant_submission_confirmation -> Map(
        "recipientName_FullName" -> "David Jones",
        "submissionDate"         -> "27 March 2022",
        "submissionTime"         -> "4:33pm"
      ),
      tctr_connection_removed -> Map(
        "recipientName_FullName" -> "David Jones",
        "submissionDate"         -> "27 March 2022",
        "submissionTime"         -> "4:33pm"
      ),
      tctr_connection_removed_cy -> Map(
        "recipientName_FullName" -> "David Jones",
        "submissionDate"         -> "27 Mawrth 2022",
        "submissionTime"         -> "4:33pm"
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
      "register_your_company_verification_email_cy" -> Map(
        "verificationLink" -> exampleLinkWithRandomId
      ),
      "register_your_company_register_vat_email_v2" -> Map(
        "vatThreshold" -> "85,000"
      ),
      "register_your_company_register_vat_email_v2_cy" -> Map(
        "vatThreshold" -> "85,000"
      ),
      "register_your_company_register_paye_confirmation_current_tax_year_v2" -> Map(
        "companyName"     -> "ABC Logistics Ltd",
        "referenceNumber" -> "BRPY12345678910",
        "salutation"      -> "Dear Dave"
      ),
      "register_your_company_register_paye_confirmation_current_tax_year_v2_cy" -> Map(
        "companyName"     -> "ABC Logistics Ltd",
        "referenceNumber" -> "BRPY12345678910",
        "salutation"      -> "Annwyl Dave"
      ),
      "register_your_company_register_paye_confirmation_new_tax_year_v2" -> Map(
        "companyName"     -> "ABC Logistics Ltd",
        "referenceNumber" -> "BRPY12345678910",
        "salutation"      -> "Dear Dave",
        "contactDate"     -> "17 May"
      ),
      "register_your_company_register_paye_confirmation_new_tax_year_v2_cy" -> Map(
        "companyName"     -> "ABC Logistics Ltd",
        "referenceNumber" -> "BRPY12345678910",
        "salutation"      -> "Annwyl Dave",
        "contactDate"     -> "17 Mai"
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
      "ioss_netp_email_declaration_code" -> Map(
        "intermediary_name"           -> "The Test Company",
        "recipientName_line1"         -> "Joe Bloggs",
        "activation_code"             -> "ABCDEF",
        "activation_code_expiry_date" -> "25 July 2025"
      )
    )
}
object TemplateParams2 {
  val exampleLinkWithRandomId = s"http://host:8080/your/link/${UUID.randomUUID}"
  val exampleParams = Map(
    "hipp_production_access_approved_email" -> Map(
      "applicationname"      -> "Test-Hipp-App",
      "apispecificationname" -> "Test-Hipp-Api",
      "environmentname"      -> "Test-Hipp-Env"
    ),
    "hipp_production_access_rejected_email" -> Map(
      "applicationname"      -> "Test-Hipp-App",
      "apispecificationname" -> "Test-Hipp-Api",
      "environmentname"      -> "Test-Hipp-Env"
    ),
    "hipp_new_production_access_request_email" -> Map(
      "applicationname"      -> "Test-Hipp-App",
      "apispecificationname" -> "Test-Hipp-Api",
      "environmentname"      -> "Test-Hipp-Env"
    ),
    "hipp_production_access_request_submitted_email" -> Map(
      "applicationname"      -> "Test-Hipp-App",
      "apispecificationname" -> "Test-Hipp-Api",
      "environmentname"      -> "Test-Hipp-Env"
    ),
    "hipp_add_team_member_to_app_email" -> Map(
      "applicationname" -> "Test-Hipp-App",
      "creatorusername" -> "Test-Hipp-Member"
    ),
    "hipp_add_team_member_to_team_email" -> Map(
      "teamname" -> "Test-Hipp-Team"
    ),
    "hipp_remove_team_member_from_app_email" -> Map(
      "applicationname" -> "Test-Hipp-App",
      "creatorusername" -> "Test-Hipp-Member"
    ),
    "hipp_application_created" -> Map(
      "applicationname" -> "Test-Hipp-App"
    ),
    "hipp_application_deleted" -> Map(
      "applicationname" -> "Test-Hipp-App"
    ),
    "hipp_application_deleted_team" -> Map(
      "applicationname" -> "Test-Hipp-App"
    ),
    "hipp_api_ownership_added_email" -> Map(
      "teamname"             -> "My Team",
      "apispecificationname" -> "API Name"
    ),
    "hipp_api_ownership_removed_email" -> Map(
      "teamname"             -> "My Team",
      "otherteamname"        -> "New API Team",
      "apispecificationname" -> "API Name"
    ),
    "hipp_remove_member_from_team_member" -> Map(
      "teamname" -> "Test-Hipp-Team"
    ),
    "hipp_notify_application_new_owning_team" -> Map(
      "teamname"        -> "Test-Hipp-Team",
      "applicationname" -> "Test-Hipp-Application"
    ),
    "hipp_notify_application_old_owning_team" -> Map(
      "teamname"        -> "Test-Hipp-Team",
      "oldteamname"     -> "Old Test-Hipp-Team",
      "applicationname" -> "Test-Hipp-Application"
    ),
    "hipp_api_doc_rejected" -> Map(
      "apiname"             -> "MyApi",
      "documentdescription" -> "System Architecture Document v1.2"
    ),
    "hipp_api_doc_quarantined" -> Map(
      "apiname"             -> "MyApi",
      "documentdescription" -> "System Architecture Document v1.2"
    ),
    "hipp_api_doc_unknown_error" -> Map(
      "apiname"             -> "MyApi",
      "documentdescription" -> "System Architecture Document v1.2"
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
    "cir_email_verification_code" -> Map(
      "team_name"         -> "CIR",
      "verification_code" -> "ABCDEG"
    ),
    "cir_email_verification_code_welsh" -> Map(
      "team_name"         -> "CIR",
      "verification_code" -> "ABCDEG"
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
    "oss_registration_amendment_confirmation" -> Map(
      "recipientName_line1" -> "Joe Bloggs",
      "amendmentDate"       -> "23 May 2023"
    ),
    "platformContact" -> Map(
      "apiTitle"    -> "Individuals Tax Relief for Kitten Ownership",
      "senderName"  -> "Alice Example",
      "senderEmail" -> "alice@example.com",
      "contactReasons" -> Base64.getEncoder.encodeToString(stringify(parse("""[
          "I want to know if I can reuse this API",
          "I need more information, like schemas or examples"
        ]""")).getBytes("UTF-8")),
      "specificQuestion" -> "I need some stuff."
    ),
    "platformContactConfirmation" -> Map(
      "apiTitle"    -> "Individuals Tax Relief for Kitten Ownership",
      "senderName"  -> "Alice Example",
      "senderEmail" -> "alice@example.com",
      "contactReasons" -> Base64.getEncoder.encodeToString(stringify(parse("""[
          "I want to know if I can reuse this API",
          "I need more information, like schemas or examples"
        ]""")).getBytes("UTF-8")),
      "specificQuestion" -> "I need some stuff.",
      "apiEmail"         -> "api-platform@example.com"
    ),
    "telephone_payments_service" -> Map(
      "totalAmountPaid"      -> "1000.00",
      "transactionReference" -> "12345FFF",
      "cardType"             -> "Visa Debit",
      "cardNumber"           -> "1234",
      "tpsPaymentItemsForEmail" -> "[{\"taxType\":\"P800\",\"amount\":\"1.92\",\"transactionFee\":\"1.00\",\"transactionNumber\":\"12345\"}]"
    ),
    "face_to_face_payment_email_successful" -> Map(
      "totalAmountInPence"     -> "100000",
      "transactionReference"   -> "4012637",
      "cardType"               -> "Visa Debit",
      "cardNumber"             -> "**** **** **** 1234",
      "dateOfPayment"          -> "31 December 2021",
      "applicationId"          -> "A0000000031010",
      "panSequence"            -> "56",
      "merchantId"             -> "***2710",
      "terminalId"             -> "***2074",
      "cardVerificationMethod" -> "PIN verified",
      "authorisation"          -> "D12345",
      "transactionSource"      -> "Chip and PIN",
      "time"                   -> "5:30pm",
      "transactionType"        -> "Payment",
      "taxType"                -> "Self Assessment",
      "amountInPence"          -> "192",
      "transactionFeeInPence"  -> "100",
      "transactionNumber"      -> "1234567890K"
    ),
    "face_to_face_payment_email_unsuccessful" -> Map(
      "totalAmountInPence"     -> "100000",
      "transactionReference"   -> "4012637",
      "cardType"               -> "Visa Debit",
      "cardNumber"             -> "**** **** **** 1234",
      "dateOfPayment"          -> "31 December 2021",
      "applicationId"          -> "A0000000031010",
      "panSequence"            -> "56",
      "merchantId"             -> "***2710",
      "terminalId"             -> "***2074",
      "cardVerificationMethod" -> "PIN verified",
      "authorisation"          -> "Declined",
      "transactionSource"      -> "Chip and PIN",
      "time"                   -> "5:30pm",
      "transactionType"        -> "Payment",
      "taxType"                -> "Self Assessment",
      "amountInPence"          -> "192",
      "transactionFeeInPence"  -> "100",
      "transactionNumber"      -> "1234567890K"
    ),
    "face_to_face_payment_email_no_receipt_successful" -> Map(
      "totalAmountInPence"    -> "100000",
      "transactionReference"  -> "4012637",
      "taxType"               -> "Self Assessment",
      "amountInPence"         -> "192",
      "transactionFeeInPence" -> "100",
      "transactionNumber"     -> "1234567890K"
    ),
    "face_to_face_payment_email_no_receipt_unsuccessful" -> Map(
      "totalAmountInPence"    -> "100000",
      "transactionReference"  -> "4012637",
      "dateOfPayment"         -> "31 December 2021",
      "taxType"               -> "Self Assessment",
      "amountInPence"         -> "192",
      "transactionFeeInPence" -> "100"
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
      "totalPaid"    -> "126.00"
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
    "dd_email_verifcation" -> Map(
      "name"             -> "Joe",
      "verificationLink" -> exampleLinkWithRandomId
    ),
    "recon_finance_report" -> Map(
      "subject" -> "Telephone Payment Service (TPS) and Face to Face (F2F) Payment Service finance report 22/01/1989",
      "financeReport_sundry_card"           -> "4,2500.00,2,1200.00,6,3700.00",
      "financeReport_sundry_vatLegal"       -> "1,500.00,0,0,1,500.00",
      "financeReport_sundry_debitCard"      -> "4,25.05,1,11.25,5,36.30",
      "financeReport_sundry_commissionCard" -> "1,10.00,0,0,1,10.00",
      "financeReport_sundry_subTotal"       -> "5,3000.00,0,0,7,4200",
      "financeReport_chb_card"              -> "1,200.21,0,0,1,200.21",
      "financeReport_chb_debitCard"         -> "1,30.05,0,0,1,30.05",
      "financeReport_chb_commissionCard"    -> "0,0,0,0,0,0",
      "financeReport_chb_subTotal"          -> "1,230.05,0,0,1,230.03.05",
      "financeReport_total"                 -> "6,3230.05,0,0,8,4430.05"
    ),
    "recon_surcharge_report" -> Map(
      "subject"                                                 -> "Surcharge report 27/09/2027",
      "tpsDapiSurchargeReport_sa"                               -> "1,10.0,2,20.0,3,30.0",
      "tpsDapiSurchargeReport_ct"                               -> "1,10.0,2,20.0,3,30.0",
      "tpsDapiSurchargeReport_ntc"                              -> "1,10.0,2,20.0,3,30.0",
      "tpsDapiSurchargeReport_nps"                              -> "1,10.0,2,20.0,3,30.0",
      "tpsDapiSurchargeReport_total"                            -> "8,80.0,16,160.0,24,240.0",
      "f2fDapiSurchargeReport_total"                            -> "4,40.0,8,80.0,12,120.0",
      "opsDapiSurchargeReport_sa"                               -> "1,10.0,2,20.0,3,30.0",
      "opsDapiSurchargeReport_cotax"                            -> "1,10.0,2,20.0,3,30.0",
      "opsDapiSurchargeReport_totalShipley"                     -> "5,50.0,10,100.0,15,150.0",
      "tpsTpsoCombineDesSurchargeReport_sdlt"                   -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_vat"                    -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_safe"                   -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_epaye"                  -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_p800"                   -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_pngr"                   -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_childBenefitRepayments" -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_ppt"                    -> "1,10.0,2,20.0,3,30.0",
      "tpsTpsoCombineDesSurchargeReport_total"                  -> "3,30.0,6,60.0,9,90.0",
      "topsJustModsSurchargeReport_mods"                        -> "1,10.0,2,20.0,3,30.0",
      "f2fDesSurchargeReport_total"                             -> "4,40.0,8,80.0,12,120.0",
      "opsDesNoModsSurchargeReport_paye"                        -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_misc"                        -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_sdlt"                        -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_vat"                         -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_p800"                        -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_simpleAssessment"            -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_cgt"                         -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_pngr"                        -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_cds"                         -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_ppt"                         -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_childBenefitRepayments"      -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_vatOss"                      -> "1,10.0,2,20.0,3,30.0",
      "opsDesNoModsSurchargeReport_total"                       -> "8,80.0,16,160.0,22,240.0",
      "opsDesJustModsSurchargeReport_mods"                      -> "1,10.0,2,20.0,3,30.0"
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
    "mtdfb_vatreg_registration_received" -> Map(
      "name" -> "Joe Bloggs",
      "ref"  -> "VRS 1234 5678 9012"
    ),
    "mtdfb_vatreg_registration_received_post" -> Map(
      "name" -> "Joe Bloggs",
      "ref"  -> "VRS 1234 5678 9012"
    ),
    "mtdfb_vatreg_registration_received_cy" -> Map(
      "name" -> "Joe Bloggs",
      "ref"  -> "VRS 1234 5678 9012"
    ),
    "mtdfb_vatreg_registration_received_post_cy" -> Map(
      "name" -> "Joe Bloggs",
      "ref"  -> "VRS 1234 5678 9012"
    ),
    "pods_psa_invited" -> Map(
      "inviteeName" -> "Jane Doe",
      "schemeName"  -> "Some Pension Scheme",
      "expiryDate"  -> "20 July 1969"
    ),
    "pods_user_research_banner" -> Map(
      "psaName"    -> "Nigel Robert Smith",
      "comOrgName" -> "CompanyTestName",
      "psaId"      -> "1234567890",
      "psaEmail"   -> "nigel@test.com"
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
      "AllITEMS" -> "[{\"commodityDescription\":\"Beer\",\"volume\":\"100\",\"goodsValue\":\"400.00\",\"valueCurrency\":\"EUR\",\"valueCurrencyName\":\"Euro (EUR)\",\"originCountry\":\"FR\",\"originCountryName\":\"France\",\"exchangeRate\":\"1.1577\",\"exchangeRateDate\":\"2021-03-09\",\"goodsValueGBP\":\"345.51\",\"VATRESClaimed\":false,\"exciseGBP\":\"80.00\",\"customsGBP\":\"0.00\",\"vatGBP\":\"85.10\",\"ukVATPaid\":false,\"ukExcisePaid\":false}]"
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
    "tdq_fph_self_serve_nudge" -> Map(
      "developerName"   -> "John Smith",
      "month"           -> "October",
      "year"            -> "2019",
      "status"          -> "HEADERS_WITH_ERRORS",
      "applicationName" -> "My Well Behaved App",
      "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
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
    "pods_event_report_submitted" -> Map(
      "schemeName"    -> "Smith Harper pension scheme",
      "taxYear"       -> "2021-2022",
      "dateSubmitted" -> "5 January 2023 at 8:20pm",
      "hmrcEmail"     -> "pensions.administration@hmrc.gov.uk",
      "psaName"       -> "Jane Doe"
    ),
    "pods_pension_scheme_return_submitted" -> Map(
      "schemeName"     -> "Smith Harper pension scheme",
      "periodOfReturn" -> "7 April 2025 to 6 April 2026",
      "dateSubmitted"  -> "2 April 2025 at 8:20pm",
      "psaName"        -> "Jane Doe"
    ),
    "pods_pension_scheme_return_sipp_submitted" -> Map(
      "schemeName"     -> "Smith Harper pension scheme",
      "periodOfReturn" -> "7 April 2025 to 6 April 2026",
      "dateSubmitted"  -> "2 April 2025 at 8:20pm",
      "psaName"        -> "Jane Doe"
    ),
    "cbc_registration_successful_organisation" -> Map(
      "name"  -> "Joe Bloggs",
      "cbcID" -> "XWCBC0000000058"
    ),
    "cbc_file_upload_successful" -> Map(
      "contactName"   -> "Joe Bloggs",
      "orgName"       -> "ABC Ltd",
      "dateSubmitted" -> "11:14am on 20 March 2023",
      "messageRefId"  -> "XACBC0000123778",
      "reportType"    -> "The file contains new information for the reporting period.",
      "endPeriod"     -> "31 December 2023",
      "startPeriod"   -> "1 January 2023"
    ),
    "cbc_file_upload_unsuccessful" -> Map(
      "contactName"   -> "Joe Bloggs",
      "orgName"       -> "ABC Ltd",
      "dateSubmitted" -> "11:14am on 20 March 2023",
      "messageRefId"  -> "XACBC0000123778"
    ),
    "cbc_agent_file_upload_successful" -> Map(
      "contactName"       -> "Joe Bloggs",
      "dateSubmitted"     -> "11:14am on 20 March 2023",
      "messageRefId"      -> "XACBC0000123778",
      "cbcId"             -> "XWCBC0000000058",
      "clientTradingName" -> "ABC Ltd",
      "reportType"        -> "The file contains new information for the reporting period.",
      "endPeriod"         -> "31 December 2023",
      "startPeriod"       -> "1 January 2023"
    ),
    "cbc_agent_file_upload_unsuccessful" -> Map(
      "contactName"       -> "Joe Bloggs",
      "dateSubmitted"     -> "11:14am on 20 March 2023",
      "messageRefId"      -> "XACBC0000123778",
      "cbcId"             -> "XWCBC0000000058",
      "clientTradingName" -> "ABC Ltd"
    ),
    "dac6_registration_successful" -> Map(
      "name"   -> "Joe Bloggs",
      "dac6ID" -> "XXDAC000012345"
    ),
    "mdr_registration_successful_organisation" -> Map(
      "name"  -> "Joe Bloggs",
      "mdrID" -> "XWDAC0000000058"
    ),
    "mdr_registration_successful_individual" -> Map(
      "name"  -> "Joe Bloggs",
      "mdrID" -> "XWDAC0000000058"
    ),
    "mdr_file_upload_successful" -> Map(
      "contactName"       -> "Joe Bloggs",
      "dateAndTime"       -> "2:29pm on 27 January 2012",
      "messageRefId"      -> "XAMDR00012345671234567890123456789012345678901234567890123456789012345678901234567890",
      "reportTypeMessage" -> "The file contains new information in one report."
    ),
    "mdr_file_upload_unsuccessful" -> Map(
      "contactName"  -> "Joe Bloggs",
      "dateAndTime"  -> "2:29pm on 27 January 2012",
      "messageRefId" -> "XAMDR00012345671234567890123456789012345678901234567890123456789012345678901234567890"
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
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-ATAR-ORG",
      "serviceContent"         -> "You can now apply for an Advance Tariff Ruling."
    ),
    "ecc_subscription_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-ATAR-ORG",
      "serviceContent"         -> "Erbyn hyn, gallwch wneud cais am Ddyfarniad Tariffau Uwch."
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
    "cashDecEU_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "cash_declaration_UK" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cash_declaration_GB_Currency" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "currencyName1"       -> "British Pound - GBP",
      "currencyName2"       -> "Bosnia and Herzegovina Convertible Mark - BAM",
      "currencyName3"       -> "Sao Tome and Principe Dobra - STD",
      "currencyName4"       -> "United Arab Emirates Dirham - AED",
      "currencyName5"       -> "Brazil Real - BRL",
      "currencyAmount1"     -> "99,999,999.99",
      "currencyAmount2"     -> "2,000,000.00",
      "currencyAmount3"     -> "3000",
      "currencyAmount4"     -> "4,000,000",
      "currencyAmount5"     -> "5,000,000.00",
      "uploadDocText"       -> "You also uploaded a document telling HMRC about smaller values in other currencies."
    ),
    "cash_declaration_GB_Currency_cy" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "currencyName1"       -> "Punt y Deyrnas Unedig - GBP",
      "currencyName2"       -> "Marc Bosnia a Herzegovina - BAM",
      "currencyName3"       -> "Dobra São Tomé a Príncipe - STD",
      "currencyName4"       -> "Dirham yr Emiraethau Arabaidd Unedig - AED",
      "currencyName5"       -> "Real Brasil - BRL",
      "currencyAmount1"     -> "99,999,999.99",
      "currencyAmount2"     -> "2,000,000.00",
      "currencyAmount3"     -> "3000",
      "currencyAmount4"     -> "4,000,000",
      "currencyAmount5"     -> "5,000,000.00",
      "uploadDocText" -> "Rydych chi hefyd wedi uwchlwytho dogfen sy’n rhoi gwybod i CThEF am werthoedd llai mewn arian cyfred eraill."
    ),
    "cashDecUK_code" -> Map(
      "confirmationCode" -> "HGDY"
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
    "corporation_tax_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "register_for_fuel_duty_confirmation" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "adr_confirmation_submission" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "adr_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "adr_code_cy" -> Map(
      "confirmationCode" -> "HGDY"
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
    "challengeChildcare_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "challengeChildcare_code_cy" -> Map(
      "confirmationCode" -> "HGDY"
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
    "spbp_claim_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_claim_code_submission_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_notification_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_notification_code_submission_cy" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_record_code_submission" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "spbp_record_code_submission_cy" -> Map(
      "confirmationCode" -> "HGDY"
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
      "miscText" -> "When making the repayment, you must only use the bank details provided to repay the grant money. You must not use these bank details to make any other payment to HMRC.",
      "emailTeam" -> "the Self-Employment Income Support team"
    ),
    "seiss_repay_submission_cy" -> Map(
      "customerName" -> "Hugh Mann",
      "miscText" -> "Wrth wneud yr ad-daliad, dim ond i ad-dalu arian grant y dylech ddefnyddio’r manylion banc hyn. Peidiwch â defnyddio’r manylion banc hyn i wneud unrhyw daliad arall i CThEM.",
      "emailTeam" -> "y tîm Cymhorthdal Incwm Hunangyflogaeth"
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
      "para8" -> "Select ‘start now’ from the GOV.UK page you used to start your original application. You can then confirm your email, then select ‘Make additions to an already approved application’."
    ),
    "c117_application_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "c118_confirmation_dynamic" -> Map(
      "customerName"        -> "Hugh Mann",
      "c118DySub"           -> "HMRC received part of your AEO application",
      "c118Section"         -> "C118 Section 1 Part 1",
      "submissionReference" -> "NC38-N2ZC-TH68"
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
    "ioss_dereg_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "businessName"        -> "Acquisitions Incorporated",
      "changeNotice"        -> "deregistered from"
    ),
    "ioss_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ioss_dereg_code" -> Map(
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
    "xiEORI_change_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "nipbe_confirmation" -> Map(
      "nipbeDySub"          -> "You told HMRC about a specific purpose for an EORI number starting XI",
      "heading1"            -> "You told us you are using an EORI number starting XI",
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "para1"               -> "We will email you within 10 working days to confirm your records have been updated.",
      "para2"               -> "",
      "para3"               -> "We send a confirmation email for an application submitted online."
    ),
    "nipbe_confirmation_cy" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "seiss_voluntary_disclosure_confirmation" -> Map(
      "customerName" -> "Hugh Mann"
    ),
    "netp_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cjrs_disclosure_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "cjrsDisclosure_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "creative_industries_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "companyName"         -> "Acquisitions Incorporated"
    ),
    "qahc_confirmation" -> Map(
      "qahcDySub"           -> "HMRC received your QAHC information",
      "heading1"            -> "You notified HMRC about a QAHC",
      "heading2"            -> "Registering for Corporation Tax",
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "notification"        -> "your notification",
      "companyName"         -> "Acquisitions Incorporated",
      "para1"               -> "You told us you do not currently have a Corporation Tax Unique Taxpayer Reference.",
      "para2" -> "If you are not currently waiting to receive this reference, you should register for Corporation Tax as soon as possible.",
      "para3" -> "Search GOV.UK for ‘Set up a limited company’, and go to step seven of the guide."
    ),
    "creative_industries_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "qahc_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "pods_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "res1_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "res1_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "emailTeam"           -> "Pay As You Earn and Self Assessment team"
    ),
    "utt_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "companyName"         -> "Acquisitions Incorporated"
    ),
    "utt_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ppt_registration_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ppt_registration_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ppt_enquiry_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ppt_enquiry_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "psa1_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "psa1_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "vat652_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "para1" -> "Once we have processed the form we will send you a letter acknowledging your disclosure."
    ),
    "vat652_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ppt_return_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ppt_request_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "venture_capital_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "venture_capital_confirmation" -> Map(
      "customerName" -> "Hugh Mann",
      "businessName" -> "Acquisitions Incorporated",
      "captionExpression" -> "Seed Enterprise Investment Scheme (SEIS), Enterprise Investment Scheme (EIS) and Investment from a Venture Capital Trust (VCT)",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "trusts_report_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "trusts_report_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "trusts_request_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "trusts_request_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "chief_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "chief_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "paragraph1" -> "Acquisitions Incorporated cannot use CHIEF to make import declarations after the deadline of",
      "date1"      -> "30 September 2022.",
      "paragraph4" -> "This is because you told us Acquisitions Incorporated does not plan to move to using the Customs Declaration Service (CDS) in the future.",
      "paragraph5" -> "We can only give an extension for using CHIEF to make import declarations if a business plans to move to using CDS.",
      "emailTeam" -> "the Single Customs Platform team"
    ),
    "fprc_confirmation" -> Map(
      "customerName" -> "Hugh Mann",
      "businessName" -> "Acquisitions Incorporated",
      "para1" -> "We aim to look at the information you have sent within 7 working days. If you do not hear from us within that timeframe, you can contact us using the contact details and reference on the letter we sent. The reference is CFSS followed by 7 numbers.",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "gbEORI_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "gbCancelEORI_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "essPreNotification_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "essPreNotification_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "rndNotification_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "rndNotification_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "companyName"         -> "Acquisitions Incorporated",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "newMessageAlert_P800"        -> newMessageAlert_Names,
    "newMessageAlert_P800_cy"     -> newMessageAlert_Names,
    "newMessageAlert_PA302"       -> newMessageAlert_Names,
    "newMessageAlert_PA302_cy"    -> newMessageAlert_Names,
    "newMessageAlert_P800_D2"     -> newMessageAlert_Names,
    "newMessageAlert_P800_D2_cy"  -> newMessageAlert_Names,
    "newMessageAlert_PA302_D2"    -> newMessageAlert_Names,
    "newMessageAlert_PA302_D2_cy" -> newMessageAlert_Names,
    "new_message_alert_itsa"      -> newMessageAlert_Names,
    "new_message_alert_itsa_cy"   -> newMessageAlert_Names,
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
    "oss_registration_amendment_confirmation" -> Map(
      "recipientName_line1" -> "Joe Bloggs",
      "amendmentDate"       -> "23 May 2023"
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
    "ioss_netp_email_declaration_code" -> Map(
      "intermediary_name"           -> "The Test Company",
      "recipientName_line1"         -> "Mr Joe Bloggs",
      "activation_code"             -> "ABCDEF",
      "activation_code_expiry_date" -> "25 July 2025"
    )
  )
}
object TemplateParams3 {
  val exampleParams = Map(
    "ecc_subscription_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-GVMS-ORG",
      "serviceContent"         -> "Mae’r Gwasanaeth Symud Cerbydau Nwyddau yn barod i’w defnyddio"
    ),
    "open_banking_payment_successful" -> Map(
      "taxType"    -> "Self Assessment",
      "reference"  -> "1234567890K",
      "amountPaid" -> "123.45"
    ),
    "open_banking_payment_successful_fdp" -> Map(
      "taxType"              -> "Self Assessment",
      "paymentScheduledDate" -> "22 October 2027",
      "datePaymentSetUp"     -> "12 October 2027",
      "reference"            -> "1234567890K",
      "amountPaid"           -> "123.45"
    ),
    "open_banking_payment_successful_fdp_cy" -> Map(
      "taxType"              -> "Self Assessment",
      "paymentScheduledDate" -> "22 October 2027",
      "datePaymentSetUp"     -> "12 October 2027",
      "reference"            -> "1234567890K",
      "amountPaid"           -> "123.45"
    ),
    "ecc_subscription_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-CTC-ORG",
      "serviceContent"         -> "Mae’r System Gludo Gyfrifiadurol Newydd yn barod i’w defnyddio"
    ),
    "ecc_subscription_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-SS-ORG",
      "serviceContent"         -> "Mae’r Gwasanaeth Diogelwch yn GB yn barod i’w defnyddio"
    ),
    "ecc_subscription_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-CTS-ORG",
      "serviceContent"         -> "Mae’r Gwasanaethau Masnachwyr Tollau yn barod i’w defnyddio"
    ),
    "ecc_subscription_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-CDS-ORG",
      "serviceContent"         -> "Erbyn hyn, gallwch wneud cais am Ddyfarniad Tariffau Uwch."
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
    ),
    "apiNewTermsOfUseInvitation" -> Map(
      "completeBy"      -> "31 October 2023",
      "applicationName" -> "Test Application"
    ),
    "apiNewTermsOfUseConfirmation" -> Map(
      "applicationName" -> "Test Application"
    ),
    "apiResponsibleIndividualDeclinedV2" -> Map(
      "applicationName"           -> "Test Application",
      "responsibleIndividualName" -> "Joe Bloggs"
    ),
    "apiChangeOfApplicationDetailsNoValue" -> Map(
      "applicationName" -> "Nexus 6",
      "fieldName"       -> "privacy policy URL",
      "requesterName"   -> "Bob Roberts"
    ),
    "agent_permissions_beta_participant_details" -> Map(
      "arn"             -> "TARN0000001",
      "numClients"      -> "103",
      "contactName"     -> "Bob De Builder",
      "emailAddress"    -> "bob@builders.com",
      "telephoneNumber" -> "+44(0) 208 123 4567"
    ),
    "essDisclosure_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "essDisclosure_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "mod_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "mod_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "p626_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "p626_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "p11d_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "p11d_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "p11db_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "p11db_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "dynamicEmail_code" -> Map(
      "emailHeading"     -> "Confirm your email address",
      "emailSubjectCode" -> "Confirm your email address - GForm name",
      "emailFormName"    -> "Submit a return as a registered dealer in controlled oils (RDCO)",
      "confirmationCode" -> "HGDY",
      "emailContact"     -> "HMRC",
      "emailTeam"        -> "Email Team"
    ),
    "dynamicEmail_confirmation" -> Map(
      "heading1" -> "We have received your request to apply for, amend or cancel a PAYE settlement agreement",
      "para1" -> "We confirm we have received your request to apply for, amend or cancel a PAYE settlement agreement.",
      "para2" -> "We will respond to PSA applications and amendments within 30 working days. We will send written confirmation to the address you supplied.",
      "para3"        -> "If you have consented to communication by email we will use the email address you supplied.",
      "customerName" -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "emailSubjectConfirmation" -> "HMEC has received your request to apply for, amend or cancel a PAYE settlement agreement",
      "emailTeam" -> "From HMRC"
    ),
    "fullyDynamicEmail_confirmation" -> Map(
      "heading3"  -> "What you need to do next",
      "heading10" -> "Why you are receiving this email",
      "para1"     -> "Dear Hugh Mann",
      "para2"  -> "We have received your notification about the amount of VAT owed on goods moved to Northern Ireland.",
      "para3"  -> "If you have already paid, you do not need to do anything.",
      "para4"  -> "If you have not yet paid the VAT you owe, do this as soon as possible.",
      "para5"  -> "1. Go to GOV.UK",
      "para6"  -> "2. Search for ‘Pay taxes, penalties or enquiry settlements’",
      "para7"  -> "3. Follow the payment instructions on the page, using the payment details in this email.",
      "para8"  -> "Your payment reference:",
      "para9"  -> "Payment amount: £400",
      "para10" -> "We send a confirmation email for all forms submitted online.",
      "para11" -> "If you need to contact us, quote the form submission reference number: ",
      "para12" -> "If we need to contact you, we will use the details you provided.",
      "para13" -> "For security reasons, we have not included the details you submitted.",
      "para14" -> "From HMRC Customer Services Group",
      "bold8"  -> "XVC129182918273",
      "bold11" -> "197391827182917",
      "emailSubjectConfirmation" -> "You have notified HMRC of VAT owed on goods moved to Northern Ireland"
    ),
    "fullyDynamicEmail_confirmation_cy" -> Map(
      "heading3"  -> "What you need to do next",
      "heading10" -> "Why you are receiving this email",
      "para1"     -> "Dear Hugh Mann",
      "para2"  -> "We have received your notification about the amount of VAT owed on goods moved to Northern Ireland.",
      "para3"  -> "If you have already paid, you do not need to do anything.",
      "para4"  -> "If you have not yet paid the VAT you owe, do this as soon as possible.",
      "para5"  -> "1. Go to GOV.UK",
      "para6"  -> "2. Search for ‘Pay taxes, penalties or enquiry settlements’",
      "para7"  -> "3. Follow the payment instructions on the page, using the payment details in this email.",
      "para8"  -> "Your payment reference:",
      "para9"  -> "Payment amount: £400",
      "para10" -> "We send a confirmation email for all forms submitted online.",
      "para11" -> "If you need to contact us, quote the form submission reference number: ",
      "para12" -> "If we need to contact you, we will use the details you provided.",
      "para13" -> "For security reasons, we have not included the details you submitted.",
      "para14" -> "From HMRC Customer Services Group",
      "bold8"  -> "XVC129182918273",
      "bold11" -> "197391827182917",
      "emailSubjectConfirmation" -> "You have notified HMRC of VAT owed on goods moved to Northern Ireland"
    ),
    "dynamicEmail_code_cy" -> Map(
      "emailHeading"     -> "Confirm your email address",
      "emailSubjectCode" -> "Confirm your email address - GForm name",
      "emailFormName"    -> "Submit a return as a registered dealer in controlled oils (RDCO)",
      "confirmationCode" -> "HGDY",
      "emailContact"     -> "HMRC",
      "emailTeam"        -> "Email Team"
    ),
    "dynamicEmail_confirmation_cy" -> Map(
      "heading1" -> "We have received your return as a registered dealer in controlled oils",
      "heading4" -> "Keep your details up-to-date",
      "para1"    -> "We confirm we have received your return as a registered dealer in controlled oils.",
      "para2"    -> "Your return will now be processed.",
      "para3"    -> "If we need to discuss your return, we will get in touch using the contact information we hold.",
      "para4"    -> "You can email HMRC at morcexciseeast@@hmrc.gov.uk to update your details.",
      "customerName"             -> "Hugh Mann",
      "submissionReference"      -> "NC38-N2ZC-TH68",
      "emailSubjectConfirmation" -> "Email Subject",
      "emailTeam"                -> "From Email Team"
    ),
    "rndClaim_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "rndClaim_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "companyName"         -> "Acquisitions Incorporated"
    ),
    "ecc_registration_successful" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-ATAR-ORG"
    ),
    "ecc_registration_successful_cy" -> Map(
      "recipientName_FullName" -> "Jane Jones",
      "serviceName"            -> "Advance Tariff Rulings",
      "enrolmentKey"           -> "HMRC-ATAR-ORG"
    ),
    "eis_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "eis_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "seis_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "sdes_alert" -> Map(
      "heading" -> "You have unprocessed SDES items",
      "paragraph" -> "There are 2 new envelopes and a total of 15 unprocessed SDES envelopes. You can view these under 'Sdes Submissions' in your EEITT dashboard."
    ),
    "seis_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ca3822_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ca3822_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "ho5_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68"
    ),
    "ho5_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "cds_confirmation" -> Map(
      "customerName"        -> "Hugh Mann",
      "submissionReference" -> "NC38-N2ZC-TH68",
      "emailTeam"           -> "From HMRC CDS Operations"
    ),
    "cds_code" -> Map(
      "confirmationCode" -> "HGDY"
    ),
    "cir_email_verification_code" -> Map(
      "team_name"         -> "CIR",
      "verification_code" -> "ABCDEH"
    ),
    "cir_email_verification_code_welsh" -> Map(
      "team_name"         -> "CIR",
      "verification_code" -> "ABCDEH"
    ),
    "face_to_face_payment_email_successful_cy" -> Map(
      "totalAmountInPence"     -> "100000",
      "transactionReference"   -> "4012637",
      "cardType"               -> "Visa Debit",
      "cardNumber"             -> "**** **** **** 1234",
      "dateOfPayment"          -> "31 December 2021",
      "applicationId"          -> "A0000000031010",
      "panSequence"            -> "56",
      "merchantId"             -> "***2710",
      "terminalId"             -> "***2074",
      "cardVerificationMethod" -> "PIN verified",
      "authorisation"          -> "D12345",
      "transactionSource"      -> "Chip and PIN",
      "time"                   -> "5:30pm",
      "transactionType"        -> "Payment",
      "taxType"                -> "Self Assessment",
      "amountInPence"          -> "192",
      "transactionFeeInPence"  -> "100",
      "transactionNumber"      -> "1234567890K"
    ),
    "face_to_face_payment_email_unsuccessful_cy" -> Map(
      "totalAmountInPence"     -> "100000",
      "transactionReference"   -> "4012637",
      "cardType"               -> "Visa Debit",
      "cardNumber"             -> "**** **** **** 1234",
      "dateOfPayment"          -> "31 December 2021",
      "applicationId"          -> "A0000000031010",
      "panSequence"            -> "56",
      "merchantId"             -> "***2710",
      "terminalId"             -> "***2074",
      "cardVerificationMethod" -> "PIN verified",
      "authorisation"          -> "Declined",
      "transactionSource"      -> "Chip and PIN",
      "time"                   -> "5:30pm",
      "transactionType"        -> "Payment",
      "taxType"                -> "Self Assessment",
      "amountInPence"          -> "192",
      "transactionFeeInPence"  -> "100",
      "transactionNumber"      -> "1234567890K"
    ),
    "face_to_face_payment_email_no_receipt_successful_cy" -> Map(
      "totalAmountInPence"    -> "100000",
      "transactionReference"  -> "4012637",
      "dateOfPayment"         -> "31 December 2021",
      "taxType"               -> "Self Assessment",
      "amountInPence"         -> "192",
      "transactionFeeInPence" -> "100",
      "transactionNumber"     -> "1234567890K"
    ),
    "face_to_face_payment_email_no_receipt_unsuccessful_cy" -> Map(
      "totalAmountInPence"    -> "100000",
      "transactionReference"  -> "4012637",
      "dateOfPayment"         -> "31 December 2021",
      "taxType"               -> "Self Assessment",
      "amountInPence"         -> "192",
      "transactionFeeInPence" -> "100"
    ),
    "cds_ddi_amended_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "cds_regime"          -> "CDS"
    ),
    "cds_ddi_cancelled_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "cds_regime"          -> "CDS"
    ),
    "cds_ddi_not_acceptable_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "cds_regime"          -> "CDS"
    ),
    "cds_ddi_reinstated_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "cds_regime"          -> "CDS"
    ),
    "cds_ddi_reminder_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "cds_regime"          -> "CDS"
    ),
    "cds_ddi_setup_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "cds_regime"          -> "CDS"
    ),
    "cds_ddi_unpaid_dcs_alert" -> Map(
      "recipientName_line1" -> "Joe Smith",
      "cds_regime"          -> "CDS"
    ),
    "sdds_ddi_setup_dcs_alert" -> Map(
      "subject"             -> "regime Direct Debit Setup",
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_setup_dcs_alert_cy" -> Map(
      "subject"             -> "regime Direct Debit Setup(Welsh)",
      "recipientName_line1" -> "Cadfael Jones",
      "sdds_regimeName"     -> "Ardoll y Diwydiant Diodydd Ysgafn"
    ),
    "sdds_ddi_amended_dcs_alert" -> Map(
      "subject"             -> "regime Direct Debit Amended",
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_amended_dcs_alert_cy" -> Map(
      "subject"             -> "regime Direct Debit Amended(Welsh)",
      "recipientName_line1" -> "Cadfael Jones",
      "sdds_regimeName"     -> "Ardoll y Diwydiant Diodydd Ysgafn"
    ),
    "sdds_ddi_cancelled_dcs_alert" -> Map(
      "subject"             -> "regime Direct Debit Cancelled",
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_cancelled_dcs_alert_cy" -> Map(
      "subject"             -> "regime Direct Debit Cancelled(Welsh)",
      "recipientName_line1" -> "Cadfael Jones",
      "sdds_regimeName"     -> "Ardoll y Diwydiant Diodydd Ysgafn"
    ),
    "sdds_ddi_reminder_dcs_alert" -> Map(
      "subject"             -> "regime Direct Debit Reminder",
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_reminder_dcs_alert_cy" -> Map(
      "subject"             -> "regime Direct Debit Reminder(Welsh)",
      "recipientName_line1" -> "Cadfael Jones",
      "sdds_regimeName"     -> "Ardoll y Diwydiant Diodydd Ysgafn"
    ),
    "sdds_ddi_unpaid_dcs_alert" -> Map(
      "subject"             -> "regime Direct Debit Unpaid",
      "recipientName_line1" -> "Joe Smith",
      "sdds_regimeName"     -> "Soft Drinks Industry Levy"
    ),
    "sdds_ddi_unpaid_dcs_alert_cy" -> Map(
      "subject"             -> "regime Direct Debit Unpaid(Welsh)",
      "recipientName_line1" -> "Cadfael Jones",
      "sdds_regimeName"     -> "Ardoll y Diwydiant Diodydd Ysgafn"
    ),
    "ecl_registration_submitted" -> Map(
      "name"                     -> "John Doe",
      "eclRegistrationReference" -> "XMECL0000000001",
      "eclRegistrationDate"      -> "20 September 2023",
      "dateDue"                  -> "30 September 2024",
      "isPrimaryContact"         -> "true",
      "secondContactEmail"       -> "joe.smith@test.com",
      "previousFY"               -> "2022",
      "currentFY"                -> "2023"
    ),
    "ecl_registration_submitted_cy" -> Map(
      "name"                     -> "John Doe",
      "eclRegistrationReference" -> "XMECL0000000001",
      "eclRegistrationDate"      -> "20 September 2023",
      "dateDue"                  -> "30 September 2024",
      "isPrimaryContact"         -> "true",
      "secondContactEmail"       -> "joe.smith@test.com",
      "previousFY"               -> "2022",
      "currentFY"                -> "2023"
    ),
    "ecl_return_submitted" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "1 September 2023",
      "periodStartDate" -> "1 April 2022",
      "periodEndDate"   -> "31 March 2023",
      "chargeReference" -> "XY007000075424",
      "fyStartYear"     -> "2022",
      "fyEndYear"       -> "2023",
      "datePaymentDue"  -> "30 September 2023",
      "amountDue"       -> "£10,000"
    ),
    "ecl_return_submitted_cy" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "1 Medi 2023",
      "periodStartDate" -> "1 Ebrill 2022",
      "periodEndDate"   -> "31 Mawrth 2023",
      "chargeReference" -> "XY007000075424",
      "fyStartYear"     -> "2022",
      "fyEndYear"       -> "2023",
      "datePaymentDue"  -> "30 Medi 2023",
      "amountDue"       -> "£10,000"
    ),
    "ecl_nil_return_submitted" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "1 September 2023",
      "periodStartDate" -> "1 April 2022",
      "periodEndDate"   -> "31 March 2023",
      "fyStartYear"     -> "2022",
      "fyEndYear"       -> "2023",
      "amountDue"       -> "£0"
    ),
    "ecl_nil_return_submitted_cy" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "1 Medi 2023",
      "periodStartDate" -> "1 Ebrill 2022",
      "periodEndDate"   -> "31 Mawrth 2023",
      "fyStartYear"     -> "2022",
      "fyEndYear"       -> "2023",
      "amountDue"       -> "£0"
    ),
    "ecl_amend_return_submitted" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "1 September 2023",
      "periodStartDate" -> "1 April 2022",
      "periodEndDate"   -> "31 March 2023",
      "addressLine1"    -> "testLine1",
      "addressLine2"    -> "testLine2",
      "addressLine3"    -> "testLine3",
      "addressLine4"    -> "testLine4",
      "containsAddress" -> "true"
    ),
    "ecl_amend_return_submitted_cy" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "1 September 2023",
      "periodStartDate" -> "1 April 2022",
      "periodEndDate"   -> "31 March 2023",
      "addressLine1"    -> "testLine1",
      "addressLine2"    -> "testLine2",
      "addressLine3"    -> "testLine3",
      "addressLine4"    -> "testLine4",
      "containsAddress" -> "true"
    ),
    "ecl_amend_registration_submitted" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "31 March 2023",
      "addressLine1"    -> "testLine1",
      "addressLine2"    -> "testLine2",
      "addressLine3"    -> "testLine3",
      "addressLine4"    -> "testLine4",
      "containsAddress" -> "true"
    ),
    "ecl_amend_registration_submitted_cy" -> Map(
      "name"            -> "John Doe",
      "dateSubmitted"   -> "31 March 2023",
      "addressLine1"    -> "testLine1",
      "addressLine2"    -> "testLine2",
      "addressLine3"    -> "testLine3",
      "addressLine4"    -> "testLine4",
      "containsAddress" -> "true"
    ),
    "ecl_deregistration_requested" -> Map(
      "name"               -> "John Doe",
      "dateSubmitted"      -> "28 February 2024",
      "addressLine1"       -> "testLine1",
      "addressLine2"       -> "testLine2",
      "addressLine3"       -> "testLine3",
      "addressLine4"       -> "testLine4",
      "eclReferenceNumber" -> "XMECL0000000001"
    ),
    "ecl_deregistration_requested_cy" -> Map(
      "name"               -> "John Doe",
      "dateSubmitted"      -> "28 February 2024",
      "addressLine1"       -> "testLine1",
      "addressLine2"       -> "testLine2",
      "addressLine3"       -> "testLine3",
      "addressLine4"       -> "testLine4",
      "eclReferenceNumber" -> "XMECL0000000001"
    ),
    "ars_notification_template" -> Map(
      "name" -> "Victoria sponge"
    ),
    "feeback_answers_for_digital_persona" -> Map(
      "config" -> "eyJuYW1lIjoidGVzdCIsImxhYmVsIjoiQVNNIHNhdGlzZmFjdGlvbiBzdXJ2ZXkiLCJxdWVzdGlvbnMiOlt7ImxhYmVsIjoiT24gYSBzY2FsZSBvZiAxIHRvIDEwIGhvdyB1c2VmdWwgd2FzIHRoZSBhdGEgb3BpbmlvbiBkYXRhPyIsInJhbmdlIjpbMCwxMF0sInR5cGUiOiJzbGlkZXIifSx7ImxhYmVsIjoiSG93IG11Y2ggZG8geW91IGFncmVlPyBUaGUgYW1vdW50IG9mIHRpbWUgaXQgdG9vayBmb3IgbXkgYmFnIHRvIGJlIGxvYWRlZC91bmxvYWRlZCB3YXMgcmVhc29uYWJsZSIsIm9wdGlvbnMiOlsiU3Ryb25nbHkgRGlzYWdyZWUiLCJTb21ld2hhdCBEaXNhZ3JlZSIsIk5laXRoZXIgQWdyZWUgbm9yIERpc2FncmVlIiwiU29tZXdoYXQgQWdyZWUiLCJTdHJvbmdseSBBZ3JlZSJdLCJ0eXBlIjoicmFkaW8ifSx7ImxhYmVsIjoiSXMgdGhlcmUgYW55IG90aGVyIHRoaW5nIHlvdSB3b3VsZCBsaWtlIHVzIHRvIGtub3c/Iiwib3B0aW9uYWwiOnRydWUsInR5cGUiOiJ0ZXh0QXJlYSJ9XSwiYWN0aXZlIjp7ImZyb20iOiIyMDIzLTAzLTAxVDAwOjAwOjAwWiIsInRvIjoiMjAyMy0wNC0wMVQwMDowMDowMFoifSwic2hvd09uY2UiOmZhbHNlLCJzaG93UmF0ZSI6MX0=",
      "answers" -> "eyJuYW1lIjoidGVzdCIsImFuc3dlcnMiOlsiMiIsIjMiLCJIb3BlIHRoaXMgd29ya3MiXX0="
    ),
    "ecl_registration_received" -> Map(
      "name"       -> "John Doe",
      "dateDue"    -> "30 September 2024",
      "previousFY" -> "2022",
      "currentFY"  -> "2023"
    ),
    "iforms_submission_rejection_email_non_agent" -> Map(
      "name" -> "John"
    ),
    "iforms_submission_rejection_email_non_agent_cy" -> Map(
      "name" -> "John"
    ),
    "iforms_submission_rejection_email_agent" -> Map(
      "name" -> "John Doe"
    ),
    "iforms_submission_rejection_email_agent_cy" -> Map(
      "name" -> "John Doe"
    ),
    "ecl_registration_received_cy" -> Map(
      "name"       -> "John Doe",
      "dateDue"    -> "30 Medi 2024",
      "previousFY" -> "2022",
      "currentFY"  -> "2023"
    ),
    "customs_financials_requested_duty_deferment_not_found" -> Map(
      "recipientName_FullName" -> "ABC ltd"
    ),
    "customs_financials_requested_c79_certificate_not_found" -> Map(
      "recipientName_FullName" -> "ABC ltd"
    ),
    "customs_financials_requested_postponed_import_vat_statements_not_found" -> Map(
      "recipientName_FullName" -> "ABC ltd"
    ),
    "customs_financials_requested_notification_adjustment_statements_not_found" -> Map(
      "recipientName_FullName" -> "ABC ltd"
    ),
    "customs_financials_requested_cash_account_transactions" -> Map(
      "recipientName_FullName" -> "ABC ltd"
    ),
    customsFinancialsChangeEmailAddress -> Map(
      "emailAddress" -> "tony@abcltd.com"
    ),
    "undertaking_admin_deadline_reminder" -> Map(
      "deadline" -> "23 November 2023"
    ),
    "undertaking_admin_deadline_expired" -> Map(
      "deadline" -> "23 November 2023"
    ),
    "dprs_registration_submitted" -> Map(
      "name"   -> "Homer Simpson",
      "dprsId" -> "XLDPI0023000377"
    ),
    "dprs_added_platform_operator" -> Map(
      "userPrimaryContactName" -> "Ashley Smith",
      "poBusinessName"         -> "Vinted",
      "poId"                   -> "PO12345678"
    ),
    "dprs_added_as_platform_operator" -> Map(
      "poPrimaryContactName" -> "Tim Vinted",
      "poId"                 -> "PO12345678",
      "poBusinessName"       -> "Vinted"
    ),
    "dprs_removed_platform_operator" -> Map(
      "userPrimaryContactName" -> "Ashley Smith",
      "poBusinessName"         -> "Vinted",
      "poId"                   -> "PO12345678"
    ),
    "dprs_removed_as_platform_operator" -> Map(
      "poPrimaryContactName" -> "Tim Vinted",
      "poId"                 -> "PO12345678",
      "poBusinessName"       -> "Vinted"
    ),
    "dprs_updated_platform_operator" -> Map(
      "userPrimaryContactName" -> "Ashley Smith",
      "poBusinessName"         -> "Vinted"
    ),
    "dprs_updated_as_platform_operator" -> Map(
      "poPrimaryContactName" -> "Tim Vinted",
      "poBusinessName"       -> "Vinted"
    ),
    "dprs_added_reporting_notification" -> Map(
      "userPrimaryContactName" -> "Ashley Smith",
      "poBusinessName"         -> "Vinted"
    ),
    "dprs_added_reporting_notification_for_you" -> Map(
      "poPrimaryContactName"       -> "Tim Vinted",
      "isReportingPO"              -> "true",
      "reportablePeriodYear"       -> "2024",
      "poBusinessName"             -> "Vinted",
      "isExtendedDueDiligence"     -> "true",
      "isActiveSellerDueDiligence" -> "true"
    ),
    "dprs_successful_xml_submission_user" -> Map(
      "userPrimaryContactName"  -> "Ashley Smith",
      "poBusinessName"          -> "Vinted",
      "poId"                    -> "PO12345678",
      "checksCompletedDateTime" -> "9:15am on 25 January 2024",
      "reportingPeriod"         -> "2024",
      "fileName"                -> "some-file-name.xml"
    ),
    "dprs_successful_xml_submission_platform_operator" -> Map(
      "poPrimaryContactName"    -> "Tim Vinted",
      "poBusinessName"          -> "Vinted",
      "poId"                    -> "PO12345678",
      "checksCompletedDateTime" -> "9:15am on 25 January 2024",
      "reportingPeriod"         -> "2024",
      "fileName"                -> "some-file-name.xml"
    ),
    "dprs_failed_xml_submission_user" -> Map(
      "userPrimaryContactName"  -> "Ashley Smith",
      "poBusinessName"          -> "Vinted",
      "checksCompletedDateTime" -> "9:15am on 25 January 2024",
      "fileName"                -> "some-file-name.xml"
    ),
    "dprs_failed_xml_submission_platform_operator" -> Map(
      "poPrimaryContactName"    -> "Tim Vinted",
      "poBusinessName"          -> "Vinted",
      "checksCompletedDateTime" -> "9:15am on 25 January 2024"
    ),
    "dprs_add_assumed_reporting_user" -> Map(
      "userPrimaryContactName"   -> "Ashley Smith",
      "checksCompletedDateTime"  -> "9:15am on 25 January 2024",
      "assumingPlatformOperator" -> "Assuming PO",
      "poBusinessName"           -> "Vinted",
      "reportingPeriod"          -> "2024"
    ),
    "dprs_add_assumed_reporting_platform_operator" -> Map(
      "poPrimaryContactName"     -> "Tim Vinted",
      "checksCompletedDateTime"  -> "9:15am on 25 January 2024",
      "assumingPlatformOperator" -> "Assuming PO",
      "poBusinessName"           -> "Vinted",
      "reportingPeriod"          -> "2024"
    ),
    "dprs_update_assumed_reporting_user" -> Map(
      "userPrimaryContactName"   -> "Ashley Smith",
      "checksCompletedDateTime"  -> "9:15am on 25 January 2024",
      "assumingPlatformOperator" -> "Assuming PO",
      "poBusinessName"           -> "Vinted",
      "reportingPeriod"          -> "2024"
    ),
    "dprs_update_assumed_reporting_platform_operator" -> Map(
      "poPrimaryContactName"     -> "Tim Vinted",
      "checksCompletedDateTime"  -> "9:15am on 25 January 2024",
      "assumingPlatformOperator" -> "Assuming PO",
      "poBusinessName"           -> "Vinted",
      "reportingPeriod"          -> "2024"
    ),
    "dprs_delete_assumed_reporting_user" -> Map(
      "userPrimaryContactName"   -> "Ashley Smith",
      "checksCompletedDateTime"  -> "9:15am on 25 January 2024",
      "assumingPlatformOperator" -> "Assuming PO",
      "poBusinessName"           -> "Vinted",
      "reportingPeriod"          -> "2024"
    ),
    "dprs_delete_assumed_reporting_platform_operator" -> Map(
      "poPrimaryContactName"     -> "Tim Vinted",
      "checksCompletedDateTime"  -> "9:15am on 25 January 2024",
      "assumingPlatformOperator" -> "Assuming PO",
      "poBusinessName"           -> "Vinted",
      "reportingPeriod"          -> "2024"
    ),
    "entity_check_notification" -> Map(
      "arn"          -> "XARN000034892",
      "utr"          -> "489021408",
      "agencyName"   -> "Test Agent",
      "failedChecks" -> "Agent (individual) is deceased | Agent is present on the 'Refuse to Deal With' list",
      "dateTime"     -> "26 April 2024 08:34am"
    ),
    "tgp_download_record_notification_email" -> Map(
      "expiredDate" -> "18 August 2024"
    ),
    "tgp_download_record_notification_email_cy" -> Map(
      "expiredDate" -> "18 Awst 2024"
    ),
    "tgp_download_record_failure_notification_email" -> Map(
      "expiredDate" -> "18 August 2024"
    ),
    "tgp_download_record_failure_notification_email_cy" -> Map(
      "expiredDate" -> "18 Awst 2024"
    ),
    "tre_report_available" -> Map(
      "reportRequestId" -> "XXXXX678"
    ),
    "tre_report_available_non_verified" -> Map(
      "reportRequestId" -> "XXXXX678"
    ),
    "tre_report_failed" -> Map(
      "reportRequestId" -> "XXXXX678"
    ),
    "tre_report_failed_non_verified" -> Map(
      "reportRequestId" -> "XXXXX678"
    ),
    "tre_third_party_access_removed" -> Map(
      "businessName" -> "TestBusiness"
    ),
    "ngr_registration_successful" -> Map(
      "firstName" -> "Jim",
      "lastName"  -> "Ferguson",
      "reference" -> "123ABC"
    ),
    "ngr_add_property_request_sent" -> Map(
      "firstName"         -> "Jim",
      "lastName"          -> "Ferguson",
      "reference"         -> "123ABC",
      "postcodeFirstPart" -> "BS15"
    ),
    "pillar2_gir_submission_successful" -> Map(
      "referenceId"           -> "REF123456789",
      "pillar2Id"             -> "XMPLR0123456789",
      "submissionDate"        -> "15/10/2025",
      "submissionTime"        -> "14:35",
      "accountingPeriodStart" -> "01/04/2024",
      "accountingPeriodEnd"   -> "31/03/2025"
    ),
    "pillar2_gir_submission_generic_errors" -> Map(
      "referenceId"           -> "REF987654321",
      "pillar2Id"             -> "XMPLR9876543210",
      "submissionDate"        -> "15/10/2025",
      "submissionTime"        -> "15:20",
      "accountingPeriodStart" -> "01/04/2024",
      "accountingPeriodEnd"   -> "31/03/2025",
      "errors" -> stringify(parse("""[
        {
          "errorCode": "Error Code 16",
          "description": "The structure of the DocRefId is not in the correct format, as set out in the HMRC Pillar 2 Business Rules.",
          "docRefIds": "GB2025FRPLRX1234, FR2023GBXPLR1234",
          "count": "2"
        },
        {
          "errorCode": "Error Code 21",
          "description": "Where the DocTypeIndic is OECD2 or OECD3, the DocSpec element must contain a CorrDocRefId element.",
          "docRefIds": "GB2025GB-PLRX123",
          "count": "1"
        },
        {
          "errorCode": "Error Code 35",
          "description": "The MessageRefId must be unique and must not have been used in a previous message.",
          "docRefIds": "GB2025PLRX456789",
          "count": "1"
        }
      ]"""))
    ),
    "pillar2_gir_submission_critical_errors" -> Map(
      "referenceId"    -> "REF555666777",
      "pillar2Id"      -> "XMPLR5556667777",
      "submissionDate" -> "15/10/2025",
      "submissionTime" -> "16:45",
      "errors" -> stringify(parse("""[
        {
          "errorCode": "Temp Pillar 2 Error Code 1",
          "businessRuleName": "Failed Threat Scan",
          "errorLevel": "DocRefId(s)",
          "description": "Submissions must not include Prohibited Characters or Entity References in the MessageRefId or DocRefId. Submissions must not include Prohibited Characters, these have to be escaped using Entity References in all element values in the DPIBody."
        },
        {
          "errorCode": "Temp Pillar 2 Error Code 2",
          "businessRuleName": "Failed Schema Validation",
          "errorLevel": "File",
          "description": "The referenced file failed validation against the GIR XML Schema."
        },
        {
          "errorCode": "Temp Pillar 2 Error Code 4",
          "businessRuleName": "Test Data",
          "errorLevel": "DocRefId(s)",
          "description": "The referenced file contains one or more records with a DocTypeIndic value in the range OECD10-OECD13, indicating test data. As a result, the receiving Competent Authority cannot accept this file as a valid GIR file submission."
        }
      ]"""))
    )
  )
}
