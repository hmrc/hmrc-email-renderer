package uk.gov.hmrc.hmrcemailrenderer.templates.hec

import uk.gov.hmrc.hmrcemailrenderer.templates.FromAddress.govUkTeamAddress
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.HEC

object HecTemplates {
  val templates = Seq(
    MessageTemplate.create(
      templateId = "hec_tax_check_code",
      fromAddress = govUkTeamAddress,
      service = HEC,
      subject = "Your tax check code confirmation",
      plainTemplate = txt.hecTaxCheckCode.f,
      htmlTemplate = html.hecTaxCheckCode.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}