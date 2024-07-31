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

package preview

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import org.mockito.Mockito
import org.mockito.Mockito.when
import org.mockito.ArgumentMatchers.{ any, anyString }
import uk.gov.hmrc.hmrcemailrenderer.domain.{ Body, MessagePriority, MessageTemplate, MissingTemplateId, TemplateRenderFailure }
import uk.gov.hmrc.hmrcemailrenderer.services.TemplateRenderer
import uk.gov.hmrc.hmrcemailrenderer.templates.{ ServiceIdentifier, TemplateLocator }
import org.scalatest.matchers.should.Matchers
import org.scalatest.OptionValues
import org.scalatestplus.mockito.MockitoSugar

class PreviewSpec extends AnyWordSpec with Matchers with OptionValues with GuiceOneAppPerSuite with MockitoSugar {

  "createPreviewGroup" should {
    "generate a  preview item for each template id that resolves to a message template" in {
      val templates: Seq[MessageTemplate] = List("does not exist", "also does not exist").map { id =>
        MessageTemplate
          .create(id, "", ServiceIdentifier.SelfAssessment, id, (_ => ???): Body.Plain, (_ => ???): Body.Html)
      }
      val result = PreviewGroup.createPreviewGroup("Self Assessment", templates)
      result.name shouldBe "Self Assessment"
      result.items should contain.only(
        PreviewListItem("does not exist", "does not exist", MessagePriority.Standard, Map.empty),
        PreviewListItem("also does not exist", "also does not exist", MessagePriority.Standard, Map.empty)
      )
    }

    "generate the queryString from a PreviewListItem" in {
      PreviewListItem("", "", MessagePriority.Standard, Map("hello" -> "goodbye")).queryString shouldBe "?hello=goodbye"
      PreviewListItem("", "", MessagePriority.Standard, Map.empty).queryString shouldBe ""
    }
  }

  "The preview" should {

    def allTemplates = TemplateLocator.all

    val templateRenderer = app.injector.instanceOf[TemplateRenderer]

    forAll(Table.apply("templateId", allTemplates: _*)) { (mt: MessageTemplate) =>
      s"be able to render ${mt.templateId}" in {

        val parameters = TemplateParams.exampleParams
          .getOrElse(
            mt.templateId,
            TemplateParams2.exampleParams
              .getOrElse(mt.templateId, TemplateParams3.exampleParams.getOrElse(mt.templateId, Map.empty))
          )

        templateRenderer.render(mt.templateId, parameters) should not matchPattern {
          case Left(TemplateRenderFailure(_)) =>
        }
      }
    }

    val mock: TemplateRenderer = Mockito.mock(classOf[TemplateRenderer])
    "return an error string if the template not found" in {
      when(mock.render(anyString(), any[Map[String, String]]()))
        .thenReturn(Left(MissingTemplateId("12")))
      val preview = new Preview(mock)
      preview.html("", Map.empty) shouldBe "failed to rendered template with id == 12"
    }
  }
}
