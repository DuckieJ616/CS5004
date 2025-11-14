package calculator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator
 */
public class SimpleCalc7 {
  public static void main(String[] args) {
    try {
      new Controller7(new InputStreamReader(System.in), System.out)
          .go(new SimpleCalc7Model()); // ← 使用真正 model
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/**
 * A simple real model for SimpleCalc7 (implements interface)
 */
class SimpleCalc7Model implements CalculatorModelInterface {
  @Override
  public int add(int a, int b) {
    return a + b;
  }
}

/**
 * A controller for the calculator. This controller works with a Readable and
 * Appendable object. It has been designed to accept a sequence of multiple
 * inputs from the Readable object.
 */

class Controller7 {
  final Readable in;
  final Appendable out;

  Controller7(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }

  public void go(CalculatorModelInterface model) throws IOException {
    Objects.requireNonNull(model);

    int num1, num2;
    Scanner scan = new Scanner(this.in);

    while (true) {
      switch (scan.next()) {
        case "+":

          num1 = scan.nextInt() + 1;
          num2 = scan.nextInt() - 1;

          this.out.append(String.format("%d\n",
              model.add(num1, num2)));
          break;

        case "q":
          return;

        default:
          throw new IllegalStateException(
              "Unexpected value: " + scan.next());
      }
    }
  }
}
