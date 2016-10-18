package uk.gov.hmrc.email.templates.rald

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.PayAsYouEarn
import uk.gov.hmrc.email.templates._
import Regime.RentalAndLeaseDetails

object RaldTemplates extends TemplateGroup with GovUkTemplate {
  val title = "RALD"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "rald_alert",
      regime = RentalAndLeaseDetails,
      subject = "Your saved Rent and Lease details expires in 90 days.",
      plainTemplate = txt.rald.apply,
      htmlTemplate = html.rald.apply,
      fromAddress = "Rent and Lease Details <noreply@tax.service.gov.uk>")
  )
}



