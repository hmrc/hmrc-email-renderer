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

package uk.gov.hmrc.hmrcemailrenderer.templates.pods

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PODS

object PodsTemplates {
  val templates = Seq(
       MessageTemplate.create(
      templateId = "pods_scheme_register",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "The pension scheme details have been sent to HMRC",
      plainTemplate = txt.schemeRegSubmitted.f,
      htmlTemplate = html.schemeRegSubmitted.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psa_register",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "You have registered as a pension scheme administrator",
      plainTemplate = txt.psaRegistered.f,
      htmlTemplate = html.psaRegistered.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psa_invited",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "You have been invited to administer a pension scheme",
      plainTemplate = txt.psaInvited.f,
      htmlTemplate = html.psaInvited.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
