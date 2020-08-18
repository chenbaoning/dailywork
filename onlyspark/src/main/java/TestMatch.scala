import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 08 - 03 19:11
  */
object TestMatch {
  def main(args: Array[String]): Unit = {
    //TODO 从内存中创建RDD
    val conf = new SparkConf().setMaster("local[*]").setAppName("RddCreate")
    val sc = new SparkContext(conf)

    /*val tuples = List((List(1, 2), 3, List(4, 5)))

    val rdd = sc.makeRDD(tuples)

    //flatMap:扁平化处理 ，返回的参数类型是可迭代的数据类型，比如集合
    //数字 3 怎么处理？
    //让数字3 变成可迭代的集合就行
    rdd.flatMap(
      datas=>{
        datas match {
          case d :Int=> List(d)
          case l :List[_] => List(l)
        }
      }
    ).collect().foreach(println)*/
    val tuples: Any = List((List(1, 2), 3, List(4, 5)))

    /*tuples.flatMap{
      datas=>{
        datas match {
          case d :Int=> List(d)
          case l :List[_] => List(l)
        }
      }
    }*/
    /*val tuple: (List[Int], Int, List[Int]) = (List(1, 2), 3, List(4, 5))
    tuple match {
      case d :Int=> List(d)
      case l :List[_] => List(l)
    }*/

    tuples match {
      case d :Int=> List(d)
      case l :List[_] => List(l)
    }




    sc.stop()

  }

}
