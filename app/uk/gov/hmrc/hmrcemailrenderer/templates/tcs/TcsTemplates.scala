package uk.gov.hmrc.email.templates.tcs

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.TaxCreditsService
import uk.gov.hmrc.email.templates._

object TcsTemplates extends TemplateGroup with HmrcTemplate {
  val title = "TCS"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "tcs_renewal_confirmation",
      regime = TaxCreditsService,
      subject = "Your tax credits renewal has been received",
      plainTemplate = txt.newTcsRenewalConfirmationMessageAlert.apply,
      htmlTemplate = html.newTcsRenewalConfirmationMessageAlert.apply,
      fromAddress = taxCreditServiceTeamAddress)
  )
}
