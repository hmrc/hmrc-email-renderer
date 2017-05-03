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
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier
import uk.gov.hmrc.hmrcemailrenderer.templates.transactionengine.TransactionEngineFromAddress.transactionEngineAddress

object TransactionEngineTemplates {

    private def extractSubject(params: Map[String,String]) : String = ""

    val templates = Seq(
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100Success",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100Success.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100Failure",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100Failure.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100Failure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100ATTSuccess",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100ATTSuccess.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100ATTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100ATTFailure",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100ATTFailure.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100ATTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100ATTTILSuccess",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100ATTTILSuccess.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100ATTTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100ATTTILFailure",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100ATTTILFailure.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100ATTTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100TILSuccess",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100ATTTILSuccess.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100ATTTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100TILFailure",
            fromAddress = transactionEngineAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject,
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100ATTTILFailure.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100ATTTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        )
    )
}
