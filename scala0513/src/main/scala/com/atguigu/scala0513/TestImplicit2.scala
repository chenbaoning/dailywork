package com.atguigu.scala0513

object TestImplicit2 {
  def main(args: Array[String]): Unit = {
    implicit def transfer(i:Double):Int = {
      println(32)
      i.toInt
    }

    val i:Int = 2.5
    println(i)
  }
  implicit def transfer(i:Double):Int = {
    println(32)
    i.toInt
  }
}
