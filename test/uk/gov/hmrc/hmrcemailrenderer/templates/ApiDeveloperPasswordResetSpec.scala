package uk.gov.hmrc.hmrcemailrenderer.templates

import junit.framework.TestCase
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}

class ApiDeveloperPasswordResetSpec extends PlaySpec with OneAppPerTest {

  val resetPasswordLink = "http://reset.password.com"
  val developerHubTitle = "Developer Hub Title"

  val templateParams = Map("developerHubTitle" -> developerHubTitle, "resetPasswordLink" -> resetPasswordLink,
    "staticAssetUrlPrefix" -> "http://uri", "staticAssetVersion" -> "v1")

  "htmlView" must {
    "render as" in new TestCase {
      val renderedHtml = api.html.passwordResetEmail.render(templateParams)
      renderedHtml.contentType must include("text/html")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">" +
                                     "Click on the link below to reset your password for the HMRC " + developerHubTitle + ".</p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">" +
                                     "<a href=\"" + resetPasswordLink + "\" style=\"color: #005EA5;\">" +
                                     resetPasswordLink + "</a> </p>")
      renderedHtml.body must include("<p style=\"margin: 0 0 30px; font-size: 19px;\">From HMRC " + developerHubTitle + "</p>")
    }

    "textView" must {
      "render as" in new TestCase {
        val renderedTxt = api.txt.passwordResetEmail.render(templateParams)
        renderedTxt.contentType must include("text/plain")
        renderedTxt.body must include("Click on the link below to reset your password for the HMRC " + developerHubTitle + ".")
        renderedTxt.body must include(resetPasswordLink)
        renderedTxt.body must include("From HMRC " + developerHubTitle)
      }
    }
  }
}
