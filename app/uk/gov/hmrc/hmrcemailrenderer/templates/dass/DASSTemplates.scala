/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.dass

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress

object DASSTemplates {

  val templates = Seq(
    //IForms Rejected
    MessageTemplate.create(
      templateId = "iforms_submission_rejection_email_non_agent",
      fromAddress = govUkTeamAddress,
      service = ServiceIdentifier.SelfAssessment,
      subject = "Action Required: HMRC Application Rejected",
      plainTemplate = sa.txt.dassIformsNonAgentSubmissionRejectedEmail.f,
      htmlTemplate = sa.html.dassIformsNonAgentSubmissionRejectedEmail.f,
      priority = None
    ),
    MessageTemplate.create(
      templateId = "iforms_submission_rejection_email_non_agent_cy",
      fromAddress = govUkTeamAddress,
      service = ServiceIdentifier.SelfAssessment,
      subject = "Camau i’w cymryd: Cais i CThEF wedi’i wrthod",
      plainTemplate = sa.txt.dassIformsNonAgentSubmissionRejectedEmail_cy.f,
      htmlTemplate = sa.html.dassIformsNonAgentSubmissionRejectedEmail_cy.f,
      priority = None
    ),
    MessageTemplate.create(
      templateId = "iforms_submission_rejection_email_agent",
      fromAddress = govUkTeamAddress,
      service = ServiceIdentifier.SelfAssessment,
      subject = "Action Required: HMRC Application Rejected",
      plainTemplate = sa.txt.dassIformsAgentSubmissionRejectedEmail.f,
      htmlTemplate = sa.html.dassIformsAgentSubmissionRejectedEmail.f,
      priority = None
    ),
    MessageTemplate.create(
      templateId = "iforms_submission_rejection_email_agent_cy",
      fromAddress = govUkTeamAddress,
      service = ServiceIdentifier.SelfAssessment,
      subject = "Camau i’w cymryd: Cais i CThEF wedi’i wrthod",
      plainTemplate = sa.txt.dassIformsAgentSubmissionRejectedEmail_cy.f,
      htmlTemplate = sa.html.dassIformsAgentSubmissionRejectedEmail_cy.f,
      priority = None
    )
  )

}
