package com.atguigu.excercise

object TestPriority {
  def main(args: Array[String]): Unit = {
    implicit val name:String="jack"

    def hello(implicit a: String)={
      println("hello "+a)
    }

    hello
  }
}
