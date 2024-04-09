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

package uk.gov.hmrc.hmrcemailrenderer.templates.lostcredentials

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.LostCredentials

object LostCredentialsTemplates {
  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.create(
      templateId = "retrieve_userid_notification",
      fromAddress = FromAddress.noReply("Government Gateway service"),
      service = LostCredentials,
      subject = "Government Gateway User ID",
      plainTemplate = txt.lostCredentialsRetrieveUseridNotificationEmail.f,
      htmlTemplate = html.lostCredentialsRetrieveUseridNotificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
