package uk.gov.hmrc.email.templates.paye

import uk.gov.hmrc.email.services.{BodyTemplate, SimpleMessageTemplate}
import uk.gov.hmrc.email.templates.Regime.PayAsYouEarn
import uk.gov.hmrc.email.templates._

object PayeTemplates extends TemplateGroup with GovUkTemplate {
  val title = "PAYE"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "tax_estimate_message_alert",
      regime = PayAsYouEarn,
      subject = "Your Income Tax estimate has changed",
      plainTemplate = txt.newTaxEstimateMessageAlert.apply,
      htmlTemplate = html.newTaxEstimateMessageAlert.apply,
      fromAddress = " HMRC Check your Income Tax service <noreply@tax.service.gov.uk>")
  )
}
