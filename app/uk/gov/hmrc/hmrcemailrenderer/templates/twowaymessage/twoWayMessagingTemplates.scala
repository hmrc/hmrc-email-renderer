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

package uk.gov.hmrc.hmrcemailrenderer.templates.twowaymessage

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate, Subject}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.TwoWayMessaging

object twoWayMessagingTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "newMessageAlert_2WSM-question",
      fromAddress = FromAddress.noReply("HMRC digital team"),
      service = TwoWayMessaging,
      subject =  "HMRC will reply within 7 days",
      plainTemplate = txt.twoWayMessageRecievedTemplate.f,
      htmlTemplate = html.twoWayMessageRecievedTemplate.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_2WSM-reply",
      fromAddress = FromAddress.noReply("HMRC digital team"),
      service = TwoWayMessaging,
      subject = "HMRC reply: Sign in for new message",
      plainTemplate = txt.twoWayMessageNotificationTemplate.f,
      htmlTemplate = html.twoWayMessageNotificationTemplate.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
