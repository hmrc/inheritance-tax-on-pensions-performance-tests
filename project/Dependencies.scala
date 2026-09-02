import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc" %% "performance-test-runner" % "6.3.0" % Test,
    "uk.gov.hmrc" %% "domain-test-play-30" % "13.0.0" % Test
  )
}
