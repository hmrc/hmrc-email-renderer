package uk.gov.hmrc.email.templates.ats

import uk.gov.hmrc.email.services.BodyTemplate.{Params, Subject}
import uk.gov.hmrc.email.services.{MissingTemplateParameterException, SimpleMessageTemplate}
import uk.gov.hmrc.email.templates.{TemplateGroup, GovUkTemplate}
import uk.gov.hmrc.email.templates.Regime.AnnualTaxSummary

object AtsTemplates extends TemplateGroup with GovUkTemplate {
  val title = "ATS"

  private def ats_year_for_subject(params : Params) =
    params.get("taxYear").map(year => s"Your Annual Tax Summary for $year is now ready").getOrElse(throw new MissingTemplateParameterException("taxYear"))

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "annual_tax_summaries_message_alert",
      regime = AnnualTaxSummary,
      subject = Subject(ats_year_for_subject),
      plainTemplate = txt.annualTaxSummariesMessageAlert.apply,
      htmlTemplate = html.annualTaxSummariesMessageAlert.apply,
      fromAddress = " HMRC Your Annual Tax Summary <noreply@tax.service.gov.uk>")
  )
}
