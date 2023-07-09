import cats.effect.IO

import java.util.concurrent.{Executors, TimeUnit}
import scala.concurrent.duration.DurationInt

object Cancellation {

  lazy val loop: IO[Unit] = IO.println("Hello, World") >> loop

  loop.timeout(5.seconds) // => IO[[Unit]

  /*
    Asynchronous Dimensions
   */
  IO(Thread.sleep(500)) // IO[Unit]

  val scheduler = Executors.newScheduledThreadPool(1)

  // We need to seriously deconstruct the below
  IO.async_[Unit] { cb =>
    scheduler.schedule(new Runnable {
      def run = cb(Right(()))
    }, 500, TimeUnit.MILLISECONDS)
    ()
  }

}
