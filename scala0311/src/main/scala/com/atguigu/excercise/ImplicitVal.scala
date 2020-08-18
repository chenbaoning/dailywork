package com.atguigu.excercise

object ImplicitVal {

  def main(args: Array[String]): Unit = {
    implicit val str1: String = "jack"
    def hello(implicit name: String): Unit = {
      println(name + " hello")
      def hello(): Unit = {
        println("aaa")
      }
    }
    hello


    val +*- = "hello biaoshifu"
    val +* : String = "hello BIAOSHIFU"
    println(+*)

  }
  def hello(): Unit = {
    println("bb")
  }

}
