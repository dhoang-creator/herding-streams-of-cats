import cats.effect.{IO, IOApp}

// This project does not run on sbt?!? -> check out why
object HelloWorld extends IOApp.Simple {
  val run = IO.println("Hello, World!")

  // the below two function behave and give output in the same way
  IO.println("Hello") flatMap { _ =>
    IO.println("World")
  }

  // Note that a for comprehension in Cats Effect isn't the same as an ordinary for comprehension with the flatMap and map
  for {
    _ <- IO.println("Hello")
    _ <- IO.println("World")
  } yield ()
}
