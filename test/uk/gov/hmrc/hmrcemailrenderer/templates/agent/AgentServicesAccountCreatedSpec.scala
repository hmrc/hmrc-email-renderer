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

package uk.gov.hmrc.hmrcemailrenderer.templates.agent

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import uk.gov.hmrc.hmrcemailrenderer.domain.MessagePriority
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Agent
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, FromAddress, TemplateLoader, TemplateLocator }

class AgentServicesAccountCreatedSpec
    extends AnyWordSpec with Matchers with TemplateLoader with TemplateLocator with CommonParamsForSpec {

  private val accountCreatedTemplate = templateGroups("Agent")
    .find(_.templateId == "agent_services_account_created")
    .get

  private val subscriptionCompleteTemplate = templateGroups("Agent")
    .find(_.templateId == "agent_services_subscription_complete")
    .get

  private val subscriptionCompleteParams = commonParameters ++ Map(
    "agencyName"         -> "Test Agency",
    "serviceName"        -> "PAYE/CIS",
    "serviceSectionName" -> "Pay as you earn (PAYE)/Construction Industry Scheme (CIS)",
    "agentCode"          -> "AB1234"
  )

  private val accountCreatedParams = commonParameters ++ Map(
    "agencyName" -> "Test Agency",
    "arn"        -> "TARN0000001"
  )

  "Rendering agent_services_account_created" should {

    "render the existing ASA account created email unchanged" in {
      val htmlContent = accountCreatedTemplate.htmlTemplate(accountCreatedParams).toString
      val txtContent = accountCreatedTemplate.plainTemplate(accountCreatedParams).toString

      accountCreatedTemplate.templateId shouldBe "agent_services_account_created"
      accountCreatedTemplate.service shouldBe Agent
      accountCreatedTemplate.fromAddress(Map.empty) shouldBe FromAddress.noReply("HMRC Agent Services")
      accountCreatedTemplate.subject(accountCreatedParams) shouldBe "HMRC: agent services account created"
      accountCreatedTemplate.priority shouldBe Some(MessagePriority.Urgent)

      htmlContent should include("Agent services account created")
      htmlContent should include("You have created an HMRC agent services account for Test Agency.")
      htmlContent should include("Your account reference number is <strong>TARN0000001</strong>")
      htmlContent should not include "agent services agent code"

      txtContent should include("Agent services account created")
      txtContent should include("You have created an HMRC agent services account for Test Agency.")
      txtContent should include("Your account reference number is TARN0000001")
      txtContent should not include "agent services agent code"
    }
  }

  "Rendering agent_services_subscription_complete" should {

    "render service-specific meta information" in {
      subscriptionCompleteTemplate.templateId shouldBe "agent_services_subscription_complete"
      subscriptionCompleteTemplate.service shouldBe Agent
      subscriptionCompleteTemplate.fromAddress(Map.empty) shouldBe FromAddress.noReply("HMRC Agent Services")
      subscriptionCompleteTemplate.subject(
        subscriptionCompleteParams
      ) shouldBe "HMRC: Your PAYE/CIS agent code is ready"
      subscriptionCompleteTemplate.priority shouldBe Some(MessagePriority.Urgent)
    }

    "render the service-specific agent code in html and text content" in {
      val htmlContent = subscriptionCompleteTemplate.htmlTemplate(subscriptionCompleteParams).toString
      val txtContent = subscriptionCompleteTemplate.plainTemplate(subscriptionCompleteParams).toString

      htmlContent should include("Your PAYE/CIS agent code is ready")
      htmlContent should include("You can now view your code on your agent services account.")
      htmlContent should include("Pay as you earn (PAYE)/Construction Industry Scheme (CIS)")
      htmlContent should include("Your agent code is <strong>AB1234</strong>")
      htmlContent should not include "Your account reference number is"

      txtContent should include("Your PAYE/CIS agent code is ready")
      txtContent should include("You can now view your code on your agent services account.")
      txtContent should include("Pay as you earn (PAYE)/Construction Industry Scheme (CIS)")
      txtContent should include("Your agent code is AB1234")
      txtContent should include("If you’re unsure an email is from HMRC")
      txtContent should not include "Your account reference number is"
    }
  }
}
