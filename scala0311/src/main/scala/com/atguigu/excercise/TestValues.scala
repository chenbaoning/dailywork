package com.atguigu.excercise

object TestValues {
  def main(args: Array[String]): Unit = {
    def values(fun: (Int) => Int, low: Int, high: Int) = {
      (low to high).map(x=>(x,fun(x))).toList
    }

    //println(values(x => x * x, -5, 5).reverse.mkString)

    val lines:List[String] = List("hello scala","hello spark","hello atguigu")

    lines.flatMap(_.split(" "))

    val stringToInt: Map[String, Int] = lines.flatMap(_.split(" ")).groupBy(x=>x).map{case (word,list)=>(word,list.size)}

    val str: String = stringToInt.mkString(",")

    println(str)




    //lines.flatMap(_.spilt( " " )).groupBy(word => word ).map(t => (t._1,t._2.size))


  }
}
