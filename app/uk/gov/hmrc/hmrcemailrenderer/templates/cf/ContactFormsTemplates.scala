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

package uk.gov.hmrc.hmrcemailrenderer.templates.cf

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ContactForms

object ContactFormsTemplates {

  private val fromNoReplyVOA = FromAddress.noReply("Valuation Office Agency")
  private val standardPriority = Some(MessagePriority.Standard)

  val contactFormsGroup = "Contact Forms"
  val cf_enquiry_confirmation = "cf_enquiry_confirmation"

  val templates = Seq(
    MessageTemplate.create(
      templateId = cf_enquiry_confirmation,
      fromAddress = fromNoReplyVOA,
      service = ContactForms,
      subject = "You have sent an enquiry to the Valuation Office Agency",
      plainTemplate = txt.cf_enquiry_confirmation.f,
      htmlTemplate = html.cf_enquiry_confirmation.f,
      priority = standardPriority
    )
  )

}
