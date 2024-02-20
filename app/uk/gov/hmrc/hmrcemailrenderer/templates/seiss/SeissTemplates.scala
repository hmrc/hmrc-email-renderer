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

package uk.gov.hmrc.hmrcemailrenderer.templates.seiss

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.noReply
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Seiss

object SeissTemplates {

  lazy val seissFromAddress = noReply("Self-Employment Income Support Scheme")
  lazy val seissFromAddressWelsh = noReply("Cynllun Cymhorthdal Incwm Hunangyflogaeth")
  val templates = Seq(
    MessageTemplate.create(
      templateId = "seiss_processing_grant",
      fromAddress = seissFromAddress,
      service = Seiss,
      subject = "HMRC is processing your grant for the Self-Employment Income Support Scheme",
      plainTemplate = txt.seissProcessingGrant.f,
      htmlTemplate = html.seissProcessingGrant.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "seiss_processing_grant_cy",
      fromAddress = seissFromAddressWelsh,
      service = Seiss,
      subject = "Mae CThEF yn prosesu’ch grant ar gyfer y Cynllun Cymhorthdal Incwm Hunangyflogaeth",
      plainTemplate = txt.seissProcessingGrant_cy.f,
      htmlTemplate = html.seissProcessingGrant_cy.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "seiss_payment_failed",
      fromAddress = seissFromAddress,
      service = Seiss,
      subject = "HMRC needs more details to pay your grant for the Self-Employment Income Support Scheme",
      plainTemplate = txt.seissPaymentFailure.f,
      htmlTemplate = html.seissPaymentFailure.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "seiss_payment_failed_cy",
      fromAddress = seissFromAddressWelsh,
      service = Seiss,
      subject = "Mae angen mwy o fanylion ar CThEF i dalu’ch grant ar gyfer y Cynllun Cymhorthdal Incwm Hunangyflogaeth",
      plainTemplate = txt.seissPaymentFailure_cy.f,
      htmlTemplate = html.seissPaymentFailure_cy.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "seiss_scheme_open",
      fromAddress = seissFromAddress,
      service = Seiss,
      subject = "You can now make a Self-Employment Income Support Scheme grant claim online",
      plainTemplate = txt.seissSchemeOpen.f,
      htmlTemplate = html.seissSchemeOpen.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seiss_received_confirmation",
      fromAddress = seissFromAddress,
      service = Seiss,
      subject = "You submitted a Self-Employment Income Support Scheme grant claim to HMRC",
      plainTemplate = txt.seissReceivedConfirmation.f,
      htmlTemplate = html.seissReceivedConfirmation.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "seiss_phase_3_previously_claimed_stagger",
      fromAddress = seissFromAddress,
      service = Seiss,
      subject = "More help for the self-employed affected by COVID-19",
      plainTemplate = txt.seissPhase3PreviouslyClaimedStagger.f,
      htmlTemplate = html.seissPhase3PreviouslyClaimedStagger.f,
      priority = Some(MessagePriority.Background)
    ),
    MessageTemplate.create(
      templateId = "seiss_phase_3_previously_claimed_stagger_cy",
      fromAddress = seissFromAddressWelsh,
      service = Seiss,
      subject = "Rhagor o help i bobl hunangyflogedig y mae COVID-19 wedi effeithio arnynt",
      plainTemplate = txt.seissPhase3PreviouslyClaimedStagger_cy.f,
      htmlTemplate = html.seissPhase3PreviouslyClaimedStagger_cy.f,
      priority = Some(MessagePriority.Background)
    )
  )
}
