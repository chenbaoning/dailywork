package com.atguigu.scala1021

object TestConstrctor1 {
  def main(args: Array[String]): Unit = {
    val cat: AnimalDemo = new AnimalDemo("cat")

    //cat = new AnimalDemo("dog")

    cat.name = "dog"

    val animal: Class[_ <: AnimalDemo] = cat.getClass
  }


}

class AnimalDemo(var name:String){

}
