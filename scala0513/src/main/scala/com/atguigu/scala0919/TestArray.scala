package com.atguigu.scala0919

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object TestArray {
  def main(args: Array[String]): Unit = {
    /*val arr1: Array[Int] = Array(12)
    //"qqq"
    val set: mutable.Set[Int] = mutable.Set(1,2,3)
    //arr1.foldLeft()
    //获取累加器的值
    var map0 = Map[(String, String), Long]()*/




    var accMap: Map[(String, String), Long]=Map((("1","2"),1L),(("1","3"),2L))

    accMap += ((("a","b"),1L))

    val map0 =Map[(String, String), Long]()

    val empty: Map[(String, String), Long] = accMap.empty

    println(empty)

    /*val mapres: Map[(String, String), Long] = accMap.foldLeft(map0) {
      case (map, ((a, b), c)) => {
        map += (((a, b), c))
        map
      }
    }
    println(mapres)*/

    //println(accMap)
    println()

//val buffer: mutable.Buffer[((String, String), Long)] = accMap.toBuffer
//    buffer(1)

//val ints: List[Int] = List(1,2,3)
//    val buffer1: mutable.Buffer[Int] = ints.toBuffer

    //对累加出来的数据进行分组


//    for(i <- 1 to 3)for(j <- 1 to 3; if i != j ) print((10 * i + j)) + " "





  }

}
