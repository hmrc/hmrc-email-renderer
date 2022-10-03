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

package uk.gov.hmrc.hmrcemailrenderer.templates.mtdfb.vatreg

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.MTDfBVatRegistration

object VatRegTemplates {

  val serviceName = "VAT Registration"
  val subject = "We’ve received your VAT registration application"
  val subjectWelsh = "Mae’ch cais i gofrestru ar gyfer TAW wedi dod i law"
  val templatePrefix = "mtdfb_vatreg"

  val templates = Seq(
    MessageTemplate.create(
      templateId = s"${templatePrefix}_registration_received",
      fromAddress = FromAddress.noReply(serviceName),
      service = MTDfBVatRegistration,
      subject = subject,
      plainTemplate = txt.registration_received.f,
      htmlTemplate = html.registration_received.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = s"${templatePrefix}_registration_received_cy",
      fromAddress = FromAddress.noReply(serviceName),
      service = MTDfBVatRegistration,
      subject = subjectWelsh,
      plainTemplate = txt.registration_received_cy.f,
      htmlTemplate = html.registration_received_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = s"${templatePrefix}_registration_received_email",
      fromAddress = FromAddress.noReply(serviceName),
      service = MTDfBVatRegistration,
      subject = subject,
      plainTemplate = txt.registration_received_email.f,
      htmlTemplate = html.registration_received_email.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = s"${templatePrefix}_registration_received_email_cy",
      fromAddress = FromAddress.noReply(serviceName),
      service = MTDfBVatRegistration,
      subject = subjectWelsh,
      plainTemplate = txt.registration_received_email_cy.f,
      htmlTemplate = html.registration_received_email_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = s"${templatePrefix}_registration_received_post",
      fromAddress = FromAddress.noReply(serviceName),
      service = MTDfBVatRegistration,
      subject = subject,
      plainTemplate = txt.registration_received_post.f,
      htmlTemplate = html.registration_received_post.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = s"${templatePrefix}_registration_received_post_cy",
      fromAddress = FromAddress.noReply(serviceName),
      service = MTDfBVatRegistration,
      subject = subjectWelsh,
      plainTemplate = txt.registration_received_post_cy.f,
      htmlTemplate = html.registration_received_post_cy.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
