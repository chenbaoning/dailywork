package p1{
  class Father{
    protected var name = "zz"
  }

  class Son extends Father{

  }

  object Son{
    def main(args: Array[String]): Unit = {
      val son = new Son
      println(son.name)
    }
  }
}