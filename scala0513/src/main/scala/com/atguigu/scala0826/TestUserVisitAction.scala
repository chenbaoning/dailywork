package com.atguigu.scala0826

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object TestUserVisitAction {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("UserVisitAction").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("UserVisitAction")
      .getOrCreate()


    //3 需求一：top10热门品类
    //3.1 获取原始数据
    val dataRDD: RDD[String] = sc.textFile("C:\\Users\\35951\\IdeaProjects\\dailywork\\scala0513\\src\\main\\resources\\user_visit_action.txt")

    //3.2 将原始数据进行转换（分解）
    val actionRDD: RDD[UserVisitAction] = dataRDD.map(
      data => {
        // 获取一行数据
        val datas: Array[String] = data.split(",")

        // 将解析的数据封装到 UserVisitAction
        UserVisitAction(
          datas(0),
          datas(1).toLong,
          datas(2),
          datas(3).toLong,
          datas(4),
          datas(5),
          datas(6).toLong,
          datas(7).toLong,
          datas(8),
          datas(9),
          datas(10),
          datas(11),
          datas(12).toLong
        )
      }
    )
    import spark.implicits._
    val actionFrame: DataFrame = actionRDD.toDF()
    println(actionFrame.count())

    actionFrame.createOrReplaceTempView("user_action")

    spark.sql(
      """
        |select
        |user_id,
        |sum(if((click_category_id=0),0,1)) click_count
        |from user_action
        |group by user_id
      """.stripMargin).show()
    //println(actionRDD.count())
    sc.stop()


  }

}

case class UserVisitAction(date: String, //用户点击行为的日期
                           user_id: Long, //用户的ID
                           session_id: String, //Session的ID
                           page_id: Long, //某个页面的ID
                           action_time: String, //动作的时间点
                           search_keyword: String, //用户搜索的关键词
                           click_category_id: Long, //某一个商品品类的ID
                           click_product_id: Long, //某一个商品的ID
                           order_category_ids: String, //一次订单中所有品类的ID集合
                           order_product_ids: String, //一次订单中所有商品的ID集合
                           pay_category_ids: String, //一次支付中所有品类的ID集合
                           pay_product_ids: String, //一次支付中所有商品的ID集合
                           city_id: Long)

//城市 id
// 输出结果表
case class CategoryCountInfo(categoryId: String, //品类id
                             clickCount: Long, //点击次数
                             orderCount: Long, //订单次数
                             payCount: Long)

//支付次数

