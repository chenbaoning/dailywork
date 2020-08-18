package com.atguigu.scacla0218


import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}


object TestKafkaStreaming {
  def main(args: Array[String]): Unit = {
    // 准备配置信息
    val sparkConf = new SparkConf().setAppName("SparkStreaming01_WordCount").setMaster("local[4]")

    // 创建上下文环境对象
    val streamingContext = new StreamingContext(sparkConf, Seconds(2))

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "hadoop102:9092,hadoop103:9092,hadoop104:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "use_a_separate_group_id_for_each_stream",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )

    val topics = Array("topicA")
    val stream = KafkaUtils.createDirectStream[String, String](
      streamingContext,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )

    /*// 从Kafka中获取数据
    val kafkaDStream: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream[String, String, StringDecoder, StringDecoder](
      streamingContext,
      Map(
        ConsumerConfig.GROUP_ID_CONFIG -> "atguiguGroup",
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
        "zookeeper.connect" -> "hadoop102:2181"
      ),
      Map(

        "KafkaStreaming" -> 3
      ),
      StorageLevel.MEMORY_ONLY
    )*/

    /*val kafkaPrams: Map[String, Any] = Map(
      "bootstrap.servers" -> "hadoop102:9092,hadoop103:9092,hadoop104:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "testGroup",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> false
    )

    val kafkaDstream: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](
      streamingContext,
      PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](List("kafkaOperation"), kafkaPrams)
    )*/


    //Subscribe[String,String](List("kafkaOperation"),kafkaPrams)

//    val lineDStream: DStream[String] = stream.map {
//      case (k, v) => v
//    }
//
//    // 将一行数据进行扁平化操作
//    val wordDStream: DStream[String] = lineDStream.flatMap(line=>line.split(" "))
//
//    // 将单词转换结构
//    val wordToOneDStream: DStream[(String, Int)] = wordDStream.map(word=>(word,1))
//
//    // 聚合数据
//    val resultDStream: DStream[(String, Int)] = wordToOneDStream.reduceByKey(_+_)
//
//    resultDStream.print()
//
//    // 释放资源
//    // SparkStreaming的采集器需要长期执行，所以不能停止
//    // SparkStreaming的采集器需要明确启动
//    streamingContext.start()
//    //streamingContext.stop()
//
//    // Driver程序不能单独停止，需要等待采集器的执行结束
//    streamingContext.awaitTermination()
  }

}
