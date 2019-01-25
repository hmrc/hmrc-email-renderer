/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.agent

import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Agent
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}

object AgentTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "overseas_application_rejected",
      fromAddress = govUkTeamAddress,
      service = Agent,
      subject = "new message",
      plainTemplate = txt.overseas_application_rejected.f,
      htmlTemplate = html.overseas_application_rejected.f,
      priority = Some(MessagePriority.Standard))
  ,
  MessageTemplate.create(
    templateId = "overseas_application_accepted",
    fromAddress = govUkTeamAddress,
    service = Agent,
    subject = "new message",
    plainTemplate = txt.overseas_application_accepted.f,
    htmlTemplate = html.overseas_application_accepted.f,
    priority = Some(MessagePriority.Standard))
    ,
  MessageTemplate.create(
    templateId = "overseas_application_received",
    fromAddress = govUkTeamAddress,
    service = Agent,
    subject = "new message",
    plainTemplate = txt.overseas_application_received.f,
    htmlTemplate = html.overseas_application_received.f,
    priority = Some(MessagePriority.Standard)))

}
