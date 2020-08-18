package com.atguigu.scala.test

class Person {

  private var name: String = "bobo"
  protected var age: Int = 18
  private[test] var sex: String = "男"

  def say(): Unit = {
    println(name)
  }
}


object Person {

  def main(args: Array[String]): Unit = {

    val person = new Person

    person.say()

    println(person.name)

    println(person.age)
  }
}


class Teacher extends Person {

  def test(): Unit = {
    this.age
    this.sex
  }
}

class Animal {
  def test: Unit = {
    new Person().sex
  }
}

