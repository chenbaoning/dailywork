package com.atguigu.scala0624

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestRepartition {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("lineage")
    val sc = new SparkContext(conf)
    val initRDD = sc.makeRDD(1 to 100,2)


    val res1: RDD[(Int, Int)] = initRDD.mapPartitionsWithIndex {
      (index, it) => {
        it.map((index, _))
      }
    }
 

    val value: RDD[(Int, Int)] = initRDD.map((_,1)).reduceByKey(_+_)



    val res2 = res1.repartition(4)


    res2.collect()
    println(res2.toDebugString)
    println("***************************************")
    println(res2.dependencies)
    sc.stop()

  }

}
