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

package uk.gov.hmrc.hmrcemailrenderer.templates

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpecLike
import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.services._
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import org.scalatest.OptionValues
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.templates.cf.ContactFormsTemplates.{ cf_enquiry_confirmation, cf_enquiry_confirmation_cy, contactFormsGroup }
import uk.gov.hmrc.hmrcemailrenderer.templates.rald.RaldTemplates.{ raldGroup, rald_connection_removed, rald_connection_removed_cy }

class TemplateLocatorSpec extends AnyWordSpecLike with should.Matchers with OptionValues with GuiceOneAppPerSuite {

  "The template locator when requested Welsh template" should {

    "return Welsh version of template if it exists" in new TestCase {
      templateLocatorWithWelsh
        .findTemplate("template-templateGroup-1-2_cy")
        .value
        .templateId shouldBe "template-templateGroup-1-2_cy"
    }
    "return English version of template if Welsh virsion doesn't exists  " in new TestCase {
      templateLocator
        .findTemplate("template-templateGroup-1-2_cy")
        .value
        .templateId shouldBe "template-templateGroup-1-2"
    }
    "return None if template doesn't exist" in new TestCase {
      templateLocator.findTemplate("foobar-template") shouldBe None
    }
  }

  "The template locator" should {

    "loop through all groups and return the first template matching the provided template id" in new TestCase {
      templateLocator.findTemplate("template-templateGroup-1-2").value.templateId shouldBe "template-templateGroup-1-2"
      templateLocator
        .findTemplate("template-templateGroup-1-2")
        .value
        .fromAddress
        .apply(Map.empty) shouldBe "from@test <noreply@tax.service.gov.uk>"
      templateLocator.findTemplate("template-templateGroup-1-2").value.service shouldBe SelfAssessment
    }

    "return none if the template is not found" in new TestCase {
      templateLocator.findTemplate("template-templateGroup-10-2") shouldBe None
    }

    "enumerate all titles" in {
      TemplateLocator.templateGroups.keys should contain only (
        "AEO MRA",
        "Agent",
        "API Platform",
        "Self Assessment",
        "AMLS",
        "Passcodes",
        "TAMC",
        "DAC6",
        "MDR",
        "CBCR-NEW",
        "DFS",
        "Digital Contact VAT",
        "Digital Tariffs",
        "DST",
        "Childcare",
        "PAYE",
        "FANDF",
        "GG",
        "ATS",
        "AWRS",
        "GMP",
        raldGroup,
        contactFormsGroup,
        "BARS",
        "TCS",
        "register-your-company",
        "Mandate",
        "EMAC Helpdesk",
        "EMAC",
        "Customs",
        "Transaction Engine",
        "ATED",
        "LifetimeISA",
        "ITR",
        //        "TAVC",
        "CBCR",
        "EEITT",
        "FHDDS",
        "OnlinePaymentService",
        "HTS",
        "HTSReminder",
        "SDIL",
        "Lost Credentials",
        "CCA",
        "CDS",
        "MTDfB-VAT",
        "VATREG",
        "PODS",
        "vat",
        "Two way messaging",
        "Parcels",
        "Customs Financials",
        "Cgtpd",
        "TDQ",
        "SEISS",
        "GVMS",
        "EOTHO",
        "Eori Common Component",
        "Exports (CDS)",
        "MODS",
        "CDSRC",
        "OSS",
        "API Catalogue",
        "HEC",
        "EU Subsidy",
        "ITSA"
      )
    }

    "enumerate all template identifiers" in {
      TemplateLocator.all.map(_.templateId) should contain only (
        "aeo_mra_row_data_exchange_report",
        "email_verification_passcode",
        "email_verification_passcode_welsh",
        "overseas_application_rejected",
        "overseas_application_accepted",
        "overseas_application_received",
        "client_rejected_authorisation_request",
        "client_accepted_authorisation_request",
        "client_expired_authorisation_request",
        "agent_permissions_success",
        "agent_permissions_success_cy",
        "agent_permissions_some_failed",
        "agent_permissions_some_failed_cy",
        "agent_permissions_all_failed",
        "agent_permissions_all_failed_cy",
        "agent_permissions_beta_participant_details",
        "agent_services_account_created",
        "agent_services_account_created_cy",
        "agent_invitation_about_to_expire_single",
        "agent_invitations_about_to_expire",
        "dc-1462-test-message",
        "apiDeveloperEmailVerification",
        "apiDeveloperPasswordReset",
        "apiDeveloperChangedPasswordConfirmation",
        "apiDeveloperHubNewLoginNotification",
        "apiAddedRegisteredDeveloperAsCollaboratorConfirmation",
        "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation",
        "apiAddedDeveloperAsCollaboratorConfirmation",
        "apiAddedDeveloperAsCollaboratorNotification",
        "apiRemovedCollaboratorConfirmation",
        "apiRemovedCollaboratorNotification",
        "apiApplicationApprovedGatekeeperConfirmation",
        "apiApplicationApprovedAdminConfirmation",
        "apiApplicationApprovedNotification",
        "apiApplicationDeletedNotification",
        "apiDeveloperDeletedConfirmation",
        "apiApplicationRejectedNotification",
        "apiStatusChangedNotification",
        "apiAddedClientSecretNotification",
        "apiRemovedClientSecretNotification",
        "apiApplicationToBeDeletedNotification",
        "apiProductionCredentialsRequestExpired",
        "apiProductionCredentialsRequestExpiryWarning",
        "apiVerifyResponsibleIndividual",
        "apiVerifyResponsibleIndividualUpdate",
        "apiResponsibleIndividualReminderToAdmin",
        "apiResponsibleIndividualDidNotVerify",
        "apiResponsibleIndividualDeclined",
        "apiResponsibleIndividualNotChanged",
        "apiChangeOfApplicationName",
        "apiChangeOfApplicationDetails",
        "apiChangeOfResponsibleIndividual",
        "changeOfEmailAddress",
        "changeOfEmailAddress_cy",
        "verifyEmailAddress",
        "verifyEmailAddress_cy",
        "digitalOptInConfirmation",
        "digitalOptInConfirmation_cy",
        "digitalOptOutConfirmation",
        "digitalOptOutConfirmation_cy",
        "changeOfEmailAddressNewAddress",
        "changeOfEmailAddressNewAddress_cy",
        "newMessageAlert",
        "newMessageAlert_cy",
        "newMessageAlert_SA316",
        "newMessageAlert_SS300",
        "newMessageAlert_SA300",
        "newMessageAlert_SA309",
        "newMessageAlert_R002A",
        "newMessageAlert_SA251",
        "newMessageAlert_SA326D",
        "newMessageAlert_SA328D",
        "newMessageAlert_SA359",
        "newMessageAlert_SA370",
        "newMessageAlert_SA371",
        "newMessageAlert_SA372",
        "newMessageAlert_SA373",
        "newMessageAlert_IgnorePaperFiling",
        "newMessageAlert_CA001",
        "new_message_alert_itsa",
        "new_message_alert_itsa_cy",
        "amls_notification_received_template",
        "rescindedMessageAlert",
        "rescindedMessageAlert_cy",
        "penaltyChargeApologies",
        "verificationReminder",
        "verificationReminder_cy",
        "generic_access_invitation_template_id",
        "cato_access_invitation_template_id",
        "agents_access_invitation_template_id",
        "agent_mapping_invitation_template_id",
        "agent_subscription_invitation_template_id",
        "agent_fi_invitation_template_id",
        "agents_opt_in_exclude_template_id",
        "agents_opt_in_rejoin_template_id",
        "tamc_access_invitation_template_id",
        "tamc_confirmation_template_id",
        "tamc_confirmation_pta",
        "tamc_update_cancel",
        "tamc_update_reject",
        "tamc_update_divorce_transferor_boy",
        "tamc_update_divorce_recipient_eoy",
        "tamc_current_year",
        "tamc_retro_year",
        "tamc_current_retro_year",
        "tamc_transferor_divorce_previous_yr",
        "tamc_recipient_divorce_previous_yr",
        "tamc_recipient_rejects_retro_yr",
        "tamc_transferor_divorce_current_yr",
        "tamc_update_cancel_cy",
        "tamc_update_reject_cy",
        "tamc_update_divorce_transferor_boy_cy",
        "tamc_update_divorce_recipient_eoy_cy",
        "tamc_current_year_cy",
        "tamc_retro_year_cy",
        "tamc_current_retro_year_cy",
        "tamc_transferor_divorce_previous_yr_cy",
        "tamc_recipient_divorce_previous_yr_cy",
        "tamc_recipient_rejects_retro_yr_cy",
        "tamc_transferor_divorce_current_yr_cy",
        "digital_tariffs_case_completed",
        "digital_tariffs_advice_request",
        "digital_tariffs_application_submitted",
        "digital_tariffs_application_submitted_cy",
        "dfs_submission_success_r39_2015",
        "dfs_submission_success_r39_2015_welsh",
        "dfs_submission_success_cis_2015",
        "dfs_submission_success_cis_2015_welsh",
        "dfs_submission_success_sptu_2015",
        "dfs_submission_success_sptu_2015_welsh",
        "dfs_submission_success_generic_2015",
        "dfs_submission_success_generic_2015_welsh",
        "dfs_submission_success_generic_2017",
        "dfs_submission_success_generic_2017_welsh",
        "dfs_submission_success_empty_turn_around_time_2015",
        "dfs_submission_success_empty_turn_around_time_2015_welsh",
        "dfs_submission_success_empty_turn_around_time_2020",
        "dfs_submission_success_gencompsub_2021",
        "dfs_submission_success_gencompsub_2021_welsh",
        "dfs_admin_notification",
        "dfs_admin_notification_welsh",
        "dfs_trusts_submission_success",
        "dfs_trusts_submission_success_welsh",
        "dfs_submission_success_rcgt_2018",
        "dfs_submission_success_rcgt_2018_welsh",
        "eeitt_submission_confirmation",
        "cir_appointment_confirmation",
        "cir_appointment_confirmation_cy",
        "cir_revocation_confirmation",
        "cir_revocation_confirmation_cy",
        "cir_return_confirmation",
        "cir_return_confirmation_cy",
        "randd_confirmation_submission",
        "randd_confirmation_submission_cy",
        "eeitt_ce930_confirmation",
        "eeitt_ce930_confirmation_cy",
        "eeitt_ho930_confirmation",
        "eeitt_ho930_confirmation_cy",
        "ho10_confirmation_submission",
        "ho10_confirmation_submission_cy",
        "vat_refund_claim_confirmation",
        "apd_return_confirmation",
        "apd_return_confirmation_cy",
        "apd_registration_confirmation",
        "apd_registration_confirmation_cy",
        "ipt100_return_confirmation",
        "ipt100_return_confirmation_cy",
        "ipt100_registration_confirmation",
        "bd510_return_confirmation",
        "bd510_return_confirmation_cy",
        "al100_return_confirmation",
        "al_registration_confirmation",
        "al_registration_confirmation_cy",
        "lt100_return_confirmation",
        "lt100_return_confirmation_cy",
        "gd95_return_confirmation",
        "gd95_return_confirmation_cy",
        "gd94_return_confirmation",
        //        "ex250_return_confirmation",
        "ex250_registration_confirmation",
        "ex250_registration_confirmation_cy",
        "adr_confirmation_submission",
        "adr_code",
        "adr_code_cy",
        "air597_return_confirmation",
        "air597_return_confirmation_cy",
        "confirmationCode_confirmation_submission",
        "ipr1_confirmation_submission",
        "ipr2_confirmation_submission",
        "ipr3_confirmation_submission",
        "seiss_repay_submission",
        "seiss_repay_submission_cy",
        "ioss_code",
        "ioss_dereg_code",
        "ioss_code_cy",
        "ioss_confirmation",
        "ioss_confirmation_cy",
        "ioss_dereg_confirmation",
        "c117_application_confirmation",
        "c117_application_confirmation_cy",
        "c118_confirmation_dynamic",
        "c118_section1_part1_application_confirmation",
        "c118_section1_part1_application_confirmation_cy",
        "c118_section1_part2_application_confirmation",
        "c118_section1_part2_application_confirmation_cy",
        "c118_section1_part3_application_confirmation",
        "c118_section1_part3_application_confirmation_cy",
        "c118_section2_application_confirmation",
        "c118_section2_application_confirmation_cy",
        "c118_section3_part1_application_confirmation",
        "c118_section3_part1_application_confirmation_cy",
        "c118_section3_part2_application_confirmation",
        "c118_section3_part2_application_confirmation_cy",
        "c118_section4_application_confirmation",
        "c118_section4_application_confirmation_cy",
        "c118_section5_application_confirmation",
        "c118_section5_application_confirmation_cy",
        "c118_section6_part1_application_confirmation",
        "c118_section6_part1_application_confirmation_cy",
        "c118_section6_part2_application_confirmation",
        "c118_section6_part2_application_confirmation_cy",
        "c118_section6_part3_application_confirmation",
        "c118_section6_part3_application_confirmation_cy",
        "c118_section6_part4_application_confirmation",
        "c118_section6_part4_application_confirmation_cy",
        "cbc_registration_successful_organisation",
        "cbc_file_upload_successful",
        "cbc_file_upload_unsuccessful",
        "cbc_agent_file_upload_successful",
        "cbc_agent_file_upload_unsuccessful",
        "spbp_confirmation_submission",
        "tsp_application_confirmation",
        "gd_application_confirmation",
        "rdec_email_confirmation",
        "bd600_confirmation_submission",
        "civOffShore_confirmation_submission",
        "civQualifying_confirmation_submission",
        "civTransparency_confirmation_submission",
        "civOffshore_code_submission",
        "civQualifying_code_submission",
        "civTransparency_code_submission",
        "spbp_code_submission",
        "spbp_code_submission_cy",
        "spbp_claim_code_submission",
        "spbp_claim_code_submission_cy",
        "spbp_notification_code_submission",
        "spbp_notification_code_submission_cy",
        "spbp_record_code_submission",
        "spbp_record_code_submission_cy",
        "cjrs_code_submission",
        "cjrs_code_submission_cy",
        "seiss_code_submission",
        "seiss_code_submission_cy",
        "seiss_eligibility_submission",
        "seiss_new_child_submission",
        "seiss_grant_submission",
        "seissOverPayment_confirmation",
        "seissOverPayment_confirmation_cy",
        "seiss_voluntary_disclosure_confirmation",
        "seiss_scheme_open",
        "seiss_processing_grant",
        "seiss_processing_grant_cy",
        "seiss_payment_failed",
        "seiss_payment_failed_cy",
        "seiss_received_confirmation",
        "seiss_phase_3_previously_claimed_stagger",
        "seiss_phase_3_previously_claimed_stagger_cy",
        "vishing_code_submission",
        "vishing_code_submission_cy",
        "cjrs_confirmation_submission",
        "cjrs_disclosure_confirmation",
        "cjrsDisclosure_code",
        "jrsRemoval_submission_confirmation",
        "csr_submission_confirmation",
        "cet_email_confirmation",
        "gss_email_confirmation",
        "cash_declaration",
        "cash_declaration_EU",
        "cashDecEU_code",
        "cash_declaration_UK",
        "cashDecUK_code",
        "ccg1_confirmation_submission",
        "dan_waiver_confirmation",
        "duty_deferment_account_amend_confirmation",
        "pods_confirmation",
        "res1_code",
        "res1_confirmation",
        "utt_confirmation",
        "utt_code",
        "ppt_registration_confirmation",
        "ppt_registration_code",
        "ppt_enquiry_confirmation",
        "ppt_enquiry_code",
        "ppt_return_confirmation",
        "ppt_request_confirmation",
        "psa1_confirmation",
        "psa1_code",
        "tor_code",
        "tor_confirmation",
        "tor_confirmation_dynamic",
        "nrsDLT_code",
        "nrsDLT_confirmation",
        "pesm_confirmation",
        "pesm_code",
        "pesm_code_cy",
        "creative_industries_confirmation",
        "creative_industries_code",
        "qahc_confirmation",
        "qahc_code",
        "vat652_confirmation",
        "vat652_code",
        "venture_capital_confirmation",
        "venture_capital_code",
        "trusts_report_code",
        "trusts_report_confirmation",
        "trusts_request_code",
        "trusts_request_confirmation",
        "chief_code",
        "chief_confirmation",
        "fprc_confirmation",
        "gbEORI_confirmation",
        "gbCancelEORI_confirmation",
        "essPreNotification_code",
        "essPreNotification_confirmation",
        "essDisclosure_code",
        "essDisclosure_confirmation",
        "mod_confirmation",
        "mod_code",
        "rndNotification_code",
        "rndNotification_confirmation",
        "elcb_code",
        "elcb_code_cy",
        "elcb_confirmation",
        "ctDormancy_code",
        "ctDormancy_code_cy",
        "ctDormancy_confirmation",
        "tspDeReg_confirmation_submission",
        "tspCHIEF_confirmation_submission",
        "challengeChildcare_confirmation_submission",
        "challengeChildcare_code",
        "challengeChildcare_code_cy",
        "register_for_duty_on_gas_for_road_fuel_use",
        "register_for_duty_on_biofuels_and_other_fuel_substitutes",
        "register_for_fuel_duty_confirmation",
        "corporation_tax_confirmation",
        "corporation_tax_code",
        "fhdds_submission_confirmation",
        "fhdds_submission_withdrawal",
        "fhdds_email_verification",
        "fhdds_submission_deregister",
        "fhddsAlertMessage",
        "lt_registration_confirmation",
        "cc_registration_email",
        "childcare_registration_email",
        "childcare_schemes_interest_email",
        "childcare_taxfree_england",
        "childcare_taxfree_devolved",
        "childcare_taxfree_england_A",
        "childcare_taxfree_devolved_A",
        "childcare_taxfree_england_B",
        "childcare_taxfree_devolved_B",
        "tax_estimate_message_alert",
        "tax_estimate_message_alert_cy",
        "iht_access_invitation_template_id",
        "fandf_ask_help_notification",
        "fandf_offer_help_notification",
        "annual_tax_summaries_message_alert",
        "annual_tax_summaries_message_alert_cy",
        "gmp_access_invitation_template_id",
        //        "indefensibleUpgrade",
        //        "indefensibleUpgradeWithDate",
        "awrs_notification_template_reg_change",
        "awrs_notification_template_app_change",
        "awrs_notification_template_comfirmation_api4",
        "awrs_notification_template_comfirmation_api4_new_business",
        "awrs_notification_template_comfirmation_api6",
        "awrs_notification_template_comfirmation_api6_pending",
        "awrs_notification_template_cancellation_api10",
        "awrs_notification_template_withdrawn_api8",
        "awrs_notification_template_comfirmation_api6_new_business",
        "awrs_notification_template_comfirmation_api6_new_business_pending",
        "awrs_email_verification",
        "gmp_bulk_upload_received",
        "hts_reminder_email",
        "gmp_bulk_upload_processed",
        "rald_alert",
        "rald_not_connected",
        "rald_submission_confirmation",
        rald_connection_removed,
        rald_connection_removed_cy,
        cf_enquiry_confirmation,
        cf_enquiry_confirmation_cy,
        "bars_alert",
        "bars_alert_transaction",
        "tcs_renewal_confirmation",
        "register_your_company_verification_email",
        "register_your_company_verification_email_cy",
        "register_your_company_register_vat_email",
        "register_your_company_register_vat_email_cy",
        "register_your_company_register_paye_confirmation_new_tax_year_v2",
        "register_your_company_register_paye_confirmation_new_tax_year_v2_cy",
        "register_your_company_register_paye_confirmation_current_tax_year_v2",
        "register_your_company_register_paye_confirmation_current_tax_year_v2_cy",
        "investment_tax_relief_verification_email",
        "investment_tax_relief_confirmation_email",
        "investment_tax_relief_no_docs_confirmation_email",
        "client_approves_mandate",
        "agent_activates_mandate",
        "agent_rejects_mandate",
        "agent_removes_mandate",
        "client_removes_mandate",
        "client_cancels_active_mandate",
        "agent_self_auth_activates_mandate",
        "agent_self_auth_deactivates_mandate",
        "gg_userid_notification",
        "2SV_reset_confirmation",
        "password_change_confirmation",
        "customs_registration_successful",
        "customs_registration_not_successful",
        "customs_migrate_successful",
        "customs_migrate_not_successful",
        "customs_validation_success",
        "customs_payment_required",
        "customs_payment_success",
        "customs_declaration_success",
        "customs_pull_notifications_warning",
        "customs_push_notifications_warning",
        "customs_rcm_notifications",
        "transactionEngineHMRCSASA100Success",
        "transactionEngineHMRCSASA100Failure",
        "transactionEngineHMRCSASA100ATTSuccess",
        "transactionEngineHMRCSASA100ATTFailure",
        "transactionEngineHMRCSASA100ATTTILSuccess",
        "transactionEngineHMRCSASA100ATTTILFailure",
        "transactionEngineHMRCSASA100TILSuccess",
        "transactionEngineHMRCSASA100TILFailure",
        "transactionEngineHMRCCTCT600Success",
        "transactionEngineHMRCCTCT600Failure",
        "transactionEngineHMRCCTCT600TILSuccess",
        "transactionEngineHMRCCTCT600TILFailure",
        "transactionEngineHMRCPPACCTSuccess",
        "transactionEngineHMRCPPACCTFailure",
        "transactionEngineHMRCPPAMDSuccess",
        "transactionEngineHMRCPPAMDFailure",
        "transactionEngineHMRCPPEVNTSuccess",
        "transactionEngineHMRCPPEVNTFailure",
        "transactionEngineHMRCPPMAINTSuccess",
        "transactionEngineHMRCPPMAINTFailure",
        "transactionEngineHMRCPPPRACSuccess",
        "transactionEngineHMRCPPPRACFailure",
        "transactionEngineHMRCPPRASSuccess",
        "transactionEngineHMRCPPRASFailure",
        "transactionEngineHMRCPPRETSuccess",
        "transactionEngineHMRCPPRETFailure",
        "transactionEngineCHARCLMFailure",
        "transactionEngineCHARCLMSuccess",
        "transactionEngineCHARCLMMULTIFailure",
        "transactionEngineCHARCLMMULTISuccess",
        "transactionEngineECSLORGV101Success",
        "transactionEngineECSLORGV101Failure",
        "transactionEngineIRAACTSuccess",
        "transactionEngineIRAACTFailure",
        "transactionEngineIRAAPAYESuccess",
        "transactionEngineIRAAPAYEFailure",
        "transactionEngineIRAASASuccess",
        "transactionEngineIRAASAFailure",
        "transactionEngineIRCISCIS300MRSuccess",
        "transactionEngineIRCISCIS300MRFailure",
        "transactionEngineIRCISVERIFYSuccess",
        "transactionEngineIRCISVERIFYFailure",
        "transactionEngineIRCTFANNUALRETURNSuccess",
        "transactionEngineIRCTFANNUALRETURNFailure",
        "transactionEngineIRPAYEEOYSuccess",
        "transactionEngineIRPAYEEOYFailure",
        "transactionEngineIRPAYEEOYTILSuccess",
        "transactionEngineIRPAYEEOYTILFailure",
        "transactionEngineIRPAYEEXBSuccess",
        "transactionEngineIRPAYEEXBFailure",
        "transactionEngineIRPAYEMOVSuccess",
        "transactionEngineIRPAYEMOVFailure",
        "transactionEngineIRPAYEMOVTILSuccess",
        "transactionEngineIRPAYEMOVTILFailure",
        "transactionEngineIRPAYEP38ASuccess",
        "transactionEngineIRPAYEP38AFailure",
        "transactionEngineIRPAYEUPDATESuccess",
        "transactionEngineIRPAYEUPDATEFailure",
        "transactionEngineIRSDLTLTRSuccess",
        "transactionEngineIRSDLTLTRFailure",
        "transactionEngineHMRCPAYERTIEASSuccess",
        "transactionEngineHMRCPAYERTIEASFailure",
        "transactionEngineHMRCPAYERTIEASTILSuccess",
        "transactionEngineHMRCPAYERTIEASTILFailure",
        "transactionEngineHMRCPAYERTIEPSSuccess",
        "transactionEngineHMRCPAYERTIEPSFailure",
        "transactionEngineHMRCPAYERTIEPSTILSuccess",
        "transactionEngineHMRCPAYERTIEPSTILFailure",
        "transactionEngineHMRCPAYERTIEYUSuccess",
        "transactionEngineHMRCPAYERTIEYUFailure",
        "transactionEngineHMRCPAYERTIEYUTILSuccess",
        "transactionEngineHMRCPAYERTIEYUTILFailure",
        "transactionEngineHMRCPAYERTIFPSSuccess",
        "transactionEngineHMRCPAYERTIFPSFailure",
        "transactionEngineHMRCPAYERTIFPSTILSuccess",
        "transactionEngineHMRCPAYERTIFPSTILFailure",
        "transactionEngineHMRCPAYERTINVRSuccess",
        "transactionEngineHMRCPAYERTINVRFailure",
        "transactionEngineHMRCPAYERTINVRTILSuccess",
        "transactionEngineHMRCPAYERTINVRTILFailure",
        "transactionEngineHMRCPSAACCTTAXSuccess",
        "transactionEngineHMRCPSAACCTTAXFailure",
        "transactionEngineHMRCPSAADDSCHASuccess",
        "transactionEngineHMRCPSAADDSCHAFailure",
        "transactionEngineHMRCPSAAMDDETSSuccess",
        "transactionEngineHMRCPSAAMDDETSFailure",
        "transactionEngineHMRCPSAASSCSASuccess",
        "transactionEngineHMRCPSAASSCSAFailure",
        "transactionEngineHMRCPSACOMBINEDREGSuccess",
        "transactionEngineHMRCPSACOMBINEDREGFailure",
        "transactionEngineHMRCPSAEVNTREPSuccess",
        "transactionEngineHMRCPSAEVNTREPFailure",
        "transactionEngineHMRCPSAMAINTSCMSuccess",
        "transactionEngineHMRCPSAMAINTSCMFailure",
        "transactionEngineHMRCPSARASSuccess",
        "transactionEngineHMRCPSARASFailure",
        "transactionEngineHMRCPSAREGSuccess",
        "transactionEngineHMRCPSAREGFailure",
        "transactionEngineHMRCPSARETSuccess",
        "transactionEngineHMRCPSARETFailure",
        "transactionEngineHMRCPSAPRACAUTHSuccess",
        "transactionEngineHMRCPSAPRACAUTHFailure",
        "transactionEngineHMRCPSAPRACDEAUTHSuccess",
        "transactionEngineHMRCPSAPRACDEAUTHFailure",
        "transactionEngineHMRCSASA800ATTSuccess",
        "transactionEngineHMRCSASA800ATTFailure",
        "transactionEngineHMRCSASA800TILSuccess",
        "transactionEngineHMRCSASA800TILFailure",
        "transactionEngineHMRCSASA800ATTTILSuccess",
        "transactionEngineHMRCSASA800ATTTILFailure",
        "transactionEngineHMRCSASA800Success",
        "transactionEngineHMRCSASA800Failure",
        "transactionEngineHMRCSASA900ATTSuccess",
        "transactionEngineHMRCSASA900ATTFailure",
        "transactionEngineHMRCSASA900TILSuccess",
        "transactionEngineHMRCSASA900TILFailure",
        "transactionEngineHMRCSASA900ATTTILSuccess",
        "transactionEngineHMRCSASA900ATTTILFailure",
        "transactionEngineHMRCSASA900Success",
        "transactionEngineHMRCSASA900Failure",
        "transactionEngineHMCENESEDIFACTSuccess",
        "transactionEngineHMCENESEDIFACTFailure",
        "transactionEngineHMRCVATDECSuccess",
        "transactionEngineHMRCVATDECFailure",
        "transactionEngineHMRCVATDECTILSuccess",
        "transactionEngineHMRCVATDECTILFailure",
        "chargeable_return_submit",
        "relief_return_submit",
        "amended_return_submit",
        "lisa_application_submit",
        "further_return_submit",
        "change_details_return_submit",
        "disposal_return_submit",
        "emac_helpdesk_failure_confirmation_email",
        "emac_helpdesk_successful_confirmation_email",
        "emac_activation_code_not_received",
        "cbcr_subscription",
        "cbcr_report_confirmation",
        "cbcr_cbcid_regeneration",
        "open_banking_payment_successful",
        "open_banking_payment_successful_cy",
        "payment_successful",
        "payment_successful_cy",
        "payment_successful_parcels",
        "recon_finance_report",
        "recon_surcharge_report",
        "recon_mods_finance_report",
        "ddi_migration_letter",
        "ddi_setup_dcs_alert",
        "ddi_setup_aa_dcs_alert",
        "ddi_amended_dcs_alert",
        "ddi_cancelled_dcs_alert",
        "ddi_reminder_dcs_alert",
        "ddi_unpaid_dcs_alert",
        "ddi_08_alert_aa",
        "ddi_advance_notice",
        "dd_email_verifcation",
        "sdds_ddi_setup_dcs_alert",
        "sdds_ddi_amended_dcs_alert",
        "sdds_ddi_cancelled_dcs_alert",
        "sdds_ddi_reminder_dcs_alert",
        "sdds_ddi_unpaid_dcs_alert",
        "cds_ddi_setup_dcs_alert",
        "cds_ddi_amended_dcs_alert",
        "cds_ddi_cancelled_dcs_alert",
        "cds_ddi_reminder_dcs_alert",
        "cds_ddi_unpaid_dcs_alert",
        "cds_ddi_not_acceptable_dcs_alert",
        "hts_verification_email",
        "sdil_registration_accepted",
        "sdil_registration_received",
        "retrieve_userid_notification",
        "cca_appeals_submission_link",
        "cca_enrolment_migration_confirmation",
        "cca_enrolment_confirmation",
        "cca_enrolment_confirmation_agent",
        "cca_enrolment_confirmation_individual",
        "cca_revaluation_subscription_confirmation",
        "cdsTestTemplate",
        "cdsEmailTemplate",
        "dmsdoc_notification",
        "newMessageAlert_CDS_exp",
        "mtdfb_vat_principal_sign_up_successful",
        "mtdfb_vat_principal_sign_up_failure",
        "mtdfb_vat_agent_sign_up_successful",
        "mtdfb_vatreg_registration_received",
        "mtdfb_vatreg_registration_received_email",
        "mtdfb_vatreg_registration_received_post",
        "mtdfb_vatreg_registration_received_cy",
        "mtdfb_vatreg_registration_received_email_cy",
        "mtdfb_vatreg_registration_received_post_cy",
        "pods_scheme_register",
        "pods_racdac_scheme_register",
        "pods_psa_register",
        "pods_psa_register_company",
        "pods_psa_invited",
        "pods_file_aft_return",
        "pods_aft_amended_return_decrease",
        "pods_aft_amended_return_no_change",
        "pods_aft_amended_return_increase",
        "pods_psp_register",
        "pods_psp_amend",
        "pods_psp_de_auth_psp_individual",
        "pods_psp_de_auth_psp_company_partnership",
        "pods_authorise_psp",
        "pods_psa_deauthorise_psp",
        "pods_psp_deregister_self",
        "pods_scheme_migration_confirmation",
        "pods_racdac_bulk_migration_confirmation",
        "pods_racdac_individual_migration_confirmation",
        "ppnsCallbackUrlChangedNotification",
        "vat",
        "newMessageAlert_2WSM-question",
        "newMessageAlert_2WSM-reply",
        "twoWayMessageUpdate",
        "passengers_payment_confirmation",
        "newMessageAlert_VRT12B",
        "newMessageAlert_VRT14B",
        "newMessageAlert_CC07C_SM11C",
        "newMessageAlert_VRT1214C",
        "newMessageAlert_VRT1214A",
        "parcels_registration_confirmation",
        "customs_financials_new_statement_notification",
        "customs_financials_requested_duty_deferment_statement",
        "customs_financials_new_import_adjustment",
        "customs_financials_requested_import_adjustment",
        "customs_financials_new_c79_certificate",
        "customs_financials_historic_c79_certificate",
        "customs_financials_new_postponed_vat_notification",
        "customs_financials_requested_postponed_vat_notification",
        "customs_financials_requested_for_standing_authorities",
        "cgtpd_email_verification",
        "cgtpd_email_verification_cy",
        "tdq_fph_report_non_compliant",
        "tdq_fph_report_heuristically_compliant",
        "tdq_fph_self_serve_nudge",
        "cgtpd_account_created",
        "cgtpd_account_created_cy",
        "cgtpd_private_beta_access",
        "dst_registration_received",
        "dst_registration_accepted",
        "cgtpd_submission_confirmation",
        "cgtpd_submission_confirmation_cy",
        "gms_enrolment_confirmation",
        "dac6_registration_successful",
        "dac6_new_disclosure_confirmation",
        "dac6_additional_disclosure_confirmation",
        "dac6_replace_disclosure_confirmation",
        "dac6_delete_disclosure_confirmation",
        "mdr_registration_successful_organisation",
        "mdr_registration_successful_individual",
        "mdr_file_upload_successful",
        "mdr_file_upload_unsuccessful",
        "discounted_dining_payment_sent",
        "discounted_dining_payment_sent_cy",
        "ipr1_code",
        "ipr2_code",
        "ipr3_code",
        "vat_declaration_confirmation",
        "ecc_subscription_successful",
        "ecc_subscription_successful_cy",
        "ecc_subscription_not_successful",
        "ecc_subscription_not_successful_cy",
        "ecc_rcm_notifications",
        "trading_status_before_seiss_claimed",
        "settlement_request",
        "complaint_consultation_code",
        "complaint_consultation_code_cy",
        "consultation_complaint_confirmation",
        "duty_deferment_account_confirmation",
        "eat_out_help_out_confirmation",
        "mods_import_declaration",
        "mods_amend_import_declaration",
        "mods_export_declaration",
        "mods_amend_export_declaration",
        "mods_import_declaration_cy",
        "mods_amend_import_declaration_cy",
        "mods_export_declaration_cy",
        "mods_amend_export_declaration_cy",
        "ni_vat_Status_reporting_confirmation",
        "ni_vat_Status_withdrawal_confirmation",
        "xiEORI_confirmation",
        "xiEORI_change_confirmation",
        "nipbe_confirmation",
        "nipbe_confirmation_cy",
        "netp_confirmation",
        "reimbursement_claim_submission",
        "reimbursement_claim_submission_cy",
        "newMessageAlert_P800",
        "newMessageAlert_P800_cy",
        "newMessageAlert_PA302",
        "newMessageAlert_PA302_cy",
        "newMessageAlert_P800_D2",
        "newMessageAlert_P800_D2_cy",
        "newMessageAlert_PA302_D2",
        "newMessageAlert_PA302_D2_cy",
        "oss_registration_confirmation",
        "oss_returns_email_confirmation",
        "oss_overdue_returns_email_confirmation",
        "oss_returns_email_confirmation_no_vat_owed",
        "platformContact",
        "platformContactConfirmation",
        "pods_psa_amend",
        "hec_tax_check_code",
        "hec_tax_check_code_cy",
        "create_undertaking_email_to_lead",
        "undertaking_member_added_email_to_be",
        "undertaking_member_added_email_to_lead",
        "undertaking_member_removed_email_to_lead",
        "undertaking_member_removed_email_to_be",
        "promoted_other_as_lead_email_to_be",
        "promoted_other_as_lead_email_to_lead",
        "member_remove_themself_email_to_lead",
        "member_remove_themself_email_to_be",
        "promoted_themself_as_lead_email_to_lead",
        "removed_as_lead_email_to_previous_lead",
        "telephone_payments_service",
        "face_to_face_payment_email_successful",
        "face_to_face_payment_email_unsuccessful",
        "face_to_face_payment_email_successful_cy",
        "face_to_face_payment_email_unsuccessful_cy",
        "disabled_undertaking_email_to_lead",
        "disabled_undertaking_email_to_be"
      )
    }
  }

  trait TestCase {
    def messageTemplates(templateName: String): Seq[MessageTemplate] = (1 to 5) map { i =>
      MessageTemplate.create(
        templateId = s"template-$templateName-$i",
        FromAddress.noReply("from@test"),
        service = SelfAssessment,
        subject = "a subject",
        plainTemplate = txt.templateSample.f,
        htmlTemplate = html.templateSample.f
      )
    }

    val templateLocator: TemplateLocator = new TemplateLocator {
      override lazy val all: Seq[MessageTemplate] = (1 to 5) flatMap { i =>
        messageTemplates(s"templateGroup-$i")
      }
    }

    val templateLocatorWithWelsh: TemplateLocator = new TemplateLocator {
      val allEnglish: Seq[MessageTemplate] = (1 to 5) flatMap { i =>
        messageTemplates(s"templateGroup-$i")
      }
      override lazy val all: Seq[MessageTemplate] = allEnglish ++ allEnglish.map(t =>
        t.copy(templateId = s"${t.templateId}${TemplateLocator.WELSH_SUFFIX}"))
    }
  }

}
