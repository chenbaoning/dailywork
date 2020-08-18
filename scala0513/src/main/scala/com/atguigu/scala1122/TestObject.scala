package com.atguigu.scala1122

import org.apache.hadoop.io.{BytesWritable, NullWritable}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 05 - 15 23:06
  */
object TestObject {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)


    val res = sc.sequenceFile("F:\\cnbj4-talos_structure_audit_log_zjyprc-hadoop_zjy-hadoop-prc-transfer88.bj_1_20200515-202233", classOf[NullWritable], classOf[BytesWritable])

    val res1: RDD[BytesWritable] = res.map(_._2)
    val res2: RDD[String] = res1.map(_.copyBytes().toString)



    res2.foreach(println)

    sc.stop()
    val q: String = "q"

  }

}
