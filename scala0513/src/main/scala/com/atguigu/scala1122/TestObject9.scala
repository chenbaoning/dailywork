package com.atguigu.scala1122

import scala.collection.mutable.ListBuffer

/**
  * author: 35951
  * date: 2020 - 05 - 27 17:11
  */
object TestObject9 {
  def main(args: Array[String]): Unit = {
    val source: List[(String, Int)] = List(("hello", 4),("hello spark", 3),("hello spark scala", 2),("hello spark scala hive", 1))

    val res0: List[(String, Int)] = source.flatMap {
      case (words, count) => {
        val result: ListBuffer[(String, Int)] = new ListBuffer[(String, Int)]()
        for (elem <- words.split(" ")) {
          result.append((elem, count))
        }
        result
      }
    }
    val result: Map[String, Int] = res0.groupBy(_._1).map {
      case (word, counts) => {
        (word, counts.map(_._2).sum)
      }
    }
    println(result.toList.sortBy(-_._2).take(3))

  }

}
