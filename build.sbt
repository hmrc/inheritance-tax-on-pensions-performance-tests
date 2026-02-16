lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "inheritance-tax-on-pensions-performance-tests",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.13.16",
    scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:postfixOps"),
    Test / testOptions := Seq.empty,
    Test / parallelExecution := false,
    libraryDependencies ++= Dependencies.test
  )
