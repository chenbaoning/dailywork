package com.atguigu.scala0826

object TestFlatten {
  def main(args: Array[String]): Unit = {
    val list: List[String] = List("hello scala spark","hello hadoop scalal")

    val listArrayString: List[Array[String]] = list.map(_.split(" "))

    val listString: List[String] = listArrayString.flatten

    list.flatMap(_.split(" "))

    println(listString)

    val sortedList= listString.sortBy(x=>x)

    println(sortedList)

  }

}
