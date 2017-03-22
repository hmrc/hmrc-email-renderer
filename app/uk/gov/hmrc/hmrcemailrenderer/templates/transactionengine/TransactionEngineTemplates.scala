/*
 * Copyright 2017 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.transactionengine

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier

object TransactionEngineTemplates {
    val templates = Seq(
        MessageTemplate.create(
            templateId = "transactionEngineHMRCSASA100Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = "Successful Receipt of Online Submission",
            plainTemplate = sa.txt.transactionEngineHMRCSASA100Success.f,
            htmlTemplate = sa.html.transactionEngineHMRCSASA100Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.create(
            templateId = "transactionEngineHMRCSASA100Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = "Unsuccessful Self Assessment submission",
            plainTemplate = sa.txt.transactionEngineHMRCSASA100Failure.f,
            htmlTemplate = sa.html.transactionEngineHMRCSASA100Failure.f,
            priority = Some(MessagePriority.Urgent)
        ))
}
