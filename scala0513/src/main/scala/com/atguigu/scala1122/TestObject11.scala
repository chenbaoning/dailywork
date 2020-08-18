package com.atguigu.scala1122

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/**
  * author: 35951
  * date: 2020 - 05 - 27 19:24
  */
object TestObject11 {
  def main(args: Array[String]): Unit = {
    /*val list: List[(String, Int)] = List(("hello", 4),("hello spark", 3),("hello spark scala", 2),("hello spark scala hive", 1))

    val data: List[String] = list.map(a=>(a._1+" ")*a._2).flatMap(_.split(" "))

    val maps: Map[String, Int] = data.groupBy(a=>a).map(a=>(a._1,a._2.length))

    val strings: Array[String] = new Array[String](4)

    val arr1: Array[Int] = Array(1,2,3)
    val arr2: Array[Int] = Array(2,3,4)

    val arr3: Array[Int] = arr2 ++: arr1

    val ints: Set[Int] = Set(1,2)
    val set: mutable.Set[Int] = mutable.Set(1,2)

val buffer= ListBuffer(List(1,2,3))

    val flatten: ListBuffer[Int] = buffer.flatten

    println(arr3.mkString(","))*/

    val tuple: (Int, String) = (1,"22")
    println(tuple.x)
    val x: (Int, String) = tuple.x
    
  }

}
