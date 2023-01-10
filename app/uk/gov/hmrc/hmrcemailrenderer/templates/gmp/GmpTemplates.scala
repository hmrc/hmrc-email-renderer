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

package uk.gov.hmrc.hmrcemailrenderer.templates.gmp

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.GuaranteedMinimumPension

object GmpTemplates {
  private val gmp_upload_reference_received_for_subject: Map[String, String] => String =
    _.get("fileUploadReference")
      .map(fileUploadReference => s"Your file $fileUploadReference has been received.")
      .getOrElse(throw new RuntimeException("Missing parameter fileUploadReference"))

  private val gmp_upload_reference_processed_for_subject: Map[String, String] => String =
    _.get("fileUploadReference")
      .map(fileUploadReference => s"Your GMP calculation $fileUploadReference is ready.")
      .getOrElse(throw new RuntimeException("Missing parameter fileUploadReference"))

  val from = FromAddress.noReply("GMP Checker")

  val templates = Seq(
    MessageTemplate.createWithDynamicSubject(
      templateId = "gmp_bulk_upload_received",
      fromAddress = from,
      service = GuaranteedMinimumPension,
      subject = gmp_upload_reference_received_for_subject,
      plainTemplate = txt.gmpFileReceivedNotificationEmail.f,
      htmlTemplate = html.gmpFileReceivedNotificationEmail.f
    ),
    MessageTemplate.createWithDynamicSubject(
      templateId = "gmp_bulk_upload_processed",
      fromAddress = from,
      service = GuaranteedMinimumPension,
      subject = gmp_upload_reference_processed_for_subject,
      plainTemplate = txt.gmpFileProcessedNotificationEmail.f,
      htmlTemplate = html.gmpFileProcessedNotificationEmail.f
    )
  )
}
