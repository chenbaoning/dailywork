package com.atguigu.scala0624

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestWordCount {
  def main(args: Array[String]): Unit = {
    // 1. 创建 SparkConf对象, 并设置 App名字
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    // 2. 创建SparkContext对象
    val sc = new SparkContext(conf)
    // 3. 使用sc创建RDD并执行相应的transformation和action
    val rdd0: RDD[String] = sc.textFile("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0513\\src\\main\\resources\\input")

    //sc.makeRDD()


    rdd0.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .sortByKey()
      .foreach(println)
    // 4. 关闭连接
    sc.stop()

    def positions(length: Long, numSlices: Int): Iterator[(Int, Int)] = {
      (0 until numSlices).iterator.map { i =>
        val start = ((i * length) / numSlices).toInt
        val end = (((i + 1) * length) / numSlices).toInt
        (start, end)
      }
    }

  }

}
