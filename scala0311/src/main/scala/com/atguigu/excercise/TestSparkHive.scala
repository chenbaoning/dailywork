package com.atguigu.excercise


import java.sql.DriverManager

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.{JdbcRDD, RDD}
import org.apache.spark.sql.{DataFrame, SparkSession}

object TestSparkHive {

  def main(args: Array[String]): Unit = {


  // 创建上下文环境对象
  val sparkConf = new SparkConf().setAppName("TestHive").setMaster("local[*]")

  val spark: SparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()
  import spark.implicits._

    //2.创建SparkContext
    val sc = new SparkContext(sparkConf)

    //3.定义连接mysql的参数
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://hadoop102:3306/rdd"
    val userName = "root"
    val passWd = "000000"

    //创建JdbcRDD
//    val rdd = new JdbcRDD(sc, () => {
//      Class.forName(driver)
//      DriverManager.getConnection(url, userName, passWd)
//    },
//      "select * from `rddtable` where `id`>=?;",
//      1,
//      10,
//      1,
//      r => (r.getInt(1), r.getString(2))
//    )
//
//    rdd.distinct()


//    // 创建RDD
  val rdd= spark.sparkContext.makeRDD(List( (1, "zhangsan", 30), (2, "lisi", 40) ))

//    val sc: SparkContext = spark.sparkContext
//
//
//  // 转换DataFrame
//  val df = rdd.toDF("id", "name", "age")
//
//  // 将数据导入到Hive中
//  val databaseName = "sparkmall190311"
//
//
//  spark.sql("create database  " + databaseName)
//  spark.sql("use " + databaseName)
//  // 保存成表
//  df.write.saveAsTable("user")
//
//  // 从Hive中获取数据
//  spark.sql("select * from user").show()
//
//  spark.stop()
//
//    val hs = "hs"
//    val hello = "hello"

  }

}
