package com.atguigu.spark0513

import java.util

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestFlatmap {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("TestFlatmap").setMaster("local[*]").set("spark.default.parallelism","3")
    val sc: SparkContext = new SparkContext(sparkConf)

    val map = Map((1,2),(3,4))

    val list1 = List(1,2,3)
    val list2 = List(2,3,4)
    val list3: List[(Int, Int)] = list1.zip(list2)


    list1.eq(list2)


    //list1.reduceLeft(_ + "," + _)
    val list = List(List(1,2,3),List(4,5,6))

    val rdd1: RDD[List[Int]] = sc.makeRDD(list)



    val rdd2: RDD[Int] = rdd1.flatMap(list => list)

    val rdd3: RDD[(Int, Int)] = rdd2.map((_,1)).reduceByKey(_+_)

    //val rdd3: RDD[Int] = rdd2.repartition(2)

    rdd3.saveAsTextFile("./flatmapfile")

   // val rdd4= rdd1.flatMap(_)
  }

}
