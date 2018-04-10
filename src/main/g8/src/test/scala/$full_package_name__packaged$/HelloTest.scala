package $full_package_name$

import be.dataminded.lighthouse.testing.SparkFunSuite

class HelloTest extends SparkFunSuite {
  test("Should be able to show the hello dataframe") {
    Hello.helloWorldDataFrame(spark).show()
  }
}
