package com.atguigu.scala0213

/**
  * author: 35951
  * date: 2020 - 06 - 01 14:56
  */
object TestObject1 {
  def main(args: Array[String]): Unit = {
    def countdownN(n:Int)={
      (0 to n).reverse foreach println
    }
    countdownN(3)

    var t: (Int, Int) = (1,2)

  }

}
