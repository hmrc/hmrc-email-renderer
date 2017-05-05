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
      ("transactionEngineHMRCSASA100Success", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")),
      ("transactionEngineHMRCSASA100Failure", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")),
      ("transactionEngineHMRCSASA100ATTSuccess", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")),
      ("transactionEngineHMRCSASA100ATTFailure", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")),
      ("transactionEngineHMRCSASA100ATTTILSuccess", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")),
      ("transactionEngineHMRCSASA100ATTTILFailure", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")),
      ("transactionEngineHMRCSASA100TILSuccess", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")),
      ("transactionEngineHMRCSASA100TILFailure", Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01","subject" -> "subject")),
      ("digitalOptOutConfirmation", Map("recipientName_forename" -> "Ms Jane Doe")),
      ("transactionEngineECSLORGV101Success", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineECSLORGV101Failure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRAACTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRAACTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRAAPAYESuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRAAPAYEFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRAASASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRAASAFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRCISCIS300MRSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRCISCIS300MRFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRCISVERIFYSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRCISVERIFYFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRCTFANNUALRETURNSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRCTFANNUALRETURNFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEEOYSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEEOYFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEEOYTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEEOYTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEEXBSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEEXBFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEMOVSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEMOVFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEMOVTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEMOVTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEP38ASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEP38AFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEUPDATESuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRPAYEUPDATEFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRSDLTLTRSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineIRSDLTLTRFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEASSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEASFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEASTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEASTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEPSSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEPSFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEPSTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEPSTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEYUSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEYUFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEYUTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIEYUTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIFPSSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIFPSFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIFPSTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTIFPSTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTINVRSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTINVRFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTINVRTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPAYERTINVRTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAACCTTAXSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAACCTTAXFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAADDSCHASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAADDSCHAFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAAMDDETSSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAAMDDETSFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAASSCSASuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAASSCSAFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSACOMBINEDREGSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSACOMBINEDREGFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAEVNTREPSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAEVNTREPFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAMAINTSCMSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAMAINTSCMFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSARASSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSARASFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAREGSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSAREGFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSARETSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCPSARETFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800ATTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800ATTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800TILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800TILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800ATTTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800ATTTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800Success", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA800Failure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900ATTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900ATTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900TILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900TILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900ATTTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900ATTTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900Success", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCSASA900Failure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMCENESEDIFACTSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMCENESEDIFACTFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCVATDECSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCVATDECFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCVATDECTILSuccess", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject")),
      ("transactionEngineHMRCVATDECTILFailure", Map("receivedDate" -> "01/01/01","identifier" -> "12345","subject" -> "subject"))
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
