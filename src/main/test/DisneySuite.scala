import cats.effect.IO
import weaver.SimpleIOSuite

// Weaver used more for tests for the I/O layers (i.e. http, database calls) which occur concurrently
class DisneySuite extends SimpleIOSuite {
  test("make sure IO computes the right result") {
    IO.pure(1).map(_ + 2) map { result =>
      expect.eql(result,3)
    }
  }

}
