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

package uk.gov.hmrc.hmrcemailrenderer.templates.exports

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier

object ExportsTemplates {

  val templates = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "dmsdoc_notification",
      fromAddress = FromAddress.noReply("HMRC CDS Exports Team"),
      service = ServiceIdentifier.Exports,
      subject = params => s"Route 1: documents required for MRN ${params("mrn")}",
      plainTemplate = txt.dmsdocNotification.f,
      htmlTemplate = html.dmsdocNotification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_CDS_exp",
      fromAddress = FromAddress.noReply("HMRC CDS Exports Team"),
      service = ServiceIdentifier.Exports,
      subject = "Urgent: Your Declaration or Goods are being queried",
      plainTemplate = txt.nudgeNotification.f,
      htmlTemplate = html.nudgeNotification.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
