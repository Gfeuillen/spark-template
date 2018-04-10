import sbt._

object Dependencies {
  val sparkVersion = "$spark_version$"

  lazy val lightHouseTesting = "be.dataminded"              %% "lighthouse-testing" % "0.2.1" % Test
  lazy val logback           = "ch.qos.logback"             % "logback-classic"     % "1.2.3"
  lazy val scalaLogging      = "com.typesafe.scala-logging" %% "scala-logging"      % "3.7.2"

  lazy val testDependencies = Seq(lightHouseTesting, logback, scalaLogging)

  lazy val sparkSql  = "org.apache.spark" %% "spark-sql"   % sparkVersion % Provided
  lazy val sparkCore = "org.apache.spark" %% "spark-core"  % sparkVersion % Provided
  lazy val sparkHive = "org.apache.spark" %% "spark-hive"  % sparkVersion % Provided
  lazy val sparkMlib = "org.apache.spark" %% "spark-mllib" % sparkVersion % Provided

  lazy val sparkDependencies = Seq(sparkCore, sparkSql, sparkHive, sparkMlib)
}
