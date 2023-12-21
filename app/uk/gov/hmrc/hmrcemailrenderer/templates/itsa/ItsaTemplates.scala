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

package uk.gov.hmrc.hmrcemailrenderer.templates.itsa

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Itsa

object ItsaTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "new_message_alert_itsa",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsa.f,
      htmlTemplate = html.new_message_alert_itsa.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsa_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsa_cy.f,
      htmlTemplate = html.new_message_alert_itsa_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaqu1",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsaqu1.f,
      htmlTemplate = html.new_message_alert_itsaqu1.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaqu1_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsaqu1_cy.f,
      htmlTemplate = html.new_message_alert_itsaqu1_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaqu2",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsaqu2.f,
      htmlTemplate = html.new_message_alert_itsaqu2.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaqu2_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsaqu2_cy.f,
      htmlTemplate = html.new_message_alert_itsaqu2_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaeops1",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsaeops1.f,
      htmlTemplate = html.new_message_alert_itsaeops1.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaeops1_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsaeops1_cy.f,
      htmlTemplate = html.new_message_alert_itsaeops1_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaeops2",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsaeops2.f,
      htmlTemplate = html.new_message_alert_itsaeops2.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaeops2_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsaeops2_cy.f,
      htmlTemplate = html.new_message_alert_itsaeops2_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaeopsf",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsaeopsf.f,
      htmlTemplate = html.new_message_alert_itsaeopsf.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsaeopsf_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsaeopsf_cy.f,
      htmlTemplate = html.new_message_alert_itsaeopsf_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa1-1",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsapoa1_1.f,
      htmlTemplate = html.new_message_alert_itsapoa1_1.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa1-1_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsapoa1_1_cy.f,
      htmlTemplate = html.new_message_alert_itsapoa1_1_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa1-2",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsapoa1_2.f,
      htmlTemplate = html.new_message_alert_itsapoa1_2.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa1-2_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsapoa1_2_cy.f,
      htmlTemplate = html.new_message_alert_itsapoa1_2_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa2-1",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsapoa2_1.f,
      htmlTemplate = html.new_message_alert_itsapoa2_1.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa2-1_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsapoa2_1_cy.f,
      htmlTemplate = html.new_message_alert_itsapoa2_1_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa2-2",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsapoa2_2.f,
      htmlTemplate = html.new_message_alert_itsapoa2_2.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa2-2_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsapoa2_2_cy.f,
      htmlTemplate = html.new_message_alert_itsapoa2_2_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsafd1",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsafd1.f,
      htmlTemplate = html.new_message_alert_itsafd1.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsafd1_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsafd1_cy.f,
      htmlTemplate = html.new_message_alert_itsafd1_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsafd2",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsafd2.f,
      htmlTemplate = html.new_message_alert_itsafd2.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsafd2_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsafd2_cy.f,
      htmlTemplate = html.new_message_alert_itsafd2_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsafd3",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsafd3.f,
      htmlTemplate = html.new_message_alert_itsafd3.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsafd3_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsafd3_cy.f,
      htmlTemplate = html.new_message_alert_itsafd3_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa-cn",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsapoa_cn.f,
      htmlTemplate = html.new_message_alert_itsapoa_cn.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsapoa-cn_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsapoa_cn_cy.f,
      htmlTemplate = html.new_message_alert_itsapoa_cn_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsauc1",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_itsauc1.f,
      htmlTemplate = html.new_message_alert_itsafd1.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_itsauc1_cy",
      fromAddress = govUkTeamAddress,
      service = Itsa,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_itsauc1_cy.f,
      htmlTemplate = html.new_message_alert_itsauc1_cy.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
