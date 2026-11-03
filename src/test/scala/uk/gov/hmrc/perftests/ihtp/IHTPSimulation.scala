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

import io.gatling.core.Predef.pause
import io.gatling.core.action.builder.PauseBuilder

import scala.concurrent.duration.*
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.ihtp.IHTPPSPPageRequests.*
import uk.gov.hmrc.perftests.ihtp.IHTPPageRequests.*
import uk.gov.hmrc.perftests.ihtp.TestOnlyRequests.*

class IHTPSimulation extends PerformanceTestRunner {

  val pauseTest = pause(500 milliseconds).actionBuilders.last

  setup(
    "psa-view-submissions-with-organisation",
    "PSA View Submissions with Organisation"
  ) withActions(
    getLoginToIHTPPage, pauseTest,
    postLoginToIHTPPage, pauseTest,
    getReportInheritanceTaxOnPensionPage, pauseTest,
    getYouWillNeedPage, pauseTest,
    postYouWillNeedPage, pauseTest,
    getEnterInheritanceTaxReferencePage, pauseTest,
    postEnterInheritanceTaxReferencePage("A123456/25A"), pauseTest,
    getNameOfDeceasedPage, pauseTest,
    postNameOfDeceasedPage("DeceasedFirstName", "DeceasedSurnameName"), pauseTest,
    getDoesDeceasedHasNationalInsuranceNumberPage, pauseTest,
    postDoesDeceasedHasNationalInsuranceNumberPage("true"), pauseTest,
    getEnterNationalInsuranceNumberPage, pauseTest,
    postEnterNationalInsuranceNumberPage(), pauseTest,
    getEnterBirthDeathDatePage, pauseTest,
    postEnterBirthDeathDatePage, pauseTest,
    getPrIndividualOrOrganisationPage, pauseTest,
    postPrIndividualOrOrganisationPage("organisation"), pauseTest,
    getPrOrganisationNamePage, pauseTest,
    postPrOrganisationNamePage("PR Organisation"), pauseTest,
    getNamePrOrganisationPage, pauseTest,
    postNamePrOrganisationPage("TestFirstName", "TestSurname"), pauseTest,
    seedPrAddress, pauseTest,
    getPrSubmitPaymentNoticePage, pauseTest,
    postPrSubmitPaymentNoticePage("true"), pauseTest,
    getSchemeReceivePaymentNoticePage, pauseTest,
    postSchemeReceivePaymentNoticePage("AddBeneficiary"), pauseTest,
    getAreBeneficiariesKnownPage, pauseTest,
    postAreBeneficiariesKnownPage("true"), pauseTest,
    getSelectBeneficiaryTypePage, pauseTest,
    postSelectBeneficiaryTypePage("individual"), pauseTest,
    getEnterNameOfBeneficiary, pauseTest,
    postEnterNameOfBeneficiary("BeneficiaryFirstName", "BeneficiarySurnameName"), pauseTest,
    getDoesBeneficiaryHaveNationalInsuranceNumberPage, pauseTest,
    postDoesBeneficiaryHaveNationalInsuranceNumberPage("true"), pauseTest,
    getEnterBeneficiaryNationalInsuranceNumberPage, pauseTest,
    postEnterBeneficiaryNationalInsuranceNumberPage, pauseTest,
    seedBeneficiaryAddress(0), pauseTest,
    getEnterAmountOfInheritanceTaxPayableForIndividualBeneficiaryPage, pauseTest,
    postEnterAmountOfInheritanceTaxPayableForIndividualBeneficiaryPage("2000"), pauseTest,
    getEnterAmountOfInterestPayableForIndividualBeneficiaryPage, pauseTest,
    postEnterAmountOfInterestPayableForIndividualBeneficiaryPage("10"), pauseTest,
    getYouAddedABeneficiaryPage, pauseTest,
    postYouAddedABeneficiaryPage("false"), pauseTest,
    postCYAPage, pauseTest,
    getPsaDeclarationPage, pauseTest,
    postPsaDeclarationPage, pauseTest,
    getPsaIHTPReportSubmittedPage
  )

//  setup(
//    "psa-view-submissions-for-an-organisation-with-beneficiary-type-of-organisation",
//    "PSA View Submissions For An Organisation With Beneficiary Type Of Organisation"
//  ) withRequests (
//    getLoginToIHTPPage,
//    postLoginToIHTPPage,
//    getReportInheritanceTaxOnPensionPage,
//    getYouWillNeedPage,
//    postYouWillNeedPage,
//    getEnterInheritanceTaxReferencePage,
//    postEnterInheritanceTaxReferencePage("A123456/25A"),
//    getNameOfDeceasedPage,
//    postNameOfDeceasedPage("DeceasedFirstName", "DeceasedSurnameName"),
//    getDoesDeceasedHasNationalInsuranceNumberPage,
//    postDoesDeceasedHasNationalInsuranceNumberPage("true"),
//    getEnterNationalInsuranceNumberPage,
//    postEnterNationalInsuranceNumberPage(),
//    getEnterBirthDeathDatePage,
//    postEnterBirthDeathDatePage,
//    getPrIndividualOrOrganisationPage,
//    postPrIndividualOrOrganisationPage("organisation"),
//    getPrOrganisationNamePage,
//    postPrOrganisationNamePage("PR Organisation"),
//    getNamePrOrganisationPage,
//    postNamePrOrganisationPage("TestFirstName", "TestSurname"),
//    seedPrAddress,
//    getPrSubmitPaymentNoticePage,
//    postPrSubmitPaymentNoticePage("true"),
//    getSchemeReceivePaymentNoticePage,
//    postSchemeReceivePaymentNoticePage("AddBeneficiary"),
//    getAreBeneficiariesKnownPage,
//    postAreBeneficiariesKnownPage("true"),
//    getSelectBeneficiaryTypePage,
//    postSelectBeneficiaryTypePage("trust"),
//    getEnterNameOfTrust,
//    postEnterNameOfTrust("Test Organisation & Co ltd."),
//    getNamePrTrustBeneficiaryPage,
//    postNamePrTrustBeneficiaryPage("PRTrustBeneficiaryFirstname", "PRTrustBeneficiarySurname"),
//    seedBeneficiaryAddress(0),
//    getEnterAmountOfInheritanceTaxPayableForTrustBeneficiaryPage,
//    postEnterAmountOfInheritanceTaxPayableForTrustBeneficiaryPage("2000"),
//    getEnterAmountOfInterestPayableForTrustBeneficiaryPage,
//    postEnterAmountOfInterestPayableForTrustBeneficiaryPage("10"),
//    getYouAddedABeneficiaryPage,
//    postYouAddedABeneficiaryPage("false"),
//    postCYAPage,
//    postCYAPage,
//    getPsaDeclarationPage,
//    postPsaDeclarationPage,
//    getPsaIHTPReportSubmittedPage
//  )
//
//  setup(
//    "psp-view-submissions-with-organisation",
//    "PSP View Submissions with Organisation"
//  ) withRequests (
//    getLoginToIHTPPageForPsp,
//    postLoginToIHTPPageForPsp,
//    getReportInheritanceTaxOnPensionPageForPsp,
//    getYouWillNeedPageForPsp,
//    postYouWillNeedPageForPsp,
//    getEnterInheritanceTaxReferencePageForPsp,
//    postEnterInheritanceTaxReferencePageForPsp("A123456/25A"),
//    getNameOfDeceasedPageForPsp,
//    postNameOfDeceasedPageForPsp("DeceasedFirstName", "DeceasedSurnameName"),
//    getDoesDeceasedHasNationalInsuranceNumberPage,
//    postDoesDeceasedHasNationalInsuranceNumberPage("true"),
//    getEnterNationalInsuranceNumberPage,
//    postEnterNationalInsuranceNumberPage(),
//    getEnterBirthDeathDatePageForPsp,
//    postEnterBirthDeathDatePageForPsp,
//    getPrIndividualOrOrganisationPageForPsp,
//    postPrIndividualOrOrganisationPageForPsp,
//    getPrOrganisationNamePageForPsp,
//    postPrOrganisationNamePageForPsp("PR Organisation"),
//    getNamePrOrganisationPageForPsp,
//    postNamePrOrganisationPageForPsp("PRFirstname", "PRSurname"),
//    seedPrAddress,
//    getPrSubmitPaymentNoticePageForPsp,
//    postPrSubmitPaymentNoticePageForPsp("false"),
//    getSchemeReceivePaymentNoticePageForPsp,
//    postSchemeReceivePaymentNoticePageForPsp,
//    getSelectBeneficiaryTypePageForPsp,
//    postSelectBeneficiaryTypePageForPsp("individual"),
//    getEnterNameOfBeneficiaryForPsp,
//    postEnterNameOfBeneficiaryForPsp("BeneficiaryFirstName", "BeneficiarySurnameName"),
//    getDoesBeneficiaryHaveNationalInsuranceNumberPageForPsp,
//    postDoesBeneficiaryHaveNationalInsuranceNumberPageForPsp("true"),
//    getEnterBeneficiaryNationalInsuranceNumberPageForPsp,
//    postEnterBeneficiaryNationalInsuranceNumberPageForPsp,
//    seedBeneficiaryAddress(0),
//    getEnterAmountOfInheritanceTaxPayableForIndividualBeneficiaryPage,
//    postEnterAmountOfInheritanceTaxPayableForIndividualBeneficiaryPage("2000"),
//    getEnterAmountOfInterestPayableForIndividualBeneficiaryPage,
//    postEnterAmountOfInterestPayableForIndividualBeneficiaryPage("10"),
//    getBeneficiaryListRedirectToCYA,
//    getCYAPageForPsp,
//    postCYAPageForPsp,
//    getDeclarationPageForPsp,
//    postDeclarationPageForPsp,
//    getIHTPReportSubmittedPageForPsp
//  )
//
//  setup(
//    "psa-view-submissions-with-individual-no-beneficiary-known",
//    "PSA View Submissions with Individual-No-Beneficiary-Known"
//  ) withRequests (
//    getLoginToIHTPPage,
//    postLoginToIHTPPage,
//    getReportInheritanceTaxOnPensionPage,
//    getYouWillNeedPage,
//    postYouWillNeedPage,
//    getEnterInheritanceTaxReferencePage,
//    postEnterInheritanceTaxReferencePage("A123456/25A"),
//    getNameOfDeceasedPage,
//    postNameOfDeceasedPage("DeceasedFirstName", "DeceasedLastName"),
//    getDoesDeceasedHasNationalInsuranceNumberPage,
//    postDoesDeceasedHasNationalInsuranceNumberPage("true"),
//    getEnterNationalInsuranceNumberPage,
//    postEnterNationalInsuranceNumberPage(),
//    getEnterBirthDeathDatePage,
//    postEnterBirthDeathDatePage,
//    getPrIndividualOrOrganisationPage,
//    postPrIndividualOrOrganisationPage("individual"),
//    getPrIndividualNamePage,
//    postPrIndividualNamePage("PRFirstname", "PRLastname"),
//    seedPrAddress,
//    getPrSubmitPaymentNoticePage,
//    postPrSubmitPaymentNoticePage("true"),
//    getSchemeReceivePaymentNoticePage,
//    postSchemeReceivePaymentNoticePage("AddBeneficiary"),
//    getAreBeneficiariesKnownPage,
//    postAreBeneficiariesKnownPage("false"),
//    getEnterInheritanceTaxPayable,
//    PostEnterInheritanceTaxPayable("£5000"),
//    getEnterAmountOfInterestPayableForNoBeneficiariesPage,
//    postEnterAmountOfInterestPayableForNoBeneficiariesPage("10"),
//    getCYAPage,
//    postCYAPage,
//    getPsaDeclarationPage,
//    postPsaDeclarationPage,
//  )
//
//  setup(
//    "psa-view-submissions-with-no-submission-notice",
//    "PSA View Submissions with No Submission Notice"
//  ) withRequests (
//    getLoginToIHTPPage,
//    postLoginToIHTPPage,
//    getReportInheritanceTaxOnPensionPage,
//    getYouWillNeedPage,
//    postYouWillNeedPage,
//    getEnterInheritanceTaxReferencePage,
//    postEnterInheritanceTaxReferencePage("A123456/25A"),
//    getNameOfDeceasedPage,
//    postNameOfDeceasedPage("DeceasedFirstName", "DeceasedSurnameName"),
//    getDoesDeceasedHasNationalInsuranceNumberPage,
//    postDoesDeceasedHasNationalInsuranceNumberPage("true"),
//    getEnterNationalInsuranceNumberPage,
//    postEnterNationalInsuranceNumberPage(),
//    getEnterBirthDeathDatePage,
//    postEnterBirthDeathDatePage,
//    getPrIndividualOrOrganisationPage,
//    postPrIndividualOrOrganisationPage("organisation"),
//    getPrOrganisationNamePage,
//    postPrOrganisationNamePage("PR Organisation"),
//    getNamePrOrganisationPage,
//    postNamePrOrganisationPage("TestFirstName", "TestSurname"),
//    seedPrAddress,
//    getPrSubmitPaymentNoticePage,
//    postPrSubmitPaymentNoticePage("false"),
//    getSchemeReceivePaymentNoticePage,
//    postSchemeReceivePaymentNoticePage("SelectBeneficiary"),
//    getSelectBeneficiaryTypePage,
//    postSelectBeneficiaryTypePage("individual"),
//    getEnterNameOfBeneficiary,
//    postEnterNameOfBeneficiary("BeneficiaryFirstName", "BeneficiarySurnameName"),
//    getDoesBeneficiaryHaveNationalInsuranceNumberPage,
//    postDoesBeneficiaryHaveNationalInsuranceNumberPage("false"),
//    getWhyDoesBeneficiaryNotHaveNationalInsuranceNumberReasonPage,
//    postWhyDoesBeneficiaryNotHaveNationalInsuranceNumberReasonPage("Beneficiary not a UK citizen"),
//    seedBeneficiaryAddress(0),
//    getEnterAmountOfInheritanceTaxPayableForIndividualBeneficiaryPage,
//    postEnterAmountOfInheritanceTaxPayableForIndividualBeneficiaryPage("2000"),
//    getEnterAmountOfInterestPayableForIndividualBeneficiaryPage,
//    postEnterAmountOfInterestPayableForIndividualBeneficiaryPage("10"),
//    getBeneficiaryListRedirectToCYA,
//    getCYAPage,
//    postCYAPage,
//    getPsaDeclarationPage,
//    postPsaDeclarationPage
//  )
//
//  setup(
//    "psa-view-paid-reports",
//    "Psa View Paid Reports"
//  ) withRequests (
//    getLoginToIHTPPage,
//    postLoginToIHTPPage,
//    getReportInheritanceTaxOnPensionPage,
//    getViewPaidReportsPage
//  )
//
//  setup(
//    "psp-view-paid-reports",
//    "PSP View Paid Reports"
//  ) withRequests (
//    getLoginToIHTPPageForPsp,
//    postLoginToIHTPPageForPsp,
//    getReportInheritanceTaxOnPensionPageForPsp,
//    getViewPaidReportsPageForPsp
//  )

  runSimulation()
}
