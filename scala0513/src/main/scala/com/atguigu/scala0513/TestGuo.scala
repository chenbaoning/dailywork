package test1{

  import test1.test2.User2

  package test2 {
    class User2 {
      private[test1] val name : String = "zhangsan"
    }

    object Test{
      def main(args: Array[String]): Unit = {
        val user2 = new User2
        //user2.name
      }
    }

  }

  object Test2{
    def main(args: Array[String]): Unit = {
      val user3 = new User2
      //user3.name
    }
  }

  package test3 {


    import test1.test2.User2


    class User3  {
      def main(args: Array[String]): Unit = {
        val user2 = new User2()

        //println(user2.name)
      }
    }

  }
}

object ScalaTest_Object1 {

}