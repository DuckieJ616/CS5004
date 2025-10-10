import java.util.Objects;

/**
 * Concrete implementation of {@link Fraction}.
 * <p>
 * Fractions are always normalized so that denominators are positive and
 * values are stored in lowest terms using the Euclidean GCD algorithm.
 * </p>
 */
public class FractionImpl implements Fraction {
  private int numerator;
  private int denominator;

  /**
   * Constructs a new FractionImpl.
   *
   * @param numerator   numerator (may be negative, zero, or positive)
   * @param denominator denominator (must not be zero)
   * @throws IllegalArgumentException if denominator == 0
   */
  public FractionImpl(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator must not be zero");
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
      throw new IllegalArgumentException("Denominator must be positive");
    }
    this.denominator = d;
    normalizeAndReduce();
  }

  @Override
  public double toDouble() {
    return (double) numerator / (double) denominator;
  }

  /**
   * Returns the string representation of this fraction in simplest form.
   * <p>Format: "numerator / denominator".</p>
   *
   * @return simplified string representation
   */
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
    long left = (long) this.numerator * other.getDenominator();
    long right = (long) other.getNumerator() * this.denominator;
    return Long.compare(left, right);
  }

  /**
   * Normalizes the fraction:
   * <ul>
   *   <li>Denominator becomes positive.</li>
   *   <li>Sign is carried by numerator only.</li>
   *   <li>Fraction reduced to lowest terms using gcd.</li>
   * </ul>
   */
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

  /**
   * Computes gcd using Euclid's recursive algorithm.
   */
  private static int gcd(int a, int b) {
    if (b == 0) return a;
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
