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

package uk.gov.hmrc.perftests.ihtp

import io.gatling.core.Predef.*
import io.gatling.core.session.Expression
import io.gatling.http.Predef.*
import io.gatling.http.request.builder.HttpRequestBuilder



object IHTPPageRequests extends BaseRequest {



  def getClearData: HttpRequestBuilder =
    http("Clear Data")
      .get(s"$baseUrl/$route/test-only/clear-all": String)
      .check(status.is(200))


  def getLoginToIHTPPage: HttpRequestBuilder =
    http("Navigate to auth login stub page")
      .get(s"$authUrl/auth-login-stub/gg-sign-in": String)
      .check(status.is(200))
      .check(saveCsrfToken())

  def postLoginToIHTPPage: HttpRequestBuilder =
     http("Login to Psp IHTP via Auth Stub")
        .post(s"$authUrl/auth-login-stub/gg-sign-in")
        .formParam("csrfToken", csrfTokenExpr)
        .formParam("redirectionUrl", _ => s"$baseUrl$WhatWillYouNeed")
        .formParam("affinityGroup", _ => "Organisation")
        .formParam("credentialStrength", _ => "strong")
        .formParam("confidenceLevel", _ => "50")
        .formParam("nino", _ => "")
        .formParam("authorityId", _ => "")
        .formParam("enrolment[0].name", _ => "HMRC-PODS-ORG")
        .formParam("enrolment[0].taxIdentifier[0].name", _ => "PsaID")
        .formParam("enrolment[0].taxIdentifier[0].value", _ => "A2100005")
        .formParam("enrolment[0].state", _ => "Activated")
        .check(status.is(303))


  def getYouWillNeedPage: HttpRequestBuilder =
    http("Get What you will need Page")
      .get(s"$baseUrl$WhatWillYouNeed")
      .check(status.is(200))
    .check(bodyString.saveAs("pageBody"))
  .check(saveCsrfToken())


  def postYouWillNeedPage: HttpRequestBuilder =
    http("Post What you will need Page")
     .post(s"$baseUrl$route/start-report-you-will-need": String)
    .formParam("csrfToken", csrfTokenExpr)
     .check(status.is(303))
     .check(header(locationHeaderExpr).is(s"$route/enter-inheritance-tax-reference": String))

  def getEnterInheritanceTaxReferencePage: HttpRequestBuilder =
    http("Navigate to Enter the Inheritance Tax reference number Page")
      .get(s"$baseUrl$route/enter-inheritance-tax-reference": String)
      .check(status.is(200))
    .check(saveCsrfToken())

  def postEnterInheritanceTaxReferencePage(taxReference: String): HttpRequestBuilder =
    http("Post Enter the Inheritance Tax reference number Page")
      .post(s"$baseUrl$route/enter-inheritance-tax-reference": String)
      .formParam("csrfToken", csrfTokenExpr)
      .formParam("value", _ => taxReference)
      .check(status.is(303))
      .check(header(locationHeaderExpr).is(s"$route/name-of-deceased": String))

  def getNameOfDeceasedPage: HttpRequestBuilder =
      http("Navigate to Enter the full name of the deceased person Page")
        .get(s"$baseUrl$route/name-of-deceased": String)
        .check(status.is(200))
        .check(saveCsrfToken())

  def postNameOfDeceasedPage(firstForename: String, surname: String): HttpRequestBuilder =
      http("Post Enter the full name of the deceased person Page")
        .post(s"$baseUrl$route/name-of-deceased": String)
        .formParam("csrfToken", csrfTokenExpr)
        .formParam("firstForename", _ => firstForename)
        .formParam("surname",_ =>  surname)
       .check(status.is(303))
      .check(header(locationHeaderExpr).is(s"$route/enter-national-insurance-number": String))

  def getEnterNationalInsuranceNumberPage: HttpRequestBuilder =
    http("Navigate to Deceased has a National Insurance number Page")
      .get(s"$baseUrl$route/enter-national-insurance-number": String)
      .check(status.is(200))
      .check(saveCsrfToken())

