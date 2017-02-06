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

package uk.gov.hmrc.hmrcemailrenderer.templates.ats

import uk.gov.hmrc.play.test.UnitSpec

class AtsSalutationHelperSpec extends UnitSpec {
  "salutationFrom" should {
    "return 'Dear FirstName' if first name is present" in {

      val salutationParams: Map[String, Any] = Map("recipientName_forename" -> "John")

      val salutation = AtsSalutationHelper.salutationFrom(salutationParams)

      salutation shouldBe "Dear John"
    }

    "return 'Dear Title Surname' if first name is not present, and surname/title are present" in {

      val salutationParams: Map[String, Any] = Map("recipientName_title" -> "Mr", "recipientName_surname" -> "Doe")

      val salutation = AtsSalutationHelper.salutationFrom(salutationParams)

      salutation shouldBe "Dear Mr Doe"
    }

    "return 'Dear customer' by default if it doesn't match any specified condition" in {

      val salutationParams: Map[String, Any] = Map("recipientName_surname" -> "Doe")

      val salutation = AtsSalutationHelper.salutationFrom(salutationParams)

      salutation shouldBe "Dear customer"
    }
  }
}
