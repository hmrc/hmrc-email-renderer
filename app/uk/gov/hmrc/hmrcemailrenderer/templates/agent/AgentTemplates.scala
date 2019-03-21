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

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Agent

object AgentTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "overseas_application_rejected",
      fromAddress = FromAddress.noReply("HMRC Agent Services"),
      service = Agent,
      subject = "HMRC rejected your agent services account application",
      plainTemplate = txt.overseas_application_rejected.f,
      htmlTemplate = html.overseas_application_rejected.f,
      priority = Some(MessagePriority.Standard))
  ,
  MessageTemplate.create(
    templateId = "overseas_application_accepted",
    fromAddress = FromAddress.noReply("HMRC Agent Services"),
    service = Agent,
    subject = "HMRC approved your agent services account application",
    plainTemplate = txt.overseas_application_accepted.f,
    htmlTemplate = html.overseas_application_accepted.f,
    priority = Some(MessagePriority.Standard))
    ,
  MessageTemplate.create(
    templateId = "overseas_application_received",
    fromAddress = FromAddress.noReply("HMRC Agent Services"),
    service = Agent,
    subject = "HMRC received your agent services account application",
    plainTemplate = txt.overseas_application_received.f,
    htmlTemplate = html.overseas_application_received.f,
    priority = Some(MessagePriority.Standard))
  )
}
