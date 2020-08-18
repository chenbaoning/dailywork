package com.atguigu.scala0513

import scala.util.control.Breaks

object TestTest {
  def main(args: Array[String]): Unit = {
    var y = 0

    //var x={}
   val x=y=1

    println(x)


    Breaks.breakable(
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) Breaks.break()
      }
    )


    val fun = scala.math.ceil _
    println(fun(2.001))

    println(2.001.ceil)
  }

}
