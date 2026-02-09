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

package uk.gov.hmrc.hmrcemailrenderer.templates.niref

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PersonalTax

object NIRefTemplates {
  val templates: Seq[MessageTemplate] = Seq(
    MessageTemplate.create(
      templateId = "newMessageAlert_NIRef1",
      fromAddress = govUkTeamAddress,
      service = PersonalTax,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.newMessageAlert_NIRef1.f,
      htmlTemplate = html.newMessageAlert_NIRef1.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_NIRef1_cy",
      fromAddress = govUkTeamAddress,
      service = PersonalTax,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlert_NIRef1_cy.f,
      htmlTemplate = html.newMessageAlert_NIRef1_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_NIRef2",
      fromAddress = govUkTeamAddress,
      service = PersonalTax,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.newMessageAlert_NIRef2.f,
      htmlTemplate = html.newMessageAlert_NIRef2.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_NIRef2_cy",
      fromAddress = govUkTeamAddress,
      service = PersonalTax,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlert_NIRef2_cy.f,
      htmlTemplate = html.newMessageAlert_NIRef2_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_NIRef3",
      fromAddress = govUkTeamAddress,
      service = PersonalTax,
      subject = "You’ve got a new message from HMRC",
      plainTemplate = txt.newMessageAlert_NIRef3.f,
      htmlTemplate = html.newMessageAlert_NIRef3.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "newMessageAlert_NIRef3_cy",
      fromAddress = govUkTeamAddress,
      service = PersonalTax,
      subject = "Mae gennych neges newydd oddi wrth CThEF",
      plainTemplate = txt.newMessageAlert_NIRef3_cy.f,
      htmlTemplate = html.newMessageAlert_NIRef3_cy.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
