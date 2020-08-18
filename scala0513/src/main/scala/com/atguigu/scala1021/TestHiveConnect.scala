package com.atguigu.scala1021

import org.apache.spark.sql.SparkSession

object TestHiveConnect {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("Test")
      .enableHiveSupport()
      .getOrCreate()
    import spark.implicits._
    import spark.sql

    sql("show tables").show

  }

}
