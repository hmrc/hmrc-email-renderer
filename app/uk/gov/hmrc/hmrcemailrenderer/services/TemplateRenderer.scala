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

package uk.gov.hmrc.hmrcemailrenderer.services

import com.google.inject.Inject
import play.api.{ Configuration, Logging }
import play.twirl.api.Format
import uk.gov.hmrc.hmrcemailrenderer.connectors.PreferencesConnector
import uk.gov.hmrc.hmrcemailrenderer.controllers.model.RenderResult
import uk.gov.hmrc.hmrcemailrenderer.domain.{ ErrorMessage, MissingTemplateId, TemplateRenderFailure }
import uk.gov.hmrc.hmrcemailrenderer.model.Language
import uk.gov.hmrc.hmrcemailrenderer.model.Language.{ English, Welsh }
import uk.gov.hmrc.hmrcemailrenderer.templates.TemplateLocator
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.audit.http.connector.{ AuditConnector, AuditResult }
import uk.gov.hmrc.play.audit.model.DataEvent
import uk.gov.hmrc.play.audit.model.EventTypes.Succeeded

import scala.concurrent.{ ExecutionContext, Future }
import scala.util.{ Failure, Success, Try }

class TemplateRenderer @Inject() (
  configuration: Configuration,
  auditConnector: AuditConnector,
  preferencesConnector: PreferencesConnector
) extends Logging {

  val locator: TemplateLocator = TemplateLocator

  lazy val commonParameters: Map[String, String] =
    configuration
      .get[Configuration](s"templates.config")
      .entrySet
      .map(a => (a._1, a._2.unwrapped().toString))
      .toMap

  lazy val templatesByLangPreference: Map[String, String] =
    configuration
      .get[Configuration]("welshTemplatesByLangPreferences")
      .entrySet
      .map(a => (a._1, a._2.unwrapped().toString))
      .toMap

  def render(templateId: String, parameters: Map[String, String]): Either[ErrorMessage, RenderResult] = {
    val allParams = commonParameters ++ parameters
    for {
      template  <- locator.findTemplate(templateId).toRight[ErrorMessage](MissingTemplateId(templateId))
      plainText <- render(template.plainTemplate, allParams)
      htmlText  <- render(template.htmlTemplate, allParams)
    } yield RenderResult(
      plainText,
      htmlText,
      template.fromAddress(allParams),
      template.subject(allParams),
      template.service.name,
      template.priority
    )
  }

  private def sendLanguageEvents(
    email: String,
    language: Language,
    originalTemplateId: String,
    selectedTemplateId: String,
    description: String
  )(implicit ec: ExecutionContext): Future[AuditResult] = {

    val event = DataEvent(
      "hmrc-email-renderer",
      auditType = Succeeded,
      tags = Map("transactionName" -> "Template Language"),
      detail = templatesByLangPreference ++ Map(
        "email"              -> email,
        "originalTemplateId" -> originalTemplateId,
        "selectedTemplateId" -> selectedTemplateId,
        "language"           -> language.toString,
        "description"        -> description
      )
    )

    auditConnector.sendEvent(event) map { success =>
      logger.debug("Language event successfully audited")
      success
    } recover { case e @ AuditResult.Failure(msg, _) =>
      logger.warn(s"Language event failed to audit: $msg")
      e
    }
  }

  def languageTemplateId(originalTemplateId: String, emailAddress: Option[String])(implicit
    hc: HeaderCarrier,
    ec: ExecutionContext
  ): Future[String] = {

    if (templatesByLangPreference.size <= 0) {
      logger.warn("WelshTemplatesByLangPreferences allowlist is empty")
    }

    val result = for {
      email           <- emailAddress
      welshTemplateId <- templatesByLangPreference.get(originalTemplateId)
    } yield preferencesConnector.languageByEmail(email).map { lang =>
      val selectedTemplateId = lang match {
        case English => originalTemplateId
        case Welsh   => welshTemplateId
      }
      sendLanguageEvents(email, lang, originalTemplateId, selectedTemplateId, "Language preference found")
      selectedTemplateId
    } recover { case e: Throwable =>
      logger.error(s"Error retrieving language preference from preferences service: ${e.getMessage}")
      originalTemplateId
    }
    result match {
      case Some(templateId) => templateId
      case None =>
        sendLanguageEvents(
          emailAddress.getOrElse("N/A"),
          Language.English,
          originalTemplateId,
          originalTemplateId,
          "Defaulting to English"
        )
        Future.successful(originalTemplateId)
    }
  }

  private def render(
    template: Map[String, String] => Format[_]#Appendable,
    params: Map[String, String]
  ): Either[ErrorMessage, String] =
    Try(template(params)) match {
      case Success(output) => Right(output.toString)
      case Failure(error)  => Left(TemplateRenderFailure(error.getMessage))
    }

}
