package com.atguigu.scala0624

import scala.collection.mutable

object TestBibao {
  def main(args: Array[String]): Unit = {

    var fac = 10

    def foo(i:Int) = {
      i + fac
    }
//
//    val list = List(1,2,3)
//    val i2 = list.reduceRight((x,y) => x-y)
//    println(i2)

    var stringToInt: mutable.Map[String, Int] = mutable.Map("a"-> 1)

    stringToInt += ("b" -> 2)

    println(stringToInt.mkString)

  }

}
