package com.atguigu.scala0826

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestPrint {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf()setAppName("WordCount")setMaster("local[*]")
    val sc = new SparkContext(conf)
    //sc.textFile("",3)
    //val res1: RDD[Int] = sc.parallelize(1 to 10,3)
    val res2: RDD[Int] = sc.makeRDD(1 to 10,3)
    //res1.foreach(print)
    //res1.foreach(x=>println(x + "println"))

    val res3: RDD[Int] = res2.sortBy(t=>t)

    res3.collect().foreach(println)
    sc.stop()
  }

}
