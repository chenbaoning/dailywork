package com.atguigu.scala1122

import java.sql.Date

/**
  * author: 35951
  * date: 2020 - 05 - 21 19:08
  */
object TestObject8 {
  def main(args: Array[String]): Unit = {
    //(a:Int,b:Int) => a+b
    val c =(f:(Int,Int) => Int) => {
      f(10,20)
    }
    println(c((a:Int,b:Int) => a+b))

import java.sql
    val date: Date = new Date(2010,1,2)
    //val dd: Date = new sql.Date()
  }

}
