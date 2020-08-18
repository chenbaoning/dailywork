package com.atguigu.scala1122

object TestFAST {
  def main(args: Array[String]): Unit = {
    val person11: Person111 = new Person111
    val t: TestFAST = new TestFAST



    def g(name:Int*): Int = {
      var ans = 1
      for (i <- name){
        ans *= i
      }
      ans
    }

    println(g(5,6))

    def rr(f:(Int*) => Int) : Unit = {
      println(f)
    }
    var res=for (i <-1 to 5 ) yield {
       i*2
    }

    println(res)







  }

}
class TestFAST{
  var p1 = new Person111()

}
class Person111{
  var name = "tiantian"
}