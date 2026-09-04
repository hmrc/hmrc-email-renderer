/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.vpd

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.{ govUkTeamAddress, govUkTeamAddressWelsh }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.VPD

object VPDTemplates {

  private val vpdTeamAddress: String = FromAddress.noReply("HMRC Vaping Products Duty Team")

  val templates = Seq(
    MessageTemplate.create(
      templateId = "vpd_duty_due_confirmation",
      fromAddress = vpdTeamAddress,
      service = VPD,
      subject = "Payment due for your Vaping Products Duty return",
      plainTemplate = txt.vpd_duty_due_confirmation.f,
      htmlTemplate = html.vpd_duty_due_confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "vpd_nil_return_confirmation",
      fromAddress = vpdTeamAddress,
      service = VPD,
      subject = "Your Vaping Products Duty return has been submitted",
      plainTemplate = txt.vpd_nil_return_confirmation.f,
      htmlTemplate = html.vpd_nil_return_confirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "vpd_credit_due_confirmation",
      fromAddress = vpdTeamAddress,
      service = VPD,
      subject = "Credit due on your Vaping Products Duty return",
      plainTemplate = txt.vpd_credit_due_confirmation.f,
      htmlTemplate = html.vpd_credit_due_confirmation.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
