package com.atguigu.scala0715

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object CacheDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("TestCache").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setCheckpointDir("./")

    sc.textFile("")

    sc.makeRDD(Array(1,2,3))

    val rdd1 = sc.parallelize(Array("ab", "bc"))
    val rdd2 = rdd1.flatMap(x => {
      println()
      println("flatMap...")
      x.split("")
    })
    val rdd3: RDD[(String, Int)] = rdd2.map(x => {
      (x, 1)
    })
    val rdd4: RDD[(String, Int)] = rdd3.reduceByKey(_+_)

    val rdd5: RDD[String] = rdd4.map(_._1).coalesce(3)

//    rdd5.cache()
//    rdd5.checkpoint()

    //println(rdd5.toDebugString)
    rdd3.cache()
    rdd3.checkpoint()



    rdd5.foreach(println)
    println("-----------")
    //println(rdd5.toDebugString)
    //rdd3.foreach(println)
    //Thread.sleep(1000000)
    sc.stop()
  }
}
