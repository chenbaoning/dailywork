package com.atguigu.scala1122



trait Ball {
  def describe(): String = {
    "ball"
  }
}

trait Color extends Ball {
  override def describe(): String = {
    "blue-" + super.describe()
  }
}

trait Category extends Ball {
  override def describe(): String = {
    "foot-" + super.describe()
  }
}

class MyBall extends Color with Category {
  override def describe(): String = {
    "my ball is a " + super.describe()
  }
}

object TestTrait {
  def main(args: Array[String]): Unit = {
    println(new MyBall().describe())
  }
}
