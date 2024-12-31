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

package uk.gov.hmrc.hmrcemailrenderer.templates.dprs

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.DigitalPlatformReporting
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress }

class AddedReportingNotificationForYouSpec extends PlaySpec with CommonParamsForSpec {

  "dprs_added_reporting_notification_for_you" must {
    val underTest = MessageTemplate.create(
      templateId = "dprs_added_reporting_notification_for_you",
      fromAddress = govUkTeamAddress,
      service = DigitalPlatformReporting,
      subject = "A reporting notification has been added for you in the digital platform reporting service",
      plainTemplate = txt.dprs_added_reporting_notification_for_you.f,
      htmlTemplate = html.dprs_added_reporting_notification_for_you.f,
      priority = Some(MessagePriority.Urgent)
    )

    "include correct subject" in {
      underTest.subject(
        commonParameters
      ) mustBe "A reporting notification has been added for you in the digital platform reporting service"
    }

    "render template correctly when isReportingPO, isExtendedDueDiligence, isActiveSellerDueDiligence are true" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName"       -> "Tim Vinted",
            "isReportingPO"              -> "true",
            "reportablePeriodYear"       -> "2024",
            "poBusinessName"             -> "Vinted",
            "isExtendedDueDiligence"     -> "true",
            "isActiveSellerDueDiligence" -> "true"
          )
        )
        .toString
      htmlContent must include("A reporting notification has been added for you")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include(
        "The following reporting notification has been added for Vinted in the digital platform reporting service."
      )
      htmlContent must include("You are a reporting platform operator for the 2024 reportable period.")
      htmlContent must include("You have taken the extended time limit for due diligence on pre-existing sellers.")
      htmlContent must include("You are carrying out due diligence on active sellers only.")

      htmlContent must include("This notification will automatically carry over each year until it is updated.")
      htmlContent must include("Why you are receiving this email")
      htmlContent must include("You are listed as a contact for Vinted.")

      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("From HMRC Digital Platform Reporting")
    }

    "render template correctly when isReportingPO is false and isExtendedDueDiligence, isActiveSellerDueDiligence are true" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName"       -> "Tim Vinted",
            "isReportingPO"              -> "false",
            "reportablePeriodYear"       -> "2024",
            "poBusinessName"             -> "Vinted",
            "isExtendedDueDiligence"     -> "true",
            "isActiveSellerDueDiligence" -> "true"
          )
        )
        .toString
      htmlContent must include("A reporting notification has been added for you")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include(
        "The following reporting notification has been added for Vinted in the digital platform reporting service."
      )
      htmlContent must include("You are an excluded platform operator for the 2024 reportable period.")
      htmlContent must not include "You have taken the extended time limit for due diligence on pre-existing sellers."
      htmlContent must not include "You are carrying out due diligence on active sellers only."

      htmlContent must include("This notification will automatically carry over each year until it is updated.")
      htmlContent must include("Why you are receiving this email")
      htmlContent must include("You are listed as a contact for Vinted.")

      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("From HMRC Digital Platform Reporting")
    }

    "render template correctly when isReportingPO=true, isExtendedDueDiligence=false, isActiveSellerDueDiligence=true" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName"       -> "Tim Vinted",
            "isReportingPO"              -> "true",
            "reportablePeriodYear"       -> "2024",
            "poBusinessName"             -> "Vinted",
            "isExtendedDueDiligence"     -> "false",
            "isActiveSellerDueDiligence" -> "true"
          )
        )
        .toString
      htmlContent must include("A reporting notification has been added for you")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include(
        "The following reporting notification has been added for Vinted in the digital platform reporting service."
      )
      htmlContent must include("You are a reporting platform operator for the 2024 reportable period.")
      htmlContent must not include "You have taken the extended time limit for due diligence on pre-existing sellers."
      htmlContent must include("You are carrying out due diligence on active sellers only.")

      htmlContent must include("This notification will automatically carry over each year until it is updated.")
      htmlContent must include("Why you are receiving this email")
      htmlContent must include("You are listed as a contact for Vinted.")

      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("From HMRC Digital Platform Reporting")
    }

    "render template correctly when isReportingPO=true, isExtendedDueDiligence=true, isActiveSellerDueDiligence=false" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName"       -> "Tim Vinted",
            "isReportingPO"              -> "true",
            "reportablePeriodYear"       -> "2024",
            "poBusinessName"             -> "Vinted",
            "isExtendedDueDiligence"     -> "true",
            "isActiveSellerDueDiligence" -> "false"
          )
        )
        .toString
      htmlContent must include("A reporting notification has been added for you")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include(
        "The following reporting notification has been added for Vinted in the digital platform reporting service."
      )
      htmlContent must include("You are a reporting platform operator for the 2024 reportable period.")
      htmlContent must include("You have taken the extended time limit for due diligence on pre-existing sellers.")
      htmlContent must include("You are carrying out due diligence on all sellers.")

      htmlContent must include("This notification will automatically carry over each year until it is updated.")
      htmlContent must include("Why you are receiving this email")
      htmlContent must include("You are listed as a contact for Vinted.")

      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("From HMRC Digital Platform Reporting")
    }

    "render template correctly when isReportingPO=true, isExtendedDueDiligence=false, isActiveSellerDueDiligence=false" in {
      val htmlContent = underTest
        .htmlTemplate(
          commonParameters ++ Map(
            "poPrimaryContactName"       -> "Tim Vinted",
            "isReportingPO"              -> "true",
            "reportablePeriodYear"       -> "2024",
            "poBusinessName"             -> "Vinted",
            "isExtendedDueDiligence"     -> "false",
            "isActiveSellerDueDiligence" -> "false"
          )
        )
        .toString
      htmlContent must include("A reporting notification has been added for you")
      htmlContent must include("Dear")
      htmlContent must include("Tim Vinted")
      htmlContent must include(
        "The following reporting notification has been added for Vinted in the digital platform reporting service."
      )
      htmlContent must include("You are a reporting platform operator for the 2024 reportable period.")
      htmlContent must not include "You have taken the extended time limit for due diligence on pre-existing sellers."
      htmlContent must include("You are carrying out due diligence on all sellers.")

      htmlContent must include("This notification will automatically carry over each year until it is updated.")
      htmlContent must include("Why you are receiving this email")
      htmlContent must include("You are listed as a contact for Vinted.")

      htmlContent must include(
        "For more information, search GOV.UK for 'check if you need to carry out digital platform reporting'."
      )
      htmlContent must include("From HMRC Digital Platform Reporting")
    }
  }
}
