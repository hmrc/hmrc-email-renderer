/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.ecc

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress._
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.EoriCommonComponent

object EoriCommonComponentTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "ecc_subscription_successful",
      fromAddress = govUkTeamAddress,
      service = EoriCommonComponent,
      subject = "HMRC approved your service application",
      plainTemplate = txt.eccSubscribeSuccessful.f,
      htmlTemplate = html.eccSubscribeSuccessful.f
    ),
    MessageTemplate.create(
      templateId = "ecc_subscription_successful_cy",
      fromAddress = govUkTeamAddressWelsh,
      service = EoriCommonComponent,
      subject = "Mae CThEM wedi cymeradwyo’ch cais i’r gwasanaeth",
      plainTemplate = txt.eccSubscribeSuccessful_cy.f,
      htmlTemplate = html.eccSubscribeSuccessful_cy.f
    ),
    MessageTemplate.create(
      templateId = "ecc_subscription_not_successful",
      fromAddress = govUkTeamAddress,
      service = EoriCommonComponent,
      subject = "Your service application was unsuccessful",
      plainTemplate = txt.eccSubscribeNotSuccessful.f,
      htmlTemplate = html.eccSubscribeNotSuccessful.f
    ),
    MessageTemplate.create(
      templateId = "ecc_subscription_not_successful_cy",
      fromAddress = govUkTeamAddressWelsh,
      service = EoriCommonComponent,
      subject = "Roedd eich cais i’r gwasanaeth yn aflwyddiannus",
      plainTemplate = txt.eccSubscribeNotSuccessful_cy.f,
      htmlTemplate = html.eccSubscribeNotSuccessful_cy.f
    ),
    MessageTemplate.create(
      templateId = "ecc_rcm_notifications",
      fromAddress = govUkTeamAddress,
      service = EoriCommonComponent,
      subject = "ECC RCM Exception",
      plainTemplate = txt.eccRCMNotifications.f,
      htmlTemplate = html.eccRCMNotifications.f
    )
  )
}
