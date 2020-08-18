package com.atguigu.spark0513

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object testCombine {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val rdd: RDD[(Int, Int)] = sc.makeRDD(List((1,1),(1,1),(1,3),(2,1)))

    val rdd1 = rdd.combineByKey[Int](
      (value:Int) => value,
      (old:Int, value:Int) => (old + value),
      (value1:Int, value2:Int) => (value1 + value2)
    )
    rdd1.collect().foreach(println)

  }

}
