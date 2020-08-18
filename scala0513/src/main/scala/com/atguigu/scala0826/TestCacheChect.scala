package com.atguigu.scala0826

import org.apache.spark.rdd.RDD
import org.apache.spark.{Dependency, ShuffleDependency, SparkConf, SparkContext}

object TestCacheChect {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")

    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)

    // 需要设置路径，否则抛异常：Checkpoint directory has not been set in the SparkContext
    sc.setCheckpointDir("./checkpoint1")

    //3. 创建一个RDD，读取指定位置文件:hello atguigu atguigu
    val lineRdd: RDD[String] = sc.textFile("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0513\\src\\main\\resources\\input")



    //3.1.业务逻辑
    val wordRdd: RDD[String] = lineRdd.flatMap(line => line.split(" "))

    val wordToOneRdd: RDD[(String, Long)] = wordRdd.map {
      word => {
        (word, System.currentTimeMillis())
      }
    }

    val result: RDD[(String, Long)] = wordToOneRdd.reduceByKey(_ + _)

//    result.dependencies.foreach{
//      case shuffleDep: ShuffleDependency[_, _, _] =>
//        println("一个宽依赖" + shuffleDep)
//      case dependency =>
//        val ziRDD: RDD[_] = dependency.rdd
//        println("子依赖" + ziRDD.dependencies)
//    }

    result.dependencies.foreach{
      case dependency => dependency.rdd.dependencies.foreach(x => println("内部依赖" + x))
    }

    //3.5 增加缓存,避免再重新跑一个job做checkpoint
//    val cachedRDD: RDD[(String, Long)] = wordToOneRdd.cache()
//
//    println("依赖：" + "\n"+cachedRDD.toDebugString)

    //3.4 数据检查点：针对wordToOneRdd做检查点计算
//    wordToOneRdd.checkpoint()
//    println("依赖：" + "\n"+cachedRDD.toDebugString)

    //3.2 触发执行逻辑
    result.collect().foreach(println)
    // 会立即启动一个新的job来专门的做checkpoint运算

//    //3.3 再次触发执行逻辑
//    wordToOneRdd.collect().foreach(println)
//    wordToOneRdd.collect().foreach(println)

    //Thread.sleep(100000)

    //4.关闭连接
    sc.stop()

  }

}
