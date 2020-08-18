package com.atguigu.scala0624
import scala.collection.immutable.StringOps

object TestFlatmap {
  def main(args: Array[String]): Unit = {
    val tuples: List[(String, Int)] = List(("hello atguigu",3),("hello scala",2))

    val chars: List[Char] = tuples.flatMap(x=>x._1)

    val strings: List[String] = tuples.map(x=>(x._1 + "") * x._2)




  }

}
