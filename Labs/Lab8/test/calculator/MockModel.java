package calculator;

public class MockModel implements CalculatorModelInterface {

  private final StringBuilder log = new StringBuilder();

  @Override
  public int add(int a, int b) {
    log.append("Passed: ").append(a)
        .append(" and ").append(b)
        .append(System.lineSeparator());
    return -12345;
  }

  public String getLog() {
    return log.toString();
  }
}
