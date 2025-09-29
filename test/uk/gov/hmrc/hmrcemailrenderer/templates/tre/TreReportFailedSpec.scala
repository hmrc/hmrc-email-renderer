package uk.gov.hmrc.hmrcemailrenderer.templates.tre

import org.scalatestplus.play.PlaySpec
import uk.gov.hmrc.hmrcemailrenderer.domain.{ MessagePriority, MessageTemplate }
import uk.gov.hmrc.hmrcemailrenderer.templates.CommonParamsForSpec
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier.TradeReportingExtracts

class TreReportFailedSpec extends PlaySpec with CommonParamsForSpec {

  val treReportFaield: MessageTemplate = MessageTemplate.create(
    templateId = "tre_report_failed",
    fromAddress = "Trade Reporting Extracts <noreply@confirmation.tax.service.gov.uk",
    service = TradeReportingExtracts,
    subject = "There is a problem with your CDS report",
    plainTemplate = txt.treReportFailed.f,
    htmlTemplate = html.treReportFailed.f,
    priority = Some(MessagePriority.Urgent)
  )

  val params: Map[String, String] = Map(
    "reportRequestId" -> "XXXXX678"
  )

  "tre_report_failed" must {

    "include correct subject" in {
      treReportFaield.subject(commonParameters) mustBe "There is a problem with your CDS report"
    }

    "include htmlTemplate body and footer" in {
      val htmlContent = treReportFaield.htmlTemplate(commonParameters ++ params).toString
      htmlContent must include("Dear customer")
      htmlContent must include("We could not complete the CSD report XXXXX678 because of an error.")
      htmlContent must include("What you need to do next")
      htmlContent must include("Go to GOV.UK.")
      htmlContent must include("Search for 'Get customs declaration data for imports and exports'.")
      htmlContent must include("Log in to your account.")
      htmlContent must include(
        "Select 'Requested reports' in the reports section of your dashboard to view details of the error."
      )
      htmlContent must include("From the HMRC Customs declaration data team")
    }
  }
}
