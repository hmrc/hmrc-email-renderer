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

package uk.gov.hmrc.hmrcemailrenderer.templates.hec

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.HEC

object HecTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "hec_tax_check_code",
      fromAddress = govUkTeamAddress,
      service = HEC,
      subject = "Tax check code for your licence application",
      plainTemplate = txt.hecTaxCheckCode.f,
      htmlTemplate = html.hecTaxCheckCode.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "hec_tax_check_code_cy",
      fromAddress = govUkTeamAddress,
      service = HEC,
      subject = "Cod gwirio treth ar gyfer eich cais am drwydded",
      plainTemplate = txt.hecTaxCheckCode_cy.f,
      htmlTemplate = html.hecTaxCheckCode_cy.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
