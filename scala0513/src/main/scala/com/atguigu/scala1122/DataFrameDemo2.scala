package com.atguigu.scala1122

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

/**
  * author: 35951
  * date: 2020 - 04 - 22 21:58
  */
object DataFrameDemo2 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("Word Count")
      .getOrCreate()
    val sc: SparkContext = spark.sparkContext
    val rdd: RDD[(String, Int)] = sc.parallelize(Array(("lisi", 10), ("zs", 20), ("zhiling", 40)))
    // 映射出来一个 RDD[Row], 因为 DataFrame其实就是 DataSet[Row]
    val rowRdd: RDD[Row] = rdd.map(x => Row(x._1, x._2))
    // 创建 StructType 类型
    val types = StructType(Array(StructField("name", StringType), StructField("age", IntegerType)))
    val df: DataFrame = spark.createDataFrame(rowRdd, types)
    df.show
  }
}
