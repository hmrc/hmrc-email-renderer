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
import uk.gov.hmrc.http.{HeaderCarrier, HttpGet, HttpResponse}
import uk.gov.hmrc.play.test.UnitSpec

import scala.concurrent.Future

class PreferencesConnectorSpec  extends UnitSpec with MockitoSugar {

  "PreferencesConnector" should {
    "return false if language is en" in new TestCase {
     when(mockHttp.doGet(anyString())(any())).thenReturn(Future.successful(HttpResponse(responseStatus = 200, responseString = Some("en"))))
    await(preferencesConnector.isWelsh(EmailAddress("test@test.com"))) shouldBe(false)
    }

    "return true if language is cy" in new TestCase {
      when(mockHttp.doGet(anyString())(any())).thenReturn(Future.successful(HttpResponse(responseStatus = 200, responseString = Some("cy"))))
      await(preferencesConnector.isWelsh(EmailAddress("test@test.com"))) shouldBe(true)
    }

    "return false if we get 404 from preferences" in new TestCase {
      when(mockHttp.doGet(anyString())(any())).thenReturn(Future.successful(HttpResponse(responseStatus = 404, responseString = Some(""))))
      await(preferencesConnector.isWelsh(EmailAddress("test@test.com"))) shouldBe(false)
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


