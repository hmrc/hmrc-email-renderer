/*
 * Copyright 2018 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates

sealed trait ServiceIdentifier extends Product with Serializable {
  def name: String
}
object ServiceIdentifier {
  case object Agent extends ServiceIdentifier { override val name = "agent" }
  case object AgentOptInExclude extends ServiceIdentifier { override val name = "agent-optin-exclude" }
  case object AgentOptInRejoin extends ServiceIdentifier { override val name = "agent-optin-rejoin" }
  case object AlcoholWholesalerRegistrationScheme extends ServiceIdentifier { override val name = "awrs" }
  case object AntiMoneyLaunderingSupervision extends ServiceIdentifier { override val name = "amls" }
  case object AnnualTaxSummary extends ServiceIdentifier { override val name = "ats" }
  case object ApiDeveloperHub extends ServiceIdentifier { override val name = "api" }
  case object BusinessRates extends ServiceIdentifier { override val name = "bars" }
  case object Charities extends ServiceIdentifier { override val name = "charities" }
  case object Childcare extends ServiceIdentifier { override val name = "cc" }
  case object CompanyAccountsTaxOnline extends ServiceIdentifier { override val name = "cato" }
  case object CorporationTax extends ServiceIdentifier { override val name  = "ct" }
  case object DigitalFormsService extends ServiceIdentifier { override val name = "dfs" }
  case object Eeitt extends ServiceIdentifier {override val name = "eeitt"}
  case object Fhdds extends ServiceIdentifier {override val name = "fhdds"}
  case object FriendsAndFamily extends ServiceIdentifier { override val name = "fandf" }
  case object GovernmentGateway extends ServiceIdentifier { override val name = "gg" }
  case object GuaranteedMinimumPension extends ServiceIdentifier { override val name = "gmp" }
  case object Generic extends ServiceIdentifier { override val name = "generic" }
  case object InheritanceTax extends ServiceIdentifier { override val name = "iht" }
  case object PayAsYouEarn extends ServiceIdentifier { override val name = "paye" }
  case object PensionSchemesforPractitioners extends ServiceIdentifier { override val name  = "pp" }
  case object RegisterYourCompany extends ServiceIdentifier { override val name = "register-your-company" }
  case object RentalAndLeaseDetails extends ServiceIdentifier { override val name = "rald" }
  case object SecurityConsole extends ServiceIdentifier { override val name = "security-console" }
  case object SelfAssessment extends ServiceIdentifier { override val name  = "sa" }
  case object TaxAdvantagedVentureCapital extends ServiceIdentifier { override val name = "tavc" }
  case object TaxAllowanceForMarriedCouples extends ServiceIdentifier { override val name = "tamc" }
  case object TaxCreditsService extends ServiceIdentifier { override val name = "tcs" }
  case object Mandate extends ServiceIdentifier { override val name = "agent-client-mandate" }
  case object OffPayroll extends ServiceIdentifier { override val name = "off-payroll" }
  case object Customs extends ServiceIdentifier { override val name = "cds" }
  case object AgentAuthorisation extends ServiceIdentifier { override val name = "aa" }
  case object ConstructionIndustryScheme extends ServiceIdentifier { override val name = "cis" }
  case object ChildTrustFund extends ServiceIdentifier { override val name = "ctf" }
  case object StampDutyLandTaxOnlineForOrganisations extends ServiceIdentifier { override val name = "sdlt" }
  case object EmployerAlignmentSubmission extends ServiceIdentifier { override val name = "eas" }
  case object EmployerPaymentSummarySubmission extends ServiceIdentifier { override val name = "eps" }
  case object EarlierYearUpdateSubmission extends ServiceIdentifier { override val name = "eyu" }
  case object FullPaymentSubmission extends ServiceIdentifier { override val name = "fps" }
  case object NINOVerificationRequest extends ServiceIdentifier { override val name = "nvr" }
  case object AccountingForTax extends ServiceIdentifier { override val name = "act" }
  case object AddSchemeAdministrator extends ServiceIdentifier { override val name = "add" }
  case object PensionSchemeAmendment extends ServiceIdentifier { override val name = "amd" }
  case object PensionSchemeAssociation extends ServiceIdentifier { override val name = "ass" }
  case object CombinedRegistration extends ServiceIdentifier { override val name = "combined" }
  case object PensionSchemeEvent extends ServiceIdentifier { override val name = "evnt" }
  case object AmendSchemeDetails extends ServiceIdentifier { override val name = "maint" }
  case object ProvideReliefAtSourceRepaymentDetails extends ServiceIdentifier { override val name = "ras" }
  case object PensionSchemeRegistration extends ServiceIdentifier { override val name = "reg" }
  case object PensionSchemeReturn extends ServiceIdentifier { override val name = "ret" }
  case object PensionSchemePractitioners extends ServiceIdentifier { override val name = "prac" }
  case object VATECSalesList extends ServiceIdentifier { override val name = "ecsl" }
  case object NewExportSystem extends ServiceIdentifier { override val name = "nes" }
  case object SubmitVATReturns extends ServiceIdentifier { override val name = "vat" }
  case object Ated extends ServiceIdentifier { override val name = "ated" }
  case object InvestmentTaxRelief extends ServiceIdentifier { override val name = "itr" }
  case object EmacHelpdesk extends ServiceIdentifier { override val name = "emac-helpdesk" }
  case object LifetimeISA extends ServiceIdentifier { override val name = "lisa" }
  case object CountryByCountryReporting extends ServiceIdentifier { override val name = "cbcr" }
  case object OnlinePaymentService extends ServiceIdentifier { override val name = "online-payment-service" }
  case object HelpToSave extends ServiceIdentifier { override val name = "hts" }
}
