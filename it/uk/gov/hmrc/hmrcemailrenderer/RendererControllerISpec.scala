package uk.gov.hmrc.hmrcemailrenderer

import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.{OneServerPerSuite, ServerProvider, WsScalaTestClient}
import play.api.libs.json._
import uk.gov.hmrc.play.config.ServicesConfig
import uk.gov.hmrc.play.http.test.ResponseMatchers
import uk.gov.hmrc.play.test.UnitSpec

class RendererControllerISpec extends UnitSpec
  with ServicesConfig
  with WsScalaTestClient
  with OneServerPerSuite
  with ScalaFutures
  with ResponseMatchers
  with ServerProvider {
  "POST /templates/:templateId" should {
    "return 200 and yield the rendered template data when supplied a valid templateId" in {
      val params = Map(
        "verificationLink" -> "/abc"
      )

      val response = wsUrl(s"/templates/verifyEmailAddress").post(Json.obj("parameters" -> params))
      response should have(
        status(200),
        jsonProperty(__ \ "fromAddress", "HMRC paperless <noreply@tax.service.gov.uk>"),
        jsonProperty(__ \ "subject", "HMRC paperless notifications: verify your email address"),
        jsonProperty(__ \ "service", "sa"),
        jsonProperty(__ \ "plain"),
        jsonProperty(__ \ "html")
      )
    }

    "return 404 when a non-existent templateId is specified on the path" in {
      wsUrl(s"/templates/nonExistentTemplateId").
        post(Json.obj("parameters" -> Map.empty[String, String])) should have(status(404))
    }

    "return 400 and indicate the first point of failure when the parameters for the template are not supplied" in {
      wsUrl(s"/templates/verifyEmailAddress")
        .post(Json.obj("parameters" -> Map.empty[String, String])) should have(
        status(400),
        jsonProperty(__ \ "reason", "key not found: verificationLink")
      )
    }
  }

}
