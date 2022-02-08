/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.awrs

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.AlcoholWholesalerRegistrationScheme
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress

object AwrsTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "awrs_notification_template_reg_change",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS registration change",
      plainTemplate = txt.awrsNotificationEmailRegChange.f,
      htmlTemplate = html.awrsNotificationEmailRegChange.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_app_change",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS application change",
      plainTemplate = txt.awrsNotificationEmailAppChange.f,
      htmlTemplate = html.awrsNotificationEmailAppChange.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_comfirmation_api4",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS application confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI4.f,
      htmlTemplate = html.awrsNotificationConfirmationAPI4.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_comfirmation_api4_new_business",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS application confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI4NewBusiness.f,
      htmlTemplate = html.awrsNotificationConfirmationAPI4NewBusiness.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_comfirmation_api6",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS amendment confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI6.f,
      htmlTemplate = html.awrsNotificationConfirmationAPI6.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_comfirmation_api6_pending",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS amendment confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI6Pending.f,
      htmlTemplate = html.awrsNotificationConfirmationAPI6Pending.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_comfirmation_api6_new_business",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS amendment confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI6NewBusiness.f,
      htmlTemplate = html.awrsNotificationConfirmationAPI6NewBusiness.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_comfirmation_api6_new_business_pending",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS amendment confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI6NewBusinessPending.f,
      htmlTemplate = html.awrsNotificationConfirmationAPI6NewBusinessPending.f
    ),
    MessageTemplate.create(
      templateId = "awrs_email_verification",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "Verify your email address",
      plainTemplate = txt.awrsEmailVerification.f,
      htmlTemplate = html.awrsEmailVerification.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_cancellation_api10",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS cancellation request",
      plainTemplate = txt.awrsNotificationCancellationAPI10.f,
      htmlTemplate = html.awrsNotificationCancellationAPI10.f
    ),
    MessageTemplate.create(
      templateId = "awrs_notification_template_withdrawn_api8",
      fromAddress = govUkTeamAddress,
      service = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS withdrawal request",
      plainTemplate = txt.awrsNotificationWithdrawalAPI8.f,
      htmlTemplate = html.awrsNotificationWithdrawalAPI8.f
    )
  )
}
