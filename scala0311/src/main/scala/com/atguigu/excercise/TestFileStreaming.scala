package com.atguigu.excercise

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object TestFileStreaming {
  def main(args: Array[String]): Unit = {
    // 创建上下文环境对象
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("SparkStreaming02_WordCount2")

    val ssc = new StreamingContext(sparkConf, Seconds(3))

    // 采集数据 : 文件路径
    val lineDStream: DStream[String] = ssc.textFileStream("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0311\\in")

    // 将采集的数据进行扁平化操作
    val wordDStream: DStream[String] = lineDStream.flatMap(line=>line.split( " " ))

    // 将扁平化数据进行结构的转变：(word, one)
    val wordToOneDStream: DStream[(String, Long)] = wordDStream.map {
      word => (word, 1L)
    }

    // 将转变解构后的数据进行聚合统计
    val wordToCountDStream: DStream[(String, Long)] = wordToOneDStream.reduceByKey(_+_)

    // 打印结果
    wordToCountDStream.print()

    // 释放资源
    // 流式数据处理当中，上下文环境对象不能停止的。
    // main方法不能执行完毕，因为一旦main放置执行完毕，环境对象就会被回收。
    //ssc.stop()
    // 启动采集器
    ssc.start()
    // Driver程序等待采集器的执行完毕
    ssc.awaitTermination()
  }

}
