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

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.ihtp.IHTPPageRequests.*
import uk.gov.hmrc.perftests.ihtp.IHTPPSPPageRequests.*


class IHTPSimulation extends PerformanceTestRunner {

  setup(
    "psa-view-submissions with Organisation",
    "PSA View Submissions with Organisation"
  ) withRequests(
    getLoginToIHTPPage,
    postLoginToIHTPPage,
    getReportInheritanceTaxOnPensionPage,
    getYouWillNeedPage,
    postYouWillNeedPage,
    getEnterInheritanceTaxReferencePage,
    postEnterInheritanceTaxReferencePage("A123456/25A"),
    getNameOfDeceasedPage,
    postNameOfDeceasedPage("John","Smith"),
    getEnterNationalInsuranceNumberPage,
    postEnterNationalInsuranceNumberPage("AB123456C"),
    getEnterBirthDeathDatePage,
    postEnterBirthDeathDatePage,
    getLprIndividualOrOrganisationPage,
    postLprIndividualOrOrganisationPage("organisation"),
    getLprOrganisationNamePage,
    postLprOrganisationNamePage("LPR Organisation"),
    postCYAPage,
    postCYAPage,
    getPsaDeclarationPage,
    postPsaDeclarationPage,
    getPsaIHTPReportSubmittedPage,

  )

  setup(
    "psp-view-submissions with Organisation",
    "PSP View Submissions with Organisation"
  ) withRequests(
    getLoginToIHTPPageForPsp,
    postLoginToIHTPPageForPsp,
    getYouWillNeedPageForPsp,
    postYouWillNeedPageForPsp,
    getEnterInheritanceTaxReferencePageForPsp,
    postEnterInheritanceTaxReferencePageForPsp("A123456/25A"),
    getNameOfDeceasedPageForPsp,
    postNameOfDeceasedPageForPsp("John", "Smith"),
    getEnterNationalInsuranceNumberPageForPsp,
    postEnterNationalInsuranceNumberPageForPsp("AB123456C"),
    getEnterBirthDeathDatePageForPsp,
    postEnterBirthDeathDatePageForPsp,
    getLprIndividualOrOrganisationPageForPsp,
    postLprIndividualOrOrganisationPageForPsp,
    getLprOrganisationNamePageForPsp,
    postLprOrganisationNamePageForPsp("LPR Organisation"),
    postCYAPageForPsp,
    postCYAPageForPsp,
    getDeclarationPageForPsp,
    postDeclarationPageForPsp,
    getIHTPReportSubmittedPageForPsp,

  )
  setup(
    "psa-view-submissions with Individual",
    "PSA View Submissions with Individual"
  ) withRequests(
    getLoginToIHTPPage,
    postLoginToIHTPPage,
    getReportInheritanceTaxOnPensionPage,
    getYouWillNeedPage,
    postYouWillNeedPage,
    getEnterInheritanceTaxReferencePage,
    postEnterInheritanceTaxReferencePage("A123456/25A"),
    getNameOfDeceasedPage,
    postNameOfDeceasedPage("John", "Smith"),
    getEnterNationalInsuranceNumberPage,
    postEnterNationalInsuranceNumberPage("AB123456C"),
    getEnterBirthDeathDatePage,
    postEnterBirthDeathDatePage,
    getLprIndividualOrOrganisationPage,
    postLprIndividualOrOrganisationPage("individual"),
    getLprIndividualNameChangePage,  //Usingchangenameurltoavoidaddresslookup
    postLprIndividualNameChangePage("Joe", "Smith"), //Usingchangenameurltoavoidaddresslookup
    getCYAPage,
    postCYAPage,
//    getPsaDeclarationPage,
//    postPsaDeclarationPage,
  )


    runSimulation()
}
