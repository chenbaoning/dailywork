package com.atguigu.scala1021

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object TestPartition {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)


    System.setProperty("HADOOP_USER_NAME","atguigu")


    val res0: RDD[String] = sc.textFile("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0513\\src\\main\\resources\\input", 3)
    res0.saveAsTextFile("output1234")

    sc.stop()
  }

}

