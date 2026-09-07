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
import uk.gov.hmrc.perftests.ihtp.IHTPPSPPageRequests.*
import uk.gov.hmrc.perftests.ihtp.IHTPPageRequests.*
import uk.gov.hmrc.perftests.ihtp.TestOnlyRequests.seedPrAddress

class IHTPSimulation extends PerformanceTestRunner {

  setup(
    "psa-view-submissions with Organisation",
    "PSA View Submissions with Organisation"
  ) withRequests (
    getLoginToIHTPPage,
    postLoginToIHTPPage,
    getReportInheritanceTaxOnPensionPage,
    getYouWillNeedPage,
    postYouWillNeedPage,
    getEnterInheritanceTaxReferencePage,
    postEnterInheritanceTaxReferencePage("A123456/25A"),
    getNameOfDeceasedPage,
    postNameOfDeceasedPage("John", "Smith"),
    getDoesDeceasedHasNationalInsuranceNumberPage,
    postDoesDeceasedHasNationalInsuranceNumberPage("true"),
    getEnterNationalInsuranceNumberPage,
    postEnterNationalInsuranceNumberPage("AB123456C"),
    getEnterBirthDeathDatePage,
    postEnterBirthDeathDatePage,
    getPrIndividualOrOrganisationPage,
    postPrIndividualOrOrganisationPage("organisation"),
    getPrOrganisationNamePage,
    postPrOrganisationNamePage("PR Organisation"),
    getNamePrOrganisationPage,
    postNamePrOrganisationPage("TestFirstName", "TestSurname"),
    seedPrAddress,
    getPrSubmitPaymentNoticePage,
    postPrSubmitPaymentNoticePage("true"),
    getSchemeReceivePaymentNoticePage,
    postSchemeReceivePaymentNoticePage,
    getAreBeneficiariesKnownPage,
    postAreBeneficiariesKnownPage("true"),
    getSelectBeneficiaryTypePage,
    postSelectBeneficiaryTypePage("individual"),
    getEnterNameOfBeneficiary,
    postEnterNameOfBeneficiary("Joe", "Doe"),
    getBeneficiaryNationalInsuranceNumberPage,
    postBeneficiaryNationalInsuranceNumberPage("true"),
    getBeneficiaryListPage,
    postBeneficiaryListPage,
    getCYAPage,
    postCYAPage,
    getPsaDeclarationPage
//    postPsaDeclarationPage,
//    getPsaIHTPReportSubmittedPage
  )

  setup(
    "psp-view-submissions with Organisation",
    "PSP View Submissions with Organisation"
  ) withRequests (
    getLoginToIHTPPageForPsp,
    postLoginToIHTPPageForPsp,
    getYouWillNeedPageForPsp,
    postYouWillNeedPageForPsp,
    getEnterInheritanceTaxReferencePageForPsp,
    postEnterInheritanceTaxReferencePageForPsp("A123456/25A"),
    getNameOfDeceasedPageForPsp,
    postNameOfDeceasedPageForPsp("John", "Smith"),
    getDoesDeceasedHasNationalInsuranceNumberPage,
    postDoesDeceasedHasNationalInsuranceNumberPage("true"),
    getEnterNationalInsuranceNumberPage,
    postEnterNationalInsuranceNumberPage("AB123456C"),
//    getEnterNationalInsuranceNumberPageForPsp,
//    postEnterNationalInsuranceNumberPageForPsp("AB123456C"),
    getEnterBirthDeathDatePageForPsp,
    postEnterBirthDeathDatePageForPsp,
    getPrIndividualOrOrganisationPageForPsp,
    postPrIndividualOrOrganisationPageForPsp,
    getPrOrganisationNamePageForPsp,
    postPrOrganisationNamePageForPsp("PR Organisation"),
    getNamePrOrganisationPageForPsp,
    postNamePrOrganisationPageForPsp("TestFirstname", "TestSurname"),
    seedPrAddress,
    getPrSubmitPaymentNoticePageForPsp,
    postPrSubmitPaymentNoticePageForPsp("false"),
    getSchemeReceivePaymentNoticePageForPsp,
    postSchemeReceivePaymentNoticePageForPsp,
    getSelectBeneficiaryTypePageForPsp,
    postSelectBeneficiaryTypePageForPsp("individual"),
    getEnterNameOfBeneficiaryForPsp,
    postEnterNameOfBeneficiaryForPsp("Joe", "Doe"),
    getBeneficiaryNationalInsuranceNumberPageForPsp,
    postBeneficiaryNationalInsuranceNumberPageForPsp("true"),
    getBeneficiaryListPage,
    postBeneficiaryListPage,
    getCYAPageForPsp,
    postCYAPageForPsp,
    getDeclarationPageForPsp
//    postDeclarationPageForPsp,
//    getIHTPReportSubmittedPageForPsp
  )
  setup(
    "psa-view-submissions with Individual",
    "PSA View Submissions with Individual"
  ) withRequests (
    getLoginToIHTPPage,
    postLoginToIHTPPage,
    getReportInheritanceTaxOnPensionPage,
    getYouWillNeedPage,
    postYouWillNeedPage,
    getEnterInheritanceTaxReferencePage,
    postEnterInheritanceTaxReferencePage("A123456/25A"),
    getNameOfDeceasedPage,
    postNameOfDeceasedPage("John", "Smith"),
    getDoesDeceasedHasNationalInsuranceNumberPage,
    postDoesDeceasedHasNationalInsuranceNumberPage("true"),
    getEnterNationalInsuranceNumberPage,
    postEnterNationalInsuranceNumberPage("AB123456C"),
    getEnterBirthDeathDatePage,
    postEnterBirthDeathDatePage,
    getPrIndividualOrOrganisationPage,
    postPrIndividualOrOrganisationPage("individual"),
    getPrIndividualNamePage,
    postPrIndividualNamePage("Joe", "Smith"),
    seedPrAddress,
    getPrSubmitPaymentNoticePage,
    postPrSubmitPaymentNoticePage("true"),
    getSchemeReceivePaymentNoticePage,
    postSchemeReceivePaymentNoticePage,
    getAreBeneficiariesKnownPage,
    postAreBeneficiariesKnownPage("false"),
    getCYAPage,
    postCYAPage
//    getPsaDeclarationPage,
//    postPsaDeclarationPage,
  )

  runSimulation()
}
