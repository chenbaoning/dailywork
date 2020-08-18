package com.atguigu.excercise

object TwoImplicitVal {
  def main(args: Array[String]): Unit = {
    // 隐式变量（值）
    //implicit val name1: String = "Scala"
    //implicit val name2: String = "World"

    def hello(implicit content: String = "jack"): Unit = {
      println("Hello " + content)
    }

    hello

  }
}
