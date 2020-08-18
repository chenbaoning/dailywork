import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 08 - 03 19:57
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    // 创建Spark运行配置对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    // 创建Spark上下文环境对象（连接对象）
    val sc : SparkContext = new SparkContext(sparkConf)

    // 读取文件数据
    val fileRDD: RDD[String] = sc.textFile("C:\\Users\\35951\\IdeaProjects\\dailywork\\onlyspark\\src\\main\\resources\\word.txt")

    // 将文件中的数据进行分词
    val wordRDD: RDD[String] = fileRDD.flatMap( _.split(" ") )

    // 转换数据结构 word => (word, 1)
    val word2OneRDD: RDD[(String, Int)] = wordRDD.map((_,1))

    // 将转换结构后的数据按照相同的单词进行分组聚合
    val word2CountRDD: RDD[(String, Int)] = word2OneRDD.reduceByKey(_+_)

    word2CountRDD.distinct()

    word2CountRDD.zip(word2OneRDD)
    // 将数据聚合结果采集到内存中
    val word2Count: Array[(String, Int)] = word2CountRDD.collect()

    word2CountRDD.foreachPartition(rdd=>rdd.foreach(println))
    // 打印结果
    word2Count.foreach(println)

    //关闭Spark连接
    sc.stop()

  }

}
