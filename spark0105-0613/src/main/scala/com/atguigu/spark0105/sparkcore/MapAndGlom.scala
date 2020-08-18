package com.atguigu.spark0105.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer

object MapAndGlom {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("WC").setMaster("local")

    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc = new SparkContext(conf)

    val res0: RDD[String] = sc.makeRDD(Array("a","b","c","d"),2)

    val res1: RDD[String] = res0.glom().map((_.mkString("")))

    val res2: Array[String] = res1.collect()

    //使用mapPartition
    val res3: RDD[String] = res0.mapPartitions {
      par => {
        var buffer = new StringBuffer()
        for (elem <- par) {
          buffer.append(elem)
        }
        val res = new ArrayBuffer[String]()
        res.append(buffer.toString)
        res.iterator
      }
    }
    res3.collect().foreach(println)

    //使用foreachPartition
    res0.foreachPartition{
      par=>{
        var buffer = new StringBuffer()
        for(elem <- par){
          buffer.append(elem)
        }
        println(buffer)
      }
    }

    println((res2(0), res2(1)).toString())

  }

}
