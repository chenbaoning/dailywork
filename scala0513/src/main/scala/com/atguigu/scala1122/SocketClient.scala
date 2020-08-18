package com.atguigu.scala1122

import java.io._
import java.net.Socket

/**
  * author: 35951
  * date: 2020 - 05 - 22 17:13
  */
object SocketClient {
  def main(args: Array[String]): Unit = {
    val client = new Socket("localhost", 9999)
    val outputStream = new ObjectOutputStream(client.getOutputStream)

    outputStream.writeObject(new WithFunction)
    outputStream.flush()

  }

}


