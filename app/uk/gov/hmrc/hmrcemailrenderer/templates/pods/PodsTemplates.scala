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

package uk.gov.hmrc.hmrcemailrenderer.templates.pods

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PODS

object PodsTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "pods_scheme_register",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "HMRC received your application",
      plainTemplate = txt.schemeRegSubmitted.f,
      htmlTemplate = html.schemeRegSubmitted.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psa_register",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "You have registered as a pension scheme administrator",
      plainTemplate = txt.psaRegistered.f,
      htmlTemplate = html.psaRegistered.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psa_invited",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "You have an invitation to be added as a scheme administrator of a pension scheme",
      plainTemplate = txt.psaInvited.f,
      htmlTemplate = html.psaInvited.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_file_aft_return",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "Accounting for Tax - return submitted",
      plainTemplate = txt.aftReturnSubmitted.f,
      htmlTemplate = html.aftReturnSubmitted.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_aft_amended_return_decrease",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "Accounting for Tax - amended return submitted",
      plainTemplate = txt.aftAmendmentSubmittedDecrease.f,
      htmlTemplate = html.aftAmendmentSubmittedDecrease.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_aft_amended_return_no_change",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "Accounting for Tax - amended return submitted",
      plainTemplate = txt.aftAmendmentSubmittedNoChange.f,
      htmlTemplate = html.aftAmendmentSubmittedNoChange.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_aft_amended_return_increase",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "Accounting for Tax - amended return submitted",
      plainTemplate = txt.aftAmendmentSubmittedIncrease.f,
      htmlTemplate = html.aftAmendmentSubmittedIncrease.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psp_register",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "Registered: pension scheme practitioner",
      plainTemplate = txt.pspRegistered.f,
      htmlTemplate = html.pspRegistered.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psp_amend",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "Amended: pension scheme practitioner",
      plainTemplate = txt.pspAmended.f,
      htmlTemplate = html.pspAmended.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psp_de_auth_psp_individual",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "You have deauthorised as a pension scheme practitioner",
      plainTemplate = txt.pspDeAuthorisedIndividual.f,
      htmlTemplate = html.pspDeAuthorisedIndividual.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psp_de_auth_psp_company_partnership",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "You have deauthorised a pension scheme practitioner",
      plainTemplate = txt.pspDeAuthorisedCompanyPartnership.f,
      htmlTemplate = html.pspDeAuthorisedCompanyPartnership.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_authorise_psp",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "The pension scheme practitioner is now authorised",
      plainTemplate = txt.pspAuthorised.f,
      htmlTemplate = html.pspAuthorised.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psa_deauthorise_psp",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "Pension scheme practitioner deauthorised",
      plainTemplate = txt.pspDeauthorisedByPsa.f,
      htmlTemplate = html.pspDeauthorisedByPsa.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "pods_psp_deregister_self",
      fromAddress = govUkTeamAddress,
      service = PODS,
      subject = "You are no longer a pension scheme practitioner",
      plainTemplate = txt.pspDeregisteredSelf.f,
      htmlTemplate = html.pspDeregisteredSelf.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
