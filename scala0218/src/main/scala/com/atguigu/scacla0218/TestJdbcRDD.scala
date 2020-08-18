package com.atguigu.scacla0218

import java.sql.{Connection, ResultSet}

import org.apache.spark.SparkContext
import org.apache.spark.rdd.JdbcRDD

import scala.reflect.ClassTag

object TestJdbcRDD {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("scala","jdbcRDD")



  }

}
//class JdbcRDD[T: ClassTag](
//                            sc: SparkContext,
//                            getConnection: () => Connection,
//                            sql: String,
//                            lowerBound: Long,
//                            upperBound: Long,
//                            numPartitions: Int,
//                            mapRow: (ResultSet) => T = JdbcRDD.resultSetToObjectArray _)
