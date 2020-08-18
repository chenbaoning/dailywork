package com.atguigu.scala0826

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestSortBy {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    // 3.5 创建一个RDD
    val rdd3: RDD[(Int, Int,Int)] = sc.makeRDD(List((2, 1,3), (1, 2,2), (1, 1,1), (2, 2,3)))

    // 3.6 先按照tuple的第一个值排序，相等再按照第2个值排
    rdd3.sortBy(t=>t).collect().foreach(println)

    //4.关闭连接
    sc.stop()



  }

}
