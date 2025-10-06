/*
 * Copyright 2025 HM Revenue & Customs
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

class Pillar2TemplatesSpec extends PlaySpec with CommonParamsForSpec {

  "pillar2_confirmation_email" must {

    val template: MessageTemplate = MessageTemplate.create(
      templateId = "pillar2_confirmation_email",
      fromAddress = "HMRC@tax.service.gov.uk",
      service = Pillar2,
      subject = "Confirmation of Pillar 2 submission",
      plainTemplate = txt.pillar2ConfirmationEmail.f,
      htmlTemplate = html.pillar2ConfirmationEmail.f,
      priority = Some(MessagePriority.Standard)
    )

    val defaultTemplateParams: Map[String, String] = commonParameters ++ Map(
      "confirmationDate"      -> "3 October 2025",
      "confirmationTime"      -> "2:45pm",
      "requestType"           -> "UK Tax Return",
      "accountingPeriodStart" -> "1 April 2024",
      "accountingPeriodEnd"   -> "31 March 2025"
    )

    val btnTemplateParams: Map[String, String] = commonParameters ++ Map(
      "confirmationDate"      -> "25 October 2024",
      "confirmationTime"      -> "10:30am",
      "requestType"           -> "Below Threshold Notification",
      "accountingPeriodStart" -> "10 October 2024",
      "accountingPeriodEnd"   -> "9 October 2025"
    )

    "include correct subject" in {
      template.subject(defaultTemplateParams) mustBe "Confirmation of Pillar 2 submission"
    }

    "include default content for non-BTN request types" in {
      val htmlContent = template
        .htmlTemplate(defaultTemplateParams)
        .toString
      htmlContent must include("Multinational Top-up Tax/Domestic Top-up Tax")
      htmlContent must include("Dear Customer")
      htmlContent must include(
        "This is confirmation that on 3 October 2025 at 2:45pm HM Revenue & Customs received your Pillar 2 UK Tax Return for the Accounting Period 1 April 2024 to 31 March 2025."
      )
      htmlContent must include("If you have any queries, please email the Pillar 2 team at pillar2mailbox@hmrc.gov.uk")
      htmlContent must not include "Pillar 2 Top-up Taxes – Below-Threshold Notification"
      htmlContent must not include "What happens next"
    }

    "include plainTemplate body and footer for non-BTN request types" in {
      val txtContent = template
        .plainTemplate(defaultTemplateParams)
        .toString
      txtContent must include("Multinational Top-up Tax/Domestic Top-up Tax")
      txtContent must include("Dear Customer")
      txtContent must include(
        "This is confirmation that on 3 October 2025 at 2:45pm HM Revenue & Customs received your Pillar 2 UK Tax Return for the Accounting Period 1 April 2024 to 31 March 2025."
      )
      txtContent must include("If you have any queries, please email the Pillar 2 team at pillar2mailbox@hmrc.gov.uk")
      txtContent must not include "Pillar 2 Top-up Taxes – Below-Threshold Notification"
    }

    "include BTN-specific content for BTN request type" in {
      val htmlContent = template
        .htmlTemplate(btnTemplateParams)
        .toString
      htmlContent must include("Multinational Top-up Tax/Domestic Top-up Tax")
      htmlContent must include("Dear Customer")
      htmlContent must include("Pillar 2 Top-up Taxes – Below-Threshold Notification")
      htmlContent must include(
        "You have submitted a Below-Threshold Notification on 25 October 2024. This is effective from the start of the accounting period you selected, 10 October 2024."
      )
      htmlContent must include("What happens next")
      htmlContent must include(
        "The Below-Threshold Notification satisfies your group's obligation to submit a UK Tax Return for the current and future accounting periods."
      )
      htmlContent must include(
        "HMRC will not expect to receive an information return while your group remains below-threshold."
      )
      htmlContent must include(
        "You must submit a UK Tax Return if your group meets the threshold conditions in the future."
      )
      htmlContent must not include "This is confirmation that on"
      htmlContent must not include "If you have any queries, please email the Pillar 2 team"
    }

    "include BTN-specific content in plain text for BTN request type" in {
      val txtContent = template
        .plainTemplate(btnTemplateParams)
        .toString
      txtContent must include("Multinational Top-up Tax/Domestic Top-up Tax")
      txtContent must include("Dear Customer")
      txtContent must include("Pillar 2 Top-up Taxes – Below-Threshold Notification")
      txtContent must include(
        "You have submitted a Below-Threshold Notification on 25 October 2024. This is effective from the start of the accounting period you selected, 10 October 2024."
      )
      txtContent must include("What happens next")
      txtContent must include(
        "The Below-Threshold Notification satisfies your group's obligation to submit a UK Tax Return for the current and future accounting periods."
      )
      txtContent must include(
        "HMRC will not expect to receive an information return while your group remains below-threshold."
      )
      txtContent must include(
        "You must submit a UK Tax Return if your group meets the threshold conditions in the future."
      )
      txtContent must not include "This is confirmation that on"
      txtContent must not include "If you have any queries, please email the Pillar 2 team"
    }

    "handle different request types correctly" in {
      val overseasParams = defaultTemplateParams + ("requestType" -> "Overseas Return Notification")
      val htmlContent = template
        .htmlTemplate(overseasParams)
        .toString
      htmlContent must include("Overseas Return Notification")
      htmlContent must not include "Below-Threshold Notification"
    }

    "handle amended request types correctly" in {
      val amendedParams = defaultTemplateParams + ("requestType" -> "amended UK Tax Return")
      val htmlContent = template
        .htmlTemplate(amendedParams)
        .toString
      htmlContent must include("amended UK Tax Return")
      htmlContent must not include "Below-Threshold Notification"
    }
  }

}
