package com.pewpew.bst

sealed abstract class BinaryTree

case class Node(element: Int, left: BinaryTree, right: BinaryTree) extends BinaryTree
case class EmptyTree() extends BinaryTree