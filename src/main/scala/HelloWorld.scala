import cats.effect.{IO, IOApp}

// This project does not run on sbt?!? -> check out why
object HelloWorld extends IOApp.Simple {
  val run = IO.println("Hello, World!")
}
