import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

/**
  * author: 35951
  * date: 2020 - 08 - 09 18:01
  */
object Spark03_acc_custom {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster( "local[*]" ).setAppName( "RDDCreate" )
    val sc = new SparkContext( sparkConf )

    val rdd: RDD[Int] = sc.makeRDD( List( 1, 2, 3, 4, 5, 6 ) )

    /*
    ①longAccumulator 累加器中 new了一个累加器对象,并注册
    val acc = new LongAccumulator
    register(acc, name)
    ②继承了AccumulatorV2
     */

    val myacc = new myAccumulator
    //在spark中注册
    sc.register( myacc, "sum" )

    //使用累加器
    rdd.foreach(
      num => myacc.add(num)
    )

    //获取累加器的值
    println( myacc.value )

    sc.stop()
  }

  /*
    自定义累加器
    1. 继承AccumulatorV2, 约束类型
        IN : 向累加器增加的数据的类型
        OUT : 累加器的计算结果的类型
    2. 重写方法（6）
     */
  class myAccumulator extends AccumulatorV2[Int, Int] {
    //定义累加器临时变量
    private var temp = 0

    // zero : 初始化
    // 判断当前累加器是否为初始化状态
    override def isZero: Boolean = {
      println("iiiiiiiiii")
      temp == 0
    }

    override def copy(): AccumulatorV2[Int, Int] = {
      println("ccccccccc")
      new myAccumulator
    }

    // 重置累加器
    override def reset(): Unit = {
      println("rrrrrrrr")
      temp = 0
    }

    // 向累加器中增加数据
    override def add(v: Int): Unit = {
      println("aaaaaaaa")
      temp += v
    }

    // 合并累加器的值
    // 当前累加器和其他累加器进行两两合并，运行的结果再和其他的累加器合并
    override def merge(other: AccumulatorV2[Int, Int]): Unit = {
      println("mmmmmmmmmm")
      temp += other.value
    }

    // 获取累加器的值（计算结果）
    override def value: Int = {
      temp
    }
  }

}
