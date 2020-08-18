package com.atguigu.scala0317

import java.io.ObjectInputStream
import java.net.ServerSocket

/**
  * author: 35951
  * date: 2020 - 06 - 23 19:11
  */
object TestServer {
  def main(args: Array[String]): Unit = {
    val server = new ServerSocket(9999)
    println("server is ready....")
    val socket = server.accept()
    val ois = new ObjectInputStream(socket.getInputStream)
    var flag = true
    /*while (flag) {
      var user = ois.readObject()
      if (user == null) {
        flag = false
      } else {
        println(user.toString)
      }
    }*/

    println(ois.readObject().toString)

    Thread.sleep(10000)
    ois.close()
    socket.close()
    server.close()
  }

}
