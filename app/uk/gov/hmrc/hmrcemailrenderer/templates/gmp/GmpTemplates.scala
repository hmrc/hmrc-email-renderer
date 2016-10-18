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

package uk.gov.hmrc.hmrcemailrenderer.templates.gmp

import uk.gov.hmrc.email.services.BodyTemplate._
import uk.gov.hmrc.email.services.{MissingTemplateParameterException, SimpleMessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.GuaranteedMinimumPension
import uk.gov.hmrc.hmrcemailrenderer.templates.{GovUkTemplate, TemplateGroup}

object GmpTemplates extends TemplateGroup with GovUkTemplate {

  val title = "GMP"
  val from = "GMP Checker <noreply@tax.service.gov.uk>"

  def subGroups = Seq(
    SimpleMessageTemplate(
        id = "gmp_bulk_upload_received",
        regime = GuaranteedMinimumPension,
        subject = Subject(gmp_upload_reference_received_for_subject),
        plainTemplate = txt.gmpFileReceivedNotificationEmail.apply,
        htmlTemplate = html.gmpFileReceivedNotificationEmail.apply,
        fromAddress = from
        ),
    SimpleMessageTemplate(
        id = "gmp_bulk_upload_processed",
        regime = GuaranteedMinimumPension,
        subject = Subject(gmp_upload_reference_processed_for_subject),
        plainTemplate = txt.gmpFileProcessedNotificationEmail.apply,
        htmlTemplate = html.gmpFileProcessedNotificationEmail.apply,
        fromAddress = from
        )
    )

  private def gmp_upload_reference_received_for_subject(params : Params) =
    params.get("fileUploadReference").map(fileUploadReference => s"Your file $fileUploadReference has been received.").getOrElse(throw new MissingTemplateParameterException("fileUploadReference"))

  private def gmp_upload_reference_processed_for_subject(params : Params) =
   params.get("fileUploadReference").map(fileUploadReference => s"Your GMP calculation $fileUploadReference is ready.").getOrElse(throw new MissingTemplateParameterException("fileUploadReference"))

}
