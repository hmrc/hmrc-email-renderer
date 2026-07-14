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

package uk.gov.hmrc.hmrcemailrenderer.templates.dsao

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SeniorAccountingOfficer

object DsaoTemplates {
  val fromAddress: String = FromAddress.noReply("HMRC SAO service")

  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.create(
      templateId = "dsao_registration_confirmation",
      fromAddress = fromAddress,
      service = SeniorAccountingOfficer,
      subject = "Senior Accounting Officer registration",
      plainTemplate = txt.dsao_registration_confirmation.f,
      htmlTemplate = html.dsao_registration_confirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dsao_notification_confirmation",
      fromAddress = fromAddress,
      service = SeniorAccountingOfficer,
      subject = "Submitted: Senior Accounting Officer notification",
      plainTemplate = txt.dsao_notification_confirmation.f,
      htmlTemplate = html.dsao_notification_confirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dsao_certificate_confirmation_for_submitter",
      fromAddress = fromAddress,
      service = SeniorAccountingOfficer,
      subject = "Submitted: Senior Accounting Officer certificate",
      plainTemplate = txt.dsao_certificate_confirmation_for_submitter.f,
      htmlTemplate = html.dsao_certificate_confirmation_for_submitter.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "dsao_certificate_confirmation_for_sao",
      fromAddress = fromAddress,
      service = SeniorAccountingOfficer,
      subject = "Submitted: Senior Accounting Officer certificate",
      plainTemplate = txt.dsao_certificate_confirmation_for_sao.f,
      htmlTemplate = html.dsao_certificate_confirmation_for_sao.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
