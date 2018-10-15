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

package uk.gov.hmrc.hmrcemailrenderer.templates.helpers

import uk.gov.hmrc.play.test.UnitSpec

import uk.gov.hmrc.hmrcemailrenderer.templates.helpers.SalutationHelper._

class SalutationHelperSpec extends UnitSpec {
    "The salutation" should {

      "be Dear Customer when having no name" in {
        salutationFrom(Map()) should be("Dear Customer")
      }

      "be Dear Customer when having name.forename only" in {
        salutationFrom(Map("recipientName_forename" -> "GEOFF")) should be("Dear Customer")
      }

      "be Dear Customer when having name.title and name.forename only" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF")) should be("Dear Customer")
      }

      "be Dear Customer when having name.title and name.surname only" in {
        salutationFrom(Map("recipientName_surname" -> "FISHER")) should be("Dear Customer")
      }

      "be Dear Customer when having empty title" in {
        salutationFrom(Map("recipientName_title" -> "   ", "recipientName_surname" -> "O'maLLey")) should be("Dear Customer")
      }

      "be Dear Customer when having empty surname" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "  ")) should be("Dear Customer")
      }

      "be respected when having apostrophied surname" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "O'maLLey")) should be("Dear Mr O'Malley")
      }

      "be respected when having hyphenated surname" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "FISHER-PriCE")) should be("Dear Mr Fisher-Price")
      }

      "be respected when having name.title name.surname	Dear [name.title] [name.surname]" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "FISHER")) should be("Dear Mr Fisher")
      }

      "be title and forename when provided with line1" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "FISHER", "recipientName_line1" -> "something else")) should be("Dear Mr Fisher")
      }

      "be line1 when title and forname are not provided" in {
        salutationFrom(Map("recipientName_line1" -> "something else")) should be("Dear something else")
      }

      "be respected when having name.title name.forename name.surname	Dear [name.title] [name.forename] [name.surname]" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_surname" -> "FISHER")) should be("Dear Mr Fisher")
      }
      "be respected when having name.forename name.surname name.honours	Dear [name.forename] [name.surname] [name.honours]" in {
        salutationFrom(Map("recipientName_forename" -> "GEOFF", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Customer")
      }
      "be respected when having name.forename name.secondForename name.surname name.honours	Dear [name.forename] [name.secondForename] [name.surname] [name.honours]" in {
        salutationFrom(Map("recipientName_forename" -> "GEOFF", "recipientName_secondForename" -> "BOB", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Customer")
      }
      "be respected when having name.title name.surname name.honours	Dear [name.title] [name.surname] [name.honours]" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Mr Fisher")
      }
      "be respected when having name.title name.forename name.surname name.honours	Dear [name.title] [name.forename] [name.surname] [name.honours]" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Mr Fisher")
      }
      "be respected when having name.title name.forename name.secondForename name.surname	Dear [name.title] [name.forename] [name.secondForename] [name.surname]" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_secondForename" -> "BOB", "recipientName_surname" -> "FISHER")) should be("Dear Mr Fisher")
      }
      "be respected when having name.title name.forename name.secondForename name.surname name.honours	Dear [name.title] [name.forename] [name.secondForename] [name.surname] [name.honours]" in {
        salutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_secondForename" -> "BOB", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Mr Fisher")
      }
    }

  "The informal salutation" should {

    "be Dear Customer when having no name" in {
      informalSalutationFrom(Map()) should be("Dear Customer")
    }

    "be Dear Customer when having name.forename only" in {
      informalSalutationFrom(Map("recipientName_forename" -> "GEOFF")) should be("Dear Customer")
    }

    "be Dear Customer when having name.title and name.forename only" in {
      informalSalutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF")) should be("Dear Customer")
    }

    "be Dear Customer when having name.title and name.surname only" in {
      informalSalutationFrom(Map("recipientName_surname" -> "FISHER")) should be("Dear Customer")
    }

    "be Dear Customer when having empty forname" in {
      informalSalutationFrom(Map("recipientName_forename" -> "", "recipientName_surname" -> "O'maLLey")) should be("Dear Customer")
    }

    "be Dear Customer when having empty surname" in {
      informalSalutationFrom(Map("recipientName_forename" -> "PAT", "recipientName_surname" -> "")) should be("Dear Customer")
    }

    "be respected when having apostrophied surname" in {
      informalSalutationFrom(Map("recipientName_forename" -> "PAT", "recipientName_surname" -> "O'maLLey")) should be("Dear Pat O'Malley")
    }

    "be respected when having hyphenated surname" in {
      informalSalutationFrom(Map("recipientName_forename" -> "COLIN", "recipientName_surname" -> "FISHER-PriCE")) should be("Dear Colin Fisher-Price")
    }

    "be respected when having name.title name.surname	Dear Customer" in {
      informalSalutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "FISHER")) should be("Dear Customer")
    }

    "be respected when having name.title name.forename name.surname	Dear [name.title] [name.forename] [name.surname]" in {
      informalSalutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_surname" -> "FISHER")) should be("Dear Geoff Fisher")
    }
    "be respected when having name.forename name.surname name.honours	Dear [name.forename] [name.surname] [name.honours]" in {
      informalSalutationFrom(Map("recipientName_forename" -> "GEOFF", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Geoff Fisher")
    }
    "be respected when having name.forename name.secondForename name.surname name.honours	Dear [name.forename] [name.secondForename] [name.surname] [name.honours]" in {
      informalSalutationFrom(Map("recipientName_forename" -> "GEOFF", "recipientName_secondForename" -> "BOB", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Geoff Fisher")
    }
    "be respected when having name.title name.surname name.honours	Dear Customer" in {
      informalSalutationFrom(Map("recipientName_title" -> "MR", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Customer")
    }
    "be respected when having name.title name.forename name.surname name.honours	Dear [name.title] [name.forename] [name.surname] [name.honours]" in {
      informalSalutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Geoff Fisher")
    }
    "be respected when having name.title name.forename name.secondForename name.surname	Dear [name.title] [name.forename] [name.secondForename] [name.surname]" in {
      informalSalutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_secondForename" -> "BOB", "recipientName_surname" -> "FISHER")) should be("Dear Geoff Fisher")
    }
    "be respected when having name.title name.forename name.secondForename name.surname name.honours	Dear [name.title] [name.forename] [name.secondForename] [name.surname] [name.honours]" in {
      informalSalutationFrom(Map("recipientName_title" -> "MR", "recipientName_forename" -> "GEOFF", "recipientName_secondForename" -> "BOB", "recipientName_surname" -> "FISHER", "recipientName_honours" -> "LLB")) should be("Dear Geoff Fisher")
    }
  }

  "The Fullname salutation" should {

    "be Dear Customer when having no name" in {
      saluteFullName(Map()) should be("Dear Customer")
    }

    "be Dear Customer when having name.forename only" in {
      saluteFullName(Map("recipientName_forename" -> "John")) should be("Dear Customer")
    }

    "be Dear Customer when having name.title and name.surname only" in {
      saluteFullName(Map("recipientName_surname" -> "DOE")) should be("Dear Customer")
    }

    "be Dear Customer when having empty forname" in {
      saluteFullName(Map("recipientName_forename" -> "", "recipientName_surname" -> "O'doe")) should be("Dear Customer")
    }

    "be Dear Customer when having empty surname" in {
      saluteFullName(Map("recipientName_forename" -> "John", "recipientName_surname" -> "")) should be("Dear Customer")
    }

    "be respected when having apostrophied Fullname" in {
      saluteFullName(Map("recipientName_FullName" -> "John O'Doe")) should be("Dear John O'Doe")
    }

    "be respected when having hyphenated Fullname" in {
      saluteFullName(Map("recipientName_FullName" -> "John DOE-DOE")) should be("Dear John Doe-Doe")
    }

    "be respected when having uppercase Fullname" in {
      saluteFullName(Map("recipientName_FullName" -> "JOHN DOE")) should be("Dear John Doe")
    }

    "be Dear John Doe when having firstname, surname, fullname" in {
      saluteFullName(Map("recipientName_forename" -> "ABCDEF", "recipientName_surname" -> "ZXCVB", "recipientName_FullName" -> "John DOE")) should be("Dear John Doe")
    }
  }

}
