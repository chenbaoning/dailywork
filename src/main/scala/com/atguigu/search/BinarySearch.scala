package com.atguigu.search

object BinarySearch {
  def main(args: Array[String]): Unit = {


  }
  def binarySearch(arr:Array[Int],left:Int,right:Int,findVal:Int): Int={
    if(left>right){//递归退出条件，找不到，返回-1
      -1
    }

    val midIndex = (left+right)/2

    if (findVal < arr(midIndex)){//向左递归查找
      binarySearch(arr,left,midIndex,findVal)
    }else if(findVal > arr(midIndex)){//向右递归查找
      binarySearch(arr,midIndex,right,findVal)
    }else{//查找到，返回下标
      midIndex
    }

  }
}
