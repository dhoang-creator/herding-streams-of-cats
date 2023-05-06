ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.3"

lazy val root = (project in file("."))
  .settings(
    name := "Herding-Streams-Of-Cats"
  )

libraryDependencies ++= Seq(
  // Cats & Cats Effect
  "org.typelevel"         %% "cats-core"              % "2.9.0",
  "org.typelevel"         %% "cats-effect"            % "3.4.9",

  // MUnits
  "org.typelevel"         %% "munit-cats-effect-3"    % "1.0.7" % Test,

  "com.disneystreaming"   %% "weaver-cats"            % "0.8.1" % Test
)

testFrameworks += new TestFramework("weaver.framework.CatsEffect")