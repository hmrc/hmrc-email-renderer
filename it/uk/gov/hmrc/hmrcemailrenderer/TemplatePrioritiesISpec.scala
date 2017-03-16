package uk.gov.hmrc.hmrcemailrenderer

import org.scalatest.concurrent.ScalaFutures
import play.api.libs.ws.WS
import uk.gov.hmrc.play.http.test.ResponseMatchers
import uk.gov.hmrc.play.it.{ExternalService, MicroServiceEmbeddedServer, ServiceSpec}
import uk.gov.hmrc.play.test.WithFakeApplication
import play.api.libs.json._
import play.api.Play.current
import org.scalatest.prop.TableDrivenPropertyChecks

class TemplatePrioritiesISpec extends ServiceSpec
  with WithFakeApplication
  with ScalaFutures
  with ResponseMatchers
  with TableDrivenPropertyChecks {

  "Rendered templates" should {

    forAll(TestTemplates.urgent) {
      (templateId, params) =>
        s"have correct urgent priorities for templateId '$templateId'" in {
          val response = WS.url(resource(s"/templates/$templateId")).post(Json.obj("parameters" -> params))
          response should have(
            status(200),
            jsonProperty(__ \ "priority", "urgent")
          )
        }
    }

    forAll(TestTemplates.standard) { (templateId, params) =>
      s"not supply a priority for templateId '$templateId'" in {
        val response = WS.url(resource(s"/templates/$templateId")).post(Json.obj("parameters" -> params)).futureValue
        response.status shouldBe 200
        (response.json \ "priority").asOpt[String] shouldBe None
      }
    }

    forAll(TestTemplates.background) {
      (templateId, params) =>
        s"have correct background priorities for templateId '$templateId'" in {
          val response = WS.url(resource(s"/templates/$templateId")).post(Json.obj("parameters" -> params))
          response should have(
            status(200),
            jsonProperty(__ \ "priority", "background")
          )
        }
    }
  }

  override protected val server = new TestServer()

  class TestServer(override val testName: String = "RendererControllerISpec") extends MicroServiceEmbeddedServer {
    override protected val externalServices: Seq[ExternalService] = Seq.empty
  }

  object TestTemplates {

    val urgent = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("verifyEmailAddress", Map("verificationLink" -> "/abc")),
      ("changeOfEmailAddress", Map[String, String]()),
      ("changeOfEmailAddressNewAddress", Map("verificationLink" -> "/abc")),
      ("generic_access_invitation_template_id", Map("verificationLink" -> "/abc")),
      ("cato_access_invitation_template_id", Map("verificationLink" -> "/abc")),
      ("apiApplicationApprovedAdminConfirmation", Map(
        "applicationName" -> "applicationName",
        "developerHubLink" -> "/developerHubLink"
      )),
      ("apiAddedRegisteredDeveloperAsCollaboratorConfirmation", Map(
        "role" -> "role",
        "applicationName" -> "applicationName"
      )),
      ("apiDeveloperEmailVerification", Map("verificationLink" -> "/abc")),
      ("apiAddedUnregisteredDeveloperAsCollaboratorConfirmation", Map(
        "role" -> "role",
        "applicationName" -> "applicationName",
        "developerHubLink" -> "/developerHubLink"
      )),
      ("apiApplicationRejectedNotification", Map(
        "applicationName" -> "applicationName",
        "reason" -> "reason",
        "guidelinesUrl" -> "guidelinesUrl"
      )),
      ("apiDeveloperPasswordReset", Map("resetPasswordLink" -> "/reset"))
    )

    val background = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("newMessageAlert_SA316", Map[String, String]()),
      ("annual_tax_summaries_message_alert", Map("taxYear" -> "2016"))
    )

    val standard = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("newMessageAlert", Map[String, String]()),
      ("verificationReminder", Map[String, String]("verificationLink" -> "/abc")),
      ("newMessageAlert_SS300", Map[String, String]()),                                      // DC-839: Moved to standard because of SA316.
      ("newMessageAlert_SA300", Map[String, String]()),                                      // DC-839: Moved to standard because of SA316.
      ("newMessageAlert_SA309", Map[String, String]()),                                      // DC-839: Moved to standard because of SA316.
      ("tax_estimate_message_alert", Map[String, String]("fullName" -> "Mr Joe Bloggs")),    // DC-839: Moved to standard because of SA316.
      ("digitalOptOutConfirmation", Map[String, String]()),
      ("apiAddedDeveloperAsCollaboratorNotification", Map(
        "role" -> "role",
        "applicationName" -> "applicationName",
        "email" -> "email@address.com"
      )),
      ("apiRemovedCollaboratorConfirmation", Map(
        "applicationName" -> "applicationName"
      )),
      ("apiDeveloperChangedPasswordConfirmation", Map[String, String]()),
      ("apiApplicationApprovedGatekeeperConfirmation", Map(
        "applicationName" -> "applicationName",
        "email" -> "email@address.com"
      )),
      ("apiApplicationApprovedNotification", Map(
        "applicationName" -> "applicationName"
      )),
      ("apiRemovedCollaboratorNotification", Map(
        "applicationName" -> "applicationName",
        "email" -> "email@address.com"
      ))
    )
  }
}
