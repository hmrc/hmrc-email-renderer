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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalTariffs

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import uk.gov.hmrc.play.test.UnitSpec

class CaseCompletedSpec extends UnitSpec with EitherValues with TemplateLoader with CommonParamsForSpec {

  "case_completed" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map(
      "reference"           -> "ATaR REFERENCE",
      "recipientName_line1" -> "Full Name",
      "goodsName"           -> "GOODS NAME",
      "dateSubmitted"       -> "20 December 2020",
      "officerName"         -> "Dan The Officer"
    )
    val template = templateLocator
      .templateGroups("Digital Tariffs")
      .find(_.templateId == "digital_tariffs_case_completed")
      .get

    "render correct subject" in {
      template.subject(Map("reference" -> "ATaR REFERENCE")) shouldBe ("Issued: Advance Tariff Ruling for ATaR REFERENCE")
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include(
        "We have issued your Advance Tariff Ruling for application ATaR REFERENCE for GOODS NAME")
      htmlContent should include("Dear Full Name")
      htmlContent should include(
        "Thank you for your Advance Tariff Ruling (ATaR) application dated 20 December 2020. I have made a decision and your ruling certificate can be viewed online in your ATaR account.")
      htmlContent should include("How to view your ruling for GOODS NAME")
      htmlContent should include(
        "You can sign in to your Advance Tariff Rulings account by going to GOV.UK and searching for 'Manage your Advance Tariff Rulings'.")
      htmlContent should include("In your account you will be able to:")
      htmlContent should include("print or download your ruling certificate")
      htmlContent should include("find out how I made this decision")
      htmlContent should include("find out how to review or appeal my decision")
      htmlContent should include("Important information about communicating with us by email")
      htmlContent should include(
        "Communicating with us through email is not secure and therefore no confidential information should be passed through emails with our team. By choosing to contact us by email you are accepting these risks.")
      htmlContent should include("For security reasons we have not included any links with this email.")
      htmlContent should include("Yours sincerely,")
      htmlContent should include("Dan The Officer")
      htmlContent should include("HMRC Tariff Classification Service")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include(
        "We have issued your Advance Tariff Ruling for application ATaR REFERENCE for GOODS NAME")
      txtContent should include("Dear Full Name")
      txtContent should include(
        "Thank you for your Advance Tariff Ruling (ATaR) application dated 20 December 2020. I have made a decision and your ruling certificate can be viewed online in your ATaR account.")
      txtContent should include("How to view your ruling for GOODS NAME")
      txtContent should include(
        "You can sign in to your Advance Tariff Rulings account by going to GOV.UK and searching for 'Manage your Advance Tariff Rulings'.")
      txtContent should include("In your account you will be able to:")
      txtContent should include("print or download your ruling certificate")
      txtContent should include("find out how I made this decision")
      txtContent should include("find out how to review or appeal my decision")
      txtContent should include("Important information about communicating with us by email")
      txtContent should include(
        "Communicating with us through email is not secure and therefore no confidential information should be passed through emails with our team. By choosing to contact us by email you are accepting these risks.")
      txtContent should include("For security reasons we have not included any links with this email.")
      txtContent should include("Yours sincerely,")
      txtContent should include("Dan The Officer")
      txtContent should include("HMRC Tariff Classification Service")
      txtContent should include("If you’re unsure an email is from HMRC:")
      txtContent should include("- Do not reply to it or click on any links")
      txtContent should include(
        "- Report the suspicious email to HMRC - to find out how, go to GOV.UK and search for 'Avoid and report internet scams and phishing'")
    }
  }

}
