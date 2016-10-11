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

package preview

import uk.gov.hmrc.hmrcemailrenderer.domain.{Body, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier
import uk.gov.hmrc.play.test.UnitSpec

class PreviewSpec extends UnitSpec {

  "createPreviewGroup" should {
    "generate a  preview item for each template id that resolves to a message template" in {
      val templates: Seq[MessageTemplate] = List("does not exist", "also does not exist").map { id =>
        MessageTemplate.create(id, "", ServiceIdentifier.SelfAssessment, id, (_ => ???): Body.Plain, (_ => ???): Body.Html)
      }

      val result = PreviewGroup.createPreviewGroup(ServiceIdentifier.SelfAssessment, templates)

      result.name shouldBe ServiceIdentifier.SelfAssessment.title
      result.items should contain only(
        PreviewListItem("does not exist", "does not exist", Map.empty),
        PreviewListItem("also does not exist", "also does not exist", Map.empty)
      )
    }

    "generate the queryString from a PreviewListItem" in {
      PreviewListItem("", "", Map("hello" -> "goodbye")).queryString shouldBe "?hello=goodbye"
      PreviewListItem("", "", Map.empty).queryString shouldBe ""
    }
  }
}