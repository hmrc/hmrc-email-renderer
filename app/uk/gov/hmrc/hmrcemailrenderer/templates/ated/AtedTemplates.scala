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

package uk.gov.hmrc.hmrcemailrenderer.templates.ated

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Ated
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress

object AtedTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "chargeable_return_submit",
      fromAddress = govUkTeamAddress,
      service = Ated,
      subject = "Update to Annual Tax on Enveloped Dwellings",
      plainTemplate = txt.chargeableReturnSubmitted.f,
      htmlTemplate = html.chargeableReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "relief_return_submit",
      fromAddress = govUkTeamAddress,
      service = Ated,
      subject = "Update to Annual Tax on Enveloped Dwellings",
      plainTemplate = txt.reliefReturnSubmitted.f,
      htmlTemplate = html.reliefReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "amended_return_submit",
      fromAddress = govUkTeamAddress,
      service = Ated,
      subject = "Update to Annual Tax on Enveloped Dwellings",
      plainTemplate = txt.amendedReturnSubmitted.f,
      htmlTemplate = html.amendedReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "further_return_submit",
      fromAddress = govUkTeamAddress,
      service = Ated,
      subject = "Update to Annual Tax on Enveloped Dwellings",
      plainTemplate = txt.furtherReturnSubmitted.f,
      htmlTemplate = html.furtherReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "change_details_return_submit",
      fromAddress = govUkTeamAddress,
      service = Ated,
      subject = "Update to Annual Tax on Enveloped Dwellings",
      plainTemplate = txt.changedDetailsReturnSubmitted.f,
      htmlTemplate = html.changedDetailsReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "disposal_return_submit",
      fromAddress = govUkTeamAddress,
      service = Ated,
      subject = "Update to Annual Tax on Enveloped Dwellings",
      plainTemplate = txt.disposalReturnSubmitted.f,
      htmlTemplate = html.disposalReturnSubmitted.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
