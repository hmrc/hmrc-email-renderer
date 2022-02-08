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

package uk.gov.hmrc.hmrcemailrenderer.templates.mtdfb.vat

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.MTDfBVatSignUp

object MtdfbVatTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "mtdfb_vat_principal_sign_up_successful",
      fromAddress = FromAddress.noReply("Use software to submit your VAT Returns"),
      service = MTDfBVatSignUp,
      subject = "Use software to submit your VAT Returns",
      plainTemplate = txt.principal_sign_up_successful.f,
      htmlTemplate = html.principal_sign_up_successful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "mtdfb_vat_principal_sign_up_failure",
      fromAddress = FromAddress.noReply("Use software to submit your VAT Returns"),
      service = MTDfBVatSignUp,
      subject = "Use software to submit your VAT Returns",
      plainTemplate = txt.principal_sign_up_failure.f,
      htmlTemplate = html.principal_sign_up_failure.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "mtdfb_vat_agent_sign_up_successful",
      fromAddress = FromAddress.noReply("HMRC Making Tax Digital for VAT"),
      service = MTDfBVatSignUp,
      subject = "HMRC client sign up successful for Making Tax Digital",
      plainTemplate = txt.agent_sign_up_successful.f,
      htmlTemplate = html.agent_sign_up_successful.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
