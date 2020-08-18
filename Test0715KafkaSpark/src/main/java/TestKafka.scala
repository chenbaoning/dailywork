import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka.KafkaUtils

object TestKafka {
  def main(args: Array[String]): Unit = {
    //环境配置对象
    val conf = new SparkConf().setAppName("SparkStreaming04_Kafka").setMaster("local[*]")
    // 上下文
    val ssc = new StreamingContext(conf,Seconds(3))
    // 消费Kafka中的数据
    // kafka 参数
    //kafka参数声明
    val brokers = "hadoop102:9092,hadoop103:9092,hadoop104:9092"
    val topic = "topic_event"
    val group = "bigdata"
    val deserialization = "org.apache.kafka.common.serialization.StringDeserializer"
    val kafkaParams = Map(
      ConsumerConfig.GROUP_ID_CONFIG -> group,
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers,
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> deserialization,
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> deserialization
    )
    val kafkaDS: InputDStream[(String, String)] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](
      ssc, kafkaParams, Set(topic))



    //对数据进行操作
    val mapDS: DStream[String] = kafkaDS.map(_._2)
    val wordDS: DStream[String] = mapDS.flatMap(_.split(" "))
    val wordToOneDS: DStream[(String, Int)] = wordDS.map((_,1))
    val wordToSumDS: DStream[(String, Int)] = wordToOneDS.reduceByKey(_+_)
    wordToSumDS.print()
    // 启动采集器
    ssc.start()
    ssc.awaitTermination()
  }

}
