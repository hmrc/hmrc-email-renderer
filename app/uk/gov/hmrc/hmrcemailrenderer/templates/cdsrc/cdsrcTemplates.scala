/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.cdsrc

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.CDSRC

object cdsrcTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "reimbursement_claim_submission",
      fromAddress = govUkTeamAddress,
      service = CDSRC,
      subject = "HMRC claim submission",
      plainTemplate = txt.reimbursement_claim_submission.f,
      htmlTemplate = html.reimbursement_claim_submission.f,
      priority = Some(MessagePriority.Urgent)
    )
  )

}
