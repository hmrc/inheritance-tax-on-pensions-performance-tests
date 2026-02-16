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

package uk.gov.hmrc.perftests.ihtp.pages

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.perftests.ihtp.constant.AppConfig._

object IHTPPageRequests {

  val getYourSubmissionsPage: HttpRequestBuilder =
    http("Get Your Submissions Page")
      .get(s"$ihtpFrontendHost$submissionListPath")
      .check(status.is(200))
      .check(substring("Your submissions"))

  val loginToIHTP: HttpRequestBuilder =
    http("Login to IHTP via Auth Stub")
      .post(ggSignInUrl)
      .formParam("redirectionUrl", s"$ihtpFrontendHost$ihtpRoute")
      .formParam("affinityGroup", "Organisation")
      .formParam("credentialStrength", "strong") // Often required for Organisation
      .formParam("confidenceLevel", "50")
      .formParam("nino", "")
      .formParam("authorityId", "")
      .formParam("enrolment[0].name", "HMRC-PODS-ORG")
      .formParam("enrolment[0].taxIdentifier[0].name", "PsaID")
      .formParam("enrolment[0].taxIdentifier[0].value", "A2100005")
      .formParam("enrolment[0].state", "Activated")
      .check(status.is(303))
      .check(header("Location").is(s"$ihtpFrontendHost$ihtpRoute"))
}
