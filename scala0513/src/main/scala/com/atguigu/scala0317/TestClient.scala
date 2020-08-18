package com.atguigu.scala0317

import java.io.ObjectOutputStream
import java.net.Socket

import com.atguigu.scala0213.TestAsDs.User

/**
  * author: 35951
  * date: 2020 - 06 - 23 19:12
  */
object TestClient {
  def main(args: Array[String]): Unit = {
    val client = new Socket("localhost",9999)
    val oos = new ObjectOutputStream(client.getOutputStream)
    val user = new User("ll",20)
    oos.writeObject(user)
    oos.flush()
    oos.close()
    client.close()
  }

}
