package uk.gov.hmrc.email.templates.fandf

import uk.gov.hmrc.email.services.BodyTemplate.Subject
import uk.gov.hmrc.email.services.SimpleMessageTemplate
import uk.gov.hmrc.email.templates.Regime.FriendsAndFamily
import uk.gov.hmrc.email.templates._
import uk.gov.hmrc.email.services.BodyTemplate.Params

object FandFTemplates extends TemplateGroup with HmrcTemplate {
  val title = "FANDF"

  private def ask_help_subject(params : Params) =
    params.get("helpeeFirstName").flatMap(fname => params.get("helpeeLastName").map(lname => s"$fname $lname " )).getOrElse("Someone ") +"would like your help with tax online"

  private def offer_help_subject(params : Params) =
    params.get("helperFirstName").flatMap(fname => params.get("helperLastName").map(lname => s"$fname $lname " )).getOrElse("Someone ") +"wants to help you with your tax online"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "fandf_ask_help_notification",
      regime = FriendsAndFamily,
      subject = Subject(ask_help_subject),
      plainTemplate = txt.newFandFAskHelpMessageAlert.apply,
      htmlTemplate = html.newFandFAskHelpMessageAlert.apply,
      fromAddress = trustedHelpersTeamAddress),
    SimpleMessageTemplate(
      id = "fandf_offer_help_notification",
      regime = FriendsAndFamily,
      subject = Subject(offer_help_subject),
      plainTemplate = txt.newFandFOfferHelpMessageAlert.apply,
      htmlTemplate = html.newFandFOfferHelpMessageAlert.apply,
      fromAddress = trustedHelpersTeamAddress)
  )
}
