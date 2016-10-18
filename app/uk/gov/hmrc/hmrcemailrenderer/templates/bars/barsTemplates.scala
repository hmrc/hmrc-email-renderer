package uk.gov.hmrc.email.templates.bars

import uk.gov.hmrc.email.services.BodyTemplate._
import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates._
import Regime.BusinessRates

object BarsTemplates extends TemplateGroup with GovUkTemplate {
  val title = "BARS"

  private def getBARefCode(params : Params) =
    params.get("baRefNumber").getOrElse("No BA CODE") + ""


  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "bars_alert",
      regime = BusinessRates,
      subject = Subject(getBARefCode),
      plainTemplate = txt.bars.apply,
      htmlTemplate = html.bars.apply,
      fromAddress = "Business Rates <noreply@tax.service.gov.uk>")
  )
}



