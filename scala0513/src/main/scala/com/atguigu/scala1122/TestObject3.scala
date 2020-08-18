package com.atguigu.scala1122

/**
  * author: 35951
  * date: 2020 - 04 - 13 14:04
  */
object TestObject3 {
  def main(args: Array[String]): Unit = {
    Student001()
  }

}

class Student001(name:String)

object Student001{
  def apply() = {
    println("apply方法被调用" )
  }
}
