// ScalaにおけるUnit
// http://www.ne.jp/asahi/hishidama/home/tech/scala/any.html#h_Unit

// 構文
//   - キーワード、式、文から構成されるプログラムの構造をきめるルール

// 式
//   - 評価すると値になる（Unitを含む）
//   - 後々使われる戻り値

1
val e = 1 + 2
val n = e
val u = ()
"hoge"

// 文
//   - 直接値として扱えない（直接でなければUnitとして扱える）
//   - 代入文とかクラス定義とか
//   - だいたい副作用をもつ

val i = 1
val unit = { val o = 1 }
val unit2 = {class A(){}}

var global = 1
global
global = 2 // この前後でglobalを用いた計算の結果が変わる
global

{ println("A"); println("B"); 1 + 2 }
{ println("A"); println("B"); val o = 1 }

def foo(): String = {
  "foo" + "foo"
}

def foo2: String = "foo" + "foo"

var age = 17

if (age > 18) {
  "over age 18"
} else {
  "under age 18"
}

if (age < 18) "under age 18" else "over age 18"

var ii = 1

while (ii <= 10) {
  println("ii = " + ii)
  ii = ii + 1
}

for (x <- 1 to 5; y <- 1 until 5) {
  println("x = " + x + " y = " + y)
}

for(e <- List("A", "B", "C", "D", "E")) println(e)

for(e <- List("A", "B", "C", "D", "E")) yield "Pre" + e

val taro = "Taro"

taro match {
  case "Taro" => "Male"
  case "Jiro" => "Male"
  case "Hanako" => "Female"
}

val lst = List("A", "B", "C", "D", "E")

lst match {
  case List("A", b, c, d, e) =>
    println("b = " + b)
    println("c = " + c)
    println("d = " + d)
    println("e = " + e)
  case _ =>
    println("nothing")
}

val lsts = List(List("A"), List("B", "C"))

lsts match {
  case List(a@List("A"), x) =>
    println(a)
    println(x)
  case _ => println("nothing")
}

import java.util.Locale
val obj: AnyRef = "String Literal"
obj match {
  case v: java.lang.Integer =>
    println("Integer!")
  case v: String =>
    println(v.toUpperCase(Locale.ENGLISH))
}

val obj2: Any = List("a")

obj2 match {
  case v: List[Int] => println("List[Int]")
  case v: List[String] => println("List[String]")
}
