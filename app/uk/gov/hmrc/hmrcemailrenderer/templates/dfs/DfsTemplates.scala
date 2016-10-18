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

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DigitalFormsService

object DfsTemplates {

   val template = Seq(
    MessageTemplate.create(
      templateId = "dfs_submission_success_r39_2015",
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "R39: Claim a Tax Refund submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmail.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmail.f),
     MessageTemplate.create(
      templateId = "dfs_submission_success_cis_2015", 
      fromAddress = govUkTeamAddress,
      service = DigitalFormsService,
      subject = "Subcontractor registration submission confirmation",
      plainTemplate = txt.dfsSubmissionConfirmationEmailCIS.f,
      htmlTemplate = html.dfsSubmissionConfirmationEmailCIS.f),
     MessageTemplate.create(
       templateId = "dfs_submission_success_sptu_2015",
       fromAddress = govUkTeamAddress,
       service = DigitalFormsService,
       subject = "State Pension top up (Class3A) submission confirmation",
       plainTemplate = txt.dfsSubmissionConfirmationEmailSPTU.f,
       htmlTemplate = html.dfsSubmissionConfirmationEmailSPTU.f),
     MessageTemplate.create(
       templateId = "dfs_submission_success_generic_2015",
       fromAddress = govUkTeamAddress,
       service = DigitalFormsService,
       subject = _.apply("subject"),
       plainTemplate = txt.dfsSubmissionConfirmationEmailGeneric.f,
       htmlTemplate = html.dfsSubmissionConfirmationEmailGeneric.f),
     MessageTemplate.create(
       templateId = "dfs_submission_success_empty_turn_around_time_2015",
       fromAddress = govUkTeamAddress,
       service = DigitalFormsService,
       subject = _.apply("subject"),
       plainTemplate = txt.dfsSubmissionConfirmationEmailEmptyTurnAroundTime.f,
       htmlTemplate = html.dfsSubmissionConfirmationEmailEmptyTurnAroundTime.f)
  )
}
