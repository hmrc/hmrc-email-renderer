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

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Pillar2
import uk.gov.hmrc.hmrcemailrenderer.templates.pillar2.html
import uk.gov.hmrc.hmrcemailrenderer.templates.pillar2.txt

object Pillar2Templates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "pillar2_gir_submission_successful",
      fromAddress = FromAddress.noReply("pillar2"),
      service = Pillar2,
      subject = "GloBE Information Return (GIR) – Successful Submission",
      plainTemplate = txt.girSubmissionSuccessful.f,
      htmlTemplate = html.girSubmissionSuccessful.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "pillar2_gir_submission_generic_errors",
      fromAddress = FromAddress.noReply("pillar2"),
      service = Pillar2,
      subject = "GloBE Information Return (GIR) – Errors Identified. Please Re-submit",
      plainTemplate = txt.girSubmissionGenericErrors.f,
      htmlTemplate = html.girSubmissionGenericErrors.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "pillar2_gir_submission_critical_errors",
      fromAddress = FromAddress.noReply("pillar2"),
      service = Pillar2,
      subject =
        "GloBE Information Return (GIR) – Critical Schema or Business Rule failure. Please check and re-submit.",
      plainTemplate = txt.girSubmissionCriticalErrors.f,
      htmlTemplate = html.girSubmissionCriticalErrors.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
