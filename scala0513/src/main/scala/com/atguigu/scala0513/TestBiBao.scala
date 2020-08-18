package com.atguigu.scala0513

import scala.collection.mutable.ArrayBuffer

object TestBiBao {
  def main(args: Array[String]): Unit = {
//    var i = 10
//
//    def f1(x:Int=20)={
//      println(x + i)
//      def f2(y:Int=30)={
//        println(x + y + i)
//      }
//      f2 _
//    }
//    val tempF = f1()
//    println(tempF)
//    //val tempF2 = tempF()
//    //println(tempF2)
//    //        println(f1(2)(3))

    val buffer = ArrayBuffer[Int](1,2,3)
    val buffer1: ArrayBuffer[Int] = ArrayBuffer[Int](1,2,3)

   // println(buffer == buffer1)

    val list = List(1,2,3,4,5)

     for (i <- list.productIterator){
       println(i)
     }




  }

}
