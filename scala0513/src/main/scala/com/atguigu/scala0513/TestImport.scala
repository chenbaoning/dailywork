package com.xiaoqi.chapter.chapter03 {


  package test1 {
    package test2 {

      class P {
        private[test2] val name: String = "zhangsan"
      }

    }

    package test3 {

      import com.xiaoqi.chapter.chapter03.test1.test2.P

      class Person1 {
        def main(args: Array[String]): Unit = {
          val p = new P()
          //println(p.name)
        }
      }

    }

  }

  object TestPackage01 {
    def main(args: Array[String]): Unit = {
      //package:java中的包的概念比较单一，所以scala在java的语法基础上进行了扩展
      //1.语法声明方式：package可以多次声明，包名叠加
      // scala中源码的文件路径这个类的包名没关系
      //2.包也可采用对象的方式嵌套：父子包,可以在包名的后面增加大括号，表示作用域
      //其中可以声明类，包,子包可以不用import就可以访问父包中的内容
      //3.包中无法声明属性和方法，scala提供了包对象(package object test{})的概念，可以声明属性和方法
      //4.访问权限：java（private,(default),protected(同类，同包，父子类),public）
      //           scala(private,private[包名]， protected（父子类才能访问）,(public))
    }

  }

}