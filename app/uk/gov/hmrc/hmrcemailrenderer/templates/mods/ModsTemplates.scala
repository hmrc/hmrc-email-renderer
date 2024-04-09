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

package uk.gov.hmrc.hmrcemailrenderer.templates.mods

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.MODS
import uk.gov.hmrc.hmrcemailrenderer.templates.transactionengine.TransactionEngineFromAddress.transactionEngineAddress

object ModsTemplates {
  val templates = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_import_declaration",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Import declaration"
        } else {
          "Declaration for commercial goods you bring into Great Britain"
        },
      plainTemplate = txt.mods_import_declaration.f,
      htmlTemplate = html.mods_import_declaration.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_amend_import_declaration",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Updated import declaration"
        } else {
          "Updated declaration for commercial goods you bring into Great Britain"
        },
      plainTemplate = txt.mods_amend_import_declaration.f,
      htmlTemplate = html.mods_amend_import_declaration.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_import_declaration_cy",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Datganiad mewnforio"
        } else {
          "Datganiad ar gyfer nwyddau masnachol yr ydych yn dod â nhw i Brydain Fawr"
        },
      plainTemplate = txt.mods_import_declaration_cy.f,
      htmlTemplate = html.mods_import_declaration_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_amend_import_declaration_cy",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Datganiad mewnforio"
        } else {
          "Datganiad wedi’i ddiweddaru ar gyfer nwyddau masnachol yr ydych yn dod â nhw i Brydain Fawr"
        },
      plainTemplate = txt.mods_amend_import_declaration_cy.f,
      htmlTemplate = html.mods_amend_import_declaration_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_export_declaration",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Export declaration"
        } else {
          "Declaration for commercial goods you take out of Great Britain"
        },
      plainTemplate = txt.mods_export_declaration.f,
      htmlTemplate = html.mods_export_declaration.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_amend_export_declaration",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Updated export declaration"
        } else {
          "Updated declaration for commercial goods you take out of Great Britain"
        },
      plainTemplate = txt.mods_amend_export_declaration.f,
      htmlTemplate = html.mods_amend_export_declaration.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_export_declaration_cy",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Datganiad allforio"
        } else {
          "Datganiad ar gyfer nwyddau masnachol yr ydych yn mynd â nhw allan o Brydain Fawr"
        },
      plainTemplate = txt.mods_export_declaration_cy.f,
      htmlTemplate = html.mods_export_declaration_cy.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "mods_amend_export_declaration_cy",
      fromAddress = transactionEngineAddress,
      service = MODS,
      subject = params =>
        if (params("emailTo") == "BorderForce") {
          s"${params("surname")} - ${params("declarationReference")} - Datganiad allforio"
        } else {
          "Datganiad wedi’i ddiweddaru ar gyfer nwyddau masnachol yr ydych yn mynd â nhw allan o Brydain Fawr"
        },
      plainTemplate = txt.mods_amend_export_declaration_cy.f,
      htmlTemplate = html.mods_amend_export_declaration_cy.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
