package $full_package_name$

import org.apache.spark.sql.{DataFrame, SparkSession}

object Hello {
  def main(args: Array[String]): Unit = {
    implicit val spark = SparkSession
      .builder()
      .enableHiveSupport()
      .getOrCreate()
    helloWorldDataFrame.show(false)
  }

  def helloWorldDataFrame(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._
    Seq(
      ("This", "is"),
      ("the", "spark"),
      ("Hello", "world")
    ).toDF()
  }
}
