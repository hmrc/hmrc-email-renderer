package uk.gov.hmrc.email.templates.childcarecalculator

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.Childcare
import uk.gov.hmrc.email.templates.{GovUkTemplate, TemplateGroup}

object childcareTemplates extends TemplateGroup with GovUkTemplate {
  val title = "ChildcareCalculator"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "childcare_registration_email",
      regime = Childcare,
      subject = "Registration of interest email",
      plainTemplate = txt.childcareRegistrationEmail.apply,
      htmlTemplate = html.childcareRegistrationEmail.apply,
      fromAddress = govUkTeamAddress)
  )
}
