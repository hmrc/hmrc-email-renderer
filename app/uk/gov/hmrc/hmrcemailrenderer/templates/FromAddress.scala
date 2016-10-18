package uk.gov.hmrc.hmrcemailrenderer.templates

object FromAddress {
  def noReply(name: String): String = s"$name <noreply@tax.service.gov.uk>"

  lazy val govUkTeamAddress = noReply("Gov.uk Team")
}
