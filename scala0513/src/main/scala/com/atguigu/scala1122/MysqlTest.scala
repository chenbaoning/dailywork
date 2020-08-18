package com.atguigu.scala1122



import java.sql.DriverManager
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 04 - 20 20:39
  */
object MysqlTest {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")

    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    var driver = "com.mysql.jdbc.Driver"
    var url = "jdbc:mysql://hadoop102:3306/test"
    var username = "root"
    var passwd = "123456"
    //var sql="select * from user where id >=? and id <=?;"
    //var sql: String = "INSERT INTO `user`(`id`,`username`,`password`) VALUES(?,?,?)"
    val rdd: RDD[(Int, String, String)] = sc.makeRDD(List((2,"qiaofeng","hf"),(3,"qiaofeng","hf")))
    /*
    val value: JdbcRDD[(Int, String)] = new JdbcRDD(sc,
      () => {
        Class.forName(driver)
        DriverManager.getConnection(url,username,passwd)
      },
      sql,
      1,
      2,
      1,
      r => (r.getInt(1), r.getString(2))
    )
    value.foreach(println)
*/
    rdd.foreachPartition {
      datas => {
        //注册驱动
        Class.forName(driver)
        //获取连接
        val connection = DriverManager.getConnection(url, username, passwd)

        var sql:String = "insert into user(`id`,`username`,`password`) values(?,?,?)"
        //获取数据库操作对象
        val statement= connection.prepareStatement(sql)
        datas.foreach {
          case (id, username, password) => {

            statement.setInt(1, id)
            statement.setString(2, username)
            statement.setString(3, password)
            statement.executeUpdate()
          }
        }
        statement.close()
        connection.close()
      }
    }
    //4.关闭连接
    sc.stop()

}}
