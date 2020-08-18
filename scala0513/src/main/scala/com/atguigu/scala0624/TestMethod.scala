package com.atguigu.scala0624

object TestMethod {
  def main(args: Array[String]): Unit = {
    implicit class Trans(val self: Int) {
      def +%(x: Int) = (self * (1 + x * 1.0 / 100)).toInt

      def ! = factorial(self)

      def factorial(i: Int): Int = if (i > 1) i * factorial(i - 1) else 1

    }

    val i: Int = 120 +% 10 //报错
    println(i)
    println(10 !)
    println(120 +% 10)
    //    println(120 * (1 + 10 / 100))
    //3.


  }
}
