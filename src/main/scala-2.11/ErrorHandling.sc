val v1: Option[Int] = Some(3)
val v2: Option[Int] = Some(5)
val v3: Option[Int] = Some(7)

for {
  i1 <- v1
  i2 <- v2
  i3 <- v3
} yield i1 * i2 * i3

val v4 = Some(2)
val v5 = Some(11)

for {
  i1 <- v1
  i2 <- v2
  i3 <- v3
  i4 <- v4
  i5 <- v5
} yield i1 * i2 * i3 * i4 * i5
