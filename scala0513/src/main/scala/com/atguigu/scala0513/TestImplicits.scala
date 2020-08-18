package com.atguigu.scala0513
import math._
import scala.collection.mutable.ArrayBuffer



object TestImplicits {

  //implicit val str: String = "hello world!"

  def hello(implicit arg: String="good bey world!"): Unit = {
    println(arg)
  }


  def main(args: Array[String]): Unit = {

    hello

    val b: ArrayBuffer[Int] = ArrayBuffer[Int]()

    //b += Array(1,2,3)

    println(Array(1, 7, 2, 9).sorted.mkString(","))
  }

}
