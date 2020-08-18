package com.atguigu

/**
  * author: 35951
  * date: 2020 - 07 - 06 15:38
  */
object TestFor {
  def main(args: Array[String]): Unit = {
    //for(i <- 1 to 3  ; j <- 1 to 3; if i != j ) print((10 * i + j) + " ")

    println(Map("book" -> 5, "pen" -> 2).map(m => m._1 -> m._2 * 2))
  }

}
