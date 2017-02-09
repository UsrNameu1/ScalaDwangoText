import scala.io.StdIn

object Main extends App {
  val a = StdIn.readLine.toInt
  val List(b, c) = StdIn.readLine.split(" ").toList.map(_.toInt)
  val s = StdIn.readLine()
  println(List(a + b + c, s).mkString(" "))
}
