/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.hmrcemailrenderer

import org.scalactic.source.Position
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import org.scalatestplus.play.{ ServerProvider, WsScalaTestClient }
import play.api.libs.json._
import play.api.libs.ws.WSClient
import play.api.libs.ws.writeableOf_JsValue
import uk.gov.hmrc.play.http.test.ResponseMatchers
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TemplatePrioritiesISpec
    extends AnyWordSpec with Matchers with OptionValues with WsScalaTestClient with GuiceOneServerPerSuite
    with ScalaFutures with ResponseMatchers with ServerProvider with TableDrivenPropertyChecks {

  System.setProperty("auditing.enabled", "false")

  "Rendered templates" should {

    implicit lazy val wsc: WSClient = app.injector.instanceOf[WSClient]
    implicit lazy val pos: Position = Position.here

    forAll(TestTemplates.urgent) { (templateId, params) =>
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

    forAll(TestTemplates.background) { (templateId, params) =>
      s"have correct background priorities for templateId '$templateId'" in {
        val response = wsUrl(s"/templates/$templateId").post(Json.obj("parameters" -> params))
        response should have(
          status(200),
          jsonProperty(__ \ "priority", "urgent")
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
      (
        "apiAddedRegisteredDeveloperAsCollaboratorConfirmation",
        Map(
          "role"            -> "role",
          "applicationName" -> "applicationName"
        )
      ),
      (
        "apiAddedUnregisteredDeveloperAsCollaboratorConfirmation",
        Map(
          "role"             -> "role",
          "applicationName"  -> "applicationName",
          "developerHubLink" -> "/developerHubLink"
        )
      ),
      (
        "apiAddedDeveloperAsCollaboratorConfirmation",
        Map(
          "article"         -> "a",
          "role"            -> "role",
          "applicationName" -> "applicationName"
        )
      ),
      (
        "apiAddedDeveloperAsCollaboratorNotification",
        Map(
          "role"            -> "role",
          "applicationName" -> "applicationName",
          "email"           -> "email@address.com"
        )
      ),
      (
        "apiRemovedCollaboratorConfirmation",
        Map(
          "applicationName" -> "applicationName"
        )
      ),
      (
        "apiRemovedCollaboratorNotification",
        Map(
          "applicationName" -> "applicationName",
          "email"           -> "email@address.com"
        )
      ),
      (
        "apiApplicationApprovedGatekeeperConfirmation",
        Map(
          "applicationName" -> "applicationName",
          "email"           -> "email@address.com"
        )
      ),
      (
        "apiApplicationApprovedAdminConfirmation",
        Map(
          "applicationName"  -> "applicationName",
          "developerHubLink" -> "/developerHubLink"
        )
      ),
      (
        "apiApplicationApprovedNotification",
        Map(
          "applicationName" -> "applicationName"
        )
      ),
      (
        "apiApplicationDeletedNotification",
        Map(
          "applicationName" -> "applicationName",
          "applicationId"   -> "a4e14136-e283-4d79-be01-ebf230873285",
          "requestor"       -> "email@address.com"
        )
      ),
      (
        "apiDeveloperDeletedConfirmation",
        Map(
          "applicationName" -> "applicationName",
          "requestor"       -> "email@address.com"
        )
      ),
      (
        "apiApplicationRejectedNotification",
        Map(
          "applicationName" -> "applicationName",
          "reason"          -> "reason",
          "supportUrl"      -> "supportUrl"
        )
      ),
      (
        "apiNewTermsOfUseInvitation",
        Map(
          "completeBy"      -> "31 March 2023",
          "applicationName" -> "applicationName"
        )
      ),
      (
        "apiNewTermsOfUseConfirmation",
        Map(
          "applicationName" -> "applicationName"
        )
      ),
      (
        "apiVerifyResponsibleIndividual",
        Map(
          "applicationName"           -> "applicationName",
          "developerHubLink"          -> "/developerHubLink",
          "responsibleIndividualName" -> "responsibleIndividualName",
          "requesterName"             -> "requesterName"
        )
      ),
      (
        "apiVerifyResponsibleIndividualUpdate",
        Map(
          "applicationName"           -> "applicationName",
          "developerHubLink"          -> "/developerHubLink",
          "responsibleIndividualName" -> "responsibleIndividualName",
          "requesterName"             -> "requesterName"
        )
      ),
      (
        "apiResponsibleIndividualDeclined",
        Map(
          "applicationName"           -> "applicationName",
          "responsibleIndividualName" -> "responsibleIndividualName",
          "requesterName"             -> "requesterName"
        )
      ),
      (
        "apiResponsibleIndividualDeclinedV2",
        Map(
          "applicationName"           -> "applicationName",
          "responsibleIndividualName" -> "responsibleIndividualName"
        )
      ),
      (
        "apiResponsibleIndividualNotChanged",
        Map(
          "applicationName"           -> "applicationName",
          "responsibleIndividualName" -> "responsibleIndividualName"
        )
      ),
      (
        "apiChangeOfApplicationName",
        Map(
          "previousApplicationName" -> "Old Application Name",
          "newApplicationName"      -> "New Application Name",
          "requesterName"           -> "Bob Roberts"
        )
      ),
      (
        "apiChangeOfApplicationDetails",
        Map(
          "applicationName" -> "Nexus 6",
          "fieldName"       -> "application description",
          "previousValue"   -> "old description of what the application is and does",
          "newValue"        -> "new much better description of what the application is and does",
          "requesterName"   -> "Bob Roberts"
        )
      ),
      (
        "apiChangeOfApplicationDetailsNoValue",
        Map(
          "applicationName" -> "Nexus 6",
          "fieldName"       -> "privacy policy URL",
          "requesterName"   -> "Bob Roberts"
        )
      ),
      (
        "apiChangeOfResponsibleIndividual",
        Map(
          "applicationName"               -> "Nexus 6",
          "previousResponsibleIndividual" -> "Donald Trump",
          "newResponsibleIndividual"      -> "Joe Biden",
          "requesterName"                 -> "Bob Roberts"
        )
      ),
      ("apiDeveloperEmailVerification", Map("verificationLink" -> "/abc", "recipientName_forename" -> "Ms Jane Doe")),
      ("apiDeveloperChangedPasswordConfirmation", Map[String, String]()),
      ("apiDeveloperPasswordReset", Map("resetPasswordLink" -> "/reset")),
      (
        "apiAddedRegisteredMemberToOrganisationConfirmation",
        Map(
          "organisationName" -> "Organisation Name",
          "sdstEmailAddress" -> "SDSTeam@hmrc.gov.uk"
        )
      ),
      (
        "apiAddedUnregisteredMemberToOrganisationConfirmation",
        Map(
          "organisationName" -> "Organisation Name",
          "sdstEmailAddress" -> "SDSTeam@hmrc.gov.uk"
        )
      ),
      (
        "apiAddedMemberToOrganisationNotification",
        Map(
          "organisationName" -> "Organisation Name",
          "emailAddress"     -> "test.person@hmrc.gov.uk",
          "role"             -> "Admin"
        )
      ),
      (
        "apiRemovedMemberFromOrganisationConfirmation",
        Map(
          "organisationName" -> "Organisation Name"
        )
      ),
      (
        "apiRemovedMemberFromOrganisationNotification",
        Map(
          "organisationName" -> "Organisation Name",
          "emailAddress"     -> "test.person@hmrc.gov.uk",
          "role"             -> "Admin"
        )
      ),
      (
        "transactionEngineHMRCSASA100Success",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA100Failure",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA100ATTSuccess",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA100ATTFailure",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA100ATTTILSuccess",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA100ATTTILFailure",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA100TILSuccess",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA100TILFailure",
        Map("identifier" -> "1234567890", "receivedDate" -> "01/01/01", "subject" -> "subject")
      ),
      ("digitalOptOutConfirmation", Map("recipientName_forename" -> "Ms Jane Doe")),
      (
        "transactionEngineECSLORGV101Success",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineECSLORGV101Failure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRAACTSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRAACTFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRAAPAYESuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRAAPAYEFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRAASASuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRAASAFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRCISCIS300MRSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRCISCIS300MRFailure",
        Map(
          "errorType"      -> "business",
          "receivedTime"   -> "21:45",
          "receivedDate"   -> "20 April 2017",
          "identifier"     -> "12345",
          "subject"        -> "subject",
          "errorTextBlock" -> "Error Code: 123 Error Message: Business Error Message",
          "errorHtmlBlock" -> "<p>Error Code: 123 Error Message: Business Error Message</p>",
          "errorNumber"    -> "1001",
          "errorMessage"   -> "Fatal Error Message"
        )
      ),
      (
        "transactionEngineIRCISVERIFYSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRCTFANNUALRETURNSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRCTFANNUALRETURNFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEEOYSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEEOYFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEEOYTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEEOYTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEEXBSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEEXBFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEMOVSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEMOVFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEMOVTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEMOVTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEP38ASuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEP38AFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEUPDATESuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRPAYEUPDATEFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRSDLTLTRSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineIRSDLTLTRFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEASSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEASFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEASTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEASTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEPSSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEPSFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEPSTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEPSTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEYUSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEYUFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEYUTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIEYUTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIFPSSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIFPSFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIFPSTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTIFPSTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTINVRSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTINVRFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTINVRTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPAYERTINVRTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAACCTTAXSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAACCTTAXFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAADDSCHASuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAADDSCHAFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAAMDDETSSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAAMDDETSFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAASSCSASuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAASSCSAFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSACOMBINEDREGSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSACOMBINEDREGFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAEVNTREPSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAEVNTREPFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAMAINTSCMSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAMAINTSCMFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSARASSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSARASFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAREGSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSAREGFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSARETSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCPSARETFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800ATTSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800ATTFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800TILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800TILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800ATTTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800ATTTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800Success",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA800Failure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900ATTSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900ATTFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900TILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900TILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900ATTTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900ATTTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900Success",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCSASA900Failure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMCENESEDIFACTSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMCENESEDIFACTFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCVATDECSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCVATDECFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCVATDECTILSuccess",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "transactionEngineHMRCVATDECTILFailure",
        Map("receivedDate" -> "01/01/01", "identifier" -> "12345", "subject" -> "subject")
      ),
      (
        "emac_helpdesk_failure_confirmation_email",
        Map(
          "service_name"   -> "Self Assessment (SA)",
          "full_name"      -> "Troy Barnes",
          "correlation_id" -> "H5JK4ITURY84783HJ345HJ345HJ342N3"
        )
      ),
      (
        "emac_helpdesk_successful_confirmation_email",
        Map(
          "service_name"   -> "Alcohol and Tobacco Warehousing Declarations (ATWD)",
          "full_name"      -> "Abed Nadir",
          "correlation_id" -> "HJ345HJ345HJ342N3H5JK4ITURY84783"
        )
      ),
      ("cbcr_subscription", Map("f_name" -> "Tyrion", "s_name" -> "Lannister", "cbcrId" -> "XGCBC0000000001")),
      (
        "cbcr_report_confirmation",
        Map(
          "name"        -> "Tyrion Lannister",
          "received_at" -> "31 December 2017",
          "hash"        -> "6753c4e3bf192b0f9881ceb2d822a75e1b618269fbdb44112d35a10b1987f6"
        )
      ),
      (
        "cbcr_cbcid_regeneration",
        Map(
          "f_name"      -> "Tyrion",
          "s_name"      -> "Lannister",
          "received_at" -> "31 December 2017",
          "cbcrId"      -> "XGCBC0000000001"
        )
      ),
      ("mtdfb_vat_principal_sign_up_successful", Map("vatNumber" -> "123456782")),
      ("mtdfb_vat_principal_sign_up_failure", Map.empty),
      ("mtdfb_vat_agent_sign_up_successful", Map("vatNumber" -> "123456782")),
      ("discounted_dining_payment_sent", Map("claimRefNo" -> "1234")),
      ("discounted_dining_payment_sent_cy", Map("claimRefNo" -> "1234"))
    )

    val background = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("newMessageAlert_SA316", Map.empty),
      ("annual_tax_summaries_message_alert", Map("taxYear" -> "2016"))
    )

    val standard = Table[String, Map[String, String]](
      ("templateIds", "params"),
      ("newMessageAlert", Map("recipientName_forename" -> "Ms Jane Doe")),
      (
        "verificationReminder",
        Map[String, String]("verificationLink" -> "/abc", "recipientName_forename" -> "Ms Jane Doe")
      ),
      (
        "newMessageAlert_SS300",
        Map("recipientName_forename" -> "Ms Jane Doe")
      ), // DC-839: move from Background because of SA316
      (
        "newMessageAlert_SA300",
        Map("recipientName_forename" -> "Ms Jane Doe")
      ), // DC-839: move from Background because of SA316
      (
        "newMessageAlert_SA309",
        Map("recipientName_forename" -> "Ms Jane Doe")
      ), // DC-839: move from Background because of SA316
      ("tax_estimate_message_alert", Map("fullName" -> "myName"))
    )
  }

}
