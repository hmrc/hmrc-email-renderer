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

package uk.gov.hmrc.hmrcemailrenderer.templates.tdq

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.tdq.params._
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateComparisonSpec }

class TdqTemplatesSpec extends TemplateComparisonSpec with CommonParamsForSpec with GuiceOneAppPerSuite {

  val templateName: String = "tdq_fph_self_serve_nudge"

  "TDQ / CMQ template tdq_fph_self_serve_nudge" should {

    val baseParams = commonParameters ++ Map(
      "developerName"   -> "John Smith",
      "month"           -> "October",
      "year"            -> "2019",
      "status"          -> "HEADERS_WITH_ERRORS",
      "applicationName" -> "MTD VAT Test Application",
      "applicationId"   -> "c190e3a0-cf8e-402d-ae37-2ec4a54bffff"
    )

    "be the same for text and html content" in {
      compareContent(templateName, baseParams)(tdqTemplate)
    }

    "contain subject with application name for application with no requests" in {
      val params = baseParams + ("status" -> NoRequests.name)
      val template = findTemplate(templateName)
      template.subject.f(params) mustEqual "Check fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for missing headers" in {
      val params = baseParams + ("status" -> AllRequiredHeadersMissing.name)
      val template = findTemplate(templateName)
      template.subject.f(params) mustEqual "Submit fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for invalid connection method" in {
      val params = baseParams + ("status" -> InvalidConnectionMethod.name)
      val template = findTemplate(templateName)
      template.subject.f(params) mustEqual "Submit fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for headers with errors" in {
      val params = baseParams + ("status" -> HeadersWithErrors.name)
      val template = findTemplate(templateName)
      template.subject.f(params) mustEqual "Fix fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for headers with advisories" in {
      val params = baseParams + ("status" -> HeadersWithWarnings.name)
      val template = findTemplate(templateName)
      template.subject.f(params) mustEqual "Improve fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name for heuristically compliant headers" in {
      val params = baseParams + ("status" -> HeadersHeuristicallyCompliant.name)
      val template = findTemplate(templateName)
      template.subject.f(params) mustEqual "Fraud prevention headers for MTD VAT Test Application"
    }

    "contain subject with application name" in {
      val template = findTemplate(templateName)
      template.subject.f(baseParams) mustEqual "Fix fraud prevention headers for MTD VAT Test Application"
    }

    "include subject as the title" in {
      renderedEmail(baseParams) must include("Fix fraud prevention headers for MTD VAT Test Application")
    }

    "include status contents for headers with errors" in {
      val email = renderedEmail(baseParams)
      email must include("Your application’s fraud prevention headers have errors.")
      email must include(
        "In production, in October 2019, MTD VAT Test Application does not meet the fraud prevention specification."
      )
    }

    "include status contents for application with no requests" in {
      val email = renderedEmail(baseParams + ("status" -> NoRequests.name))
      email must include("MTD VAT Test Application has not sent any requests in October 2019.")
    }

    "include action content for headers with errors" in {
      renderedEmail(baseParams) must include("find out which errors you need to fix")
    }

    "include action content for application with no requests" in {
      renderedEmail(baseParams + ("status" -> NoRequests.name)) must include(
        "check the status of your application"
      )
    }
  }

  def tdqTemplate(templateId: String): Option[(HtmlTemplate, TextTemplate)] =
    messageTemplateF(templateId)(TdqTemplates.templates)

  def findTemplate(templateId: String): MessageTemplate =
    TdqTemplates.templates.filter(t => t.templateId == templateId).head

  def renderedEmail(params: Map[String, String]): String =
    tdqTemplate(templateName) match {
      case Some((htmlTemplate, _)) => htmlTemplate(params).body
      case _                       => fail(s"could not locate template with id $templateName")
    }

}
