package com.atguigu.scala0715



object TestVariable {
  def main(args: Array[String]): Unit = {

    def foo()={
      println("foo")
      1
    }
    val f1: () => Int = foo _

    val f2: Int = foo

    println(f1)
    println(f2)
  }

}
