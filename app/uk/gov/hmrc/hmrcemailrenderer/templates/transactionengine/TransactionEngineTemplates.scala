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

    private def extractSubject(params: Map[String,String]) : String = params("subject")

    val templates = Seq(
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCSASA100Success.f,
            htmlTemplate = sa.html.transactionEngineHMRCSASA100Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCSASA100Failure.f,
            htmlTemplate = sa.html.transactionEngineHMRCSASA100Failure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEASSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEASSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEASFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEASFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEASTILSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEASTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEASTILFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEASTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEPSSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEPSSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEPSFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEPSFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEPSTILSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEPSTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEPSTILFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEPSTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEYUSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEYUSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEYUFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEYUFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEYUTILSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEYUTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIEYUTILFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIEYUTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIFPSSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIFPSSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIFPSFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIFPSFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIFPSTILSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIFPSTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTIFPSTILFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTIFPSTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTINVRSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTINVRSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTINVRFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTINVRFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTINVRTILSuccess.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTINVRTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineHMRCPAYERTINVRTILFailure.f,
            htmlTemplate = sa.html.transactionEngineHMRCPAYERTINVRTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        )
    )
}
