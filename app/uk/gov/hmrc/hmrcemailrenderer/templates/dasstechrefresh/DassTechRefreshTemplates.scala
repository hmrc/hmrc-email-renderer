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

import uk.gov.hmrc.hmrcemailrenderer.domain.{MessagePriority, MessageTemplate}
import uk.gov.hmrc.hmrcemailrenderer.templates.ServiceIdentifier
import uk.gov.hmrc.hmrcemailrenderer.templates.dasstechrefresh.DassTechRefreshFromAddress.dtrEmailAddress

object DassTechRefreshTemplates {

  val templates = Seq(
    MessageTemplate.create(
      templateId = "dtr_cis_nil_monthly_return_org_success",
      fromAddress = dtrEmailAddress,
      service = ServiceIdentifier.ConstructionIndustryScheme,
      subject = "CIS Online submission received by HM Revenue and Customs",
      plainTemplate = cis.txt.nilMonthlyReturnOrgSuccess.f,
      htmlTemplate = cis.html.nilMonthlyReturnOrgSuccess.f,
      priority = Some(MessagePriority.Urgent)
    )
  )
}
