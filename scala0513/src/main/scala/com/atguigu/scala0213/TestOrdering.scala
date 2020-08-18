package com.atguigu.scala0213

import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 06 - 11 17:03
  */
object TestOrdering {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")
    val sc = new SparkContext(sparkConf)
    val dataRDD = sc.makeRDD(List((1,2),(1,3),(2,2)),1)
    val reverse: Ordering[(Int, Int)] = Ordering.Tuple2[Int,Int].reverse
    //val str = dataRDD.takeOrdered(4)(Ordering.by(_._2).reverse).mkString(" ")
    //print(str)
    sc.stop()
  }

}
