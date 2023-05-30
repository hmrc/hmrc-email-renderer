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

package uk.gov.hmrc.hmrcemailrenderer.templates.oss

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.OSS
import views.{ html, txt }

object OSSTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "oss_registration_confirmation",
      fromAddress = FromAddress.noReply("VAT One Stop Shop Team"),
      service = OSS,
      subject = "HMRC: your registration for the One Stop Shop Union scheme",
      plainTemplate = txt.oss_registration_confirmation.f,
      htmlTemplate = html.oss_registration_confirmation.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "oss_returns_email_confirmation",
      fromAddress = FromAddress.noReply("VAT One Stop Shop Team"),
      service = OSS,
      subject = "HMRC: VAT return submitted",
      plainTemplate = txt.oss_returns_email_confirmation.f,
      htmlTemplate = html.oss_returns_email_confirmation.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "oss_returns_email_confirmation_no_vat_owed",
      fromAddress = FromAddress.noReply("VAT One Stop Shop Team"),
      service = OSS,
      subject = "HMRC: VAT return submitted",
      plainTemplate = txt.oss_returns_email_confirmation_no_vat_owed.f,
      htmlTemplate = html.oss_returns_email_confirmation_no_vat_owed.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "oss_overdue_returns_email_confirmation",
      fromAddress = FromAddress.noReply("VAT One Stop Shop Team"),
      service = OSS,
      subject = "HMRC: VAT return submitted",
      plainTemplate = txt.oss_overdue_returns_email_confirmation.f,
      htmlTemplate = html.oss_overdue_returns_email_confirmation.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "oss_registration_amendment_confirmation",
      fromAddress = FromAddress.noReply("VAT One Stop Shop Team"),
      service = OSS,
      subject = "HMRC: One Stop Shop details updated",
      plainTemplate = txt.oss_registration_amendment_confirmation.f,
      htmlTemplate = html.oss_registration_amendment_confirmation.f,
      priority = Some(MessagePriority.Background)
    )
  )
}
