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

import uk.gov.hmrc.hmrcemailrenderer.domain.MessageTemplate
import uk.gov.hmrc.hmrcemailrenderer.templates.aeo.AEOMRATemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.agent.AgentTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.amls.AmlsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.api.ApiTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.apicatalogue.ApiCatalogueTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ars.ArsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ated.AtedTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ats.AtsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.awrs.AwrsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.bars.BarsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cbcr.CBCRTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cbcrnew.CBCRNewTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cir.CirTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.crsfatca.CRSFatcaTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cds.cdsTestTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.childcare.ChildcareTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.customs.CustomsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.dac6.Dac6Templates
import uk.gov.hmrc.hmrcemailrenderer.templates.mdr.MdrTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.dfs.DfsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact.DigitalContactTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.digitaltariffs.DigitalTariffTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.eeitt.EeittTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.emac.EmacTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.emachelpdesk.EmacHelpdeskTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.exports.ExportsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.fandf.FandFTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.fhdds.FhddsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.gg.GgTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.gmp.GmpTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.hts.HtsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.itr.ItrTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.lisa.LisaTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.lostcredentials.LostCredentialsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.mandate.MandateTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.mtdfb.vat.MtdfbVatTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.onlinepaymentservice.OnlinePaymentServiceTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.passcode.PasscodesTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.paye.PayeTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.pods.PodsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.rald.RaldTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.rald.RaldTemplates.raldGroup
import uk.gov.hmrc.hmrcemailrenderer.templates.registeryourcompany.RegisterYourCompanyTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.sdil.SdilTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.tamc.TamcTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.tcs.TcsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.transactionengine.TransactionEngineTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.twowaymessage.twoWayMessagingTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.vat.vatTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.voa.CCATemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.digitalcontact.DigitalContactVatTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.parcels.ParcelsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.customsfinancials.CustomsFinancialsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cgtpd.CgtpdTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.tdq.TdqTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.htsreminder.HtsReminderTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.dst.DstTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ecc.EoriCommonComponentTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.eotho.EothoTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.gms.GmsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.mods.ModsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.seiss.SeissTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cdsrc.cdsrcTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cf.ContactFormsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.cf.ContactFormsTemplates.contactFormsGroup
import uk.gov.hmrc.hmrcemailrenderer.templates.dass.DASSTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.dprs.DprsTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ecl.EclTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.euSubsidy.EUSubsidyTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.oss.OSSTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.hec.HecTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.itsa.ItsaTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.mtdfb.vatreg.VatRegTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.hipp.HippTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.feedback.FeedbackTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ioss.IossTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.iossNetp.IossNetpTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.ngr.NgrTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.penaltyreform.PenReformTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.tctr.TctrTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.tctr.TctrTemplates.tctrGroup
import uk.gov.hmrc.hmrcemailrenderer.templates.tgp.TgpTemplates
import uk.gov.hmrc.hmrcemailrenderer.templates.pillar2.Pillar2Templates
import uk.gov.hmrc.hmrcemailrenderer.templates.tre.treTemplates

