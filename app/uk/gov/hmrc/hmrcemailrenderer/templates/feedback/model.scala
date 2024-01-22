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

package uk.gov.hmrc.hmrcemailrenderer.templates.feedback

import play.api.libs.json._

import java.time.Instant
import java.util.Base64
import scala.collection.immutable.Seq

object model {
  sealed trait Question {
    def label: String

    def optional: Option[Boolean]
  }

  case class RangeQuestion(label: String, range: Seq[Int], optional: Option[Boolean] = None) extends Question

  case class RadioQuestion(label: String, options: Seq[String], optional: Option[Boolean] = None) extends Question

  case class TextAreaQuestion(label: String, optional: Option[Boolean] = None) extends Question

  object Question {
    implicit val format: OFormat[Question] = new OFormat[Question] {

      override def reads(json: JsValue): JsResult[Question] = (json \ "type").as[String] match {
        case "slider"   => Json.reads[RangeQuestion].reads(json)
        case "radio"    => Json.reads[RadioQuestion].reads(json)
        case "textArea" => Json.reads[TextAreaQuestion].reads(json)
      }

      override def writes(o: Question): JsObject = o match {
        case rangeQ: RangeQuestion => Json.writes[RangeQuestion].writes(rangeQ) ++ Json.obj("type" -> "slider")
        case radioQ: RadioQuestion => Json.writes[RadioQuestion].writes(radioQ) ++ Json.obj("type" -> "radio")
        case taQ: TextAreaQuestion => Json.writes[TextAreaQuestion].writes(taQ) ++ Json.obj("type" -> "textArea")
      }
    }
  }

  case class DateSpan(from: Instant, to: Option[Instant] = None)

  object DateSpan {
    implicit val format: OFormat[DateSpan] = Json.format[DateSpan]

    def forever(from: Instant = Instant.now()) = DateSpan(from)
  }

  case class FeedbackConfig(
    name: String,
    label: String,
    questions: Seq[Question],
    active: DateSpan,
    showOnce: Boolean = true,
    showRate: Double = 1)

  case class Answers(name: String, answers: Seq[String])

  implicit val feedbackConfigFmt: OFormat[FeedbackConfig] = Json.format[FeedbackConfig]
  implicit val answersFmt: OFormat[Answers] = Json.format[Answers]

  def deserialize[A](src: Any)(implicit fjs: Reads[A]): A = {
    val decoded = Base64.getDecoder.decode(src.toString)
    Json.parse(decoded).as[A]
  }

  def questionAndAnswers(params: Map[String, Any]) = {
    val config = deserialize[FeedbackConfig](params("config"))
    val answers = deserialize[Answers](params("answers")).answers
    config.questions.zipWithIndex.map { case (question, index) => (index, question, answers(index)) }
  }
}
