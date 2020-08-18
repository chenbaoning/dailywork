package com.atguigu.scala0826

object TestJieCheng {
  def main(args: Array[String]): Unit = {
    def test(i : Int) : Int = {
      if (i == 1) {
        1
      } else {
        i * test(i - 1)
      }
    }

    test(5)

  }

}
