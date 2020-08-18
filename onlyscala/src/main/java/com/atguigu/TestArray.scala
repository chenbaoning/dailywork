package com.atguigu

/**
  * author: 35951
  * date: 2020 - 07 - 02 10:10
  */
object TestArray {
  def main(args: Array[String]): Unit = {
    val arr1: Array[Int] = Array(1,2,3)
    val arr2: Array[Int] = Array(2,3,4)

    val arr3: Array[Int] = arr2 ++ arr1

    println(arr3.mkString(","))
  }

}
