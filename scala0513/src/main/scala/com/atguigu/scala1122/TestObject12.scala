package com.atguigu.scala1122

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
  * author: 35951
  * date: 2020 - 06 - 05 20:31
  */
object TestObject12 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val source: RDD[String] = sc.makeRDD(List("hello","spark","scala","hello"))

   // source.map((_,1)).fold()

  }

}
