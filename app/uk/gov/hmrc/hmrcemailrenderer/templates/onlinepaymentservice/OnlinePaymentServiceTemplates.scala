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

package uk.gov.hmrc.hmrcemailrenderer.templates.onlinepaymentservice

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ FromAddress, ServiceIdentifier }

object OnlinePaymentServiceTemplates {

  lazy val templates: List[MessageTemplate] = cdsTemplates ++ Seq(
    // Card payments templates
    MessageTemplate.create(
      templateId = "payment_successful",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC payment confirmation",
      plainTemplate = txt.payment_successful.f,
      htmlTemplate = html.payment_successful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "payment_successful_cy",
      fromAddress = FromAddress.noReply("O Daliadau Ar-lein CThEM"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Cadarnhad gan CThEM o daliad",
      plainTemplate = txt.payment_successful_cy.f,
      htmlTemplate = html.payment_successful_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "payment_successful_parcels",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Receipt for payment of import VAT on parcels",
      plainTemplate = txt.payment_successful_parcels.f,
      htmlTemplate = html.payment_successful_parcels.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // Open Banking payment receipts
    MessageTemplate.create(
      templateId = "open_banking_payment_successful",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "You sent a payment to HMRC",
      plainTemplate = txt.open_banking_payment_successful.f,
      htmlTemplate = html.open_banking_payment_successful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "open_banking_payment_successful_cy",
      fromAddress = FromAddress.noReply("O Daliadau Ar-lein CThEM"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Rydych wedi anfon taliad i CThEM",
      plainTemplate = txt.open_banking_payment_successful_cy.f,
      htmlTemplate = html.open_banking_payment_successful_cy.f,
      priority = Some(MessagePriority.Urgent)
    ), // Open Banking payment receipts fdp
    MessageTemplate.create(
      templateId = "open_banking_payment_successful_fdp",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Payment scheduled",
      plainTemplate = txt.open_banking_payment_successful_fdp.f,
      htmlTemplate = html.open_banking_payment_successful_fdp.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "open_banking_payment_successful_fdp_cy",
      fromAddress = FromAddress.noReply("O Daliadau Ar-lein CThEM"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Taliad CThEF wedi’i drefnu",
      plainTemplate = txt.open_banking_payment_successful_fdp_cy.f,
      htmlTemplate = html.open_banking_payment_successful_fdp_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // Direct Debit VAT templates
    MessageTemplate.create(
      templateId = "ddi_advance_notice",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: Advance notice of your payment",
      plainTemplate = txt.ddi_advance_notice.f,
      htmlTemplate = html.ddi_advance_notice.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_migration_letter",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: important information",
      plainTemplate = txt.ddi_migration_letter.f,
      htmlTemplate = html.ddi_migration_letter.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_setup_dcs_alert",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return: Direct Debit set up",
      plainTemplate = txt.ddi_setup_dcs_alert.f,
      htmlTemplate = html.ddi_setup_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_setup_aa_dcs_alert",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Direct Debit: set up confirmation",
      plainTemplate = txt.ddi_setup_aa_dcs_alert.f,
      htmlTemplate = html.ddi_setup_aa_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_amended_dcs_alert",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return: Direct Debit amended",
      plainTemplate = txt.ddi_amended_dcs_alert.f,
      htmlTemplate = html.ddi_amended_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_cancelled_dcs_alert",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return: Direct Debit cancelled",
      plainTemplate = txt.ddi_cancelled_dcs_alert.f,
      htmlTemplate = html.ddi_cancelled_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_reminder_dcs_alert",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: reminder of payment collection",
      plainTemplate = txt.ddi_reminder_dcs_alert.f,
      htmlTemplate = html.ddi_reminder_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_unpaid_dcs_alert",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: payment not collected",
      plainTemplate = txt.ddi_unpaid_dcs_alert.f,
      htmlTemplate = html.ddi_unpaid_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "ddi_08_alert_aa",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Direct Debit",
      plainTemplate = txt.ddi_08_alert_aa.f,
      htmlTemplate = html.ddi_08_alert_aa.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // Direct Debit generic SDDS templates
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_setup_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_setup_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_setup_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_setup_dcs_alert_cy",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_setup_dcs_alert_cy.f,
      htmlTemplate = html.sdds_ddi_setup_dcs_alert_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_amended_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_amended_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_amended_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_amended_dcs_alert_cy",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_amended_dcs_alert_cy.f,
      htmlTemplate = html.sdds_ddi_amended_dcs_alert_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_cancelled_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_cancelled_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_cancelled_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_cancelled_dcs_alert_cy",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_cancelled_dcs_alert_cy.f,
      htmlTemplate = html.sdds_ddi_cancelled_dcs_alert_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_reminder_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_reminder_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_reminder_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_reminder_dcs_alert_cy",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_reminder_dcs_alert_cy.f,
      htmlTemplate = html.sdds_ddi_reminder_dcs_alert_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_unpaid_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_unpaid_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_unpaid_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "sdds_ddi_unpaid_dcs_alert_cy",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.sdds_ddi_unpaid_dcs_alert_cy.f,
      htmlTemplate = html.sdds_ddi_unpaid_dcs_alert_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    // END Direct Debit generic SDDS templates
    MessageTemplate.createWithDynamicSubject(
      templateId = "passengers_payment_confirmation",
      fromAddress = "HMRC Online Service for Passengers <noreply@confirmation.tax.service.gov.uk>",
      service = ServiceIdentifier.PassengerService,
      subject = _.apply("subject"),
      plainTemplate = txt.passengers_confirmation.f,
      htmlTemplate = html.passengers_confirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dd_email_verifcation",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Verify your email address",
      plainTemplate = txt.dd_email_verifcation.f,
      htmlTemplate = html.dd_email_verifcation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    //Recon tps, f2f
    MessageTemplate.createWithDynamicSubject(
      templateId = "recon_finance_report",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.recon_finance_report.f,
      htmlTemplate = html.recon_finance_report.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "recon_surcharge_report",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.recon_surcharge_report.f,
      htmlTemplate = html.recon_surcharge_report.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "recon_mods_finance_report",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.recon_mods_finance_report.f,
      htmlTemplate = html.recon_mods_finance_report.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "telephone_payments_service",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Payment confirmation",
      plainTemplate = txt.telephone_payments_service.f,
      htmlTemplate = html.telephone_payments_service.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_successful",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Payment confirmation",
      plainTemplate = txt.face_to_face_payment_email_successful.f,
      htmlTemplate = html.face_to_face_payment_email_successful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_unsuccessful",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Your payment to HMRC was unsuccessful",
      plainTemplate = txt.face_to_face_payment_email_unsuccessful.f,
      htmlTemplate = html.face_to_face_payment_email_unsuccessful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_no_receipt_successful",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Payment confirmation",
      plainTemplate = txt.face_to_face_payment_email_no_receipt_successful.f,
      htmlTemplate = html.face_to_face_payment_email_no_receipt_successful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_no_receipt_unsuccessful",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Your payment to HMRC was unsuccessful",
      plainTemplate = txt.face_to_face_payment_email_no_receipt_unsuccessful.f,
      htmlTemplate = html.face_to_face_payment_email_no_receipt_unsuccessful.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

  val cdsTemplates = List(
    MessageTemplate.create(
      templateId = "cds_ddi_setup_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Duty Deferred: Direct Debit set up",
      plainTemplate = txt.cds_ddi_setup_dcs_alert.f,
      htmlTemplate = html.cds_ddi_setup_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cds_ddi_amended_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Duty Deferred Direct Debit: confirmation of details",
      plainTemplate = txt.cds_ddi_amended_dcs_alert.f,
      htmlTemplate = html.cds_ddi_amended_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cds_ddi_cancelled_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Duty Deferred: Direct Debit cancelled",
      plainTemplate = txt.cds_ddi_cancelled_dcs_alert.f,
      htmlTemplate = html.cds_ddi_cancelled_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cds_ddi_reminder_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Duty Deferred Direct Debit: advance notice of payment",
      plainTemplate = txt.cds_ddi_reminder_dcs_alert.f,
      htmlTemplate = html.cds_ddi_reminder_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cds_ddi_unpaid_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Duty Deferred Direct Debit: payment not collected",
      plainTemplate = txt.cds_ddi_unpaid_dcs_alert.f,
      htmlTemplate = html.cds_ddi_unpaid_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cds_ddi_not_acceptable_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Duty Deferred Direct Debit: instruction cannot be used",
      plainTemplate = txt.cds_ddi_not_acceptable_dcs_alert.f,
      htmlTemplate = html.cds_ddi_not_acceptable_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_successful_cy",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Cadarnhad bod CThEF wedi cael y taliad",
      plainTemplate = txt.face_to_face_payment_email_successful_cy.f,
      htmlTemplate = html.face_to_face_payment_email_successful_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_unsuccessful_cy",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Roedd eich taliad i CThEF yn aflwyddiannus",
      plainTemplate = txt.face_to_face_payment_email_unsuccessful_cy.f,
      htmlTemplate = html.face_to_face_payment_email_unsuccessful_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_no_receipt_successful_cy",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Cadarnhad bod CThEF wedi cael y taliad",
      plainTemplate = txt.face_to_face_payment_email_no_receipt_successful_cy.f,
      htmlTemplate = html.face_to_face_payment_email_no_receipt_successful_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "face_to_face_payment_email_no_receipt_unsuccessful_cy",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Roedd eich taliad i CThEF yn aflwyddiannus",
      plainTemplate = txt.face_to_face_payment_email_no_receipt_unsuccessful_cy.f,
      htmlTemplate = html.face_to_face_payment_email_no_receipt_unsuccessful_cy.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
