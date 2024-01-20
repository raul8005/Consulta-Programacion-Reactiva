ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "Consulta_2Bim",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.9.0-M2",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.9.0-M2"
  )
