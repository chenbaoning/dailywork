package com.atguigu.excercise

object TestFunction {
  def main(args: Array[String]): Unit = {
    val list1: List[Any] = List(1,"2",3,"4",5,"6")

    val ints: List[Int] = list1.map {
      case i: Int => i * 2
      case s: String => s toInt
    }
    println(ints)

    var y = 1

    var x = {}

    x = y = 1

//    val tuples: List[(String, Any)] = List(("1",1),("12","1"),("3","1"),("2","1"),("22","1"))
//
//    val list2: List[Any] = tuples.flatMap(t=>List(t._1,t._2))
//
//    def fun(tuple:(String,Any)) = {
//      tuple._1 + tuple._2
//    }
//
//    tuples.flatMap(t=>t._1+t._2)
//
//    list2.foreach(println)

    val list3: List[Int] = List(1, 2, 3, 4 ,5)

    val min: Int = list3 reduceLeft((l,r)=> {if (l < r) l else r})

    list3.reduceLeft(_ + _)

    println(min)

    val words: List[String] = List("the", "quick", "brown", "fox")
    val wordList: List[Int] = words map (_.length)
    println(wordList + " 显示每个单词长度")

  }
}
