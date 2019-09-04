/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.customsfinancials

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CustomsFinancials
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress

object CustomsFinancialsTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "customs_financials_new_statement_notification",
      fromAddress = govUkTeamAddress,
      service = CustomsFinancials,
      subject = "View your HMRC Duty Deferment Statement",
      plainTemplate = txt.newStatementNotificationEmail.f,
      htmlTemplate = html.newStatementNotificationEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "customs_financials_new_import_adjustment",
      fromAddress = govUkTeamAddress,
      service = CustomsFinancials,
      subject = "New notification of import adjustment statement",
      plainTemplate = txt.ImportAdjustmentEmail.f,
      htmlTemplate = html.ImportAdjustmentEmail.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "customs_financials_new_c79_certificate",
      fromAddress = govUkTeamAddress,
      service = CustomsFinancials,
      subject = "New import VAT certificate (C79)",
      plainTemplate = txt.C79Certificate.f,
      htmlTemplate = html.C79Certificate.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "customs_financials_new_postponed_vat_notification",
      fromAddress = govUkTeamAddress,
      service = CustomsFinancials,
      subject = "New postponed import VAT statement",
      plainTemplate = txt.postponedImportVATStatement.f,
      htmlTemplate = html.postponedImportVATStatement.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}