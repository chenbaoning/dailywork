package com.atguigu.scacla0218

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

object TestSocketStreaming {
  def main(args: Array[String]): Unit = {
    // 创建Spark配置信息
    val streamingConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("StreamingWordCount")

    // 创建流式数据处理上下文对象
    val ssc: StreamingContext = new StreamingContext(streamingConf, Seconds(5))

    // 保留状态需要设置检查点的目录
    ssc.sparkContext.setCheckpointDir("cp")

    // 从指定端口采集数据,封装为DStream,但是需要保留每一次统计的结果（状态）
    val socketDStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop102", 9999)

    // 将获取的一行数据分解为单词
    val wordDStream: DStream[String] = socketDStream.flatMap(_.split(" "))

    // 为了统计方便，将单词转换结构，变成元组数据
    val tupleDStream: DStream[(String, Int)] = wordDStream.map(word=>(word, 1))

    // 聚合统计结果
    //val resultDStream: DStream[(String, Int)] = tupleDStream.reduceByKey(_+_)
    val resultDStream: DStream[(String, Int)] = tupleDStream.updateStateByKey((items: Seq[Int], opt: Option[Int]) => {

      var totalcnt = items.sum + opt.getOrElse(0)

      Option(totalcnt)
    })

    // 打印结果
    resultDStream.print()

    // 启动流式处理
    ssc.start()

    // 等待数据
    ssc.awaitTermination()
  }
}
