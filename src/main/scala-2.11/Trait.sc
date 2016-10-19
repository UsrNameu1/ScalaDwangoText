trait TraitA
trait TraitB
class ClassA
class ClassB
class ClassC extends ClassA with TraitA with TraitB

class ClassAA extends TraitA

object ObjectA {
//  val a = new TraitA
  val a = new ClassAA
}

//trait TraitAA(name: String)

trait TraitAAA {
  val name: String
  def printName(): Unit = println(name)
}

class ClassAAA(val name: String) extends TraitAAA

object ObjectAA {
  val a = new ClassAAA("dwango")
  val a2 = new TraitAAA { val name = "kadokawa" }
}

trait TraitC {
  def greet(): Unit
}

trait TraitD extends TraitC {
  def greet(): Unit = println("Good morning")
}

trait TraitE extends TraitC {
  def greet(): Unit = println("Good evening")
}

class ClassD extends TraitD with TraitE {
  override def greet(): Unit = println("aa")
}

class ClassE extends TraitD with TraitE {
  override def greet(): Unit = super[TraitD].greet()
}

trait TraitCC {
  def greet(): Unit = println("Hello")
}

trait TraitDD extends TraitCC {
  override def greet(): Unit = {
    super.greet()
    println("Good morning")
  }
}

trait TraitEE extends TraitCC {
  override def greet(): Unit = {
    super.greet()
    println("Good evening")
  }
}

class ClassDD extends TraitDD with TraitEE
(new ClassDD).greet()

class ClassEE extends TraitEE with TraitDD
(new ClassEE).greet()


trait Greeter {
  def greet(): Unit
}

trait Robot {
  self: Greeter =>

  def start(): Unit = greet()
  override final def toString = "Robot"
}

trait HelloGreeter extends Greeter {
  def greet(): Unit = println("Hello")
}

val r: Robot = new Robot with HelloGreeter
r.start()

trait Robot2 extends Greeter {
  def start(): Unit = greet()
  override final def toString = "Robot2"
}

//r.greet()

val r2: Robot2 = new Robot2 with HelloGreeter
r2.greet()

trait Robot3 {
  self: Greeter2 =>

  def name: String

  def start(): Unit = greet()
}

trait Greeter2 {
  self: Robot3 =>

  def greet(): Unit = println(s"My name is $name")
}

trait FooA {
  val foo: String
}
trait FooB extends FooA {
  lazy val bar = foo + "World"
}
class FooC extends FooB {
  val foo = "Hello"
  def printBar(): Unit = println(bar)
}

(new FooC).printBar()

class FooD extends {
  val foo = "Hello"
} with FooB {
  def printBar(): Unit = println(bar)
}
(new FooD).printBar()
