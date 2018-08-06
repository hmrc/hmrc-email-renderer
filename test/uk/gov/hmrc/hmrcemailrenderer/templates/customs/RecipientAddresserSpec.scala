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

package uk.gov.hmrc.hmrcemailrenderer.templates.customs

import org.scalatest.{Matchers, WordSpec}
import RecipientAddresser._

class RecipientAddresserSpec extends WordSpec with Matchers {

  "The Recipient Addresser" should {

    "be 'You are' when having no org name" in {
      youAreOrgNameIs(Map.empty) shouldBe "You are"
    }

    "be 'Orgname is' when having org name only" in {
      youAreOrgNameIs(Map("recipientOrgName" -> "Orgname")) shouldBe "Orgname is"
    }

    "be 'Orgname is' when having orgname in uppercase" in {
      youAreOrgNameIs(Map("recipientOrgName" -> "ORGNAME")) shouldBe "Orgname is"
    }

    "be 'Orgname is' when having org name in lowercase" in {
      youAreOrgNameIs(Map("recipientOrgName" -> "orgname")) shouldBe "Orgname is"
    }

    "be 'Orgname-Orgname is' when having hyphenated org name" in {
      youAreOrgNameIs(Map("recipientOrgName" -> "orgname-orgname")) shouldBe "Orgname-Orgname is"
    }

    "preserve the apostrophe" in {
      youAreOrgNameIs(Map("recipientOrgName" -> "o'orgname")) shouldBe "O'Orgname is"
    }

    "preserve the spaces in org name" in {
      youAreOrgNameIs(Map("recipientOrgName" -> "orgname orgname")) shouldBe "Orgname Orgname is"
    }
  }
}
