/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.lingua

import org.scalatest._


class NameCaseSpec extends WordSpec with Matchers {

  "NameCase nc" should {
    val properNames = List(
      "Keith", "Leigh-Williams", "McCarthy",
      "O'Callaghan", "St. John", "von Streit",
      "van Dyke", "Van", "ap Llwyd Dafydd",
      "Al",
      // "el Grecco",
      "Ben Gurion", "Ben",
      "da Vinci",
      "di Caprio", "du Pont", "de Legate",
      "del Crond", "der Sind", "van der Post",
      "von Trapp",  "le Figaro",
      "Mack Knife", "Dougal MacDonald"
    )
    properNames.foreach{name =>
      s""" fix "${name.toLowerCase}" to "${name}" """ in {
        NameCase.nc(name.toLowerCase) should be(name)
      }
    }
  }

  it should  {
    val badNamesMap = Map(
      "DR SARAH BEETLE" -> "Dr Sarah Beetle",
      "june O'LEARY" -> "June O'Leary",
      "MICHAEL JOHN JACOBS JR" -> "Michael John Jacobs Jr",
      // "MR. jon whitacre iii" -> "Mr. Jon Whitacre III",
      "MARY BETH DAVIDSON MD" -> "Mary Beth Davidson MD",
      "MS LAURA CONLEY-ROSE" -> "Ms Laura Conley-Rose",
      "LAURA&DAVID SMITH" -> "Laura&David Smith",
      "ESTATE OF LAURA JONES" -> "Estate Of Laura Jones",
      "MS MS. LAURA J BYRD" -> "Ms Ms. Laura J Byrd",
      "ben mcgrath" -> "Ben McGrath",
      "al gore" -> "Al Gore",
      // "AHARON BEN AMRAM HA-KOHEIN" -> "Aharon ben Amram Ha-Kohein",
      // "MIRIAM BAT RIVKAH" -> "Miriam bat Rivkah",
      "anton macevicius" -> "Anton Macevicius",
      "kelechi okoro" -> "Kelechi Okoro",
      "kelechi okoro on behalf of alex olkhovskiy" -> "Kelechi Okoro on behalf of Alex Olkhovskiy"
    )
    badNamesMap.keys.foreach( name =>
      s"""fix "${name}" to "${badNamesMap.get(name).get}" """ in {
        NameCase.nc(name) should be(badNamesMap.get(name).get)
      }
    )
  }
}
