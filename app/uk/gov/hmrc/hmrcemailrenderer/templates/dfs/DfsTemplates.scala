package uk.gov.hmrc.email.templates.dfs

import uk.gov.hmrc.email.services.BodyTemplate.Subject
import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.DigitalFormsService
import uk.gov.hmrc.email.templates.{GovUkTemplate, TemplateGroup}

object DfsTemplates extends TemplateGroup with GovUkTemplate {
   val title = "DFS"

   def subGroups = Seq(
    SimpleMessageTemplate(
      id = "dfs_submission_success_r39_2015",
      regime = DigitalFormsService,
      subject = "R39: Claim a Tax Refund submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmail.apply,
      htmlTemplate = html.dfsSubmissionConfirmationEmail.apply,
      fromAddress = govUkTeamAddress),
      SimpleMessageTemplate(
      id = "dfs_submission_success_cis_2015",
      regime = DigitalFormsService,
      subject = "Subcontractor registration submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailCIS.apply,
      htmlTemplate = html.dfsSubmissionConfirmationEmailCIS.apply,
      fromAddress = govUkTeamAddress),
     SimpleMessageTemplate(
       id = "dfs_submission_success_sptu_2015",
       regime = DigitalFormsService,
       subject = "State Pension top up (Class3A) submission confirmation",
       plainTemplate = txt.dfsSubmissionConfirmationEmailSPTU.apply,
       htmlTemplate = html.dfsSubmissionConfirmationEmailSPTU.apply,
       fromAddress = govUkTeamAddress),
     SimpleMessageTemplate(
       id = "dfs_submission_success_generic_2015",
       regime = DigitalFormsService,
       subject = Subject(p => s"${p("subject")}" ),
       plainTemplate = txt.dfsSubmissionConfirmationEmailGeneric.apply,
       htmlTemplate = html.dfsSubmissionConfirmationEmailGeneric.apply,
       fromAddress = govUkTeamAddress),
     SimpleMessageTemplate(
       id = "dfs_submission_success_empty_turn_around_time_2015",
       regime = DigitalFormsService,
       subject = Subject(p => s"${p("subject")}" ),
       plainTemplate = txt.dfsSubmissionConfirmationEmailEmptyTurnAroundTime.apply,
       htmlTemplate = html.dfsSubmissionConfirmationEmailEmptyTurnAroundTime.apply,
       fromAddress = govUkTeamAddress)
  )
}
