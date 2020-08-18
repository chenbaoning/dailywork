package com.atguigu.excercise

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.receiver.Receiver

import scala.util.control.Breaks

object TestSocketStreaming {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("NetCat").setMaster("local[*]")
    val ssc = new StreamingContext(conf, Seconds(3))
    val unit: ReceiverInputDStream[String] = ssc.receiverStream(new Soure("hadoop102", 9999))
    val unit1: DStream[String] = unit.flatMap(i => i.split(" "))
    val unit2: DStream[(String, Int)] = unit1.map((_, 1))
    val unit3: DStream[(String, Int)] = unit2.reduceByKey(_ + _)
    unit3.print()
    ssc.start()
    ssc.awaitTermination()
  }
}

class Soure(host: String, port: Int) extends Receiver[String](StorageLevel.MEMORY_ONLY) {

  def receiver(): Unit = {
    val socket = new Socket(host, port)
    val reader = new BufferedReader(new InputStreamReader(socket.getInputStream, "UTF-8"))
    var io = reader.readLine()
    print("********" + io + "********")
    Breaks.breakable {
      while (io != null) {
        if (io.equals("55555")) {
          Breaks.break()
        } else {
          store(io)
          io = reader.readLine()
        }
      }
    }





  }
  override def onStart(): Unit = {
    new Thread(new Runnable {
      override def run(): Unit = {
        receiver()
      }
    }).start()
  }

  override def onStop(): Unit = {
  }

}
