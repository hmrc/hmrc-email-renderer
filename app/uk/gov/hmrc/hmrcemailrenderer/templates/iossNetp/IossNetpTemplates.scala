/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.iossNetp

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.IossNetp
import uk.gov.hmrc.hmrcemailrenderer.templates.{ FromAddress, ServiceIdentifier }

object IossNetpTemplates {

  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.create(
      templateId = "ioss_netp_email_declaration_code",
      fromAddress = FromAddress.noReply("VAT Import One Stop Shop Team"),
      service = IossNetp,
      subject = "Your Import One Stop Shop activation code",
      plainTemplate = txt.ioss_netp_email_declaration_code.f,
      htmlTemplate = html.ioss_netp_email_declaration_code.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_ioss_netp",
      fromAddress = FromAddress.govUkTeamAddress,
      service = IossNetp,
      subject = "You have a new message from HMRC",
      plainTemplate = txt.new_message_alert_ioss_netp.f,
      htmlTemplate = html.new_message_alert_ioss_netp.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
