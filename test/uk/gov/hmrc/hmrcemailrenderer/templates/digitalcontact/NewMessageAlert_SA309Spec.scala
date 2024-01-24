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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.SelfAssessment
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class NewMessageAlert_SA309Spec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "NewMessageAlert_SA309" should {

    val templateSA309: MessageTemplate = MessageTemplate.create(
      templateId = "newMessageAlert_SA309",
      fromAddress = "HMRC paperless norepoy@tax.service.gov.uk",
      service = SelfAssessment,
      subject = "You've got a new message from HMRC",
      plainTemplate = txt.newMessageAlertSA309.f,
      htmlTemplate = html.newMessageAlertSA309.f,
      priority = Some(MessagePriority.Standard)
    )

    "have the correct subject and body content" in {

      templateSA309.subject(commonParameters) shouldBe "You've got a new message from HMRC"
      val htmlContent = templateSA309.htmlTemplate(commonParameters).toString
      htmlContent should include(
        "You have a new message from HMRC to let you know the deadline for completing a paper tax return has now passed so you will need to do your self assessment online by 31 January")
      htmlContent should include("To view it, sign in to your HMRC online account")
    }

    "have dear customer as salutation no name parameters are provided" in {
      templateSA309.htmlTemplate(commonParameters).toString should include("Dear Customer")
    }

    "have dear customer as salutation no forename parameter is provided" in {
      val nameData = Map(
        "recipientName_title"          -> "Lord",
        "recipientName_secondForename" -> "Montogmery",
        "recipientName_surname"        -> "Windsor",
        "recipientName_honours"        -> "Viscount")
      val htmlContent = templateSA309.htmlTemplate(commonParameters ++ nameData).toString
      htmlContent should include("Dear Lord Windsor")
      htmlContent shouldNot include("Customer")
      htmlContent shouldNot include("Montgomery")
      htmlContent shouldNot include("Viscount")
    }

  }

}
