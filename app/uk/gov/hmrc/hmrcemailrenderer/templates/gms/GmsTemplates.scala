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

package uk.gov.hmrc.hmrcemailrenderer.templates.gms

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.GoodsMovementSystem

object GmsTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "gms_enrolment_confirmation",
      fromAddress = FromAddress.noReply("Get a goods movement reference"),
      service = GoodsMovementSystem,
      subject = "Your registration to Get a goods movement reference",
      plainTemplate = txt.gms_enrolment_confirmation.f,
      htmlTemplate = html.gms_enrolment_confirmation.f,
      priority = None
    )
  )
}
