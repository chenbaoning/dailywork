package TestPackage{



  package ziPackage{

    package sunPackage{


      object testSun{
        def main(args: Array[String]): Unit = {
          name
        }
      }
    }
  }
  object ClassA {

    def main(args: Array[String]): Unit = {
      println(name)
      ClassD.fun()
      ClassB()
      //ClassB.testFun()

    }
  }


  object ClassD{
    def fun()={
      println("this is from ClassB")
    }
  }
}



package object TestPackage {
  val name = "baoduixiang"

  def ClassB()={
    println("this is from package object")
  }
}