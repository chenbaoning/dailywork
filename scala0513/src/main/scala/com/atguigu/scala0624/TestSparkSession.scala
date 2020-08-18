package com.atguigu.scala0624

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object TestSparkSession {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("Word Count")
      .getOrCreate()




  }

}
