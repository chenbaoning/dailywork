package com.atguigu.scala0624

import org.apache.spark.{SparkConf, SparkContext}

object TestFast {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("testfast").setMaster("local[*]")
    val sc = new SparkContext(conf)

  }

}
