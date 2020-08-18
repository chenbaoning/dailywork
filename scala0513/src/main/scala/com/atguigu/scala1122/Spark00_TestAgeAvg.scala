package com.atguigu.scala1122

import com.atguigu.udaf.MyAveragUDAF
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * author: 35951
  * date: 2020 - 04 - 23 11:16
  */
object Spark00_TestAgeAvg {
  def main(args: Array[String]): Unit = {
    //创建上下文环境配置对象
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")
    //创建SparkSession对象
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    //创建聚合函数

    //在spark中注册聚合函数
    spark.udf.register("avgAge",new MyAveragUDAF)

    //读取数据  {"username": "zhangsan","age": 20}
    val df: DataFrame = spark.read.json("D:\\dev\\workspace\\spark-bak\\spark-bak-00\\input\\test.json")

    //创建临时视图
    df.createOrReplaceTempView("user")

    //使用自定义函数查询
    spark.sql("select avgAge(age) from user").show()
  }


}
/*
定义类继承UserDefinedAggregateFunction，并重写其中方法
*/

