package com.atguigu.scala1122

/**
  * author: 35951
  * date: 2020 - 05 - 06 21:14
  */
object TestObject5 {
  def main(args: Array[String]): Unit = {

    def describe(x:Any)={
      x match {
        case i:Int => "Int"
        case s:String => "String"
        case _ => {
          10000
        }
      }
    }

    val ll: Any = describe('a')
    println(ll)


  }

  def multi(a:Int,b:Int)={
    a * b

    def f0()={
      println("这是一个函数")
    }
  }

}
