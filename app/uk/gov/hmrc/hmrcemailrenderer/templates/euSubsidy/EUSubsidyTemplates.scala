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

package uk.gov.hmrc.hmrcemailrenderer.templates.euSubsidy

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.EUSubsidy

object EUSubsidyTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "create_undertaking_by_lead",
      fromAddress = govUkTeamAddress,
      service = EUSubsidy,
      subject = "You created a new single undertaking",
      plainTemplate = txt.createUndertakingByLead.f,
      htmlTemplate = html.createUndertakingByLead.f,
      priority = Some(MessagePriority.Urgent)
    )
  )


}
