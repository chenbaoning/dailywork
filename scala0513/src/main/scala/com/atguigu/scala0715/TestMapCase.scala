package com.atguigu.scala0715

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestMapCase {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // 算子 - 转换 - partitionBy
    val datas = List((1,1),(1,2),(1,4),(1,6),(1,5),(1,3));
    //需求，value从大到小TOP3
    val dataRDD = sc.makeRDD(datas);
    val groupRDD: RDD[(Int, Iterable[Int])] = dataRDD.groupByKey();
    //由于Iterable并不能直接排序，所以需要将其转化成List

    val sortedRDD: RDD[List[Int]] = groupRDD.map(line => line._2.toList.sortWith {
      (x, y) => x > y
    })
    sortedRDD.collect().foreach(println)
//    groupRDD.map((x=>x._2.toList.sortWith()
//
//  })

    sc.stop()
  }

}
