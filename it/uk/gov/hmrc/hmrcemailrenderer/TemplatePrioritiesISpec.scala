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
      ("digitalOptOutConfirmation", Map("recipientName_forename" -> "Ms Jane Doe")),
      ("transactionEngineHMRCSASA100Success", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA100Failure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineECSLORGV101Success", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineECSLORGV101Failure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRAACTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRAACTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRAAPAYESuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRAAPAYEFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRAASASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRAASAFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRCISCIS300MRSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRCISCIS300MRFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRCISVERIFYSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRCISVERIFYFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRCTFANNUALRETURNSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRCTFANNUALRETURNFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEEOYSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEEOYFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEEOYTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEEOYTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEEXBSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEEXBFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEMOVSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEMOVFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEMOVTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEMOVTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEP38ASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEP38AFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEUPDATESuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRPAYEUPDATEFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRSDLTLTRSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineIRSDLTLTRFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEASSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEASFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEASTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEASTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEPSSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEPSFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEPSTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEPSTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEYUSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEYUFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEYUTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIEYUTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIFPSSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIFPSFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIFPSTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTIFPSTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTINVRSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTINVRFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTINVRTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPAYERTINVRTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAACCTTAXSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAACCTTAXFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAADDSCHASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAADDSCHAFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAAMDDETSSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAAMDDETSFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAASSCSASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAASSCSAFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSACOMBINEDREGSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSACOMBINEDREGFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAEVNTREPSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAEVNTREPFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAMAINTSCMSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAMAINTSCMFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSARASSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSARASFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAREGSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSAREGFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSARETSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCPSARETFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800ATTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800ATTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800TILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800TILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800ATTTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800ATTTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800Success", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA800Failure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900ATTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900ATTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900TILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900TILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900ATTTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900ATTTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900Success", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCSASA900Failure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMCENESEDIFACTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMCENESEDIFACTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCVATDECSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCVATDECFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCVATDECTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345")),
      ("transactionEngineHMRCVATDECTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345"))
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
