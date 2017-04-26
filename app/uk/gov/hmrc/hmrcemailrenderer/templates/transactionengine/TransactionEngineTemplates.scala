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
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAACTSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRAACTSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRAACTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAACTFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRAACTFailure.f,
            htmlTemplate = sa.html.transactionEngineIRAACTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAAPAYESuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRAAPAYESuccess.f,
            htmlTemplate = sa.html.transactionEngineIRAAPAYESuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAAPAYEFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRAAPAYEFailure.f,
            htmlTemplate = sa.html.transactionEngineIRAAPAYEFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAASASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRAASASuccess.f,
            htmlTemplate = sa.html.transactionEngineIRAASASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAASAFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRAASAFailure.f,
            htmlTemplate = sa.html.transactionEngineIRAASAFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISCIS300MRSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRCISCIS300MRSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRCISCIS300MRSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISCIS300MRFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRCISCIS300MRFailure.f,
            htmlTemplate = sa.html.transactionEngineIRCISCIS300MRFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISVERIFYSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRCISVERIFYSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRCISVERIFYSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISVERIFYFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRCISVERIFYFailure.f,
            htmlTemplate = sa.html.transactionEngineIRCISVERIFYFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCTFANNUALRETURNSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRCTFANNUALRETURNSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRCTFANNUALRETURNSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCTFANNUALRETURNFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRCTFANNUALRETURNFailure.f,
            htmlTemplate = sa.html.transactionEngineIRCTFANNUALRETURNFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEOYSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEOYSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEOYFailure.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEOYFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEOYTILSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEOYTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEOYTILFailure.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEOYTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEXBSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEXBSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEXBSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEXBFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEXBFailure.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEXBFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEMOVSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEMOVSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEMOVFailure.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEMOVFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEMOVTILSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEMOVTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEMOVTILFailure.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEMOVTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEP38ASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEP38ASuccess.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEP38ASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEP38AFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEEP38AFailure.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEEP38AFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEUPDATESuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEUPDATESuccess.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEUPDATESuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEUPDATEFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRPAYEUPDATEFailure.f,
            htmlTemplate = sa.html.transactionEngineIRPAYEUPDATEFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRSDLTLTRSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRSDLTLTRSuccess.f,
            htmlTemplate = sa.html.transactionEngineIRSDLTLTRSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRSDLTLTRFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineIRSDLTLTRFailure.f,
            htmlTemplate = sa.html.transactionEngineIRSDLTLTRFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAACCTTAXSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAACCTTAXSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAACCTTAXSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAACCTTAXFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAACCTTAXFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAACCTTAXFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAADDSCHASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAADDSCHASuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAADDSCHASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAADDSCHAFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAADDSCHAFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAADDSCHAFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAAMDDETSSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAAMDDETSSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAAMDDETSSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAAMDDETSFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAAMDDETSFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAAMDDETSFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAASSCSASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAASSCSASuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAASSCSASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAASSCSAFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAASSCSAFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAASSCSAFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSACOMBINEDREGSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSACOMBINEDREGSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSACOMBINEDREGSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSACOMBINEDREGFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSACOMBINEDREGFailure.f,
            htmlTemplate = sa.html.transactionEnginePSACOMBINEDREGFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAEVNTREPSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAEVNTREPSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAEVNTREPSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAEVNTREPFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAEVNTREPFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAEVNTREPFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAMAINTSCMSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAMAINTSCMSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAMAINTSCMSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAMAINTSCMFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAMAINTSCMFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAMAINTSCMFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAPRACAUTHSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAPRACAUTHSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAPRACAUTHSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAPRACAUTHFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAPRACAUTHFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAPRACAUTHFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAPRACDEAUTHSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAPRACDEAUTHSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAPRACDEAUTHSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAPRACDEAUTHFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAPRACDEAUTHFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAPRACDEAUTHFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSARASSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSARASSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSARASSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSARASFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSARASFailure.f,
            htmlTemplate = sa.html.transactionEnginePSARASFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAREGSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAREGSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSAREGSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSAREGFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSAREGFailure.f,
            htmlTemplate = sa.html.transactionEnginePSAREGFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSARETSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSARETSuccess.f,
            htmlTemplate = sa.html.transactionEnginePSARETSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEnginePSARETFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEnginePSARETFailure.f,
            htmlTemplate = sa.html.transactionEnginePSARETFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineECSLORGV101Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineECSLORGV101Success.f,
            htmlTemplate = sa.html.transactionEngineECSLORGV101Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineECSLORGV101Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.txt.transactionEngineECSLORGV101Failure.f,
            htmlTemplate = sa.html.transactionEngineECSLORGV101Failure.f,
            priority = Some(MessagePriority.Urgent)
        )
    )
}
