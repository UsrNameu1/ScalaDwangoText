

class Point(val x: Int, val y: Int) {
  def +(p: Point): Point = new Point(x + p.x, y + p.y)
  override def toString(): String = "(" + x + ", " + y + ")"
}

val p1 = new Point(1, 1)
val p2 = new Point(2, 2)
p1 + p2

class Adder {
  def add(x: Int)(y: Int): Int = x + y
}

val adder = new Adder()
adder.add(2)(3)
adder.add(2) _

class APrinter() {
  def print(): Unit = {
    println("A")
  }
}

class BPrinter() extends APrinter {
  override def print(): Unit = {
    println("B")
  }
}
