/*
 * Copyright 2020 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.connectors

import org.mockito.Matchers._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import play.api.Mode.Mode
import play.api.{Configuration, Mode}
import uk.gov.hmrc.emailaddress.EmailAddress
import uk.gov.hmrc.hmrcemailrenderer.model.Language
import uk.gov.hmrc.http.{HeaderCarrier, HttpGet, HttpResponse}
import uk.gov.hmrc.play.test.UnitSpec

import scala.concurrent.Future

class PreferencesConnectorSpec  extends UnitSpec with MockitoSugar {

  "PreferencesConnector language by email" should {
    "return English if preference returns English" in new TestCase {
      when(mockHttp.GET[Language](anyString())(any(), any(), any())).thenReturn(Future.successful(Language.English))
      await(preferencesConnector.languageByEmail("test@test.com")) shouldBe(Language.English)
    }
    "return Welsh if preference returns Welsh" in new TestCase {
      when(mockHttp.GET[Language](anyString())(any(), any(), any())).thenReturn(Future.successful(Language.Welsh))
      await(preferencesConnector.languageByEmail("test@test.com")) shouldBe(Language.Welsh)
    }
  }


  trait TestCase {
    val mockHttp = mock[HttpGet]
    implicit val headerCarrier: HeaderCarrier = new HeaderCarrier()
    val preferencesConnector = new PreferencesConnector {

      override def httpGet = mockHttp

      override protected def mode: Mode = Mode.Dev

      override protected def runModeConfiguration: Configuration = Configuration.empty

      override def baseUrl(serviceName: String): String = "what ever"
    }
  }
}


