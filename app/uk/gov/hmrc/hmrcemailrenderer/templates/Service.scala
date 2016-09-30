/*
 * Copyright 2016 HM Revenue & Customs
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

sealed trait Service {
  val name: String
}
object Service {

  case object ApiDeveloperHub                     extends Service { override val name = "api" }
  case object SelfAssessment                      extends Service { override val name = "sa" }
  case object DigitalFormsService                 extends Service { override val name = "dfs" }
  case object AnnualTaxSummary                    extends Service { override val name = "ats" }
  case object Childcare                           extends Service { override val name = "cc" }
  case object FriendsAndFamily                    extends Service { override val name = "fandf" }
  case object TaxCreditsService                   extends Service { override val name = "tcs" }
  case object PayAsYouEarn                        extends Service { override val name = "paye" }
  case object NationalInsuranceAndStatePension    extends Service { override val name = "nisp" }
  case object TaxAllowanceForMarriedCouples       extends Service { override val name = "tamc" }
  case object CompanyAccountsTaxOnline            extends Service { override val name = "cato" }
  case object InheritanceTax                      extends Service { override val name = "iht" }
  case object Agent                               extends Service { override val name = "agent" }
  case object AgentOptInExclude                   extends Service { override val name = "agent-optin-exclude" }
  case object AgentOptInRejoin                    extends Service { override val name = "agent-optin-rejoin" }
  case object GuaranteedMinimumPension            extends Service { override val name = "gmp"}
  case object AlcoholWholesalerRegistrationScheme extends Service { override val name = "awrs"}
  case object Generic                             extends Service { override val name = "generic" }
  case object RentalAndLeaseDetails               extends Service { override val name = "rald" }
  case object BusinessRates                       extends Service { override val name = "bars" }
}
