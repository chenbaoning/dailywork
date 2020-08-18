package com.aguigu{

  package object scala{
    val name = "helloyou"

    def plus(i:Int,j:Int)={i + j}
  }


  package scala{
    object TestPackageObject {
      def main(args: Array[String]): Unit = {
        println(name)

        println(plus(1, 2))
      }
    }

    class TestPackageObject{
      val name2 = name

      TestPackageObject.main(new Array[String](1) )
    }
  }


}


