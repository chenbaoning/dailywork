package com.atguigu.scala1122

import scala.collection.immutable
import java.util

/**
  * author: 35951
  * date: 2020 - 04 - 10 13:53
  */
object TestObject2 {
  def main(args: Array[String]): Unit = {
    /*val list1: List[String] = List("a","b","c")
    val res0: List[(String, Int, String)] = List(("a",10,"hello"),("cc",11,"happy"),("ddd",13,"atguigu"))

    val booleanToTuples: Map[Boolean, List[(String, Int, String)]] = res0.groupBy(_._3.contains("h"))



    list1.flatMap(_.split(""))
    val indices: Range = list1.indices

    val tuples: List[(String, Int)] = list1.zip(indices)
    val tuples2: immutable.IndexedSeq[(Int, String)] = indices.zip(list1)

    val unzip: (immutable.IndexedSeq[Int], immutable.IndexedSeq[String]) = tuples2.unzip

    val value: immutable.IndexedSeq[Int] = unzip._1

    println(value.toList)

    val res1: List[String] = List("hello atguigu study","hello spark")

    res1.flatMap(_.split(" ")).map((_,1)).groupBy(_._1).map(x=>(x._1,x._2.size))
    res1.flatMap(_.split(" ")).map((_,1))*/

    val list1: List[Int] = List(1,2,3,4)
    val list2: List[Int] = List(2,3,4,5)

    val result: List[Int] = list1.zip(list2).map(t=>t._1+t._2)

    println(result)


    def fun ={
      println("无参数列表函数")
    }

    val function: () => Unit = fun _

    val list3: util.ArrayList[String] = new util.ArrayList[String]()
    list3.add("a")
    println(list3)

  }
}
