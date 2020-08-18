package com.atguigu.scala0513

object TestSimplify {
  def main(args: Array[String]): Unit = {
    def f1() =  {
      1
    }

    val function = f1 _
    println(function)


    def filter(arr: Array[Int], op: Int => Boolean) = {
      for (elem <- arr) yield {if (op(elem)) elem }
    }

    filter(Array(1, 2, 3, 4), x => x % 2 == 1)
    var arr1 = filter(Array(1, 2, 3, 4), _ % 2 == 1)
    println(arr1.mkString(","))

  }

}
object Test20 extends App {
  println("xxxxxxxxxxx");
}


