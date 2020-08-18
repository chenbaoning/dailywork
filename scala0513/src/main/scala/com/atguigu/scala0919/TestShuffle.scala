package com.atguigu.scala0919

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestShuffle {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val res0 = sc.makeRDD(List((2,2),(5,5),(3,3)),2)

    val res1: RDD[(Int, Int)] = res0.map {
      case (n1, n2) => {
        (n1 + 1, n2 + 1)
      }
    }
    val sortbyRDD: RDD[(Int, Int)] = res1.sortBy(_._2)

    println(sortbyRDD.dependencies)

    sortbyRDD.collect()

    sc.stop()
  }

}