trait TemplateLocator {
  def templateGroups: Map[String, Seq[MessageTemplate]] =
    Map(
      "AEO MRA"               -> AEOMRATemplates.templates,
      "Agent"                 -> AgentTemplates.templates,
      "API Platform"          -> ApiTemplates.templates,
      "API Catalogue"         -> ApiCatalogueTemplates.templates,
      "ATS"                   -> AtsTemplates.templates,
      "AWRS"                  -> AwrsTemplates.templates,
      "AMLS"                  -> AmlsTemplates.templates,
      "ARS"                   -> ArsTemplates.templates,
      "BARS"                  -> BarsTemplates.templates,
      "Childcare"             -> ChildcareTemplates.templates,
      "CIR"                   -> CirTemplates.templates,
      "DAC6"                  -> Dac6Templates.templates,
      "DASS"                  -> DASSTemplates.templates,
      "MDR"                   -> MdrTemplates.templates,
      "CBCR-NEW"              -> CBCRNewTemplates.templates,
      "Digital Tariffs"       -> DigitalTariffTemplates.templates,
      "DST"                   -> DstTemplates.templates,
      "DFS"                   -> DfsTemplates.templates,
      "EMAC Helpdesk"         -> EmacHelpdeskTemplates.templates,
      "EMAC"                  -> EmacTemplates.templates,
      "Exports (CDS)"         -> ExportsTemplates.templates,
      "FANDF"                 -> FandFTemplates.templates,
      "GG"                    -> GgTemplates.templates,
      "GMP"                   -> GmpTemplates.templates,
      "GVMS"                  -> GmsTemplates.templates,
      "Passcodes"             -> PasscodesTemplates.templates,
      "PAYE"                  -> PayeTemplates.templates,
      raldGroup               -> RaldTemplates.templates,
      contactFormsGroup       -> ContactFormsTemplates.templates,
      tctrGroup               -> TctrTemplates.tctrTemplates,
      "register-your-company" -> RegisterYourCompanyTemplates.templates,
      "Self Assessment"       -> DigitalContactTemplates.templates,
      "TAMC"                  -> TamcTemplates.templates,
      "TCS"                   -> TcsTemplates.templates,
      "Mandate"               -> MandateTemplates.templates,
      "Customs"               -> CustomsTemplates.templates,
      "Transaction Engine"    -> TransactionEngineTemplates.templates,
      "ATED"                  -> AtedTemplates.templates,
      "LifetimeISA"           -> LisaTemplates.templates,
      "ITR"                   -> ItrTemplates.templates,
      "CBCR"                  -> CBCRTemplates.templates,
      "CRSFATCA"              -> CRSFatcaTemplates.templates,
      "OnlinePaymentService"  -> OnlinePaymentServiceTemplates.templates,
      "EEITT"                 -> EeittTemplates.templates,
      "HTS"                   -> HtsTemplates.templates,
      "HTSReminder"           -> HtsReminderTemplates.templates,
      "FHDDS"                 -> FhddsTemplates.templates,
      "Lost Credentials"      -> LostCredentialsTemplates.templates,
      "FHDDS"                 -> FhddsTemplates.templates,
      "SDIL"                  -> SdilTemplates.templates,
      "CCA"                   -> CCATemplates.templates,
      "CDS"                   -> cdsTestTemplates.templates,
      "MTDfB-VAT"             -> MtdfbVatTemplates.templates,
      "VATREG"                -> VatRegTemplates.templates,
      "PODS"                  -> PodsTemplates.templates,
      "Parcels"               -> ParcelsTemplates.templates,
      "vat"                   -> vatTemplates.templates,
      "Digital Contact VAT"   -> DigitalContactVatTemplates.templates,
      "Two way messaging"     -> twoWayMessagingTemplates.templates,
      "Customs Financials"    -> CustomsFinancialsTemplates.templates,
      "Cgtpd"                 -> CgtpdTemplates.templates,
      "TDQ"                   -> TdqTemplates.templates,
      "SEISS"                 -> SeissTemplates.templates,
      "EOTHO"                 -> EothoTemplates.templates,
      "Eori Common Component" -> EoriCommonComponentTemplates.templates,
      "MODS"                  -> ModsTemplates.templates,
      "CDSRC"                 -> cdsrcTemplates.templates,
      "OSS"                   -> OSSTemplates.templates,
      "HEC"                   -> HecTemplates.templates,
      "EU Subsidy"            -> EUSubsidyTemplates.templates,
      "ITSA"                  -> ItsaTemplates.templates,
      "IOSS"                  -> IossTemplates.templates,
      "ECL"                   -> EclTemplates.templates,
      "HIPP"                  -> HippTemplates.templates,
      "Penalty Reform"        -> PenReformTemplates.templates,
      "TGP"                   -> TgpTemplates.templates,
      "DPRS"                  -> DprsTemplates.templates,
      "IOSS NETP"             -> IossNetpTemplates.templates,
      "TRE"                   -> treTemplates.templates,
      "Pillar 2"              -> Pillar2Templates.templates,
      FeedbackTemplates.id    -> FeedbackTemplates.templates,
      "NGR"                   -> NgrTemplates.templates
    )

  lazy val all: Seq[MessageTemplate] = templateGroups.values.flatten.toSeq

  def findTemplate(templateId: String): Option[MessageTemplate] =
    all.find(_.templateId == templateId) orElse {
      all.find(_.templateId == templateId.stripSuffix(TemplateLocator.WELSH_SUFFIX))
    }
}

object TemplateLocator extends TemplateLocator {
  final val WELSH_SUFFIX = "_cy"
}
