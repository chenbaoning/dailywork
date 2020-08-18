package com.atguigu

/**
  * author: 35951
  * date: 2020 - 07 - 01 22:03
  */
object TestCoin {
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty || money<0) 0
    else if (coins.tail.isEmpty && (money % coins.head==0)) 1
    else countChange(money, coins.tail) + countChange(money-coins.head, coins)
  }

  def main(args: Array[String]): Unit = {
    val i: Int = countChange(17,List(10,5))
    println(i)
  }

}
