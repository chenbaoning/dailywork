package com.atguigu.spark0513

import org.apache.spark.sql.SparkSession

/**
  * author: 35951
  * date: 2020 - 06 - 04 22:20
  */
object TestHusband {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Spark Hive Graph Node")
      .master("local[*]")
      //.enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    val records: List[OperationRecord] = List(OperationRecord("cluster1", "uri1", "open"), OperationRecord("cluster1", "uri2", "open"),
      OperationRecord("cluster1", "uri3", "open"), OperationRecord("cluster1", "uri2", "open"))


    records.toDF().distinct().foreach(row => println("----------------------" + row))
  }


}

case class NodeRelation(cluster: String,
                        uri: String,
                        downCluster: String,
                        downUri: String) {
}
case class OperationRecord(cluster: String,
                           uri: String,
                           cmd: String)