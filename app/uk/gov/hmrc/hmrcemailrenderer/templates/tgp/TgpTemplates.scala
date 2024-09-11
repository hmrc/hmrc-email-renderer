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

package uk.gov.hmrc.hmrcemailrenderer.templates.tgp

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Tgp

object TgpTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "tgp_download_record_notification_email",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Tgp,
      subject = "Your Trader Goods Profile records file is ready to download",
      plainTemplate = txt.DownloadRecordNotification.f,
      htmlTemplate = html.DownloadRecordNotification.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "tgp_download_record_notification_email_cy",
      fromAddress = FromAddress.noReply("Do not reply"),
      service = Tgp,
      subject = "Mae’r ffeil sy'n cynnwys cofnodion eich Proffil Nwyddau Masnachwr yn barod i’w lawrlwytho",
      plainTemplate = txt.DownloadRecordNotification_cy.f,
      htmlTemplate = html.DownloadRecordNotification_cy.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
