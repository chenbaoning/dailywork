package com.atguigu.scala0513

object TestReturn {
  def main(args: Array[String]): Unit = {
//    def fun(x:Int):Boolean={
//      if(x>5)
//        return true
//      else
//        return false
//    }
//
//    println(fun(6))

//    def add(n:Int, m:Int): Int = return n + m
//
//    def sum1(ns: Int*): Int = ns.foldLeft(0)(add)
    val list = List(1,2,3)

   val result: Int = list.foldLeft(0)((n, m) => return n + m)

    println("result = ")



//    def foo: Int = {
//      val sumR: List[Int] => Int = _.foldLeft(0)((n, m) => return n + m)
//      sumR(List(1,2,3)) + sumR(List(4,5,6))
//    }

//    println("sum1(1,2,3) = " + sum1(1,2,3))
//    println("sum2(1,2,3) = " + sum2(1,2,3))
//    println("foo = " + foo)


  }

}
