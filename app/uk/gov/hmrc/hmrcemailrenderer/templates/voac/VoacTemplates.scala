/*
 * Copyright 2017 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.voac

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.ValuationOfficeAgencyContactForm

object VoacTemplates  {

  private val property_for_subject: Map[String, String] => String = m =>
    s"Valuation Office Agency Contact Form for ${m.getOrElse("propertyAddress", "00 High St,Town,County, AA11AA")}"

  val templates = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "voa_confirmation_message_alert",
      FromAddress.noReply("VOA Internal Use only - From Valuation Office Agency Contact Form"),
      service  = ValuationOfficeAgencyContactForm,
      subject = property_for_subject,
      plainTemplate = txt.voaConfirmationMessageAlert.f,
      htmlTemplate = html.voaConfirmationMessageAlert.f
    )
  )
}
