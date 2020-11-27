/*
 * Copyright 2020 HM Revenue & Customs
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
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.MODS

object ModsTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "mods_import_declaration",
      fromAddress = govUkTeamAddress,
      service = MODS,
      subject = "Declaration and payment for commercial goods you bring into Great Britain",
      plainTemplate = txt.mods_import_declaration.f,
      htmlTemplate = html.mods_import_declaration.f,
      priority = Some(MessagePriority.Standard)
    ),
    MessageTemplate.create(
      templateId = "mods_export_declaration",
      fromAddress = govUkTeamAddress,
      service = MODS,
      subject = "Declaration for commercial goods leaving Great Britain",
      plainTemplate = txt.mods_export_declaration.f,
      htmlTemplate = html.mods_export_declaration.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
