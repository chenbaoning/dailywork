package com.atguigu.scala0624

object TestSortBy {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,4,6,2,8,4)

    //val functionToInts: (Int => Nothing) => List[Int] = list1.sortBy(_)

    val list2: List[Int] = list1.sortBy(x => x)
  }

}
