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

package uk.gov.hmrc.hmrcemailrenderer.templates.customs

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Customs

object CustomsTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "customs_registration_successful",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "HMRC approved your EORI number application",
      plainTemplate = txt.customsRegistrationSuccessful.f,
      htmlTemplate = html.customsRegistrationSuccessful.f
    ),
    MessageTemplate.create(
      templateId = "customs_registration_not_successful",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Your EORI application was unsuccessful",
      plainTemplate = txt.customsRegistrationNotSuccessful.f,
      htmlTemplate = html.customsRegistrationNotSuccessful.f
    ),
    MessageTemplate.create(
      templateId = "customs_migrate_successful",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "HMRC approved your CDS application",
      plainTemplate = txt.customsMigrateSuccessful.f,
      htmlTemplate = html.customsMigrateSuccessful.f
    ),
    MessageTemplate.create(
      templateId = "customs_migrate_not_successful",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Your CDS application was unsuccessful",
      plainTemplate = txt.customsMigrateNotSuccessful.f,
      htmlTemplate = html.customsMigrateNotSuccessful.f
    ),
    MessageTemplate.create(
      templateId = "customs_validation_success",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Status Change in your Supplementary Declaration",
      plainTemplate = txt.customsValidationSuccess.f,
      htmlTemplate = html.customsValidationSuccess.f
    ),
    MessageTemplate.create(
      templateId = "customs_payment_required",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Status Change in your Supplementary Declaration",
      plainTemplate = txt.customsPaymentRequired.f,
      htmlTemplate = html.customsPaymentRequired.f
    ),
    MessageTemplate.create(
      templateId = "customs_payment_success",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Status Change in your Supplementary Declaration",
      plainTemplate = txt.customsPaymentSuccess.f,
      htmlTemplate = html.customsPaymentSuccess.f
    ),
    MessageTemplate.create(
      templateId = "customs_declaration_success",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Status Change in your Supplementary Declaration",
      plainTemplate = txt.customsDeclarationSuccess.f,
      htmlTemplate = html.customsDeclarationSuccess.f
    ),
    MessageTemplate.create(
      templateId = "customs_pull_notifications_warning",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Customs pull notifications queue alarm - do not reply",
      plainTemplate = txt.customsPullNotificationsWarning.f,
      htmlTemplate = html.customsPullNotificationsWarning.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "customs_push_notifications_warning",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "Customs push notifications failure - do not reply",
      plainTemplate = txt.customsPushNotificationsWarning.f,
      htmlTemplate = html.customsPushNotificationsWarning.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "customs_rcm_notifications",
      fromAddress = govUkTeamAddress,
      service = Customs,
      subject = "CDS RCM Exception",
      plainTemplate = txt.customsRCMNotifications.f,
      htmlTemplate = html.customsRCMNotifications.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
