
class Cell[A](var value: A) {

  def put(newValue: A): Unit = {
    value = newValue
  }

  def get(): A = value
}

val cell = new Cell[Int](1)

cell.put(2)
cell.get()
//cell.put("something")

class Pair[+A, +B](val a: A, val b: B) {
  override def toString: String = "(" + a + "," + b + ")"
}

def divide(m: Int, n: Int): Pair[Int, Int] = new Pair[Int, Int](m / n, m % n)

divide(7, 3)

val m = 7
val n = 3
(m / n, m % n)

//val arr: Array[Any] = new Array[String](1)
val pair: Pair[AnyRef, AnyRef] = new Pair[String, String]("foo", "bar")

trait Stack[+A] {
  def push[E >: A](e: E): Stack[E]
  def top: A
  def pop: Stack[A]
  def isEmpty: Boolean
}

class NonEmptyStack[+A](private val first: A, private val rest: Stack[A]) extends Stack[A] {
  def push[E >: A](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def top: A = first
  def pop: Stack[A] = rest
  def isEmpty: Boolean = false
}

case object EmptyStack extends Stack[Nothing] {
  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def top: Nothing = throw new IllegalArgumentException("empty stack")
  def pop: Nothing = throw new IllegalArgumentException("empty stack")
  def isEmpty: Boolean = true
}

object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}

val intStack: Stack[Int] = Stack()
val stringStack: Stack[String] = Stack()

// 反変：関数の引数の例→入り口は広いほうが問題が少ない（Producer Extends Consumer Super）
//val x1: AnyRef => AnyRef = (x: String) => (x: AnyRef)
val x2: String => AnyRef = (x: AnyRef) => x

// https://www.clear.rice.edu/comp310/JavaResources/generics/co_contra_host_visitor.html
// http://tkawachi.github.io/blog/2013/10/09/covariant-contravariant/

abstract class Show {
  def show: String
}

class ShowablePair[A <: Show, B <: Show](val a: A, val b: B) extends Show {
  override def show: String = "(" + a.show + "," + b.show + ")"
}

abstract class Stack2[+A] {
//  def push(element: A): Stack[A]
  def top: A
  def pop: Stack[A]
  def isEmpty: Boolean
}
