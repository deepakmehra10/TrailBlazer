name := "TrailBlazer"

maintainer := "trailblazer@knoldus.com"
organization in ThisBuild := "com.knoldus"
version in ThisBuild := "1.0.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion := "2.12.8"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test

lazy val `trailblazer` = (project in file("."))
  .aggregate(`temperature-processor-api`, `temperature-processor-impl`)

lazy val `temperature-processor-api` = (project in file("temperature-processor-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `temperature-processor-impl` = (project in file("temperature-processor-impl"))
  .enablePlugins(LagomScala, JavaAppPackaging, JavaServerAppPackaging)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`temperature-processor-api`)
