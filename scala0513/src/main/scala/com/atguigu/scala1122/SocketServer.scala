package com.atguigu.scala1122

import java.io.{BufferedReader, ByteArrayInputStream, InputStreamReader, ObjectInputStream}
import java.net.{ServerSocket, Socket}
import  com.atguigu.scala1122
/**
  * author: 35951
  * date: 2020 - 05 - 22 17:13
  */
object SocketServer {
  def main(args: Array[String]): Unit = {
    val server = new ServerSocket(9999)

      val socket: Socket = server.accept()
      val inputStream = new ObjectInputStream(socket.getInputStream)
      val clientMsg = inputStream.readObject()

      clientMsg match {
        case withFunction: WithFunction => println(withFunction.fun(2, 5))
      }


    Thread.sleep(100000)
    inputStream.close()
    socket.close()
    server.close()
      }
    }



