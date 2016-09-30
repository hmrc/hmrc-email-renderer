package uk.gov.hmrc.hmrcemailrenderer

import org.scalatest.concurrent.ScalaFutures
import play.api.libs.json.Json
import play.api.libs.ws.WS
import uk.gov.hmrc.play.it._
import uk.gov.hmrc.play.test.WithFakeApplication

class RendererControllerISpec extends ServiceSpec with WithFakeApplication with ScalaFutures {

  import play.api.Play.current

  "The controller" should {

    "render the verifyEmailAddress template" in {

      val response = WS.url(resource(s"/templates/verifyEmailAddress"))
        .post(Json.obj("parameters" -> Map("verificationLink" -> "/abc"))).futureValue
      response.status shouldBe 200
      response.body should include ("Verify your email address")
      response.body should include ("/abc")
    }
  }


  override protected val server = new TestServer()

  class TestServer(override val testName: String = "RendererControllerISpec") extends MicroServiceEmbeddedServer {
    override protected val externalServices: Seq[ExternalService] = Seq.empty
  }

}
