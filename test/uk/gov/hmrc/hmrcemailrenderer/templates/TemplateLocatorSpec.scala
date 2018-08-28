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

package uk.gov.hmrc.hmrcemailrenderer.templates

import org.scalatestplus.play.OneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.services._
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.play.test.UnitSpec

class TemplateLocatorSpec extends UnitSpec with OneAppPerSuite {

  "The template locator" should {

    "loop through all groups and return the first template matching the provided template id" in new TestCase {
      templateLocator.findTemplate("template-templateGroup-1-2").get.templateId shouldBe "template-templateGroup-1-2"
      templateLocator.findTemplate("template-templateGroup-1-2").get.fromAddress.apply(Map.empty) shouldBe "from@test <noreply@tax.service.gov.uk>"
      templateLocator.findTemplate("template-templateGroup-1-2").get.service shouldBe SelfAssessment
    }

    "return none if the template is not found" in new TestCase {
      templateLocator.findTemplate("template-templateGroup-10-2") shouldBe None
    }

    "enumerate all titles" in {
      TemplateLocator.templateGroups.keys should contain only(
        "API Platform",
        "Self Assessment",
        "AMLS",
        "Passcodes",
        "TAMC",
        "DFS",
        "Childcare",
        "PAYE",
        "FANDF",
        "GG",
        "ATS",
        "AWRS",
        "GMP",
        "RALD",
        "BARS",
        "TCS",
        "register-your-company",
        "Mandate",
        "Off Payroll",
        "EMAC Helpdesk",
        "Customs",
        "Transaction Engine",
        "ATED",
        "LifetimeISA",
        "ITR",
        "TAVC",
        "CBCR",
        "EEITT",
        "FHDDS",
        "OnlinePaymentService",
        "HTS",
        "SDIL",
        "Lost Credentials",
        "CCA",
        "CDS",
        "MTDfB-VAT",
        "PODS",
        "vat"
      )
    }

    "enumerate all template identifiers" in {
      TemplateLocator.all.map(_.templateId) should contain only(
        "dc-1462-test-message",
        "apiDeveloperEmailVerification",
        "apiDeveloperPasswordReset",
        "apiDeveloperChangedPasswordConfirmation",
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
        "changeOfEmailAddress",
        "verifyEmailAddress",
        "digitalOptOutConfirmation",
        "changeOfEmailAddressNewAddress",
        "newMessageAlert",
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
        "amls_notification_received_template",
        "rescindedMessageAlert",
        "verificationReminder",
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
        "dfs_submission_success_r39_2015",
        "dfs_submission_success_cis_2015",
        "dfs_submission_success_sptu_2015",
        "dfs_submission_success_generic_2015",
        "dfs_submission_success_generic_2017",
        "dfs_submission_success_empty_turn_around_time_2015",
        "dfs_admin_notification",
        "dfs_trusts_submission_success",
        "dfs_submission_success_rcgt_2018",
        "eeitt_submission_confirmation",
        "cir_appointment_confirmation",
        "cir_revocation_confirmation",
        "cir_return_confirmation",
        "randd_confirmation_submission",
        "eeitt_ce930_confirmation",
        "eeitt_ho930_confirmation",
        "ho10_confirmation_submission",
        "apd_return_confirmation",
        "ipt100_return_confirmation",
        "fhdds_submission_confirmation",
        "fhdds_submission_withdrawal",
        "fhdds_email_verification",
        "fhdds_submission_deregister",
        "fhddsAlertMessage",
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
        "iht_access_invitation_template_id",
        "fandf_ask_help_notification",
        "fandf_offer_help_notification",
        "annual_tax_summaries_message_alert",
        "gmp_access_invitation_template_id",
        "indefensibleUpgrade",
        "indefensibleUpgradeWithDate",
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
        "gmp_bulk_upload_processed",
        "rald_alert",
        "bars_alert",
        "tcs_renewal_confirmation",
        "register_your_company_verification_email",
        "register_your_company_welcome_email",
        "register_your_company_register_vat_email",
        "register_your_company_register_paye_confirmation_new_tax_year",
        "register_your_company_register_paye_confirmation_current_tax_year",
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
        "offpayroll_private_beta_invitation",
        "gg_userid_notification",
        "2SV_reset_confirmation",
        "password_change_confirmation",
        "customs_registration_successful",
        "customs_registration_not_successful",
        "customs_validation_success",
        "customs_payment_required",
        "customs_payment_success",
        "customs_declaration_success",
        "customs_pull_notifications_warning",
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
        "cbcr_subscription",
        "cbcr_report_confirmation",
        "cbcr_cbcid_regeneration",
        "payment_successful",
        "payment_successful_cy",
        "ddi_cancelled",
        "ddi_not_acceptable",
        "ddi_reinstated",
        "ddi_unpaid",
        "ddi_advance_notice",
        "ddi_set_up",
        "ddi_migration_letter",
        "hts_verification_email",
        "sdil_registration_accepted",
        "sdil_registration_received",
        "retrieve_userid_notification",
        "cca_enrolment_migration_confirmation",
        "cca_enrolment_confirmation",
        "cdsTestTemplate",
        "cdsEmailTemplate",
        "mtdfb_vat_principal_sign_up_successful",
        "mtdfb_vat_principal_sign_up_failure",
        "pods_scheme_register",
        "pods_psa_register",
        "vat"
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

    val templateLocator = new TemplateLocator {
      override lazy val all: Seq[MessageTemplate] = (1 to 5) flatMap { i => messageTemplates(s"templateGroup-$i") }
    }
  }

}
