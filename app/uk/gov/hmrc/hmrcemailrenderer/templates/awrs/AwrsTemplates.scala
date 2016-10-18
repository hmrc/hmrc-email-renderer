package uk.gov.hmrc.email.templates.awrs

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.AlcoholWholesalerRegistrationScheme
import uk.gov.hmrc.email.templates.{GovUkTemplate, TemplateGroup}

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
