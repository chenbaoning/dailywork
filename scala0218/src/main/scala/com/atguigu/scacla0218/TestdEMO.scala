package com.atguigu.scacla0218

object TestDemo01 {
  def main(args: Array[String]): Unit = {
    println(fun(1, 2, 1)) //flag初始即为1
  }


  def fun(n: Int, start: Int, flag: Int): Int = {
    //传入参数为(n-1,n,flag)
    if (n == 0) {
      //当前整数为0则返回结果
      start
    } else if (flag == 2) {
      //flag位是2则减当前整数
      fun(n - 1, start - n, 1)
    } else if (flag == 1) {
      //flag位是1则加当前整数
      fun(n - 1, start + n, 2)
    } else {
      0
    }
  }
}
