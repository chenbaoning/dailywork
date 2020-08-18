package com.atguigu.scala1122

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Dataset, RelationalGroupedDataset, SparkSession}

/**
  * author: 35951
  * date: 2020 - 05 - 29 14:25
  */
object TestDataset {
  def main(args: Array[String]): Unit = {
    //创建上下文环境配置对象
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")

    //创建SparkSession对象
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    //RDD=>DataFrame=>DataSet转换需要引入隐式转换规则，否则无法转换
    //spark不是包名，是上下文环境对象名
    import spark.implicits._

    Array(Person("zhangwuji",32)).toList.toDS()

    val ds = Seq(Person("zhangwuji",32)).toDS()

    //val groupedDataset: RelationalGroupedDataset = ds.groupBy("name")

    //groupedDataset.count()



    val mapDataset: Dataset[(String, Person)] = ds.map(p=>(p.name,p))

    val tuples: Array[(String, Person)] = mapDataset.collect()

    val map: Map[String, Person] = tuples.toMap
    println(map)
    spark.stop()
  }
  case class Person(name:String,age:Int)

}
