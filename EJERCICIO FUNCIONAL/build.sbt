ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "EJERCICIO FUNCIONAL",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.8.0",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.8.0"
  )
