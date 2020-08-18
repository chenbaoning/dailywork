import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

import scala.collection.mutable

/**
  * author: 35951
  * date: 2020 - 08 - 07 18:29
  */
object ReduceWordCount {
  def main(args: Array[String]): Unit = {
    // 创建Spark运行配置对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    // 创建Spark上下文环境对象（连接对象）
    val sc : SparkContext = new SparkContext(sparkConf)

    // 读取文件数据
    val fileRDD: RDD[String] = sc.textFile("C:\\Users\\35951\\IdeaProjects\\dailywork\\onlyspark\\src\\main\\resources\\word.txt")
    val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))

    val wordOneRDD: RDD[(String, Int)] = wordRDD.map((_,1))

    val mapRDD: RDD[mutable.HashMap[String, Int]] = wordOneRDD.map {
      case (str, i) => mutable.HashMap[String, Int]((str, i))
    }
    val result: mutable.HashMap[String, Int] = mapRDD.reduce {
      case (map1, map2) => {
        map1.foldLeft(map2) {
          case (map, (key, value)) => {
            map(key) = map.getOrElse(key, 0) + value
            map
          }
        }
      }
    }
    println(result)


  }

}
