import java.util.Objects;

public class FractionImpl implements Fraction {
  private int numerator;
  private int denominator;

  public FractionImpl(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator must be != 0");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    normalizeAndReduce();
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setNumerator(int n) {
    this.numerator = n;
    normalizeAndReduce();
  }

  @Override
  public void setDenominator(int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be > 0");
    }
    this.denominator = d;
    normalizeAndReduce();
  }

  @Override
  public double toDouble() {
    return (double) numerator / (double) denominator;
  }

  @Override
  public String toString() {
    return String.format("%d / %d", numerator, denominator);
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new ArithmeticException("Reciprocal of 0 is undefined");
    }
    int newNum = denominator * Integer.signum(numerator);
    int newDen = Math.abs(numerator);
    return new FractionImpl(newNum, newDen);
  }

  @Override
  public Fraction add(Fraction other) {
    Objects.requireNonNull(other, "other");
    long a = this.numerator;
    long b = this.denominator;
    long c = other.getNumerator();
    long d = other.getDenominator();
    long newNum = a * d + b * c;
    long newDen = b * d;
    if (newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE || newDen > Integer.MAX_VALUE) {
      throw new ArithmeticException("Integer overflow when adding fractions");
    }
    return new FractionImpl((int) newNum, (int) newDen);
  }

  @Override
  public int compareTo(Fraction other) {
    Objects.requireNonNull(other, "other");
    long left = (long) this.numerator * (long) other.getDenominator();
    long right = (long) other.getNumerator() * (long) this.denominator;
    return Long.compare(left, right);
  }

  private void normalizeAndReduce() {
    if (numerator == 0) {
      denominator = 1;
      return;
    }
    if (denominator < 0) {
      denominator = -denominator;
      numerator = -numerator;
    }
    int g = gcd(Math.abs(numerator), denominator);
    numerator /= g;
    denominator /= g;
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Fraction)) return false;
    Fraction that = (Fraction) o;
    return numerator == that.getNumerator() && denominator == that.getDenominator();
  }

  @Override
  public int hashCode() {
    int result = Integer.hashCode(numerator);
    result = 31 * result + Integer.hashCode(denominator);
    return result;
  }
}
