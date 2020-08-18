package com.atguigu.scacla0218

object TestApply {
  def main(args: Array[String]): Unit = {
    // 创建对象,如果直接使用类名，那么编译器会自动调用伴生对象中的apply方法
//    val emp = Emp7("zhangsan")
//    emp()
    //通过伴生对象创建对象
//    val user = Emp7(20)
//    println(user.test())
  }
}

//class Emp7 {
//  //貌似不在伴生对象中定义也可以
//  def apply() = {
//    println("伴生类中apply方法被调用")
//  }
//  def test(): Unit ={
//    println("aa")
//  }
//  def apply(age:Int):Emp7 = new Emp7()
//}
//object Emp7 {
//  // 应用方法，用于构建对象
////  def apply: Emp7 = new Emp7()
//
//    def apply(name:String) = new Emp7()
////
////      def apply(age:Int):Emp7 = new Emp7()
//}
//class User {
//  // 声明属性：和声明变量完全一致
//  var username : String = _
//  var age : Int = _
//
//  // 声明方法：和声明函数完全一致
//  def login(): Boolean = {
//    //方法体
//    true
//  }
//
//  //def test():String
//}
//// Emp
//// Emp$
//// 伴生对象
//object User {
//
//}

