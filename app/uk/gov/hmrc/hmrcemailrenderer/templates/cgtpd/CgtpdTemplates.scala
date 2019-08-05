import uk.gov.hmrc.hmrcemailrenderer.domain
import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.Cgtpd

object CgtpdTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "cgtpd_email_verification",
      fromAddress = govUkTeamAddress,
      service = Cgtpd,
      subject = "Report and pay Capital Gains Tax on UK property email verification",
      plainTemplate = txt.cgtpdEmailVerification.f,
      htmlTemplate = html.cgtpdEmailVerification.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
