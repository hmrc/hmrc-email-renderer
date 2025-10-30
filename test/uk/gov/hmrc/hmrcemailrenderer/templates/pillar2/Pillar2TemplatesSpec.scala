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

package uk.gov.hmrc.hmrcemailrenderer.templates.pillar2

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.CommonParamsForSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Pillar2
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress

class Pillar2TemplatesSpec extends PlaySpec with CommonParamsForSpec {

  "GIR Successful Submission Template" must {

    val successTemplate: MessageTemplate = MessageTemplate.create(
      templateId = "pillar2_gir_submission_successful",
      fromAddress = FromAddress.noReply("pillar2"),
      service = Pillar2,
      subject = "GloBE Information Return (GIR) – Successful Submission",
      plainTemplate = txt.girSubmissionSuccessful.f,
      htmlTemplate = html.girSubmissionSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    )

    val params = commonParameters ++ Map(
      "referenceId"           -> "REF123456",
      "pillar2Id"             -> "XMPLR0123456789",
      "submissionDate"        -> "01/01/2024",
      "submissionTime"        -> "14:30",
      "accountingPeriodStart" -> "01/04/2023",
      "accountingPeriodEnd"   -> "31/03/2024"
    )

    "include correct subject" in {
      successTemplate.subject(params) mustBe "GloBE Information Return (GIR) – Successful Submission"
    }

    "include htmlTemplate body with correct content" in {
      val htmlContent = successTemplate.htmlTemplate(params).toString
      htmlContent must include("GloBE Information Return")
      htmlContent must include("Reference ID: REF123456")
      htmlContent must include("Pillar 2 ID: XMPLR0123456789")
      htmlContent must include(
        "This is to confirm that HM Revenue and Customs received your GloBE Information Return on 01/01/2024 at 14:30"
      )
      htmlContent must include("for the accounting period 01/04/2023 to 31/03/2024")
      htmlContent must include("pillar2mailbox@hmrc.gov.uk")
      htmlContent must include("From the HMRC Pillar 2 team")
    }

    "include txtTemplate body with correct content" in {
      val txtContent = successTemplate.plainTemplate(params).toString
      txtContent must include("GloBE Information Return")
      txtContent must include("Reference ID: REF123456")
      txtContent must include("Pillar 2 ID: XMPLR0123456789")
      txtContent must include(
        "This is to confirm that HM Revenue and Customs received your GloBE Information Return on 01/01/2024 at 14:30"
      )
      txtContent must include("for the accounting period 01/04/2023 to 31/03/2024")
      txtContent must include("pillar2mailbox@hmrc.gov.uk")
      txtContent must include("From the HMRC Pillar 2 team")
    }
  }

  "GIR Generic Errors Template" must {

    val genericErrorsTemplate: MessageTemplate = MessageTemplate.create(
      templateId = "pillar2_gir_submission_generic_errors",
      fromAddress = FromAddress.noReply("pillar2"),
      service = Pillar2,
      subject = "GloBE Information Return (GIR) – Errors Identified. Please Re-submit",
      plainTemplate = txt.girSubmissionGenericErrors.f,
      htmlTemplate = html.girSubmissionGenericErrors.f,
      priority = Some(MessagePriority.Urgent)
    )

    val errors = Seq(
      Map(
        "errorCode"   -> "Error Code 16",
        "description" -> "The structure of the DocRefId is not in the correct format",
        "docRefIds"   -> "GB2025FRPLRX1234, FR2023GBXPLR1234",
        "count"       -> "2"
      ),
      Map(
        "errorCode" -> "Error Code 21",
        "description" -> "Where the DocTypeIndic is OECD2 or OECD3, the DocSpec element must contain a CorrDocRefId element",
        "docRefIds" -> "GB2025GB-PLRX123",
        "count"     -> "1"
      )
    )

    val paramsBase = commonParameters ++ Map(
      "referenceId"           -> "REF123456",
      "pillar2Id"             -> "XMPLR0123456789",
      "submissionDate"        -> "01/01/2024",
      "submissionTime"        -> "14:30",
      "accountingPeriodStart" -> "01/04/2023",
      "accountingPeriodEnd"   -> "31/03/2024"
    )

    val params: Map[String, Any] = paramsBase ++ Map("errors" -> errors)

    "include correct subject" in {
      genericErrorsTemplate.subject(
        paramsBase
      ) mustBe "GloBE Information Return (GIR) – Errors Identified. Please Re-submit"
    }

    "include htmlTemplate body with error table" in {
      val htmlContent = genericErrorsTemplate.htmlTemplate(params).toString
      htmlContent must include("GloBE Information Return")
      htmlContent must include("Reference ID: REF123456")
      htmlContent must include("Pillar 2 ID: XMPLR0123456789")
      htmlContent must include("However, validation of this return has identified the errors listed below")
      htmlContent must include("Please correct these errors and re-submit your return as soon as possible")
      htmlContent must include("Error Code 16")
      htmlContent must include("The structure of the DocRefId is not in the correct format")
      htmlContent must include("GB2025FRPLRX1234, FR2023GBXPLR1234")
      htmlContent must include("Error Code 21")
      htmlContent must include("From the HMRC Pillar 2 team")
    }

    "include txtTemplate body with errors" in {
      val txtContent = genericErrorsTemplate.plainTemplate(params).toString
      txtContent must include("GloBE Information Return")
      txtContent must include("Reference ID: REF123456")
      txtContent must include("However, validation of this return has identified the errors listed below")
      txtContent must include("Error Code 16")
      txtContent must include("Error Code 21")
      txtContent must include("From the HMRC Pillar 2 team")
    }
  }

