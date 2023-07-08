import cats.effect.{IO, IOApp}
import scala.concurrent.duration.DurationInt

/*
  Note that this simply mimics the FizzBuzz output but is also a demonstration of how to run on four concurrent lightweight threads
 */


object FizzBuzz extends IOApp.Simple {
  val run = {
    // the contents below hardly look like the 'for comprehension' you recently studied
    for {
      ctr <- IO.ref(0)

      // this is itself a code block, for each of the below commands, we're waiting one second before enabling the rest
      wait = IO.sleep(1.second)
      poll = wait *> ctr.get

      // Note that 'ifM' and 'foreverM' are similar to the effects you see in ZIO
      _ <- poll.flatMap(IO.println(_)).foreverM.start
      _ <- poll.map(_ % 3 == 0).ifM(IO.println("fizz"), IO.unit).foreverM.start
      _ <- poll.map(_ % 5 == 0).ifM(IO.println("buzz"), IO.unit).foreverM.start

      // Note that without the below command, the entire application doesnt run => why is this?
      _ <- (wait *> ctr.update(_ + 1)).foreverM.void
    } yield ()
  }


}
