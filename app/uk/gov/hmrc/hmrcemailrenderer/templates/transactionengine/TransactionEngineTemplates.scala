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
            templateId = "transactionEngineHMRCCTCT600Success",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.CorporationTax,
            subject = extractSubject(_),
            plainTemplate = ct.txt.transactionEngineHMRCCTCT600Success.f,
            htmlTemplate = ct.html.transactionEngineHMRCCTCT600Success.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCCTCT600Failure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.CorporationTax,
            subject = extractSubject(_),
            plainTemplate = ct.txt.transactionEngineHMRCCTCT600Failure.f,
            htmlTemplate = ct.html.transactionEngineHMRCCTCT600Failure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPACCTSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.acct.txt.transactionEngineHMRCPPACCTSuccess.f,
            htmlTemplate = pp.acct.html.transactionEngineHMRCPPACCTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPACCTFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.acct.txt.transactionEngineHMRCPPACCTFailure.f,
            htmlTemplate = pp.acct.html.transactionEngineHMRCPPACCTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPAMDSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.amd.txt.transactionEngineHMRCPPAMDSuccess.f,
            htmlTemplate = pp.amd.html.transactionEngineHMRCPPAMDSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPAMDFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.amd.txt.transactionEngineHMRCPPAMDFailure.f,
            htmlTemplate = pp.amd.html.transactionEngineHMRCPPAMDFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPEVNTSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.evnt.txt.transactionEngineHMRCPPEVNTSuccess.f,
            htmlTemplate = pp.evnt.html.transactionEngineHMRCPPEVNTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPEVNTFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.evnt.txt.transactionEngineHMRCPPEVNTFailure.f,
            htmlTemplate = pp.evnt.html.transactionEngineHMRCPPEVNTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPMAINTSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.maint.txt.transactionEngineHMRCPPMAINTSuccess.f,
            htmlTemplate = pp.maint.html.transactionEngineHMRCPPMAINTSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPMAINTFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.maint.txt.transactionEngineHMRCPPMAINTFailure.f,
            htmlTemplate = pp.maint.html.transactionEngineHMRCPPMAINTFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPPRACSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.prac.txt.transactionEngineHMRCPPPRACSuccess.f,
            htmlTemplate = pp.prac.html.transactionEngineHMRCPPPRACSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPPRACFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.prac.txt.transactionEngineHMRCPPPRACFailure.f,
            htmlTemplate = pp.prac.html.transactionEngineHMRCPPPRACFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPRASSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.ras.txt.transactionEngineHMRCPPRASSuccess.f,
            htmlTemplate = pp.ras.html.transactionEngineHMRCPPRASSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPRASFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.ras.txt.transactionEngineHMRCPPRASFailure.f,
            htmlTemplate = pp.ras.html.transactionEngineHMRCPPRASFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPRETSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.ret.txt.transactionEngineHMRCPPRETSuccess.f,
            htmlTemplate = pp.ret.html.transactionEngineHMRCPPRETSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineHMRCPPRETFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.PensionSchemesforPractitioners,
            subject = extractSubject(_),
            plainTemplate = pp.ret.txt.transactionEngineHMRCPPRETFailure.f,
            htmlTemplate = pp.ret.html.transactionEngineHMRCPPRETFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineCHARCLMSuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.Charities,
            subject = extractSubject(_),
            plainTemplate = charities.clm.txt.transactionEngineCHARCLMSuccess.f,
            htmlTemplate = charities.clm.html.transactionEngineCHARCLMSuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineCHARCLMFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.Charities,
            subject = extractSubject(_),
            plainTemplate = charities.clm.txt.transactionEngineCHARCLMFailure.f,
            htmlTemplate = charities.clm.html.transactionEngineCHARCLMFailure.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineCHARCLMMULTISuccess",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.Charities,
            subject = extractSubject(_),
            plainTemplate = charities.clm.txt.transactionEngineCHARCLMMULTISuccess.f,
            htmlTemplate = charities.clm.html.transactionEngineCHARCLMMULTISuccess.f,
            priority = Some(MessagePriority.Urgent)
        ),
        MessageTemplate.createWithDynamicSubject(
            templateId = "transactionEngineCHARCLMMULTIFailure",
            fromAddress = govUkTeamAddress,
            service = ServiceIdentifier.Charities,
            subject = extractSubject(_),
            plainTemplate = charities.clm.txt.transactionEngineCHARCLMMULTIFailure.f,
            htmlTemplate = charities.clm.html.transactionEngineCHARCLMMULTIFailure.f,
            priority = Some(MessagePriority.Urgent)
        )
    )
}
