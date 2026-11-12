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

  val pauseTest = pause(270 milliseconds).actionBuilders.last

  setup(
    "ihtp-submission",
    "Ihtp Submission"
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

  runSimulation()
}
