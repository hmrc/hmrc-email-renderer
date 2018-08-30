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

package uk.gov.hmrc.hmrcemailrenderer.templates.onlinepaymentservice

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.{FromAddress, ServiceIdentifier}

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
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "payment_successful_cy",
      fromAddress = FromAddress.noReply("O Daliadau Ar-lein CThEM"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "Cadarnhad gan CThEM o daliad",
      plainTemplate = txt.payment_successful_cy.f,
      htmlTemplate = html.payment_successful_cy.f,
      priority = Some(MessagePriority.Urgent)),

    // Direct Debit templates

    MessageTemplate.create(
      templateId = "ddi_cancelled",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: Cancelled Direct Debit",
      plainTemplate = txt.ddi_cancelled.f,
      htmlTemplate = html.ddi_cancelled.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "ddi_advance_notice",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: Advance notice of your payment",
      plainTemplate = txt.ddi_advance_notice.f,
      htmlTemplate = html.ddi_advance_notice.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "ddi_migration_letter",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: important information",
      plainTemplate = txt.ddi_migration_letter.f,
      htmlTemplate = html.ddi_migration_letter.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "ddi_not_acceptable",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit Instruction: cannot be used",
      plainTemplate = txt.ddi_not_acceptable.f,
      htmlTemplate = html.ddi_not_acceptable.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "ddi_reinstated",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: Reinstated Direct Debit Instruction",
      plainTemplate = txt.ddi_reinstated.f,
      htmlTemplate = html.ddi_reinstated.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "ddi_unpaid",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: payment not collected",
      plainTemplate = txt.ddi_unpaid.f,
      htmlTemplate = html.ddi_unpaid.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "ddi_set_up",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: Confirmation of your Direct Debit",
      plainTemplate = txt.ddi_set_up.f,
      htmlTemplate = html.ddi_set_up.f,
      priority = Some(MessagePriority.Urgent)),
    MessageTemplate.create(
      templateId = "ddi_cancelled_online",
      fromAddress = FromAddress.noReply("VAT direct debit"),
      service = ServiceIdentifier.OnlinePaymentService,
      subject = "VAT Return Direct Debit: cancelled",
      plainTemplate = txt.ddi_cancelled_online.f,
      htmlTemplate = html.ddi_cancelled_online.f,
      priority = Some(MessagePriority.Urgent))
  )
}
