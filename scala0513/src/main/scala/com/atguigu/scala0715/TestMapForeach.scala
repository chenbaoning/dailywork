package com.atguigu.scala0715

import scala.collection.immutable.StringOps
import scala.collection.mutable

object TestMapForeach {
  def main(args: Array[String]): Unit = {
    val stringToInt: mutable.Map[String, Int] = mutable.Map(("hello", 1), ("atguigu", 2), ("scala", 3))

    val stringToInt2: mutable.Map[String, Int] = mutable.Map(("atguigu", 1), ("hello", 2), ("scala", 0))

    def f1(kv: (String, Int)) = {
      println(kv)
    }

    //    stringToInt2.foreach(println)
    //
    //    stringToInt2.foreach(f1)
    //
    //    stringToInt2.foreach((KV:(String,Int))=>{println(KV)})


//       val equals: Equals = stringToInt.fold(stringToInt2) {
//      (a, b) => {
//        a
//        val aa: Map[String, Int] = a.asInstanceOf[Map[String, Int]]
//        val bb: (String, Int) = b.asInstanceOf[(String, Int)]
//
//        val k: StringOps = bb._1
//        val v: Int = bb._2
//
//        aa(k) = aa.getOrElse(k, 0) + v
//
//        aa
//      }
//    }
//    val result: mutable.Map[String, Int] = equals.asInstanceOf[mutable.Map[String,Int]]

//    val result: Map[String, Int] = result.foldLeft(stringToInt2)((a, b) => a)
//
//    result.foreach(println)
//
//    println(equals)


  }

}
