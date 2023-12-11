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

package uk.gov.hmrc.hmrcemailrenderer.templates.digitalTariffs

import org.scalatest.EitherValues
import uk.gov.hmrc.hmrcemailrenderer.templates.{ CommonParamsForSpec, TemplateLoader, TemplateLocator }
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class ApplicationSubmittedWelshSpec
    extends AnyWordSpecLike with Matchers with OptionValues with EitherValues with TemplateLoader
    with CommonParamsForSpec {

  "application_submitted_cy" should {
    val templateLocator = new TemplateLocator {}
    val params = commonParameters ++ Map("reference" -> "REFERENCE")
    val template = templateLocator
      .templateGroups("Digital Tariffs")
      .find(_.templateId == "digital_tariffs_application_submitted_cy")
      .get

    "render correct subject" in {
      template.subject(Map.empty) shouldBe ("Mae’ch cais am Ddyfarniad Tariffau Uwch (ATaR) wedi dod i law CThEM")
    }

    "render correct html content" in {
      val htmlContent = template.htmlTemplate(params).toString

      htmlContent should include("Eich cais am Ddyfarniad Tariffau Uwch (ATaR)")
      htmlContent should include("Annwyl Gwsmer")
      htmlContent should include("Cawsom eich cais am Ddyfarniad Tariffau Uwch, gyda’r cyfeirnod: REFERENCE")
      htmlContent should include(
        "Rydym yn ceisio anfon penderfyniadau o ran Dyfarniadau Tariffau Uwch (ATaR) cyn pen 30 diwrnod i ddyddiad derbyn y cais. Fodd bynnag, mae’n gallu cymryd hyd at 120 diwrnod, yn unol â chyfraith y DU.")
      htmlContent should include("Byddwn yn gwneud penderfyniad pan fydd yr holl wybodaeth angenrheidiol yn dod i law.")
      htmlContent should include("Samplau")
      htmlContent should include(
        "Peidiwch ag anfon samplau atom yn ystod y pandemig coronafeirws. Os bydd angen sampl arnom, byddwn yn gofyn i chi ddarparu un.")
      htmlContent should include("Yr hyn y gallwch ei wneud nesaf")
      htmlContent should include(
        "Nid yw cyfathrebu â ni drwy e-bost yn ddiogel, ac felly ni ddylid anfon unrhyw wybodaeth gyfrinachol drwy e-bost at ein tîm. Os byddwch yn dewis cysylltu â ni drwy e-bost, rydych yn derbyn y peryglon.")
      htmlContent should include(
        "I wirio statws eich cais, neu i gael gwybodaeth am samplau, ewch i GOV.UK a chwilio am ‘Apply for an Advanced Tariff Ruling (ATaR)’.")
      htmlContent should include("Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad yn yr e-bost hwn.")
      htmlContent should include("Oddi wrth y Gwasanaeth Dosbarthu Tariffau")
    }

    "render correct text content" in {
      val txtContent = template.plainTemplate(params).toString

      txtContent should include("Eich cais am Ddyfarniad Tariffau Uwch (ATaR)")
      txtContent should include("Annwyl Gwsmer")
      txtContent should include("Cawsom eich cais am Ddyfarniad Tariffau Uwch, gyda’r cyfeirnod: REFERENCE")
      txtContent should include(
        "Rydym yn ceisio anfon penderfyniadau o ran Dyfarniadau Tariffau Uwch (ATaR) cyn pen 30 diwrnod i ddyddiad derbyn y cais. Fodd bynnag, mae’n gallu cymryd hyd at 120 diwrnod, yn unol â chyfraith y DU.")
      txtContent should include("Byddwn yn gwneud penderfyniad pan fydd yr holl wybodaeth angenrheidiol yn dod i law.")
      txtContent should include("Samplau")
      txtContent should include(
        "Peidiwch ag anfon samplau atom yn ystod y pandemig coronafeirws. Os bydd angen sampl arnom, byddwn yn gofyn i chi ddarparu un.")
      txtContent should include("Yr hyn y gallwch ei wneud nesaf")
      txtContent should include(
        "Nid yw cyfathrebu â ni drwy e-bost yn ddiogel, ac felly ni ddylid anfon unrhyw wybodaeth gyfrinachol drwy e-bost at ein tîm. Os byddwch yn dewis cysylltu â ni drwy e-bost, rydych yn derbyn y peryglon.")
      txtContent should include(
        "I wirio statws eich cais, neu i gael gwybodaeth am samplau, ewch i GOV.UK a chwilio am ‘Apply for an Advanced Tariff Ruling (ATaR)’.")
      txtContent should include("Am resymau diogelwch, nid ydym wedi cynnwys cysylltiad yn yr e-bost hwn.")
      txtContent should include("Oddi wrth y Gwasanaeth Dosbarthu Tariffau")
      txtContent should include("Os nad ydych yn siŵr a yw e-bost wedi dod oddi wrth CThEF:")
      txtContent should include("- Peidiwch ag ymateb iddo na chlicio ar unrhyw gysylltiadau")
      txtContent should include(
        "- Rhowch wybod i CThEF am yr e-bost amheus - er mwyn gweld sut, ewch i GOV.UK a chwilio am ‘gwe-rwydo a sgamiau’")
    }
  }

}
