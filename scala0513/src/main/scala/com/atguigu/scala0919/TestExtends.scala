package com.atguigu.scala0919

import scala.collection.mutable.ListBuffer

object TestExtends {
  def main(args: Array[String]): Unit = {
    var buffer: ListBuffer[Int] = ListBuffer(1, 2, 3, 4)
    val ints: ListBuffer[Int] = buffer.+:(5)
    buffer.append(6)
    buffer.+=(7)
    ints.foreach(println)
//    buffer.foreach(println)
  }

}
