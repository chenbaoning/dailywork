package com.atguigu.excercise

object TestMethod {
  def main(args: Array[String]): Unit = {
    def f1 = "venassa"
    println(f1)

    def test1(x:Double) = {
      (y:Double) => x* x* y
    }

    val res= test1(2.0)

    val res2: Double = res(3.0)

  //  println(res2)

    val a = Array(1,2,3)

    def maxmin(nums:Array[Int])={
      nums.max -> nums.min
    }

    val i: Int = 1
    val ii = 11
    //println(maxmin((1 to 10).toArray))

    val names = List("Petter", "Paul", "Mary")

    val chars: List[Char] = for(name <- names;c <- name) yield c.toUpper

    chars.foreach(println)

  }

}
