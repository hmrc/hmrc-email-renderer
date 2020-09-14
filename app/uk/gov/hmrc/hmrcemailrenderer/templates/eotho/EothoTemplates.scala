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

package uk.gov.hmrc.hmrcemailrenderer.templates.eotho

import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.noReply
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.EOTHO

object EothoTemplates {

  lazy val eothoFromAddress = noReply("Eat Out to Help Out Scheme")
  lazy val eothoFromAddressWelsh = noReply("Cynllun Bwyta Allan i Helpu Allan")
  val templates = Seq(
    MessageTemplate.create(
      templateId = "discounted_dining_payment_sent",
      fromAddress = eothoFromAddress,
      service = EOTHO,
      subject = "HMRC has sent a payment for the Eat Out to Help Out Scheme",
      plainTemplate = txt.discountedDiningPaymentSent.f,
      htmlTemplate = html.discountedDiningPaymentSent.f,
      priority = Some(MessagePriority.Urgent)
    ),
    MessageTemplate.create(
      templateId = "discounted_dining_payment_sent_cy",
      fromAddress = eothoFromAddressWelsh,
      service = EOTHO,
      subject = "Mae CThEM wedi anfon taliad ar gyfer y Cynllun Bwyta Allan i Helpu Allan",
      plainTemplate = txt.discountedDiningPaymentSent_cy.f,
      htmlTemplate = html.discountedDiningPaymentSent_cy.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
