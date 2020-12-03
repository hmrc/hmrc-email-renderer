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

import org.mockito.ArgumentMatchers.{ any, anyString }
import org.mockito.Mockito.when
import org.scalatestplus.mockito.MockitoSugar
import uk.gov.hmrc.hmrcemailrenderer.model.Language
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig
import uk.gov.hmrc.play.bootstrap.http.HttpClient
import uk.gov.hmrc.play.test.UnitSpec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PreferencesConnectorSpec extends UnitSpec with MockitoSugar {

  "PreferencesConnector language by email" should {
    "return English if preference returns English" in new TestCase {
      when(httpClient.GET[Language](anyString())(any(), any(), any())).thenReturn(Future.successful(Language.English))
      await(preferencesConnector.languageByEmail("test@test.com")) shouldBe (Language.English)
    }
    "return Welsh if preference returns Welsh" in new TestCase {
      when(httpClient.GET[Language](anyString())(any(), any(), any())).thenReturn(Future.successful(Language.Welsh))
      await(preferencesConnector.languageByEmail("test@test.com")) shouldBe (Language.Welsh)
    }
  }

  trait TestCase {
    implicit val headerCarrier: HeaderCarrier = new HeaderCarrier()
    val servicesConfig = mock[ServicesConfig]
    val httpClient = mock[HttpClient]
    val preferencesConnector = new PreferencesConnector(servicesConfig, httpClient)
  }
}
