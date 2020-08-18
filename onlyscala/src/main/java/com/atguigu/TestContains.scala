package com.atguigu

/**
  * author: 35951
  * date: 2020 - 08 - 13 9:25
  */
object TestContains {
  def main(args: Array[String]): Unit = {
    val t: (Int, Int) = (1,2)
    val t2 = (1L,2L)

    val bool: Boolean = t == t2

    println(1 == 1L)

    println(bool)

    val l: List[(Int, Int)] = List(t)
    println(l.contains(t2))
  }

}
