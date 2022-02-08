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

package uk.gov.hmrc.hmrcemailrenderer.templates.gg

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.{ GovernmentGateway, SecurityConsole }

object GgTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "gg_userid_notification",
      fromAddress = FromAddress.noReply("Government Gateway service"),
      service = GovernmentGateway,
      subject = "Government Gateway User ID",
      plainTemplate = txt.ggUserIdNotificationEmail.f,
      htmlTemplate = html.ggUserIdNotificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "2SV_reset_confirmation",
      fromAddress = FromAddress.noReply("Government Gateway service"),
      service = GovernmentGateway,
      subject = "2Sv reset confirmation",
      plainTemplate = txt.TwoSvResetConfirmation.f,
      htmlTemplate = html.TwoSvResetConfirmation.f
    ),
    MessageTemplate.create(
      templateId = "password_change_confirmation",
      fromAddress = FromAddress.noReply("Government Gateway service"),
      service = SecurityConsole,
      subject = "Password change confirmation",
      plainTemplate = txt.PasswordChangeConfirmation.f,
      htmlTemplate = html.PasswordChangeConfirmation.f
    ),
    MessageTemplate.create(
      templateId = "email_verification_passcode",
      fromAddress = FromAddress.noReply("Government Gateway service"),
      service = GovernmentGateway,
      subject = "Your email confirmation code",
      plainTemplate = txt.EmailVerificationPasscode.f,
      htmlTemplate = html.EmailVerificationPasscode.f
    ),
    MessageTemplate.create(
      templateId = "email_verification_passcode_welsh",
      fromAddress = FromAddress.noReply("Government Gateway service"),
      service = GovernmentGateway,
      subject = "Eich cod cadarnhau e-bost",
      plainTemplate = txt.EmailVerificationPasscodeWelsh.f,
      htmlTemplate = html.EmailVerificationPasscodeWelsh.f
    )
  )
}
