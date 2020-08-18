package com.atguigu.scala0919

object TestFunction {
  def main(args: Array[String]): Unit = {
    def max(x: Int, y: Int) = {
      if (x > y) x
      y
    }

    val maxVal: Int = max(1, 2)
    /*
    用于文件操作的控制抽象示例，将对一个文件进行相关操作的这个行为抽象成了一个函数，当你决定对哪个文件执行怎样的操作时，可以传入文件对象以及操作代码块，可以传入不同的参数，实现对不同文件对象不同的操作，而柯里化的应用也使得这个控制抽象看起来像是scala语言本身提供的语法。
     */
//    import java.io._
//    def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
//      val writer: PrintWriter = new PrintWriter(file)
//      try {
//        op(writer)
//      } finally {
//        writer.close()
//      }
//    }
//
//    withPrintWriter(new File("date.txt")) {
//      (_: PrintWriter).println(new java.util.Date)
//    }

/*

 */
    def repeat(n: Int)(action: => Unit) = for (i <- 1 to n) action

    var i = 0
    repeat(5) {
      i = i + 1
    }
  }

  def Mytry(body: =>Unit)={

    try {
      body
    }catch {
      case e:Exception => 1
    }
  }

  Mytry(1/0)
}
