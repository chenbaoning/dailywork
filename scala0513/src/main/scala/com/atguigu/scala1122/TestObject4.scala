package com.atguigu.scala1122

import scala.collection.mutable

/**
  * author: 35951
  * date: 2020 - 04 - 23 18:18
  */
object TestObject4 {
  def main(args: Array[String]): Unit = {
    val map: mutable.Map[String, Int] = mutable.Map(("a",1),("b",2),("c",3))
    val tuple: (String, Int) = ("c",1)

    /*if (map.keys.toList.contains(tuple._1)) {
      map.mapValues{
        data=> data + tuple._2
      }
    } else {
      map(tuple._1) = tuple._2
    }*/

    val map1: collection.Map[String, Int] = map.mapValues(data=> data + tuple._2)

    println(map1)
  }

}
