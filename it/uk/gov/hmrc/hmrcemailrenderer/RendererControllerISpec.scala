package uk.gov.hmrc.hmrcemailrenderer

import org.scalatest.concurrent.ScalaFutures
import play.api.Play.current
import play.api.libs.json._
import play.api.libs.ws.WS
import uk.gov.hmrc.play.http.test.ResponseMatchers
import uk.gov.hmrc.play.it._
import uk.gov.hmrc.play.test.WithFakeApplication

class RendererControllerISpec extends ServiceSpec with WithFakeApplication with ScalaFutures with ResponseMatchers {
  "POST /templates/:templateId" should {
    "return 200 and yield the rendered template data when supplied a valid templateId" in {
      val params = Map(
        "verificationLink" -> "/abc"
      )

      val response = WS.url(resource(s"/templates/verifyEmailAddress")).post(Json.obj("parameters" -> params))
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
      WS.url(resource(s"/templates/nonExistentTemplateId")).
        post(Json.obj("parameters" -> Map.empty[String, String])) should have(status(404))
    }

    "return 400 and indicate the first point of failure when the parameters for the template are not supplied" in {
      WS.url(resource(s"/templates/verifyEmailAddress"))
        .post(Json.obj("parameters" -> Map.empty[String, String])) should have(
        status(400),
        jsonProperty(__ \ "reason", "key not found: verificationLink")
      )
    }
  }

  override protected val server = new TestServer()

  class TestServer(override val testName: String = "RendererControllerISpec") extends MicroServiceEmbeddedServer {
    override protected val externalServices: Seq[ExternalService] = Seq.empty
  }

}
