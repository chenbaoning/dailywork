package com.atguigu.scacla0218

import scala.collection.mutable.ListBuffer

object TestYield {
  def main(args: Array[String]): Unit = {
//    val res = for (i <- 1 to 10) yield {
//      if (i % 2 == 0) {
//        i
//      } else {
//        "不是偶数"
//      }
//    }
//    println(res)
//
//    for (i <- 1 to 10  if i % 2 == 1) {
//      println("i=" + i)
//    }
//
//    //var a:Char = 'a' + 1
//
//    //println(a)
//    def foo(num:Int) = {num * 2}
//
//    foo(2)



    val listA = List(1,2,List(3,4),5)
    val listB: List[Int] = listA.flatMap {
      case i: Int => List(i)
      case list: List[Int] => list
    }
    println(listB.toString())

  }
}
