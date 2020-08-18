package com.atguigu.excercise

object TestFunction1 {
  def main(args: Array[String]): Unit = {
    def f1(f: (Int) => Int): Int = {
      f(1)
    }
    var a:Int = f1((a:Int) =>{a})
    var b:Int = f1(_+1)
    var c = f1(_)
    println(a)
    println(b)
    println(c)

    function1 _
  }

  def function1(n1:Int)={
    n1 + n1

    def insidefunc()={

    }
  }

}
