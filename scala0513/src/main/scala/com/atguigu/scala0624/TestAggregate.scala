package com.atguigu.scala0624

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestAggregate {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    // 2. 创建SparkContext对象
    val sc = new SparkContext(conf)

    /*val res1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))

    val res2: RDD[(Int, Int)] = res1.map((1,_))

    println("aggregate的结果是" + res1.aggregate(10)((_ + _), (_ + _)))

    println("++++++++++++++++")

    //Integ



    println("aggregateByKey的结果是" + res2.aggregateByKey(10)((_ + _), (_ + _)).collect()(0)._2)
*/
    val rdd: RDD[String] = sc.makeRDD(Array("12","123","234","1234"),2)

    val str: String = rdd.aggregate("0")((x, y) => (Math.max(x.length, y.length).toString), (a, b) => (a + b))
    val str2: String = rdd.aggregate("")((x, y) => (Math.min(x.length, y.length).toString), (a, b) => (a + b))
    println(str)
    println(str2)
  }

}
