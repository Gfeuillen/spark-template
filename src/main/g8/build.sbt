import Dependencies._

lazy val root = (project in file("."))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    inThisBuild(List(
      organization := "$organization$",
      scalaVersion := "$scala_version$",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "$name;format="lower,hyphen"$",
    scalafmtOnCompile in ThisBuild := true,
    // Memory settings to be able to test with Spark
    Test / fork := true,
    Test / testOptions += Tests.Argument("-oD"),
    javaOptions ++= Seq(
      "-Xms768M",
      "-Xmx2048M",
      "-XX:+CMSClassUnloadingEnabled",
      "-Dspark.sql.shuffle.partitions=2",
      "-Dspark.shuffle.sort.bypassMergeThreshold=2",
      "-Dlighthouse.environment=test"
    ),
    scalacOptions ++= Seq("-Ypartial-unification"),
    libraryDependencies ++= testDependencies ++ sparkDependencies
  )