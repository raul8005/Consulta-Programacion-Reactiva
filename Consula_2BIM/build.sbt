ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "Consula_2BIM",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.9.0-M2"
  )
