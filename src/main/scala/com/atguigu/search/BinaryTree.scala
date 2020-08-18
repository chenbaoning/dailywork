package com.atguigu.search

object BinaryTree {
  def main(args: Array[String]): Unit = {
    val node1 = new TreeNode(1)
    val node2 = new TreeNode(2)
    val node3 = new TreeNode(3)
    val node4 = new TreeNode(4)
    val node5 = new TreeNode(5)
    val node6 = new TreeNode(6)
    val node7 = new TreeNode(7)
    val node8 = new TreeNode(8)

    val tree = new BinaryTree

    tree.root = node1

    node1.left = node2
    node1.right = node3

    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7

    node5.right = node8

    tree.postOrder()
    tree.postOrderSearch(4)
    tree.delNode(3)
    tree.postOrder()
  }

}

class TreeNode(treeNo:Int){
  val no = treeNo
  var left:TreeNode = null
  var right:TreeNode = null

  //后序遍历
  def postOrder():Unit={
    //向左递归输出左子树
    if(this.left != null){
      this.left.postOrder
    }
    //向右递归输出右子树
    if (this.right != null) {
      this.right.postOrder
    }

    //输出当前节点值
    printf("节点信息 no=%d \n",no)
  }

  //中序遍历
  def infixOrder():Unit={
    //向左递归输出左子树
    if(this.left != null){
      this.left.infixOrder()
    }

    //输出当前节点值
    printf("节点信息 no=%d \n",no)

    //向右递归输出右子树
    if (this.right != null) {
      this.right.infixOrder()
    }
  }

  //前序遍历
  def preOrder():Unit={
    //输出当前节点值
    printf("节点信息 no=%d \n",no)

    //向左递归输出左子树
    if(this.left != null){
      this.left.postOrder()
    }

    //向右递归输出右子树
    if (this.right != null) {
      this.right.preOrder()
    }
  }

  //后序遍历查找
  def postOrderSearch(no:Int): TreeNode = {
    //向左递归输出左子树
    var resNode:TreeNode = null
    if (this.left != null) {
      resNode = this.left.postOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    if (this.right != null) {
      resNode = this.right.postOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    println("ttt~~")
    if (this.no == no) {
      return this
    }
    resNode
  }

  //中序遍历查找
  def infixOrderSearch(no:Int): TreeNode = {


    var resNode : TreeNode = null
    //先向左递归查找
    if (this.left != null) {
      resNode = this.left.infixOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    println("yyy~~")
    if (no == this.no) {
      return this
    }
    //向右递归查找
    if (this.right != null) {
      resNode = this.right.infixOrderSearch(no)
    }
    return resNode

  }

  //前序查找
  def preOrderSearch(no:Int): TreeNode = {
    if (no == this.no) {
      return this
    }
    //向左递归查找
    var resNode : TreeNode = null
    if (this.left != null) {
      resNode = this.left.preOrderSearch(no)
    }
    if (resNode != null){
      return  resNode
    }
    //向右边递归查找
    if (this.right != null) {
      resNode = this.right.preOrderSearch(no)
    }

    return resNode
  }

  //删除节点
  //删除节点规则
  //1如果删除的节点是叶子节点，则删除该节点
  //2如果删除的节点是非叶子节点，则删除该子树

  def delNode(no:Int): Unit = {
    //首先比较当前节点的左子节点是否为要删除的节点
    if (this.left != null && this.left.no == no) {
      this.left = null
      return
    }
    //比较当前节点的右子节点是否为要删除的节点
    if (this.right != null && this.right.no == no) {
      this.right = null
      return
    }
    //向左递归删除
    if (this.left != null) {
      this.left.delNode(no)
    }
    //向右递归删除
    if (this.right != null) {
      this.right.delNode(no)
    }
  }

}

class BinaryTree{
  var root:TreeNode = null

  //后序遍历
  def postOrder(): Unit = {
    if (root != null) {
      root.postOrder()
    } else {
      println("当前二叉树为空，不能遍历")
    }
  }
    //中序遍历
    def infixOrder(): Unit = {
      if (root != null){
        root.infixOrder()
      }else {
        println("当前二叉树为空，不能遍历")
      }
    }
    //前序遍历
    def preOrder(): Unit = {
      if (root != null){
        root.preOrder()
      }else {
        println("当前二叉树为空，不能遍历")
      }
    }

    //后序遍历查找
    def postOrderSearch(no:Int): TreeNode = {
      if (root != null) {
        root.postOrderSearch(no)
      }else{
        null
      }
    }

    //中序遍历查找
    def infixOrderSeacher(no:Int): TreeNode = {
      if (root != null) {
        return root.infixOrderSearch(no)
      }else {
        return null
      }
    }

    //前序查找
    def preOrderSearch(no:Int): TreeNode = {

      if (root != null) {
        return root.preOrderSearch(no)
      }else{
        //println("当前二叉树为空，不能查找")
        return null
      }
    }

    def delNode(no:Int): Unit = {
      if (root != null) {
        //先处理一下root是不是要删除的
        if (root.no == no){
          root = null
        }else {
          root.delNode(no)
        }
      }
    }


}