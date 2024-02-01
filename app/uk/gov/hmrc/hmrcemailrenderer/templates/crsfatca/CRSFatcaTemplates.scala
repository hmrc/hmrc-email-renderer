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

package uk.gov.hmrc.hmrcemailrenderer.templates.crsfatca

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CRSFATCA

object CRSFatcaTemplates {
  val templates = Seq(
    // REGISTRATION - REGISTRATION SUCCESSFUL
    MessageTemplate.create(
      templateId = "crs_fatca_registration_successful",
      fromAddress = govUkTeamAddress,
      service = CRSFATCA,
      subject = "Successful registration for CRS and FATCA",
      plainTemplate = txt.crsfatcaRegistrationSuccessful.f,
      htmlTemplate = html.crsfatcaRegistrationSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
