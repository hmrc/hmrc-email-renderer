package uk.gov.hmrc.email.templates.passcode

import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime._
import uk.gov.hmrc.email.templates.{GovUkTemplate, TemplateGroup, passcode}

object PasscodesTemplates extends TemplateGroup with GovUkTemplate {
  val title = "Passcodes"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "generic_access_invitation_template_id",
      regime = Generic,
      subject = "Your HMRC service test link",
      plainTemplate = passcode.txt.genericVerificationEmail.apply,
      htmlTemplate = passcode.html.genericVerificationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "cato_access_invitation_template_id",
      regime = CompanyAccountsTaxOnline,
      subject = "A new method of filing your Accounts and Company Tax Return",
      plainTemplate = passcode.txt.catoVerificationEmail.apply,
      htmlTemplate = passcode.html.catoVerificationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "agents_access_invitation_template_id",
      regime = Agent,
      subject = "Invite: Test and view your clients’ PAYE for employers accounts",
      plainTemplate = passcode.txt.agentVerificationEmail.apply,
      htmlTemplate = passcode.html.agentVerificationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "agents_opt_in_exclude_template_id",
      regime = AgentOptInExclude,
      subject = "Switch back from Agent Services to the original HMRC online services",
      plainTemplate = passcode.txt.agentOptInExcludeEmail.apply,
      htmlTemplate = passcode.html.agentOptInExcludeEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "agents_opt_in_rejoin_template_id",
      regime = AgentOptInRejoin,
      subject = "Rejoin the new Agent Services from HMRC",
      plainTemplate = passcode.txt.agentOptInRejoinEmail.apply,
      htmlTemplate = passcode.html.agentOptInRejoinEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_access_invitation_template_id",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your HMRC Marriage Allowance link",
      plainTemplate = passcode.txt.tamcVerificationEmail.apply,
      htmlTemplate = passcode.html.tamcVerificationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "iht_access_invitation_template_id",
      regime = InheritanceTax,
      subject = "How to access HMRC’s Inheritance Tax Online service",
      plainTemplate = passcode.txt.ihtVerificationEmail.apply,
      htmlTemplate = passcode.html.ihtVerificationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "gmp_access_invitation_template_id",
      regime = GuaranteedMinimumPension,
      subject = "Your check a GMP link",
      plainTemplate = passcode.txt.gmpVerificationEmail.apply,
      htmlTemplate = passcode.html.gmpVerificationEmail.apply,
      fromAddress = govUkTeamAddress)
  )
}
