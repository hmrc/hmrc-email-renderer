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

package uk.gov.hmrc.hmrcemailrenderer.templates.ioss

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Ioss

object IossTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "new_message_alert_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_ioss.f,
      htmlTemplate = html.new_message_alert_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_ioss_cy.f,
      htmlTemplate = html.new_message_alert_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m01_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m01_ioss.f,
      htmlTemplate = html.new_message_alert_m01_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m01_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m01_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m01_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m01a_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m01a_ioss.f,
      htmlTemplate = html.new_message_alert_m01a_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m01a_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m01a_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m01a_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m02_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m02_ioss.f,
      htmlTemplate = html.new_message_alert_m02_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m02_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m02_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m02_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m02a_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m02a_ioss.f,
      htmlTemplate = html.new_message_alert_m02a_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m02a_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m02a_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m02a_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m04_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m04_ioss.f,
      htmlTemplate = html.new_message_alert_m04_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m04_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m04_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m04_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m05_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m05_ioss.f,
      htmlTemplate = html.new_message_alert_m05_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m05_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m05_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m05_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m05a_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m05a_ioss.f,
      htmlTemplate = html.new_message_alert_m05a_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m05a_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m05a_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m05a_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m06_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m06_ioss.f,
      htmlTemplate = html.new_message_alert_m06_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m06_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m06_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m06_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m06a_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m06a_ioss.f,
      htmlTemplate = html.new_message_alert_m06a_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m06a_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m06a_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m06a_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m07_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m07_ioss.f,
      htmlTemplate = html.new_message_alert_m07_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m07_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m07_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m07_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m07a_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m07a_ioss.f,
      htmlTemplate = html.new_message_alert_m07a_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m07a_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m07a_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m07a_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m08_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m08_ioss.f,
      htmlTemplate = html.new_message_alert_m08_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m08_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m08_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m08_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m08a_ioss",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.new_message_alert_m08a_ioss.f,
      htmlTemplate = html.new_message_alert_m08a_ioss.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "new_message_alert_m08a_ioss_cy",
      fromAddress = govUkTeamAddress,
      service = Ioss,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.new_message_alert_m08a_ioss_cy.f,
      htmlTemplate = html.new_message_alert_m08a_ioss_cy.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
