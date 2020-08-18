package com.atguigu.scala0213

import org.apache.avro.io.Encoder
import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._
import org.apache.spark.sql._

/**
  * author: 35951
  * date: 2020 - 06 - 12 20:32
  */
object TestAsDs {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
import spark.implicits._
    val df: DataFrame = spark.read.json("input/use.json")

    val ds: Dataset[User] = df.as[User]



   // val udaf = new MMyUDAF
    //    udaf.toColumn


    //df.select(udaf.toColumn).show

  }
  case class User(name:String, age:Int)
  case class AGGShuffle(var sumage:Long,var count:Long)

  /**
    * -in:输入类型
    *BUF：shuffle
    * out:输出
    *
    */
  class AreaClickUDAF extends UserDefinedAggregateFunction {
    // 输入数据的类型:  北京  String
    override def inputSchema: StructType = {
      StructType(StructField("city_name", StringType) :: Nil)
      //        StructType(Array(StructField("city_name", StringType)))
    }

    // 缓存的数据的类型: 北京->1000, 天津->5000  Map,  总的点击量  1000/?
    override def bufferSchema: StructType = {
      // MapType(StringType, LongType) 还需要标注 map的key的类型和value的类型
      StructType(StructField("city_count", MapType(StringType, LongType)) :: StructField("total_count", LongType) :: Nil)
    }

    // 输出的数据类型  "北京21.2%，天津13.2%，其他65.6%"  String
    override def dataType: DataType = StringType

    // 相同的输入是否应用有相同的输出.
    override def deterministic: Boolean = true

    // 给存储数据初始化
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      //初始化map缓存
      buffer(0) = Map[String, Long]()
      // 初始化总的点击量
      buffer(1) = 0L
    }

    // 分区内合并 Map[城市名, 点击量]
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      // 首先拿到城市名, 然后把城市名作为key去查看map中是否存在, 如果存在就把对应的值 +1, 如果不存在, 则直径0+1
      val cityName = input.getString(0)
      //        val map: collection.Map[String, Long] = buffer.getMap[String, Long](0)
      val map: Map[String, Long] = buffer.getAs[Map[String, Long]](0)
      buffer(0) = map + (cityName -> (map.getOrElse(cityName, 0L) + 1L))
      // 碰到一个城市, 则总的点击量要+1
      buffer(1) = buffer.getLong(1) + 1L
    }

    // 分区间的合并
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      val map1 = buffer1.getAs[Map[String, Long]](0)
      val map2 = buffer2.getAs[Map[String, Long]](0)

      // 把map1的键值对与map2中的累积, 最后赋值给buffer1
      buffer1(0) = map1.foldLeft(map2) {
        case (map, (k, v)) =>
          map + (k -> (map.getOrElse(k, 0L) + v))
      }

      buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
    }

    // 最终的输出. "北京21.2%，天津13.2%，其他65.6%"
    override def evaluate(buffer: Row): Any = {
      val cityCountMap = buffer.getAs[Map[String, Long]](0)
      val totalCount = buffer.getLong(1)

//      var citysRatio: List[CityRemark] = cityCountMap.toList.sortBy(-_._2).take(2).map {
//        case (cityName, count) => {
//          CityRemark(cityName, count.toDouble / totalCount)
        }
      }



    }
