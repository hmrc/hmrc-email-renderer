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

package uk.gov.hmrc.hmrcemailrenderer.templates.cgtpd

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Cgtpd

object CgtpdTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "cgtpd_email_verification",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "Confirm email for Capital Gains Tax on UK property",
      plainTemplate = txt.cgtpdEmailVerification.f,
      htmlTemplate = html.cgtpdEmailVerification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cgtpd_email_verification_cy",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "Cadarnhau e-bost ar gyfer Treth Enillion Cyfalaf ar eiddo yn y DU",
      plainTemplate = txt.cgtpdEmailVerification_cy.f,
      htmlTemplate = html.cgtpdEmailVerification_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cgtpd_account_created",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "Capital Gains Tax on UK property account created",
      plainTemplate = txt.cgtpdAccountCreated.f,
      htmlTemplate = html.cgtpdAccountCreated.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cgtpd_account_created_cy",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "Cyfrif Treth Enillion Cyfalaf ar eiddo yn y DU wedi’i greu",
      plainTemplate = txt.cgtpdAccountCreated_cy.f,
      htmlTemplate = html.cgtpdAccountCreated_cy.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cgtpd_submission_confirmation",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "HMRC has received your return",
      plainTemplate = txt.cgtpdSubmissionConfirmation.f,
      htmlTemplate = html.cgtpdSubmissionConfirmation.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "cgtpd_submission_confirmation_cy",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "Mae CThEF wedi cael eich Ffurflen Dreth",
      plainTemplate = txt.cgtpdSubmissionConfirmation_cy.f,
      htmlTemplate = html.cgtpdSubmissionConfirmation_cy.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
