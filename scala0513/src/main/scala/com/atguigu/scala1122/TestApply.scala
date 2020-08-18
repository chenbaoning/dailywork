package com.atguigu.scala1122



object TestApply {
  def main(args: Array[String]): Unit = {
    val p1 = Person001
  }



}
class Person001 private(name:String){
  var oname = name
}

object Person001{
  def apply(name: String): Person001 = new Person001(name)
}
