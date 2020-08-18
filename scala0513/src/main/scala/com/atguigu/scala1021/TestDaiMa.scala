package com.atguigu.scala1021

import scala.collection.mutable.ListBuffer

object TestDaiMa {
  def main(args: Array[String]): Unit = {
    //（1）创建一个可变集合
    val buffer = ListBuffer(1,2,3,4)

    buffer.drop(2)
    //（2）向集合中添加数据
    buffer.+=(5)// ListBuffer(1, 2, 3, 4, 5)
    buffer.append(6)// ListBuffer(1, 2, 3, 4, 5, 6)
    buffer.insert(1,2)// ListBuffer(1, 2, 2, 3, 4, 5, 6)

    //（3）打印集合数据
    buffer.foreach(println)

    //（4）修改数据
    buffer(1) = 6// ListBuffer(1, 6, 2, 3, 4, 5, 6)
    buffer.update(1,7)// ListBuffer(1, 7, 2, 3, 4, 5, 6)

    //（5）删除数据
    buffer.-(5)// ListBuffer(1, 7, 2, 3, 4, 5, 6)
    buffer.-=(5)// ListBuffer(1, 7, 2, 3, 4, 6) 元素
    buffer.remove(5)// ListBuffer(1, 7, 2, 3, 4) 位置
  }

}
