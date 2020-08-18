package com.atguigu.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.Seconds
import org.apache.spark.{SparkConf, SparkContext}

object TestParallise {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Practice").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val textRDD: RDD[String] = sc.textFile("scala0311/in/1.txt",7)





    textRDD.saveAsTextFile("scala0311/out")

//    textRDD.pipe("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0311\\src\\main\\resources\\pipe.sh").collect()

  }

}
