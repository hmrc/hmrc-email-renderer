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

package uk.gov.hmrc.hmrcemailrenderer.templates.fhdds

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Fhdds

object FhddsTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "fhdds_submission_confirmation",
      fromAddress = govUkTeamAddress,
      service = Fhdds,
      subject = "Fulfilment House Due Diligence Scheme application received",
      plainTemplate = txt.fhddsBetaSubmissionConfirmation.f,
      htmlTemplate = html.fhddsBetaSubmissionConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "fhdds_submission_withdrawal",
      fromAddress = govUkTeamAddress,
      service = Fhdds,
      subject = "Fulfilment House Due Diligence Scheme application withdrawn",
      plainTemplate = txt.fhddsBetaSubmissionWithdrawal.f,
      htmlTemplate = html.fhddsBetaSubmissionWithdrawal.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "fhdds_email_verification",
      fromAddress = govUkTeamAddress,
      service = Fhdds,
      subject = "Fulfilment House Due Diligence Scheme email verification",
      plainTemplate = txt.fhddsBetaEmailVerification.f,
      htmlTemplate = html.fhddsBetaEmailVerification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "fhdds_submission_deregister",
      fromAddress = govUkTeamAddress,
      service = Fhdds,
      subject = "Fulfilment House Due Diligence Scheme registration cancelled",
      plainTemplate = txt.fhddsBetaDeregistration.f,
      htmlTemplate = html.fhddsBetaDeregistration.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "fhddsAlertMessage",
      fromAddress = govUkTeamAddress,
      service = Fhdds,
      subject = "Fulfilment House Due Diligence Scheme Alert Message",
      plainTemplate = txt.fhddsAlertMessage.f,
      htmlTemplate = html.fhddsAlertMessage.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
