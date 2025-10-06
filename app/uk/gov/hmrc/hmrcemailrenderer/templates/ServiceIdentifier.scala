/*
 * Copyright 2023 HM Revenue & Customs
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
  case object AdvanceValuationRulingsService extends ServiceIdentifier { override val name = "ars" }
  case object AEOMRA extends ServiceIdentifier { override val name = "aeo-mra" }
  case object Agent extends ServiceIdentifier { override val name = "agent" }
  case object AgentOptInExclude extends ServiceIdentifier { override val name = "agent-optin-exclude" }
  case object AgentOptInRejoin extends ServiceIdentifier { override val name = "agent-optin-rejoin" }
  case object AlcoholWholesalerRegistrationScheme extends ServiceIdentifier { override val name = "awrs" }
  case object AntiMoneyLaunderingSupervision extends ServiceIdentifier { override val name = "amls" }
  case object AnnualTaxSummary extends ServiceIdentifier { override val name = "ats" }
  case object ApiDeveloperHub extends ServiceIdentifier { override val name = "api" }
  case object ApiCatalogue extends ServiceIdentifier { override val name = "api-catalogue" }
  case object BTIOperationalService extends ServiceIdentifier { override val name = "tariff-classification-frontend" }
  case object BTIApplicationService extends ServiceIdentifier { override val name = "binding-tariff-trader-frontend" }
  case object BTIAdviceService extends ServiceIdentifier { override val name = "binding-tariff-advice-frontend" }
  case object BusinessRates extends ServiceIdentifier { override val name = "bars" }
  case object Charities extends ServiceIdentifier { override val name = "charities" }
  case object Childcare extends ServiceIdentifier { override val name = "cc" }
  case object CIPInsightsAndReputation extends ServiceIdentifier { override val name = "cir" }
  case object CompanyAccountsTaxOnline extends ServiceIdentifier { override val name = "cato" }
  case object CorporationTax extends ServiceIdentifier { override val name = "ct" }
  case object CountryByCountryReportingNew extends ServiceIdentifier { override val name = "cbcr_new" }

  case object CRSFATCA extends ServiceIdentifier { override val name = "crs_fatca" }
  case object DAC6 extends ServiceIdentifier { override val name = "dac6" }
  case object MDR extends ServiceIdentifier { override val name = "mdr" }
  case object DigitalFormsService extends ServiceIdentifier { override val name = "dfs" }
  case object Eeitt extends ServiceIdentifier { override val name = "eeitt" }
  case object Exports extends ServiceIdentifier { override val name = "customs-declare-exports" }
  case object Fhdds extends ServiceIdentifier { override val name = "fhdds" }
  case object FriendsAndFamily extends ServiceIdentifier { override val name = "fandf" }
  case object GovernmentGateway extends ServiceIdentifier { override val name = "gg" }
  case object GuaranteedMinimumPension extends ServiceIdentifier { override val name = "gmp" }
  case object Generic extends ServiceIdentifier { override val name = "generic" }
  case object Itsa extends ServiceIdentifier { override val name = "itsa" }
  case object Ioss extends ServiceIdentifier { override val name = "ioss" }
  case object InheritanceTax extends ServiceIdentifier { override val name = "iht" }
  case object PayAsYouEarn extends ServiceIdentifier { override val name = "paye" }
  case object PensionSchemesforPractitioners extends ServiceIdentifier { override val name = "pp" }
  case object RegisterYourCompany extends ServiceIdentifier { override val name = "register-your-company" }
  case object RentalAndLeaseDetails extends ServiceIdentifier { override val name = "rald" }
  case object ContactForms extends ServiceIdentifier { override val name = "voa-contact-forms" }
  case object TctrForms extends ServiceIdentifier { override val name = "voa-tctr" }
  case object SecurityConsole extends ServiceIdentifier { override val name = "security-console" }
  case object SelfAssessment extends ServiceIdentifier { override val name = "sa" }
  case object TaxAdvantagedVentureCapital extends ServiceIdentifier { override val name = "tavc" }
  case object TaxAllowanceForMarriedCouples extends ServiceIdentifier { override val name = "tamc" }
  case object TaxCreditsService extends ServiceIdentifier { override val name = "tcs" }
  case object Mandate extends ServiceIdentifier { override val name = "agent-client-mandate" }
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
  case object Emac extends ServiceIdentifier { override val name = "emac" }
  case object LifetimeISA extends ServiceIdentifier { override val name = "lisa" }
  case object CountryByCountryReporting extends ServiceIdentifier { override val name = "cbcr" }
  case object OnlinePaymentService extends ServiceIdentifier { override val name = "online-payment-service" }
  case object PassengerService extends ServiceIdentifier { override val name = "bc-passenger-service" }
  case object HelpToSave extends ServiceIdentifier { override val name = "hts" }
  case object SoftDrinksIndustryLevy extends ServiceIdentifier { override def name: String = "sdil" }
  case object LostCredentials extends ServiceIdentifier { override val name = "lostcredentials" }
  case object CCA extends ServiceIdentifier { override val name = "check-challenge-assessment" }
  case object CDS extends ServiceIdentifier { override val name = "cds" }
  case object MTDfBVatSignUp extends ServiceIdentifier { override val name = "mtdfb-vat-sign-up" }
  case object MTDfBVatRegistration extends ServiceIdentifier { override val name = "vatreg" }
  case object PODS extends ServiceIdentifier { override val name = "pods" }
  case object Parcels extends ServiceIdentifier { override val name = "parcels" }
  case object Vat extends ServiceIdentifier { override val name = "vat" }
  case object DigitalContactVat extends ServiceIdentifier { override val name = "digitalContactVat" }
  case object TwoWayMessaging extends ServiceIdentifier { override val name = "twoWayMessaging" }
  case object CustomsFinancials extends ServiceIdentifier { override val name = "customsFinancials" }
  case object Cgtpd extends ServiceIdentifier { override val name = "cgtpd" }
  case object Tdq extends ServiceIdentifier { override val name = "tdq" }
  case object DigitalServicesTax extends ServiceIdentifier { override val name = "dst" }
  case object Seiss extends ServiceIdentifier { override val name = "seiss" }
  case object GoodsMovementSystem extends ServiceIdentifier { override val name = "goods-movement-system" }
  case object EOTHO extends ServiceIdentifier { override val name = "eotho" }
  case object EoriCommonComponent extends ServiceIdentifier { override val name = "ecc" }
  case object MODS extends ServiceIdentifier { override val name = "mods" }
  case object CDSRC extends ServiceIdentifier { override val name = "cdsrc" }
  case object OSS extends ServiceIdentifier { override val name = "oss" }
  case object HEC extends ServiceIdentifier { override val name = "hec" }
  case object EUSubsidy extends ServiceIdentifier { override val name = "euSubsidy" }
  case object EconomicCrimeLevy extends ServiceIdentifier { override val name = "ecl" }
  case object Hipp extends ServiceIdentifier { override val name = "hipp" }
  case object PenReform extends ServiceIdentifier { override val name = "penaltyReform" }
  case object Tgp extends ServiceIdentifier { override val name = "tgp" }
  case object DigitalPlatformReporting extends ServiceIdentifier { override val name = "dprs" }
  case object IossNetp extends ServiceIdentifier { override val name = "ioss-netp" }
  case object TradeReportingExtracts extends ServiceIdentifier { override val name = "tre" }

  case object Feedback extends ServiceIdentifier { override val name = "feedback" }
  case object Pillar2 extends ServiceIdentifier { override val name = "pillar2" }
  case object NgrNotify extends ServiceIdentifier { override val name = "ngr-notify" }
}
