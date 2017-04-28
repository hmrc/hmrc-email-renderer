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

    private def extractSubject(params: Map[String,String]) : String = params.getOrElse("subject","")

    val templates = Seq(
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100Success.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA100Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa100.txt.transactionEngineHMRCSASA100Failure.f,
            htmlTemplate = sa.sa100.html.transactionEngineHMRCSASA100Failure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerAlignmentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eas.txt.transactionEngineHMRCPAYERTIEASSuccess.f,
            htmlTemplate = paye.rti.eas.html.transactionEngineHMRCPAYERTIEASSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerAlignmentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eas.txt.transactionEngineHMRCPAYERTIEASFailure.f,
            htmlTemplate = paye.rti.eas.html.transactionEngineHMRCPAYERTIEASFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerAlignmentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eas.txt.transactionEngineHMRCPAYERTIEASTILSuccess.f,
            htmlTemplate = paye.rti.eas.html.transactionEngineHMRCPAYERTIEASTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEASTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerAlignmentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eas.txt.transactionEngineHMRCPAYERTIEASTILFailure.f,
            htmlTemplate = paye.rti.eas.html.transactionEngineHMRCPAYERTIEASTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerPaymentSummarySubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eps.txt.transactionEngineHMRCPAYERTIEPSSuccess.f,
            htmlTemplate = paye.rti.eps.html.transactionEngineHMRCPAYERTIEPSSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerPaymentSummarySubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eps.txt.transactionEngineHMRCPAYERTIEPSFailure.f,
            htmlTemplate = paye.rti.eps.html.transactionEngineHMRCPAYERTIEPSFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerPaymentSummarySubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eps.txt.transactionEngineHMRCPAYERTIEPSTILSuccess.f,
            htmlTemplate = paye.rti.eps.html.transactionEngineHMRCPAYERTIEPSTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEPSTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EmployerPaymentSummarySubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eps.txt.transactionEngineHMRCPAYERTIEPSTILFailure.f,
            htmlTemplate = paye.rti.eps.html.transactionEngineHMRCPAYERTIEPSTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EarlierYearUpdateSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eyu.txt.transactionEngineHMRCPAYERTIEYUSuccess.f,
            htmlTemplate = paye.rti.eyu.html.transactionEngineHMRCPAYERTIEYUSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EarlierYearUpdateSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eyu.txt.transactionEngineHMRCPAYERTIEYUFailure.f,
            htmlTemplate = paye.rti.eyu.html.transactionEngineHMRCPAYERTIEYUFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EarlierYearUpdateSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eyu.txt.transactionEngineHMRCPAYERTIEYUTILSuccess.f,
            htmlTemplate = paye.rti.eyu.html.transactionEngineHMRCPAYERTIEYUTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIEYUTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.EarlierYearUpdateSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.eyu.txt.transactionEngineHMRCPAYERTIEYUTILFailure.f,
            htmlTemplate = paye.rti.eyu.html.transactionEngineHMRCPAYERTIEYUTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.FullPaymentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.fps.txt.transactionEngineHMRCPAYERTIFPSSuccess.f,
            htmlTemplate = paye.rti.fps.html.transactionEngineHMRCPAYERTIFPSSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.FullPaymentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.fps.txt.transactionEngineHMRCPAYERTIFPSFailure.f,
            htmlTemplate = paye.rti.fps.html.transactionEngineHMRCPAYERTIFPSFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.FullPaymentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.fps.txt.transactionEngineHMRCPAYERTIFPSTILSuccess.f,
            htmlTemplate = paye.rti.fps.html.transactionEngineHMRCPAYERTIFPSTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTIFPSTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.FullPaymentSubmission,
            subject = extractSubject(_),
            plainTemplate = paye.rti.fps.txt.transactionEngineHMRCPAYERTIFPSTILFailure.f,
            htmlTemplate = paye.rti.fps.html.transactionEngineHMRCPAYERTIFPSTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.NINOVerificationRequest,
            subject = extractSubject(_),
            plainTemplate = paye.rti.nvr.txt.transactionEngineHMRCPAYERTINVRSuccess.f,
            htmlTemplate = paye.rti.nvr.html.transactionEngineHMRCPAYERTINVRSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.NINOVerificationRequest,
            subject = extractSubject(_),
            plainTemplate = paye.rti.nvr.txt.transactionEngineHMRCPAYERTINVRFailure.f,
            htmlTemplate = paye.rti.nvr.html.transactionEngineHMRCPAYERTINVRFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.NINOVerificationRequest,
            subject = extractSubject(_),
            plainTemplate = paye.rti.nvr.txt.transactionEngineHMRCPAYERTINVRTILSuccess.f,
            htmlTemplate = paye.rti.nvr.html.transactionEngineHMRCPAYERTINVRTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPAYERTINVRTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.NINOVerificationRequest,
            subject = extractSubject(_),
            plainTemplate = paye.rti.nvr.txt.transactionEngineHMRCPAYERTINVRTILFailure.f,
            htmlTemplate = paye.rti.nvr.html.transactionEngineHMRCPAYERTINVRTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAACTSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ChildTrustFund,
            subject = extractSubject(_),
            plainTemplate = ir.aa.txt.transactionEngineIRAACTSuccess.f,
            htmlTemplate = ir.aa.html.transactionEngineIRAACTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAACTFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ChildTrustFund,
            subject = extractSubject(_),
            plainTemplate = ir.aa.txt.transactionEngineIRAACTFailure.f,
            htmlTemplate = ir.aa.html.transactionEngineIRAACTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAAPAYESuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AgentAuthorisation,
            subject = extractSubject(_),
            plainTemplate = ir.aa.txt.transactionEngineIRAAPAYESuccess.f,
            htmlTemplate = ir.aa.html.transactionEngineIRAAPAYESuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAAPAYEFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AgentAuthorisation,
            subject = extractSubject(_),
            plainTemplate = ir.aa.txt.transactionEngineIRAAPAYEFailure.f,
            htmlTemplate = ir.aa.html.transactionEngineIRAAPAYEFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAASASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AgentAuthorisation,
            subject = extractSubject(_),
            plainTemplate = ir.aa.txt.transactionEngineIRAASASuccess.f,
            htmlTemplate = ir.aa.html.transactionEngineIRAASASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRAASAFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AgentAuthorisation,
            subject = extractSubject(_),
            plainTemplate = ir.aa.txt.transactionEngineIRAASAFailure.f,
            htmlTemplate = ir.aa.html.transactionEngineIRAASAFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISCIS300MRSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ConstructionIndustryScheme,
            subject = extractSubject(_),
            plainTemplate = ir.cis.txt.transactionEngineIRCISCIS300MRSuccess.f,
            htmlTemplate = ir.cis.html.transactionEngineIRCISCIS300MRSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISCIS300MRFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ConstructionIndustryScheme,
            subject = extractSubject(_),
            plainTemplate = ir.cis.txt.transactionEngineIRCISCIS300MRFailure.f,
            htmlTemplate = ir.cis.html.transactionEngineIRCISCIS300MRFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISVERIFYSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ConstructionIndustryScheme,
            subject = extractSubject(_),
            plainTemplate = ir.cis.txt.transactionEngineIRCISVERIFYSuccess.f,
            htmlTemplate = ir.cis.html.transactionEngineIRCISVERIFYSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCISVERIFYFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ConstructionIndustryScheme,
            subject = extractSubject(_),
            plainTemplate = ir.cis.txt.transactionEngineIRCISVERIFYFailure.f,
            htmlTemplate = ir.cis.html.transactionEngineIRCISVERIFYFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCTFANNUALRETURNSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.ctf.txt.transactionEngineIRCTFANNUALRETURNSuccess.f,
            htmlTemplate = ir.ctf.html.transactionEngineIRCTFANNUALRETURNSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRCTFANNUALRETURNFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.ctf.txt.transactionEngineIRCTFANNUALRETURNFailure.f,
            htmlTemplate = ir.ctf.html.transactionEngineIRCTFANNUALRETURNFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEEOYSuccess.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEEOYSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEEOYFailure.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEEOYFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEEOYTILSuccess.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEEOYTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEOYTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEEOYTILFailure.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEEOYTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEXBSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEEXBSuccess.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEEXBSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEEXBFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEEXBFailure.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEEXBFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEMOVSuccess.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEMOVSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEMOVFailure.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEMOVFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEMOVTILSuccess.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEMOVTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEMOVTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEMOVTILFailure.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEMOVTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEP38ASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEP38ASuccess.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEP38ASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEP38AFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEP38AFailure.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEP38AFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEUPDATESuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEUPDATESuccess.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEUPDATESuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRPAYEUPDATEFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = ir.paye.txt.transactionEngineIRPAYEUPDATEFailure.f,
            htmlTemplate = ir.paye.html.transactionEngineIRPAYEUPDATEFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRSDLTLTRSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.StampDutyLandTaxOnlineForOrganisations,
            subject = extractSubject(_),
            plainTemplate = ir.sdlt.txt.transactionEngineIRSDLTLTRSuccess.f,
            htmlTemplate = ir.sdlt.html.transactionEngineIRSDLTLTRSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineIRSDLTLTRFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.StampDutyLandTaxOnlineForOrganisations,
            subject = extractSubject(_),
            plainTemplate = ir.sdlt.txt.transactionEngineIRSDLTLTRFailure.f,
            htmlTemplate = ir.sdlt.html.transactionEngineIRSDLTLTRFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAACCTTAXSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AccountingForTax,
            subject = extractSubject(_),
            plainTemplate = psa.act.txt.transactionEngineHMRCPSAACCTTAXSuccess.f,
            htmlTemplate = psa.act.html.transactionEngineHMRCPSAACCTTAXSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAACCTTAXFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AccountingForTax,
            subject = extractSubject(_),
            plainTemplate = psa.act.txt.transactionEngineHMRCPSAACCTTAXFailure.f,
            htmlTemplate = psa.act.html.transactionEngineHMRCPSAACCTTAXFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAADDSCHASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AddSchemeAdministrator,
            subject = extractSubject(_),
            plainTemplate = psa.add.txt.transactionEngineHMRCPSAADDSCHASuccess.f,
            htmlTemplate = psa.add.html.transactionEngineHMRCPSAADDSCHASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAADDSCHAFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AddSchemeAdministrator,
            subject = extractSubject(_),
            plainTemplate = psa.add.txt.transactionEngineHMRCPSAADDSCHAFailure.f,
            htmlTemplate = psa.add.html.transactionEngineHMRCPSAADDSCHAFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAAMDDETSSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeAmendment,
            subject = extractSubject(_),
            plainTemplate = psa.amd.txt.transactionEngineHMRCPSAAMDDETSSuccess.f,
            htmlTemplate = psa.amd.html.transactionEngineHMRCPSAAMDDETSSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAAMDDETSFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeAmendment,
            subject = extractSubject(_),
            plainTemplate = psa.amd.txt.transactionEngineHMRCPSAAMDDETSFailure.f,
            htmlTemplate = psa.amd.html.transactionEngineHMRCPSAAMDDETSFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAASSCSASuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeAssociation,
            subject = extractSubject(_),
            plainTemplate = psa.ass.txt.transactionEngineHMRCPSAASSCSASuccess.f,
            htmlTemplate = psa.ass.html.transactionEngineHMRCPSAASSCSASuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAASSCSAFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeAssociation,
            subject = extractSubject(_),
            plainTemplate = psa.ass.txt.transactionEngineHMRCPSAASSCSAFailure.f,
            htmlTemplate = psa.ass.html.transactionEngineHMRCPSAASSCSAFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSACOMBINEDREGSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.CombinedRegistration,
            subject = extractSubject(_),
            plainTemplate = psa.combined.txt.transactionEngineHMRCPSACOMBINEDREGSuccess.f,
            htmlTemplate = psa.combined.html.transactionEngineHMRCPSACOMBINEDREGSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSACOMBINEDREGFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.CombinedRegistration,
            subject = extractSubject(_),
            plainTemplate = psa.combined.txt.transactionEngineHMRCPSACOMBINEDREGFailure.f,
            htmlTemplate = psa.combined.html.transactionEngineHMRCPSACOMBINEDREGFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAEVNTREPSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeEvent,
            subject = extractSubject(_),
            plainTemplate = psa.evnt.txt.transactionEngineHMRCPSAEVNTREPSuccess.f,
            htmlTemplate = psa.evnt.html.transactionEngineHMRCPSAEVNTREPSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAEVNTREPFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeEvent,
            subject = extractSubject(_),
            plainTemplate = psa.evnt.txt.transactionEngineHMRCPSAEVNTREPFailure.f,
            htmlTemplate = psa.evnt.html.transactionEngineHMRCPSAEVNTREPFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAMAINTSCMSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AmendSchemeDetails,
            subject = extractSubject(_),
            plainTemplate = psa.maint.txt.transactionEngineHMRCPSAMAINTSCMSuccess.f,
            htmlTemplate = psa.maint.html.transactionEngineHMRCPSAMAINTSCMSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAMAINTSCMFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.AmendSchemeDetails,
            subject = extractSubject(_),
            plainTemplate = psa.maint.txt.transactionEngineHMRCPSAMAINTSCMFailure.f,
            htmlTemplate = psa.maint.html.transactionEngineHMRCPSAMAINTSCMFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSARASSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ProvideReliefAtSourceRepaymentDetails,
            subject = extractSubject(_),
            plainTemplate = psa.ras.txt.transactionEngineHMRCPSARASSuccess.f,
            htmlTemplate = psa.ras.html.transactionEngineHMRCPSARASSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSARASFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.ProvideReliefAtSourceRepaymentDetails,
            subject = extractSubject(_),
            plainTemplate = psa.ras.txt.transactionEngineHMRCPSARASFailure.f,
            htmlTemplate = psa.ras.html.transactionEngineHMRCPSARASFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAREGSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeRegistration,
            subject = extractSubject(_),
            plainTemplate = psa.reg.txt.transactionEngineHMRCPSAREGSuccess.f,
            htmlTemplate = psa.reg.html.transactionEngineHMRCPSAREGSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSAREGFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeRegistration,
            subject = extractSubject(_),
            plainTemplate = psa.reg.txt.transactionEngineHMRCPSAREGFailure.f,
            htmlTemplate = psa.reg.html.transactionEngineHMRCPSAREGFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSARETSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeReturn,
            subject = extractSubject(_),
            plainTemplate = psa.ret.txt.transactionEngineHMRCPSARETSuccess.f,
            htmlTemplate = psa.ret.html.transactionEngineHMRCPSARETSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPSARETFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemeReturn,
            subject = extractSubject(_),
            plainTemplate = psa.ret.txt.transactionEngineHMRCPSARETFailure.f,
            htmlTemplate = psa.ret.html.transactionEngineHMRCPSARETFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineECSLORGV101Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.VATECSalesList,
            subject = extractSubject(_),
            plainTemplate = ecsl.txt.transactionEngineECSLORGV101Success.f,
            htmlTemplate = ecsl.html.transactionEngineECSLORGV101Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineECSLORGV101Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.VATECSalesList,
            subject = extractSubject(_),
            plainTemplate = ecsl.txt.transactionEngineECSLORGV101Failure.f,
            htmlTemplate = ecsl.html.transactionEngineECSLORGV101Failure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800Success.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800Failure.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800Failure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800ATTSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800ATTSuccess.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800ATTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800ATTFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800ATTFailure.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800ATTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800ATTTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800ATTTILSuccess.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800ATTTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800ATTTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800ATTTILFailure.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800ATTTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800TILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800TILSuccess.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800TILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA800TILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa800.txt.transactionEngineHMRCSASA800TILFailure.f,
            htmlTemplate = sa.sa800.html.transactionEngineHMRCSASA800TILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900Success.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900Failure.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900Failure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900ATTSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900ATTSuccess.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900ATTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900ATTFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900ATTFailure.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900ATTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900ATTTILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900ATTTILSuccess.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900ATTTILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900ATTTILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900ATTTILFailure.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900ATTTILFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900TILSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900TILSuccess.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900TILSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCSASA900TILFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.SelfAssessment,
            subject = extractSubject(_),
            plainTemplate = sa.sa900.txt.transactionEngineHMRCSASA900TILFailure.f,
            htmlTemplate = sa.sa900.html.transactionEngineHMRCSASA900TILFailure.f,
            priority = Some(MessagePriority.Urgent)
        )
