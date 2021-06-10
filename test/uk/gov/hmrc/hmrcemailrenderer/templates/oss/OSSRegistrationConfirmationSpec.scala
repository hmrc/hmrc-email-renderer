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

package uk.gov.hmrc.hmrcemailrenderer.templates.oss

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{CommonParamsForSpec, TemplateLoader, TemplateLocator}
import uk.gov.hmrc.play.test.UnitSpec

class OSSRegistrationConfirmationSpec extends UnitSpec with EitherValues with TemplateLoader with CommonParamsForSpec {

  "OSS Registration Confirmation" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters
    val template = templateLocator
      .templateGroups("OSS")
      .find(_.templateId == "oss_registration_confirmation")
      .get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe ("OSS Registration Confirmation")
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("OSS Registration Confirmation - Title")
      htmlContent should include("OSS Registration Confirmation")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("OSS Registration Confirmation")
      txtContent should include("OSS Registration Confirmation - Title")
    }
  }
}
