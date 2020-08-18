package com.atguigu.scala0513

import scala.collection.mutable.ArrayBuffer

object TestImplicitWork {
  def main(args: Array[String]): Unit = {
    //        val t = new test3[ParentPeople3]

    //    implicit val dd=3.1
    def test01(implicit d:Double)={
      println(d)
    }
//    val ddd = implicitly[Double]
//    test01

    println(Array("one", "two", "three").max)

    def describe(x: Any) = {
      x } match {

      case 5 => "Int five"

      case "hello" => "String hello"

      case true => "Boolean true"

      case '+' => "Char +"

    }

    println({"abc"})


    val b = ArrayBuffer[Int]()

    b += (1,2,3,4,5);b.trimEnd(3)

  }
}
