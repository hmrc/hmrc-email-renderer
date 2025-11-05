/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.hmrcemailrenderer.templates.dasstechrefresh

import com.typesafe.config.ConfigFactory
import scala.util.Try

object DassTechRefreshFromAddress {
  private val config = ConfigFactory.load()

  private def get(path: String): Option[String] =
    Try(config.getString(path)).toOption.map(_.trim).filter(_.nonEmpty)

  lazy val address: String =
    get("dtr.from.address").getOrElse("helpdesk@ir-efile.gov.uk")

  lazy val displayName: Option[String] =
    get("dtr.from.displayName")

  lazy val dtrEmailAddress: String = displayName.fold(address)(n => s"$n <$address>")
}
