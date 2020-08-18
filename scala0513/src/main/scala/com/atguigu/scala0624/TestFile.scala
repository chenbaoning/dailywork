package com.atguigu.scala0624

import java.io.File

object TestFile {
  def main(args: Array[String]): Unit = {

    def subFiles(dir: File): Iterator[File] = {
//      val files = dir.listFiles.filter(!_.isDirectory)
//      val str: String = files.mkString(".")
      val directories = dir.listFiles.filter(_.isDirectory)
//      val iterator: Iterator[File] = files.toIterator
      val toIterator: Iterator[File] = directories.toIterator
//      iterator++toIterator.flatMap(subFiles _)
      toIterator.flatMap(subFiles _)
    }

    val filelist: Iterator[File] = subFiles(new File("file:///F"))

//    val directoryList: Array[File] = new File("F:\\").listFiles().filter(_.isDirectory)
//    val iterator1: Iterator[File] = directoryList.toIterator
//
//    val iterator2: Iterator[File] = iterator1.flatMap(_.listFiles().filter(_.isDirectory))

    while (filelist.hasNext)
      println(filelist.next)

  }

}
