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

package uk.gov.hmrc.hmrcemailrenderer.templates.tamc

import uk.gov.hmrc.email.services.{BodyTemplate, SimpleMessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.Regime.TaxAllowanceForMarriedCouples
import uk.gov.hmrc.hmrcemailrenderer.templates._

object TamcTemplates extends TemplateGroup with GovUkTemplate {
  val title = "TAMC"

  def subGroups = Seq(
    SimpleMessageTemplate(
      id = "tamc_confirmation_template_id",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your application for Marriage Allowance",
      plainTemplate = txt.tamcConfirmationEmail.apply,
      htmlTemplate = html.tamcConfirmationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_confirmation_pta",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your application for Marriage Allowance",
      plainTemplate = txt.tamcConfirmationPtaEmail.apply,
      htmlTemplate = html.tamcConfirmationPtaEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_cancel",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcUpdateCancel.apply,
      htmlTemplate = html.tamcUpdateCancel.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_reject",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcUpdateReject.apply,
      htmlTemplate = html.tamcUpdateReject.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_divorce_transferor_boy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcUpdateDivorceTransBoy.apply,
      htmlTemplate = html.tamcUpdateDivorceTransBoy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_divorce_recipient_eoy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcUpdateDivorceRecEoy.apply,
      htmlTemplate = html.tamcUpdateDivorceRecEoy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_current_year",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your application for Marriage Allowance",
      plainTemplate = txt.tamcCurrentYrApplicationEmail.apply,
      htmlTemplate = html.tamcCurrentYrApplicationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_retro_year",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your application for Marriage Allowance",
      plainTemplate = txt.tamcRetroYrApplicationEmail.apply,
      htmlTemplate = html.tamcRetroYrApplicationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_current_retro_year",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your application for Marriage Allowance",
      plainTemplate = txt.tamcCurrentRetroYrApplicationEmail.apply,
      htmlTemplate = html.tamcCurrentRetroYrApplicationEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_transferor_divorce_previous_yr",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcTransferorDivorcePreviousYrEmail.apply,
      htmlTemplate = html.tamcTransferorDivorcePreviousYrEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_recipient_divorce_previous_yr",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcRecipientDivorcePreviousYrEmail.apply,
      htmlTemplate = html.tamcRecipientDivorcePreviousYrEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_transferor_divorce_current_yr",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcTransferorDivorceCurrentYr.apply,
      htmlTemplate = html.tamcTransferorDivorceCurrentYr.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_recipient_rejects_retro_yr",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Your change to Marriage Allowance",
      plainTemplate = txt.tamcRecipientRejectsRetroYrEmail.apply,
      htmlTemplate = html.tamcRecipientRejectsRetroYrEmail.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_cancel_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcUpdateCancelCy.apply,
      htmlTemplate = html.tamcUpdateCancelCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_reject_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcUpdateRejectCy.apply,
      htmlTemplate = html.tamcUpdateRejectCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_divorce_transferor_boy_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcUpdateDivorceTransBoyCy.apply,
      htmlTemplate = html.tamcUpdateDivorceTransBoyCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_update_divorce_recipient_eoy_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcUpdateDivorceRecEoyCy.apply,
      htmlTemplate = html.tamcUpdateDivorceRecEoyCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_current_year_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich cais am Lwfans Priodas",
      plainTemplate = txt.tamcCurrentYrApplicationEmailCy.apply,
      htmlTemplate = html.tamcCurrentYrApplicationEmailCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_retro_year_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich cais am Lwfans Priodas",
      plainTemplate = txt.tamcRetroYrApplicationEmailCy.apply,
      htmlTemplate = html.tamcRetroYrApplicationEmailCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_current_retro_year_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich cais am Lwfans Priodas",
      plainTemplate = txt.tamcCurrentRetroYrApplicationEmailCy.apply,
      htmlTemplate = html.tamcCurrentRetroYrApplicationEmailCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_transferor_divorce_previous_yr_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcTransferorDivorcePreviousYrEmailCy.apply,
      htmlTemplate = html.tamcTransferorDivorcePreviousYrEmailCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_recipient_divorce_previous_yr_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcRecipientDivorcePreviousYrEmailCy.apply,
      htmlTemplate = html.tamcRecipientDivorcePreviousYrEmailCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_transferor_divorce_current_yr_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcTransferorDivorceCurrentYrCy.apply,
      htmlTemplate = html.tamcTransferorDivorceCurrentYrCy.apply,
      fromAddress = govUkTeamAddress),
    SimpleMessageTemplate(
      id = "tamc_recipient_rejects_retro_yr_cy",
      regime = TaxAllowanceForMarriedCouples,
      subject = "Eich newid i Lwfans Priodas",
      plainTemplate = txt.tamcRecipientRejectsRetroYrEmailCy.apply,
      htmlTemplate = html.tamcRecipientRejectsRetroYrEmailCy.apply,
      fromAddress = govUkTeamAddress))
}
