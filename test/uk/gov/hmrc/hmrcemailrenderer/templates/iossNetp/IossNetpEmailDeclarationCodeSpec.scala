/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.iossNetp

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.{ EitherValues, OptionValues }
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.IossNetp
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }

class IossNetpEmailDeclarationCodeSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  private val intermediaryName: String = "Test Company Name"
  private val contactName: String = "Joe Bloggs"
  private val activationCode: String = "ABCDEF"
  private val activationCodeExpiryDate: String = "21 July 2025"

  "Ioss Netp Email Declaration Code" should {
    val templateLocator: TemplateLocator = new TemplateLocator {}
    val params: Map[String, String] = commonParameters ++ Map(
      "intermediary_name"           -> intermediaryName,
      "recipientName_line1"         -> contactName,
      "activation_code"             -> activationCode,
      "activation_code_expiry_date" -> activationCodeExpiryDate
    )
    val template = templateLocator
      .templateGroups("IOSS NETP")
      .find(_.templateId == "ioss_netp_email_declaration_code")
      .get

    "render correct meta information" in {
      template.templateId `shouldBe` "ioss_netp_email_declaration_code"
      template.service `shouldBe` IossNetp
      template.fromAddress(Map.empty) `shouldBe` "VAT Import One Stop Shop Team <noreply@tax.service.gov.uk>"
      template.subject(Map.empty) `shouldBe` "Your Import One Stop Shop activation code"
      template.priority `shouldBe` Some(MessagePriority.Standard)
    }

    "render correct HTML content" in {
      val htmlContent: String = template.htmlTemplate(params).toString

      htmlContent should include(intermediaryName + " wants to register you to the VAT Import One Stop Shop scheme")
      htmlContent should include("Dear " + contactName)
      htmlContent should include(
        intermediaryName + " has registered your business to their VAT Import One Stop Shop scheme."
      )
      htmlContent should include(
        "They will send you a link to follow, where you must use this code to confirm your registration: <strong>" + activationCode + "</strong>"
      )
      htmlContent should include("What happens next")
      htmlContent should include(
        "The link and code will expire on " + activationCodeExpiryDate + ". If you do not confirm by then, " + intermediaryName + " will need to register you again."
      )
      htmlContent should include("If you think this is an error, contact HMRC.")
      htmlContent should include("From the VAT Import One Stop Shop team")
    }

    "render correct text content" in {
      val textContent: String = template.plainTemplate(params).toString

      textContent should include(intermediaryName + " wants to register you to the VAT Import One Stop Shop scheme")
      textContent should include("Dear " + contactName)
      textContent should include(
        intermediaryName + " has registered your business to their VAT Import One Stop Shop scheme."
      )
      textContent should include(
        "They will send you a link to follow, where you must use this code to confirm your registration: " + activationCode
      )
      textContent should include("What happens next")
      textContent should include(
        "The link and code will expire on " + activationCodeExpiryDate + ". If you do not confirm by then, " + intermediaryName + " will need to register you again."
      )
      textContent should include("If you think this is an error, contact HMRC.")
      textContent should include("From the VAT Import One Stop Shop team")
    }
  }
}
