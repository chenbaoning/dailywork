package com.atguigu.scala0624

object TestMethod2 {
  def main(args: Array[String]): Unit = {
    def test(int: Int):String={
      return " "
    }

    def f1(i: Int=>Unit)={
      println(i)
    }

val function: Int => String = test _

    f1(test _)
//    f1(function)
  }

}
