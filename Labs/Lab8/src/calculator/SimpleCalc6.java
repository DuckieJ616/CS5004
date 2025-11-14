package calculator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator
 */
public class SimpleCalc6 {
  public static void main(String[] args) {
    try {
      new Controller6(new InputStreamReader(System.in), System.out)
          .go(new SimpleCalc6Model());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/**
 * Real model for SimpleCalc6
 */
class SimpleCalc6Model implements CalculatorModelInterface {
  @Override
  public int add(int a, int b) {
    return a + b;
  }
}

/**
 * A controller for the calculator.
 */
class Controller6 {
  final Readable in;
  final Appendable out;

  Controller6(Readable in, Appendable out) {
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
          num1 = scan.nextInt();
          num2 = scan.nextInt();

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

