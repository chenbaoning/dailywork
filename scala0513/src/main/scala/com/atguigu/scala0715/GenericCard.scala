package com.atguigu.scala0715

object GenericCard {
  def main(args: Array[String]): Unit = {
//    getIDCard[GranderFather](new Father)
//    getIDCard[GranderFather](new GranderFather)
//    getIDCard[GranderFather](new Son)
//    getIDCard[Tongxue](new Tongxue)//报错，所以注释

    getIDCard(1)
    getIDCard(new GranderFather)
    getIDCard[Any](new Son)

  }
  def getIDCard[T >: Father](person:T): Unit ={
    println("OK,交给你了")
  }

}
class GranderFather
class Father extends GranderFather
class Son extends Father
class Tongxue
