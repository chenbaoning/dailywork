package com.atguigu.scala1021

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SparkSession}

object TestSparkSql {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("Word Count")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext

    import spark.implicits._

    val df: DataFrame = (1 to 10).toDF("num")

  }

}
