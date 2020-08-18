import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * author: 35951
  * date: 2020 - 04 - 26 9:16
  */
object TestKafkaReceive {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf
    val sparkConf: SparkConf = new SparkConf().setAppName("ReceiverWordCount").setMaster("local[*]")

    //2.创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    //3.读取Kafka数据创建DStream(基于Receive方式)
    val kafkaDStream: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream(ssc,
      "hadoop102:2181,hadoop103:2181,hadoop104:2181",
      "atguigu",
      Map[String, Int]("first" -> 1))

    //4.计算WordCount
    kafkaDStream.map { case (_, value) =>
      (value, 1)
    }.reduceByKey(_ + _)
      .print()

    //5.开启任务
    ssc.start()
    ssc.awaitTermination()

  }

}
