/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.voa

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CCA
import registration._
object CCATemplates {

  private def appealsSubject(params: Map[String, String]) =
    s"EIPP ${params.getOrElse("submissionDate", "")} ${params.getOrElse("postcode", "")}"

  val templates = Seq(
    MessageTemplate.create(
      templateId = "cca_enrolment_migration_confirmation",
      fromAddress = govUkTeamAddress,
      service = CCA,
      subject = "Valuation Office Agency - check and challenge registration",
      plainTemplate = txt.ccaEnrolmentConfirmationExisting.f,
      htmlTemplate = html.ccaEnrolmentConfirmationExisting.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cca_enrolment_confirmation",
      fromAddress = govUkTeamAddress,
      service = CCA,
      subject = "Valuation Office Agency - check and challenge registration",
      plainTemplate = registration.txt.ccaEnrolmentConfirmation.f,
      htmlTemplate = registration.html.ccaEnrolmentConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cca_enrolment_confirmation_agent",
      fromAddress = govUkTeamAddress,
      service = CCA,
      subject = "Valuation Office Agency - check and challenge registration",
      plainTemplate = registration.txt.ccaEnrolmentConfirmationAgent.f,
      htmlTemplate = registration.html.ccaEnrolmentConfirmationAgent.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cca_enrolment_confirmation_individual",
      fromAddress = govUkTeamAddress,
      service = CCA,
      subject = "Valuation Office Agency - check and challenge registration",
      plainTemplate = registration.txt.ccaEnrolmentConfirmationIndividual.f,
      htmlTemplate = registration.html.ccaEnrolmentConfirmationIndividual.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "cca_revaluation_subscription_confirmation",
      fromAddress = govUkTeamAddress,
      service = CCA,
      subject = "You signed up for news about business rate revaluations",
      plainTemplate = subscription.txt.ccaRevalSubscriptionConfirmation.f,
      htmlTemplate = subscription.html.ccaRevalSubscriptionConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "cca_appeals_submission_link",
      fromAddress = govUkTeamAddress,
      service = CCA,
      subject = appealsSubject(_),
      plainTemplate = appeals.txt.ccaAppealsSubmissionData.f,
      htmlTemplate = appeals.html.ccaAppealsSubmissionData.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
