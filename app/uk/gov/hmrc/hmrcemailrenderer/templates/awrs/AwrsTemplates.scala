/*
 * Copyright 2016 HM Revenue & Customs
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

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.AlcoholWholesalerRegistrationScheme
import uk.gov.hmrc.hmrcemailrenderer.templates.{GovUkTemplate, TemplateGroup}

object AwrsTemplates extends TemplateGroup with GovUkTemplate {
  val title = "AWRS"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "awrs_notification_template_reg_change",
      regime = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS registration change",
      plainTemplate = txt.awrsNotificationEmailRegChange.apply,
      htmlTemplate = html.awrsNotificationEmailRegChange.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "awrs_notification_template_app_change",
      regime = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS application change",
      plainTemplate = txt.awrsNotificationEmailAppChange.apply,
      htmlTemplate = html.awrsNotificationEmailAppChange.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "awrs_notification_template_comfirmation_api4",
      regime = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS application confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI4.apply,
      htmlTemplate = html.awrsNotificationConfirmationAPI4.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "awrs_notification_template_comfirmation_api6",
      regime = AlcoholWholesalerRegistrationScheme,
      subject = "AWRS amendment confirmation",
      plainTemplate = txt.awrsNotificationConfirmationAPI6.apply,
      htmlTemplate = html.awrsNotificationConfirmationAPI6.apply,
      fromAddress = govUkTeamAddress)
  )
}
