package com.atguigu.spark0105.sparkstreaming

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Stream_MyReceiver {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("MyReceiver").setMaster("local[*]")
    val context: StreamingContext = new StreamingContext(sparkConf, Seconds(5))

    val line: ReceiverInputDStream[String] = context.receiverStream(new MyReceiver("hadoop102", 9999))

    line.foreachRDD(rdd=> println(rdd.count()))

    val flatMapDS: DStream[String] = line.flatMap(_.split(" "))
    val resultDS: DStream[(String, Int)] = flatMapDS.map((_, 1)).reduceByKey(_ + _)
    resultDS.print()


    context.start()
    context.awaitTermination()
  }

}

class MyReceiver(host: String, port: Int) extends Receiver[String](StorageLevel.MEMORY_ONLY) {

  private var socket: Socket = _

  override def onStart(): Unit = {
    new Thread("Socket Receiver") {
      override def run() {
        receive()
      }
    }.start()
  }

  /*override def onStart(): Unit = {
    new Thread {
      () => receive()
    }.start()
  }*/

  def receive(): Unit = {
    socket = new Socket(host, port)
    val reader = new BufferedReader(new InputStreamReader(socket.getInputStream, "UTF-8"))
    var line: String = null

    while ((line = reader.readLine()) != null) {
      if ("==end==".equalsIgnoreCase(line)) {
        return
      } else {
        store(line)
      }
    }
  }



  override def onStop(): Unit = {
    if (socket != null) {
      socket.close()
      socket = null
    }
  }
}

