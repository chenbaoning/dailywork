package com.atguigu.scala1122

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
*author: 35951
*date: 2020 - 04 - 10 13:52
*/
object TestObject1 {
  def main(args: Array[String]): Unit = {
    /*val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val res0: RDD[Int] = sc.makeRDD(1 to 6)

    println(res0.partitions.size)

    val i: Int = res0.aggregate(10)(_-_,_-_)
    println(i)*/

    var i: Int = -11%5
    println(i)

    i -= 1

    val bool: Boolean = "".startsWith("")

    val intToInt: Map[Int, Int] = Map((1,2))
   // intToInt(1)=3

   var buffer: ListBuffer[Int] = ListBuffer(1,2,3)
  }

}
