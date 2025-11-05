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

package uk.gov.hmrc.hmrcemailrenderer.templates.ad

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Itsa

object ADTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "new_message_alert_ad",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_ad.f,
      htmlTemplate = html.new_message_alert_ad.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_ad_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_ad_cy.f,
      htmlTemplate = html.new_message_alert_ad_cy.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
