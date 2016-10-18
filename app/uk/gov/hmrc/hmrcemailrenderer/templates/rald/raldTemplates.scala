/*
 * Copyright 2016 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.rald

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.RentalAndLeaseDetails

object RaldTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "rald_alert",
      fromAddress = "Rent and Lease Details <noreply@tax.service.gov.uk>",
      service = RentalAndLeaseDetails,
      subject = "Your saved Rent and Lease details expires in 90 days.",
      plainTemplate = txt.rald.f,
      htmlTemplate = html.rald.f)
  )
}
