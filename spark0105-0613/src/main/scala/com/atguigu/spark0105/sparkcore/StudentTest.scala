package com.atguigu.spark0105.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.immutable.HashMap

object StudentTest {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDDTest").setMaster("local[*]")

    val sc = new SparkContext(conf)



    val rdd2: RDD[(Int, String, String)] = sc.makeRDD(List((1,"zhangsan","student"),(2,"lisi","teacher")))




    val rdd1: RDD[(Int, String, Int)] = sc.makeRDD(List((1,"zhangsan",30),(2,"lisi",40)))

    val rdd02: RDD[Int] = sc.makeRDD(1 to 10)
    //思路一：给map算子传进一个fun函数
//    val res0: RDD[(Int, (String, Int))] = rdd1.map(fun(_))
//
//    def fun(t:Any):(Int,(String,Int))={
//      case (x:Int, y:String, z:Int) => (x, (y, z))
//    }

    //思路二：直接在map算子中写一个匿名函数
//    rdd1.map(t => {
//      t match{
//        case (x: Int, y: String, z: Int) => (x, (y, z))
//        case _ => (1,"",1)
//      }
//    })

    //思路三：常规思路，直接进行模式匹配
    val res2: RDD[(Int, (String, Int))] = rdd1.map {
      case (x, y, z) => (x, (y, z))
    }

    val a = 1

    val map = new HashMap[Int,String]

    val stringToInt: HashMap[String, Int] = new HashMap[String,Int]

    val intToInt = new HashMap[Int,Int]



    //val rdd11: RDD[(Int, (String, Int))] = rdd1.map(t => {(t._1,(t._2,t._3))})
    //val rdd22: RDD[(Int, (String, String))] = rdd2.map(t => {(t._1,(t._2,t._3))})

//    val value: RDD[(Int, (String, Int, String))] = rdd11.join(rdd22).map(x => {(x._1,(x._2._1._1,x._2._1._2,x._2._2._2))})
//    rdd22.collect().foreach(println)

  }
}
