package uk.gov.hmrc.hmrcemailrenderer

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatestplus.play.{OneServerPerSuite, ServerProvider, WsScalaTestClient}
import play.api.libs.json._
import uk.gov.hmrc.play.config.ServicesConfig
import uk.gov.hmrc.play.http.test.ResponseMatchers
import uk.gov.hmrc.play.test.UnitSpec

class TemplatePrioritiesISpec extends UnitSpec
  with ServicesConfig
  with WsScalaTestClient
  with OneServerPerSuite
  with ScalaFutures
  with ResponseMatchers
  with ServerProvider
  with TableDrivenPropertyChecks {

  "Rendered templates" should {

    forAll(TestTemplates.urgent) {
      (templateId, params) =>
        s"have correct urgent priorities for templateId '$templateId'" in {
          val response = wsUrl(s"/templates/$templateId").post(Json.obj("parameters" -> params))
          response should have(
            status(200),
            jsonProperty(__ \ "priority", "urgent")
          )
        }
    }

    forAll(TestTemplates.standard) { (templateId, params) =>
      s"not supply a priority for templateId '$templateId'" in {
        val response = wsUrl(s"/templates/$templateId").post(Json.obj("parameters" -> params)).futureValue
        response.status shouldBe 200
        (response.json \ "priority").asOpt[String] shouldBe None
      }
    }

    forAll(TestTemplates.background) {
      (templateId, params) =>
        s"have correct background priorities for templateId '$templateId'" in {
          val response = wsUrl(s"/templates/$templateId").post(Json.obj("parameters" -> params))
          response should have(
            status(200),
            jsonProperty(__ \ "priority", "background")
          )
        }
    }
  }


  object TestTemplates {

    val urgent = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("verifyEmailAddress", Map("verificationLink" -> "/abc", "recipientName_forename" -> "Ms Jane Doe")),
      ("changeOfEmailAddress", Map("recipientName_forename" -> "Ms Jane Doe")),
      ("changeOfEmailAddressNewAddress", Map("verificationLink" -> "/abc", "recipientName_forename" -> "Ms Jane Doe")),
      ("generic_access_invitation_template_id", Map("verificationLink" -> "/abc")),
      ("cato_access_invitation_template_id", Map("verificationLink" -> "/abc")),
      ("apiAddedRegisteredDeveloperAsCollaboratorConfirmation", Map(
        "role" -> "role",
        "applicationName" -> "applicationName"
      )),
      ("apiAddedUnregisteredDeveloperAsCollaboratorConfirmation", Map(
        "role" -> "role",
        "applicationName" -> "applicationName",
        "developerHubLink" -> "/developerHubLink"
      )),
      ("apiAddedDeveloperAsCollaboratorNotification", Map(
        "role" -> "role",
        "applicationName" -> "applicationName",
        "email" -> "email@address.com"
      )),
      ("apiRemovedCollaboratorConfirmation", Map(
        "applicationName" -> "applicationName"
      )),
      ("apiRemovedCollaboratorNotification", Map(
        "applicationName" -> "applicationName",
        "email" -> "email@address.com"
      )),
      ("apiApplicationApprovedGatekeeperConfirmation", Map(
        "applicationName" -> "applicationName",
        "email" -> "email@address.com"
      )),
      ("apiApplicationApprovedAdminConfirmation", Map(
        "applicationName" -> "applicationName",
        "developerHubLink" -> "/developerHubLink"
      )),
      ("apiApplicationApprovedNotification", Map(
        "applicationName" -> "applicationName"
      )),
      ("apiApplicationRejectedNotification", Map(
        "applicationName" -> "applicationName",
        "reason" -> "reason",
        "guidelinesUrl" -> "guidelinesUrl"
      )),
      ("apiDeveloperEmailVerification", Map("verificationLink" -> "/abc", "recipientName_forename" -> "Ms Jane Doe")),
      ("apiDeveloperChangedPasswordConfirmation", Map[String, String]()),
      ("apiDeveloperPasswordReset", Map("resetPasswordLink" -> "/reset")),
      ("transactionEngineHMRCSASA100Success", Map("sentDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100Failure", Map("sentDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100Success", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100Failure", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100ATTSuccess", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100ATTFailure", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100ATTTILSuccess", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100ATTTILFailure", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100TILSuccess", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("transactionEngineHMRCSASA100TILFailure", Map("idenitifer" -> "1234567890", "receivedDate" -> "01/01/01")),
      ("digitalOptOutConfirmation", Map("recipientName_forename" -> "Ms Jane Doe"))
    )

    val background = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("newMessageAlert_SA316", Map.empty),
      ("annual_tax_summaries_message_alert", Map("taxYear" -> "2016"))
    )

    val standard = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("newMessageAlert", Map("recipientName_forename" -> "Ms Jane Doe")),
      ("verificationReminder", Map[String, String]("verificationLink" -> "/abc", "recipientName_forename" -> "Ms Jane Doe")),
      ("newMessageAlert_SS300", Map("recipientName_forename" -> "Ms Jane Doe")),                               // DC-839: move from Background because of SA316
      ("newMessageAlert_SA300", Map("recipientName_forename" -> "Ms Jane Doe")),                               // DC-839: move from Background because of SA316
      ("newMessageAlert_SA309", Map("recipientName_forename" -> "Ms Jane Doe")),                               // DC-839: move from Background because of SA316
      ("tax_estimate_message_alert", Map("fullName" -> "myName"))         // DC-839: move from Background because of SA316
    )
  }
}