  "GIR Critical Errors Template" must {

    val criticalErrorsTemplate: MessageTemplate = MessageTemplate.create(
      templateId = "pillar2_gir_submission_critical_errors",
      fromAddress = FromAddress.noReply("pillar2"),
      service = Pillar2,
      subject =
        "GloBE Information Return (GIR) – Critical Schema or Business Rule failure. Please check and re-submit.",
      plainTemplate = txt.girSubmissionCriticalErrors.f,
      htmlTemplate = html.girSubmissionCriticalErrors.f,
      priority = Some(MessagePriority.Urgent)
    )

    val errors = Seq(
      Map(
        "errorCode"        -> "Temp Pillar 2 Error Code 1",
        "businessRuleName" -> "Failed Threat Scan",
        "errorLevel"       -> "DocRefId(s)",
        "description"      -> "Submissions must not include Prohibited Characters or Entity References"
      ),
      Map(
        "errorCode"        -> "Temp Pillar 2 Error Code 2",
        "businessRuleName" -> "Failed Schema Validation",
        "errorLevel"       -> "File",
        "description"      -> "The referenced file failed validation against the GIR XML Schema"
      )
    )

    val paramsBase = commonParameters ++ Map(
      "referenceId"    -> "REF123456",
      "pillar2Id"      -> "XMPLR0123456789",
      "submissionDate" -> "01/01/2024",
      "submissionTime" -> "14:30"
    )

    val params: Map[String, Any] = paramsBase ++ Map("errors" -> errors)

    "include correct subject" in {
      criticalErrorsTemplate.subject(
        paramsBase
      ) mustBe "GloBE Information Return (GIR) – Critical Schema or Business Rule failure. Please check and re-submit."
    }

    "include htmlTemplate body with critical error details" in {
      val htmlContent = criticalErrorsTemplate.htmlTemplate(params).toString
      htmlContent must include("GloBE Information Return")
      htmlContent must include("Reference ID: REF123456")
      htmlContent must include("Pillar 2 ID: XMPLR0123456789")
      htmlContent must include("has not been processed because it failed one of the following business rules")
      htmlContent must include("50005: Failed threat scan")
      htmlContent must include("50007: Failed Schema Validation")
      htmlContent must include("50010: Test data")
      htmlContent must include("Temporary Error Code 3: Empty Elements")
      htmlContent must include("Temp Pillar 2 Error Code 1")
      htmlContent must include("Failed Threat Scan")
      htmlContent must include("Temp Pillar 2 Error Code 2")
      htmlContent must include("Failed Schema Validation")
      htmlContent must include("From the HMRC Pillar 2 team")
    }

    "include txtTemplate body with critical errors" in {
      val txtContent = criticalErrorsTemplate.plainTemplate(params).toString
      txtContent must include("GloBE Information Return")
      txtContent must include("Reference ID: REF123456")
      txtContent must include("has not been processed because it failed one of the following business rules")
      txtContent must include("50005: Failed threat scan")
      txtContent must include("Temp Pillar 2 Error Code 1")
      txtContent must include("Failed Threat Scan")
      txtContent must include("From the HMRC Pillar 2 team")
    }
  }
}
