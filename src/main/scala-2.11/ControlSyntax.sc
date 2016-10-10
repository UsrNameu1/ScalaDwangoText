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
"hoge"

// 文
//   - 直接値として扱えない（直接でなければUnitとして扱える）
//   - 代入文とかクラス定義とか
//   - だいたい副作用をもつ

val i = 1
val unit = { val o = 1 }
val unit2 = {class A(){}}

var global = 1
global = 2 // この前後でglobalを用いた計算の結果が変わる
global



