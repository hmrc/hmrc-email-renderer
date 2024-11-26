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

package uk.gov.hmrc.hmrcemailrenderer.templates.cir

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CIPInsightsAndReputation

object CirTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "cir_email_verification_code",
      fromAddress = FromAddress.noReply("CIP Insights and Reputation"),
      service = CIPInsightsAndReputation,
      subject = "Your email confirmation code",
      plainTemplate = txt.EmailVerification.f,
      htmlTemplate = html.EmailVerification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cir_email_verification_code_welsh",
      fromAddress = FromAddress.noReply("CIP Insights and Reputation"),
      service = CIPInsightsAndReputation,
      subject = "Eich cod gwirio e-bost",
      plainTemplate = txt.EmailVerificationWelsh.f,
      htmlTemplate = html.EmailVerificationWelsh.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
