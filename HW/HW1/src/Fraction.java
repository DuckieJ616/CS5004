/**
 * Represents a fraction (rational number) with an integer numerator and a strictly positive denominator.
 * <p>
 * Implementations must guarantee that:
 * <ul>
 *   <li>The denominator is always greater than zero.</li>
 *   <li>The sign of the fraction is carried only by the numerator.</li>
 *   <li>The fraction can be compared, added, and converted to double.</li>
 * </ul>
 * </p>
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of this fraction.
   *
   * @return the numerator (may be negative, zero, or positive)
   */
  int getNumerator();

  /**
   * Returns the denominator of this fraction.
   *
   * @return the denominator (always positive)
   */
  int getDenominator();

  /**
   * Sets the numerator of this fraction.
   *
   * @param n new numerator value
   */
  void setNumerator(int n);

  /**
   * Sets the denominator of this fraction. Must remain positive.
   *
   * @param d new denominator
   * @throws IllegalArgumentException if {@code d <= 0}
   */
  void setDenominator(int d);

  /**
   * Converts this fraction to its decimal (double) representation.
   *
   * @return the numeric value of numerator / denominator
   */
  double toDouble();

  /**
   * Returns the reciprocal of this fraction.
   * <p>
   * If this fraction is {@code a/b}, the reciprocal is {@code b/a}.
   * </p>
   *
   * @return a new {@link Fraction} equal to the reciprocal
   * @throws ArithmeticException if the numerator is 0
   */
  Fraction reciprocal();

  /**
   * Returns the sum of this fraction and another fraction.
   *
   * @param other another fraction
   * @return a new {@link Fraction} representing the sum
   * @throws NullPointerException if {@code other} is null
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction with another fraction.
   *
   * @param other another fraction
   * @return negative if this < other, zero if equal, positive if this > other
   * @throws NullPointerException if {@code other} is null
   */
  @Override
  int compareTo(Fraction other);
}
