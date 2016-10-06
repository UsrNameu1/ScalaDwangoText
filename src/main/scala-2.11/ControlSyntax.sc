// ScalaにおけるUnit
// http://www.ne.jp/asahi/hishidama/home/tech/scala/any.html#h_Unit

// 構文
//   - キーワード、式、文から構成されるプログラムの構造をきめるルール

// 式
//   - 評価すると値になる（Unitでない）
//   - 後々使われる戻り値
//   - Unit以外の値になる

1
val e = 1 + 2
val n = e
"hoge"

// 文
//   - 評価するとUnitになる(値をもたない）
//   - 後々値として使われない
//   - 代入文などもUnitの値として扱えるから厳密には式とみなせるけど…
//   - 文はだいたい副作用をもつ、代入などの操作

val i = 1
val unit = { val o = 1 }

var global = 1
global = 2 // この前後でglobalを用いた計算の結果が変わる
global



