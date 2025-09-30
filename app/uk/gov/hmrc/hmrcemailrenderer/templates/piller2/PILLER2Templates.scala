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

package uk.gov.hmrc.hmrcemailrenderer.templates.piller2

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.PILLER2

object PILLER2Templates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "piller2_submission",
      fromAddress = FromAddress.noReply("Piller2 Team"),
      service = PILLER2,
      subject = "Multinational Top-up Tax/Domestic Top-up Tax",
      plainTemplate = txt.piller2Validation.f,
      htmlTemplate = html.piller2Validation.f,
      priority = Some(MessagePriority.Standard)
    )
  )
}
