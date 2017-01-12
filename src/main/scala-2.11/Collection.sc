
List(List(1, 2, 3), List(4, 5)).flatMap{e => e.map{g => g + 1}}

List(1, 2, 3).flatMap{e => List(e * 2, e * 3)}

List(1, 2, 3).flatMap{e => List(4, 5).map{g => e * g}}

for(x <- List(1, 2, 3); y <- List(4, 5)) yield x * y

List(1, 2).flatMap{e => List(3, 5).flatMap{g => List(7, 11).map(h => e * g * h)}}
for {
  p1 <- List(1, 2)
  p2 <- List(3, 5)
  p3 <- List(7, 11)
} yield p1 * p2 * p3


// http://docs.scala-lang.org/ja/overviews/collections/performance-characteristics
// Listのデータ構造： :: か Nil を再構成するのに末尾追加だと時間がかかる
List(1, 2, 3, 4)
1 :: List(2, 3, 4)
List(1, 2, 3) :+ 4

Vector(1, 2, 3, 4)
0 +: Vector(1, 2, 3, 4)
Vector(1, 2, 3, 4) :+ 5
Vector(1, 2, 3, 4).updated(2, 5)

val im = Map("A" -> 1, "B" -> 2, "C" -> 3)
im.updated("B", 4)
im

import scala.collection.mutable
val mm = mutable.Map("A" -> 1, "B" -> 2, "C" -> 3)
mm.update("B", 5)
mm

Set(1, 1, 2, 3, 4, 5, 5)

val is = Set(1, 2, 3, 4, 5)
is - 5
is

import scala.collection.mutable

val ms = mutable.Set(1, 2, 3, 4, 5)
ms -= 5
ms
