/*
 * Copyright 2018 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.voa

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CCA
import registration._
object CCATemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "cca_enrolment_migration_confirmation",
      fromAddress = govUkTeamAddress,
      service = CCA,
      subject = "Submission Confirmation",
      plainTemplate = txt.ccaEnrolmentConfirmationExisiting.f,
      htmlTemplate = html.ccaEnrolmentConfirmationExisting.f,
      priority = Some(MessagePriority.Standard)),
    MessageTemplate.create(
        templateId = "cca_enrolment_confirmation",
        fromAddress = govUkTeamAddress,
        service = CCA,
        subject = "Submission Confirmation",
        plainTemplate = registration.txt.ccaEnrolmentConfirmation.f,
        htmlTemplate = registration.html.ccaEnrolmentConfirmation.f,
        priority = Some(MessagePriority.Standard)
      )
  )
}
