package com.atguigu.scala1122

/**
  * author: 35951
  * date: 2020 - 05 - 27 17:24
  */
object TestObject10 {
  def main(args: Array[String]): Unit = {
    val source: List[(String, Int)] = List(("hello", 4),("hello spark", 3),("hello spark scala", 2),("hello spark scala hive", 1))
    val res0: List[String] = source.map {
      case (word, count) => {
        word + (" " + word) * (count - 1)
      }
    }
    val result: List[(String, Int)] = res0.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map {
      case (word, list) => {
        (word, list.size)
      }
    }.toList.sortBy(-_._2).take(3)
    println(result)



  }


}
