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

package uk.gov.hmrc.hmrcemailrenderer.templates.helpers.organisationname

import uk.gov.hmrc.hmrcemailrenderer.templates.helpers.organisationname.OrgNameHelper._
import uk.gov.hmrc.play.test.UnitSpec

class OrgNameHelperSpec extends UnitSpec {
    "The orgName" should {

      "be 'You are' when having no orgName" in {
        orgNameOrIndividual(Map()) should be("You are")
      }

      "be 'Orgname is' when having orgName only" in {
        orgNameOrIndividual(Map("recipientOrgName" -> "Orgname")) should be("Orgname is")
      }

      "be 'Orgname is' when having orgName in uppercase" in {
        orgNameOrIndividual(Map("recipientOrgName" -> "ORGNAME")) should be("Orgname is")
      }

      "be 'Orgname is' when having orgName in lowercase" in {
        orgNameOrIndividual(Map("recipientOrgName" -> "orgname")) should be("Orgname is")
      }

      "be 'Orgname-Orgname is' when having hyphenated orgName" in {
        orgNameOrIndividual(Map("recipientOrgName" -> "orgname-orgname")) should be("Orgname-Orgname is")
      }

      "be respected when having apostrophied orgName" in {
        orgNameOrIndividual(Map("recipientOrgName" -> "o'orgname")) should be("O'Orgname is")
      }

      "be 'Orgname Orgname is' when having orgName with spaces" in {
        orgNameOrIndividual(Map("recipientOrgName" -> "orgname orgname")) should be("Orgname Orgname is")
      }
    }
}
