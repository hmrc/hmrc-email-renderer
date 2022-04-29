/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.apicatalogue.params

import java.util.Base64
import play.api.libs.json.Json
object ApiCatalogueReportParams {

  def getQuestions(params: Map[String, Any]): List[String] =
    params
      .get("contactReasons")
      .fold(List.empty[String])(contactReasons => {
        val encoded = contactReasons.toString
        val decoded = new String(Base64.getDecoder.decode(encoded), "UTF-8")
        decoded.split("[|]").toList
      })
}
