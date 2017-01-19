/*
 * Copyright 2017 HM Revenue & Customs
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

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.amls.AmlsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.api.ApiTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ats.AtsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.awrs.AwrsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.bars.BarsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cc.CcTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.childcarecalculator.ChildcareTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.childcareschemesinterest.ChildcareSchemesInterestTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.customs.CustomsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.dfs.DfsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact.DigitalContactTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.fandf.FandFTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.gg.GgTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.gmp.GmpTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.mandate.MandateTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.offpayroll.OffPayrollTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.passcode.PasscodesTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.paye.PayeTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.rald.RaldTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.registeryourcompany.RegisterYourCompanyTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.tamc.TamcTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.tcs.TcsTemplates

trait TemplateLocator {
  def templateGroups: Map[String, Seq[MessageTemplate]] =
    Map("API Platform"               -> ApiTemplates.templates,
        "ATS"                        -> AtsTemplates.templates,
        "AWRS"                       -> AwrsTemplates.templates,
        "AMLS"                       -> AmlsTemplates.templates,
        "BARS"                       -> BarsTemplates.templates,
        "CC"                         -> CcTemplates.templates,
        "Childcare Calculator"       -> ChildcareTemplates.templates,
        "Childcare Schemes Interest" -> ChildcareSchemesInterestTemplates.templates,
        "DFS"                        -> DfsTemplates.templates,
        "FANDF"                      -> FandFTemplates.templates,
        "GG"                         -> GgTemplates.templates,
        "Passcodes"                  -> PasscodesTemplates.templates,
        "GMP"                        -> GmpTemplates.templates,
        "PAYE"                       -> PayeTemplates.templates,
        "RALD"                       -> RaldTemplates.templates,
        "register-your-company"      -> RegisterYourCompanyTemplates.templates,
        "Self Assessment"            -> DigitalContactTemplates.templates,
        "TAMC"                       -> TamcTemplates.templates,
        "TCS"                        -> TcsTemplates.templates,
        "Mandate"                    -> MandateTemplates.templates,
        "Off Payroll"                -> OffPayrollTemplates.templates,
        "Customs"                    -> CustomsTemplates.templates)

  lazy val all: Seq[MessageTemplate] = templateGroups.values.flatten.toSeq

  def findTemplate(templateId: String): Option[MessageTemplate] =
    all.find(_.templateId == templateId)
}
object TemplateLocator extends TemplateLocator
