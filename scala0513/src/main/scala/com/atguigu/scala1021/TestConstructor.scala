package com.atguigu.scala1021

object TestConstructor {
  def main(args: Array[String]): Unit = {
    val p1: PersonDemo = new PersonDemo("zs",12)

    PersonDemo()
  }

}

class PersonDemo(inname:String,inage:Int){
  var name = inname
  var age = inage

  def foo_ = {

  }

}

object PersonDemo{
  def apply():Unit = {
    println("apply" +
      "")
  }
}