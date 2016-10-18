package uk.gov.hmrc.email.templates.cc

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.Childcare
import uk.gov.hmrc.email.templates.{GovUkTemplate, TemplateGroup}

object CcTemplates extends TemplateGroup with GovUkTemplate {
  val title = "CC"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "cc_registration_email",
      regime = Childcare,
      subject = "Your interest in Tax-Free Childcare",
      plainTemplate = txt.ccRegistrationEmail.apply,
      htmlTemplate = html.ccRegistrationEmail.apply,
      fromAddress = govUkTeamAddress)
  )
}
