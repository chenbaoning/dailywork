package com.atguigu.scala1122

/**
  * author: 35951
  * date: 2020 - 05 - 13 19:10
  */
object TestObject6 {
  def main(args: Array[String]): Unit = {
    val num: Int = 2

    def filter(n:Int)={
      n % num ==0
    }

    val bool: Boolean = filter(10)
  }

}
