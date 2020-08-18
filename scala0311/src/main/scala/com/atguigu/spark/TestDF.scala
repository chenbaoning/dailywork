package com.atguigu.spark

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object TestDF {
  def main(args: Array[String]): Unit = {
    // 测试自定义的聚合函数
    val spark: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("TestDF")
      .getOrCreate()

    import spark.implicits._

    val peopleDf: DataFrame = spark.read
      .option("inferSchema", true.toString)
      .csv("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0311\\src\\main\\resources\\people1.csv")
    peopleDf.show()

    val ds: Dataset[People1] = peopleDf.as[People1]

    ds.show()


  }

}

case class People1(_c0:BigInt,_c1:String)
