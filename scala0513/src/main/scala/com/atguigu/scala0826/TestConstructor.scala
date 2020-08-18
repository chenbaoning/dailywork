package com.atguigu.scala0826

package test01{
  package test03{

    object Test02{
      def main(args: Array[String]): Unit = {
        val test0: Test01 = new Test01

        test0.ddd()
      }
    }
    class Test01{
      private[test03] def ddd(): Unit ={

        println("dddd")
      }
    }
  }

}

package test02{


  import com.atguigu.scala0826.test01.test03.Test01



}