  def postEnterNationalInsuranceNumberPage(nino: String): HttpRequestBuilder =
    http("Post Deceased has a National Insurance number Page")
      .post(s"$baseUrl$route/enter-national-insurance-number")
      .formParam("csrfToken", csrfTokenExpr)
      .formParam("value", _ => "yes")
      .formParam("nino", _ => nino)
      .check(status.is(303))
      .check(header(locationHeaderExpr).is(s"$route/enter-birth-death-date"))


  def getEnterBirthDeathDatePage: HttpRequestBuilder =
      http("Navigate to Enter DOB and DOD of Deceased Page")
        .get(s"$baseUrl$route/enter-birth-death-date": String)
        .check(status.is(200))
    //.check(saveCsrfToken())

  def postEnterBirthDeathDatePage: HttpRequestBuilder =
      http("Post Enter DOB and DOD of Deceased Page")
        .post(s"$baseUrl$route/enter-birth-death-date": String)
        .formParam("csrfToken", csrfTokenExpr)
        .formParam("dateOfBirth.day", "09": Expression[String])
        .formParam("dateOfBirth.month", "11": Expression[String])
        .formParam("dateOfBirth.year", "1990": Expression[String])
        .formParam("dateOfDeath.day", "09": Expression[String])
        .formParam("dateOfDeath.month", "11": Expression[String])
        .formParam("dateOfDeath.year", "2023": Expression[String])
        .check(status.is(303))
        .check(
          header(locationHeaderExpr).is(s"$route/lpr-individual-or-organisation": String)
        )

  def getLprIndividualOrOrganisationPage: HttpRequestBuilder =
    http("Navigate to Is the legal personal representative (LPR) an individual or a member of an organisation Page")
      .get(s"$baseUrl$route/lpr-individual-or-organisation": String)
      .check(status.is(200))
      .check(saveCsrfToken())

  def postLprIndividualOrOrganisationPage: HttpRequestBuilder =
    http("Post Is the legal personal representative (LPR) an individual or a member of an organisation Page")
      .post(s"$baseUrl$route/lpr-individual-or-organisation": String)
      .formParam("csrfToken", csrfTokenExpr)
      .formParam("value", _ => "organisation")
      .check(status.is(303))
      .check(
        header(locationHeaderExpr).is(s"$route/enter-organisation-name": String)
      )

  def getLprOrganisationNamePage: HttpRequestBuilder =
    http("Navigate to Enter the name of the organisation Page")
      .get(s"$baseUrl$route/enter-organisation-name": String)
      .check(status.is(200))
      .check(saveCsrfToken())

  def postLprOrganisationNamePage(organisationName: String): HttpRequestBuilder =
    http("Post Enter the name of the organisation Page")
      .post(s"$baseUrl$route/enter-organisation-name": String)
      .formParam("csrfToken", csrfTokenExpr)
      .formParam("value", organisationName: Expression[String])
      .check(status.is(303))
      .check(
        header(locationHeaderExpr).is(s"$route/check-your-answers": String)
      )

  def getOrganisationCYAPage: HttpRequestBuilder =
    http("Navigate to Check and submit the report Page")
      .get(s"$baseUrl$route/check-your-answers": String)
      .check(status.is(200))
       .check(saveCsrfToken())

  def postOrganisationCYAPage: HttpRequestBuilder =
    http("Post Check and submit the reportPage")
      .post(s"$baseUrl$route/check-your-answers": String)
      .formParam("csrfToken", csrfTokenExpr)
      .check(status.is(303))
      .check(
        header(locationHeaderExpr).is(s"$route/psa-declaration": String)
      )

  def getPsaDeclarationPage: HttpRequestBuilder =
    http("Navigate to Declaration Page")
      .get(s"$baseUrl$route/psa-declaration": String)
      .check(status.is(200))
      .check(saveCsrfToken())

  def postPsaDeclarationPage: HttpRequestBuilder =
    http("Post Declaration Page")
      .post(s"$baseUrl$route/psa-declaration": String)
      .formParam("csrfToken", csrfTokenExpr)
      .check(status.is(303))
      .check(
        header(locationHeaderExpr).is(s"$route/ihtp-report-submitted": String)
      )

  def getPsaIHTPReportSubmittedPage: HttpRequestBuilder =
    http("Navigate to Report submitted Page")
      .get(s"$baseUrl$route/ihtp-report-submitted": String)
      .check(status.is(200))
  


}
