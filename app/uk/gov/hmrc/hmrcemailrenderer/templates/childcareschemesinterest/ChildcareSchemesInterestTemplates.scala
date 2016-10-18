package uk.gov.hmrc.email.templates.childcareschemesinterest

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.Childcare
import uk.gov.hmrc.email.templates.{GovUkTemplate, TemplateGroup}

object ChildcareSchemesInterestTemplates extends TemplateGroup with GovUkTemplate {
  val title = "ChildcareSchemesInterest"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "childcare_schemes_interest_email",
      regime = Childcare,
      subject = "Your interest new childcare support schemes",
      plainTemplate = txt.csiEmailRegistration.apply,
      htmlTemplate = html.csiEmailRegistration.apply,
      fromAddress = govUkTeamAddress)
  )
}
