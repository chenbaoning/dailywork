package com.atguigu.scala1122

import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 05 - 15 19:01
  */
object TestObject7 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
      .builder()
      .master("local[2]")
      .appName("AreaClickApp")
      .getOrCreate()
import spark.implicits._

    val caseClassDS = Seq(Person7("wangyuyan",2)).toDS()

    val ds1: Dataset[Person7] = caseClassDS.map(p => {
      if (p.name.startsWith("z")) {
        p.name = "li"
      }
      p
    })
    val ds2: Dataset[Person7] = ds1.filter($"age">10)


  }

}
case class Person7(var name: String,age: Long)