//       ,MessageTemplate.createWithDynamicSubject(
//        templateId = "transactionEngineHMRCPSAPRACAUTHSuccess",
//        fromAddress = govUkTeamAddress,
//        service = ServiceIdentifier.SelfAssessment,
//        subject = extractSubject(_),
//        plainTemplate = psa.prac.txt.transactionEngineHMRCPSAPRACAUTHSuccess.f,
//        htmlTemplate = psa.prac.html.transactionEngineHMRCPSAPRACAUTHSuccess.f,
//        priority = Some(MessagePriority.Urgent)
//    ),
//    MessageTemplate.createWithDynamicSubject(
//        templateId = "transactionEngineHMRCPSAPRACAUTHFailure",
//        fromAddress = govUkTeamAddress,
//        service = ServiceIdentifier.SelfAssessment,
//        subject = extractSubject(_),
//        plainTemplate = psa.prac.txt.transactionEngineHMRCPSAPRACAUTHFailure.f,
//        htmlTemplate = psa.prac.html.transactionEngineHMRCPSAPRACAUTHFailure.f,
//        priority = Some(MessagePriority.Urgent)
//    ),
//    MessageTemplate.createWithDynamicSubject(
//        templateId = "transactionEngineHMRCPSAPRACDEAUTHSuccess",
//        fromAddress = govUkTeamAddress,
//        service = ServiceIdentifier.SelfAssessment,
//        subject = extractSubject(_),
//        plainTemplate = psa.prac.txt.transactionEngineHMRCPSAPRACDEAUTHSuccess.f,
//        htmlTemplate = psa.prac.html.transactionEngineHMRCPSAPRACDEAUTHSuccess.f,
//        priority = Some(MessagePriority.Urgent)
//    ),
//    MessageTemplate.createWithDynamicSubject(
//        templateId = "transactionEngineHMRCPSAPRACDEAUTHFailure",
//        fromAddress = govUkTeamAddress,
//        service = ServiceIdentifier.SelfAssessment,
//        subject = extractSubject(_),
//        plainTemplate = psa.prac.txt.transactionEngineHMRCPSAPRACDEAUTHFailure.f,
//        htmlTemplate = psa.prac.html.transactionEngineHMRCPSAPRACDEAUTHFailure.f,
//        priority = Some(MessagePriority.Urgent)
//    )
    )
}
