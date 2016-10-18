package uk.gov.hmrc.email.templates.gmp

import uk.gov.hmrc.email.services.BodyTemplate._
import uk.gov.hmrc.email.services.{MissingTemplateParameterException, SimpleMessageTemplate}
import uk.gov.hmrc.email.templates.Regime.GuaranteedMinimumPension
import uk.gov.hmrc.email.templates.{GovUkTemplate, TemplateGroup}

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