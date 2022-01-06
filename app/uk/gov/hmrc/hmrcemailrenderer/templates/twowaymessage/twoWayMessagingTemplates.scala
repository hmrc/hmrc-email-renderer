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

package uk.gov.hmrc.hmrcemailrenderer.templates.twowaymessage

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.TwoWayMessaging
import uk.gov.hmrc.hmrcemailrenderer.templates.helpers.DateHelper

object twoWayMessagingTemplates {

  private def getWaitTimeSubject(params: Map[String, String]): String = {
    val waitTime = params.getOrElse("waitTime", "7 days")
    s"HMRC will reply within $waitTime"
  }

  private def getUpdateSubject(params: Map[String, String]): String =
    params.get("receivedAt") match {
      case Some(receivedAt) =>
        val shortDate = DateHelper.shortDateFormatter(receivedAt)
        s"HMRC update on your $shortDate question"
      case _ => "HMRC update on your question"
    }

  val templates = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "newMessageAlert_2WSM-question",
      fromAddress = FromAddress.noReply("HMRC digital team"),
      service = TwoWayMessaging,
      subject = getWaitTimeSubject(_),
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
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "twoWayMessageUpdate",
      fromAddress = FromAddress.noReply("HMRC digital team"),
      service = TwoWayMessaging,
      subject = getUpdateSubject(_),
      plainTemplate = txt.twoWayMessageUpdate.f,
      htmlTemplate = html.twoWayMessageUpdate.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
