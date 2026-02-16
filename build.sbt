lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "inheritance-tax-on-pensions-performance-tests",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "3.3.7",
    scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:postfixOps"),
    Test / testOptions := Seq.empty,
    Test / parallelExecution := false,
    libraryDependencies ++= Dependencies.test,

    // Fork for Gatling
    fork in Gatling := true,

    // JVM options for the forked Gatling process
    javaOptions in Gatling ++= Seq(
      "--add-opens=java.base/java.lang=ALL-UNNAMED"
    )
  )
