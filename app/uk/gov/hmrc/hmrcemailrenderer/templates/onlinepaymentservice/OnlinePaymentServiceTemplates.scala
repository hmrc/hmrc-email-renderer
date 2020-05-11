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

package uk.gov.hmrc.hmrcemailrenderer.templates.onlinepaymentservice

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.{ FromAddress, ServiceIdentifier }

object OnlinePaymentServiceTemplates {

  val templates = Seq(
    // Card payments templates
    MessageTemplate.create(
      templateId = "payment_successful",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "HMRC Payment confirmation",
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
    MessageTemplate.create(
      templateId = "sdds_ddi_setup_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Tax return: Direct Debit set up",
      plainTemplate = txt.sdds_ddi_setup_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_setup_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "sdds_ddi_amended_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Tax return: Direct Debit amended",
      plainTemplate = txt.sdds_ddi_amended_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_amended_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "sdds_ddi_cancelled_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Tax return: Direct Debit cancelled",
      plainTemplate = txt.sdds_ddi_cancelled_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_cancelled_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "sdds_ddi_reminder_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Tax return Direct Debit: reminder of payment collection",
      plainTemplate = txt.sdds_ddi_reminder_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_reminder_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "sdds_ddi_unpaid_dcs_alert",
      fromAddress = FromAddress.noReply("HMRC Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Tax return Direct Debit: payment not collected",
      plainTemplate = txt.sdds_ddi_unpaid_dcs_alert.f,
      htmlTemplate = html.sdds_ddi_unpaid_dcs_alert.f,
      priority = Some(MessagePriority.Urgent)
    ),
    //Passengers email template
    MessageTemplate.create(
      templateId = "passengers_payment_confirmation",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Receipt for payment on goods brought into the UK",
      plainTemplate = txt.passengers_confirmation.f,
      htmlTemplate = html.passengers_confirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dd_email_verifcation",
      fromAddress = FromAddress.noReply("VAT Direct Debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Verify your email address",
      plainTemplate = txt.dd_email_verifcation.f,
      htmlTemplate = html.dd_email_verifcation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    //Recon tps
    MessageTemplate.createWithDynamicSubject(
      templateId = "recon_tps_report",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.recon_tps_report.f,
      htmlTemplate = html.recon_tps_report.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "recon_tops_report",
      fromAddress = FromAddress.noReply("HMRC Online Payments"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = _.apply("subject"),
      plainTemplate = txt.recon_tops_report.f,
      htmlTemplate = html.recon_tops_report.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
