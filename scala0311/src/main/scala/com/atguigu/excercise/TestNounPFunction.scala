package com.atguigu.excercise

object TestNounPFunction {
  def main(args: Array[String]): Unit = {
    def fun1(name: String): String = {
      return "luyan"
    }

    /*//1.声明函数后，可以将函数体最后一行语句作为函数的返回值，return可以省略
    def fun2(name: String): String = {
      name
    }

    //2.如果函数可以自动推断返回值类型，返回值类型可以省略
    def fun3(name: String) = {
      name
    }

    //3.如果函数体只有一行代码，花括号可以省略，如果需要返回结果 return不能写，花括号省略的函数体只能有一行代码
    def fun4(i: Int, j: Int) = i + j
    //      println(fun4(5,3))

    //4.如果参数列表无参，参数列表的小括号可以省略，调用时只能用函数名
    def fun5 = println("abc")
    //5.如果函数的参数列表未声明，调用时不能使用小括号
    //      fun5*/

    def fun6() = {
      println("fun6")
    }

    val f1: () => Unit = fun6 _

    f1()
    //6.如果函数的参数列表已声明且没有不需要传参，调用时可以使用小括号或者不使用小括号
    //      fun6
/*
    //7.如果函数体中有明确的return语法，必须声明返回值类型
    def fun7(): String = {
      return "Hello"
    }

    def fun8(i: Int) = {
      if (i % 2 == 0) {
        "偶数"
      } else {
        i
      }
    }

    //8.如果函数声明返回值类型为Unit，函数体中的return语句不起作用
    def fun9(): String = {
      return "Java"
    }
    //      println(fun9())

    //9.如果Unit类型也想省略，同时将等号一并省略
    //无返回值，省略方法返回值类型的函数称为过程
    def fun10(name: String*) {
      println(name)
    }
    //      fun10("hello","world")

    //10.匿名函数
    //方式1：()->{函数体}
    // a.不能有参数
    // b.可以有return语句，如果获取返回值

    //      (name : String)->{println("")}
    //方式2：(参数)=>{函数体}
    //a.不支持可变参数
    //b.匿名函数赋值给变量，变量的类型是<functionN>，N代表参数个数，N最大22个
    //c.调用时函数名()，()不可省略
    //          val fun12 = (name:String*) => {return ""}
    //          println(fun12(("a")))

    //val fun11 = ()->{for (i <- 1 to 10) println(i)}

    //匿名函数
    //    println(() => println("xxxxx")) //
    //
    //        def f9 = () => println("yyyyy")
    //        println(f9)
    //        var f10 = (a:Int) => {println(a + 1)};
    //        println(f10)
    //    var f11 = (a:Int,b:Int) => {a + b}
    //    println(f11)

    val f12: (Int, Int) => Int = (i: Int, j: Int) => {
      i + j
    }
    //println(f12)

    val array1: Array[Int] = Array(0, 0)
    val array2: Array[Int] = Array[Int](1, 1)

    val sorted: Array[Int] = Array(1, 7, 2, 9).sorted
    sorted.foreach(println)

    var y = 1
    var x = {}
    x = y = 1*/

  }
}
