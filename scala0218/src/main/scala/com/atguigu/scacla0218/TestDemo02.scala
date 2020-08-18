package com.atguigu.scacla0218

object TestDemo02 {
  def main(args: Array[String]): Unit = {
     val emp = Emp7
    val emp1 = Emp7("zs")
    val user=Emp7(25)
  }
}
class Emp7 {

}

object Emp7 {
  def apply: Emp7 = new Emp7()

  def apply(name: String): Emp7 = new Emp7()

  def apply(age:Int):User  = new User()
}

class User {

}