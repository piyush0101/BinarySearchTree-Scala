import com.pewpew.bst._

class BinarySearchTree {

  def insert(element: Int, tree: BinaryTree): BinaryTree = {
    tree match {
      case EmptyTree() => Node(element, EmptyTree(), EmptyTree())
      case Node(elem, left, right) if element < elem => Node(elem, insert(element, left), right)
      case Node(elem, left, right) if element > elem => Node(elem, left, insert(element, right))
      case Node(elem, left, right) if element == elem => Node(elem, left, right)
    }
  }

  def fill(elements: List[Int]): BinaryTree = {
    elements.foldLeft(EmptyTree(): BinaryTree)((tree: BinaryTree, elem: Int) => insert(elem, tree))
  }

  def preOrder(tree: BinaryTree, traversal: List[Int]): List[Int] = {
    tree match {
      case EmptyTree() => List()
      case Node(elem, left, right) => traversal ::: List(elem) ::: preOrder(left, traversal) ::: preOrder(right, traversal)
    }
  }

  def postOrder(tree: BinaryTree, traversal: List[Int]): List[Int] = {
    tree match {
      case EmptyTree() => List()
      case Node(elem, left, right) => traversal ::: postOrder(left, traversal) ::: postOrder(right, traversal) ::: List(elem)
    }
  }

  def inOrder(tree: BinaryTree, traversal: List[Int]): List[Int] = {
    tree match {
      case EmptyTree() => List()
      case Node(elem, left, right) => traversal ::: inOrder(left, traversal) ::: List(elem) ::: inOrder(right, traversal)
    }
  }

  def find(tree: BinaryTree, x: Int): Option[Int] = {
    tree match {
      case EmptyTree() => None
      case Node(elem, left, right) if (x == elem) => Some(x)
      case Node(elem, left, right) if (x < elem) => find(left, elem)
      case Node(elem, left, right) if (x > elem) => find(right, elem)
    }
  }

  def mirror(tree: BinaryTree) : BinaryTree = {
    tree match {
      case EmptyTree() => EmptyTree()
      case Node(elem, left, right) => Node(elem, mirror(right), mirror(left))
    }
  }
}