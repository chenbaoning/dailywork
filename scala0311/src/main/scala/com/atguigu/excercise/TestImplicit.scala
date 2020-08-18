package com.atguigu.excercise

import scala.collection.mutable.ArrayBuffer

object TestImplicit {

  def main(args: Array[String]): Unit = {
    implicit var str: String = "main"

    val t1 = new t1()
    //t1.name("bob")

    println(Array(1, 2, 3))
    println(ArrayBuffer(1, 2, 3))
  }


  class t1 {
    implicit var str: String = "jack"

    def name(implicit name: String = "tom" ): Unit = {
      println("name = " + name)
    }
  }
}
