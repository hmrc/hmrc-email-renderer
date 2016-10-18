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

package uk.gov.hmrc.hmrcemailrenderer.templates.dfs

import uk.gov.hmrc.email.services.BodyTemplate.Subject
import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.DigitalFormsService
import uk.gov.hmrc.hmrcemailrenderer.templates.{GovUkTemplate, TemplateGroup}

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
