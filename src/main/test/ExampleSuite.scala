import cats.effect.IO
import munit.CatsEffectSuite

// Below is an MUnit Expectation Assertion -> preferred testing framework when forcing IOs through unsafe runs
class ExampleSuite extends CatsEffectSuite {
  test("make sure IO computes the right result") {
    // Note that we're not referring to an Independent code block but instead including the IO code below
    IO.pure(1).map(_ + 2) flatMap { result =>
      IO(assertEquals(result, 3))
    }
  }
}
