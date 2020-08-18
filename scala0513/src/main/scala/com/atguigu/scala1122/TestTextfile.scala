package com.atguigu.scala1122

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 04 - 19 17:28
  */
object TestTextfile {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val res0: RDD[String] = sc.makeRDD(List("Hello","hello"))

    val value = res0.groupBy((x:String)=>x.startsWith("h"),2)

    value.foreach(println)
    sc.stop()


    /*val res0: RDD[String] = sc.textFile("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0513\\src\\main\\resources\\input",8)
        res0.saveAsTextFile("output1234")*/
  }

}
