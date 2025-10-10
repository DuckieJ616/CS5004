public interface Fraction extends Comparable<Fraction> {
  int getNumerator();
  int getDenominator();
  void setNumerator(int n);
  void setDenominator(int d);
  double toDouble();
  Fraction reciprocal();
  Fraction add(Fraction other);
  @Override
  int compareTo(Fraction other);
}
