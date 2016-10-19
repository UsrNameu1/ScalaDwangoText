class A {
  def a(): String = "a"
}

object A { // シングルトンといえる？
  def a(): String = "aa"
}

class Point(val x: Int, val y: Int)

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

Point(1, 2)

class Person(name: String, age: Int, private val weight: Int)

object Hoge {
  def printWeight(): Unit = {
    val taro = new Person("Taro", 20, 70)
//    println(taro.weight)
  }
}

object Person {
  def printWeight(): Unit = {
    val taro = new Person("Taro", 20, 70)
    println(taro.weight)
  }
}
