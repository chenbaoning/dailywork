package com.atguigu.scala0919

object TestSuper {
  def main(args: Array[String]): Unit = {
    val f: father = new son
    println(f.name)
    f.eat()
  }
}

class son extends father {
  override val name = "erzi"

  override def eat() = {
    println(this.name)
  }

}

class father {
  val name = "baba"

  def eat() = {
    println("吃窝头")
  }
}

